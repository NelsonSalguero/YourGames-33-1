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
                        <li><a href="ControladorP?accion=cargarCSV">PRODUCTOS</a></li>
                        <li><a href="ControladorV?accion=goventas">VENTAS</a></li>
                        <li><a href="#">REPORTES</a></li>
                        <li><a href="ControladorC?accion=Salir">CERRAR SESION</a></li>
                        
                    </ul>
                </nav>
            </div>
        </header><center>
        <h1> MODULO CLIENTES YOUR GAMES</h1></center>
        <div class="content">
            <form action="../ControladorC">
                <section >
                    <div class="fields">
                    CÉDULA
                    <input class="txt" type="number" name="txtcedulaC" id="cedula"  >
                    NOMBRE COMPLETO
                    <input class="txt" type="text" name="txtnombreC" id="nombre"  >
                    DIRECCIÓN
                    <input class="txt" type="text" name="txtDirC" id="direccion"  >
                    TELÉFONO
                    <input class="txt" type="text" name="txtTelC" id="telefono"  >
                    CORREO ELECTRÓNICO
                    <input class="txt" type="email" name="txtCorreoC" id="correo" >
                   
                    <input class="btn btn-success " type="submit" name="accion" value="Crear" onclick="javascript:return confirmAction1()">
                        <script>
                            // The function below will start the confirmation dialog
                            function confirmAction1() {
                                let confirmAction = confirm("Desea Crear este cliente?");
                                if (confirmAction) {
                                    alert("El Cliente será Creado");
                                    return true;

                                } else {
                                    alert("Acción cancelada");
                                    return false;

                                }
                            }
                        </script> 
                    <input class="btn btn-primary" type="submit" name="accion" value="Consultar">
                    <input class="btn btn-danger" type="submit" name="accion"  value="Borrar" onclick="javascript:return confirmAction2()">
                        <script>
                        // The function below will start the confirmation dialog
                        function confirmAction2() {
                            let confirmAction = confirm("Confirma el Borrado de este Cliente?");
                            if (confirmAction) {
                                alert("El Cliente será Borrado");
                                return true;

                            } else {
                                alert("Acción cancelada");
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
    </body>

</html>
