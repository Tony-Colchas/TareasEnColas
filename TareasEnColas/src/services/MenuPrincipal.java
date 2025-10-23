package services;

import java.util.Scanner; //importar el scanner

public class MenuPrincipal {

    private static final Scanner scanner = new Scanner(System.in);
    private static final GestorTareas gestor = new GestorTareas();

    public static void main(String[] args) {
        int opcion;
        do {
            mostrarMenu();
            opcion = leerEntero("Seleccione una opción: ");
            ejecutarOpcion(opcion);
        } while (opcion != 0);

        System.out.println("\n👋 ¡Programa finalizado!");
    }

    //  Muestra las opciones disponibles en el sistema.
    
    private static void mostrarMenu() {
        System.out.println("\n==============================");
        System.out.println("🗂  SISTEMA: TAREAS EN COLAS");
        System.out.println("==============================");
        System.out.println("1. ➕ Agregar tarea");//añadir tareas a la lista en forma de cola
        System.out.println("2. ✔ Completar tarea");//completa la primera tarea anotada
        System.out.println("3. ↩ Deshacer última tarea completada");//desapilar y encolar
        System.out.println("4. 📋 Ver tareas principales");//mostrar cola
        System.out.println("5. 🕓 Ver el historial de tareas completadas");//mostrar la pila
        System.out.println("6. 📚 Ver todas las tareas");//mostrar arreglo dinamico (una lista por debajo)
        System.out.println("0. 🚪 Salir");//terminar el entorno de ejecucion
        System.out.println("==============================");
    }

    //Controla las acciones de cada opción.
    private static void ejecutarOpcion(int opcion){
        switch (opcion){
            case 1:
                agregarTarea();
            break; 
            case 2:
                gestor.completarTarea();
            break;
            case 3:    
                gestor.deshacerTarea();
            break;    
            case 4:
                gestor.mostrarColaPrincipal();
            break;    
            case 5:
                gestor.mostrarHistorial();
            break;    
            case 6:    
                gestor.mostrarTodas();
            break;    
            case 0:
                System.out.println("👋 Saliendo del programa...");
            break;     
            default:
                System.out.println("❌ Opción inválida. Intente nuevamente.");
        }
    }

    // ==================================================
    // MÉTODOS DE OPERACIÓN no definidos en gestor de tareas
    // ==================================================

    private static void agregarTarea() {
        System.out.print("Ingrese descripción de la tarea: ");
        String descripcion = scanner.nextLine().trim();
        if (!descripcion.isEmpty()) {
            gestor.agregarTarea(descripcion);
        } else {
            System.out.println("⚠ La descripción no puede estar vacía.");
        }
    }


    private static int leerEntero(String mensaje) {     // Este metodo revisa cual opcion necesita el usuario
        while (true) {
            try {
                System.out.print(mensaje);
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("❌ Entrada inválida. Ingrese un número.");
            }
        }
    }
}
