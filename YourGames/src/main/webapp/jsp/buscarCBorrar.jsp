<%-- 
    Document   : clientes
    Created on : 28/09/2021, 05:48:31 PM
    Author     : PORTATIL
--%>
<%@page import="Ciclo3.Proyecto.Controlador.ControladorC"%>
<%@page import="java.util.Iterator"%>
<%@page import="Ciclo3.Proyecto.Modelo.Cliente"%>
<%@page import="java.util.List"%>
<%@page import="Ciclo3.Proyecto.ModeloDAO.ClienteDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">

    <head>
        <meta charset="UTF-8">
         <link href="../css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="../css/style.css">
        <link rel="stylesheet" href="../css/pages.css">
        <title>YouGames users</title>
    </head>

    <body>
        <header>
            <div class="menu">
                <a href="log-admin.html"><img src="../img/yg-white.png" alt=""></a>
                <nav>
                    <ul>
                        <li><a href="Controlador?accion=listar">USUARIOS</a></li>
                        <li class="active"><a href="ControladorC?accion=listar">CLIENTES</a></li>
                        <li><a href="ControladorP?accion=listar">PROVEEDORES</a></li>
                        <li><a href="ControladorP?accion=cargarCSV">PRODUCTOS</a></li>
                        <li><a href="ControladorP?accion=factura">VENTAS</a></li>
                        <li><a href="#">REPORTES</a></li>
                        <li><a href="jsp/cerrarSesion.jsp">CERRAR SESION</a></li>
                    </ul>
                </nav>
            </div>
        </header>
        <div class="content">
            <form action="../ControladorC">
                <section class="fields">
                    <input class="txt" type="number" name="txtcedulaC" id="cedula" placeholder="Cédula" required="">
                    <input class="txt" type="text" name="nombreC" id="nombre" placeholder="Nombre completo" disabled>
                    <input class="txt" type="email" name="DirC" id="correo" placeholder="Dirección" disabled>
                    <input class="txt" type="text" name="TelC" id="usuario" placeholder="Telefono"disabled>
                    <input class="txt" type="password" name="CorreoC" id="contrasena" placeholder="Correo electrónico" disabled>
                    <input class="btn btn-success" type="submit" value="Crear">
                    <input class="btn" type="submit" name="accion" value= "Consultar">
                    <input class="btn" type="submit" value="Actualizar">
                    <input class="btn" type="submit" value="Borrar"><br><br>
                    
                    <input class="btn" type="submit" value="Listar">
                    <input class="btn" type="submit" value="Cerrar">
                </section>
            </form>
        </div>
    </body>

</html>
