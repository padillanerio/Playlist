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

public class Cancion {
    private String titulo;
    private String autor;
    private String filePath;
    private long posicion; // Variable en minúscula (convención Java)
    private Clip clip;

    public Cancion(String titulo, String autor, String nombreArchivo) {
        this.titulo = titulo;
        this.autor = autor;
        this.filePath = "src\\songs\\" + nombreArchivo;
    }

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

    public void reproducir() {
        if (clip != null) clip.start();
    }

    public void parar() {
        if (clip != null) {
            posicion = clip.getMicrosecondPosition();
            clip.stop();
        }
    }

    public void reanudar() {
        if (clip != null) {
            clip.setMicrosecondPosition(posicion);
            clip.start();
        }
    }

    public void pararyLiberar() {
        if (clip != null) {
            clip.stop();
            clip.close();
        }
    }

    public String getTitulo() { return titulo; }
    public String getAutor() { return autor; }
}