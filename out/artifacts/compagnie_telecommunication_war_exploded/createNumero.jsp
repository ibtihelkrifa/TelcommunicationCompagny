<%--
  Created by IntelliJ IDEA.
  User: krifa
  Date: 21/12/17
  Time: 02:39 م
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="com.connection.ConnectionBD" %>
<%@ page import="javax.servlet.http.HttpSession" %>
<%@ page import="java.sql.*" %>
<%@ page import="java.io.IOException" %>
<% session = request.getSession();
    if (session.getAttribute("mat") == null) {
        response.sendRedirect("Login.jsp");

    } else {
%>
<html>
<head>
    <title>creer numero</title>
</head>
<body>
<form action="CreateNum" method="post">
    <div class="radio-group" onchange="toggleType()">
        <input type="radio" name="type" value="Fixe" checked> Fixe<br>
        <input type="radio" name="type" value="Mobile" id="fixe"> Mobile<br>
    </div>

    <div id="fixeField"> Localisation Geographique :


        <select name="loc">
            <% ConnectionBD c = new ConnectionBD();
                c.driver();
                c.OpenConnexion(); %>
            <% String sql = "select Id, Nom from Localisation;"; %>
            <% ResultSet rst = c.selectExec(sql); %>

            <% while (rst.next()) { %>

            <option value="<%=rst.getString(1)%>"><%=rst.getString(2)%></option>
            <%}%>
        </select>

    </div>
    <div style="display: none" id="mobileField">
        Type :
        <select name="type">
            <option value="3G">3G</option>
            <option value="4G">4G</option>
        </select><br>
        Type Reseau :
        <select name="reseau">
            <option value="1">Type 1</option>
            <option value="2">Type 2</option>
            <option value="3">Type 3</option>
        </select><br>
        Type Payement :
        <select name="payement">
            <option value="1">cache/carte bancaire</option>
            <option value="2">Cheque</option>
            <option value="2">Prelevement Mensulle</option>
        </select>
        <br>

        Service vocale <br><select name="servicevoc">
        <%String sql1 = "select Num_service,Description from Service_Voc;";%>
        <% rst = c.selectExec(sql1);%>
        <% while (rst.next()) { %>
        <option value="<%=rst.getInt("Num_service")%>"><%=rst.getString("Description")%></option>

        <%}%>
    </select><br>
        Service internet <br><select name="serviceinternet">
        <%String sql2 = "select Num_service,Description from Service_Int;";%>
        <% rst = c.selectExec(sql2);%>
        <%while (rst.next()) {%>
        <option value="<%=rst.getInt("Num_service")%>"><%=rst.getString("Description")%></option>
        <%}%>
    </select>


    </div>
    <input type="submit" value="creer">
</form>

<script>
    function toggleType() {


        let fixe = document.querySelector("#fixeField");
        let type = document.querySelector("#mobileField");
        let radio = document.getElementsByName("type");

        if (radio[0].checked) {
            fixe.style.display = "block";
            type.style.display = "none";
        } else {
            fixe.style.display = "none";
            type.style.display = "block";
        }
    }
</script>
</body>
<br><a href="Login.jsp">Logout</a>
</html>
<%}%>