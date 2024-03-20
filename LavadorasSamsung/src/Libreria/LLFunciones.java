/*
 * Clase para las funciones logicas de una lavadora
 */
package Libreria;

/**
 *
 * @author Ramon
 */
public class LLFunciones {
    //ropa blanca TipoDeRopa = 1, ropa de color = 2
    //para el llenado,lavado y secado 0 sera falso y 1 sera verdadero
    private int Kilos = 0,LlenadoCompleto = 0, TipoDeRopa = 0,LavadoCompleto = 0,
            SecadoCompleto = 0;
    
    
    public LLFunciones(int Kilos, int TipoDeRopa){
        this.Kilos = Kilos;
        this.TipoDeRopa = TipoDeRopa;
    }
    
    //funciones de la lavadora
    private void Llenado(){//llenado de la lavadora
        //comprobamos si los kilos son mayor a la capacidad de la lavadora
        if (this.Kilos <= 12) {
            this.LlenadoCompleto = 1;
            System.out.println("Llenando...");
            System.out.println("Llenado completo.");
        }else{
            System.out.println("La carga de ropa es muy pesada, reduce la carga");
        }
    }
    
    private void Lavado(){//lavado de la lavadora
        Llenado();
        
        //comprobamos si se lleno la lavadora
        if (this.LlenadoCompleto == 1) {
            //comprobamos el tipo de ropa
            if (this.TipoDeRopa == 1) {
                System.out.println("Ropa blanca / Lavado suave");
                System.out.println("Lavando...");
                
                this.LavadoCompleto = 1;
            } else if (this.TipoDeRopa == 2) {
                System.out.println("Ropa de color / Lavado intenso");
                System.out.println("Lavando...");
                
                this.LavadoCompleto = 1;
            } else {
                System.out.println("El tipo de ropa no esta disponible");
                System.out.println("Se lavara como ropa de color / Lavado intenso");
                
                this.LavadoCompleto = 1;
            }
            
        } else {
            System.out.println("No se ha llenado");
        }
    }
    
    private void Secado(){//secado de la lavadora
        Lavado();
        
        //comprobamos si se a lavado completamente
        if (this.LavadoCompleto == 1){
            System.out.println("Secando...");
            
            this.SecadoCompleto = 1;
        }
    }
    
    public void CicloFinalizado(){
        Secado();
        
        //preguntamos si el ciclo llego a terminarse
        if (this.SecadoCompleto == 1) {
            System.out.println("Tu ropa esta lista");
        }
    }
    
    //metodos Setter y Getter
    
    public int getTipoDeRopa(){
        return this.TipoDeRopa;
    }
    
    public void setTipoDeRopa(int TipoDeRopa){
        this.TipoDeRopa = TipoDeRopa;
    }
    
    
}
