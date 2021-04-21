<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--  include navlibrarian.jsp  --%>
<%@ include file="navlibrarian.jsp"%>


<form action="AddBook" method="post">
    <%--@declare id="title"--%><%--@declare id="genre"--%><%--@declare id="publisher"--%><%--@declare id="author"--%><label for="Title">Name</label>
    <input type="text" placeholder="Title" name="title" required>
    <label for="Genre">Genre</label>
    <input type="text" placeholder="Genre" name="genre" required>
    <label for="Publisher">Publisher</label>
    <input type="text" placeholder="Publisher" name="publisher" required>
    <label for="Author">Author</label>
    <input type="text" placeholder="Author" name="author" required>
    <input type="submit" value="Add">
</form>

</body>
</html>
