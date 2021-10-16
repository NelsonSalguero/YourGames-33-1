package Ciclo3.Proyecto.Controlador;

import Ciclo3.Proyecto.Modelo.Cliente;
import Ciclo3.Proyecto.Modelo.DetalleVenta;
import Ciclo3.Proyecto.Modelo.Producto;
import Ciclo3.Proyecto.Modelo.Usuario;
import Ciclo3.Proyecto.Modelo.Venta;
import Ciclo3.Proyecto.ModeloDAO.ClienteDAO;
import Ciclo3.Proyecto.ModeloDAO.DetalleVentaDAO;
import Ciclo3.Proyecto.ModeloDAO.ProductoDAO;
import Ciclo3.Proyecto.ModeloDAO.VentaDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ControladorV extends HttpServlet {
     String mensaje = null;
    String aviso = null;
    String afacturar = "jsp/factura.jsp";
    String noenc = "jsp/noencontradoC.jsp";
    String faltandatos = "jsp/faltandatos.jsp";
    String vuelve="ControladorV?accion=goventas";
    Venta venta = new Venta();
    VentaDAO ventaDAO = new VentaDAO();
    Usuario usuarioVenta = new Usuario();
    int cedusuario = 0; //Cedula de quien esta loggeado
    int cedulaClienteVentas;
    Cliente clo = new Cliente();
    Producto pro = new Producto();
    DetalleVenta detalleVenta = new DetalleVenta();
    List<DetalleVenta> detalleVentas = new ArrayList<DetalleVenta>();
    DetalleVentaDAO detalleVentaDAO = new DetalleVentaDAO();
    int numeroFactura = 0;
    int codigoProductoVentas;
    int item = 0;
    String descripcion;
    double valorVenta = 0;
    int cantidad = 0;
    double precioVenta=0;
    double valorIva = 0;
    double valorTotal = 0;
    double subtotal = 0;
    double totalIva = 0;
    double totalFactura = 0;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession objSesionVentas = request.getSession();
        usuarioVenta= (Usuario)objSesionVentas.getAttribute("objusuario");
        cedusuario=usuarioVenta.getCedula();
        System.out.println("Cedula usuario traida a ventas:"+cedusuario);
        String acceso = "";
        String action = request.getParameter("accion");
        //Entra a Vista factura y trae No de factura
        if (action.equalsIgnoreCase("goventas")) {
            detalleVentas=new ArrayList<DetalleVenta>();
            numeroFactura = ventaDAO.calcularIdVenta();
            numeroFactura += 1;
            System.out.println("Num fact es:" + numeroFactura);
            request.setAttribute("idVenta", numeroFactura);
            acceso = afacturar;
            
        //Trae datos del cliente x cedula    
        } else if (action.equalsIgnoreCase("buscarClienteF")) {
            if (request.getParameter("txtCedulaF").isEmpty()){
                mensaje = null;
                aviso = "  Cliente Nulo, Reintente";
                request.setAttribute("aviso",aviso);
                request.setAttribute("mensaje",mensaje);
                acceso = afacturar;
            }else{
                System.out.println("Entro a buscar cliente");
                int id = Integer.parseInt((String) request.getParameter("txtCedulaF"));
                ClienteDAO cda = new ClienteDAO();
                Cliente cli = (Cliente) cda.listC(id);
                int control = cli.getCedulaC();
                if (control == 0) {
                    mensaje = null;
                    aviso = "  Cliente No existe en DB";
                    request.setAttribute("aviso",aviso);
                    request.setAttribute("mensaje",mensaje);
                    acceso = afacturar;
                } else {
                    //aca poner método para llevar los datos del cliente a factura
                    clo = cli;
                    System.out.println("CLIENTE ENCONTRADO= " + clo.toString());
                    request.setAttribute("idVenta", numeroFactura);
                    request.setAttribute("clienteFactura", clo);

                    acceso = afacturar;
                }
            }//Este cierra
        } else if (action.equalsIgnoreCase("buscarProductoF")) {
            if (request.getParameter("txtCodigoF").isEmpty()){
                mensaje = null;
                aviso = "  Producto Nulo, Reintente";
                request.setAttribute("aviso",aviso);
                request.setAttribute("mensaje",mensaje);
                request.setAttribute("idVenta", numeroFactura);
                request.setAttribute("clienteFactura", clo);
                acceso = afacturar;
            }else{
                System.out.println("Entro a buscar Producto");
                int id = Integer.parseInt((String) request.getParameter("txtCodigoF"));
                ProductoDAO produ = new ProductoDAO();
                Producto pp = (Producto) produ.listPro(id);
                int control = pp.getCodigo();
                if (control == 0) {
                    mensaje = null;
                    aviso = "  Producto No existe en DB";
                    request.setAttribute("aviso",aviso);
                    request.setAttribute("mensaje",mensaje);
                    request.setAttribute("idVenta", numeroFactura);
                    request.setAttribute("clienteFactura", clo);
                     request.setAttribute("detalleVentas", detalleVentas);
                    request.setAttribute("subtotal", subtotal);
                    request.setAttribute("totalIva", totalIva);
                    request.setAttribute("totalFactura", totalFactura);
                    
                    acceso = afacturar;
                } else {
//                     aca poner método para llevar los datos del producto cliente y numero a factura
                    pro = pp;
                    System.out.println("PRODUCTO ENCONTRADO= " + pro.toString());
                    System.out.println("CLIENTE ENCONTRADO= " + clo.toString());
                    request.setAttribute("clienteFactura", clo);
                    request.setAttribute("idVenta", numeroFactura);
                    request.setAttribute("productoFactura", pro);
                    request.setAttribute("detalleVentas", detalleVentas);
                    request.setAttribute("subtotal", subtotal);
                    request.setAttribute("totalIva", totalIva);
                    request.setAttribute("totalFactura", totalFactura);
                    acceso = afacturar;
                }
            }//Este cierra
            
        } else if (action.equalsIgnoreCase("agregarProducto")) {
            if (request.getParameter("txtCantidad").isEmpty()){
                cantidad=0;
            }else{
            cantidad = Integer.parseInt(request.getParameter("txtCantidad"));}
            System.out.println("Cantidad al agrgar en factura: "+cantidad);
            if (cantidad <=0 ){
                mensaje = null;
                aviso = "  Cantidad Nula o Negativa, Reintente";
                request.setAttribute("aviso",aviso);
                request.setAttribute("mensaje",mensaje);
                request.setAttribute("clienteFactura", clo);
                request.setAttribute("idVenta", numeroFactura);
                request.setAttribute("productoFactura", pro);
                //arriba los datos previamnte enviados
                //abajo los datos del lado derecho
                request.setAttribute("subtotal", subtotal);
                request.setAttribute("totalIva", totalIva);
                request.setAttribute("totalFactura", totalFactura);
                request.setAttribute("detalleVentas", detalleVentas);
                acceso = afacturar;
                
                
                } else {
                    System.out.println("Entró a agregar Producto si todo bien");
                    item += 1;
                    System.out.println("valor item=" + item);
                    numeroFactura = Integer.parseInt(request.getParameter("txtNumeroFactura"));
                    System.out.println("valor numero fact=" + numeroFactura);
                    codigoProductoVentas = Integer.parseInt(request.getParameter("txtCodigoF"));
                    descripcion = request.getParameter("txtNombreProducto");
                    System.out.println("Variables vienen num factura e item: " + numeroFactura + item);
                    precioVenta = Double.parseDouble(request.getParameter("txtPrecioVenta"));
                    cantidad = Integer.parseInt(request.getParameter("txtCantidad"));
                    valorVenta = precioVenta * cantidad;
                    valorIva = Math.round((valorVenta * pro.getIva() / 100) + 100 / 100);
                    valorTotal=valorVenta+valorIva;
                    subtotal += valorVenta;
                    totalIva += valorIva;
                    totalFactura = subtotal + totalIva;
                    detalleVenta = new DetalleVenta();
                    detalleVenta.setId(item);
                    detalleVenta.setDescripcion(descripcion);
                    detalleVenta.setIdVenta(numeroFactura);
                    detalleVenta.setIdProducto(codigoProductoVentas);
                    detalleVenta.setCantidadProducto(cantidad);
                    detalleVenta.setPrecioventa(precioVenta);
                    detalleVenta.setValorVenta(valorVenta);
                    detalleVenta.setValorIva(valorIva);
                    detalleVenta.setValorTotal(valorTotal);
                    detalleVentas.add(detalleVenta);
                    System.out.println("Arreglo detalleventas ="+detalleVentas);
                    request.setAttribute("clienteFactura", clo);
                    request.setAttribute("idVenta", numeroFactura);
                    request.setAttribute("productoFactura", pro);
                    //arriba los datos previamnte enviados
                    //abajo los datos del lado derecho
                    request.setAttribute("subtotal", subtotal);
                    request.setAttribute("totalIva", totalIva);
                    request.setAttribute("totalFactura", totalFactura);
                    request.setAttribute("detalleVentas", detalleVentas);
                    acceso = afacturar;}

        }else if (action.equalsIgnoreCase("guardarFactura")) {
            System.out.println("Entró a Guardar Factura");
            //Enviamos registro a la tabla venta
            numeroFactura = Integer.parseInt(request.getParameter("txtNumeroFactura"));
            cedulaClienteVentas=Integer.parseInt(request.getParameter("txtCedulaF"));
            //set el objeto venta
            venta.setId(numeroFactura);
            venta.setCedulaCliente(cedulaClienteVentas);
            venta.setIdUsuario(cedusuario);
            venta.setTotalVenta(subtotal);
            venta.setIvaVenta(totalIva);
            venta.setValorVenta(totalFactura);
            System.out.println("Factura a Guardar= " + venta.toString());
            //SE envia a tabla venta
            boolean crearVenta=ventaDAO.addFactura(venta);
            //Enviar registro a tabla detalleventa
               //revisamos contenido de lista  detalleventa
               for (DetalleVenta detalleVenta:detalleVentas){
                   System.out.println("Productos en Factura:  "+ detalleVenta.toString());
               }
               for (DetalleVenta detalleVenta:detalleVentas){
//                   System.out.println("Productos en Factura:  "+ detalleVenta.toString());
                   detalleVentaDAO.addDetalleVenta(detalleVenta);
               }
//           
            acceso = vuelve;

        }else if (action.equalsIgnoreCase("cancelarFactura")) {
            
           acceso=vuelve; 
            
        }
        RequestDispatcher vista = request.getRequestDispatcher(acceso);
        vista.forward(request, response);

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
