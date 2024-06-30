/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package filaADT;

/**
 *
 * @author Ana Kuenneth
 */
public class Fila {
    
    private class Nodo{
        private Integer pedido;
        private Nodo nodoSiguiente;
        
        public Nodo(Integer pedido){
            this.pedido = pedido;
            this.nodoSiguiente=null;
        }

        public Integer getPedido() {
            return pedido;
        }

        public void setPedido(Integer pedido) {
            this.pedido = pedido;
        }

        public Nodo getNodoSiguiente() {
            return nodoSiguiente;
        }

        public void setNodoSiguiente(Nodo nodoSiguiente) {
            this.nodoSiguiente = nodoSiguiente;
        }
    }
    
    private Nodo frente;
    private Nodo ultimoNodo;
    private int longitud = 0;

    public Fila() {
        this.frente = null;
        this.ultimoNodo = null;
    }
    
    public static Fila filaVacia(){
        return new Fila();
    }
    
    public Integer frente(){
        if(this.esFilaVacia()){
            return null;
        }else{
            return this.frente.getPedido();
        }
    }
    
    public boolean esFilaVacia(){
        return this.frente==null;
    }
    
    public Fila enfila(Integer pedido){
        Nodo nuevoNodo = new Nodo(pedido);
        
        if(this.esFilaVacia()){
            this.frente = nuevoNodo;
            this.ultimoNodo = nuevoNodo;
        }
        else{
            this.ultimoNodo.setNodoSiguiente(nuevoNodo);
            this.ultimoNodo = nuevoNodo;
        }
        
        this.longitud++;
        return this;
    }
    
    public Fila defila(){
        if(!this.esFilaVacia()){
            this.frente = this.frente.getNodoSiguiente();
            this.longitud--;
        }
        return this;
    }
    
    public int longitud(){
        return this.longitud;
    }
    
    public void mostrarFila(){
        Nodo nodoAux = this.frente;
        
        if(nodoAux == null){
            System.out.println("La fila es vacia. No hay pedidos");
        }
        
        while(nodoAux != null){
            System.out.println(nodoAux.getPedido());
            nodoAux = nodoAux.getNodoSiguiente();
        }
        
    }
}
