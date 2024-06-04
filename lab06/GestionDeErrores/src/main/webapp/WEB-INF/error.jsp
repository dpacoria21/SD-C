<%--
  Created by IntelliJ IDEA.
  User: ADVANCE
  Date: 3/06/2024
  Time: 08:03
  To change this template use File | Settings | File Templates.
--%>
<%@page isErrorPage="true" %>
<%@page import="java.util.ArrayList" %>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Error Page</title>
</head>
<body>
<h1>Ocurrió un error</h1>
<% ArrayList<String> mensajes = (ArrayList<String>) request.getAttribute("mensajes"); %>
<% if (mensajes != null) { %>
<ul>
    <% for (String mensaje : mensajes) { %>
    <li><%= mensaje %></li>
    <% } %>
</ul>
<% } else { %>
<p><%= exception.getMessage() %></p>
<% } %>
</body>
</html>