package com.servlet;
import javax.servlet.http.HttpSession;
import com.beans.Employe;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CreateEmp")
public class CreateEmp extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        HttpSession session = request.getSession();
        if ((int)session.getAttribute("nums")==0)
        {
            response.sendRedirect("Login.jsp");
        }
        if ((int)session.getAttribute("nums")!=1)
        {
            response.sendRedirect("Acceuil.jsp");
        }
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String passwd = request.getParameter("passwd");
        String mail = request.getParameter("mail");
        String adresse = request.getParameter("adresse");
        String num = request.getParameter("service");
        int nums = Integer.parseInt(num);
        Employe employe =new Employe(nom ,prenom ,adresse,mail,passwd,nums);
        employe.addEmploye();

        response.sendRedirect("Acceuil.jsp");
    }

}