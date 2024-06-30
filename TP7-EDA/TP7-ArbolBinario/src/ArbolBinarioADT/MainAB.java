/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ArbolBinarioADT;

import filaADT.Fila;

/**
 *
 * @author Ana Kuenneth
 */
public class MainAB {

    //Enviar excepción para que funcione el método del ADT
    public static void main(String[] args) throws Exception {
        ArbolBinario abA;
        ArbolBinario abB;
        ArbolBinario abC;
        ArbolBinario abIzq = ArbolBinario.abVacio();
        ArbolBinario abDer = ArbolBinario.abVacio();

        abB = ArbolBinario.armarAB(abIzq, 2, abDer);
        abC = ArbolBinario.armarAB(abIzq, 3, abDer);

        abA = ArbolBinario.armarAB(abB, 1, abC);

        //Presentamos lo armado por pantalla
//        System.out.println(abA.raiz());
//        System.out.println(abA.izquierdo().raiz());
//        System.out.println(abA.derecho().raiz());

        //pertenece
//        System.out.println(ArbolBinario.pertenece(abA, 5));
//        System.out.println(abA.pertenece(abA, 1));

        preOrden(abA);
        System.out.println("---");
        ordenSimetrico(abA);
        System.out.println("---");
        posOrden(abA);
        System.out.println("---");
        porNivel(abA);
    }

    
    //listadoPreOrden
    public static void preOrden(ArbolBinario ab) {
        if(!ab.esABVacio()){
            System.out.println(ab.raiz());
            preOrden(ab.izquierdo());
            preOrden(ab.derecho());
        }
    }
    
    //listadoSimetrico
    public static void ordenSimetrico(ArbolBinario ab) {
        if(!ab.esABVacio()){
            ordenSimetrico(ab.izquierdo());
            System.out.println(ab.raiz());
            ordenSimetrico(ab.derecho());
        }
    }
    
    //listadoPostOrden
    public static void posOrden(ArbolBinario ab) {
        if(!ab.esABVacio()){
            posOrden(ab.izquierdo());
            posOrden(ab.derecho());
            System.out.println(ab.raiz());
        }
    }
    
    //listadoPorNivel
     public static void porNivel(ArbolBinario ab) {
        Fila filaAux = Fila.filaVacia();
        ArbolBinario abAux = ArbolBinario.abVacio();
        
        if(!ab.esABVacio()){
            filaAux.enfila(ab);
            
            while(!filaAux.esFilaVacia()){
                abAux = filaAux.frente();
                filaAux = filaAux.defila();
                System.out.println(abAux.raiz());
                
                 if(!abAux.izquierdo().esABVacio()){
                     filaAux = filaAux.enfila(abAux.izquierdo());
                 }
                if(!abAux.derecho().esABVacio()){
                     filaAux = filaAux.enfila(abAux.derecho());
                 }
            }
        }
    }
}
