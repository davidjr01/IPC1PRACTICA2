/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica2;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author david
 */
public class Mensaje extends Thread {
    @Override
    public void run(){
        try{
          Thread.sleep(200);
     }catch(InterruptedException ex){
         Logger.getLogger(Grafica.class.getName()).log(Level.SEVERE,null,ex);
     }
      int op=JOptionPane.showConfirmDialog(null,"Desplazar opciones ", "¿Ordenar datos?",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
      if(op==JOptionPane.YES_OPTION){
          Vpregunta vp=new Vpregunta();
          vp.setVisible(true);
      }
    }
    
}
