package tp9EDA;


import tp9EDA.ListaEnlazada;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */


/**
 *
 * @author maria
 */
public class TP9EDA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ListaEnlazada lista = ListaEnlazada.crearLista();
        
        lista.insertarAlInicio(4);
        lista.insertarAlFinal(94);
        lista.insertarAlInicio(45);
        lista.insertarAlFinal(37);
        
        lista.mostrar();
        
        System.out.println("La lista ordenada es: ");
        
        lista.mezclarLista().mostrar();
      
    }
    
}
