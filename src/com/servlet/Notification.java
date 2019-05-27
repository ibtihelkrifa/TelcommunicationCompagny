package com.servlet;

import com.beans.Abonne;
import com.beans.Facture;
import com.beans.MailHelper;
import com.connection.ConnectionBD;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet(name = "Notification")
public class Notification extends HttpServlet {


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String button = request.getParameter("alert");
        if(button==null)
        {
            button="paye";
        }
        else
        {
            button="alert";
        }
        System.out.println(button);
        if(button.equals("paye"))
        {
            int numero=Integer.parseInt(request.getParameter("numero"));
            Facture.payer(numero);
            System.out.println("numero");
        }
        else
        {
            System.out.println("hi alert");
            int numero=Integer.parseInt(request.getParameter("numero"));
            System.out.println(String.valueOf(numero));
            try {
                String adressemail= Abonne.getmail(numero);
               new MailHelper().sendMail("aymen.chebi@gmail.com","objet:facturation ","veuillez payer votre facture");
                System.out.println(adressemail);
                System.out.println(String.valueOf(numero)+"alert");
                }
            catch (SQLException e) {
                e.printStackTrace();
            }

        }

    }
}
