<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Register Account</title>
    <link href="https://fonts.googleapis.com/css?family=ZCOOL+XiaoWei" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<%--  include navadmin.jsp  --%>
<jsp:include page="navadmin.jsp" />

<div class="container">
    <div class="regbox box">
        <img class="avatar" src="img/registration.jpg">
        <h1>Register Account</h1>
        <form action="AddLibrarian" method="post">
            <%--@declare id="name1"--%>
            <%--@declare id="id1"--%>
                <%--@declare id="surname1"--%>
                <%--@declare id="email1"--%>
                <%--@declare id="password1>name</label>
            <input type="--%><%--@declare id="password1"--%>

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

<%--<%--%>
<%--    if ((String)request.getAttribute("status") != null && ((String)request.getAttribute("status")).equals("false")) {--%>
<%--        out.print("<p class=error>Email already exist!</p>");--%>
<%--    }--%>
<%--%>--%>
</body>
</html>
