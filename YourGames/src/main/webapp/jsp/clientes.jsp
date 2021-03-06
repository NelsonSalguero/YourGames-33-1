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
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="es">

    <head>
        <meta charset="UTF-8">
        <link href="../css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="css/style.css" type="text/css"/>
        <link rel="stylesheet" href="css/pages.css" type="text/css"/>
        <title>YourGames Clientes</title>
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
                        <li class="active"><a href="ControladorC?accion=listar">CLIENTES</a></li>
                        <li><a href="ControladorP?accion=listar">PROVEEDORES</a></li>
                        <li><a href="ControladorCSV?accion=listar">PRODUCTOS</a></li>
                        <li><a href="ControladorV?accion=goventas">VENTAS</a></li>
                        <li><a href="ControladorInfor?accion=listar">REPORTES</a></li>
                        <li><a href="ControladorC?accion=Salir">CERRAR SESION</a></li>
                        
                    </ul>
                </nav>
            </div>
        </header><center>
        <h1> MODULO CLIENTES YOUR GAMES</h1>
            <div class="mensaje">
                    <c:if test="${mensaje != null}" >
                        <div class="alert alert-success alert-dismissible">
                            <button type="button" class="close" data-dismiss="alert">&times;</button>
                            <strong>Resultado!</strong>${mensaje}
                        </div>
                    </c:if>
                    <c:if test="${aviso != null}" >
                        <div class="alert alert-danger alert-dismissible">
                            <button type="button" class="close" data-dismiss="alert">&times;</button>
                            <strong>Error:</strong>${aviso}
                        </div>
                    </c:if>  

                </div></center>
        <div class="content">
            <form action="../ControladorC">
                <section >
                    <div class="fields">
                    C??DULA
                    <input class="txt" type="number" name="txtcedulaC" id="cedula"  >
                    NOMBRE COMPLETO
                    <input class="txt" type="text" name="txtnombreC" id="nombre"  >
                    DIRECCI??N
                    <input class="txt" type="text" name="txtDirC" id="direccion"  >
                    TEL??FONO
                    <input class="txt" type="text" name="txtTelC" id="telefono"  >
                    CORREO ELECTR??NICO
                    <input class="txt" type="email" name="txtCorreoC" id="correo" >
                   
                    <input class="btn btn-success " type="submit" name="accion" value="Crear" >
                    <input class="btn btn-primary" type="submit" name="accion" value="Consultar">
                    <input class="btn btn-danger" type="submit" name="accion"  value="Borrar" onclick="javascript:return confirmAction2()">
                        <script>
                        // The function below will start the confirmation dialog
                        function confirmAction2() {
                            let confirmAction = confirm("Confirma el Borrado de este Cliente?");
                            if (confirmAction) {
                                alert("El Cliente ser?? Borrado");
                                return true;

                            } else {
                                alert("Acci??n cancelada");
                                return false;

                            }
                        }
                    </script> 
                   <input class="btn btn-secondary" type="submit" name="accion" value="Cancelar">
                    </div>
                </section>
            </form>
        </div><br><br>
        <div class="content2">
            <table class="table table-striped table-dark">
                <thead class="table thead-dark">
                    <tr>
                        <th>CEDULA</th>
                        <th>NOMBRES</th>
                        <th>DIRECCION</th>
                        <th>TELEFONO</th>
                        <th>CORREO</th>
                        <!--<th>NIVEL</th>
                        <th>ACCIONES</th>-->
                    </tr>
                </thead>
                <%
                    ClienteDAO dao = new ClienteDAO();
                    List<Cliente> list = dao.listarC();
                    Iterator<Cliente> iter = list.iterator();
                    Cliente cli = null;
                    while (iter.hasNext()) {
                        cli = iter.next();

                %>
                <tbody>
                    <tr>
                        <td class="text-center"><%= cli.getCedulaC()%></td>
                        <td><%= cli.getNomC()%></td>
                        <td><%= cli.getDireccionC()%></td>
                        <td><%= cli.getTelefC()%></td>
                        <td><%= cli.getCorreoC()%></td>
                        
                        <!--<td class="text-center">-->
                            <!--<a class="boton1" href="Controlador?accion=editar&cedula=<%= cli.getCedulaC()%>">Editar</a>-->
                           <!-- <a class="boton3" href="Controlador?accion=eliminar&cedula=<%= cli.getCedulaC()%>">Eliminar</a>-->
                           <!-- <a class="boton3" href="Controlador?accion=eliminar&cedula=<%= cli.getCedulaC()%>"  onclick="javascript:return confirmAction()">Eliminar</a>-->
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
                       <%}%>
                </tbody>
            </table>
     
        </div>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js" integrity="sha384-wHAiFfRlMFy6i5SRaxvfOCifBUQy1xHdJ/yoi7FRNXMRBu5WHdZYu1hA6ZOblgut" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js" integrity="sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k" crossorigin="anonymous"></script>   
            
    </body>

</html>
