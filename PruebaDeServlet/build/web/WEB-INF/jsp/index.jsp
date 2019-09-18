<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/Resources/CSS/login.css" >
        <link rel="stylesheet" type="text/css" href="https://fonts.googleapis.com/css?family=Open+Sans:400,700">
        <title>Welcome to Spring Web MVC project</title>
    </head>

    <body>
        <form method="GET" action="/PruebaDeServlet/testServlet">
            <input type="submit" name="cmdPromedio" value="Calcular Promedio">
        </form>
        <br>
        <br>
        <br>
        <div id="login">
          <form method="POST" action="/PruebaDeServlet/testServlet" name='form-login'>
            <span class="fontawesome-user"></span>
              <input type="text" id="user" name="cmdNombre" placeholder="Username">

            <span class="fontawesome-lock"></span>
              <input type="password" id="pass" name="cmdPassword" placeholder="Password">

            <input type="submit" value="Login">

          </form>
        </div>
        
         
         <%  Object valor =  request.getAttribute("respuesta");%>
         
         <p><%= valor %></p>
    </body>
</html>
