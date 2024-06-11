package org.example;

import static Entities.GestionContactos.*;

public class Main {
    public static void main(String[] args) {
        int opcion;
        do {
            mostrarMenu();
            opcion = obtenerEntero("Seleccione una opción: ");
            switch (opcion) {
                case 1:
                    agregarContacto();
                    break;
                case 2:
                    buscarContacto();
                    break;
                case 3:
                    mostrarContactos();
                    break;
                case 4:
                    eliminarContacto();
                    break;
                case 5:
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
            }
        } while (opcion != 5);
    }


}