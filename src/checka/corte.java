/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checka;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author DC45-61
 */
public class corte {
    String barra = File.separator;
    String proyecto = System.getProperty("user.dir")+barra+"rehu";
    String db= "jdbc:sqlite:"+proyecto; 
    Connection Conexion;
    
    
    DateFormat hourFormat = new SimpleDateFormat("HH:mm");
    DateFormat fechaFormat = new SimpleDateFormat("yyyy/MM/dd");
    conexionBD c = new conexionBD();
    regevet log2 = new regevet();
    Date d;
   
    public void fechacorte(){
        d = new Date();
        c.cargar();
        

        long milis_c = (long) 1.08e+7;
        long milis_a = 0;
        String ultima_fecha = c.corte;
                
         try {
             
             String filtro = fechaFormat.format(d);
             String filtro2 = hourFormat.format(d);
             

             
             milis_a = (long) (hourFormat.parse(filtro2).getTime()- 2.16e+7);
             //println(hourFormat.format(d));
             //println("actual "+ milis_a);
             
             Date fecha_actual = fechaFormat.parse(filtro);
             //println(ultima_fecha);
             Date fecha_anterior = fechaFormat.parse(ultima_fecha);
                  
             //println(fecha_anterior);
             //println(fecha_actual);
             log2.wlog("Fecha Anterior "+fecha_anterior+" Fecha Actual "+fecha_actual);      
             
               if(fecha_anterior.before(fecha_actual)){
                   
                   
                   //println(fecha_anterior);
                   //println(fecha_actual);
                   
                   
                   log2.wlog("Milisegundoss actuales "+milis_a+" Milisegundos despues de las 3am "+milis_c);
                   
                   if(milis_a>milis_c){
                       
                       
                       //println("actual "+ milis_a);
                       //println("3 horas am" + milis_c);
                       log2.wlog("Milisegundoss actuales "+milis_a+" Milisegundos despues de las 3am "+milis_c);
                       
                       
                       c.guardar(filtro);
                       corte();
                       
                   }
          
               }
      
         } catch (ParseException ex) {
             log2.wlog("error con las fechas"+ex);
             
             
             Logger.getLogger(corte.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
     public void es_fechacorte(String fechaactual,String horachecada){
        d = new Date();
        c.cargar();
        

        long milis_c = (long) 1.08e+7;
        long milis_a = 0;
        String ultima_fecha = c.corte;
                
         try {
             
             String filtro = fechaFormat.format(d);
             String filtro2 = horachecada;
             

             
            // milis_a = (long) (hourFormat.parse(filtro2).getTime());
             milis_a = (long) (hourFormat.parse(filtro2).getTime()- 2.16e+7);
             //println(hourFormat.format(d));
             //println("actual "+ milis_a);
             
             Date fecha_actual = fechaFormat.parse(fechaactual);
             //println(ultima_fecha);
             Date fecha_anterior = fechaFormat.parse(ultima_fecha);
                  
             //println(fecha_anterior);
             //println(fecha_actual);
             log2.wlog("Fecha Anterior "+fecha_anterior+" Fecha Actual "+fecha_actual);      
         
               if(fecha_anterior.equals(fecha_actual)){
                   
               }else{
                   
                   
                   //println(fecha_anterior);
                   //println(fecha_actual);
                   
                   
                   log2.wlog("Milisegundoss actuales "+milis_a+" Milisegundos despues de las 3am "+milis_c);
                   
                   if(milis_a>milis_c){
                       
                       
                       //println("actual "+ milis_a);
                       //println("3 horas am" + milis_c);
                       log2.wlog("Milisegundoss actuales "+milis_a+" Milisegundos despues de las 3am "+milis_c);
                       
                       
                       c.guardar(fechaactual);
                       corte();
                       
                   }
          
               }
      
         } catch (ParseException ex) {
             log2.wlog("error con las fechas"+ex);
             
             
             Logger.getLogger(corte.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
    public void _fechacorte(String fecha_anterio,String fecha_actua,String hora){
        c.cargar();
        d = new Date();

        long milis_c = (long) 1.08e+7;
        long milis_a = 0;
        String ultima_fecha = fecha_anterio;
                
         try {
             
             String filtro = fechaFormat.format(d);
             String filtro2 = hora;
             

             
             milis_a = (long) (hourFormat.parse(filtro2).getTime()- 2.16e+7);
             //println(hourFormat.format(d));
             //println("actual "+ milis_a);
             
             Date fecha_actual = fechaFormat.parse(filtro);
             //println(ultima_fecha);
             Date fecha_anterior = fechaFormat.parse(ultima_fecha);
                  
             //println(fecha_anterior);
             //println(fecha_actual);
             log2.wlog("Fecha Anterior "+fecha_anterior+" Fecha Actual "+fecha_actual);      
             
               if(fecha_anterior.before(fecha_actual)){
                   
                   
                   //println(fecha_anterior);
                   //println(fecha_actual);
                   
                   
                   log2.wlog("Milisegundoss actuales "+milis_a+" Milisegundos despues de las 3am "+milis_c);
                   
                   if(milis_a>milis_c){
                       
                       
                       //println("actual "+ milis_a);
                       //println("3 horas am" + milis_c);
                       log2.wlog("Milisegundoss actuales "+milis_a+" Milisegundos despues de las 3am "+milis_c);
                       
                       
                       c.guardar(filtro);
                       _corte(fecha_anterio);
                       
                   }
          
               }
      
         } catch (ParseException ex) {
             log2.wlog("error con las fechas"+ex);
             
             
             Logger.getLogger(corte.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
    public void _corte(String fecha_anterior){
       d = new Date();
        try {
            
            
          
            
            String barra = File.separator;
            String proyecto = System.getProperty("user.dir")+barra+"rehu";
            File af = new File(proyecto);
            String db2= "jdbc:sqlite:"+proyecto;
     
            
            Conexion = DriverManager.getConnection(db2);
            
            String sql= "UPDATE registro SET opt = '0' ";
            PreparedStatement us8 = Conexion.prepareStatement(sql);
            us8.execute();
            us8.close();
            
            Conexion.close();
        } catch (SQLException ex) {
             Logger.getLogger(corte.class.getName()).log(Level.SEVERE,null, ex);
        }
        
        
    }
    public void corte(){
      d = new Date();
        try {
            
            String barra = File.separator;
            String proyecto = System.getProperty("user.dir")+barra+"rehu";
            File af = new File(proyecto);
            String db= "jdbc:sqlite:"+proyecto;
            
            Conexion  = DriverManager.getConnection(db);
        
            
            
            
            
            String sql= "UPDATE registro SET opt = '0' ";
            PreparedStatement us5 = Conexion.prepareStatement(sql);
            us5.executeUpdate();
            us5.close();
            
            Conexion.close();
        } catch (SQLException ex) {
             Logger.getLogger(corte.class.getName()).log(Level.SEVERE,null, ex);
        }
        
        
    }
    
}
