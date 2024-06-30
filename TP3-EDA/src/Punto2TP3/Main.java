/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Punto2TP3;

/**
 *
 * @author Ana Kuenneth
 */
public class Main {
    public static void main(String[] args){
        ListaEnlazada<Integer> lista1 = ListaEnlazada.crearLista();
      
      System.out.println("\nAgrego nodos y corroboro las cantidades de cada lista");
      lista1.insertarAlInicio(1);
      System.out.println("Cantidad lista1: "+lista1.cantidad());
      lista1.insertarAlFinal(2);
      System.out.println("Cantidad lista1: "+lista1.cantidad()+"\n");
      
      
      ListaEnlazada<Integer> lista2= ListaEnlazada.crearLista();
      System.out.println("Cantidad lista2: "+lista2.cantidad()+"\n");
      
      System.out.println("Es vacia lista1? "+lista1.esVacia());
      System.out.println("Es vacia lista2? "+lista2.esVacia());
      
      
      System.out.println("\nInserto al inicio de las listas el elemento '1'");
      lista1.insertarAlInicio(1);
      lista2.insertarAlInicio(1);
      System.out.println("Mostrar lista1");
      lista1.mostrar();
      System.out.println("\nMostrar lista2");
      lista2.mostrar();
    }
}
