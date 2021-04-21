<%@ page import="kz.iitu.DAO.BookDao" %>
<%@ page import="kz.iitu.BEAN.BookBean" %>
<jsp:useBean id="bookDao" scope="session" class="kz.iitu.DAO.BookDao" />

<%!
    String str = "";
    String id;
    BookBean b;
%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    id = request.getParameter("id");
    b = BookDao.viewById(Integer.parseInt(id));
    str = "<div class=\"book_card\">\n" +
            "                <div>\n" +
            "                    <p>Name: " + b.getTitle() + "</p>\n" +
            "                    <p>Price: " + b.getGenre() + "</p>\n" +
            "                    <p>Name: " + b.getPublisher() + "</p>\n" +
            "                    <p>Price: " + b.getAuthor() + "</p>\n" +
            "                </div>\n" +
            "            </div>";
%>


<div class="div_main">

    <h1 class="title">Book Detail</h1>

    <div class="ul-flex">
        <%= str %>
    </div>

</div>
</body>
</html>
