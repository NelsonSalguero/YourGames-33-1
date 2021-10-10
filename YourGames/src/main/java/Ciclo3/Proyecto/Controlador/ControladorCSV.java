
package Ciclo3.Proyecto.Controlador;

import Ciclo3.Proyecto.Modelo.Producto;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ControladorCSV extends HttpServlet {
    LectorCSV lectorCSV = new LectorCSV(',',' ');
    String mensaje = null;
    String aviso = null;

    
   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nombre = null;
        // Creamos una lista de tipo Producto
        List<Producto> productos = new ArrayList<Producto>();
        
        // Capturamos la informacipon del formulario
        try {
            nombre = request.getParameter("nombre");
            // Llenamos la lista con el método creado en la Clase LectorCSV
            productos = lectorCSV.leerCSVSimple(nombre);
            mensaje = "Archivo Cargado Exitosamente.";
            aviso = null;
            if(productos.size() == 0){
                aviso = "Datos Leídos Inválidos";
                mensaje = null;
            }
        } catch (Exception e) {
            aviso = "No se seleccionó archivo para cargar";
            mensaje = null;
        }
        // Definir la variable se van a usar en la vista
        request.setAttribute("productos", productos);
        request.setAttribute("aviso", aviso);
        request.setAttribute("mensaje", mensaje);
        // Direccionar la salida a la vista jsp
        request.getRequestDispatcher("jsp/VistaCarProd.jsp").forward(request, response);
        
        
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
        processRequest(request, response);
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
