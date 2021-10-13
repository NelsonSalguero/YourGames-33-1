
package Ciclo3.Proyecto.Modelo;


public class Venta {
private int id;
private int cedulaCliente;
private int idUsuario;
private double ivaVenta;
private double totalVenta;
private double valorVenta;

    public Venta() {
    }

    public Venta(int id, int cedulaCliente, int idUsuario, double ivaVenta, double totalVenta, double valorVenta) {
        this.id = id;
        this.cedulaCliente = cedulaCliente;
        this.idUsuario = idUsuario;
        this.ivaVenta = ivaVenta;
        this.totalVenta = totalVenta;
        this.valorVenta = valorVenta;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCedulaCliente() {
        return cedulaCliente;
    }

    public void setCedulaCliente(int cedulaCliente) {
        this.cedulaCliente = cedulaCliente;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public double getIvaVenta() {
        return ivaVenta;
    }

    public void setIvaVenta(double ivaVenta) {
        this.ivaVenta = ivaVenta;
    }

    public double getTotalVenta() {
        return totalVenta;
    }

    public void setTotalVenta(double totalVenta) {
        this.totalVenta = totalVenta;
    }

    public double getValorVenta() {
        return valorVenta;
    }

    public void setValorVenta(double valorVenta) {
        this.valorVenta = valorVenta;
    }

    @Override
    public String toString() {
        return "Venta{" + "id=" + id + ", cedulaCliente=" + cedulaCliente + ", idUsuario=" + idUsuario + ", ivaVenta=" + ivaVenta + ", totalVenta=" + totalVenta + ", valorVenta=" + valorVenta + '}';
    }

    
}
