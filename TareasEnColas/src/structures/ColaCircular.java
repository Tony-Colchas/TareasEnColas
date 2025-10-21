
package structures;

import models.TareaRecurrente;

/**
  Clase ColaCircular
 ======================================================
  Implementa una cola circular con capacidad fija.
  Se usa para manejar las tareas recurrentes del sistema.
 */
public class ColaCircular {

    private final TareaRecurrente[] elementos;
    private int frente;
    private int fin;
    private int tamaño;
    private final int capacidad;

   
    public ColaCircular(int capacidad) {
        this.capacidad = capacidad;
        elementos = new TareaRecurrente[capacidad];
        frente = 0;
        fin = -1;
        tamaño = 0;
    }

    // Encola una nueva tarea recurrente
    public void encolar(TareaRecurrente tarea) {
        if (estaLlena()) {
            System.out.println("⚠ Cola circular llena. No se puede agregar más tareas.");
            return;
        }
        fin = (fin + 1) % capacidad;
        elementos[fin] = tarea;
        tamaño++;
    }

    //le dice a la cola que quite la ultima tarea en la cola
    public TareaRecurrente desencolar() {
        if (estaVacia()) {
            System.out.println("⚠ La cola circular está vacía.");
            return null;
        }
        TareaRecurrente tarea = elementos[frente];
        frente = (frente + 1) % capacidad;
        tamaño--;
        return tarea;
    }
    
     //revisa si esta vacia
    public boolean estaVacia() {
        return tamaño == 0;
    }

    //la cola revisa si esta llena
    public boolean estaLlena() {
        return tamaño == capacidad;
    }

    // envia a la cola a revisar si esta vacia y si no lo esta mostrar su contenido
    public void mostrar() {
        if (estaVacia()) {
            System.out.println("⚠ No hay tareas recurrentes.");
            return;
        }
        System.out.println("Tareas recurrentes en cola:");
        for (int i = 0; i < tamaño; i++) {
            int index = (frente + i) % capacidad;
            System.out.println(" - " + elementos[index]);
        }
    }

   
}
