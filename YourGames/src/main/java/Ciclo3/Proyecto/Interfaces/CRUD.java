
package Ciclo3.Proyecto.Interfaces;

import Ciclo3.Proyecto.Modelo.Usuario;
import java.util.List;


public interface CRUD {
    


    public List listar();
    public Usuario list(int cedula);
    public boolean add(Usuario per);
    public boolean edit(Usuario per);
    public boolean eliminar(int cedula);

}


