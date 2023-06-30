<%-- 
    Document   : login
    Created on : 29/06/2023, 03:35:21 PM
    Author     : HP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Document</title>
        <link href="resources/css/login.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="formulario">
            <h1>Inicio de Sesión</h1>
            <form action="./login?action=login" method="post">
                <div class="username">
                    <input id="correo" name="correo" type="email" required placeholder="Correo">

                </div>
                <div class="contraseña">
                    <input id="contrasenia" name="contrasenia" type="password" required placeholder="Contraseña">
                </div>
                <div class="recordar">¿Olvidaste tu contraseña?</div>
                <input type="submit" value="Iniciar">
                <div class="registrarse">
                    ¿No tienes cuenta? <a href="register.jsp">Regístrate</a>
                </div>
            </form>
        </div>
    </body>
</html> 
