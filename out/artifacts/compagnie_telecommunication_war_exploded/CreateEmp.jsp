<%--
  Created by IntelliJ IDEA.
  User: imen
  Date: 21/12/17
  Time: 09:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="javax.servlet.http.HttpSession" %>
<html>
<head>
    <title>Création d'un Employé</title>
</head>
<body>

<%
    if ((int)session.getAttribute("nums")==0)
    {
        response.sendRedirect("Login.jsp");
    }
    if ((int)session.getAttribute("nums")!=1)
    {
        response.sendRedirect("Acceuil.jsp");
    }
%>

<form action="CreateEmp" method="post">
    Nom : <br>
    <input type="text" name="nom"><br>
    Prénom : <br>
    <input type="text" name="prenom"><br>
    Adresse Mail : <br>
    <input type="email" name="mail"> <br>
    Adresse  : <br>
    <input type="text" name="adresse"> <br>
    Mot de passe : <br>
    <input type="password" name="passwd"><br>
    Tâche :<br>
    <input type="radio" name="service" value="1"> Administration<br>
    <input type="radio" name="service" value="2"> Gestion des factures<br>
    <input type="radio" name="service" value="3"> Gestion des contrats<br>
    <input type="submit" value="Valider">
</form>




<a href="Login.jsp">Logout</a>
</body>
</html>