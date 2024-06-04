<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Inicio de sesión</title>
</head>
<body>
<h1>Inicio de sesión</h1>
<form action="login" method="POST">
    <label for="usuario">Usuario:</label>
    <input type="text" id="usuario" name="usuario"><br><br>
    <label for="contrasenia">Contraseña:</label>
    <input type="password" id="contrasenia" name="contrasenia"><br><br>
    <input type="submit" value="Iniciar sesión">
</form>
<br/>
<a href="hello-servlet">Hello Servlet</a>
</body>
</html>