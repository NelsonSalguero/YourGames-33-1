<%-- 
    Document   : Buscar por Cedula
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
        <link rel="stylesheet" href="css/style.css" type="text/css"/>
        <link rel="stylesheet" href="css/pages.css" type="text/css"/>
        <title>Buscar Usuario</title>
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
            Usuario p = (Usuario) dao.list(id);;


        %>
        <h1>Consultando Usuario Con Cedula: <%= p.getCedula()%>   </h1></center>
    <div class="content">
        <form action="Controlador">
            <section>
                <div class="fields">
                    NOMBRES
                    <input class="txt" type="text" name="txtNom" value="<%= p.getNom()%>" required=""><br>
                    CORREO
                    <input class="txt" type="text" name="txtCorreo" value="<%= p.getCorreo()%>" required=""><br>
                    USUARIO
                    <input class="txt" type="text" name="txtUsuario" value="<%= p.getUsuario()%>" required=""><br>
                    CONTRASEÑA
                    <input class="txt" type="text" name="txtClave" value="<%= p.getClave()%>" required=""><br>
                    NIVEL
                    <input class="txt" type="text" name="txtNivel" value="<%= p.getTipoUsuario()%>" required=""><br>
                        <!--<select class="form-control" name="txtNivel" id="acceso" value="<%= p.getTipoUsuario()%>" >
                            <option value="Operador">Operador</option>
                            <option value="Administrador">Administrador</option>-->
                    <br><br>


                    <input type="hidden" name="txtCedula" value="<%= p.getCedula()%>">
                    <a class="boton2" href="Controlador?accion=editar&cedula=<%= p.getCedula()%>">Editar</a>
                    <a class="boton3" href="Controlador?accion=eliminar&cedula=<%= p.getCedula()%>"  onclick="javascript:return confirmAction()">Eliminar</a>
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

                    <a class="boton1" href="Controlador?accion=listar">Regresar</a>
                </div> 
            </section>
        </form>
    </div>              
</body>
</html>
