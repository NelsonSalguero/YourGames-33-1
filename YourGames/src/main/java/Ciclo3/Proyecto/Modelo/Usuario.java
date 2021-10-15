
package Ciclo3.Proyecto.Modelo;

public class Usuario {
    

    int cedula;
    String nom;
    String correo;
    String usuario;
    String clave;
    String tipoUsuario;
    public Usuario() {
    }

    public Usuario(int cedula, String nom, String correo, String usuario, String clave,String tipoUsuario) {
        this.cedula=cedula;
        this.nom = nom;
        this.correo = correo;
        this.usuario = usuario;
        this.clave = clave;
        this.tipoUsuario=tipoUsuario;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    @Override
    public String toString() {
        return "Usuario{" + "cedula=" + cedula + ", nom=" + nom + ", correo=" + correo + ", usuario=" + usuario + ", clave=" + clave + ", tipoUsuario=" + tipoUsuario + '}';
    }

   
    
}

