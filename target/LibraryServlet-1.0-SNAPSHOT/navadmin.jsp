<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin</title>
</head>
<body>
<%= "Welcome " + request.getParameter("email") %><br>


<a href="register.jsp">Add Librarian</a>
<a href="ViewLibrarian">View Librarian</a>
<a href="LogoutAdmin">Logout</a>


</body>
</html>