<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP Tags Demo</title>
</head>
<body>

    <h1>JSP Tags: Scriptlets, Expressions, and Declarations</h1>

    <%-- Declaration Tag: Declares a variable and a method --%>
    <%!
        private int counter = 0;

        public String getGreeting(String name) {
            return "Hello, " + name + "!";
        }
    %>

    <%-- Scriptlet Tag: Increments the counter and defines a local variable --%>
    <%
        counter++;
        String userName = "Guest";
    %>

    <p>
        This page has been visited
        <%-- Expression Tag: Prints the value of the counter --%>
        <strong><%= counter %></strong>
        time(s).
    </p>

    <p>
        <%-- Expression Tag: Calls the declared method --%>
        <strong><%= getGreeting(userName) %></strong>
    </p>
</body>
</html>