package com.servlet;
import com.beans.Fixe;
import com.beans.Mobile;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "CreateNum")
public class CreateNum extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int num=0;
        System.out.println("cccccccccc");
        HttpSession session = request.getSession();
        if ((int)session.getAttribute("mat")==0)
        {
            response.sendRedirect("Login.jsp");
        }
        if ((int)session.getAttribute("nums")!=3)
        {
            response.sendRedirect("Acceuil.jsp");
        }
        int mat=(int)session.getAttribute("mat");
        String type = request.getParameter("type");
        System.out.println(type);
        if(type.equals("Fixe"))
        {
            int loc = Integer.parseInt(request.getParameter("loc"));

            Fixe f = new Fixe(loc,mat) ;
            f.addfixe();
             num =f.getnum();
        }
        else if(type.equals("Mobile"))
        {
            String typecon= request.getParameter("type");
            String reseau=request.getParameter("reseau");

            String payement=request.getParameter("payement");

            int serviceint=Integer.parseInt(request.getParameter("serviceinternet"));

            int servicevoc=Integer.parseInt(request.getParameter("servicevoc"));

            Mobile mob = new Mobile(typecon, reseau, payement,serviceint, servicevoc, mat);

            mob.addmobile();

           num =mob.getNum();
        }
        session.setAttribute("mat",mat);
        session.setAttribute("numero",num);
        response.sendRedirect("Contrat.jsp");
    }

            }








