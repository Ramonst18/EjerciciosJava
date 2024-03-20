/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete2;
import paquete1.Atributos_metodos;
/**
 *
 * @author PC
 */
public class Clase_java_2 {
    public static void main(String[]args){
        Atributos_metodos mensajero = new Atributos_metodos();
        
        //Como es publico sus atributos y metodos, se podran acceder a las variables
        //y metodos
        mensajero.metodoErnesto();
        
        //para cuando no se tenga  un modificador de acceso publico pasara esto
        //como en esta clase no esta en el paquete en el cual esta atributos metodos
        //entonces no se podran acceder a los atributos default
        
        //el siguiente codigo no funciona
        //mensajero.valorDos = 0;
        
    }
}
