<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Periodic Reports</title>
    <meta http-equiv="refresh" content="10">
    <style>
        body {
            font-family: sans-serif;
            margin: 2em;
        }
        h1 {
            color: #333;
        }
        ul {
            list-style-type: none;
            padding: 0;
        }
        li {
            background: #f4f4f4;
            margin: 5px 0;
            padding: 10px;
            border-left: 5px solid #007bff;
        }
    </style>
</head>
<body>
    <h1>Periodic Reports</h1>
    <ul>
        <c:forEach var="report" items="${applicationScope.reports}">
            <li><c:out value="${report}"/></li>
        </c:forEach>
    </ul>
</body>
</html>
