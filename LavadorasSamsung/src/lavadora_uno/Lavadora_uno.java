
package lavadora_uno;
import Libreria.LLFunciones;
import java.util.Scanner;

public class Lavadora_uno {
    public static void main(String []args){
        Scanner scan = new Scanner(System.in);
        
        System.out.println("¿La ropa es blanca o de color?");
        System.out.println("Preciona 1 - ropa blanca / 2 - ropa color");
        int TipoDeRopa = scan.nextInt();
        
        System.out.print("¿Cuantos kilos de ropa?");
        int kilos = scan.nextInt();
        
        LLFunciones mensajero = new LLFunciones(kilos, TipoDeRopa);
        
        mensajero.setTipoDeRopa(2);
        System.out.println("El tipo de ropa es: " + mensajero.getTipoDeRopa());
        mensajero.CicloFinalizado();
    }
}
