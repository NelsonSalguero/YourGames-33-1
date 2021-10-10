package Ciclo3.Proyecto.Controlador;

import Ciclo3.Proyecto.Modelo.Proveedor;
import Ciclo3.Proyecto.ModeloDAO.ProveedorDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author PORTATIL
 */
public class ControladorP extends HttpServlet {

    String noenc = "jsp/noencontradoP.jsp";
    String edit = "jsp/editP.jsp";
    String listarP = "jsp/proveedores.jsp";
    String faltandatos = "jsp/faltandatosP.jsp";
    String cerrar = "jsp/cerrarSesion.jsp";
    String cargarCSV="jsp/productos.jsp";
    String factura="jsp/factura.jsp";
    Proveedor p = new Proveedor();
    ProveedorDAO pdao = new ProveedorDAO();
    int nit;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
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
//        processRequest(request, response);
        String acceso = "";
        String action = request.getParameter("accion");
        if (action.equalsIgnoreCase("listar")) {
            acceso = listarP;
        } else if (action.equalsIgnoreCase("Crear")) {
            String nid = request.getParameter("txtNit");
            String nom = request.getParameter("txtnombreP");
            String direccion = request.getParameter("txtDirP");
            String tel = request.getParameter("txtTelP");
            String ciudad = request.getParameter("txtCiudad");
//            if (nid.length() != 0)
            if (nid != "" & nom != "" & direccion != "" & tel != "" & ciudad != "") {
                int ida = Integer.parseInt(nid);
                p.setNit(ida);
                p.setNomP(nom);
                p.setDireccionP(direccion);
                p.setTelefP(tel);
                p.setCiudad(ciudad);
                pdao.addP(p);
                acceso = listarP;

            } else {
                acceso = faltandatos;

            }
        } else if (action.equalsIgnoreCase("Consultar")) {
            String concedula = request.getParameter("txtNit");
            if (concedula != "") {
                request.setAttribute("idper", request.getParameter("txtNit"));
                ProveedorDAO clo = new ProveedorDAO();
                int id = Integer.parseInt((String) request.getAttribute("idper"));
                Proveedor p = (Proveedor) clo.listP(id);
                int control = p.getNit();
                if (control == 0) {
                    acceso = noenc;
                } else {
//                acceso = edit;
                    acceso = edit;
                }
            } else {
                acceso = faltandatos;
            }

        } else if (action.equalsIgnoreCase("Editar")) {

            request.setAttribute("idper", request.getParameter("txtNit"));
            acceso = edit;

        } else if (action.equalsIgnoreCase("Actualizar")) {
            nit = Integer.parseInt(request.getParameter("txtNit"));
            String nom = request.getParameter("txtnombreP");
            String direccion = request.getParameter("txtDirP");
            String telefono = request.getParameter("txtTelP");
            String ciudad = request.getParameter("txtCiudad");
            if (nit != 0 & nom != "" & direccion != "" & telefono != "" & ciudad != "") {
                p.setNit(nit); 
                p.setNomP(nom);
                p.setDireccionP(direccion);
                p.setTelefP(telefono);
                p.setCiudad(ciudad);
                pdao.editP(p);
                acceso = listarP;
            } else {
                acceso = faltandatos;
            }

        } else if (action.equalsIgnoreCase("Borrar")) {
            String concedula = request.getParameter("txtNit");
            if (concedula != "") {
                request.setAttribute("idper", request.getParameter("txtNit"));
                ProveedorDAO clo = new ProveedorDAO();
                int id = Integer.parseInt((String) request.getAttribute("idper"));
                Proveedor p = (Proveedor) clo.listP(id);;
                int control = p.getNit();
                if (control == 0) {
                    acceso = noenc;
                } else {
                    nit = Integer.parseInt(request.getParameter("txtNit"));
                    p.setNit(nit);
                    pdao.eliminarP(nit) ;
                    acceso = listarP;
                }
            } else {
                acceso = faltandatos;
            }
        } else if (action.equalsIgnoreCase("Limpiar")) {
            acceso = listarP;
        } else if (action.equalsIgnoreCase("Cancelar")) {
            acceso = listarP;
        } else if (action.equalsIgnoreCase("Salir")) {
            acceso = cerrar;
        } else if (action.equalsIgnoreCase("CargarCSV")) {
            acceso = cargarCSV;
        } else if (action.equalsIgnoreCase("Factura")) {
            acceso = factura;
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
        processRequest(request, response);
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
