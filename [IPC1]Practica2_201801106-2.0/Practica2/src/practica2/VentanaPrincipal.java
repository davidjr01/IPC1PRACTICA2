
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




public class VentanaPrincipal extends JFrame{
    public static  String ruta,nombreG;
    public String [][]contenedor=new String[100][2];
    Panel panel=new Panel();
    int cantidad=-1;
    
    

 

public VentanaPrincipal(){
    super();
  
    Toolkit tamano=Toolkit.getDefaultToolkit();
    Dimension dimension =tamano.getScreenSize();
    int altura=dimension.height/2;
    int ancho=dimension.width/2;
    setBounds(ancho-415,altura-450,830,900);
    setResizable(false);
    setLayout(null);
    this.setTitle("Proceso de datos");
    panel.setBounds(40, 210, 740, 600);
    panel.setBackground(Color.gray);
    this.add(panel);
    agregar();
   

    this.addWindowListener(new WindowAdapter(){

     @Override
           public void windowClosing(WindowEvent we) {  
           
         }

    });

}

void agregar(){
        
        JLabel etiquetaNombre = new JLabel("Ruta : ");
        etiquetaNombre.setBounds(50, 20, 50, 30);
        this.add(etiquetaNombre);
        
        JTextField txtRuta = new JTextField();
        txtRuta.setBounds(50, 50, 600, 30);
        this.add(txtRuta);
        
        JLabel etiquetaEdad = new JLabel("Nombre Grafica : ");
        etiquetaEdad.setBounds(50, 90, 200, 30);
        this.add(etiquetaEdad);
        
        JTextField txtNombre = new JTextField();
        txtNombre.setBounds(50, 120, 730, 30);
        this.add(txtNombre);

        JButton boton = new JButton("Buscar");
        boton.setBounds(680, 50, 100, 30);
        this.add(boton);
    
        JButton boton2 = new JButton("Aceptar");
        boton2.setBounds(680, 165, 100, 30);
        this.add(boton2);
        
        VentanaPrincipal referenciaPadre = this;


         boton.addActionListener(
                         new ActionListener(){
                             @Override
                             public void actionPerformed(ActionEvent e) {
                                  JFileChooser cargaArchivos = new JFileChooser();
                                  cargaArchivos.showOpenDialog(referenciaPadre);
                                  txtRuta.setText(cargaArchivos.getSelectedFile().getPath());
                                  
                                  
                                
                                 }

                             }
                 );
          boton2.addActionListener(
                         new ActionListener(){
                             @Override
                             public void actionPerformed(ActionEvent e) {
                                  
                                  for(int i=0;i<100;i++){
                                      contenedor[i][0]="";
                                      contenedor[i][1]="";
                                      
                                  }
                                  cantidad=-1;
                                  
                                  
                                  ruta=txtRuta.getText();
                                  nombreG=txtNombre.getText();
                                  if((ruta.equals(""))||(nombreG.equals(""))){
                                      JOptionPane.showMessageDialog(null,"Campos vacios");
                                      
                                  }else{
                                     File archivo;
                                     FileReader fr;
                                     BufferedReader br;
                                     String nombre=ruta;
                                     try {
                                         archivo=new File(nombre);
                                         fr= new FileReader (archivo);
                                         br= new  BufferedReader(fr);
                                         String a;
                                         while((a=br.readLine())!=null){
                                             cantidad=cantidad+1;
                                             int pos=0;
                                             for(int i=0;i<a.length();i++){
                                                 String aux2=""+a.charAt(i);
                                                 if(aux2.equals(",")){
                                                     pos=pos+1;
                                                 }else{
                                                     contenedor[cantidad][pos]=contenedor[cantidad][pos] + aux2;
                                                 }
                                                 
                                                 
                                             }
                                             
                                             
                                             
                                             
                                         }
                                         br.close();
                                         fr.close();
                                         
    
                                        
                                        Grafica grafica=new Grafica(panel,cantidad,contenedor,nombreG);
                                        grafica.start();
                                      
                                        
                                       
                                     }
                                     catch(IOException ex){
                                         JOptionPane.showMessageDialog(null,"Error al abrir el archivo: " + ex.getMessage());
                                     }
                                      
                                      
                                  }
                                  
                                
                                 }

                             }
                 );
         
        


}
 


}
                                    