<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>HttpURLConnection Demo</title>
</head>
<body>
    <h1>HttpURLConnection Demo</h1>

    <h2>GET Request</h2>
    <form action="http-action" method="get">
        <label for="getUrl">URL:</label>
        <input type="text" id="getUrl" name="url" size="100" value="https://api.github.com/users/google">
        <br>
        <input type="submit" value="Send GET Request">
    </form>

    <hr>

    <h2>POST Request</h2>
    <form action="http-action" method="post">
        <label for="postUrl">URL:</label>
        <input type="text" id="postUrl" name="url" size="100" value="https://jsonplaceholder.typicode.com/posts">
        <br>
        <label for="payload">Payload:</label>
        <textarea id="payload" name="payload" rows="5" cols="80">{"title": "foo", "body": "bar", "userId": 1}</textarea>
        <br>
        <input type="submit" value="Send POST Request">
    </form>
</body>
</html>
