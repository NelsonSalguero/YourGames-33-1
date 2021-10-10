/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ciclo3.Proyecto.Modelo;


public class Proveedor {
     int Nit;
    String nomP;
    String direccionP;
    String telefP;
    String ciudad;

    public Proveedor() {
    }

    public Proveedor(int Nit, String nomP, String direccionP, String telefP, String ciudad) {
        this.Nit = Nit;
        this.nomP = nomP;
        this.direccionP = direccionP;
        this.telefP = telefP;
        this.ciudad = ciudad;
    }

    public int getNit() {
        return Nit;
    }

    public void setNit(int Nit) {
        this.Nit = Nit;
    }

    public String getNomP() {
        return nomP;
    }

    public void setNomP(String nomP) {
        this.nomP = nomP;
    }

    public String getDireccionP() {
        return direccionP;
    }

    public void setDireccionP(String direccionP) {
        this.direccionP = direccionP;
    }

    public String getTelefP() {
        return telefP;
    }

    public void setTelefP(String telefP) {
        this.telefP = telefP;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
    
    
}
