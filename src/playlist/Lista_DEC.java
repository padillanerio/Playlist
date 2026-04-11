/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package playlist;

public class Lista_DEC {
    Nodo head;
    Nodo tail;
    Nodo puntero;

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
    public Cancion siguienteCancion() {
        if (puntero != null) {
            puntero.cancion.pararyLiberar(); // Apaga la actual
            puntero = puntero.next;          // Avanza
            return puntero.cancion;          // Devuelve la nueva
        }
        return null;
    }

    public Cancion anteriorCancion() {
        if (puntero != null) {
            puntero.cancion.pararyLiberar();
            puntero = puntero.prev;
            return puntero.cancion;
        }
        return null;
    }
}