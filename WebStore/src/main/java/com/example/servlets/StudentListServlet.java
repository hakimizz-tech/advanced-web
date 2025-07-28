package com.example.servlets;

import com.example.model.Student; // Assuming a simple Student POJO
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/student-list")
public class StudentListServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // 1. Get data from a DAO (or create a dummy list for demo)
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "Alice", "alice@example.com"));
        students.add(new Student(2, "Bob", "bob@example.com"));
        students.add(new Student(3, "Charlie", "charlie@example.com"));

        // 2. Set the data as a request attribute
        request.setAttribute("studentList", students);

        // 3. Forward to the JSP for presentation
        request.getRequestDispatcher("student-list.jsp").forward(request, response);
    }
}
