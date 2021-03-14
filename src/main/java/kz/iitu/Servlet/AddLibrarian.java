package kz.iitu.Servlet;

import kz.iitu.DAO.LibrarianDao;
import kz.iitu.BEAN.LibrarianBean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/AddLibrarian")
public class AddLibrarian extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        LibrarianBean bean = new LibrarianBean(id, name, surname, email, password);

        if (LibrarianDao.save(bean) == true){
            out.print("<h4>Librarian added successfully</h4>");
            request.getRequestDispatcher("navlibrarian.jsp").include(request, response);
            response.sendRedirect("navlibrarian.jsp");
        }else {
            out.print("<h4>Error</h4>");
            request.getRequestDispatcher("register.jsp").include(request, response);
        }
        out.println("</div>");
        out.close();
    }
}

