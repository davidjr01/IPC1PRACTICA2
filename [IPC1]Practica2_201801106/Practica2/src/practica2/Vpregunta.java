package practica2;

import java.awt.Toolkit;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Locale;




public class Vpregunta extends JFrame{
 public static int ordenamiento,velocidad,algoritmo,ds,control;


 

public Vpregunta(){
    super();
  
    Toolkit tamano=Toolkit.getDefaultToolkit();
    Dimension dimension =tamano.getScreenSize();
    int altura=dimension.height/2;
    int ancho=dimension.width/2;
    setBounds(ancho-225,altura-210,450,420);
    setResizable(false);
    setLayout(null);
    this.setTitle("Opciones de ordenamiento");
   
   agregar();
   

    this.addWindowListener(new WindowAdapter(){

     @Override
           public void windowClosing(WindowEvent we) {  
           
         }

    });

}
public void agregar(){
        JLabel etiquetaNombre = new JLabel("Tipo de Ordenamiento : ");
        etiquetaNombre.setBounds(25, 10, 400, 30);
        this.add(etiquetaNombre);
        
        JRadioButton r1=new JRadioButton ("Ascendente",false);
        r1.setBounds(25, 50, 100, 30);
        this.add(r1);
        
        JRadioButton r2=new JRadioButton ("Descendente",false);
        r2.setBounds(270,50 , 200, 30);
        this.add(r2);
  
        
        JLabel etiqueta2= new JLabel("Velocidad de Ordenamiento ");
        etiqueta2.setBounds(25,130, 400, 30);
        this.add(etiqueta2);
        
        JLabel etiqueta3= new JLabel("Algoritmo de Ordenamiento ");
        etiqueta3.setBounds(250,130, 400, 30);
        this.add(etiqueta3);
        
        JRadioButton r3=new JRadioButton ("Baja",false);
        r3.setBounds(25,170 , 100, 30);
        this.add(r3);
        
        JRadioButton r4=new JRadioButton ("Media",false);
        r4.setBounds(25,210 , 100, 30);
        this.add(r4);
        
        JRadioButton r5=new JRadioButton ("alta",false);
        r5.setBounds(25,250 , 100, 30);
        this.add(r5);
        
        ButtonGroup grupo2=new ButtonGroup();
        grupo2.add(r3);
        grupo2.add(r4);
        grupo2.add(r5);
        
        JRadioButton r6=new JRadioButton ("Bubble sort",false);
        r6.setBounds(260,170 , 100, 30);
        this.add(r6);
        
        JRadioButton r7=new JRadioButton ("Quicksort",false);
        r7.setBounds(260,210 , 100, 30);
        this.add(r7);
        
        JRadioButton r8=new JRadioButton ("Shellsort",false);
        r8.setBounds(260,250 , 100, 30);
        this.add(r8);
        
        ButtonGroup grupo3=new ButtonGroup();
        grupo3.add(r6);
        grupo3.add(r7);
        grupo3.add(r8);
        
        JButton boton = new JButton("Ordenar");
        boton.setBounds(90, 320, 100, 30);
        this.add(boton);
    
        JButton boton2 = new JButton("Cancelar");
        boton2.setBounds(230, 320, 100, 30);
        this.add(boton2);
        
        boton.addActionListener(
                         new ActionListener(){
                             @Override
                             public void actionPerformed(ActionEvent e) {
                                  
                                  ds=1;

                                
                                 }

                             }
                 );
         
        
        r1.addActionListener(
                         new ActionListener(){
                             @Override
                             public void actionPerformed(ActionEvent e) {
                                 r2.setSelected(false);
                                 ordenamiento=1;
                                
                                 }

                             }
                 );
        r2.addActionListener(
                         new ActionListener(){
                             @Override
                             public void actionPerformed(ActionEvent e) {
                                 r1.setSelected(false);
                                 ordenamiento=2;
                                
                                 }

                             }
                 );
        
        r3.addActionListener(
                         new ActionListener(){
                             @Override
                             public void actionPerformed(ActionEvent e) {
                                 r4.setSelected(false);
                                 r5.setSelected(false);
                                 velocidad=1;
                                
                                 }

                             }
                 );
        r4.addActionListener(
                         new ActionListener(){
                             @Override
                             public void actionPerformed(ActionEvent e) {
                                 r3.setSelected(false);
                                 r5.setSelected(false);
                                 velocidad=2;
                                
                                 }

                             }
                 );
        r5.addActionListener(
                         new ActionListener(){
                             @Override
                             public void actionPerformed(ActionEvent e) {
                                 r4.setSelected(false);
                                 r3.setSelected(false);
                                 velocidad=3;
                                
                                 }

                             }
                 );
        
        r6.addActionListener(
                         new ActionListener(){
                             @Override
                             public void actionPerformed(ActionEvent e) {
                                 r7.setSelected(false);
                                 r8.setSelected(false);
                                 algoritmo=1;
                                
                                 }

                             }
                 );
        r7.addActionListener(
                         new ActionListener(){
                             @Override
                             public void actionPerformed(ActionEvent e) {
                                 r6.setSelected(false);
                                 r8.setSelected(false);
                                 algoritmo=2;
                                
                                
                                 }

                             }
                 );
        r8.addActionListener(
                         new ActionListener(){
                             @Override
                             public void actionPerformed(ActionEvent e) {
                                 r6.setSelected(false);
                                 r7.setSelected(false);
                                 algoritmo=3;
                                
                                 }

                             }
                 );
        
}


}