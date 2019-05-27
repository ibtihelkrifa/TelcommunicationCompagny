package com.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Enumeration;

import com.beans.Facture;
import com.beans.MailHelper;


@WebServlet(name = "Fact")
public class Fact extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//        new MailHelper().sendMail("aymen.chebi@gmail.com","hello","helooooo");

        HttpSession session = request.getSession();
        String type = request.getParameter("creer Fixe");
        System.out.println("hiiiiiiii");
        int i;
        System.out.println(type);
        if(type==(null))
        {
            type="Mobile";
             i =Integer.parseInt((String)session.getAttribute("nombre"));
        }
        else
        {
            type="fixe";
            i=Integer.parseInt((String)session.getAttribute("nombre1"));
        }
        System.out.println(type);


        // Enumeration names = request.getParameterNames();


            for(int j=0;j<i;j++) {
                //names.nextElement();
               // names.nextElement();
                System.out.println("hiiiiiii");
                System.out.println(request.getParameter(String.valueOf(j)));
                System.out.println(request.getParameter(String.valueOf(j+1)));

                int numero=Integer.parseInt(request.getParameter(String.valueOf(j)));
                int nbunite=Integer.parseInt(request.getParameter(String.valueOf(j+1)));
                 Facture f=new Facture(type,numero,nbunite);
               try {

                   f.addfacture();

                   j=j+1;
               } catch (SQLException e) {
                   System.out.println(e.getMessage());
               }


            }
            response.sendRedirect("CreateFact.jsp");
    }

}
