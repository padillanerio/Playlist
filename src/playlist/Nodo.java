/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package playlist;

/**
 * Nodo de una lista doblemente enlazada circular de canciones.
 *
 * <p>Guarda la canción actual y las referencias al siguiente y anterior nodo.</p>
 */
public class Nodo 
{
    Cancion cancion;
    Nodo next;
    Nodo prev;
    
    /**
     * Crea un nodo que encapsula una canción.
     *
     * @param cancion canción asociada al nodo
     */
    public Nodo(Cancion cancion){
        this.cancion = cancion;
        this.next = null;
        this.prev =  null;
        
    }
    
    
}
