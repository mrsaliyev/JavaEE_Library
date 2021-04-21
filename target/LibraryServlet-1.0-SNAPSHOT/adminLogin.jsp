<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
</head>
<body>
<%@ include file="header.jsp"%>

<form action="AdminLogin" method="post">
    <h2>Login Form</h2>
    Username: <input type="text" name="email" placeholder = "Enter email" required>
    <br/>
    Password: <input type="password" name="password" placeholder="Enter password" required>
    <br>
    <input type="submit" value="Login">
</form>

</body>
</html>
