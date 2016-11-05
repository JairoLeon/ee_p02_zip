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
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
public class Guardado {
    
    public static void guardarArchivo(String n, String cabecera) 
    {
        try
        {       
            JFileChooser file=new JFileChooser();
            file.showSaveDialog(file);
            File guarda =file.getSelectedFile();
            if(guarda !=null)
            {
                BufferedWriter d = new BufferedWriter(new FileWriter(guarda+".txz"));
                d.write(cabecera);
                d.newLine();
                d.write(n);
                d.close();
                JOptionPane.showMessageDialog(null,
                    "El archivo se comprimio y guardo exitosamente",
                    "Información",JOptionPane.INFORMATION_MESSAGE);
            }
        }
        catch(IOException ex)
        {
            JOptionPane.showMessageDialog(null,
                "Su archivo no se ha guardado",
                "Advertencia",JOptionPane.WARNING_MESSAGE);
        }
    }
    
    public static void guardarArchivo(String cadena) 
    {
        try
        {       
            JFileChooser file=new JFileChooser();
            file.showSaveDialog(file);
            File guarda =file.getSelectedFile();
            if(guarda !=null)
            {
                FileWriter d = new FileWriter(guarda+".txz");
                d.write(cadena);
                d.close();
                JOptionPane.showMessageDialog(null,
                    "El archivo se comprimio y guardo exitosamente",
                    "Información",JOptionPane.INFORMATION_MESSAGE);
            }
        }
        catch(IOException ex)
        {
            JOptionPane.showMessageDialog(null,
                "Su archivo no se ha guardado",
                "Advertencia",JOptionPane.WARNING_MESSAGE);
        }
    }
    
}
