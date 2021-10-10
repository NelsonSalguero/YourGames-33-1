<%-- 
    Document   : clientes
    Created on : 28/09/2021, 05:48:31 PM
    Author     : PORTATIL
--%>
<%@page import="Ciclo3.Proyecto.Controlador.ControladorP"%>
<%@page import="java.util.Iterator"%>
<%@page import="Ciclo3.Proyecto.Modelo.Proveedor"%>
<%@page import="java.util.List"%>
<%@page import="Ciclo3.Proyecto.ModeloDAO.ProveedorDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <body>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UACompatible" content="ie=edge">
        <link href="../css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="../css/style.css">
        <link rel="stylesheet" href="../css/pages.css">
        <title>YouGames users</title>
    </head>
    <header class="header">
        <div class="container logo-nav-container">

            <a href="" class="logo">
                <img src="../img/yg-white.png" alt="" class="logo">

            </a>
            <nav class="navigation">
                <ul>
                    <li><a href="Controlador?accion=listar">USUARIOS</a></li>
                    <li><a href="ControladorC?accion=listar">CLIENTES</a></li>
                    <li class="active"><a href="ControladorP?accion=listar">PROVEEDORES</a></li>
                    <li><a href="ControladorP?accion=cargarCSV">PRODUCTOS</a></li>
                    <li><a href="../ControladorP?accion=factura">VENTAS</a></li>
                    <li><a href="#">REPORTES</a></li>
                    <li><a href="jsp/cerrarSesion.jsp">CERRAR SESION</a></li>

                </ul>
            </nav>
        </div>
    </header>

    <center>
        <h1> MODULO PROVEEDORES YOUR GAMES</h1></center>
        <%
            ProveedorDAO pdao = new ProveedorDAO();
            int id = Integer.parseInt((String) request.getAttribute("idper"));
            Proveedor p = (Proveedor) pdao.listP(id);
        %>

    <div class="content">
        <form action="ControladorP">
            <section> 
                <div class="fields">
                    CÉDULA
                    <input class="txt" type="number" name="txtNit" value="<%= p.getNit()%>" >
                    NOMBRE COMPLETO
                    <input class="txt" type="text" name="txtnombreP"   value="<%= p.getNomP()%>" >
                    DIRECCIÓN
                    <input class="txt" type="text" name="txtDirP" value="<%= p.getDireccionP()%>" >
                    TELÉFONO
                    <input class="txt" type="text" name="txtTelP" value="<%= p.getTelefP()%>"  >
                    CORREO ELECTRÓNICO
                    <input class="txt" type="text" name="txtCiudad" value="<%= p.getCiudad()%>" >

                    <input class="btn btn-success" type="submit" name="accion" value="Crear" onclick="javascript:return confirmAction3()">
                    <script>
                        // The function below will start the confirmation dialog
                        function confirmAction3() {
                            let confirmAction = confirm("Desea Crear este Proveedor?");
                            if (confirmAction) {
                                alert("El Proveedor será Creado");
                                return true;

                            } else {
                                alert("Acción cancelada");
                                return false;

                            }
                        }
                    </script> 
                    <input class="btn btn-primary" type="submit" name="accion" value= "Consultar">
                    <input class="btn btn-warning" type="submit" name="accion"   value="Actualizar">
                    <input class="btn btn-danger" type="submit" name="accion" value="Borrar"onclick="javascript:return confirmAction4()">
                    <script>
                        // The function below will start the confirmation dialog
                        function confirmAction4() {
                            let confirmAction = confirm("Confirma el Borrado de este Cliente?");
                            if (confirmAction) {
                                alert("Datos del Cliente serán Borrados");
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
    </div><br>
    <div class="content2">
        <table class="table table-striped table-dark">
                <thead class="table thead-dark">
                <tr>
                    <th>NIT</th>
                    <th>NOMBRE</th>
                    <th>DIRECCION</th>
                    <th>TELEFONO</th>
                    <th>CIUDAD</th>
                    <!--<th>NIVEL</th>
                    <th>ACCIONES</th>-->
                </tr>
            </thead>
            <%
                ProveedorDAO dao = new ProveedorDAO();
                List<Proveedor> list = dao.listarP();
                Iterator<Proveedor> iter = list.iterator();
                Proveedor cli = null;
                while (iter.hasNext()) {
                    cli = iter.next();

            %>
            <tbody>
                <tr>
                    <td class="text-center"><%= cli.getNit()%></td>
                    <td><%= cli.getNomP()%></td>
                    <td><%= cli.getDireccionP()%></td>
                    <td><%= cli.getTelefP()%></td>
                    <td><%= cli.getCiudad()%></td>

                </tr>
                <%}%>
            </tbody>
        </table>




    </div>

</body>

</html>
