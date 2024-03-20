/**
 * Creado por Ramon
 * Version 1.0
 * Creado el 13/12/2020
*/
package inversordepalabras;

import java.util.Scanner;

/**
 *
 * @author Ramon
 */
public class InversorDePalabras {

    public static void main(String[] args) {
        
        //ejercicio resuelto por mi
        Scanner scan = new Scanner(System.in);
        String palabra;
        String palabraInvertida = "";
        int indice;
        
        //preguntamos por la palabra
        System.out.print("Digite una palabra: ");
        palabra = scan.nextLine();
        
        //obtenemos el numero de caracteres de la palabra
        indice = palabra.length();
        
        //recorremos la palabra
        for (int i = (indice - 1); i >= 0; i--) {
            //obtenemos el caracter
            char caracter = palabra.charAt(i);
            palabraInvertida += caracter;
        }
        
        System.out.println("Palabra invertida: "+palabraInvertida);
    }
    
}
