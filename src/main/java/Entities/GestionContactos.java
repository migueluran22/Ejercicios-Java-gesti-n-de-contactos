package Entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GestionContactos {
    private static List<Contacto> listaContactos = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void mostrarMenu() {
        System.out.println("=== Menú ===");
        System.out.println("1. Agregar contacto");
        System.out.println("2. Buscar contacto");
        System.out.println("3. Mostrar todos los contactos");
        System.out.println("4. Eliminar contacto");
        System.out.println("5. Salir");
    }

    public static void agregarContacto() {
        System.out.println("Ingrese los detalles del contacto:");
        String nombre = obtenerTexto("Nombre: ");
        String telefono = obtenerTexto("Teléfono: ");
        String email = obtenerTexto("Email: ");
        Contacto contacto = new Contacto(nombre, telefono, email);
        listaContactos.add(contacto);
        System.out.println("Contacto agregado correctamente.");
    }

    public static void buscarContacto() {
        String nombreBuscar = obtenerTexto("Ingrese el nombre del contacto a buscar: ");
        boolean encontrado = false;
        for (Contacto contacto : listaContactos) {
            if (contacto.getNombre().equalsIgnoreCase(nombreBuscar)) {
                System.out.println("Contacto encontrado:\n" + contacto);
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            System.out.println("No se encontró ningún contacto con ese nombre.");
        }
    }

    public static void mostrarContactos() {
        if (listaContactos.isEmpty()) {
            System.out.println("No hay contactos en la lista.");
        } else {
            System.out.println("Lista de contactos:");
            for (Contacto contacto : listaContactos) {
                System.out.println(contacto);
            }
        }
    }

    public static void eliminarContacto() {
        if (listaContactos.isEmpty()) {
            System.out.println("No hay contactos para eliminar.");
            return;
        }
        System.out.println("Lista de contactos:");
        for (int i = 0; i < listaContactos.size(); i++) {
            System.out.println((i + 1) + ". " + listaContactos.get(i).getNombre());
        }
        int indiceEliminar = obtenerEntero("Ingrese el número del contacto a eliminar: ") - 1;
        if (indiceEliminar >= 0 && indiceEliminar < listaContactos.size()) {
            listaContactos.remove(indiceEliminar);
            System.out.println("Contacto eliminado correctamente.");
        } else {
            System.out.println("Índice inválido. No se eliminó ningún contacto.");
        }
    }

    public static String obtenerTexto(String mensaje) {
        System.out.print(mensaje);
        return scanner.nextLine();
    }

    public static int obtenerEntero(String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje);
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Por favor, ingrese un número válido.");
            }
        }
    }
}
