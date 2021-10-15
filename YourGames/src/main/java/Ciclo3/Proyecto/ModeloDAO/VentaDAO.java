
package Ciclo3.Proyecto.ModeloDAO;

import Ciclo3.Proyecto.Conexion.Conexion;
import Ciclo3.Proyecto.Modelo.Cliente;
import Ciclo3.Proyecto.Modelo.ReporteVentas;
import Ciclo3.Proyecto.Modelo.Venta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


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
    public List reporteVentasXCliente() {
        ArrayList<ReporteVentas> list = new ArrayList<>();
        String sql = "select v.cedulaCliente, c.NombreC, sum(v.totalVenta) as Total from "
                + "venta v, clientes c where v.cedulaCliente = c.Cedula group by v.cedulaCliente, c.NombreC";
        
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                ReporteVentas repoV = new ReporteVentas();
                repoV.setCedulaCliente(rs.getInt(1));
                repoV.setNombreCliente(rs.getString(2));
                repoV.setVentaT(rs.getDouble(3));
                list.add(repoV);
                cn.desconectar();
            }
        } catch (Exception e) {
            System.out.println("Error en DAO SQL reporteVentasXCliente"+e);
        }
        return list;
    }
    
    
}