<%@ page import="java.util.ArrayList" %>
<%@ page import="com.beans.Facture" %><%--
  Created by IntelliJ IDEA.
  User: krifa
  Date: 22/01/18
  Time: 11:39 م
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>page notification</title>
</head>
<body>
<%ArrayList<Integer> A = Facture.afficherfacture();%>

<% for (int i = 0; i < A.size(); i++) {%>
<form action="Notification" method="post">
    Facture : <input type="text" name="numero" value=<%=String.valueOf(A.get(i))%>>
    <input type="submit" value="alert"name="alert">
    <input type="submit" value="payer" name="paye">
</form>
<%}%>

</body>
</html>

