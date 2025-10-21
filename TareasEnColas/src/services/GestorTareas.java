
package services;

import models.Tarea;
import models.TareaRecurrente;
import structures.ColaTareas;
import structures.ColaCircular;
import structures.HistorialEnPila;
import structures.ArregloDinamico;

//esta clase es el intermediario entre las estructuras el modelo y el main el pegamento que lo compacta todo
public class GestorTareas {

    private final ColaTareas colaPrincipal = new ColaTareas();
    private final ColaCircular recurrentes = new ColaCircular(15); // cola circular con capacidad fija
    private final HistorialEnPila historial = new HistorialEnPila();
    private final ArregloDinamico registro = new ArregloDinamico();

    /** Agrega una tarea normal a la cola */
    public void agregarTarea(String descripcion) {
        if (descripcion!= null){
        Tarea t = new Tarea(descripcion);
        colaPrincipal.encolar(t);
        registro.agregar(t);
        System.out.println("✅ Tarea agregada con éxito.");
        } else {
            System.out.println("la descripcion no puede estar vacia");
        }
    }

    //Marca la primera tarea como completada y la mueve al historial 
    public void completarTarea() {
        Tarea t = colaPrincipal.desencolar();
        if (t != null) {
            t.marcarCompletada();
            historial.apilar(t);
            System.out.println("✔ Tarea completada y movida al historial.");
        } else {
            System.out.println("⚠ No hay tareas en la cola principal.");
        }
    }

    // Agrega una tarea recurrente 
    public void agregarTareaRecurrente(String descripcion) {
        TareaRecurrente t = new TareaRecurrente(descripcion);
        recurrentes.encolar(t);
        System.out.println("🔁 Tarea recurrente agregada.");
    }

    // Ejecuta la siguiente tarea rutinaria
    public void ejecutarTareaRecurrente() {
        TareaRecurrente t = recurrentes.desencolar();
        if (t != null) {
            System.out.println("▶ Ejecutando tarea recurrente: " + t);
            recurrentes.encolar(t); // vuelve al final
        } else {
            System.out.println("⚠ No hay tareas recurrentes.");
        }
    }

    //Deshace la última tarea completada 
    public void deshacerTarea() {
        Tarea t = historial.desapilar();
        if (t != null) {
            t.marcarCompletada();
            colaPrincipal.encolar(t);
            System.out.println("↩ Tarea devuelta a la cola principal.");
        } else {
            System.out.println("⚠ No hay tareas para deshacer.");
        }
    }

    // Muestra todas las tareas registradas 
    public void mostrarTodas() {
        registro.mostrar(); 
    }

    // Muestra el contenido de cada estructura 
    public void mostrarColaPrincipal() {
        colaPrincipal.mostrar();
    }

    public void mostrarHistorial() {
        historial.mostrar();
    }

    public void mostrarRecurrentes() {
        recurrentes.mostrar();
    }
}
