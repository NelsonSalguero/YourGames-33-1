
package Ciclo3.Proyecto.Modelo;


public class ReporteVentas {
    private int  cedulaCliente;
    private String nombreCliente;
    private double ventaT;

    public ReporteVentas() {
    }

    public ReporteVentas(int cedulaCliente, String nombreCliente, double ventaT) {
        this.cedulaCliente = cedulaCliente;
        this.nombreCliente = nombreCliente;
        this.ventaT = ventaT;
    }

    public int getCedulaCliente() {
        return cedulaCliente;
    }

    public void setCedulaCliente(int cedulaCliente) {
        this.cedulaCliente = cedulaCliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public double getVentaT() {
        return ventaT;
    }

    public void setVentaT(double ventaT) {
        this.ventaT = ventaT;
    }

    @Override
    public String toString() {
        return "ReporteVentas{" + "cedulaCliente=" + cedulaCliente + ", nombreCliente=" + nombreCliente + ", ventaT=" + ventaT + '}';
    }
    
    
}
