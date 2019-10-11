<%-- 
    Document   : Registro
    Created on : Sep 17, 2019, 10:16:38 AM
    Author     : Miguel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/Resources/css/login.css" >
        <link rel="stylesheet" type="text/css" href="https://fonts.googleapis.com/css?family=Open+Sans:400,700">
        <title>Inicio de sesión</title>
    </head>
    <body>
        <div id="login">
            <form method="POST" action="RegistroServlet" name='form' onsubmit="return validarRegistro()">
                
            <span class="fontawesome-user"></span>
              <input type="text" id="email" name="email" placeholder="Email">
              
            <span class="fontawesome-user"></span>
              <input type="text" id="usuario" name="usuario" placeholder="Username">

            <span class="fontawesome-lock"></span>
              <input type="password" id="password" name="password" placeholder="password">
              
            <span class="fontawesome-lock"></span>
              <input type="password" id="validarPassword" name="validarPassword" placeholder="validarPassword">
              
              <p><%=(request.getAttribute("errMessage") == null) ? "" : request.getAttribute("errMessage")%></p>      
            <input type="submit" value="Registro"></input>
            
            <p class="link-login" >Regresar a <a href="${pageContext.request.contextPath}/LoginServlet" >Login.</a></p>
          </form>
        </div>
            <script type="text/javascript" src="${pageContext.request.contextPath}/Resources/js/validaciones.js"></script>
    </body>
</html>
