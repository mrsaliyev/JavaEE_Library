<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Login Account</title>
    <link href="https://fonts.googleapis.com/css?family=ZCOOL+XiaoWei" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet" type="text/css"/>
</head>
<body>

<%@ include file="header.jsp"%>

<div class="container">
    <div class="box">
        <img class="avatar" src="img/user-avatar.jpg">
        <h1>Login Account</h1>
        <form action = "LibrarianLogin" method="post">
            <p>Email</p>
            <input type="text" placeholder="Email" name="email" required>
            <p>Password</p>
            <input type="password" placeholder="Password" name="password" required>
            <input type="submit" value="Register">
        </form>
    </div>
</div>
</body>
</html>
