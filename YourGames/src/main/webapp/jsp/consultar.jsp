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
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UACompatible" content="ie=edge">
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
        </header>
        <div class="content">
            <form action="../ControladorC">
                <section class="fields">
                   
                    <input class="txt" type="number" name="txtcedulaC" id="cedula" placeholder="Cédula" required="">
                    
                    <input class="txt" type="text" name="txtnombreC" id="nombre" placeholder="Nombre completo" disabled>
                   
                    <input class="txt" type="text" name="txtDirC" id="direccion" placeholder="Dirección" disabled>
                   
                    <input class="txt" type="text" name="txtTelC" id="telefono" placeholder="Telefono" disabled>
                    
                    <input class="txt" type="email" name="txtCorreoC" id="correo" placeholder="Correo electrónico" disabled>
                    <input class="btn btn-success" type="submit" name="accion" value="Crear">
                    <input class="btn" type="submit" name="accion" value= "Consultar">
                    <input class="btn" type="submit" value="Actualizar">
                    <input class="btn" type="submit" value="Borrar">
                    
                   <a class="btn" href="clientes.jsp" >Listar</a>
                    <input class="btn" type="submit" value="Cerrar">
                </section>
            </form>
        </div><br><br>
        <div>
            <table class="tablalistar">
                <thead>
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
                            
                           <!-- <a class="boton3" href="Controlador?accion=preborrado&cedula=<%= cli.getCedulaC()%>">Eliminar</a>-->
                       <!-- </td>-->
                    </tr>
                    <%}%>
                </tbody>
            </table>

            
            
            
        </div>
    </body>

</html>
