<%-- 
    Document   : vistaAdmin
    Created on : 18/09/2021
    Author     : Grupo 33/1
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es" 
    <head>
        <meta charset="utf-8">
        <title>Vista Admin</title>
        <link href="../css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="/css/style.css" type="text/css"/>
        <link rel="stylesheet" href="/css/pages.css" type="text/css"/>
    </head>
         <%
        String user = "";
        HttpSession objSesion = request.getSession();
        String usuario;
        if (objSesion.getAttribute("usuario") != null && objSesion.getAttribute("nivel") == "Administrador") {
            usuario = objSesion.getAttribute("usuario").toString();
            user = "<label>" + usuario + "</label>";
        } else if (objSesion.getAttribute("usuario") != null && objSesion.getAttribute("nivel") == "Operador") {
            out.print("<script>location.replace('vistaCliente.jsp');</script>");
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
                        <li><a href="../Controlador?accion=listar">USUARIOS</a></li>
                        <li><a href="../ControladorC?accion=listar">CLIENTES</a></li>
                        <li><a href="../ControladorP?accion=listar">PROVEEDORES</a></li>
                        <li><a href="../ControladorCSV?accion=listar">PRODUCTOS</a></li>
                        <li><a href="../ControladorV?accion=goventas">VENTAS</a></li>
                        <li><a href="#">REPORTES</a></li>
                        <li><a href="../ControladorC?accion=Salir">CERRAR SESION</a></li>
                        
                    </ul>
                </nav>
            </div>
        </header>
        <main>
    <div>
        <center>
        <h1>Vista Administrador</h1>
        <h1>Bienvenido : <% out.print(user);%></h1><br>
        <br>
           
        </center>

    </div>
        </main>
    <footer class="footer">
        
        <div>
            <center>
            <p>Proyecto Desarrollo de Software MisionTIC Grupo 33 / Grupo 1</p>
            </center>
        </div>   
    </footer>
</body>
</html>

