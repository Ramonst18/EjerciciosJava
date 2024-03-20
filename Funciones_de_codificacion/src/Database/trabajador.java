/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

/**
 *
 * @author PC
 */
public class trabajador {
    String nombre;
    String direccion;
    String telefono;
    String posicion;

    public trabajador(String nombre, String direccion, String telefono, String posicion) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.posicion = posicion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPosicion() {
        return posicion;
    }
    
}
