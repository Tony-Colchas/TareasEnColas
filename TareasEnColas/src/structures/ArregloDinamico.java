
package structures;

import java.util.ArrayList;
import models.Tarea;

/*

se implementa un arreglo dinamico simulado con una lista
porque en java no existen arreglos dinamicos

*/

public class ArregloDinamico {

    private final ArrayList<Tarea> lista = new ArrayList<>();

    /*este metodo se encarga de agregar una tarea 
    y hacer crecer el arreglo en caso de que no haya espacio para seguir agregando tareas
    perfecto para el uso que le damos de base de datos de bajisimo nivel
    */
    public void agregar(Tarea tarea) {
        lista.add(tarea);   
    }

    //le dice a la lista "arreglo" que muestre su contenido
    public void mostrar() {
        if (lista.isEmpty()) {
            System.out.println("⚠ No hay tareas registradas.");
        } else {
            System.out.println("📚 Todas las tareas registradas:");
            for (Tarea t : lista) {
                System.out.println(" - " + t);
            }
        }
    }

    //aqui le dice a la lista de fondo que revise su tamaño para imprimirlo como el tamaño del supuesto arreglo
    public int tamaño() {
        return lista.size();
    }
}
