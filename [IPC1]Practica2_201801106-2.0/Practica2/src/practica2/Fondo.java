
package practica2;

import java.awt.Toolkit;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Locale;


public class Fondo extends JPanel{
    private Image imagen;
     @Override
     public void paint(Graphics g){
      imagen=new ImageIcon(getClass().getResource("2.jpg")).getImage();
      g.drawImage(imagen, 0, 0,200,200, this);
      setOpaque(false);
      super.paint(g);
     }
     
    
    
    
}
