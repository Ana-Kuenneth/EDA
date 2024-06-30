/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Punto2Agenda;

/**
 *
 * @author Ana Kuenneth
 */
public class Agenda {

    public class Contacto {

        private String nombre;
        private String telefono;
        private String email;
        private Contacto siguiente;

        
        public Contacto(String nombre, String telefono, String email) {
            this.nombre = nombre;
            this.telefono = telefono;
            this.email = email;
            this.siguiente = null;
        }

        public Contacto getSiguiente() {
            return siguiente;
        }

        public void setSiguiente(Contacto siguiente) {
            this.siguiente = siguiente;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public String getTelefono() {
            return telefono;
        }

        public void setTelefono(String telefono) {
            this.telefono = telefono;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }
    }

    private Contacto primerNodo;
    private int tamaño;

    public Agenda() {
        this.primerNodo = null;
        this.tamaño = 0;
    }

    public static Agenda crearAgenda() {
        return new Agenda();
    }
    
    public boolean esVacia(){
        return this.primerNodo == null;
    }
    
    public int cantidad(){
        return this.tamaño;
    }
    
    public void agregar(Contacto c) {
        Contacto nuevoContacto = new Contacto(c.getNombre(),c.getTelefono(),c.getEmail());
        if(this.esVacia()){
            this.primerNodo = nuevoContacto;
        }else{
            Contacto nodoAux = this.primerNodo;
            while(nodoAux.getSiguiente()!=null){
                nodoAux = nodoAux.getSiguiente();
            }
            nodoAux.setSiguiente(nuevoContacto);
            this.tamaño++;
        }
    }
    
    public Contacto buscar(String nombre){
        Contacto nodoAux = this.primerNodo;
        if(!this.esVacia()){
            while(!nodoAux.getNombre().equals(nombre)){
                nodoAux = nodoAux.getSiguiente();
            }
            return nodoAux;
        }else{
            return null;
        }
    }
    
    public void borrar(String telefono){
        Contacto nodoAuxiliar = this.primerNodo;
        if (!this.esVacia() && this.primerNodo.getTelefono().equals(telefono)) {
            
            this.primerNodo = nodoAuxiliar.getSiguiente();
            this.tamaño--; 
        
        }
        while (nodoAuxiliar != null) {
            if (nodoAuxiliar.getSiguiente() != null && nodoAuxiliar.getSiguiente().getTelefono().equals(telefono)) {
                nodoAuxiliar.setSiguiente(nodoAuxiliar.getSiguiente().getSiguiente());
                this.tamaño--;
            } else {
                nodoAuxiliar = nodoAuxiliar.getSiguiente(); 
            }

        }
    }
    
    public void listar(){
        if(!this.esVacia()){
            Contacto nodoAux = this.primerNodo;
            while(nodoAux!=null){
                System.out.println(nodoAux.getNombre());
                System.out.println(nodoAux.getTelefono());
                System.out.println(nodoAux.getEmail());
                System.out.println("\n");
                nodoAux = nodoAux.getSiguiente();
            }
        }
    }
    
    public Contacto enPosicion(int posicion){
        int posicionContacto=1;
        Contacto nodoAuxiliar = this.primerNodo;
        if(posicion>this.cantidad()){
            throw new NullPointerException();
        }
        while(posicionContacto<posicion){
            nodoAuxiliar = nodoAuxiliar.getSiguiente();
            posicionContacto++;
        }
        return nodoAuxiliar;
    }
    
    
    //EXTRA
    public boolean existeContacto(String nombreContacto) {
        Contacto nodoAuxiliar = this.primerNodo;

        // Recorrer la lista de contactos
        while (nodoAuxiliar != null) {
            // Comparar el nombre del contacto actual con el nombre buscado
            if (nodoAuxiliar.getNombre().equals(nombreContacto)) {
                return true; // Contacto encontrado
            }

            nodoAuxiliar = nodoAuxiliar.getSiguiente(); // Siguiente nodo
        }

        return false; // Contacto no encontrado
    }
}
