package Ciclo3.Proyecto.Controlador;

import Ciclo3.Proyecto.Modelo.Cliente;
import Ciclo3.Proyecto.Modelo.DetalleVenta;
import Ciclo3.Proyecto.Modelo.Producto;
import Ciclo3.Proyecto.Modelo.Venta;
import Ciclo3.Proyecto.ModeloDAO.ClienteDAO;
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

public class ControladorV extends HttpServlet {

    String afacturar = "jsp/factura.jsp";
    String noenc = "jsp/noencontradoC.jsp";
    String faltandatos = "jsp/faltandatos.jsp";
    Venta venta = new Venta();
    VentaDAO ventaDAO = new VentaDAO();

    Cliente clo = new Cliente();
    Producto pro = new Producto();
    DetalleVenta detalleVenta = new DetalleVenta();
    List<DetalleVenta> detalleVentas = new ArrayList<DetalleVenta>();
    int numeroFactura = 0;
    int codigoProductoVentas;
    int item = 0;
    String descripcion;
    double valorVenta = 0;
    int cantidad = 0;
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
        String acceso = "";
        String action = request.getParameter("accion");
        if (action.equalsIgnoreCase("goventas")) {
            numeroFactura = ventaDAO.calcularIdVenta();
            numeroFactura += 1;
            System.out.println("Num fact es:" + numeroFactura);
            request.setAttribute("idVenta", numeroFactura);
            acceso = afacturar;
        } else if (action.equalsIgnoreCase("buscarClienteF")) {

            System.out.println("Entro a buscar cliente");
            String concedula = request.getParameter("txtCedulaF");
            System.out.println("concedula=" + concedula);
            if (concedula != "") {
                request.setAttribute("idper", request.getParameter("txtCedulaF"));
                int id = Integer.parseInt((String) request.getAttribute("idper"));
                ClienteDAO cda = new ClienteDAO();
                Cliente cli = (Cliente) cda.listC(id);
                int control = cli.getCedulaC();
                if (control == 0) {
                    acceso = noenc;
                } else {
                    //aca poner método para llevar los datos del cliente a factura
                    clo = cli;
                    System.out.println("CLIENTE ENCONTRADO= " + clo.toString());
                    request.setAttribute("idVenta", numeroFactura);
                    request.setAttribute("clienteFactura", clo);

                    acceso = afacturar;
                }
            } else {
                acceso = faltandatos;
            }
        } else if (action.equalsIgnoreCase("buscarProductoF")) {

            System.out.println("Entro a buscar Producto");
            String concedula = request.getParameter("txtCodigoF");
            System.out.println("concedula=" + concedula);
            if (concedula != "") {
                request.setAttribute("idper", request.getParameter("txtCodigoF"));
                int id = Integer.parseInt((String) request.getAttribute("idper"));
                ProductoDAO produ = new ProductoDAO();
                Producto pp = (Producto) produ.listPro(id);
                int control = pp.getCodigo();
                if (control == 0) {
                    acceso = noenc;
                } else {
                    //aca poner método para llevar los datos del producto cliente y numero a factura
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
            } else {
                acceso = faltandatos;
            }
        } else if (action.equalsIgnoreCase("agregarProducto")) {
            System.out.println("Entró a agregar Producto");
            item += 1;
            System.out.println("valor item=" + item);
            numeroFactura = Integer.parseInt(request.getParameter("txtNumeroFactura"));
            System.out.println("valor numero fact=" + numeroFactura);
            codigoProductoVentas = Integer.parseInt(request.getParameter("txtCodigoF"));
            descripcion = request.getParameter("txtNombreProducto");
            System.out.println("Variables vienen num factura e item: " + numeroFactura + item);
            valorVenta = Double.parseDouble(request.getParameter("txtPrecioVenta"));
            cantidad = Integer.parseInt(request.getParameter("txtCantidad"));
            valorTotal = valorVenta * cantidad;
            valorIva = Math.round((valorTotal * pro.getIva() / 100) + 100 / 100);
            subtotal += valorTotal;
            totalIva += valorIva;
            totalFactura = subtotal + totalIva;
            detalleVenta = new DetalleVenta();
            detalleVenta.setId(item);
            detalleVenta.setDescripcion(descripcion);
            detalleVenta.setIdVenta(numeroFactura);
            detalleVenta.setIdProducto(codigoProductoVentas);
            detalleVenta.setCantidadProducto(cantidad);
            detalleVenta.setPrecioventa(valorVenta);
            detalleVenta.setValorVenta(valorTotal);
            detalleVenta.setValorIva(valorIva);
            detalleVentas.add(detalleVenta);
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
