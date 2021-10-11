package Ciclo3.Proyecto.ModeloDAO;

import Ciclo3.Proyecto.Conexion.Conexion;
import Ciclo3.Proyecto.Interfaces.CRUDCliente;
import Ciclo3.Proyecto.Modelo.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO implements CRUDCliente {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Cliente c = new Cliente();
   

    @Override
    public List listarC() {
        ArrayList<Cliente> list = new ArrayList<>();
        String sql = "select * from clientes";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Cliente cli = new Cliente();
                cli.setCedulaC(rs.getInt("Cedula"));
                cli.setNomC(rs.getString("NombreC"));
                cli.setDireccionC(rs.getString("Direccion"));
                cli.setTelefC(rs.getString("Telefono"));
                cli.setCorreoC(rs.getString("Email"));
                list.add(cli);
                cn.desconectar();
            }
        } catch (Exception e) {
        }
        return list;
    }

    @Override
    public Cliente listC(int cedulac) {
        String sql = "select * from clientes where Cedula=" + cedulac;
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                c.setCedulaC(rs.getInt("Cedula"));
                c.setNomC(rs.getString("NombreC"));
                c.setDireccionC(rs.getString("Direccion"));
                c.setTelefC(rs.getString("Telefono"));
                c.setCorreoC(rs.getString("Email"));

            }
            cn.desconectar();
        } catch (Exception e) {
        }
        return c;
    }

    @Override
    public boolean addC(Cliente cli) {
        String sql = "insert into clientes(Cedula,NombreC,Direccion,Telefono,Email)values('" + cli.getCedulaC() + "','" + cli.getNomC() + "','" + cli.getDireccionC() + "','" + cli.getTelefC() + "','" + cli.getCorreoC() + "')";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
            cn.desconectar();
        } catch (Exception e) {
        }
        return false;
    }

    @Override
    public boolean editC(Cliente cli) {
        String sql = "update clientes set NombreC='" + cli.getNomC() + "',Direccion='" + cli.getDireccionC() + "',Telefono='" + cli.getTelefC() + "',Email='" + cli.getCorreoC() + "' where Cedula=" + cli.getCedulaC();
        try {

            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
            cn.desconectar();
        } catch (Exception e) {

        }
        return false;
    }

    @Override
    public boolean eliminarC(int cedulac) {
        String sql = "delete from clientes where Cedula=" + cedulac;
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
            cn.desconectar();
        } catch (Exception e) {
        }
        return false;
    }

}
