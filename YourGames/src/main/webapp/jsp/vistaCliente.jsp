<%-- 
    Document   : vistaCliente
    Created on : 18/09/2021
    Author     : Grupo 33/1
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es" dir="ltr">
    <head>
        <meta charset="utf-8">
        <title>Vista Cliente</title>
        <link rel="stylesheet" href="../css/homestyle.css" type="text/css"/>
    </head>
       <%
            String user = "";
            String admin = "";
            HttpSession objSesion = request.getSession();
            String usuario;
            if (objSesion.getAttribute("usuario") != null && objSesion.getAttribute("nivel") == "Operador") {
                usuario = objSesion.getAttribute("usuario").toString();
                user = "<label>" + usuario + "</label>";
            } else if (objSesion.getAttribute("usuario") != null && objSesion.getAttribute("nivel") == "Administrador") {
                usuario = objSesion.getAttribute("usuario").toString();
                user = "<label>" + usuario + "</label>";
                admin = "<label>El administrador tiene acceso total a todo <br><a href='vistaAdmin.jsp' class='btn btn-primary'><span class='fa fa-eye'></span> Vista administrador</a></label>";
            } else {
                out.print("<script>location.replace('index.html');</script>");
            }
        %>
    <body>
        <header class="header">
            <div class="container logo-nav-container">

                <a href="" class="logo">
                    <img src="../img/yg-white.png" alt="" class="logo">

                </a>
                <nav class="navigation">
                    <ul>
                        
                        <li><a href="ControladorV?accion=goventas">VENTAS</a></li>
                        <li><a href="#">REPORTES</a></li>
                    </ul>
                </nav>
            </div>
        </header>
        <main>
             <center>
            <h1>Vista Operador</h1>
        <% out.print(admin); %>
        <h1>Bienvenido <% out.print(user);%></h1>
        <a href="cerrarSesion.jsp" class="boton1"> Cerrar sesion</a>    
            
            
           
                
             </center>

        </main>
        <footer class="footer"> <center>
            <div class="container">
                <p>Proyecto Desarrollo de Software MisionTIC Grupo 33 / Grupo 1</p>
            </div> </center>  
        </footer>
</body>
</html>

