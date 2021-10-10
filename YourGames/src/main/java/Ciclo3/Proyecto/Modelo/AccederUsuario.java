
package Ciclo3.Proyecto.Modelo;

import Ciclo3.Proyecto.Conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class AccederUsuario extends Conexion {
    
public String login(Usuario usu)throws Exception
    {
        String estado = "";
        ResultSet rs;
        Conexion cn=new Conexion();
        Connection cone;

    
        try 
        {
            con=cn.getConnection();
            String sql = "select tipoUsuario from usuarios where usuario=? and clave=?";
            PreparedStatement ps =this.getCon().prepareStatement(sql);
            ps.setString(1, usu.getUsuario());
            ps.setString(2, usu.getClave());
            rs= ps.executeQuery();
            if (rs.next()) {

                estado = "true";

            }
            usu.setTipoUsuario(rs.getString("tipoUsuario"));
        } catch (Exception e) 
        {
            throw e;
        }
        return estado;
    }
}

