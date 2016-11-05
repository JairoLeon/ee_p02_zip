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
public class ColaPrioridad <T extends Comparable<T>>{
    
    private Lista<T> cola = new Lista<T>();
    
    public boolean isVacia()
    {
        if (cola.getInicio().getSiguiente()!=null)
            return true;
        return false;
    }
    
    public T revisar()
    {
        return cola.getInicio().getDato();
    }
    
    public void insertar(T dato)
    {
        cola.inserta_en_orden(dato);
    }
    
    public T retirar()
    {
        return cola.eliminaInicioDevolviendo();
    }
    
}
