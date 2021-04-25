<%@ page import="kz.iitu.BEAN.BookBean" %>
<%@ page import="kz.iitu.DAO.BookDao" %>
<%@ page import="java.awt.*" %>
<%@ page import="java.util.List" %>
<jsp:useBean id="bookDao" scope="session" class="kz.iitu.DAO.BookDao" />
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    List<BookBean> books = BookDao.view();
    String s = "";
%>

<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    for(BookBean b : books) {
        String str = "<div class=\"book_card\">\n" +
                "                <div>\n" +
                "                    <p>Name: " + b.getTitle() + "</p>\n" +
                "                    <p>Price: " + b.getGenre() + "</p>\n" +
                "                    <p>Name: " + b.getPublisher() + "</p>\n" +
                "                    <p>Price: " + b.getAuthor() + "</p>\n" +
                "                    <a href=\"book?id=" + b.getId() + "\">Show detail</a>" +
                "                </div>\n" +
                "            </div>";
        s += str + "\n";
    }
%>


<div class="div_main">
    <h1 class="title">Books</h1>
    <div class="ul-flex">
        <%= s %>
    </div>
</div>
</body>
</html>
