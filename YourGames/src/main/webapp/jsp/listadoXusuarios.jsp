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
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
                        <li><a href="Controlador?accion=listar">USUARIOS</a></li>
                        <li><a href="ControladorC?accion=listar">CLIENTES</a></li>
                        <li><a href="ControladorP?accion=listar">PROVEEDORES</a></li>
                       <li><a href="ControladorCSV?accion=listar">PRODUCTOS</a></li>
                        <li><a href="ControladorV?accion=goventas">VENTAS</a></li>
                        <li class="active"><a href="ControladorInfor?accion=listar">REPORTES</a></li>
                        <li><a href="ControladorC?accion=Salir">CERRAR SESION</a></li>
                        
                    </ul>
                </nav>
            </div>
        </header>
    <center>
        <div class="">
            <h1>LISTADO DE USUARIOS</h1>
            <form action="ControladorInfor">
                   <input type="submit" name="accion" value="Regresar" class="btn btn-success btn-lg">
            </form>
            <br/> 
            
            <div class="content2">
            <table class="table table-striped table-dark">
                <thead class="table thead-dark">
                    <tr>
                        <th>CEDULA</th>
                        <th>NOMBRES</th>
                        <th>CORREO ELECTRONICO</th>
                        <th>USUARIO</th>
                        <th>PASSWORD</th>
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
                    </tr>
                    <%}%>
                </tbody>
            </table>
            </div>
        </div></center>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js" integrity="sha384-wHAiFfRlMFy6i5SRaxvfOCifBUQy1xHdJ/yoi7FRNXMRBu5WHdZYu1hA6ZOblgut" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js" integrity="sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k" crossorigin="anonymous"></script>   

    </body>
</html>
