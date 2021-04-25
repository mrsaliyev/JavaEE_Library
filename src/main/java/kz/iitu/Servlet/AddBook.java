package kz.iitu.Servlet;


import kz.iitu.BEAN.BookBean;
import kz.iitu.BEAN.LibrarianBean;
import kz.iitu.DAO.BookDao;
import kz.iitu.DAO.LibrarianDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/AddBook")
public class AddBook extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String title = request.getParameter("title");
        String genre = request.getParameter("genre");
        String publisher = request.getParameter("publisher");
        String author = request.getParameter("author");
        BookBean bean = new BookBean(title,genre,publisher,author);

        if (BookDao.save(bean) == true){
            out.print("<h4>Book added successfully</h4>");
            request.getRequestDispatcher("navlibrarian.jsp").include(request, response);
            response.sendRedirect("navlibrarian.jsp");
        } else {
            out.print("<h4>Error</h4>");
            request.getRequestDispatcher("abbBook.jsp").include(request, response);
        }
        out.println("</div>");
        out.close();
    }
}
