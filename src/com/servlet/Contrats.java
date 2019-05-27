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

@WebServlet(name = "Contrats")
public class Contrats extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
if((request.getParameter("valider")).equals("valider"))
{
    HttpSession session= request.getSession();
    int mat=(int)session.getAttribute("mat");
    ConnectionBD c = new ConnectionBD();
    c.driver();
    c.OpenConnexion();
    String sql="select Mail from Abonne where Matricule= "+mat+";";
    ResultSet rst=c.selectExec(sql);
    try {
        if( rst.next())
        {
            System.out.println(rst.getString("Mail"));
            response.sendRedirect("Acceuil.jsp");

        }
    }
    catch (SQLException e)
    {
        e.printStackTrace();
    }

}


}}
