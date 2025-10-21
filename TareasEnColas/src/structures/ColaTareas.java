
package structures;

import java.util.LinkedList;
import java.util.Queue;
import models.Tarea;

/**
 * Implementa una cola FIFO para las tareas pendientes.
 */
public class ColaTareas {
    private final Queue<Tarea> cola = new LinkedList<>();

    //le dice a la cola que agregue otra tarea a la cola
    public void encolar(Tarea tarea) {
        if (cola != null){
        cola.add(tarea);             
        }  else{
    System.out.println("No puede agregar una tarea vacia");
    }
}
    
    //le dice a la cola que quite la ultima tarea agregada
    public Tarea desencolar() {
        return cola.poll();
    }

    //la cola revisa si esta vacia  respondiendo si y no 
    public boolean estaVacia() {
        return cola.isEmpty();
    }

    //le dice a la cola que muestre las tareas en cola
    public void mostrar() {
        if (cola.isEmpty()) {
            System.out.println("📭 No hay tareas en la cola.");
            return;
        }
        System.out.println("📂 Cola de tareas pendientes:");
        for (Tarea t : cola) System.out.println("   " + t);
    }
}