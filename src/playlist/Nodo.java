/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package playlist;

/**
 *
 * @author User
 */
public class Nodo 
{
    Cancion cancion;
    Nodo next;
    Nodo prev;
    
    public Nodo(Cancion cancion){
        this.cancion = cancion;
        this.next = null;
        this.prev =  null;
        
    }
    
    
}
