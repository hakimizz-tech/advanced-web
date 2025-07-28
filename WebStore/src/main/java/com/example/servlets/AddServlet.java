package com.example.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/add")
public class AddServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String num1Str = request.getParameter("num1");
        String num2Str = request.getParameter("num2");

        try {
            int num1 = Integer.parseInt(num1Str);
            int num2 = Integer.parseInt(num2Str);
            int sum = num1 + num2;

            // response.getWriter().append("The sum is: ").append(String.valueOf(sum));
            request.setAttribute("sum", sum);

            RequestDispatcher rd = request.getRequestDispatcher("square");
            rd.forward(request, response);

        } catch (NumberFormatException e) {
            response.getWriter().append("Invalid input. Please enter two numbers.");
        }
    }
}