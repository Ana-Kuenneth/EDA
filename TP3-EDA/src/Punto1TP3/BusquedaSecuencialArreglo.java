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
public class BusquedaSecuencialArreglo {
    //1.
    //Escriba la versión recursiva de búsqueda secuencial en un arreglo. Tal que:
    //  - devuelva la posición de la primera ocurrencia del elemento buscado en el arreglo
    //  - devuelva -1 si el mismo no está presente
    public static int busquedaSecuencialRecursiva(ArrayList<Integer> arreglo, int indice, int elementoBuscado) {
        if (indice == 0 && arreglo.get(indice)!=elementoBuscado) {
            return -1;
        }

        if (arreglo.get(indice) == elementoBuscado) {
            return indice;
        } else {
            return (busquedaSecuencialRecursiva(arreglo, indice - 1, elementoBuscado));
        }
    }
}
