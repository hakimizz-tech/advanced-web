<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.example.model.User" %>
<% User user = (User) session.getAttribute("user");
   if (user == null) {
       response.sendRedirect("login.jsp");
       return;
   } %>
<html>
<head>
    <title>Upload Resume</title>
    <style>
        body { font-family: sans-serif; margin: 2em; }
        .container { max-width: 600px; margin: auto; padding: 2em; border: 1px solid #ccc; border-radius: 5px; }
        h1 { color: #333; }
        form { display: flex; flex-direction: column; gap: 10px; }
        input[type="file"] { padding: 8px; border: 1px solid #ddd; border-radius: 4px; }
        input[type="submit"] { background-color: #007bff; color: white; padding: 10px; border: none; border-radius: 4px; cursor: pointer; }
        input[type="submit"]:hover { background-color: #0056b3; }
    </style>
</head>
<body>
    <div class="container">
        <h1>Upload Resume</h1>
        <form action="upload-resume" method="post" enctype="multipart/form-data">
            <label for="resume">Select XML Resume File:</label>
            <input type="file" id="resume" name="resume" accept=".xml" required>
            <input type="submit" value="Upload">
        </form>
    </div>
</body>
</html>
