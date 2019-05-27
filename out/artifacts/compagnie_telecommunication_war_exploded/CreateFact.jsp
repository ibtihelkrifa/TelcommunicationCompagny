<%@ page import="java.sql.ResultSet" %>
<%@ page import="com.connection.ConnectionBD" %>
<%@ page import="com.beans.Facture" %>
<%@ page import="java.util.Vector" %><%--
  Created by IntelliJ IDEA.
  User: krifa
  Date: 20/01/18
  Time: 10:50 م
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>creation facture</title>

</head>
<body>
Lignes Fixe sans facture :<br>
<% String sql="select Numero,Matricule from Fixe ;";%>
<%ConnectionBD c = new ConnectionBD();
    c.driver();
    c.OpenConnexion();
    ResultSet rst=c.selectExec(sql);%>

<form action="Fact" method="post" >
    <%int i=0;%>
<%while(rst.next()){%>


        Numero : <input type="text" name=<%=i%>   value=<%=String.valueOf(rst.getInt(1))%>>
        Nombre d'unités : <input type="text" name=<%=i+1%>><br>
    <%i=i+2;%>
    <%}%>
    <%session.setAttribute("nombre1",String.valueOf(i));%>
        <input type="submit" value="creer" name="creer Fixe" >

</form>

Lignes Mobile sans facture :<br>
<% sql="select Numero,Matricule from Mobile ;";%>
<% rst=c.selectExec(sql);%>

<form action="Fact" method="post" >
    <%int j=0;%>
<%while(rst.next()){%>


    NUmero : <input type="text"  name=<%=j%>    value=<%=String.valueOf(rst.getInt(1))%>>
    Nombre d'unités : <input type="text" name=<%=j+1%>><br>
    <%j=j+2;%>
    <%}%>
    <%session.setAttribute("nombre",String.valueOf(j));%>
    <input type="submit" value="creer" name="creer Mobile" >
</form>
<%Vector v = new Vector();%>
<% v = Facture.getfacture();%>
Les Factures:
<%System.out.println(String.valueOf(v.size()));%>
<%System.out.println(v.elementAt(3).toString());%>

<table>
    <tr>
        <th>Id</th>
        <th>Numero</th>
        <th>Date d'ajout</th>
        <th>Nombre d'unite</th>
        <th>Total</th>
        <th>Delais</th>
    </tr>

    <%for (int k = 0; k < v.size(); k++) {%>
    <tr>
        <td><%=v.elementAt(k).toString()%></td>
        <td><%=v.elementAt(k+1).toString()%></td>
        <td><%=v.elementAt(k+2).toString()%></td>
        <td><%=v.elementAt(k+3).toString()%></td>
        <td><%=v.elementAt(k+4).toString()%></td>
        <td><%=v.elementAt(k+5).toString()%></td>
    </tr>
<%k=k+5;%>
    <%}%>
</table>

</body>
<br><a href="Login.jsp">Logout</a>
</html>
