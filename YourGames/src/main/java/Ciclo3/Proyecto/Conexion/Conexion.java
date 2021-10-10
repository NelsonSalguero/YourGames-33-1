
package Ciclo3.Proyecto.Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Conexion {
    

    public Connection con;
        public Connection getCon() {
        return con;
        }
        public void setCon(Connection con) {
        this.con = con;
            }
    public Conexion(){
        try {
           
            Class.forName("com.mysql.cj.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3305/sprint?useSSL=false&serverTimezone=UTC&useUnicode=true&characterEncoding=utf-8", "root", "root");     

        } catch (Exception e) {

        }
    }
    
    public void desconectar() throws Exception
    {
        try
        {
            if(con!=null)
            {
                if(con.isClosed()==false)
                {
                    con.isClosed();
                }
            }
        }
        catch (SQLException e)
        {
            throw e;
        }
    }
    
    
    public Connection getConnection(){
        return con;
    }
}


