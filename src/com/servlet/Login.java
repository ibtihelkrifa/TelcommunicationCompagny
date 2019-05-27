package com.servlet;

import com.connection.ConnectionBD;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet(name = "Login")
public class Login extends HttpServlet {


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username=request.getParameter("username");
        String password =request.getParameter("password");
        ConnectionBD Con = new ConnectionBD();
        Con.driver();
        Con.OpenConnexion();
        ResultSet rs= Con.selectExec("SELECT Id, NumeroService FROM Employe WHERE Mail='" + username + "' AND Password = '" + password + "';");
        try {
            if (!rs.next())
            {
                response.sendRedirect("Login.jsp");
            }
            else
            {
                HttpSession session = request.getSession();
                session.setAttribute("id",Integer.parseInt(rs.getString(1)));
                session.setAttribute("nums",Integer.parseInt(rs.getString(2)));
                response.sendRedirect("Acceuil.jsp");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}