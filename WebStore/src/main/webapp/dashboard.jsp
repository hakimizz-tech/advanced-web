<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.example.model.User" %>
<% User user = (User) session.getAttribute("user");
   if (user == null) {
       response.sendRedirect("login.jsp");
       return;
   } %>
<html>
<head>
    <title>Dashboard</title>
    <style>
        body { font-family: sans-serif; margin: 2em; }
        h1 { color: #333; }
        p { font-size: 1.2em; }
        a { color: #007bff; text-decoration: none; }
        a:hover { text-decoration: underline; }
    </style>
</head>
<body>
    <h1>Welcome, ${user.getName()}!</h1>
    <p>Your username is: <%= user.getUsername() %></p>
    <p>Your email is: <%= user.getEmail() %></p>
    <a href="logout">Logout</a>
    <p><a href="resume.jsp">Upload Resume</a></p>
</body>
</html>
