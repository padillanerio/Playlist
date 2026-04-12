/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package playlist;

import java.util.Scanner;

/**
 * Punto de entrada de la aplicación de reproducción de playlist.
 */
public class Playlist {
    /**
     * Inicializa una lista de prueba, crea el controlador y comienza la reproducción.
     *
     * @param args argumentos de línea de comandos (no utilizados)
     */
    public static void main(String[] args) {
        // 1. Instanciamos la Estructura de Datos
        Lista_DEC miPlaylist = new Lista_DEC();

        // 2. Creamos las canciones
        Cancion c4 = new Cancion("After all this time", "Patrick Jordan", "After all this time,Patrick Jordan Patrikios.wav");
        Cancion c2 = new Cancion("Back to the Start", "Autor 2", "Back To The Start,Patrick Jordan Patrikios.wav"); // Asegúrate de tener este archivo para probar
        Cancion c3 = new Cancion("Eyes","Patrick Jordan","Eyes,Patrick Jordan Patrikios.wav");
        Cancion c1 = new Cancion("Lose Yourself to dance","Patrick Jordan","Daft Punk,Lose Yourself to Dance (Official Version).wav");
        // 3. Alimentamos la lista
        miPlaylist.agregar(c1);
        miPlaylist.agregar(c2);
        miPlaylist.agregar(c3);
        miPlaylist.agregar(c4);

        // 4. Conectamos el Cerebro (Controlador)
        Controlador manager = new Controlador(miPlaylist);

        // 5. Pruebas de fuego
      //  manager.iniciar(); // Suena la C1
        
//        Scanner sc = new Scanner(System.in);
//        System.out.println("presiona Enter para terminar");
//        sc.nextLine();
        
        // Simular que le das al botón siguiente en tu interfaz
        // manager.siguiente(); 
        Ventana v = new Ventana(manager); 
        v.actualizarJList(manager);
        v.setVisible(true);
        
    }
}