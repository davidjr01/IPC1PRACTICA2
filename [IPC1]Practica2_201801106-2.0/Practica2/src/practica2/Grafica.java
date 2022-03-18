
package practica2;

import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jfree.chart.*;
import org.jfree.chart.entity.StandardEntityCollection;
import org.jfree.data.category.*;
import org.jfree.chart.plot.*;
import org.jfree.data.general.DefaultPieDataset;
import static practica2.VentanaPrincipal.nombreG;




public class Grafica extends Thread {
  
     Panel panel;
     String[][]vector;
     String[][]ordenado;
     String[][]desordenado;
     int n;
     String nombre;
     public static int o=0,v=0,alg=0;
     public static int control=0,a=0;
     String algoritmo="",velocidad="",orden="";
     int pasos=0, tiempo=0;
     String dato[][]=new String[2][2];
     
    public Grafica(Panel panel,int n,String[][] vector,String nombre){
        this.vector=vector;
        this.panel=panel;
        this.n=n;
        this.nombre=nombre;
      
    }
 
    
    @Override
    public void run(){
      ordenado=new String[n+1][2];
      desordenado=new String[n][2];
      for(int i=0;i<n;i++){
          desordenado[i][0]=vector[i+1][0];
          desordenado[i][1]=vector[i+1][1];
      }
      for(int i=0;i<2;i++){
          dato[i][0]="";
          dato[i][1]="";
          
      }
      panel.setBackground(Color.white);
      Vpregunta vp=new Vpregunta();
      proceso(vector);
      int op=JOptionPane.showConfirmDialog(null,"Desplazar opciones ", "¿Ordenar datos?",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
      if(op==JOptionPane.YES_OPTION){
      vp.setVisible(true);
      }
      while(a!=1){
       System.out.print("");
       o=vp.ordenamiento;
       v=vp.velocidad;
       alg=vp.algoritmo;
       if (vp.ds==1){
           a=1;
           vp.dispose();
           
       }
      }
    
      
      
      /*
   
       Tiempo t=new Tiempo();
       t.start();
       */
      if(alg==1){
        algoritmo="burbuja";
         if(o==1){
           orden="Ascendente";
           burbuja();  
         }else if(o==2){
             orden="Descendente";
             burbuja2();
         }
        
      }else if(alg==2){
          algoritmo="QuickSort";
          if(o==1){
           orden="Ascendente";
           QuickSort(vector,1,n); 
         }else if(o==2){
           orden="Descendente";
           String [][]temp=new String [n][2];
           for(int i=0;i<n;i++){
               temp[i][0]=vector[i+1][0];
               temp[i][1]=vector[i+1][1];
           }
            QuickSort2(temp,0,n-1);
         }
      }else if(alg==3){
          algoritmo="ShellSort";
          if(o==1){
           orden="Ascendente";
           ShellSort(vector, n);  
         }else if(o==2){
           orden="Descendente";
           ShellSort2(vector, n);
         }
      }
      vp.ds=0;
      a=0;
    //  t.stop();
      crear();
    
    }
 
    public void burbuja(){
        double aux;
        String aux2;
        for(int i=1;i<n;i++){
            for(int j=1;j<n;j++){
                if( Double.parseDouble(vector[j][1])> Double.parseDouble(vector[j+1][1])){
                    aux= Double.parseDouble(vector[j][1]);
                    aux2=vector[j][0];
                    //b[j]=b[j+1];
                    vector[j][1]=vector[j+1][1];
                    vector[j][0]=vector[j+1][0];
                    //b[j+1]=aux;
                    vector[j+1][1]=aux + "";
                    vector[j+1][0]=aux2;
                    proceso(vector);
                    
                }
            }  
        } 
        dato[0][0]= vector[1][0];
        dato[0][1]=vector[1][1];
        
        dato[1][0]=vector[n][0];
        dato[1][1]=vector[n][1];
    }
     public void burbuja2(){  
        double aux;
        String aux2;
        for(int i=1;i<n;i++){
            for(int j=1;j<n;j++){
                if( Double.parseDouble(vector[j][1])< Double.parseDouble(vector[j+1][1])){
                    aux= Double.parseDouble(vector[j][1]);
                    aux2=vector[j][0];
                    //b[j]=b[j+1];
                    vector[j][1]=vector[j+1][1];
                    vector[j][0]=vector[j+1][0];
                    //b[j+1]=aux;
                    vector[j+1][1]=aux + "";
                    vector[j+1][0]=aux2;
                    proceso(vector);
                  
                }
            }  
        }
        dato[0][0]=vector[n][0];
        dato[0][1]=vector[n][1];
        
        dato[1][0]=vector[1][0];
        dato[1][1]=vector[1][1];
        
    }
    public void proceso(String [][]vector2){
    
    DefaultCategoryDataset data=new DefaultCategoryDataset();
         for(int i=1;i<=n;i++){
              data.addValue(Double.parseDouble(vector2[i][1]),vector2[i][0],"");
              //////////////////7
              ordenado[i][0]=vector2[i][0];
              ordenado[i][1]=vector2[i][1];
              
              
              ////////77
              
         }
         JFreeChart grafica=ChartFactory.createBarChart3D(nombre, vector2[0][0], vector2[0][1], data, PlotOrientation.VERTICAL,true,true , false);
   

     ChartPanel contenedor=new ChartPanel(grafica);
     contenedor.setBounds(0,60, 740, 540);
     if (pasos==0){
       try{
         final ChartRenderingInfo info=new ChartRenderingInfo(new StandardEntityCollection());
         final File file1=new File("Grafica1.png");
         ChartUtilities.saveChartAsPNG(file1, grafica, 600, 400,info);
         
     }catch(Exception e){
         
     }  
     }else{
         try{
         final ChartRenderingInfo info=new ChartRenderingInfo(new StandardEntityCollection());
         final File file1=new File("Grafica2.png");
         ChartUtilities.saveChartAsPNG(file1, grafica, 600, 400,info);
         
     }catch(Exception e){
         
     }
     }
     
     this.panel.removeAll();
     
     
     
     JLabel etiquetaNombre = new JLabel("Oden   :  "+orden);
     etiquetaNombre.setBounds(1, 1, 300, 30);
     this.panel.add(etiquetaNombre);
     
     JLabel labelvelocidad = new JLabel("Velocidad  : "+ velocidad);
     labelvelocidad .setBounds(1, 40, 300, 30);
     this.panel.add(labelvelocidad );
     
     JLabel labelalgoritmo = new JLabel("Algoritmo : "+ algoritmo);
     labelalgoritmo.setBounds(500, 1, 300, 30);
     this.panel.add(labelalgoritmo);
     
     JLabel labelpasos = new JLabel("Pasos  : "+ pasos);
     labelpasos  .setBounds(500, 40, 300, 30);
     this.panel.add(labelpasos  );
     
     
     
     this.panel.add(contenedor);
     this.panel.repaint();
     try{
          if(v==1){
           velocidad="Baja";
           Thread.sleep(400);  
          }else if(v==2){
              velocidad="Media";
              Thread.sleep(300);
          }
          else if(v==3){
              velocidad="Alta";
              Thread.sleep(50);
          }
          pasos=pasos+1;
          
     }catch(InterruptedException ex){
         Logger.getLogger(Grafica.class.getName()).log(Level.SEVERE,null,ex);
     }
}
     public void proceso2(String [][]vector2){
    
    DefaultCategoryDataset data=new DefaultCategoryDataset();
         for(int i=0;i<n;i++){
              data.addValue(Double.parseDouble(vector2[i][1]),vector2[i][0],"");     
         }
         JFreeChart grafica=ChartFactory.createBarChart3D(nombre, vector2[0][0], vector2[0][1], data, PlotOrientation.VERTICAL,true,true , false);
   

     ChartPanel contenedor=new ChartPanel(grafica);
     contenedor.setBounds(0,60, 740, 540);
     this.panel.removeAll();
     
     
     
     JLabel etiquetaNombre = new JLabel("Oden   :  "+orden);
     etiquetaNombre.setBounds(1, 1, 300, 30);
     this.panel.add(etiquetaNombre);
     
     JLabel labelvelocidad = new JLabel("Velocidad  : "+ velocidad);
     labelvelocidad .setBounds(1, 40, 300, 30);
     this.panel.add(labelvelocidad );
     
     JLabel labelalgoritmo = new JLabel("Algoritmo : "+ algoritmo);
     labelalgoritmo.setBounds(500, 1, 300, 30);
     this.panel.add(labelalgoritmo);
     
     JLabel labelpasos = new JLabel("Pasos  : "+ pasos);
     labelpasos  .setBounds(500, 40, 300, 30);
     this.panel.add(labelpasos  );
     
     
     
     this.panel.add(contenedor);
     this.panel.repaint();
     try{
          if(v==1){
           velocidad="Baja";
           Thread.sleep(400);  
          }else if(v==2){
              velocidad="Media";
              Thread.sleep(300);
          }
          else if(v==3){
              velocidad="Alta";
              Thread.sleep(50);
          }
          pasos=pasos+1;
          
     }catch(InterruptedException ex){
         Logger.getLogger(Grafica.class.getName()).log(Level.SEVERE,null,ex);
     }
}
    
    public void QuickSort(String a[][],int primero,int ultimo){
        int i=primero,j=ultimo;
        double pivote=Double.parseDouble(a[(primero+ultimo)/2][1]);
        double aux;
        String aux2;
        do{
            while(Double.parseDouble(a[i][1])<pivote){
                i++;
            }
            while(Double.parseDouble(a[j][1])>pivote){
             j--;   
            }
            if(i<=j){
              aux=Double.parseDouble(a[i][1]) ;
              aux2=a[i][0];
              
              a[i][1]=a[j][1];
              a[i][0]=a[j][0];
              
              a[j][1]=aux+"";
              a[j][0]=aux2;
              i++;
              j--;
               proceso(a);
               ordenar(a);
               dato[0][0]= a[1][0];
               dato[0][1]=a[1][1];
               dato[1][0]=a[n][0];
               dato[1][1]=a[n][1];
            }
            
        }while(i<=j);
        if(primero<j){
           QuickSort(a,primero,j) ;
        }
        if(i<ultimo){
           QuickSort(a,i,ultimo) ;
        }     
      
    }
    public  void QuickSort2(String a[][],int primero,int ultimo){
        int i=primero,j=ultimo;
        double pivote=Double.parseDouble(a[(primero+ultimo)/2][1]);
        String aux,aux2;
        do{
            while(Double.parseDouble(a[i][1])>pivote){
                i++;
            }
            while(Double.parseDouble(a[j][1])<pivote){
             j--;   
            }
            if(i<=j){
              aux=a[j][1] ;
              a[j][1]=a[i][1];
              a[i][1]=aux;
              i++;
              j--;
              proceso2(a);
              ordenar(a);
              dato[0][0]=vector[n][0];
              dato[0][1]=vector[n][1];
        
              dato[1][0]=vector[1][0];
              dato[1][1]=vector[1][1];
             
            }
            
        }while(i<=j);
        if(primero>j){
           QuickSort(a,primero,j) ;
        }
        if(i>ultimo){
           QuickSort(a,i,ultimo) ;
        }
        
      
      
    }
   
    
    public void ShellSort(String vector[][],int n){
        int i,j,k,salto;
        double aux;
        String aux2;
        salto=n/2;
        while(salto>0){
            for( i=0;i<=n;i++){
                j=i-salto;
                while(j>=1){
                    k=j+salto;
                    
                    if(Double.parseDouble(vector[j][1])<=Double.parseDouble(vector[k][1])){
                        j=-1;
                    }else{
                        aux=Double.parseDouble(vector[j][1]);
                        aux2=vector[j][0];
                        
                        vector[j][1]=vector[k][1];
                        vector[j][0]=vector[k][0];
                        
                        vector[k][1]=aux+"";
                        vector[k][0]=aux2;
                        j=j-salto;
                        proceso(vector);
                        ordenar(vector);
                        dato[0][0]= vector[1][0];
                        dato[0][1]=vector[1][1];
        
                        dato[1][0]=vector[n][0];
                        dato[1][1]=vector[n][1];
                    }
                }
            }
            salto=salto/2;
        }
            
    }
    public void ShellSort2(String vector[][],int n){
        int i,j,k,salto;
        double aux;
        String aux2;
        salto=n/2;
        while(salto>0){
            for( i=0;i<=n;i++){
                j=i-salto;
                while(j>=1){
                    k=j+salto;
                    
                    if(Double.parseDouble(vector[j][1])>=Double.parseDouble(vector[k][1])){
                        j=-1;
                    }else{
                        aux=Double.parseDouble(vector[j][1]);
                        aux2=vector[j][0];
                        
                        vector[j][1]=vector[k][1];
                        vector[j][0]=vector[k][0];
                        
                        vector[k][1]=aux+"";
                        vector[k][0]=aux2;
                        j=j-salto;
                        proceso(vector);
                        ordenar(vector);
                        dato[0][0]=vector[n][0];
                        dato[0][1]=vector[n][1];
        
                         dato[1][0]=vector[1][0];
                         dato[1][1]=vector[1][1];
                    }
                }
            }
            salto=salto/2;
        }
            
    }

  
   public void crear(){
         String inicio = "<!DOCTYPE html>\n" +
                        "<html >\n" +"<head>\n"+
                        "<title>Reporte</title>\n" +
                        "<meta charset=\"utf-8\" >\n" +
                        "<link rel=\"stylesheet\"type=\"text/css\"  href=\"estilo1.css\">\n" +
                        " <div id=\"header\">\n" +
                        "<div id=\"letra\">REPORTE IPC1</div>\n" +
                        "</div>\n" + "</div>\n" + "</head>\n";
         
         String pibody = "\n<body>\n"+ "<div id=\"base\">\n" +
                        "<div id=\"nav\">\n" +
                        "<div id=\"letra_titulo\">\n"+ "Luis David Juarez Reyes , 201801106 \n"+ "</div>\n"+"</div>\n"+ " <br><br>\n"+
                        "Algoritmo :"+ algoritmo +"&nbsp;     &nbsp;     &nbsp;       &nbsp;  &nbsp;     &nbsp;     &nbsp;       &nbsp; "+
                        "Orden : &nbsp;  &nbsp; "+orden+ " <br><br>\n"+
                        "Velocidad : " + velocidad + "  &nbsp;     &nbsp;     &nbsp;       &nbsp;  &nbsp;     &nbsp;     &nbsp;       &nbsp;  Pasos : " + (pasos -1)+"\n"+
                        "<br><br><br><br>\n"+ 
                         "Dato mayor : " + dato[1][0]+   "  &nbsp;     &nbsp;   " +dato[1][1]+ " &nbsp;     &nbsp;     &nbsp;       &nbsp;  &nbsp;     &nbsp;     &nbsp;       &nbsp;Dato menor :"+
                         dato[0][0] + "   &nbsp;     &nbsp; "+ dato[0][1]+"<br><br><br>\n"+"<br><br>\n"+"DATOS DESORDENADOS"+"<br><br>\n"+"<br><br>\n"; 
         
         String fin="</body>\n" +"</html>";
                String pro="";
                String pro2="";
                String total="";
                
                for(int i=0;i<n;i++){
                    pro=pro+ " &nbsp;     &nbsp; "+ desordenado[i][0]+ " &nbsp;     &nbsp; "+desordenado[i][1]+"&nbsp;  ,";
                }
                for(int i=1;i<=n;i++){
                    pro2=pro2+ " &nbsp;     &nbsp; "+ ordenado[i][0]+ " &nbsp;     &nbsp; "+ordenado[i][1]+"&nbsp;  ,";
                }
                
                String imagen="<br><br>\n" +"<br><br>\n" +
                "<img src=\"Grafica1.png\" >";
                String imagen2="<br><br>\n" +"<br><br>\n" +
                "<img src=\"Grafica2.png\" >";
                
                total=inicio+pibody+pro+imagen+"<br><br>\n"+"<br><br>\n"+"<br><br>\n"+"DATOS ORDENADOS "+"<br><br>\n"+"<br><br>\n"+pro2+imagen2+fin;
                File archivo = new File("reporte.html");
                try {
                    //Se escribe la cadena en el archivo.
                    FileWriter escritor = new FileWriter(archivo);
                    escritor.write(total);
                    escritor.close();
                    
                } 
                catch (IOException ex) {
                    //Si existe algún error, se muestra un mensaje.
                    System.out.println("Error al escribir el reporte: " + ex.getMessage());
                }
                
         
         
         
         
     
    }
   public void ordenar (String [][]asd){
    
   }
   
   
    
}

