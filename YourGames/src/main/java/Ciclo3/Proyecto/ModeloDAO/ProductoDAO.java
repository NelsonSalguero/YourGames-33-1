
package Ciclo3.Proyecto.ModeloDAO;

import Ciclo3.Proyecto.Conexion.Conexion;
import Ciclo3.Proyecto.Modelo.Producto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class ProductoDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Producto produ = new Producto();
    
    public boolean addProducto(Producto producto) {
        String sql = "insert into productos (codigo,nombre,nitproveedor,precio_compra,iva,precio_venta)values('" +producto.getCodigo()+"','"+producto.getNombre()+"','"+producto.getNitProveedor()+"','"+producto.getPrecioCompra()+"','"+producto.getIva()+"','"+producto.getPrecioVenta()+"')";
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
            System.out.println("Enviado a DB");
            cn.desconectar();
        } catch (Exception e) {
            System.out.println("No se pudo cargar datos en DB"+e);
        }
       return false;
    }
    public List listarPro() {
        ArrayList<Producto> list = new ArrayList<>();
        String sql = "select * from productos";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Producto prod = new Producto();
                prod.setCodigo(rs.getInt("codigo"));
                prod.setNombre(rs.getString("nombre"));
                prod.setNitProveedor(rs.getInt("nitProveedor"));
                prod.setPrecioCompra(rs.getDouble("precio_compra"));
                prod.setIva(rs.getDouble("iva"));
                prod.setPrecioVenta(rs.getDouble("precio_venta"));
                list.add(prod);
            }
            cn.desconectar();
        } catch (Exception e) {
        }
        return list;
    }
    public void DelAllProductos() {
        System.out.println("LLega a acá?");
        int cero=0;
        String sql = "delete from productos";
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
            System.out.println("Borrada la DB");
            cn.desconectar();                                 
        } catch (Exception e) {
        }
          
    }
    
    //aca poner metodo de buscar producto por codigo
    
    public Producto listPro(int codigo) {
        String sql = "select * from productos where codigo=" + codigo;
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                
                produ.setCodigo(rs.getInt("codigo"));
                produ.setNombre(rs.getString("nombre"));
                produ.setNitProveedor(rs.getInt("nitProveedor"));
                produ.setPrecioCompra(rs.getDouble("precio_compra"));
                produ.setIva(rs.getDouble("iva"));
                produ.setPrecioVenta(rs.getDouble("precio_venta"));

            }
            cn.desconectar();
            System.out.println("Producto encontrado ="+produ);
        } catch (Exception e) {
        }
        return produ;
    }
    
    
}
