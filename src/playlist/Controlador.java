/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package playlist;

/**
 * Orquesta las acciones de reproducción sobre la lista de canciones.
 *
 * <p>Actúa como capa de control para iniciar, pausar, reanudar y navegar
 * entre canciones.</p>
 */
public class Controlador {
    private Lista_DEC lista;

    /**
     * Crea un controlador asociado a una lista doblemente enlazada circular.
     *
     * @param lista estructura que contiene las canciones a reproducir
     */
    public Controlador(Lista_DEC lista) {
        this.lista = lista;
    }

    /**
     * Inicia la reproducción de la canción apuntada actualmente.
     *
     * <p>Si la lista está vacía, informa al usuario por consola.</p>
     */
    public void iniciar() {
        if (lista.puntero != null) {
            lista.puntero.cancion.prepararCancion();
            lista.puntero.cancion.reproducir();
        } else {
            System.out.println("Lista vacía. Agrega canciones primero.");
        }
    }

    /**
     * Pausa la canción actual conservando la posición de reproducción.
     */
    public void pausar() {
        if (lista.puntero != null) lista.puntero.cancion.parar();
    }

    /**
     * Reanuda la canción actual desde la última posición pausada.
     */
    public void reanudar() {
        if (lista.puntero != null) lista.puntero.cancion.reanudar();
    }

    /**
     * Avanza a la siguiente canción, la prepara y la reproduce.
     */
    public void siguiente() {
        Cancion nuevaCancion = lista.siguienteCancion();
        if (nuevaCancion != null) {
            nuevaCancion.prepararCancion();
            nuevaCancion.reproducir();
            System.out.println("Reproduciendo: " + nuevaCancion.getTitulo());
        }
    }

    /**
     * Retrocede a la canción anterior, la prepara y la reproduce.
     */
    public void anterior() {
        Cancion nuevaCancion = lista.anteriorCancion();
        if (nuevaCancion != null) {
            nuevaCancion.prepararCancion();
            nuevaCancion.reproducir();
            System.out.println("Reproduciendo: " + nuevaCancion.getTitulo());
        }
    }
}