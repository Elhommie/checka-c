
package checka;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URISyntaxException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;
import javax.swing.JOptionPane;

/**
 *
 * @author DC45-61
 */
public class conexionBD {
    String url;
    String user;
    String pass;
    String passbd;
    String versionq;
    String contraseña;
    String port;
    String corte;
    String tiempotolerancia;
    String retardos;
    String licencia;
    String serial;
    String vencimineto;

    public String getLicencia() {
        return licencia;
    }

    public void setLicencia(String licencia) {
        this.licencia = licencia;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public String getVencimineto() {
        return vencimineto;
    }

    public void setVencimineto(String vencimineto) {
        this.vencimineto = vencimineto;
    }

    public String getTiempotolerancia() {
        return tiempotolerancia;
    }

    public void setTiempotolerancia(String tiempotolerancia) {
        this.tiempotolerancia = tiempotolerancia;
    }

    public String getRetardos() {
        return retardos;
    }

    public void setRetardos(String retardos) {
        this.retardos = retardos;
    }
    
    public String getVersionq() {
        return versionq;
    }

    public void setVersionq(String versionq) {
        this.versionq = versionq;
    }
   
    public String getPassbd() {
        return passbd;
    }

    public void setPassbd(String passbd) {
        this.passbd = passbd;
    }
  
    
   regevet log2 = new regevet();
 
    public String getCorte() {
        return corte;
    }

    public void setCorte(String corte) {
        this.corte = corte;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
    
    Properties p = new Properties();

 
               
    public void cargar() {
    File restt = new File("rest.bat");
    if(!restt.exists()){
        try {
            
          
            restt.createNewFile();
            PrintWriter bw = new PrintWriter("rest.bat", "UTF-8");
            bw.println("@echo off");
            bw.println("start CHECKA_Mini_final.jar");
            bw.close(); 
             
        } catch(IOException ex) {
            Logger.getLogger(conexionBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }else{
        
    }
    
    
    
    
        //println(getClass().getProtectionDomain().getCodeSource().getLocation());
    File file = new File("configuracion.properties");
    Date fecha = new Date();
    
    if(!file.exists()){
        try {
            //println("secreacofign");
            DateFormat fechaFormat = new SimpleDateFormat("yyyy/MM/dd");
            
            file.createNewFile();
            PrintWriter bw = new PrintWriter("configuracion.properties", "UTF-8");
            bw.println("url=0");
            bw.println("user=0");
            bw.println("pass=0");
            bw.println("passbd=0");
            bw.println("puertocom=0");
            bw.println("contraseña=0");
            bw.println("corte="+fechaFormat.format(fecha));
            bw.println("tiempotolerancia=10");
            bw.println("retardos");
            bw.println("vercion=2.2.00");
            bw.close(); 
           
        } catch (IOException ex) {
            Logger.getLogger(conexionBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }else{
        
        
        
    }

    try {
        p.load(new FileInputStream("configuracion.properties"));
        //println("Secargo");
    } catch (IOException ex) {
        Logger.getLogger(conexionBD.class.getName()).log(Level.SEVERE, null, ex);
    }
    url = p.getProperty("url");
    user = p.getProperty("user");
    pass = p.getProperty("pass");
    passbd = p.getProperty("passbd");
    port = p.getProperty("puertocom");
    contraseña=p.getProperty("contreseña");
    corte= p.getProperty("corte");
      //  System.out.println(versionq);
      //  System.out.println(corte);
    versionq = p.getProperty("vercion");
    tiempotolerancia=p.getProperty("tiempotolerancia");
    retardos=p.getProperty("retardos");
    licencia=p.getProperty("licencia");
    serial=p.getProperty("serial");
    vencimineto=p.getProperty("vencimiento");
    
  
    }

    public void guardarconfasis(String retardos2,String tiempotoleracia2){
        try {
            
           
              p.load(new FileInputStream("configuracion.properties"));    
              p.put("retardos",retardos2);
              p.put("tiempotolerancia", tiempotoleracia2);
   
              p.store(new FileWriter("configuracion.properties"),null);
            
            JOptionPane.showMessageDialog(null, "Cambios Guardados");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error al Guardar Cambios");
            Logger.getLogger(conexionBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
public void guardartodo(){
        try {
            
           
              p.load(new FileInputStream("configuracion.properties"));
              
              p.put("puertocom",port);
              p.put("passbd", passbd);
            //p.store(new FileWriter("conf.properties"),"un comentario");
              p.store(new FileWriter("configuracion.properties"),null);
            
            JOptionPane.showMessageDialog(null, "Cambios Guardados");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error al Guardar Cambios");
            Logger.getLogger(conexionBD.class.getName()).log(Level.SEVERE, null, ex);
        }
           
}
public void guardar(String fecha){
    
         try {
            
            p.load(new FileInputStream("configuracion.properties"));
            p.put("corte",fecha);
            //p.store(new FileWriter("conf.properties"),"un comentario");
            p.store(new FileWriter("configuracion.properties"),null);
           
           
           
        } catch (FileNotFoundException ex) {
            log2.wlog("ERROR AL GUARDAR ARCHIVO DE PROPIEDADES");
            Logger.getLogger(conexionBD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            log2.wlog("ERROR AL GUARDAR ARCHIVO DE PROPIEDADES");
            Logger.getLogger(conexionBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    

    
}

   
}
