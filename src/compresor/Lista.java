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
public class Lista<T extends Comparable<T>> {
    
   private Nodo<T> inicio;
     
    public Nodo <T> getInicio()
    {
        return inicio;
    }
    
    public void setInicio(Nodo <T> inicio)
    {
        this.inicio = inicio;
    }
    
    public void agregarInicio(T dato)
    {
        Nodo <T> nuevo  = new Nodo <T> (dato);
        nuevo.setSiguiente(inicio);
        inicio = nuevo;
    }
    
    public String toString ()
    {
        Nodo <T> temporal = inicio;
        String res ="";
        while(temporal != null)
        {
            res += temporal;
            temporal = temporal.getSiguiente();
        }
        return res + "null";
    }
     
    public void agregaFinal(T dato)
    {
        Nodo <T> temporal;
        temporal = inicio;
        if(inicio == null)
            agregarInicio(dato);
        else
        {
            while(temporal.getSiguiente()!=null)
                temporal = temporal.getSiguiente();
            temporal.setSiguiente(new Nodo <T>(dato));
        }
        
    }
   
    public void insertaAntesDe(T dato, T referencia)
    {
        Nodo <T> temporal, nodoEncontrado=null, nuevo;
        Boolean band = true;
        temporal = inicio;
        while(temporal.getDato()!= referencia && band)
        {
            if(temporal.getSiguiente()!= null)
            {
                nodoEncontrado = temporal;
                temporal = temporal.getSiguiente();
            }else
                band = false;
        }
        
        if(band)
        {
            if(temporal == inicio)
            {
                agregarInicio(dato);
            }else
            {
                nuevo = new Nodo <T> (dato);
                nuevo.setSiguiente(temporal);
                nodoEncontrado.setSiguiente(nuevo);
            }
        }
    }
    
    public void insertaDespuesDe(T dato, T referencia)
    {
        Nodo <T> temporal, nuevo;
        Boolean band = true;
        temporal = inicio;
        while(temporal.getDato()!=referencia&&band)
        {
            if(temporal.getSiguiente()!=null)
            {
                temporal = temporal.getSiguiente();
            }else
            {
                band = false;
            }
        }
        
        if(band)
        {
            if(temporal==inicio)
            {
                agregaFinal(dato);
            }else
            {
                nuevo = new Nodo <T>(dato);
                nuevo.setSiguiente(temporal.getSiguiente());
                temporal.setSiguiente(nuevo);
            }
        }
    }
    
    public void elimina_primero()
    {
        Nodo <T> temporal = inicio;
        if(temporal.getSiguiente()!=null)
        {
            inicio = temporal.getSiguiente();
        }else{
            inicio = null;
        }
    }
    
    public T eliminaInicioDevolviendo()
    {
        Nodo <T> temporal = inicio;
        if(temporal.getSiguiente()!=null)
        {
            inicio = temporal.getSiguiente();
        }else{
            inicio = null;
        }
        return temporal.getDato();
    }
    
    public void eliminaPrimero2()
    {
        if (inicio != null)
            inicio = inicio.getSiguiente();
    }
     
    public void elimina_ultimo()
    {
        Nodo <T> temporal, anterior = null;
        temporal = inicio;
        if(inicio.getSiguiente() == null)
        {
            inicio = null;
        }else{
            while(temporal.getSiguiente()!= null)
            {
                anterior = temporal;
                temporal = temporal.getSiguiente();
            }
            anterior.setSiguiente(null);
        }
    }
    
    public T eliminaFinalDevolviendo()
    {
        Nodo <T> temporal, anterior = null;
        temporal = inicio;
        if(inicio.getSiguiente() == null)
        {
            inicio = null;
        }else{
            while(temporal.getSiguiente()!= null)
            {
                anterior = temporal;
                temporal = temporal.getSiguiente();
            }
            anterior.setSiguiente(null);
        }
        return temporal.getDato();
    }
    
    public void elimina_antes_de(T dato)
    {
        Nodo <T> auxiliar = null, auxiliar2 = null, temporal = inicio;
        Boolean band;
        if(temporal.getDato().equals(dato))
        {
            System.out.println("No hay nodo que preceda");
        }else
        {
        }
    }
        
    public void inserta_en_orden(T dato)
    {
        Nodo <T> temporal, nodoEncontrado=null, nuevo;
        Boolean band = true;//Determina si elemento se encontro
        temporal = inicio;
        if(inicio == null)
        {
            agregarInicio(dato);
        }else
        {
            while(dato.compareTo(temporal.getDato())== -1 && band)
            {
                if(temporal.getSiguiente()!= null)
                {
                    nodoEncontrado = temporal;
                    temporal = temporal.getSiguiente();
                }else
                    band = false;
            }
            if(band)
            {
                if(temporal == inicio)
                {
                    agregarInicio(dato);
                }else
                {
                    nuevo = new Nodo <T> (dato);
                    nuevo.setSiguiente(temporal);
                    nodoEncontrado.setSiguiente(nuevo);
                }
            }else
            {
                agregaFinal(dato);
            }
        }
    }
    
    public Nodo<T> busca (T m)
    {
        Nodo <T> temporal = inicio;
        Boolean band = true;
        while(temporal.getDato().compareTo(m)!=0 && band&& temporal!=inicio)
        {
            if(temporal.getSiguiente()!= null)
            {
                temporal = temporal.getSiguiente();
            }else 
                band = false;
        }
        
        if(band)
            return temporal;
        else
            return null;
    }
    
    public int cuantosElementos(){
        Nodo<T> aux;
        int numElementos=0;
        aux = inicio;
        //Recorremos
        while(aux != null){
            numElementos++;
            aux = aux.getSiguiente();
        }
        return numElementos;
    }
}
