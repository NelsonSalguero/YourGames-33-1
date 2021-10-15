<%-- 
    Document   : VistaCarProd
    Created on : 3/10/2021, 10:32:46 PM
    Author     : PORTATIL
--%>

<%@page import="java.util.Iterator"%>
<%@page import="Ciclo3.Proyecto.Modelo.Producto"%>
<%@page import="java.util.List"%>
<%@page import="Ciclo3.Proyecto.ModeloDAO.ProductoDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <link rel="stylesheet" href="../css/bootstrap.min.css">
        <link rel="stylesheet" href="../css/style.css" type="text/css"/>
        <link rel="stylesheet" href="../css/pages.css" type="text/css"/>
        <title>Vista Productos Cargados</title>
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
                        <li class="active"><a href="ControladorCSV?accion=listar">PRODUCTOS</a></li>
                        <li><a href="ControladorV?accion=goventas">VENTAS</a></li>
                        <li><a href="ControladorInfor?accion=listar">REPORTES</a></li>
                        <li><a href="ControladorC?accion=Salir">CERRAR SESION</a></li>

                    </ul>
                </nav>
            </div>
        </header><center>

        <h1 style="text-align: center; color: white">CARGA DE PRODUCTOS</h1>

        <div class="container-fluid">
            <div class="row">
                <h1 style="text-align: center; color: white">Listado de Productos</h1>
                <h3 style="text-align: center; color: white">Contenido de Lista subido desde CSV</h3>
                <form action="ControladorCSV">
                   <br>
                    <input type="submit" name="accion" value="Regresar" class="btn btn-success"><br/>
                </form>

                <br/><br/>
                <div class="col-sm-2">
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
                </div>
                <div class="col-sm-8">
                    <div class="content2">
                        <table class="table table-dark">
                            <thead class="table thead-dark">
                                <tr>
                                    <th>CODIGO</th>
                                    <th>NOMBRE</th>
                                    <th>PROVEEDOR</th>
                                    <th>PRECIO COMPRA</th>
                                    <th>IVA</th>
                                    <th>PRECIO VENTA</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${productos}" var="pro">
                                    <tr>
                                        <td>${pro.codigo}</td>
                                        <td>${pro.nombre}</td>
                                        <td>${pro.nitProveedor}</td>
                                        <td>${pro.precioCompra}</td>
                                        <td>${pro.iva}</td>
                                        <td>${pro.precioVenta}</td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>

                    </div>   
                </div>

            </div>


    </center>

    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js" integrity="sha384-wHAiFfRlMFy6i5SRaxvfOCifBUQy1xHdJ/yoi7FRNXMRBu5WHdZYu1hA6ZOblgut" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js" integrity="sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k" crossorigin="anonymous"></script>   

</body>
</html>
