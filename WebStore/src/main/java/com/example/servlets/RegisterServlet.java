package com.example.servlets;

import com.example.model.User;
import com.example.model.UserDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = new User();
        user.setUsername(request.getParameter("username"));
        user.setPassword(request.getParameter("password")); // In a real app, hash this!
        user.setName(request.getParameter("name"));
        user.setEmail(request.getParameter("email"));

        UserDAO userDAO = new UserDAO();
        userDAO.registerUser(user);

        response.sendRedirect("login.jsp");
    }
}
