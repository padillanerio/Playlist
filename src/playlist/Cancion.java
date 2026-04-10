/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package playlist;

/**
 *
 * @author User
 */
public class Cancion {
    
    private String nombre;
    private String autor;
   
    
    public void Cancion(String nombre, String autor)
    {
        this.nombre = nombre;
        this.autor = autor;
        
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    @Override
    public String toString() {
        return "Cancion{" + "nombre=" + nombre + ", autor=" + autor + '}';
    }
    
    
}
