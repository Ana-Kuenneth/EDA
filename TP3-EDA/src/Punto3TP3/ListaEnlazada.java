/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Punto3TP3;



/**
 *
 * @author Ana Kuenneth
 */
public class ListaEnlazada {

    public Nodo primerNodo;
    private int tamaño;

    public ListaEnlazada() {
        this.primerNodo = null;
        this.tamaño = 0;
    }

    //O(1)
    public static ListaEnlazada crearLista() {
        return new ListaEnlazada();
    }

    //O(1)
    public boolean esVacia() {
        return this.primerNodo == null;
    }
    
    
    

    //O(1)
    public void insertarAlInicio(int numero) {
        Nodo nodo = new Nodo(numero); //O(1)
        nodo.setSiguiente(this.primerNodo); //O(1)
        this.primerNodo = nodo; //O(1)
        this.tamaño++;
    }

    //O(n)
    public void insertarAlFinal(int numero) {
        Nodo nodoFinal = new Nodo(numero); //O(1)
        boolean esVacia = this.esVacia(); //O(1)
        if (esVacia) { //O(1)
            this.primerNodo = nodoFinal; //O(1) --- O(1)
        } else {
            Nodo auxiliar = this.primerNodo; //O(1)
            while (auxiliar.getSiguiente() != null) { //n iteraciones --- O(n)
                auxiliar = auxiliar.getSiguiente();   //O(1)
            }
            auxiliar.setSiguiente(nodoFinal); //O(1)
            this.tamaño++;
        }
    }

    //2.
    //Rediseñar el método mostrar de su clase ListaEnlazada del TP1 para que sea recursiva
    public void mostrar() {
        mostrarRecursivo(this.primerNodo); // Iniciar la recursión desde el primer nodo
    }
   
    private void mostrarRecursivo(Nodo nodoActual) {
        if (nodoActual == null) {
            return; // Caso base: Nodo nulo, fin de la recursión
        }

        System.out.println(nodoActual.getNumero()); // Imprimir el valor actual

        mostrarRecursivo(nodoActual.getSiguiente()); // Llamada recursiva para el siguiente nodo
    }

    


    
    //O(1)
    public int cantidad() {
        return this.tamaño;
    }

    //Debe ser O(1) idealmente
    //O(1)
    public void borrarPrimero() {
        Nodo auxiliar = this.primerNodo; //O(1)
        if (!this.esVacia()) { //O(1)
            this.primerNodo = auxiliar.getSiguiente(); //O(1)
            this.tamaño--; //O(1)
        }
    }

    //Debe ser O(n) sí o sí
    //O(n)
    public void borrarUltimo() {
        Nodo auxiliar = this.primerNodo; //O(1)
        if (!this.esVacia()) { //O(1)
            if (auxiliar.getSiguiente() == null) { //O(1) --- O(1)
                this.primerNodo = null; //O(1)
                this.tamaño--;
            } else { // --- O(n)
                while (auxiliar.getSiguiente().getSiguiente() != null) { //n iteraciones --- O(n)
                    auxiliar = auxiliar.getSiguiente(); //O(1)
                }
                auxiliar.setSiguiente(null); //O(1)
                this.tamaño--;
            }
        }
    }

    //Debe quedar como O(n)
    //O(n)
    public boolean pertenece(int buscado) {
        Nodo auxiliar = this.primerNodo; //O(1)
        if (this.esVacia()) { //O(1)
            return false; //O(0)
        } else {
            if (auxiliar.getNumero() == buscado) { //O(1) --- O(1)
                return true; //O(1)
            } else { // --- O(n)
                auxiliar = auxiliar.getSiguiente();
                while (auxiliar != null && auxiliar.getNumero() != buscado) { //n iteraciones --- O(n)
                    auxiliar = auxiliar.getSiguiente(); //O(1)
                }
                return auxiliar != null; //O(1)
            }
        }
    }

    //O(n)
    public void borrarConValor(int buscado) {

        if (!this.esVacia() && this.primerNodo.getNumero() == buscado) { //O(1)
            this.borrarPrimero(); //O(1)
        }
        Nodo nodoAuxiliar = this.primerNodo; //O(1)
        while (nodoAuxiliar != null) { //n iteraciones --- O(n)
            if (nodoAuxiliar.getSiguiente() != null && nodoAuxiliar.getSiguiente().getNumero() == buscado) { //O(1)
                nodoAuxiliar.setSiguiente(nodoAuxiliar.getSiguiente().getSiguiente()); //O(1)
                this.tamaño--; //O(1)
            } else {
                nodoAuxiliar = nodoAuxiliar.getSiguiente(); //O(1)
            }

        }
    }

    //O(n)
    public int dameValorEnPosicion(int posicionBuscar) {
        Nodo nodoAuxiliar = this.primerNodo; //O(1)
        int posicionNodo = 0; //O(1)
        if (posicionBuscar > this.cantidad()) { //O(1)
            throw new NullPointerException(); //O(1)
        }
        while (posicionNodo < posicionBuscar) { //n iteraciones --- O(n)
            nodoAuxiliar = nodoAuxiliar.getSiguiente(); //O(1)
//            System.out.println("Nodo"+nodoAuxiliar.getNumero());
            posicionNodo++; //O(1)
        }
        return nodoAuxiliar.getNumero(); //O(1)

    }

    //O(n)
    public void modificarValorEnPosicion(int valor, int posicion) {
        Nodo nodoAuxiliar = this.primerNodo; //O(1)
        if (this.esVacia()) { //O(1)
            return; //O(0)
        }
        if (posicion > this.cantidad()) { //O(1)
            throw new NullPointerException(); //O(1)
        } else {
            int indice = 0; //O(1)
            while (indice != posicion) { //n iteraciones --- O(n)
                nodoAuxiliar = nodoAuxiliar.getSiguiente(); //O(1)
                indice++; //O(1)
            }
            nodoAuxiliar.setNumero(valor); //O(1)
        }
    }

    //O(n)
    public void insertarEnPosicion(int valor, int posicion) {
        Nodo nodoNuevo = new Nodo(valor); //O(1)
        boolean esVacia = this.esVacia(); //O(1)
        int cantidad = this.cantidad(); //O(1)
        if (esVacia) { //O(1)
            this.primerNodo = nodoNuevo; //O(1)
        }
        if (posicion == 0) { //O(1)
            this.insertarAlInicio(valor); //O(1)
        }
        if (posicion > cantidad) { //O(1)
            this.insertarAlFinal(valor); //O(n) --- O(n)
        } else {
            Nodo auxiliar = this.primerNodo; //O(1)
            int posicionRecorrer = 0; //O(1)
            while (posicionRecorrer != posicion - 1) { //n iteraciones --- O(n)
                auxiliar = auxiliar.getSiguiente();   //O(1)
                posicionRecorrer++; //O(1)
            }
            nodoNuevo.setSiguiente(auxiliar.getSiguiente()); //O(1)
            auxiliar.setSiguiente(nodoNuevo); //O(1)
        }
    }

    public class Nodo {

        private int numero;
        private Nodo siguiente;

        public Nodo(int numero) {
            this.numero = numero;
            this.siguiente = null;
        }

        //O(1)
        public int getNumero() {
            return numero;
        }

        //O(1)
        public void setNumero(int numero) {
            this.numero = numero;
        }

        //O(1)
        public Nodo getSiguiente() {
            return siguiente;
        }

        //O(1)
        public void setSiguiente(Nodo siguiente) {
            this.siguiente = siguiente;
        }

    }
    
}