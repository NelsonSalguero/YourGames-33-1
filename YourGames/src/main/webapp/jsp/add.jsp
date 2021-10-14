<%-- 
    Document   : Agregar usuarios
    Created on : 18/09/2021
    Author     : Grupo 33/1
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <link href="../css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="css/style.css" type="text/css"/>
        <link rel="stylesheet" href="css/pages.css" type="text/css"/>
        <title>Agregar Usuarios</title>
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
                         <li><a href="ControladorCSV?accion=listar">PRODUCTOS</a></li>
                        <li><a href="ControladorV?accion=goventas">VENTAS</a></li>
                        <li><a href="#">REPORTES</a></li>
                        <li><a href="ControladorC?accion=Salir">CERRAR SESION</a></li>
                        
                    </ul>
                </nav>
            </div>
        </header><center>
        <h1> AGREGAR USUARIO</h1></center>
    <div class="content">
        <form action="Controlador">
            <section>
                <div class="fields">
                    CEDULA
                    <input class="txt" type="number" name="txtCedula" required=""><br>
                    NOMBRES
                    <input class="txt" type="text" name="txtNom" required=""><br>
                    CORREO
                    <input class="txt" type="email" name="txtCorreo" required=""><br>
                    USUARIO
                    <input class="txt" type="text" name="txtUsuario" required=""><br>
                    CONTRASEÑA
                    <input class="txt" type="text" name="txtClave" required=""><br>
                    NIVEL
                    <select class="txt" name="txtNivel" id="acceso" >
                        <option value="Operador">Operador</option>
                        <option value="Administrador">Administrador</option>
                    </select><br>
                    <!--<input class="form-control" type="text" name="txtNivel"><br>-->
                    <br>
                    <!--<input class="boton2" type="submit" name="accion" value="Agregar">-->
                    <input class="boton2" type="submit" name="accion" value="Agregar" >
                   
                    <a class="boton1" href="Controlador?accion=listar">Regresar</a>
                </div> 
            </section>
        </form>
    </div>

</body>
</html>
