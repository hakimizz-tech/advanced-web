package com.example.servlets;

import com.example.model.Student;
import com.example.model.Address;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/el-demo")
public class ElDemoServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // 1. Create a simple data object (Model)
        Address address = new Address("New York", "10001");
        Student student = new Student(1, "John Doe", address);

        // 2. Set the data as an attribute in the request scope
        request.setAttribute("student", student);

        // 3. Set an attribute in the session scope
        HttpSession session = request.getSession();
        session.setAttribute("userRole", "Administrator");

        // 4. Forward the request to the JSP (View)
        request.getRequestDispatcher("el-demo.jsp").forward(request, response);
    }
}
