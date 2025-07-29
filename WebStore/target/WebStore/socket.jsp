<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Socket Programming Demo</title>
</head>
<body>
    <h1>Socket Programming Demo</h1>
    <p>This page demonstrates socket programming with a simple client-server example.</p>
    <p>The server is implemented in <code>com.example.socket.SimpleServer.java</code> and the client in <code>com.example.socket.SimpleClient.java</code>.</p>

    <h2>How to Run</h2>
    <ol>
        <li>Open a terminal and navigate to the <code>WebStore</code> directory.</li>
        <li>Compile the code: <code>mvn compile</code></li>
        <li>
            Run the server in one terminal:
            <pre>java -cp target/classes com.example.socket.SimpleServer</pre>
            The server will start and listen on port 6666.
        </li>
        <li>
            Run the client in another terminal:
            <pre>java -cp target/classes com.example.socket.SimpleClient</pre>
            The client will connect to the server, send a message, and receive a response.
        </li>
    </ol>
</body>
</html>
