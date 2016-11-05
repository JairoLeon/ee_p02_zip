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
public class Caracter implements Comparable<Caracter>{
    
    private String caracter;
    private String valorBinario;
    
    public int compareTo(Caracter c)
    {
        return valorBinario.compareTo(c.getValorBinario());
    }
    
    public Caracter(String caracter, String valorBinario)
    {
        this.caracter = caracter;
        this.valorBinario = valorBinario;
    }
    
    public String getCaracter()
    {
        return caracter;
    }
    
    public String getValorBinario()
    {
        return valorBinario;
    }
    
    public String toString()
    {
        return caracter+":"+valorBinario;
    }
}
