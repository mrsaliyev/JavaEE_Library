<%@ page import="java.util.List" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="kz.iitu.BEAN.LibrarianBean" %>
<%@ page import="kz.iitu.DAO.LibrarianDao" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="css/style.css" rel="stylesheet" type="text/css"/>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
    <title>JSP Page</title>
</head>
<body>

<header>
    <nav class="ul-flex">
        <%= "Welcome " + request.getParameter("email") + " Admin " %><br>
        <div>
            <a class="header-link" href="register.jsp">Add Librarian</a>
            <a class="header-link" href="ViewLibrarian">View Librarians</a>
            <a class="header-link" href="LogoutAdmin">Logout</a>
        </div>
    </nav>
</header>

<jsp:useBean id="Library" class="kz.iitu.DAO.LibrarianDao"></jsp:useBean>

<table class="table">
    <thead>
    <tr>
        <th scope="col">#</th>
        <th scope="col">Name</th>
        <th scope="col">Surname</th>
        <th scope="col">Email</th>
        <th scope="col">Password</th>
    </tr>
    </thead>


<%
    List<LibrarianBean> librarianBeans = LibrarianDao.view();
    int i=0;
    while (librarianBeans.size()>i) {
%>


    <tbody>
    <tr>
        <th scope="row"><%= i %></th>
        <td><%= librarianBeans.get(i).getName()%></td>
        <td><%= librarianBeans.get(i).getSurname()%></td>
        <td><%= librarianBeans.get(i).getEmail()%></td>
        <td><%= librarianBeans.get(i).getPassword()%></td>
    </tr>

    </tbody>

<%
        i++;}
%>
</table>

</body>
</html>
