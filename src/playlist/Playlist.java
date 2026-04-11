/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package playlist;

import java.util.Scanner;

public class Playlist {
    public static void main(String[] args) {
        // 1. Instanciamos la Estructura de Datos
        Lista_DEC miPlaylist = new Lista_DEC();

        // 2. Creamos las canciones
        Cancion c1 = new Cancion("After all this time", "Patrick Jordan", "After all this time - Patrick Jordan Patrikios.wav");
        Cancion c2 = new Cancion("Segunda Cancion", "Autor 2", "cancion2.wav"); // Asegúrate de tener este archivo para probar

        // 3. Alimentamos la lista
        miPlaylist.agregar(c1);
        miPlaylist.agregar(c2);

        // 4. Conectamos el Cerebro (Controlador)
        Controlador manager = new Controlador(miPlaylist);

        // 5. Pruebas de fuego
        manager.iniciar(); // Suena la C1
        
        Scanner sc = new Scanner(System.in);
        System.out.println("presiona Enter para terminar");
        sc.nextLine();
        
        // Simular que le das al botón siguiente en tu interfaz
        // manager.siguiente(); 
    }
}