package structures;

import java.util.Stack;
import models.Tarea;

// Implementa una pila LIFO para guardar el historial de tareas completadas.
 
public class Pila {
    private final Stack<Tarea> pila = new Stack<>();

    /*==============================
               Metodos
    ================================*/
    
    //apilar las tareas a la pila
    public void apilar(Tarea tarea) {
        pila.push(tarea);
        System.out.println("📜 Tarea completada guardada en historial: " + tarea);
    }

    //se encarga de quitar la ultima tarea realizada y devolverla a la cola
    public Tarea desapilar() {
        return pila.isEmpty() ? null : pila.pop();
    }

    //la pila revisa si esta vacia
    public boolean estaVacia() {
        return pila.isEmpty();
    }

    //la pila muestra su contenido
    public void mostrar() {
        if (pila.isEmpty()) {
            System.out.println("📭 No hay tareas completadas en el historial.");
            return;
        }
        System.out.println("🕓 Historial de tareas completadas:");
        for (Tarea t : pila) System.out.println("   " + t);
    }
}