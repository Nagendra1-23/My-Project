<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Forgot Password</title>
    <link rel="stylesheet" href="/css/forgot-password.css">
</head>
<body>
<h2>Forgot Password</h2>

<c:if test="${not empty error}">
    <p style="color:red">${error}</p>
</c:if>

<c:if test="${not empty msg}">
    <p style="color:green">${msg}</p>
</c:if>

<form action="forgot-password" method="post">
    Email: <input type="email" name="email" required /><br/>
    New Password: <input type="password" name="password" required /><br/>
    Confirm Password:<input <span class="toggle-password" onclick="toggleForgotPassword(this)">👁️</span>/>
    <input type="submit" value="Reset Password" />
</form>

<p><a href="login">Back to Login</a></p>

</body>
</html>
