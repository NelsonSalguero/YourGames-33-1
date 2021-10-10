
package Ciclo3.Proyecto.Interfaces;

import Ciclo3.Proyecto.Modelo.Proveedor;
import java.util.List;


public interface CRUDProv {
      public List listarP();

    public Proveedor listP(int Nit);

    public boolean addP(Proveedor pro);

    public boolean editP(Proveedor pro);

    public boolean eliminarP(int Nit);
}
