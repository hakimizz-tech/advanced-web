<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>

<!DOCTYPE html>
<html>
<head>
<title>JSTL SQL Tag Demo</title>
<style>
    body { font-family: sans-serif; }
    table { width: 80%; border-collapse: collapse; margin: 20px auto; }
    th, td { border: 1px solid #ddd; padding: 8px; }
    th { background-color: #f2f2f2; }
    .warning { color: #856404; background-color: #fff3cd; border: 1px solid #ffeeba; padding: 15px; margin-bottom: 20px; }
</style>
</head>
<body>

    <h1>JSTL SQL Tag Demo</h1>

    <div class="warning">
        <strong>Warning:</strong> This page uses JSTL SQL tags for direct database access.
        This is for demonstration purposes only and is <strong>not</strong> a recommended practice for production applications.
    </div>

    <%-- Step 1: Set up the data source --%>
    <sql:setDataSource var="myDb"
        driver="com.mysql.cj.jdbc.Driver"
        url="jdbc:mysql://localhost:3306/test_db"
        user="root" password="" />

    <%-- Step 2: Execute the query --%>
    <sql:query dataSource="${myDb}" var="userResults">
        SELECT id, firstname, email FROM users;
    </sql:query>

    <%-- Step 3: Display the results using JSTL core tags --%>
    <h2>Users List</h2>
    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Email</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="row" items="${userResults.rows}">
                <tr>
                    <td><c:out value="${row.id}" /></td>
                    <td><c:out value="${row.firstname}" /></td>
                    <td><c:out value="${row.email}" /></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

</body>
</html>
