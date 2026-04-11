/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package playlist;

/**
 * Implementa una lista doblemente enlazada circular de canciones.
 *
 * <p>Mantiene referencias a la cabeza, cola y al nodo actual (puntero)
 * para permitir navegación bidireccional continua.</p>
 */
public class Lista_DEC {
    Nodo head;
    Nodo tail;
    Nodo puntero;

    /**
     * Agrega una canción al final de la lista y mantiene la circularidad.
     *
     * @param cancion canción a insertar
     */
    public void agregar(Cancion cancion) {
        Nodo nodo = new Nodo(cancion);

        if (head == null) {
            head = nodo;
            tail = nodo;
            puntero = nodo;
            // Circularidad absoluta para 1 elemento
            head.next = head;
            head.prev = head;
        } else {
            tail.next = nodo;
            nodo.prev = tail;
            tail = nodo;
            // Cierra el círculo con la cabeza
            tail.next = head;
            head.prev = tail;
        }
    }

    // Ya no comprobamos if(next == null) porque es circular.
    /**
     * Mueve el puntero a la siguiente canción y devuelve su referencia.
     *
     * <p>Antes de avanzar, detiene y libera el clip de la canción actual.</p>
     *
     * @return siguiente canción o null si la lista está vacía
     */
    public Cancion siguienteCancion() {
        if (puntero != null) {
            puntero.cancion.pararyLiberar(); // Apaga la actual
            puntero = puntero.next;          // Avanza
            return puntero.cancion;          // Devuelve la nueva
        }
        return null;
    }

    /**
     * Mueve el puntero a la canción anterior y devuelve su referencia.
     *
     * <p>Antes de retroceder, detiene y libera el clip de la canción actual.</p>
     *
     * @return canción anterior o null si la lista está vacía
     */
    public Cancion anteriorCancion() {
        if (puntero != null) {
            puntero.cancion.pararyLiberar();
            puntero = puntero.prev;
            return puntero.cancion;
        }
        return null;
    }
}