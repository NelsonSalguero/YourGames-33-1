<%-- 
    Document   : Factura
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
        <link rel="stylesheet" href="../css/pages.css" type="text/css"/>
        <link rel="stylesheet" href="../css/style.css" type="text/css"/>
        <link href="../css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <link href="../css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="../css/bootstrap-theme.css" rel="stylesheet" type="text/css"/>
        <link href="../css/bootstrap-theme.min.css" rel="stylesheet" type="text/css"/>
        
        <title>Ventas</title>
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
                        <li class="active"><a href="ControladorV?accion=goventas">VENTAS</a></li>
                        <li><a href="#">REPORTES</a></li>
                        <li><a href="ControladorC?accion=Salir">CERRAR SESION</a></li>
                        
                    </ul>
                </nav>
            </div>
        </header>
        <h1 style="text-align: center ; color: white">REGISTRO DE VENTAS</h1>  
        <div class="d-flex">
             <form action="../ControladorV">
            <div class="col-sm-5">
               
                <div class="card text-white bg-primary mb-3">
                    <div class="card-body">
                        <div class="form-group">
                            <label>DATOS DEL CLIENTE</label>
                        </div>
                        
                        <div class="form-group d-flex">
                            <div class="col-sm-4">
                                <input type="text" name="txtCedulaF" placeholder="Cedula Cliente" class="form-control"  value="${clienteFactura.getCedulaC()}">
                            </div>
                            <div class="col-sm-2">
                                
                               <!--<a class="btn btn-primary" href="ControladorC?accion=buscarClienteF">BuscarA</a>-->
                                <button type="submit" name="accion" value="buscarClienteF" class="btn btn-primary ">Buscar</button>
                               <!--<button type="submit" onclick="window.location.href='ControladorC?accion=buscarClienteF';"  class="btn btn-primary ">BuscarClick</button>-->
                                
                            </div>
                            <div class="col-sm-6">
                                <input type="text" name="txtNombreCliente" placeholder="Nombre Cliente" class="form-control" 
                                       value="${clienteFactura.getNomC()}" readonly="">
                            </div>
                        </div>
                       
                    </div>
                    <div class="card-body">
                        
                        <div class="form-group">
                            <label>DATOS DEL PRODUCTO</label>
                        </div>
                        <div class="form-group d-flex">
                            <div class="col-sm-4">
                                <input type="text" name="txtCodigoF" placeholder="Código Producto" class="form-control"
                                       value="${productoFactura.getCodigo()}">
                            </div>
                            <div class="col-sm-2">
                                <button type="submit" name="accion" value="buscarProductoF" class="btn btn-primary">Buscar</button>
                                    
                            </div>
                            <div class="col-sm-6">
                                <input type="text" name="txtNombreProducto" placeholder="Nombre Producto" class="form-control" readonly=""
                                       value="${productoFactura.getNombre()}">
                            </div>
                        </div>
                             
                            
                        <div class="form-group">
                            <label>DIGITE LA CANTIDAD Y AGREGUE>>>></label>
                        </div>
                        <div class="form-group d-flex">
                            
                            <div class="col-sm-6">
                                 <button type="submit" name="accion" value="agregarProducto" class="btn btn-success">Agregar Producto</button>
                                
                            </div>
                            <div class="col-sm-2">
                                <input type="text" name="txtCantidad" placeholder="Cantidad" class="form-control" value="1" class="text-align: right">
                                    
                            </div>
                            <div class="col-sm-4">
                                <input type="text" name="txtPrecioVenta" placeholder="0.00" class="form-control" style="text-align: right" 
                                           value="${productoFactura.getPrecioVenta()}" readonly="">
                            </div>
                        </div>
                        
                    </div>
                    
                </div>
               
            </div> 
            <div class="col-sm-7">
                <div class="card text-white bg-primary mb-3">
                    <div class="card-header">
                        <div class="d-flex col-sm-4 ml-auto">
                            <label style="width: 20">VENTA No.</label>
                            <input type="text" name="txtNumeroFactura" class="form-control" class="text-align: right" 
                                    value="${idVenta}"  disable="">
                        </div>
                    </div>
                    <div class="card-body">
                        <div class="col-sm-12 ml-auto">
                            <table border="0" class="table table-hover">
                                <thead>
                                    
                                    <tr>
                                        <th>Nro</th>
                                        <th>CODIGO</th>
                                        <th> DESCRIPCION </th>
                                        <th>PRECIO</th>
                                        <th>CANTIDAD</th>
                                        <th>SUBTOTAL</th>
                                    </tr>
                                    
                                <tbody>
                                    <c:forEach items="${detalleVentas}" var="lista">
                                    <tr>
                                        <td>${lista.getId()}</td>
                                        <td>${lista.getIdProducto()}</td>
                                        <td>${lista.getDescripcion()}</td>
                                        <td>${lista.getPrecioventa()}</td>
                                        <td>${lista.getCantidadProducto()}</td>
                                        <td>${lista.getValorVenta()}</td>
                                    </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                            
                        </div>
                    </div>
                    <div class="card-footer">
                        <div class="form-group d-flex">
                            <table border="0" class="table">
                                <tbody>
                                    <tr>
                                        <td>
                                            <button type="submit" name="accion" value="guardarFactura" class="btn btn-success" >Generar Factura</button>
                                        </td>
                                        <td>
                                           <button type="submit" name="accion" value="cancelarFactura" class="btn btn-danger" >Cancelar Registro</button> 
                                        </td>
                                        <td>
                                            <label>Subtotal : </label>
                                        </td>
                                        <td>
                                            <input type="text" name="txtSubtotal" style="text-align: right" class="form-control" 
                                                   value="${subtotal}" placeholder="$/ 0.0000,0" size="20">
                                        </td>
                                        
                                    </tr>
                                    <tr>
                                        <td></td>
                                        <td></td>
                                        <td>
                                           <label>Valor IVA : </label> 
                                        </td>
                                        <td>
                                            <input type="text" name="txtIva" style="text-align: right" class="form-control" 
                                                   value="${totalIva}" placeholder="$/ 0.0000,0" size="20">
                                        </td>
                                        
                                    </tr>
                                    <tr>
                                        <td></td>
                                        <td></td>
                                        <td>
                                            <label>Total con IVA : </label> 
                                        </td>
                                        <td>
                                            <input type="text" name="txtTotal" style="text-align: right" class="form-control" 
                                                   value="${totalFactura}" placeholder="$/ 0.0000,0" size="20">
                                        </td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                         
                </div>
                
            </div>
            
         </form>  
        </div>

        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js" integrity="sha384-wHAiFfRlMFy6i5SRaxvfOCifBUQy1xHdJ/yoi7FRNXMRBu5WHdZYu1hA6ZOblgut" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js" integrity="sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k" crossorigin="anonymous"></script>   

    </body>
</html>
