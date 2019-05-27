<%--
  Created by IntelliJ IDEA.
  User: krifa
  Date: 21/12/17
  Time: 11:46 ص
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="java.util.Vector" %>
<%@ page import="com.beans.Abonne" %>

<%
    if (session.getAttribute("id") == null) {
        response.sendRedirect("Login.jsp");

    }
%>

<% if ((int) session.getAttribute("nums") == 3) {%>
<html>
<head>
    <title> ajouter abonnee</title>
</head>
<body>

<form action='CreateAbn' method='post'>
    Nom : <br>
    <input type='text' name='nom'><br>
    Prénom : <br>
    <input type='text' name='prenom'><br>
    Adresse :<br>
    <input type='text' name='adresse'><br>
    Adresse Mail : <br>
    <input type='email' name='mail'> <br>
    <input type='submit' value='Ajouter'>
</form>
tableau des abonnés:
<%Vector v = new Vector();%>
<% v = Abonne.getabonne();%>
<%System.out.println(v.size());%>
<table>
    <tr>
        <th>Nom</th>
        <th>Prenom</th>
        <th>Adresse</th>
        <th>Mail</th>
    </tr>

    <%for (int i = 0; i < v.size(); i++) {%>
    <tr>
        <td><%=((Abonne) v.elementAt(i)).getNom()%></td>
        <td><%=((Abonne) v.elementAt(i)).getprenom()%></td>
        <td><%=((Abonne) v.elementAt(i)).getadresse()%></td>
        <td><%=((Abonne) v.elementAt(i)).getadresse()%></td>
    </tr>

    <%}%>
</table>
<br><a href="Login.jsp">Logout</a>
</body>
</html>
<%}%>