<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="true" %>
<html>
<head>
    <title>Dashboard</title>
        <link rel="stylesheet" href="dashboard.css">
    
</head>
<body>

<h2>Welcome to Dashboard</h2>

<%
    com.employee.entity.Employee emp = (com.employee.entity.Employee) session.getAttribute("loggedInUser");
    if (emp == null) {
%>
    <p>You are not logged in. <a href="login">Login here</a></p>
<%
    } else {
%>
    <p>Hello, <%= emp.getFirstName() %> <%= emp.getLastName() %></p>
    <p>Email: <%= emp.getEmail() %></p>
    <p>Designation: <%= emp.getDesignation() %></p>
    <p><a href="logout">Logout</a></p>
<%
    }
%>
<script src="dashboard.js"></script>

</body>
</html>
