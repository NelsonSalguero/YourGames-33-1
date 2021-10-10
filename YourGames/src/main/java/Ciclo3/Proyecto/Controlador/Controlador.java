package Ciclo3.Proyecto.Controlador;

import Ciclo3.Proyecto.Modelo.Usuario;
import Ciclo3.Proyecto.ModeloDAO.UsuarioDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Controlador extends HttpServlet {

    String listar = "jsp/listar.jsp";
    String add = "jsp/add.jsp";
    String edit = "jsp/edit.jsp";
    String search = "jsp/buscar.jsp";
    String noenc = "jsp/noencontrado.jsp";
    Usuario p = new Usuario();
    UsuarioDAO dao = new UsuarioDAO();
    int cedula;

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
            out.println("<title>Servlet Controlador</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Controlador at " + request.getContextPath() + "</h1>");
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
            acceso = listar;
        } else if (action.equalsIgnoreCase("add")) {
            acceso = add;
        } else if (action.equalsIgnoreCase("Agregar")) {
            String nid = request.getParameter("txtCedula");
            String nom = request.getParameter("txtNom");
            String correo = request.getParameter("txtCorreo");
            String usuario = request.getParameter("txtUsuario");
            String clave = request.getParameter("txtClave");
            String tipoUsuario = request.getParameter("txtNivel");
            int ida = Integer.parseInt(nid);
            p.setCedula(ida);
            p.setNom(nom);
            p.setCorreo(correo);
            p.setUsuario(usuario);
            p.setClave(clave);
            p.setTipoUsuario(tipoUsuario);
            dao.add(p);
            acceso = add;
        } else if (action.equalsIgnoreCase("editar")) {

            request.setAttribute("idper", request.getParameter("cedula"));
            acceso = edit;
        } else if (action.equalsIgnoreCase("buscar")) {

            request.setAttribute("idper", request.getParameter("txtBuscar"));
            UsuarioDAO bus = new UsuarioDAO();
            int id = Integer.parseInt((String) request.getAttribute("idper"));
            Usuario p = (Usuario) bus.list(id);;
            int control = p.getCedula();
            if (control == 0) {
                acceso = noenc;
            } else {
                acceso = search;
            }

        } else if (action.equalsIgnoreCase("Actualizar")) {
            cedula = Integer.parseInt(request.getParameter("txtCedula"));
            String nom = request.getParameter("txtNom");
            String correo = request.getParameter("txtCorreo");
            String usuario = request.getParameter("txtUsuario");
            String clave = request.getParameter("txtClave");
            String tipoUsuario = request.getParameter("txtNivel");
            p.setCedula(cedula);
            p.setNom(nom);
            p.setCorreo(correo);
            p.setUsuario(usuario);
            p.setClave(clave);
            p.setTipoUsuario(tipoUsuario);
            dao.edit(p);
            acceso = listar;
        } else if (action.equalsIgnoreCase("eliminar")) {
            cedula = Integer.parseInt(request.getParameter("cedula"));
            p.setCedula(cedula);
            dao.eliminar(cedula);
            acceso = listar;

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
