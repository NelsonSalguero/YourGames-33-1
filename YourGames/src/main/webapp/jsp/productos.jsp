<%-- 
    Document   : productos
    Created on : 3/10/2021, 07:25:58 PM
    Author     : PORTATIL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Cargue de Productos desde csv</title>
        
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="../css/style.css" type="text/css"/>
        <link rel="stylesheet" href="../css/pages.css" type="text/css"/>
        <link rel="stylesheet" href="../css/bootstrap.min.css">
        
        
        
        
        
    </head>
    <body>
       <header class="header">
            <div class="container logo-nav-container">

                <a href="" class="logo">
                    <img src="../img/yg-white.png" alt="" class="logo">

                </a>
                <nav class="navigation">
                     <ul>
                        <li><a href="Controlador?accion=listar">USUARIOS</a></li>
                        <li><a href="ControladorC?accion=listar">CLIENTES</a></li>
                        <li><a href="ControladorP?accion=listar">PROVEEDORES</a></li>
                        <li class="active"><a href="ControladorP?accion=cargarCSV">PRODUCTOS</a></li>
                        <li><a href="ControladorV?accion=goventas">VENTAS</a></li>
                        <li><a href="#">REPORTES</a></li>
                        <li><a href="ControladorC?accion=Salir">CERRAR SESION</a></li>
                        
                    </ul>
                </nav>
            </div>
        </header><br><br>
        <!--<div class="jumbotron text-center">
            <h1>Desarrollo de Software.</h1>
            <h2>Universidad El Bosque</h2>
            <p>Cargue de Datos archivos CSV a Base de Datos Spring Boot!</p>
        </div>-->
        <center>
            <h1 style="text-align: center; color: white">Carga de Productos </h1>
            <h3 style="text-align: center; color: white" >Cargue de Archivo CSV</h3>
            <br/><br/>
            <div class="row">
                <div class="col-sm-4" >
                    
                </div>
                <div class="col-sm-4">
                    <form action="ControladorCSV"  class="form-control">
                        <div class="custom-file">
                            <input type="file" name="nombre" accept=".csv" 
                                                                 class="custom-file" size="40">
                        </div>
                        <br/>
                        <input type="submit" name="accion" value="Subir Archivo" class="btn btn-primary"><br><br>
                        <input type="submit" name="accion" value="Ver Productos en DB" class="btn btn-success"><br/>
                    </form>
                </div>
            </div>
        </center>
         <br/><br/>
        <footer class="text-center">
            <p></p>
        </footer>
    </body>
</html>
