<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="css/style.css" rel="stylesheet" type="text/css"/>
    <title>JSP Page</title>
</head>
<body>

<header>
    <nav class="ul-flex">
        <%= "Welcome " + request.getParameter("email") + " Admin " %><br>
        <div>
            <a class="header-link" href="register.jsp">Add Librarian</a>
            <a class="header-link" href="ViewLibrarian">View Books</a>
            <a class="header-link" href="LogoutAdmin">Logout</a>
        </div>
    </nav>
</header>


</body>
</html>

