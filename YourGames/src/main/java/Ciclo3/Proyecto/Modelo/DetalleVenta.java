package Ciclo3.Proyecto.Modelo;

public class DetalleVenta {

    private int id;
    private int idProducto;
    private String descripcion;
    private int idVenta;
    private int cantidadProducto;
    private double precioventa;
    private double valorTotal;
    private double valorVenta;
    private double valorIva;

    public DetalleVenta() {
    }

    public DetalleVenta(int id, int idProducto, String descripcion, int idVenta, int cantidadProducto, double precioventa, double valorTotal, double valorVenta, double valorIva) {
        this.id = id;
        this.idProducto = idProducto;
        this.descripcion = descripcion;
        this.idVenta = idVenta;
        this.cantidadProducto = cantidadProducto;
        this.precioventa = precioventa;
        this.valorTotal = valorTotal;
        this.valorVenta = valorVenta;
        this.valorIva = valorIva;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public int getCantidadProducto() {
        return cantidadProducto;
    }

    public void setCantidadProducto(int cantidadProducto) {
        this.cantidadProducto = cantidadProducto;
    }

    public double getPrecioventa() {
        return precioventa;
    }

    public void setPrecioventa(double precioventa) {
        this.precioventa = precioventa;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public double getValorVenta() {
        return valorVenta;
    }

    public void setValorVenta(double valorVenta) {
        this.valorVenta = valorVenta;
    }

    public double getValorIva() {
        return valorIva;
    }

    public void setValorIva(double valorIva) {
        this.valorIva = valorIva;
    }
    
    

    

}
