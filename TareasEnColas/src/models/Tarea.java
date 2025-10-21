

package models;

/**
 * esta clase se encarga de representar las tareas no rutinarias en el sistema
 */
/*====================
    Atributos
=====================*/

public class Tarea {
    private static int contador = 1;
    private final int id;
    private String descripcion;
    private boolean completada;

    public Tarea(String descripcion) {
        this.id = contador++;  //Aqui le asigna un identificador numerico unico a cada tarea 
        this.descripcion = descripcion;
        this.completada = false;
    }
     //Getters
    public int getId() { return id; }
    public String getDescripcion() { return descripcion; }
    public boolean isCompletada() { return completada; }

    public void marcarCompletada() {
        this.completada = true;
    }

    @Override //si alguien llama a Tarea, Tarea se presenta de esta manera
    public String toString() {
        return "[" + id + "] " + descripcion + (completada ? " ✅" : " ⏳"); 
    }
}
