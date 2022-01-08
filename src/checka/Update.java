/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checka;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Deskco
 */
public class Update {
    int resultado=3;
    int resultado2=3;
    String version;
    boolean exitoso=false;
    // acceso al contenido web
     InputStream is ;
   // Fichero en el que queremos guardar el contenido
     FileOutputStream fos ;

      String linea;
    
      File archivo = null;
      FileReader fr = null;
      BufferedReader br = null;
      conexionBD conf = new conexionBD();
      
    public int buscar (){
        
        try {
            URL urlUpdate = new URL("https://drive.google.com/uc?id=1Hlp4iCZYnW2qCmA1JpZWmJW67mgnPzJh&export=download");
            URLConnection urlCon = urlUpdate.openConnection();
            
             is = urlCon.getInputStream();
             fos = new FileOutputStream("vercion.txt");
          
         
          // buffer para ir leyendo.
          byte [] array = new byte[1000];

          // Primera lectura y bucle hasta el final
          int leido = is.read(array);
          while (leido > 0) {
          fos.write(array,0,leido);
          leido=is.read(array);
        }
          
          exitoso=true;
          
        } catch (MalformedURLException ex) {
            
            Logger.getLogger(Update.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Update.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        if(exitoso){
            
           //resultado =  verificar();
           
           
            try {
                archivo = new File ("vercion.txt");
                fr = new FileReader (archivo);
                            br = new BufferedReader(fr);
            
            
            
            while((linea=br.readLine())!=null){
                if( linea.contains("V")){
                   version = linea.substring(1);
                   // verificar_version(version);
                    
                    conf.cargar();
                    String versionactual= conf.getVersionq();
                    if(version.equals(versionactual)){
                    //JOptionPane.showMessageDialog(null, "No hay nuevas versiones disponibles");
                    }else{
                      
                    int resp = JOptionPane.showConfirmDialog(null,version +" -- " + versionactual+ " ¿Nueva Vercion Disponible \n Desea Actualizar? ", "Checka Update", JOptionPane.CANCEL_OPTION);
                    if(resp==0){
                
                    try {
                    Process p = Runtime.getRuntime().exec ("updt.bat");
                    System.exit(0);
                    
                    /////////////////////hhhhhhhhhhhhhhhh
                    } catch (IOException ex) {
                        Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
                    }
                 
                             } 
            
            
                    }
        
                  //JOptionPane.showMessageDialog(null, "NUEVA VERCION DISPONIBLE");
                  resultado2 = 1;
                }else{
                  
                }
            }
            
            
            // Cierre de conexion y fichero.
            is.close();
            fos.close();
           
                
                
                
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Update.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Update.class.getName()).log(Level.SEVERE, null, ex);
            }

           
           
           
           
           
           
           
           
           
           
           
        }else{
           resultado= 2;
        }
        
        
     return resultado;
     
    }
    public int verificar(){
        
        try {
            archivo = new File ("vercion.txt");
            fr = new FileReader (archivo);
            br = new BufferedReader(fr);
            
            
            
            while((linea=br.readLine())!=null){
                if( linea.contains("V")){
                   version = linea.substring(1);
                    verificar_version(version);
                  //JOptionPane.showMessageDialog(null, "NUEVA VERCION DISPONIBLE");
                  resultado2 = 1;
                }else{
                  
                }
            }
            
            
            // Cierre de conexion y fichero.
            is.close();
            fos.close();
            
            
            return resultado2;
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Update.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Update.class.getName()).log(Level.SEVERE, null, ex);
        }
           return resultado2;
    }
    
    
    public void verificar_version(String versionant){
        
        
        
    }
}
