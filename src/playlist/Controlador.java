/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package playlist;

import java.io.File;
import java.util.Arrays;

/**
 * Orquesta las acciones de reproducción sobre la lista de canciones.
 *
 * Actúa como capa de control para iniciar, pausar, reanudar y navegar
 * entre canciones.
 */
public class Controlador {
    
    public String[] getNombresParaLista() {
        return lista.obtenerNombres();
    }
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
     * Si la lista está vacía, informa al usuario por consola.
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
    if (lista.puntero != null) lista.puntero.cancion.pausar(); // antes decía parar()
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
            nuevaCancion.reproducir();//los metodos 
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
    public void cargarDesdeCarpeta(String rutaCarpeta) {
        File carpeta = new File(rutaCarpeta);

        if (carpeta.exists() && carpeta.isDirectory()) {
            // 1. Obtener archivos y filtrar por .wav
            File[] archivos = carpeta.listFiles((dir, nombre) -> nombre.toLowerCase().endsWith(".wav"));

            if (archivos != null && archivos.length > 0) {
                // 2. Ordenar alfabéticamente (Clave para Data Science: Sorting)
                Arrays.sort(archivos, (a, b) -> a.getName().compareToIgnoreCase(b.getName()));

                // 3. Limpiar lista actual si es necesario y llenar
                for (File f : archivos) {
                    // Extraer info básica del nombre del archivo: "Autor - Titulo.wav"
                    // Aquí podrías usar Regex o Split para separar autor y título
                    String nombreSinExt = f.getName().replace(".wav", "");

                    // Creamos el objeto con la RUTA ABSOLUTA para que no falle
                    Cancion nueva = new Cancion(nombreSinExt, "Desconocido", f.getName());
                    // OJO: Tendrías que ajustar el constructor de Cancion para aceptar File o Path completo

                    lista.agregar(nueva);
                }
            }
        }
    }
}