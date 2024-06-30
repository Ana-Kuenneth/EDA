/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp9EDA;

/**
 *
 * @author maria
 */
public class ListaEnlazada {

    private int largoLista;
    private Nodo primero;

    //constructor de ListaEnlazada
    public ListaEnlazada() {
        this.primero = null;
        this.largoLista = 0;
    }

    private class Nodo {

        private int numeroEntero;
        private Nodo siguiente;

        //constructor
        public Nodo(int numeroEntero) {
            this.setNumeroEntero(numeroEntero);
        }

        //Metodos getter y setter
        public void setSiguiente(Nodo siguiente) {
            this.siguiente = siguiente;
        }

        public Nodo getSiguiente() {
            return siguiente;
        }

        public int getNumeroEntero() {
            return numeroEntero;
        }

        public void setNumeroEntero(int numeroEntero) {
            this.numeroEntero = numeroEntero;
        }
    }

    //Metodos
    public static ListaEnlazada crearLista() {
        ListaEnlazada lista = new ListaEnlazada();
        return lista;
    }

    public boolean esVacia() {
        return (primero == null);
    }

    public void insertarAlInicio(int x) {
        Nodo auxiliar = new Nodo(x);
        auxiliar.setSiguiente(this.primero);
        this.primero = auxiliar;
    }

    public void insertarAlFinal(int x) {
        Nodo nuevoNodo = new Nodo(x);
        if (this.esVacia()) {
            this.primero = nuevoNodo;
        } else {
            Nodo auxiliar = primero;
            while (auxiliar.getSiguiente() != null) {
                auxiliar = auxiliar.getSiguiente();
            }
            auxiliar.setSiguiente(nuevoNodo);
        }
    }

    public void mostrar() {
        Nodo auxiliar = this.primero;
        while (auxiliar != null) {
            System.out.println(auxiliar.getNumeroEntero());
            auxiliar = auxiliar.getSiguiente();
        }
    }

    public int cantidad() {
        int cantidadNodos = 0;
        Nodo auxiliar = this.primero;

        if (esVacia()) {
            return 0;
        } else {
            while (auxiliar != null) {
                cantidadNodos++;
                auxiliar = auxiliar.getSiguiente();
            }
            return cantidadNodos;
        }
    }

    public void borrarPrimero() {
        //Nodo auxiliar;
        //auxiliar= primero.getSiguiente();
        //primero= auxiliar;
        if (primero == null) {
            return;
        } else {
            primero = primero.getSiguiente();
        }
    }

    public void borrarUltimo() {
        if (this.primero.getSiguiente() != null) {
            Nodo auxiliar = this.primero;
            while (auxiliar.getSiguiente().getSiguiente() != null) {
                auxiliar = auxiliar.getSiguiente();
            }
            auxiliar.setSiguiente(null);
        }
    }

    public boolean pertenece(int buscado) {
        if (esVacia()) {
            return false;
        } else {
            Nodo auxiliar = this.primero;
            while (auxiliar != null) {
                if (auxiliar.getNumeroEntero() == buscado) {
                    return true;
                } else {
                    auxiliar = auxiliar.getSiguiente();
                }
            }
            return false;
        }
    }

    public void borrarConValor(int buscado) {
        if (esVacia()) {
            return;
        } else {
            if (primero.getNumeroEntero() == buscado) {
                this.borrarPrimero();
            } else {
                Nodo auxiliar = this.primero;
                while (auxiliar != null) {
                    if (auxiliar.getSiguiente().getNumeroEntero() == buscado) {
                        auxiliar.setSiguiente(auxiliar.getSiguiente().getSiguiente());
                    } else {
                        auxiliar = auxiliar.getSiguiente();
                    }
                }
            }
        }
    }

    public int dameValorEnPosicion(int posicion) {
        if (esVacia()) {
            return 0;
        } else {
            Nodo auxiliar = this.primero;
            int lugar = 1;
            while (auxiliar != null) {
                if (lugar == posicion) {
                    return auxiliar.getNumeroEntero();
                } else {
                    auxiliar = auxiliar.getSiguiente();
                    lugar++;
                }
            }
        }
        return 0;

    }

    public void modificarValorEnPosicion(int valor, int posicion) {
        if (esVacia()) {
            return;
        } else {
            if (posicion > this.cantidad()) {
                throw new NullPointerException();
            } else {
                int lugar = 1;
                Nodo auxiliar = this.primero;
                while (auxiliar != null) {
                    if (lugar == posicion) {
                        auxiliar.setNumeroEntero(valor);
                    } else {
                        auxiliar = auxiliar.getSiguiente();
                        lugar++;
                    }
                }
            }

        }
    }

    public void insertarEnPosicion(int valor, int posicion) {
        if (esVacia()) {
            this.insertarAlInicio(valor);
        } else {
            if (posicion > this.cantidad()) {
                throw new NullPointerException();
            } else {
                Nodo auxiliar = this.primero;
                int lugar = 1;
            }
        }
    }

    //MODIFICACIONES DE LA CLASE LISTAENLAZADA DEL TP1 AGREGANDOLE LAS FUNCIONES PARA METODO ORDENAMIENTO MERGESORT
    public ListaEnlazada mezclarLista() {
        
        ListaEnlazada izq = ListaEnlazada.crearLista();
        ListaEnlazada der = ListaEnlazada.crearLista();
        if (this.cantidad() <= 1) {
            return this;
        } else {
            dividirLista(izq, der);
            return combinarLista(izq.mezclarLista(), der.mezclarLista());
        }
    }

    private void dividirLista(ListaEnlazada izq, ListaEnlazada der) {
        int medio= this.cantidad();
        Nodo aux;

        medio = medio / 2;
        aux = this.primero;
        while (aux != null) {
            if (medio > 0) {
                izq.insertarAlFinal(aux.getNumeroEntero());
            } else {
                der.insertarAlFinal(aux.getNumeroEntero());
            }
            medio--;
            aux = aux.getSiguiente();
        }
    }

    private ListaEnlazada combinarLista(ListaEnlazada l1, ListaEnlazada l2) {
        ListaEnlazada resultante = ListaEnlazada.crearLista();

        while (!l1.esVacia() && !l2.esVacia()) {
            if (l1.primero.getNumeroEntero() < l2.primero.getNumeroEntero()) {
                resultante.insertarAlFinal(l1.primero.getNumeroEntero());
                l1.borrarPrimero();
            } else {
                resultante.insertarAlFinal(l2.primero.getNumeroEntero());
                l2.borrarPrimero();
            }
        }
        while (!l1.esVacia()&& l2.esVacia()) {
            resultante.insertarAlFinal(l1.primero.getNumeroEntero());
            l1.borrarPrimero();
        }
        while (!l2.esVacia() && l1.esVacia()) {
            resultante.insertarAlFinal(l2.primero.getNumeroEntero());
            l2.borrarPrimero();
        }
        return resultante;
    }

    public void intercambio() {
        Nodo aux, ultimo = null;
        Integer swap;
        aux = this.primero;
        while (aux != ultimo) {
            while (aux.getSiguiente() != ultimo) {
                if (aux.getNumeroEntero() > aux.getSiguiente().getNumeroEntero()) {
                    swap = aux.getNumeroEntero();
                    aux.setNumeroEntero(aux.getSiguiente().getNumeroEntero());
                    aux.getSiguiente().setNumeroEntero(swap);
                }
                aux = aux.getSiguiente();
            }
            ultimo = aux;
            aux = primero;
        }
    }
}
