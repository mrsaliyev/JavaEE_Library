<nav>
    pageContext.setAttribute("user",email,PageContext.SESSION_SCOPE);
    <%= "Welcome " + request.getParameter("email") %><br>


    <a href="register.jsp">Add Librarian</a>
    <a href="ListOfBooks.jsp">View Librarian</a>
    <a href="LogoutAdmin">Logout</a>
</nav>

