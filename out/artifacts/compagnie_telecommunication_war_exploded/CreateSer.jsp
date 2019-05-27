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
    <title>Création d'un Service</title>

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

<form action="CreateSer" method="post">
    Description : <br>
    <input type="text" name="description"><br>
    Cout de consommation par unité : <br>
    <input type="text" name="cout"> <br>
    Type du service : <br>
    <input type="checkbox" name="type" onclick="doStuff()" value="1" > Internet<br>
    <input type="checkbox" name="type" value="2"> Communication Vocale<br>

    <div style="display: none" id="isp"> ISP :
        <select name="Isp">
            <option value="Planet Tunisie">Planet Tunisie</option>
            <option value="Wanadoo-Planet">Wanadoo-Planet</option>
            <option value="GlobalNet">GlobalNet</option>
            <option value="Topnet">Topnet</option>
        </select></div>
    <input type="submit" value="Valider">
</form>




<br><a href="Logout">Logout</a>
<script> function doStuff () {
    var display = document.querySelector('#isp').style.display;
    if (display === "block") {
        document.querySelector('#isp').style.display = "none";
    } else {
        document.querySelector('#isp').style.display = "block";
    }

}
</script>
</body>
<br><a href="Login.jsp">Logout</a>
</html>