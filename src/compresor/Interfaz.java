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
import java.awt.*;
public class Interfaz extends JFrame implements ActionListener {
    
    private JMenuBar mb;
    private JMenu menu1;
    private JMenuItem salir, mi3,mi5;
    private JLabel info, info2 ;
    private JFileChooser file = new JFileChooser();
    File auxiliar, auxiliar2;
    AnalisisArchivo a = new AnalisisArchivo();
        
    public Interfaz() 
    {
        setLayout(null);
        setBounds(20,20,400,200);
        setTitle("Compresor Huffman");
        
        info = new JLabel("^ Vaya al menu de Opciones");
        info.setBounds(100, -50, 200, 200);
        add(info);
        
        info2 = new JLabel("     Version 2.1");
        info2.setBounds(100, -20, 200, 200);
        add(info2);
        
        mb=new JMenuBar();
        setJMenuBar(mb);
        menu1=new JMenu("Archivo");
        mb.add(menu1);
        
        mi3=new JMenuItem("Abrir...");
        menu1.add(mi3);
        mi3.addActionListener(this);
        
        mi5=new JMenuItem("Descomprimir...");
        menu1.add(mi5);
        mi5.addActionListener(this);
        
        salir =new JMenuItem("Salir");
        menu1.add(salir);
        salir.addActionListener(this);
    }
    
    public void actionPerformed(ActionEvent e) 
    {
        try
        {
            if (e.getSource() == salir) 
                System.exit(0);
            if (e.getSource()==mi3) 
            {
                file.showOpenDialog(null);
                auxiliar = file.getSelectedFile();
                a.analizar(auxiliar.getAbsolutePath());
                a.llenarArbol();
                a.llena();
                Integer auxi = a.tLetras*8;
                Ventana v = new Ventana(auxi+" bits"+"",a.tLetras,auxiliar.getAbsolutePath(),a);
                v.setVisible(true);
            }
            if (e.getSource()==mi5) 
            {
                file.showOpenDialog(null);
                auxiliar2 = file.getSelectedFile();
                a.descomprimir(auxiliar2.getAbsolutePath());
            }
        }catch(NullPointerException n)
        {
            System.out.println("Error");
        }
    }
    
    public static void main(String[] args) 
    {
        Interfaz formulario1 = new Interfaz();
        formulario1.setVisible(true);
    }
    
}
