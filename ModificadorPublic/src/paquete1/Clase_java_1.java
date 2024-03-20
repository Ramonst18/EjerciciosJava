/*
 * En el default, se accederan a los atributos y metodos de una clase solo
 * si las clases pertenecen al mismo paquete
 */
package paquete1;

/**
 *
 * @author PC
 */
public class Clase_java_1 {
    public static void main(String[] args){
        Atributos_metodos mensajero = new Atributos_metodos();
        
        mensajero.valorDos = 2;
    }
}
