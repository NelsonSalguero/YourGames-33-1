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
        <title>No encontrado</title>
        <link rel="stylesheet" href="/css/style.css" type="text/css"/>
        <link rel="stylesheet" href="/css/pages.css" type="text/css"/>
    </head>
    <body>
        <header class="header">
            <div class="menu">
                <a href="log-admin.html"><img src="../img/yg-white.png" alt=""></a>
                <nav>
                    <ul>
                        <li ><a href="../Controlador?accion=listar">Usuarios</a></li>
                        <li class="active"><a href="../ControladorC?accion=listar">Clientes</a></li>
                        <li><a href="#">Proveedores</a></li>
                        <li><a href="#">Productos</a></li>
                        <li><a href="../ControladorP?accion=factura">VENTAS</a></li>
                        <li><a href="#">Reportes</a></li>
                    </ul>
                </nav>
            </div>
        </header>
        <main><center><br>
    <div class="caja">
        <center>
         <h1></span><br>!!No se encuentra en la base de datos!!!!</h1>
         <h1></span><br>>>>Operación Cancelada<<<</h1>
          <br><br><br>
        
        <a class="btn" href="ControladorC?accion=listar" > Regresar</a>
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