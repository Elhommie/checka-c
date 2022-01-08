/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checka;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author DC45-61
 */



public class turnoauto {
    DateFormat hourFormat = new SimpleDateFormat("HH:mm");
    conexionBD c = new conexionBD();
    Connection Conexion;
   
    
        Date d = new Date();
        Date dd = new Date();
        long max;
        long min;
        long entradaa;
        
        
        
        
        
    
    public String entradalibre (JTable turnos,String datos ){
       String turencontrado="";
      
        
        DefaultTableModel modelTabla2;
        modelTabla2=(DefaultTableModel) turnos.getModel();
        int row = modelTabla2.getRowCount();
        boolean R = false;
        for(int x=0;x<row;x++){
        try {
                
                d = hourFormat.parse( String.valueOf(modelTabla2.getValueAt(x, 1)));
                dd = hourFormat.parse(String.valueOf(datos));
                
               
            } catch (ParseException ex) {
                Logger.getLogger(turnoauto.class.getName()).log(Level.SEVERE, null, ex);
            }
            
                max = (long) (d.getTime()+(5.4e+6));
                min = (long) (d.getTime()-(5.4e+6));
                entradaa= (long)(dd.getTime());
               // System.out.println("Maximo  "+max+"minimo  "+min+"real  "+entradaa);
                
                if(min<=entradaa && max>=entradaa ){
                     turencontrado = String.valueOf(modelTabla2.getValueAt(x, 0));
                 }     
         }
         
         if("".equals(turencontrado)){
             turencontrado="libre";
             
         }
         
         System.out.println(turencontrado);
         return turencontrado;
    }
    
    
    public boolean salidasincomer (String id, String datos){
    c.cargar();
             boolean R = false;
             String turnoreg = null;
             String horaentradaturno = null;
            String sql = "Select turnoreg from rehu.registro where codigo = "+id+" order by indx DESC";
             
             
             try {
                 
                 Conexion = (Connection) DriverManager.getConnection(c.getUrl(),c.getUser(),c.getPass());
                 PreparedStatement us = Conexion.prepareStatement(sql);
                 ResultSet res = us.executeQuery();
                 res.next();
                 turnoreg = res.getObject("turnoreg").toString();
                 res.close();
                 System.out.println(sql);
                 
            String sq2 = "Select * from rehu.turnos where nombre = '"+turnoreg+"'";
            
                 PreparedStatement us2 = Conexion.prepareStatement(sq2);
                 ResultSet res2 = us2.executeQuery();
                 while(res2.next()){
                 horaentradaturno = res2.getObject("entrada").toString();
                 }res2.close();
                 
                 System.out.println(sq2);

         } catch (SQLException ex) {
            Logger.getLogger(turnoauto.class.getName()).log(Level.SEVERE, null, ex);
        } 
         
        try {
            d = hourFormat.parse(horaentradaturno);
            dd = hourFormat.parse(datos);
        } catch (ParseException ex) {
            Logger.getLogger(turnoauto.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        max = (long) (d.getTime()+(9e+6));
        entradaa= (long)(dd.getTime());
        
        if(entradaa>max){
            R=true;
        }
          
         return R;
    }
    
    public boolean salirsalida(String id, String datos){
        
        c.cargar();
             boolean R = false;
             String turnoreg = null;
             String horaentradaturno = null;
             String sql = "Select turnoreg from rehu.registro where codigo = "+id+" order by indx DESC";
             
             
             try {
                 
                 Conexion = (Connection) DriverManager.getConnection(c.getUrl(),c.getUser(),c.getPass());
                 PreparedStatement us = Conexion.prepareStatement(sql);
                 ResultSet res = us.executeQuery();
                 res.next();
                 turnoreg = res.getObject("turnoreg").toString();
                 res.close();
                 System.out.println(sql);
                 
            String sq2 = "Select * from rehu.turnos where nombre = '"+turnoreg+"'";
            
                 PreparedStatement us2 = Conexion.prepareStatement(sq2);
                 ResultSet res2 = us2.executeQuery();
                 while(res2.next()){
                 horaentradaturno = res2.getObject("salida").toString();
                 }res2.close();
                 
                 System.out.println(sq2);

         } catch (SQLException ex) {
            Logger.getLogger(turnoauto.class.getName()).log(Level.SEVERE, null, ex);
        } 
         
        try {
            d = hourFormat.parse(horaentradaturno);
            dd = hourFormat.parse(datos);
        } catch (ParseException ex) {
            Logger.getLogger(turnoauto.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        max = (long) (d.getTime()-(1.8e+6));
        entradaa= (long)(dd.getTime());
        
        if(entradaa<max){
            R=true;
        }
          
         return R;
        
    }
}


