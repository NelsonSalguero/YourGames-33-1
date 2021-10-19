<%-- 
    Document   : clientes
    Created on : 28/09/2021, 05:48:31 PM
    Author     : PORTATIL
--%>
<%@page import="Ciclo3.Proyecto.Controlador.ControladorInfor"%>
<%@page import="java.util.Iterator"%>
<%@page import="Ciclo3.Proyecto.Modelo.ReporteVentas"%>
<%@page import="java.util.List"%>
<%@page import="Ciclo3.Proyecto.ModeloDAO.VentaDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>

    <head>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="../css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="../css/style.css" type="text/css"/>
        <link rel="stylesheet" href="../css/pages.css" type="text/css"/>
        <title>Proveedores</title>
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
        </header><center>
        <h1> LISTADO DE VENTAS POR CLIENTE</h1>
        
          <form action="ControladorInfor">
                   <input type="submit" name="accion" value="Regresar" class="btn btn-success btn-lg">
          </form>
            <br/>    
       
    <div class="content2">
        <table class="table table-striped table-dark">
                <thead class="table thead-dark">
                <tr>
                    <th>CEDULA CLIENTE</th>
                    <th>NOMBRE CLIENTE</th>
                    <th>VALOR TOTAL VENTAS</th>
                </tr>
            </thead>
            <%
                double granTotal=0;              
                VentaDAO dao = new VentaDAO();
                List<ReporteVentas> list = dao.reporteVentasXCliente();
                Iterator<ReporteVentas> iter = list.iterator();
                ReporteVentas cli = null;
                while (iter.hasNext()) {
                    cli = iter.next();

            %>
            <tbody>
                <tr>
                    <td class="text-center"><%= cli.getCedulaCliente()%></td>
                    <td><%= cli.getNombreCliente()%></td>
                    <td><%= cli.getVentaT()%></td>
                    <%granTotal=granTotal+cli.getVentaT(); %>
                                        
            <%}%>
            </tbody>
        </table>
            <table class="table table-striped table-dark">
                <thead class="table thead-dark">
                <tr>
                    <th> </th>
                    <th> </th>
                    <th> </th>
                </tr>
            </thead>
           
            <tbody>
                <tr>
                    
                    <td>TOTAL DE VENTAS</td>
                    <td>   <%=granTotal%></td>
                   
                 </tr>                       
           
            </tbody>
        </table>   
    </div>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js" integrity="sha384-wHAiFfRlMFy6i5SRaxvfOCifBUQy1xHdJ/yoi7FRNXMRBu5WHdZYu1hA6ZOblgut" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js" integrity="sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k" crossorigin="anonymous"></script>   

</body>

</html>
