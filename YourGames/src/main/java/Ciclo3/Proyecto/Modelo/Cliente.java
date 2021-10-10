
package Ciclo3.Proyecto.Modelo;


public class Cliente {
    int cedulaC;
    String nomC;
    String direccionC;
    String telefC;
    String correoC;

    public Cliente() {
    }

    public Cliente(int cedulaC, String nomC, String direccionC, String telefC, String correoC) {
        this.cedulaC = cedulaC;
        this.nomC = nomC;
        this.direccionC = direccionC;
        this.telefC = telefC;
        this.correoC = correoC;
    }

    public int getCedulaC() {
        return cedulaC;
    }

    public void setCedulaC(int cedulaC) {
        this.cedulaC = cedulaC;
    }

    public String getNomC() {
        return nomC;
    }

    public void setNomC(String nomC) {
        this.nomC = nomC;
    }

    public String getDireccionC() {
        return direccionC;
    }

    public void setDireccionC(String direccionC) {
        this.direccionC = direccionC;
    }

    public String getTelefC() {
        return telefC;
    }

    public void setTelefC(String telefC) {
        this.telefC = telefC;
    }

    public String getCorreoC() {
        return correoC;
    }

    public void setCorreoC(String correoC) {
        this.correoC = correoC;
    }

    @Override
    public String toString() {
        return "Cliente{" + "cedulaC=" + cedulaC + ", nomC=" + nomC + ", direccionC=" + direccionC + ", telefC=" + telefC + ", correoC=" + correoC + '}';
    }
    
       
}
