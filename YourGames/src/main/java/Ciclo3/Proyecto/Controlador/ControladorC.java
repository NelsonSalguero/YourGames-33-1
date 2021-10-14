package Ciclo3.Proyecto.Controlador;

import Ciclo3.Proyecto.Modelo.Cliente;
import Ciclo3.Proyecto.ModeloDAO.ClienteDAO;
import Ciclo3.Proyecto.ModeloDAO.ProductoDAO;
import Ciclo3.Proyecto.Modelo.Producto;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ControladorC extends HttpServlet {
    String mensaje = null;
    String aviso = null;
    String edit = "jsp/editC.jsp";
    String listarC = "jsp/clientes.jsp";
    String cerrar = "jsp/cerrarSesion.jsp";
    Cliente c = new Cliente();
    ClienteDAO cdao = new ClienteDAO();
    int cedulac;

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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ControladorC</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControladorC at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
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
        if (action.equalsIgnoreCase("listar")) {
            acceso = listarC;
        } else if (action.equalsIgnoreCase("Crear")) {
            String nid = request.getParameter("txtcedulaC");
            String nom = request.getParameter("txtnombreC");
            String direccion = request.getParameter("txtDirC");
            String tel = request.getParameter("txtTelC");
            String correo = request.getParameter("txtCorreoC");
//            if (nid.length() != 0)
            if (nid != "" & nom != "" & direccion != "" & tel != "" & correo != "") {
                int ida = Integer.parseInt(nid);
                c.setCedulaC(ida);
                c.setNomC(nom);
                c.setDireccionC(direccion);
                c.setTelefC(tel);
                c.setCorreoC(correo);
                cdao.addC(c);
                mensaje = "---Cliente Creado---- ";
                aviso = null; 
                request.setAttribute("aviso",aviso);
                request.setAttribute("mensaje",mensaje);
                
                acceso = listarC;

            } else {
                mensaje = null;
                aviso = "---Faltan Datos del Cliente---- "; 
                request.setAttribute("aviso",aviso);
                request.setAttribute("mensaje",mensaje);
                acceso = listarC;
                  
            }
        } else if (action.equalsIgnoreCase("Consultar")) {
            String concedula = request.getParameter("txtcedulaC");
            if (concedula != "") {
                request.setAttribute("idper", request.getParameter("txtcedulaC"));
                ClienteDAO clo = new ClienteDAO();
                int id = Integer.parseInt((String) request.getAttribute("idper"));
                Cliente c = (Cliente) clo.listC(id);;
                int control = c.getCedulaC();
                if (control == 0) {
                    mensaje = null;
                    aviso = "---Cliente Inexistente---- "; 
                    request.setAttribute("aviso",aviso);
                    request.setAttribute("mensaje",mensaje);
                    acceso = listarC;
                } else {
                    acceso = edit;
                }
            } else {
                mensaje = null;
                 aviso = "---Faltan Datos del Cliente---- "; 
                 request.setAttribute("aviso",aviso);
                 request.setAttribute("mensaje",mensaje);
                 acceso = listarC;
            }
        }  else if (action.equalsIgnoreCase("Editar")) {

            request.setAttribute("idper", request.getParameter("txtcedulaC"));
            acceso = edit;

        } else if (action.equalsIgnoreCase("Actualizar")) {
            cedulac = Integer.parseInt(request.getParameter("txtcedulaC"));
            String nom = request.getParameter("txtnombreC");
            String direccion = request.getParameter("txtDirC");
            String telefono = request.getParameter("txtTelC");
            String correo = request.getParameter("txtCorreoC");
            if (cedulac != 0 & nom != "" & direccion != "" & telefono != "" & correo != "") {
                c.setCedulaC(cedulac);
                c.setNomC(nom);
                c.setDireccionC(direccion);
                c.setTelefC(telefono);
                c.setCorreoC(correo);
                cdao.editC(c);
                acceso = listarC;
            } else {
                mensaje = null;
                 aviso = "---Faltan Datos del Cliente---- "; 
                 request.setAttribute("aviso",aviso);
                 request.setAttribute("mensaje",mensaje);
                 acceso = listarC;
            }

        } else if (action.equalsIgnoreCase("Borrar")) {
            String concedula = request.getParameter("txtcedulaC");
            if (concedula != "") {
                request.setAttribute("idper", request.getParameter("txtcedulaC"));
                ClienteDAO clo = new ClienteDAO();
                int id = Integer.parseInt((String) request.getAttribute("idper"));
                Cliente c = (Cliente) clo.listC(id);;
                int control = c.getCedulaC();
                if (control == 0) {
                     mensaje = null;
                    aviso = "---Cliente Inexistente o Cédula Errada---- "; 
                    request.setAttribute("aviso",aviso);
                    request.setAttribute("mensaje",mensaje);
                    acceso = listarC;
                }else{
                cedulac = Integer.parseInt(request.getParameter("txtcedulaC"));
                c.setCedulaC(cedulac);
                cdao.eliminarC(cedulac);
                mensaje = "---Datos del Cliente Borrados---- ";
                    aviso = null; 
                    request.setAttribute("aviso",aviso);
                    request.setAttribute("mensaje",mensaje);
                    acceso = listarC;
                }
            } else {
                 mensaje = null;
                 aviso = "---Faltan Datos del Cliente---- "; 
                 request.setAttribute("aviso",aviso);
                 request.setAttribute("mensaje",mensaje);
                 acceso = listarC;
            }
        } else if (action.equalsIgnoreCase("Cancelar")) {
            acceso = listarC;
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
