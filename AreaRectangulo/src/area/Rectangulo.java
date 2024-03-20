/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ramon
 */
public class Rectangulo {
    private int base;
    private int altura;
    private int area;
    
    public Rectangulo(int base , int altura){
        this.base = base;
        this.altura = altura;
    }
    
    public void CalculoArea(){
        this.area = this.base * this.altura;
    }
    
    public void Imprimir(){
        CalculoArea();
        System.out.println("El area es: " + this.area);
    }
}
