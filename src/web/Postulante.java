/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
//xuncoco
package web;

/**
 *
 * @author Diabulus
 */
public class Postulante {
    
    private String rut;
    private String nombre;
    private String nombre2;
    private String apellido;
    private String apellido2;
    private String direccion;
    private int promedio;

    public Postulante(String rut, String nombre, String nombre2, String apellido, String apellido2, String direccion, int promedio) {
        this.rut = rut;
        this.nombre = nombre;
        this.nombre2 = nombre2;
        this.apellido = apellido;
        this.apellido2 = apellido2;
        this.direccion = direccion;
        this.promedio = promedio;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setNombre2(String nombre2) {
        this.nombre2 = nombre2;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setPromedio(int promedio) {
        this.promedio = promedio;
    }

    public String getRut() {
        return rut;
    }

    public String getNombre() {
        return nombre;
    }

    public String getNombre2() {
        return nombre2;
    }

    public String getApellido() {
        return apellido;
    }

    public String getApellido2() {
        return apellido2;
    }

    public String getDireccion() {
        return direccion;
    }

    public int getPromedio() {
        return promedio;
    }

    
}
