<%-- 
    Document   : Listar Usuarios
    Created on : 18/09/2021
    Author     : Grupo 33/1
--%>

<%@page import="Ciclo3.Proyecto.Controlador.Controlador"%>
<%@page import="java.util.Iterator"%>
<%@page import="Ciclo3.Proyecto.Modelo.Usuario"%>
<%@page import="java.util.List"%>
<%@page import="Ciclo3.Proyecto.ModeloDAO.UsuarioDAO"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="../css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="../css/style.css" type="text/css"/>
        <link rel="stylesheet" href="../css/pages.css" type="text/css"/>
        
        <title>Lista Usuarios</title>
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
        </header><br>
    <center>
        <div class="">
            <h1>Administrador de Usuarios YourGames</h1>
            <br>
            <a class="btn btn-success" href="Controlador?accion=add">Agregar Nuevo</a>
           
            
            <br> <br>
            <div class="fields">
                <form action="Controlador">
                    <input class="field" type="number" name="txtBuscar" required="" >
                    <input class="btn btn-primary" type="submit" name="accion" value="Buscar">

                </form>
              
            </div>
            <br>
            <div class="content2">
            <table class="table table-striped table-dark">
                <thead class="table thead-dark">
                    <tr>
                        <th>CEDULA</th>
                        <th>NOMBRES</th>
                        <th>CORREO</th>
                        <th>USUARIO</th>
                        <th>CLAVE</th>
                        <th>NIVEL</th>
                        <th>ACCIONES</th>
                    </tr>
                </thead>
                <%
                    UsuarioDAO dao = new UsuarioDAO();
                    List<Usuario> list = dao.listar();
                    Iterator<Usuario> iter = list.iterator();
                    Usuario per = null;
                    while (iter.hasNext()) {
                        per = iter.next();

                %>
                <tbody>
                    <tr>
                        <td class="text-center"><%= per.getCedula()%></td>
                        <td><%= per.getNom()%></td>
                        <td><%= per.getCorreo()%></td>
                        <td><%= per.getUsuario()%></td>
                        <td><%= per.getClave()%></td>
                        <td><%= per.getTipoUsuario()%></td>
                        <td class="text-center">
                            <a class="btn btn-warning" href="Controlador?accion=editar&cedula=<%= per.getCedula()%>">Editar</a>
                            <a class="btn btn-danger" href="Controlador?accion=eliminar&cedula=<%= per.getCedula()%>"  onclick="javascript:return confirmAction()">Eliminar</a>
                    <script>
                        // The function below will start the confirmation dialog
                        function confirmAction() {
                            let confirmAction = confirm("Confirma el Borrado de este usuario?");
                            if (confirmAction) {
                                alert("Datos el Usuario Borrados");
                                return true;

                            } else {
                                alert("Action canceled");
                                return false;

                            }
                        }
                    </script> 
                           
                        </td>
                    </tr>
                    <%}%>
                </tbody>
            </table>
            </div>
        </div></center>
    </body>
</html>
