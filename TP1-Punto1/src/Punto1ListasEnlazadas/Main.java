/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Punto1ListasEnlazadas;

/**
 *
 * @author Ana Kuenneth
 */
public class Main {
  public static void main(String[] args) {
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
      
      
//      System.out.println("\nInserto al inicio de las listas el elemento '1'");
//      lista1.insertarAlInicio(1);
//      lista2.insertarAlInicio(1);
//      System.out.println("Mostrar lista1");
//      lista1.mostrar();
//      System.out.println("\nMostrar lista2");
//      lista2.mostrar();
//      System.out.println("\nCorroborar si lista2 sigue siendo vacia");
//      System.out.println("Es vacia lista2? "+lista2.esVacia()+"\n");
//      
//      
//      //Borrar primero
//      System.out.println("Borrar primero de lista1");
//      lista1.borrarPrimero();
//      lista1.mostrar();
//      
//      //Borrar último de cada lista
//      System.out.println("Borrar ultimo de lista1");
//      lista1.borrarUltimo();
//      lista1.mostrar();
//      System.out.println("Cantidad lista1: "+lista1.cantidad());
//      System.out.println("\nBorrar ultimo de lista2");
//      lista2.borrarUltimo();
//      lista2.mostrar();
//      
//      System.out.println("Cantidad lista2: "+lista2.cantidad()+"\n");
      
//    System.out.println("\nPertenece valor en lista1:");
//    System.out.println(lista1.pertenece(3));
//    System.out.println(lista1.pertenece(2));
    
//    System.out.println("\nBorrar con valor en lista1:");
    lista1.insertarAlFinal(3);
    lista1.insertarAlFinal(4);
//    lista1.borrarConValor(2);
//    lista1.mostrar();
    
    
    System.out.println("\nDame valor en posicion:");
    System.out.println("Lista1:");
    lista1.mostrar();
    System.out.println("\n");
//    System.out.println(lista1.cantidad());
    System.out.println(lista1.dameValorEnPosicion(3));
//    

//    System.out.println("\nModificar valor en posicion:");
//    System.out.println("Lista1:");
//    lista1.mostrar();
//    System.out.println("\n");
//    lista1.modificarValorEnPosicion(1,1);
//    lista1.mostrar();


//    System.out.println("\nInsertar valor en posicion:");
//    System.out.println("Lista1:");
//    lista1.mostrar();
//    System.out.println("\n");
//    lista1.insertarEnPosicion(6, 2);
//    lista1.mostrar();
  }
}