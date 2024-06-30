/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package filaADT;

/**
 *
 * @author Ana Kuenneth
 */
public class Main {
    public static void main(String[] args) throws Exception{
        Fila fila = Fila.filaVacia();
        Fila fila2 = Fila.filaVacia();
        
        System.out.println("Es fila vacia? "+fila.esFilaVacia());
        fila.mostrarFila();
        
        fila.enfila(1);
        fila.enfila(2);
        fila.enfila(3);
        fila2.enfila(1);
        fila2.enfila(2);
        fila2.enfila(3);
        
//        fila.mostrarFila();
//        System.out.println("Longitud: "+fila.longitud());
        
//        fila.defila();
//        fila.defila();
//        fila.defila();
        fila.mostrarFila();
        System.out.println("Longitud: "+fila.longitud());
        System.out.println("Es fila vacia? "+fila.esFilaVacia());
        
        
        //***Funciones del usuario
        //pertenece
        //System.out.println("Pertenece? "+ pertenece(fila, 1));
        //System.out.println("Pertenece? "+pertenece(fila2, pedido4));


        //igualF        
        //System.out.println("Son iguales? "+igualF(fila, fila2));
        
        //concat
        //concat(fila, fila2).mostrarFila();

        //invertir
        //invertir(fila).mostrarFila();
    }
    
    public static boolean pertenece(Fila f, Integer num){
        if(f.esFilaVacia()){
            return false;
        }else{
            return f.frente().equals(num) || pertenece(f.defila(), num);
        }
    }
    
    public static boolean igualF(Fila fila1, Fila fila2){
        if(fila1.esFilaVacia() && fila1.esFilaVacia()){
            return true;
        }
        if(fila1.esFilaVacia() || fila2.esFilaVacia()){
            return false;
        }else{
            return fila1.frente().equals(fila2.frente()) && igualF(fila1.defila(), fila2.defila());
        }
    }
    
    public static Fila concat(Fila fila1, Fila fila2){
        if(fila2.esFilaVacia()){
            return fila1;
        }else{
            fila1 = fila1.enfila(fila2.frente());
            fila2 = fila2.defila();
            return concat(fila1, fila2);
        }
    }
    
    public static Fila invertir(Fila fila){
        Fila filaInv = Fila.filaVacia();
        return invertir(fila, filaInv);
    }
    
    private static Fila invertir(Fila fila, Fila filaInv){
        Integer itemAux;
        if(!fila.esFilaVacia()){
            itemAux = fila.frente();
            fila = fila.defila();
            invertir(fila, filaInv);
            filaInv = filaInv.enfila(itemAux);
        }
        return filaInv;
    }
}
