<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <link rel="stylesheet" href="/css/login.css">
</head>
<body>
<h2>Login</h2>

<c:if test="${not empty error}">
    <p style="color:red">${error}</p>
</c:if>

<form action="/loginemp" method="post">
    Email: <input type="email" name="email" required /><br/>
    Password: <input type="password" name="password" required /><br/>
    <input type="submit" value="Login" />
</form>

<p><a href="register">Don't have an account? Register here.</a></p>
<p><a href="forgot-password">Forgot Password?</a></p>
<script src="login.js"></script>

</body>
</html>
