<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Register Account</title>
    <link href="https://fonts.googleapis.com/css?family=ZCOOL+XiaoWei" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<p><a href="navadmin.jsp">Go back</a> </p>

<div class="container">
    <div class="regbox box">
        <img class="avatar" src="img/registration.jpg">
        <h1>Register Account</h1>
        <form action="AddLibrarian" method="post">
            <%--@declare id="name1"--%>
            <%--@declare id="id1"--%><%--@declare id="surname1"--%><%--@declare id="email1"--%><%--@declare id="password1>name</label>
            <input type="--%><%--@declare id="password1"--%><label for="id1">ID</label>
            <input type="text" placeholder="id" name="id" required>
            <label for="name1">Name</label>
            <input type="text" placeholder="Name" name="name" required>
                <label for="surname1">Surname</label>
            <input type="text" placeholder="Surname" name="surname" required>
                <label for="email1">Email</label>
            <input type="text" placeholder="Email" name="email" required>
                <label for="password1">Password</label>
            <input type="password" placeholder="Password" name="password" required>
            <input type="submit" value="Register">
        </form>
    </div>
</div>
</body>
</html>
