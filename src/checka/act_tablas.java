/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checka;

import java.awt.TrayIcon;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author DC45-61
 */
public class act_tablas {
String barra = File.separator;
            String proyecto = System.getProperty("user.dir")+barra+"rehu";
          //  File af = new File(proyecto);
            String db= "jdbc:sqlite:"+proyecto;
    
    Connection Conexion;
    DefaultTableModel modelTabla;
    conexionBD c = new conexionBD();
    
        regevet log2 = new regevet();
            
    public String obtener_ultimafecha(){
  
        String resultado = null;
        try {
           
            Conexion  = DriverManager.getConnection(db);
            
            
           Statement us =  Conexion.createStatement();
            ResultSet res = us.executeQuery("Select MAX(fecha) from registro ");
            
            if(res.next()){
                resultado = String.valueOf(res.getObject(1));
            }
            Conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(act_tablas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return  resultado;
    }
    
    public void actualizar_turno_nuevo(JTable table, String sql, int column,String[] columna){
        modelTabla = new DefaultTableModel(null,columna){
        public boolean isCellEditable(int rowIndex, int mColIndex) {
        return false;
        }};
        table.removeAll();
        while(modelTabla.getRowCount()>0)modelTabla.removeRow(0);
        
        
    try {
        
        Conexion  = DriverManager.getConnection(db);
        Statement us = Conexion.createStatement();
            ResultSet res = us.executeQuery(sql);
            
            Object datos[]= new Object[column];
            int x=0;
            while(res.next()&&x<100){
                x++;
                for(int i=0; i<column;i++){
                    datos[i]= res.getObject(i+1);
                    
                }
                
      
                try {
                    
                    
                    
                modelTabla.addRow(datos);
                table.setModel(modelTabla);
                
                } catch (Exception e) {
                    log2.wlog("ERROR CON SORTER");
                    Logger.getLogger(act_tablas.class.getName()).log(Level.SEVERE, null, e);
                }

                
            }
            
            if(res.next()==false){
                table.setModel(modelTabla);
            }
            res.close();
           Conexion.close();
        
    } catch (SQLException ex) {
        Logger.getLogger(act_tablas.class.getName()).log(Level.SEVERE, null, ex);
    }
        
        
    }
    
    public void actualizar( JTable table, String sql, int column,String[] columna) {
        
        modelTabla = new DefaultTableModel(null,columna){
        public boolean isCellEditable(int rowIndex, int mColIndex) {
        return false;
        }};
        
         table.removeAll();
         
         

        c.cargar();
        try {
        
        Conexion  = DriverManager.getConnection(db);
        while(modelTabla.getRowCount()>0)modelTabla.removeRow(0);
        
        
            
            Statement us = Conexion.createStatement();
            ResultSet res = us.executeQuery(sql);
            
            Object datos[]= new Object[column];
            int x=0;
            while(res.next()&&x<100){
                x++;
                for(int i=0; i<column;i++){
                    datos[i]= res.getObject(i+1);
                    
                }
                
      
                try {
                    
                modelTabla.addRow(datos);
                table.setModel(modelTabla);
                
                } catch (Exception e) {
                    log2.wlog("ERROR CON SORTER");
                    Logger.getLogger(act_tablas.class.getName()).log(Level.SEVERE, null, e);
                }

                
            }
            
            if(res.next()==false){
                table.setModel(modelTabla);
            }
            res.close();
           Conexion.close();
        } catch (SQLException ex) {
         
            JOptionPane.showMessageDialog(null, ex,"ERROR AL CONSULTAR BASE DE DATOS",ERROR_MESSAGE);
            Logger.getLogger(act_tablas.class.getName()).log(Level.SEVERE, null, ex);
        }
        
          
          
          
    }

    public void actualizartdo( JTable table, String sql, int column,String[] columna) throws SQLException{
        
        modelTabla = new DefaultTableModel(null,columna){
        public boolean isCellEditable(int rowIndex, int mColIndex) {
        return false;
        }};

        c.cargar();
        
        
        while(modelTabla.getRowCount()>0)modelTabla.removeRow(0);
        
        try {
            Conexion  = DriverManager.getConnection(db);
            Statement us = Conexion.createStatement();
            ResultSet res = us.executeQuery(sql);
            
            Object datos[]= new Object[column];
            int x=0;
            while(res.next()){
                x++;
                for(int i=0; i<column;i++){
                    datos[i]= res.getObject(i+1);
                    
                }
                
                modelTabla.addRow(datos);
                table.setModel(modelTabla);
                
            }
            
            if(res.next()==false){
                table.setModel(modelTabla);
            }
            res.close();
           Conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(act_tablas.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    
    
    
    
}
