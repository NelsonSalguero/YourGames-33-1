<%-- 
    Document   : mensaje faltan datos
    Created on : 18/09/2021
    Author     : Grupo 33/1
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es" dir="ltr">
    <head>
        <meta charset="utf-8">
        <title>FALTAN DATOS</title>
        <link rel="stylesheet" href="/css/style.css" type="text/css"/>
        <link rel="stylesheet" href="/css/pages.css" type="text/css"/>
    </head>
    <body>
          <header class="header">
            <div class="menu">
                <a href="log-admin.html"><img src="../img/yg-white.png" alt=""></a>
                <nav>
                     <ul>
                        <li><a href="Controlador?accion=listar">USUARIOS</a></li>
                        <li><a href="ControladorC?accion=listar">CLIENTES</a></li>
                        <li class="active"><a href="ControladorP?accion=listar">PROVEEDORES</a></li>
                       <li><a href="ControladorCSV?accion=listar">PRODUCTOS</a></li>
                        <li><a href="ControladorV?accion=goventas">VENTAS</a></li>
                        <li><a href="#">REPORTES</a></li>
                        <li><a href="ControladorC?accion=Salir">CERRAR SESION</a></li>
                        
                    </ul>
                </nav>
            </div>
        </header>
        <main><center><br>
    <div class="caja">
        <center>
         <h1></span><br>!!!FALTAN DATOS!!!!</h1>
         <h1></span><br>>>>Operación Cancelada<<<</h1>
      <br><br><br>
        <!--<a class="boton1" href="jsp/add.jsp" > Regresar</a>-->
        <a class="btn" href="../ControladorP?accion=listar" > Regresar</a>
        </center>
    </div>
            </center>
            </main><br><br>
        <footer class="footer"><center>
        <div class="container">
            <p>Proyecto Desarrollo de Software MisionTIC Grupo 33 / Grupo 1</p>
        </div>  </center> 
    </footer>
</body>
</html>