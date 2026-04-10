/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package playlist;

/**
 *
 * @author User
 */
public class Nodo<T> 
{
    T data;
    Nodo<T> next;
    
    public Nodo(T data){
        this.data = data;
        this.next = null;
        
    }
    
    
}
