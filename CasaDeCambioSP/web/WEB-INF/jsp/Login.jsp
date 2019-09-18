<%-- 
    Document   : Login
    Created on : Sep 17, 2019, 10:16:28 AM
    Author     : Miguel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/Resources/css/login.css" >
        <link rel="stylesheet" type="text/css" href="https://fonts.googleapis.com/css?family=Open+Sans:400,700">
        <title>JSP Page</title>
    </head>
    <body>
        <div id="login">
            <form method="POST" action="LoginServlet" name='form' onsubmit="return validarLogin()">
            <span class="fontawesome-user"></span>
              <input type="text" id="usuario" name="usuario" placeholder="Username">

            <span class="fontawesome-lock"></span>
              <input type="password" id="password" name="password" placeholder="Password">
              
              <p><%=(request.getAttribute("errMessage") == null) ? "" : request.getAttribute("errMessage")%></p>      
            <input type="submit" value="Login"></input>
            <br>
            <br>
            <input type="submit" value="Reset"></input>
          </form>
        </div>
    
            <script type="text/javascript" src="${pageContext.request.contextPath}/Resources/js/validaciones.js"></script>
    </body>
</html>
