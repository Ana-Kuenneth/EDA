/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ordenamiento;

/**
 *
 * @author Ana Kuenneth
 */
public class Main {

    public static void main(String[] args) {
        ListaEnlazada<Integer> lista1 = ListaEnlazada.crearLista();
        
        lista1.insertarAlInicio(5);
        lista1.insertarAlFinal(2);
        lista1.insertarAlFinal(1);
        lista1.insertarAlFinal(4);
        lista1.insertarAlFinal(0);
        lista1.insertarAlFinal(7);
        lista1.insertarAlFinal(6);
        lista1.insertarAlFinal(3);

        System.out.println("Lista 1");
        lista1.mostrar();
        System.out.println("Lista Meclada");
//        lista1.mezclarLista();
        lista1.intercambio();
        lista1.mostrar();
        
    }
}
