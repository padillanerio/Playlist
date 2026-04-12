/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package playlist;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 * Representa una canción reproducible dentro de la playlist.
 *
 * <p>Administra metadatos básicos (título, autor), la ruta del archivo de audio
 * y el estado de reproducción para pausar y reanudar.</p>
 */
public class Cancion {
    private String titulo;
    private String autor;
    private String filePath;
    private long posicion; // Variable en minúscula (convención Java)
    private Clip clip;

    /**
     * Crea una canción asociada a un archivo ubicado en la carpeta songs.
     *
     * @param titulo nombre de la canción
     * @param autor autor o intérprete
     * @param nombreArchivo nombre del archivo de audio (por ejemplo, archivo.wav)
     */
    public Cancion(String titulo, String autor, String nombreArchivo) {
        this.titulo = titulo;
        this.autor = autor;
        this.filePath = "src\\songs\\" + nombreArchivo;
    }

    /**
     * Carga el archivo de audio en memoria y deja el clip listo para reproducción.
     *
     * <p>Si ya existe un clip abierto, lo cierra antes de cargar uno nuevo.</p>
     */
    public void prepararCancion() {
        if (this.clip != null && this.clip.isOpen()) {
            this.clip.close();
        }
        try {
            File songFile = new File(this.filePath);
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(songFile);
            this.clip = AudioSystem.getClip();
            this.clip.open(audioStream);
            System.out.println("Éxito: " + titulo + " lista para sonar.");
        } catch (UnsupportedAudioFileException e) {
            System.out.println("Error: Formato no soportado.");
        } catch (Exception e) {
            System.out.println("Error fatal al cargar: " + e.getMessage());
        }
    }

    /**
     * Inicia o continúa la reproducción desde la posición actual del clip.
     */
    public void reproducir() {
        if (clip != null) clip.start();
    }

    /**
     * Pausa la reproducción guardando la posición actual para poder reanudar.
     */
    public void pausar() {
        if (clip != null && clip.isRunning()) {
            posicion = clip.getMicrosecondPosition();
            clip.stop();
        }
    }

    public void reanudar() {
        if (clip != null && !clip.isRunning()) {  // ← verifica que NO esté corriendo
            clip.setMicrosecondPosition(posicion);
            clip.start();
        }
    }

    /**
     * Detiene la reproducción y libera los recursos del clip actual.
     */
    public void pararyLiberar() {
        if (clip != null) {
            clip.stop();
            clip.close();
        }
    }

    /**
     * Obtiene el título de la canción.
     *
     * @return título de la canción
     */
    public String getTitulo() { return titulo; }

    /**
     * Obtiene el autor de la canción.
     *
     * @return autor de la canción
     */
    public String getAutor() { return autor; }
}