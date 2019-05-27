package com.servlet;
import com.beans.Abonne;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "CreateAbn")
public class CreateAbn extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();

        if ((int)session.getAttribute("nums")==0)
        {
            response.sendRedirect("Login.jsp");
        }
        if ((int)session.getAttribute("nums")!=3)
        {
            response.sendRedirect("Acceuil.jsp");
        }

        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String mail = request.getParameter("mail");
        String adresse = request.getParameter("adresse");
        Abonne abn =new Abonne(nom ,prenom ,adresse,mail);
        int mat =abn.addabonne();

        session.setAttribute("mat",mat );

        response.sendRedirect("createNumero.jsp");
    }
}