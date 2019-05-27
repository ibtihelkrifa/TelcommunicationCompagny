package com.servlet;

import com.beans.Service_Int;
import com.beans.Service_Voc;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "CreateSer")
public class CreateSer extends HttpServlet {
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

        String description = request.getParameter("description");
        String cou = request.getParameter("cout");
        float cout =Float.parseFloat(cou);
        String type = request.getParameter("type");
        int nums = Integer.parseInt(type);
        if (nums==2) {
            Service_Voc serv = new Service_Voc(description, cout);
            serv.addservicevoc();
        }
        if (nums==1){
            String isp = request.getParameter("Isp");
            Service_Int serv = new Service_Int(description, cout, isp);
            serv.addserviceint();
        }
        response.sendRedirect("Acceuil.jsp");
    }

}
