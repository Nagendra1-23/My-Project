<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
    <link rel="stylesheet" href="index.css">
</head>
<body>
<h2>Register</h2>

<c:if test="${not empty error}">
    <p style="color:red">${error}</p>
</c:if>

<c:if test="${not empty msg}">
    <p style="color:green">${msg}</p>
</c:if>

<form action="register" method="post">
    First Name: <input type="text" name="firstName" id="firstName" required /><br/>
    Last Name: <input type="text" name="lastName" required /><br/>
    Email: <input type="email" name="email" id="email" required /><br/>
    Password: <input type="password" name="password" id="password" required /><br/>
    Designation: <input type="text" name="designation" required /><br/>
    Hire Date: <input type="date" name="hireDate" required /><br/>
    Salary: <input type="number" name="salary" required /><br/>
    <input type="submit" value="Register" />
</form>

<p><a href="login">Already have an account? Login here.</a></p>
<script src="index.js"></script>

</body>
</html>
