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
public class Arbol <T extends Comparable<T>>{
    
   private NodoA <T> raiz = new NodoA<T>(null);

    public void setRaiz(NodoA<T>raiz)
    {
        this.raiz=raiz;
    }
    
    public NodoA<T> getRaiz()
    {
        return raiz;
    }
    
    public void preorden(NodoA <T> r)
    {
        if(r!=null)
        {
            preorden(r.getNodoIzq());
            preorden(r.getNodoDer());
        }
    }
    
    public void inorden(NodoA <T> r)
    {
        if(r!=null)
        {   
            inorden(r.getNodoIzq());
            System.out.println(r.getDato());
            inorden(r.getNodoDer());
        }
    }
    
    public void posorden(NodoA <T> r)
    {
        if(r!=null)
        {
            posorden(r.getNodoIzq());
            posorden(r.getNodoDer());
            System.out.println(r.getDato());
        }
    }
    
}
