
package Ciclo3.Proyecto.ModeloDAO;

import Ciclo3.Proyecto.Conexion.Conexion;
import Ciclo3.Proyecto.Modelo.DetalleVenta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class DetalleVentaDAO {
     Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    public boolean addDetalleVenta(DetalleVenta detalleVenta) {
        String sql = "insert into detalleventa (idProducto,idVenta,cantidadProducto,valorTotal,valorVenta,valorIva) values ('" +detalleVenta.getIdProducto()+"','"+detalleVenta.getIdVenta()+"','"+detalleVenta.getCantidadProducto()+"','"+detalleVenta.getValorTotal()+"','"+detalleVenta.getValorVenta()+"','"+detalleVenta.getValorIva()+"')";
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
            System.out.println("DetalleFactura Enviada a DB");
            cn.desconectar();
        } catch (Exception e) {
            System.out.println("No se pudo cargar DetalleFactura en DB"+e);
        }
       return false;
    }
    
}
