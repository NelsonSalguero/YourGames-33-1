<%-- 
    Document   : Cerrar Sesion
    Created on : 18/09/2021
    Author     : Grupo 33/1
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true" %>
<%  
    HttpSession objSesion = request.getSession();  
    objSesion.invalidate();
    out.print("<script>location.replace('../');</script>");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cerrar Sesion</title>
    </head>
    <body>
        
    </body>
</html>
