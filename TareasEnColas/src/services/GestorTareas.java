package services;

import models.Tarea;
import structures.Cola;
import structures.Pila;
import structures.ArregloDinamico;

//esta clase es el intermediario entre las estructuras el modelo y el main el pegamento que lo compacta todo
public class GestorTareas {

    private final Cola colaPrincipal = new Cola();
    private final Pila historial = new Pila();
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
}
