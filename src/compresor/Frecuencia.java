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
public class Frecuencia implements Comparable<Frecuencia>{
    
    private String caracter;
    private Integer frecuencia;
    
    public int compareTo(Frecuencia f)
    {
        return f.getFrecuencia().compareTo(frecuencia);
    }
    
    public Frecuencia(String caracter, Integer frecuencia)
    {
        this.caracter = caracter;
        this.frecuencia = frecuencia;
    }
    
    public Integer getFrecuencia()
    {
        return frecuencia;
    }
    
    public String getCaracter()
    {
        return caracter;
    }
    
    public String toString()
    {
        return caracter+": "+frecuencia;
    }
    
}
