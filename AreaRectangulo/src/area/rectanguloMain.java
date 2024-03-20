/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package area;

import java.util.Scanner;

/**
 *
 * @author Ramon
 */
public class rectanguloMain {
    public static void main(String[]args){
        Scanner scan = new Scanner(System.in);
        
        //pedimos los datos
        System.out.print("Dame el valor de la base: ");
        int base = scan.nextInt();
        
        System.out.print("Dame el valor de la altura: ");
        int altura = scan.nextInt();
        
        Rectangulo mensajero = new Rectangulo(base , altura);
        mensajero.Imprimir();
    }
}
