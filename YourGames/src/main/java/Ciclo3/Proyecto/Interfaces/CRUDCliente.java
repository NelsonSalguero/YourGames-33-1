package Ciclo3.Proyecto.Interfaces;

import Ciclo3.Proyecto.Modelo.Cliente;
import java.util.List;

public interface CRUDCliente {

    public List listarC();

    public Cliente listC(int cedulac);

    public boolean addC(Cliente cli);

    public boolean editC(Cliente cli);

    public boolean eliminarC(int cedula);

}
