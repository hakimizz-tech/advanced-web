<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>EL Demo</title>
</head>
<body>
    <h1>Expression Language Demo</h1>

    <%-- EL automatically calls student.getName() --%>
    <p>Student Name: <strong>${student.name}</strong></p>

    <%-- Accessing a nested object property --%>
    <p>Student City: <strong>${student.address.city}</strong></p>

    <%-- Accessing a session-scoped attribute --%>
    <%-- It's good practice to specify the scope for clarity --%>
    <p>User Role (from session): <strong>${sessionScope.userRole}</strong></p>

    <%-- EL automatically searches scopes (page, request, session, application) --%>
    <p>User Role (auto-searched): <strong>${userRole}</strong></p>

    <%-- EL handles null gracefully. If 'nonExistent' is null, it prints nothing. --%>
    <p>Non-existent attribute: <strong>${nonExistent}</strong></p>

</body>
</html>
