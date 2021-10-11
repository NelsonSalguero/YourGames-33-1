
package Ciclo3.Proyecto.ModeloDAO;

import Ciclo3.Proyecto.Conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class VentaDAO {
     Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    //Generar Numero de Factura (Mayor numero para continuar"
    
    public int calcularIdVenta() {
    int idVenta=0;
    String sql = "select max (id) from venta";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                idVenta=(rs.getInt("id"));//Carlos puso 1 en lugar de "id"
            }
            cn.desconectar();
            System.out.println("Numro Actual ="+idVenta);
        } catch (Exception e) {
            System.out.println("Error aca num fact :"+e);
        }
    
    
   
    return idVenta;
    }
}
