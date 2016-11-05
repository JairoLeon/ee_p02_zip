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
import java.io.*;
public class AnalisisArchivo {
    
    private BufferedWriter bw;
    private BufferedReader br;
      
    private char caracteres[] = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J','K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T','U', 'V', 
                        'W', 'X', 'Y', 'Z','a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y',
                        'z',' ','ñ','Ñ','.',',',':',';','0','1','2','3','4','5','6','7','8','9','¿','?','!','¡','$','%','&','/','(',')','*','-',
                        '+','{','}','-','_','#','@','\"','\'','á','é','í','ó','ú'};
    
    private ColaPrioridad <NodoA<Frecuencia>> cola = new ColaPrioridad <NodoA<Frecuencia>>();   
    private Lista <Frecuencia> lista = new Lista<Frecuencia>();
    private Lista <Caracter> listaB = new Lista<Caracter>();
    int tLetras = 0;
    String arb = "";
    String rutaA = "";
    
    /**
     *Metodo para analizar el archivo que se desea comprimir y saber las frecuencias, asi como el tamaño del archivo 
     * @param nArchivoTxt 
     */
    public void analizar(String nArchivoTxt)
    {
        rutaA = nArchivoTxt;
        int tL[] = new int[95];
        try 
        {
            br = new BufferedReader(new FileReader(nArchivoTxt));
            String s = br.readLine();
            while (s != null)
            {
                for (int i = 0; i < s.length(); i++)
                {
                    for(int j = 0;j<caracteres.length;j++)
                        if(s.charAt(i)==caracteres[j])
                            tL[j]++;
                }
                s = br.readLine();
            }
            
            for (int i = 0; i < tL.length; i++)
            {
                if(tL[i] > 0)
                {
                    lista.inserta_en_orden(new Frecuencia(caracteres[i]+"",tL[i]));
                    cola.insertar(new NodoA<Frecuencia> (new Frecuencia(caracteres[i]+"",tL[i])));
                }
                tLetras += tL[i];
            }
        } catch(IOException e) 
        {
            System.out.println("Error E/S: " + e);
        }
        finally
        {
            try 
            {
                br.close();
            }catch(Exception e)
            {
                System.out.println("Error al intentar cerrar el archivo");
            }
        }
    }
    /**
     * metodo para crear el arbol de huffman
     */
    public void llenarArbol()
    {
        NodoA <Frecuencia> nodo1 = new NodoA<Frecuencia>(null);
        NodoA <Frecuencia> nodo2 = new NodoA<Frecuencia>(null);
        NodoA <Frecuencia> arbol = new NodoA<Frecuencia>(null);
        while (cola.isVacia())
        {   
            nodo1 = cola.retirar();
            nodo2 = cola.retirar();
            arbol.setDato(new Frecuencia (null,nodo1.getDato().getFrecuencia()+nodo2.getDato().getFrecuencia()));
            arbol.setNodoDer(nodo2);
            arbol.setNodoIzq(nodo1);
            cola.insertar(arbol);
            arbol = new NodoA<Frecuencia>(null);
        }   
    }
    /**
     * recorre el arbol huffman, asignando 0s a la izquierda y 1s a la derecha
     * @param r
     * @param s 
     */
    public void recorreArbol(NodoA <Frecuencia> r, String s)
    {
        if(r!=null)
        {
            String t = s;
            if(r.getNodoIzq()==null&&r.getNodoDer()==null)
            {
                arb += s+r.getDato().getCaracter();
                listaB.agregaFinal(new Caracter(r.getDato().getCaracter(),s));
            }
            recorreArbol(r.getNodoIzq(),s+="0");
            recorreArbol(r.getNodoDer(),t+="1");
        }
    }
    
    public void llena()
    {
        recorreArbol(cola.retirar(),"");
    }
    /**
     * comprime a partir del arbol huffman previamente creado
     * @param nArchivoTxt 
     */
    public void comprimir(String nArchivoTxt)
    {
        try 
        {
            br = new BufferedReader(new FileReader(nArchivoTxt));
            String s = br.readLine();
            Nodo <Caracter> temporal = listaB.getInicio();
            String mensaje = "";
            while (s != null)
            {
                for(int i = 0;i<s.length();i++)
                {
                    while (temporal!=null)
                    {
                        String t = s.charAt(i)+"";
                        if(t.equals(temporal.getDato().getCaracter()))
                        {
                            mensaje += temporal.getDato().getValorBinario();
                        }
                        t = "";
                        temporal = temporal.getSiguiente();
                    }
                    temporal = listaB.getInicio();
                }
                s = br.readLine();
            }
            Guardado.guardarArchivo(mensaje,arb+"|");
        } catch(IOException e) 
        {
            System.out.println("Error E/S: " + e);
        }
        finally
        {
            try 
            {
                br.close();
            }catch(Exception e)
            {
                System.out.println("Error");
            }
        }
    }
    
    public void comprime()
    {
        comprimir(rutaA);
    }
    /**
     * llama al metodo reconstruir arbol() para poder descomprimir el mensaje
     * @param ruta 
     */
    public void descomprimir(String ruta)
    {
        try 
        {
            br = new BufferedReader(new FileReader(ruta));
            String s = br.readLine();
            String arbol = s;
            NodoA<String> arbolRe = reconstruirArbol(arbol);
            s = br.readLine();
            String auxiliar = "";
            while (s != null)
            {
                auxiliar+=s;
                s = br.readLine();
            }
            String mensajeO = reconstruirMensaje(arbolRe, auxiliar);
            Guardado.guardarArchivo(mensajeO);
        } catch(IOException e) 
        {
            System.out.println("Error E/S: " + e);
        }
        finally
        {
            try 
            {
                br.close();
            }catch(Exception e)
            {
                System.out.println("Error");
            }
        }
    }
    /**
     * reconstrulle el arbol huffman a partir de del mensaje comprimodo y asi poder descomprimir ewl mensaje
     * @param arbol
     * @return 
     */
    public NodoA<String> reconstruirArbol(String arbol)
    {
        NodoA <String> nuevo = new NodoA<String> (null);
        NodoA <String> aux = nuevo;
        for(int i = 0;i<arbol.length();i++)
        {
            if(arbol.charAt(i)=='|')
            {
                break;
            }
            if(arbol.charAt(i)=='0')
            {
                if(aux.getNodoIzq()==null)
                {
                    NodoA<String> auxiliar = new NodoA<String>("Hola");
                    aux.setNodoIzq(auxiliar);
                    aux = aux.getNodoIzq();
                }else
                    aux = aux.getNodoIzq();
            }
            if(arbol.charAt(i)=='1')
            {
                if(aux.getNodoDer()==null)
                {
                    NodoA<String> auxiliar = new NodoA<String>("Hola");
                    aux.setNodoDer(auxiliar);
                    aux = aux.getNodoDer();
                }else
                    aux = aux.getNodoDer();
            }
            if(arbol.charAt(i)!='0'&&arbol.charAt(i)!='1')
            {
                aux.setDato(arbol.charAt(i)+"");
                aux = nuevo;
            }
        }
        return nuevo;
    }
    
    
    public String reconstruirMensaje(NodoA<String> r, String b)
    {
        NodoA <String> aux = r;
        String mensaje = "";
        for(int i = 0;i<b.length();i++)
        {
            if(b.charAt(i)=='0')
            {
                if(aux.getNodoIzq()!=null)
                {
                    aux = aux.getNodoIzq();
                    if(aux.getNodoDer()==null&&aux.getNodoIzq()==null)
                    {
                        mensaje += aux.getDato();
                        aux = r;
                    }
                } 
            }
            if(b.charAt(i)=='1')
            {
                if(aux.getNodoDer()!=null)
                {
                    aux = aux.getNodoDer();
                    if(aux.getNodoDer()==null&&aux.getNodoIzq()==null)
                    {
                        mensaje += aux.getDato();
                        aux = r;
                    }
                } 
            }
        }
        return mensaje;
    }
    
}
