/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Punto1TP3;

import java.util.ArrayList;

/**
 *
 * @author Ana Kuenneth
 */
public class Main {

    public static void main(String[] args) {
        //Prueba de búsqueda secuencial en un arreglo

        ArrayList<Integer> arreglo = new ArrayList<>();

        arreglo.add(3);
        arreglo.add(4);
        arreglo.add(7);
        arreglo.add(2);
        arreglo.add(9);
        arreglo.add(8);
        arreglo.add(11);

        int indice = arreglo.size()-1;
        int elementoBuscado = 3;
//        System.out.println(indice);
        System.out.println(BusquedaSecuencialArreglo.busquedaSecuencialRecursiva(arreglo, indice, elementoBuscado));
    }
}
