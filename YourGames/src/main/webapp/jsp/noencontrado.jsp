<%-- 
    Document   : Usuario No encontrado
    Created on : 18/09/2021
    Author     : Grupo 33/1
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es" dir="ltr">
    <head>
        <meta charset="utf-8">
        <title>Usuario No encontrado</title>
        <link rel="stylesheet" href="./css/homestyle.css" type="text/css"/>
    </head>
    <body>
        <header class="header">
            <div class="container logo-nav-container">

                <a href="" class="logo">
                    <img src="../img/yg-white.png" alt="" class="logo">

                </a>
                <nav class="navigation">
                    <ul>
                        
                        <li class="active"><a href="Controlador?accion=listar">USUARIOS</a></li>
                        <li><a href="ControladorC?accion=listar">CLIENTES</a></li>
                        <li><a href="ControladorP?accion=listar">PROVEEDORES</a></li>
                        <li><a href="ControladorP?accion=cargarCSV">PRODUCTOS</a></li>
                        <li><a href="ControladorP?accion=factura">VENTAS</a></li>
                        <li><a href="#">REPORTES</a></li>
                        <li><a href="jsp/cerrarSesion.jsp">CERRAR SESION</a></li>
                    </ul>
                </nav>
            </div>
        </header>
        <main>
    <div>
        <center>
         <h1></span><br>El usuario no se encuentra en la base de datos!!!!</h1>
      
        
        <a class="boton1" href="./Controlador?accion=listar" > Regresar</a>
        </center>
    </div>
            </main>
        <footer class="footer"><center>
        <div class="container">
            <p>Proyecto Desarrollo de Software MisionTIC Grupo 33 / Grupo 1</p>
        </div>  </center> 
    </footer>
</body>
</html>