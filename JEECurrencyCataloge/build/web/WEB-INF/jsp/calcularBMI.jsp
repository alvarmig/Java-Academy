<%-- 
    Document   : calcularBMI
    Created on : Sep 3, 2019, 1:16:02 PM
    Author     : Miguel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form name="bmiForm" action="calculateServlet" method="POST">
            <table>
                <tr>
                    <td>Your Weight (kg) :</td>
                    <td><input type="text" name="weight"/></td>
                </tr>
                <tr>
                    <td>Your Height (m) :</td>
                    <td><input type="text" name="height"/></td>
                </tr>
                <th><input type="submit" value="Submit" name="find"/></th>
                <th><input type="reset" value="Reset" name="reset" /></th>
            </table>
            <h2>${bmi}</h2>
        </form>
    </body>
</html>
