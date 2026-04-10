/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package playlist;

/**
 *
 * @author User
 */
public interface ILista<T> {
    
    // Recibe el objeto (la canción), no el nodo
    void agregar(T dato); 
    
    // Inserta el dato en una posición
    void insertar(int indice, T dato); 
    
    void eliminar(int indice);
    
    // Devuelve el objeto encontrado, no es void
    T buscar(T criterio); 
    
    void mostrar();

    
    
}
