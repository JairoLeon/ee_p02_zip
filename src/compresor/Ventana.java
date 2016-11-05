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
public class Ventana extends JFrame implements ActionListener {
    
    private JLabel label1,label2, label3,label4;
    private JButton boton;
    AnalisisArchivo ar; 
    
    public Ventana(String tamañoA, int numC, String dir, AnalisisArchivo a) 
    {
        ar = a;
        setLayout(null);
        setBounds(60,200,500,280);
        setResizable(false);
        setTitle("Info. del archivo");
        
        label1=new JLabel("Tamaño del Archivo: "+tamañoA);
        label1.setBounds(10,60,350,30);
        add(label1);
        
        label2=new JLabel("Numero de caracteres: "+numC);
        label2.setBounds(10,100,300,30);
        add(label2);
        
        label3=new JLabel("Ruta del archivo: "+dir);
        label3.setBounds(10,20,400,30);
        add(label3);
        
        boton= new JButton("Comprimir");
        boton.setBounds(150,170,200,30);
        boton.addActionListener(this);
        add(boton);
    }
    
    public void actionPerformed(ActionEvent e) 
    {
        if(e.getSource()==boton)
        {
            ar.comprime();
        }
    }
    
    
}
