package kz.iitu.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/AdminLogin")
public class AdminLogin extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();

        out.print("<!DOCTYPE html>");
        out.print("<html>");
        out.println("<head>");
        out.println("<title>Admin Section</title>");
        out.println("<link rel='stylesheet' href='bootstrap.min.css'/>");
        out.println("</head>");
        out.println("<body>");

        String email = request.getParameter("email");
        String password = request.getParameter("password");
        if(email.equals("mrsaliyev@gmail.com") && password.equals("admin123")){
            HttpSession session = request.getSession();
            session.setAttribute("admin","true");
            session.setMaxInactiveInterval(30*60);
            Cookie userEmail = new Cookie("admin", email);
            userEmail.setMaxAge(30*60);
            response.addCookie(userEmail);

            request.getRequestDispatcher("navadmin.jsp").include(request, response);
            response.sendRedirect("navadmin.jsp");

        }else{
            out.println("<div class = 'container'>");
            out.println("<font color=red>Either user email or password is wrong.</font>");
            request.getRequestDispatcher("adminLogin.jsp").include(request, response);
            out.println("</div>");
        }

        out.close();
    }

}

