
package Ciclo3.Proyecto.ModeloDAO;

import Ciclo3.Proyecto.Conexion.Conexion;
import Ciclo3.Proyecto.Modelo.Venta;
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
    String sql = "SELECT MAX(id) FROM venta";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                idVenta=(rs.getInt(1));//Carlos puso 1 en lugar de "id"
            }
            cn.desconectar();
            System.out.println("Numro Actual ="+idVenta);
        } catch (Exception e) {
            System.out.println("Error aca num fact :"+e);
        }
    
       return idVenta;
    }
    
    public boolean addFactura(Venta venta) {
        String sql = "insert into venta values('" +venta.getId()+"','"+venta.getCedulaCliente()+"','"+venta.getIdUsuario()+"','"+venta.getIvaVenta()+"','"+venta.getTotalVenta()+"','"+venta.getValorVenta()+"')";
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
            System.out.println("Factura Enviada a DB");
            cn.desconectar();
        } catch (Exception e) {
            System.out.println("No se pudo cargar Factura en DB"+e);
        }
       return false;
    }
    
    
    
}