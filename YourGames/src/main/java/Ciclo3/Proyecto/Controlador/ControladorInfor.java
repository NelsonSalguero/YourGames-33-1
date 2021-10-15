
package Ciclo3.Proyecto.Controlador;

import Ciclo3.Proyecto.Modelo.Cliente;
import Ciclo3.Proyecto.Modelo.ReporteVentas;
import Ciclo3.Proyecto.Modelo.Usuario;
import Ciclo3.Proyecto.ModeloDAO.ClienteDAO;
import Ciclo3.Proyecto.ModeloDAO.UsuarioDAO;
import Ciclo3.Proyecto.ModeloDAO.VentaDAO;
//import Ciclo3.Proyecto.ModeloDAO.VentaDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ControladorInfor extends HttpServlet {
            String mensaje = null;
            String aviso = null;
            String informes = "jsp/informes.jsp";
            String infVentas = "jsp/ventasXcliente.jsp";
            String usuarios = "jsp/listadoXusuarios.jsp";
            String clientes = "jsp/listadoXclientes.jsp";
            ReporteVentas reporteventa =new ReporteVentas();
            double granTotalventas =0;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ControladorInfor</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControladorInfor at " + request.getContextPath() + "</h1>");
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
//        processRequest(request, response);
            String acceso = "";
            String action = request.getParameter("accion");
            if (action.equalsIgnoreCase("listar")) {
            acceso = informes;
            
            }else if (action.equalsIgnoreCase("Ventas por Cliente")) {
              acceso = infVentas;

            }else if (action.equalsIgnoreCase("Regresar")) {
              acceso = informes;

            }else if (action.equalsIgnoreCase("Listado de Usuarios")) {
                
              acceso = usuarios;

            }else if (action.equalsIgnoreCase("Listado de Clientes")) {
                ClienteDAO dao = new ClienteDAO();
                List<Cliente> list = dao.listarC();
                System.out.println("Array de Clientes en informes:"+list.toString());
                if (list.isEmpty()){
                    mensaje = null;
                    aviso = "  No existen Clientes";
                    request.setAttribute("aviso",aviso);
                    request.setAttribute("mensaje",mensaje);
                    
                    acceso = informes;
                } else {
                acceso = clientes;}
              
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
