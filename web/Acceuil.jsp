<%--
  Created by IntelliJ IDEA.
  User: imen
  Date: 20/12/17
  Time: 18:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="javax.servlet.http.HttpSession" %>
<%@ page import="java.io.PrintWriter" %>
<html>
<head>
    <title>Acceuil</title>
</head>
<body>
    <%
        if (session.getAttribute("id")==null)
        {
            response.sendRedirect("Login.jsp");

        }
    %>
    <%
        PrintWriter o = response.getWriter();

    %>

    <%

        if ((int)session.getAttribute("nums") == 1)
        {
            o.print("<a href='CreateEmp.jsp'>Ajouter un Employé</a><br>");
            o.print("<a href='CreateSer.jsp'> Ajouter un Service </a><br>");
        }
        if ((int)session.getAttribute("nums") == 3)
        {
            o.print("<a href='CreateAbn.jsp'> Ajouter un Abonné </a><br>");

        }
        if ((int)session.getAttribute("nums") == 2)
        {
            o.print("<a href='CreateFact.jsp'>Créer une Factures</a><br>");
            o.print("<a href='Notifications.jsp'>Consulter Notifications</a><br>");
        }
    %>

    <br><a href="Login.jsp">Logout</a>
</body>
</html>
