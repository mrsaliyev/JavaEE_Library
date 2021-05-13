<%@ page import="kz.iitu.BEAN.BookBean" %>
<%@ page import="kz.iitu.DAO.BookDao" %>
<%@ page import="java.awt.*" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="java.util.List" %>
<jsp:useBean id="bookDao" scope="session" class="kz.iitu.DAO.BookDao" />
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
</head>
<body>
<table class="table table-striped">
    <thead>
    <th scope="col">#</th>
    <th scope="col">Name</th>
    <th scope="col">Surname</th>
    <th scope="col">Email</th>
    <th scope="col">Password</th>
    </thead>

<%
    List<BookBean> books = BookDao.view();
    int i=0;
    while (books.size()>i) {
%>

<tbody>
<tr>
    <th scope="row"><%= i %></th>
    <td><%= books.get(i).getTitle()%></td>
    <td><%= books.get(i).getGenre()%></td>
    <td><%= books.get(i).getPublisher()%></td>
    <td><%= books.get(i).getAuthor()%></td>
</tr>
</tbody>
<%
        i++;}
%>
</table>
</body>
</html>
