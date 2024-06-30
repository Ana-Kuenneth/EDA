/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Punto3TP3;

import Punto3TP3.ListaEnlazada.Nodo;

/**
 *
 * @author Ana Kuenneth
 */
public class CalcularSumaMain {
    //3.
    //Dada una lista enlazada de números enteros, escriba un algoritmo recursivo que
    //calcule la suma de los enteros almacenados en los nodos cuyo valor sea superior a
    //un valor umbral pasado como parámetro.

    public static void main(String[] args) {
        ListaEnlazada lista1 = ListaEnlazada.crearLista();

        System.out.println("\nAgrego nodos y corroboro las cantidades de cada lista");
        lista1.insertarAlInicio(1);
        lista1.insertarAlFinal(2);
        lista1.insertarAlFinal(3);
        lista1.insertarAlFinal(4);
        lista1.insertarAlFinal(1);
        lista1.insertarAlFinal(0);
        System.out.println("\n");

        lista1.mostrar();
        System.out.println("\n");
        System.out.println(calcularSuma(lista1, 1));
    }
//
//    public static int calcularSuma(ListaEnlazada lista, int valorUmbral) {
//        int suma = 0;
//        Nodo nodoAux = lista.primerNodo;
//        if (lista.esVacia()) {
//            System.out.println("salio por es vacia");
//            return 0;
//
//        }
//
//        if (nodoAux.getSiguiente() == null) {
//            suma = nodoAux.getNumero();
//            return suma;
//        }
//        return calcularSuma(lista, valorUmbral, nodoAux, suma);
//    }

    public static int calcularSuma(ListaEnlazada lista, int valorUmbral, Nodo nodoAux, int suma) {
        

        if (nodoAux.getNumero() <= valorUmbral) {
            suma = suma+ nodoAux.getNumero();
            lista.borrarPrimero();
            return suma + calcularSuma(lista, valorUmbral, nodoAux, suma);
        }
        return calcularSuma(lista, valorUmbral, nodoAux, suma);
    }
    
    
    public static int calcularSuma(ListaEnlazada lista, int valorUmbral) {
    int suma = 0;
    Nodo nodoAux = lista.primerNodo;

    if (lista.esVacia()) {
        return 0;
    }

    if (nodoAux.getSiguiente() == null) {
        return nodoAux.getNumero() <= valorUmbral ? nodoAux.getNumero() : 0;
    }

    while (nodoAux != null) {
        if (nodoAux.getNumero() <= valorUmbral) {
            suma += nodoAux.getNumero();
            lista.borrarPrimero();
            suma += calcularSuma(lista, valorUmbral, nodoAux.getSiguiente(), suma); // Recursive call
        }
        nodoAux = nodoAux.getSiguiente();
    }

    return suma;
}

}
