/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package suma;

/**
 *
 * @author Ramon
 */
public class Suma {
    private int vUno,vDos,Resultado;
    
    public Suma(int valorUno, int valorDos){
        this.vUno = valorUno;
        this.vDos = valorDos;
    }
    
    public void Operacion(){
        this.Resultado = this.vUno + this.vDos;
    }
    
    public void Imprimir(){
        Operacion();
        
        System.out.println("El resultado de la suma es: " + this.Resultado);
    }
}
