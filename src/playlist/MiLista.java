/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package playlist;

/**
 *
 * @author User
 */
public class MiLista<T> implements ILista<T> {

    Nodo<T> head;
    Nodo<T> tail;

    public void MiLista() {
        head = null;
        tail = null;
    }

    @Override
    public void agregar(T dato) {
        Nodo<T> nodo = new Nodo<>(dato);
        if (head == null) {
            head = nodo;
            tail = nodo;

        } else {
            Nodo<T> temp = head;
            while (temp.next != null) {
                temp = temp.next;

            }
            temp.next = nodo;

        }

    }

    @Override
    public void insertar(int indice, T dato) {
        Nodo<T> nuevo_nodo= new Nodo<>(dato);
        Nodo<T> anterior_nodo = head;
        for (int i = 0; i < indice - 1; i++) {
            anterior_nodo = anterior_nodo.next;
            if (anterior_nodo == null) {
                break;

            }
        }
        
        nuevo_nodo.next= anterior_nodo.next;
        anterior_nodo.next = nuevo_nodo;
        

    }

    @Override
    public void eliminar(int indice) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public T buscar(T criterio) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void mostrar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
