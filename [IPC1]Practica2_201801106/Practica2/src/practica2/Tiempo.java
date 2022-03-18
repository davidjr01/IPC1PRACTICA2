
package practica2;

import javax.swing.JLabel;
import static practica2.VentanaPrincipal.nombreG;


public class Tiempo extends Thread {
     Panel panel;
     public static int tiempo=0;
     public Tiempo(){
       
         
     }
      
    @Override
    public void run(){
     while(tiempo!=-1){
         tiempo=tiempo+1;
         System.out.println("a");
     }

     
    
    }
     
     


    
}
