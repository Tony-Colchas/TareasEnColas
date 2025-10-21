#Tareas En Colas

Proyecto realizado en el entorno "Netbeans IDE 8.0.3
leguaje implementado "Java"

Este es un programa que actua como un gestor de tareas usando estructuras lineales
las tareas no rutinarias se modelan en una cola
las tareas rutinarias se contienen en una cola circular
el historial de tareas completadas se observan en una pila
y hay una lista que simula ser un arreglo dinamico de fondo implementado con la clase arraylist de java que es usada como
una base de datos pequeña que contenga todas las tareas que ha recibido el programa con su un simbolo que indique su estado
como completado o no completado

el proyecto cuenta con 8 clases separadas en paquetes para mantener ordenado el proyecto
Models
Tarea destinada a usarse en la pila cola y arreglo dinamico
TareaRecurrente destinada a una cola circular

Structures
ArregloDinamico implementado con arraylist
ColaCircular una cola ciclica de tamaño fijo
ColaTareas una cola pensada para contener tareas
HistorialEnPila una pila pensada para ser un historial

services
Gestor de tareas es la clase que une las estructuras con las tareas y usa los metodos correspondientes en cada caso
MenuPrincipal crea la interfaz intuitiva que guiara al usuario a usar de manera correcta el programa 

Proyecto académico desarrollado para la asignatura Estructura de Datos – Universidad Nacional de Colombia.
