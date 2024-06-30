/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ArbolBinarioADT;

import java.util.Objects;

/**
 *
 * @author equipoX
 */
public class ArbolBinario {
    private Integer raiz;
    private ArbolBinario izquierdoArbol;
    private ArbolBinario derechoArbol;
    
    //Contructor predeterminado, no necesario agregar
    //private ArbolBinario() {
    //}
    
    //Setter Raíz. No es necesario implementar
    private void setRaiz(Integer num){
        this.raiz = num;
    }
    
    public Integer raiz(){
        return this.raiz;
    }
    
    public ArbolBinario izquierdo(){
        return this.izquierdoArbol;
    } 
    
    public ArbolBinario derecho(){
        return this.derechoArbol;
    }
        
    public static ArbolBinario abVacio(){
        return new ArbolBinario();
    }
    
    public boolean esABVacio(){
        return (this.raiz == null && this.izquierdoArbol == null && this.derechoArbol == null);
    }
    
    public static ArbolBinario armarAB(ArbolBinario izq, Integer num, ArbolBinario der) throws Exception{
        ArbolBinario abAux = abVacio();
        
        //está mal enviar una excepción?
        if(num == null){
            //return null; 
            //esta mal, debe retornar una excepcion o un arbol
            
            throw new Exception("No se puede crear un arbol binario sin un valor dato");
       }
        
        if(izq == null){
            abAux.izquierdoArbol = abVacio();
        } else {
            abAux.izquierdoArbol = izq;
        }
        
        if(der == null){
            abAux.derechoArbol = abVacio();
        } else {
            abAux.derechoArbol = der;
        }
        
        //Se asigna el valor a la raíz privada
        abAux.setRaiz(num); 
        
        return abAux;
    }
    
    //Debe ser static o no?
    public static boolean pertenece(ArbolBinario ab, Integer num){
        if(ab.esABVacio()){
            return false;
        }
        else{
            if(ab.raiz().equals(num)){
                return true;
            }
            else{
                return pertenece(ab.izquierdo(), num) || pertenece(ab.derecho(), num);
            }
        }
    }
    
}
