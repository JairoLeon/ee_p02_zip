/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compresor;

/**
 *
 * @author Jairo
 */
public class NodoA <T extends Comparable<T>> implements Comparable<NodoA<T>>{
    private T dato;
    private NodoA<T> nodoIzq;
    private NodoA<T> nodoDer;
    
    public int compareTo(NodoA<T> c)
    {
        return dato.compareTo(c.getDato());
    }
    
    public NodoA(T dato)
    {
        this.dato = dato;
        this.nodoIzq = null;
        this.nodoDer = null;
    }
    
    public T getDato()
    {
        return dato;
    }
    
    public NodoA<T> getNodoIzq()
    {
        return nodoIzq;
    }
    
    public NodoA<T> getNodoDer()
    {
        return nodoDer;
    }
    
    public void setNodoDer(NodoA <T> nodo)
    {
        nodoDer = nodo;
    }
    
    public void setNodoIzq(NodoA <T> nodo)
    {
        nodoIzq = nodo;
    }
    
    public void setDato(T dato)
    {
        this.dato = dato;
    }
    
    public String toString()
    {
        return "("+dato+","+nodoIzq+","+nodoDer+")";
    }
}
