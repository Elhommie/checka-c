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
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;

/**
 *
 * @author DC45-61
 */
public class act_tablas_resumen {
    Connection Conexion;
    
    DateFormat hourFormat = new SimpleDateFormat("HH:mm");
    
    public String[] comidaauto(Date d,String indx){
        try {
            Conexion = (Connection) DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306","root","");
        } catch (SQLException ex) {
            Logger.getLogger(act_tablas.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String sql = "Select c_entrada from rehu.registro where indx = '"+indx+"'";
        
        PreparedStatement us;
        try {
            us = Conexion.prepareStatement(sql);
            ResultSet res = us.executeQuery();
            Object datos = null;
            
            while(res.next()){
            datos= res.getObject(1);
            }
            //println(datos);
            
        } catch (SQLException ex) {
            Logger.getLogger(act_tablas_resumen.class.getName()).log(Level.SEVERE, null, ex);
        }
       

        String r[] = null ;
        r[0]="f";
        r[1]="23:34";
        
        
        
        
        
        
        
        return r;
    }
    public void resumen(JTable tabla){
        
        
        
    }
    
}
