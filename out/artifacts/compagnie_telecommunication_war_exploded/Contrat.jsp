<%--
  Created by IntelliJ IDEA.
  User: krifa
  Date: 21/12/17
  Time: 04:49 م
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="com.connection.ConnectionBD" %>
<%@ page import="javax.servlet.http.HttpSession" %>
<html>
<head>
    <title>creer contrat</title>

</head>
<body>
<%   session = request.getSession();%>
<% int mat=(int)session.getAttribute("mat");%>
<% int num=(int)session.getAttribute("numero");%>
<%
    if (session.getAttribute("id")==null)
    {
        response.sendRedirect("Login.jsp");
    }
    else { %>
<form action="Contrats" method="post">

Matricule Abonne :  <input type="text" name="mat" value=<%= mat%> >
Numero de la ligne :<input type="text" name="num" value=<%= num%>>
<input type="submit" value="valider" name="valider">
    <input type="submit" value="supprimer" name="supprimer">
  <%}%>
</form>
<br><a href="Login.jsp">Logout</a>
</body>
</html>