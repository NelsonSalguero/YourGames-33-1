package Ciclo3.Proyecto.Controlador;

import Ciclo3.Proyecto.Modelo.Producto;
import Ciclo3.Proyecto.ModeloDAO.ProductoDAO;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.opencsv.CSVReader;

public class LectorCSV {

    private char separador;
    private char comillas;

    public LectorCSV(char separador, char comillas) {
        this.separador = separador;
        this.comillas = comillas;
    }

    public List<Producto> leerCSVSimple(String path) throws IOException {
        ProductoDAO ProductoDAO = new ProductoDAO();
        //Borrar la base de datos
        System.out.println("Intentando borrar la DB");
        ProductoDAO.DelAllProductos();
        // Abro el .csv en buffer de lectura
        BufferedReader bufferLectura = new BufferedReader(new FileReader(path));
        String linea = bufferLectura.readLine();// Leo una línea del archivo
        List<Producto> productos = new ArrayList<>(); // Crea una lista tipo Producto
        
        try {
            while (linea != null) {
                // Separa la línea leída con el separador definido previamente
                String[] campos = linea.split(String.valueOf(this.separador));
                Producto pro = new Producto(); // Instanciamos un objeto tipo Proveedor
                pro.setCodigo(Integer.parseInt(campos[0]));
                pro.setNombre(campos[1]);
                pro.setNitProveedor(Integer.parseInt(campos[2]));
                pro.setPrecioCompra(Double.parseDouble(campos[3]));
                pro.setIva(Double.parseDouble(campos[4]));
                pro.setPrecioVenta(Double.parseDouble(campos[5]));
                System.out.println("Enviado a DAO 1");
                ProductoDAO.addProducto(pro) ;
                System.out.println("Enviado a DAO 2");
                productos.add(pro); // Agregarlo al ArrayList
                System.out.println(Arrays.toString(campos));
                // Vuelvo a leer del fichero
                linea = bufferLectura.readLine();
            }
            // CIerro el buffer de lectura
            if (bufferLectura != null) {
                bufferLectura.close();
            }

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        return productos;
    }
}
