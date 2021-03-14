package kz.iitu.Servlet;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kz.iitu.DAO.LibrarianDao;
@WebServlet("/LibrarianLogin")
public class LibrarianLogin extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();

        out.print("<!DOCTYPE html>");
        out.print("<html>");
        out.println("<head>");
        out.println("<title>Librarian Section</title>");
        out.println("<link rel='stylesheet' href='bootstrap.min.css'/>");
        out.println("</head>");
        out.println("<body>");

        String email=request.getParameter("email");
        String password=request.getParameter("password");
        if(LibrarianDao.authenticate(email, password)){
            HttpSession session = request.getSession();
            session.setAttribute("email",email);
            request.getRequestDispatcher("navlibrarian.jsp").include(request, response);
        }else{
            out.println("<div class='container'>");
            out.println("<h3>Username or password error</h3>");
            request.getRequestDispatcher("loginLibrarianForm.jsp").include(request, response);
            out.println("</div>");
        }

        out.close();
    }

}
