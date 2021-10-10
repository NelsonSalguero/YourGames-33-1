
package Ciclo3.Proyecto.Modelo;

/**
 *
 * @author PORTATIL
 */
public class Producto {
    // Atributos
    private int codigo;
    private String nombre;
    private int nitProveedor;
    private double precioCompra;
    private double iva;
    private double precioVenta;

    public Producto() {
    }

    public Producto(int codigo, String nombre, int nitProveedor, double precioCompra, double iva, double precioVenta) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.nitProveedor = nitProveedor;
        this.precioCompra = precioCompra;
        this.iva = iva;
        this.precioVenta = precioVenta;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNitProveedor() {
        return nitProveedor;
    }

    public void setNitProveedor(int nitProveedor) {
        this.nitProveedor = nitProveedor;
    }

    public double getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(double precioCompra) {
        this.precioCompra = precioCompra;
    }

    public double getIva() {
        return iva;
    }

    public void setIva(double iva) {
        this.iva = iva;
    }

    public double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(double precioVenta) {
        this.precioVenta = precioVenta;
    }

    @Override
    public String toString() {
        return "Producto{" + "codigo=" + codigo + ", nombre=" + nombre + ", nitProveedor=" + nitProveedor + ", precioCompra=" + precioCompra + ", iva=" + iva + ", precioVenta=" + precioVenta + '}';
    }
    
    
    
}
