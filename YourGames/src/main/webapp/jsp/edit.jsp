<%-- 
    Document   : Edita usuario
    Created on : 18/09/2021
    Author     : Grupo 33/1
--%>
<%@page import="Ciclo3.Proyecto.Modelo.Usuario"%>
<%@page import="Ciclo3.Proyecto.ModeloDAO.UsuarioDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="css/style.css" type="text/css"/>
        <link rel="stylesheet" href="css/pages.css" type="text/css"/>
        <title>Editar Usuario</title>
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
                        <li><a href="ControladorInfor?accion=listar">REPORTES</a></li>
                        <li><a href="ControladorC?accion=Salir">CERRAR SESION</a></li>
                        
                    </ul>
                </nav>
            </div>
        </header><center>
        <h1> CONSULTAR EDITAR USUARIO</h1>

        <%
            UsuarioDAO dao = new UsuarioDAO();
            int id = Integer.parseInt((String) request.getAttribute("idper"));
            Usuario p = (Usuario) dao.list(id);
        %>
        <h1>Modificar Usuario Con Cedula: <%= p.getCedula()%>   </h1></center>
    <div class="content">
        <form action="Controlador">
            <section>
                <div class="fields">
                NOMBRES
                <input class="txt" type="text" name="txtNom" value="<%= p.getNom()%>" required=""><br>
                CORREO
                <input class="txt" type="text" name="txtCorreo" value="<%= p.getCorreo()%>"required=""><br>
                USUARIO
                <input class="txt" type="text" name="txtUsuario" value="<%= p.getUsuario()%>"required=""><br>
                CONTRASEÑA
                <input class="txt" type="text" name="txtClave" value="<%= p.getClave()%>"required=""><br>
                NIVEL
                <select class="txt" name="txtNivel" id="acceso" value="<%= p.getTipoUsuario()%>" >
                    <option value="Operador">Operador</option>
                    <option value="Administrador">Administrador</option>
                </select><br><br>


                <input type="hidden" name="txtCedula" value="<%= p.getCedula()%>">
                <input class="boton2" type="submit" name="accion" value="Actualizar" >
                <a class="boton1"href="Controlador?accion=listar">Regresar</a>
             </div> 
            </section>
        </form>
    </div>              
</body>
</html>
