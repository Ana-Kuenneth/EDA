/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Punto2Agenda;

import Punto2Agenda.Agenda.Contacto;

/**
 *
 * @author Ana Kuenneth
 */
public class MainAgenda {

    public static void main(String[] args) {
        Agenda agenda1 = Agenda.crearAgenda();
        Agenda agenda2 = Agenda.crearAgenda();
        
//        agenda1.agregar(c);

        unirContactos(agenda1, agenda2);

        System.out.println("Agenda 1:");
        agenda1.listar();

        System.out.println("\nAgenda 2:");
        agenda2.listar();
    }

    public static void unirContactos(Agenda agenda1, Agenda agenda2) {
        // Validar que ambas agendas no sean nulas
        if (agenda1 == null || agenda2 == null) {
            throw new IllegalArgumentException("Las agendas no pueden ser nulas");
        }
        
        

        // Recorrer los contactos de la agenda de origen utilizando enPosicion
        for (int i = 1; i <= agenda2.cantidad(); i++) {
            Contacto contactoAgenda2 = agenda2.enPosicion(i);

            // Verificar si el contacto ya existe en la agenda de destino
            boolean contactoExiste = agenda1.existeContacto(contactoAgenda2.getNombre());

            // Si el contacto no existe, agregarlo a la agenda de destino
            if (!contactoExiste) {
                agenda1.agregar(contactoAgenda2);
            }
        }

    }

}
