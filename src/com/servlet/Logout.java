package com.servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "Logout")
public class Logout extends HttpServlet
{
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        HttpSession session = request.getSession();
        session.removeAttribute("username");
        session.removeAttribute("password");
        session.removeAttribute("id");
        session.removeAttribute("nums");
        session.invalidate();
        response.sendRedirect("Login.jsp");
    }
}
