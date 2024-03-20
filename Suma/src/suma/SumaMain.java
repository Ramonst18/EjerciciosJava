/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package suma;
import java.util.Scanner;
/**
 *
 * @author Ramon
 */
public class SumaMain {
    public static void main(String[]args){
        Scanner scan = new Scanner(System.in);
        
        //pedimos los valores
        System.out.print("Dame el primer valor: ");
        int valorUno = scan.nextInt();
        
        System.out.print("Dame el segundo valor: ");
        int valorDos = scan.nextInt();
        
        Suma valores = new Suma(valorUno , valorDos);
        valores.Imprimir();
    }
}
