/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package playlist;

public class Controlador {
    private Lista_DEC lista;

    public Controlador(Lista_DEC lista) {
        this.lista = lista;
    }

    public void iniciar() {
        if (lista.puntero != null) {
            lista.puntero.cancion.prepararCancion();
            lista.puntero.cancion.reproducir();
        } else {
            System.out.println("Lista vacía. Agrega canciones primero.");
        }
    }

    public void pausar() {
        if (lista.puntero != null) lista.puntero.cancion.parar();
    }

    public void reanudar() {
        if (lista.puntero != null) lista.puntero.cancion.reanudar();
    }

    public void siguiente() {
        Cancion nuevaCancion = lista.siguienteCancion();
        if (nuevaCancion != null) {
            nuevaCancion.prepararCancion();
            nuevaCancion.reproducir();
            System.out.println("Reproduciendo: " + nuevaCancion.getTitulo());
        }
    }

    public void anterior() {
        Cancion nuevaCancion = lista.anteriorCancion();
        if (nuevaCancion != null) {
            nuevaCancion.prepararCancion();
            nuevaCancion.reproducir();
            System.out.println("Reproduciendo: " + nuevaCancion.getTitulo());
        }
    }
}