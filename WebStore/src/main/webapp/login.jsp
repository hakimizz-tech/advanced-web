<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <style>
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }
        
        body { 
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif; 
            display: flex; 
            justify-content: center; 
            align-items: center; 
            min-height: 100vh; 
            <%-- background: linear-gradient(135deg, #667eea 0%, #764ba2 100%); --%>
            padding: 20px;
        }
        
        .login-container { 
            background: white; 
            padding: 2.5rem; 
            border-radius: 12px; 
            box-shadow: 0 10px 30px rgba(0, 0, 0, 0.15);
            width: 100%;
            max-width: 400px;
            display: flex;
            flex-direction: column;
            gap: 1.5rem;
        }
        
        .header {
            display: flex;
            flex-direction: column;
            align-items: center;
            gap: 0.5rem;
        }
        
        h1 { 
            color: #333; 
            font-size: 2rem;
            font-weight: 600;
        }
        
        .error-message {
            color: #dc3545;
            background-color: #f8d7da;
            border: 1px solid #f5c6cb;
            padding: 0.75rem;
            border-radius: 6px;
            text-align: center;
            font-size: 0.9rem;
        }
        
        .form-container {
            display: flex;
            flex-direction: column;
            gap: 1.2rem;
        }
        
        .form-group {
            display: flex;
            flex-direction: column;
            gap: 0.5rem;
        }
        
        label { 
            font-weight: 600; 
            color: #555;
            font-size: 0.9rem;
        }
        
        input[type="text"], input[type="password"] { 
            padding: 12px; 
            border: 2px solid #e1e5e9; 
            border-radius: 6px;
            font-size: 1rem;
            transition: all 0.3s ease;
        }
        
        input[type="text"]:focus, input[type="password"]:focus {
            outline: none;
            border-color: #007bff;
            box-shadow: 0 0 0 3px rgba(0, 123, 255, 0.1);
        }
        
        .submit-container {
            display: flex;
            flex-direction: column;
            gap: 1rem;
            margin-top: 0.5rem;
        }
        
        input[type="submit"] { 
            background: linear-gradient(135deg, #007bff 0%, #0056b3 100%);
            color: white; 
            padding: 12px; 
            border: none; 
            border-radius: 6px; 
            cursor: pointer;
            font-size: 1rem;
            font-weight: 600;
            transition: all 0.3s ease;
        }
        
        input[type="submit"]:hover { 
            transform: translateY(-2px);
            box-shadow: 0 5px 15px rgba(0, 123, 255, 0.3);
        }
        
        .footer {
            display: flex;
            justify-content: center;
            align-items: center;
            padding-top: 1rem;
            border-top: 1px solid #e9ecef;
        }
        
        .footer p {
            color: #6c757d;
            font-size: 0.9rem;
        }
        
        .footer a {
            color: #007bff;
            text-decoration: none;
            font-weight: 600;
        }
        
        .footer a:hover {
            color: #0056b3;
            text-decoration: underline;
        }
        
        @media (max-width: 480px) {
            .login-container {
                padding: 2rem;
                margin: 10px;
            }
            
            h1 {
                font-size: 1.75rem;
            }
        }
    </style>
</head>
<body>
    <div class="login-container">
        <div class="header">
            <h1>Login</h1>
        </div>
        
        <% if (request.getParameter("error") != null) { %>
            <div class="error-message">
                Invalid username or password.
            </div>
        <% } %>
        
        <form action="login" method="post" class="form-container">
            <div class="form-group">
                <label for="username">Username:</label>
                <input type="text" id="username" name="username" required>
            </div>
            
            <div class="form-group">
                <label for="password">Password:</label>
                <input type="password" id="password" name="password" required>
            </div>
            
            <div class="submit-container">
                <input type="submit" value="Login">
            </div>
        </form>
        
        <div class="footer">
            <p>Don't have an account? <a href="register.jsp">Register here</a>.</p>
        </div>
    </div>
</body>
</html>
