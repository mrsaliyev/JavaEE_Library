package kz.iitu.Servlet;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kz.iitu.BEAN.LibrarianBean;
import kz.iitu.DAO.LibrarianDao;
@WebServlet("/EditLibrarian")
public class EditLibrarian extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String sid=request.getParameter("id");
        int id=Integer.parseInt(sid);
        String name=request.getParameter("name");
        String surname=request.getParameter("surname");
        String email=request.getParameter("email");
        String password=request.getParameter("password");

        LibrarianBean bean = new LibrarianBean(id,name, surname, email, password);
        LibrarianDao.update(bean);
        response.sendRedirect("ViewLibrarian");
    }

}
