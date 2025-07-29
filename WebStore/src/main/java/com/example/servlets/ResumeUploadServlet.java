package com.example.servlets;

import com.example.model.Resume;
import com.example.model.ResumeDAO;
import com.example.model.User;
import java.io.IOException;
import java.io.InputStream;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

@WebServlet("/upload-resume")
@MultipartConfig
public class ResumeUploadServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("user") == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        User user = (User) session.getAttribute("user");
        Part filePart = request.getPart("resume");

        try (InputStream fileContent = filePart.getInputStream()) {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fileContent);
            doc.getDocumentElement().normalize();

            StringBuilder resumeText = new StringBuilder();
            NodeList nList = doc.getElementsByTagName("resume");

            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    resumeText.append("Name: ").append(eElement.getElementsByTagName("name").item(0).getTextContent()).append("\n");
                    resumeText.append("Email: ".concat(eElement.getElementsByTagName("email").item(0).getTextContent())).append("\n");
                    resumeText.append("Phone: ").append(eElement.getElementsByTagName("phone").item(0).getTextContent()).append("\n");
                }
            }

            Resume resume = new Resume();
            resume.setUserId(user.getId());
            resume.setResumeText(resumeText.toString());

            ResumeDAO resumeDAO = new ResumeDAO();
            resumeDAO.saveResume(resume);

            response.sendRedirect("dashboard.jsp?upload=success");

        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("resume.jsp?error=1");
        }
    }
}
