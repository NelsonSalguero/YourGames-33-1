package Ciclo3.Proyecto.ModeloDAO;

import Ciclo3.Proyecto.Conexion.Conexion;
import Ciclo3.Proyecto.Interfaces.CRUDProv;
import Ciclo3.Proyecto.Modelo.Proveedor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProveedorDAO implements CRUDProv {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Proveedor c = new Proveedor();

    @Override
    public List listarP() {
        ArrayList<Proveedor> list = new ArrayList<>();
        String sql = "select * from proveedores";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Proveedor cli = new Proveedor();
                cli.setNit(rs.getInt("Nit"));
                cli.setNomP(rs.getString("NombreP"));
                cli.setDireccionP(rs.getString("Direccion"));
                cli.setTelefP(rs.getString("Telefono"));
                cli.setCiudad(rs.getString("Ciudad"));
                list.add(cli);
            }
        } catch (Exception e) {
        }
        return list;
    }

    @Override
    public Proveedor listP(int nit) {
        String sql = "select * from proveedores where Nit=" + nit;
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                c.setNit(rs.getInt("Nit"));
                c.setNomP(rs.getString("NombreP"));
                c.setDireccionP(rs.getString("Direccion"));
                c.setTelefP(rs.getString("Telefono"));
                c.setCiudad(rs.getString("Ciudad"));

            }
        } catch (Exception e) {
        }
        return c;
    }

    @Override
    public boolean addP(Proveedor pro) {
        String sql = "insert into proveedores(Nit,NombreP,Direccion,Telefono,Ciudad)values('" + pro.getNit() + "','" + pro.getNomP() + "','" + pro.getDireccionP() + "','" + pro.getTelefP() + "','" + pro.getCiudad() + "')";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }

    @Override
    public boolean editP(Proveedor pro) {
       String sql = "update proveedores set NombreP='" + pro.getNomP() + "',Direccion='" + pro.getDireccionP() + "',Telefono='" + pro.getTelefP() + "',Ciudad='" + pro.getCiudad() + "' where NIT=" + pro.getNit();
        try {

            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {

        }
        return false;
    }

    @Override
    public boolean eliminarP(int Nit) {
        String sql="delete from proveedores where Nit="+Nit;
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }

}
