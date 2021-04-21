package kz.iitu.Servlet;

import kz.iitu.BEAN.LibrarianBean;
import kz.iitu.DAO.LibrarianDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/ViewLibrarian")
public class ViewLibrarian extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        out.println("<a href=\"navadmin.jsp\">Go back</a>");
        out.println("<div class='container'>");

        List<LibrarianBean> list = LibrarianDao.view();

        out.println("<table class='table table-bordered table-striped'>");
        out.println("<tr><th>Id</th><th>Name</th><th>Surname</th<th>Email</th><th>Password</th><th>Edit</th><th>Delete</th></tr>");
        for(LibrarianBean bean : list) {
            out.println("<tr><td>" + bean.getId() + "</td><td>" + bean.getName() + "</td><td>" + bean.getSurname() + "</td><td>" + bean.getEmail() + "</td><td>" + bean.getPassword() + "</td><td><a href='EditLibrarianForm?id=" + bean.getId() + "'>Edit</a></td><td><a href='DeleteLibrarian?id=" + bean.getId() + "'>Delete</a></td></tr>");
        }
        out.println("</table>");

        out.println("</div>");
        out.close();

    }
}
