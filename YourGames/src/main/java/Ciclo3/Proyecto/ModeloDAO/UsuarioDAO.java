
package Ciclo3.Proyecto.ModeloDAO;

import Ciclo3.Proyecto.Conexion.Conexion;
import Ciclo3.Proyecto.Interfaces.CRUD;
import Ciclo3.Proyecto.Modelo.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class UsuarioDAO implements CRUD {
    
Conexion cn=new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Usuario p=new Usuario();
    @Override
    public List listar() {
        ArrayList<Usuario>list=new ArrayList<>();
        String sql="select * from usuarios";
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                Usuario per=new Usuario();
                per.setCedula(rs.getInt("Cedula"));
                per.setNom(rs.getString("Nombres"));
                per.setCorreo(rs.getString("Correo"));
                per.setUsuario(rs.getString("Usuario"));
                per.setClave(rs.getString("Clave"));
                per.setTipoUsuario(rs.getString("tipoUsuario"));
                list.add(per);
                cn.desconectar();
            }
        } catch (Exception e) {
        }
       
        return list;
    }

    @Override
    public Usuario list(int cedula) {
        String sql="select * from usuarios where Cedula="+cedula;
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){                
                p.setCedula(rs.getInt("Cedula"));
                p.setNom(rs.getString("Nombres"));
                p.setCorreo(rs.getString("Correo"));
                p.setUsuario(rs.getString("Usuario"));
                p.setClave(rs.getString("Clave"));
                p.setTipoUsuario(rs.getString("tipoUsuario"));
                cn.desconectar();
            }
        } catch (Exception e) {
        }
        return p;
    }

    @Override
    public boolean add(Usuario per) {
        String sql="insert into usuarios(Cedula,Nombres,Correo,Usuario,Clave,tipoUsuario)values('"+per.getCedula()+"','"+per.getNom()+"','"+per.getCorreo()+"','"+per.getUsuario()+"','"+per.getClave()+"','"+per.getTipoUsuario()+"')";
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
            cn.desconectar();
        } catch (Exception e) {
        }
       return false;
    }

    @Override
    public boolean edit(Usuario per) {
        String sql="update usuarios set Nombres='"+per.getNom()+"',Correo='"+per.getCorreo()+"',Usuario='"+per.getUsuario()+"',Clave='"+per.getClave()+"',TipoUsuario='"+per.getTipoUsuario()+"' where Cedula="+per.getCedula();
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
            cn.desconectar();
        } catch (Exception e) {
        }
        
        return false;
    }

    @Override
    public boolean eliminar(int cedula) {
        String sql="delete from usuarios where Cedula="+cedula;
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
            cn.desconectar();
        } catch (Exception e) {
        }
        return false;
    }


    
}




