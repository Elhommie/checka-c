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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author DC45-61
 */


public class act_tablas1 extends DefaultTableCellRenderer {
    Connection Conexion;
    DefaultTableModel modelTabla;

    DateFormat hourFormat = new SimpleDateFormat("HH:mm");
    DateFormat fechaFormatd = new SimpleDateFormat("yyyy/MM/d");
    GregorianCalendar fechaCalendario = new GregorianCalendar();
    
;
        Date fechaInicio=new Date();
        Date fechaFin=new Date();
        Date fechaInicioC=new Date();
        Date fechaFinC=new Date();
        String turencontrado="";
        
            
       
        Date d = new Date();
        Date dd = new Date();
        long max;
        long min;
        long entradaa;
                    
        Date d2 = new Date();
        Date dd2 = new Date();

     public void actualizart( JTable table, String sql, int column,String[] columna,JTable turnos) {
            String barra = File.separator;
            String proyecto = System.getProperty("user.dir")+barra+"rehu";
            File af = new File(proyecto);
            String db= "jdbc:sqlite:"+proyecto;
            
        try {
            Conexion  = DriverManager.getConnection(db);
        } catch (SQLException ex) {
            Logger.getLogger(act_tablas1.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        modelTabla = new DefaultTableModel(null,columna){
        public boolean isCellEditable(int rowIndex, int mColIndex) {
        return false;
        }};
        
        
            
        
            
       
        
        
        
        modelTabla = (DefaultTableModel) table.getModel();

      
        
       
        
        try {
            
            PreparedStatement us = Conexion.prepareStatement(sql);
            
            ResultSet res = us.executeQuery();
            
            Object datos[]= new Object[column];
            Object lineas = "----";
            
            while(res.next()){
                //System.out.println("resultados obtenidos");
                for(int i=0; i<column;i++){
        
                    datos[i]= res.getObject(i+1);
             
 
                    
   
                if(i==5){
                    
                    String hentrada = String.valueOf(datos[2]);     
                    String hsalida = String.valueOf(datos[5]);
                    String hcentrada = String.valueOf(datos[3]);
                    String hcsalida = String.valueOf(datos[4]);
                    
                    
                    long tiempoInicial=0;
                    long tiempoFinal=0;
                    long resta;
                    
                    long tiempoInicialC=0;
                    long tiempoFinalC=0; 
                    long restaC;
                    
                    
                        try {
                            if(lineas.equals(hentrada)||lineas.equals(hsalida)){
                                
                            }else{                               
                                fechaInicio = hourFormat.parse(hentrada);
                                tiempoInicial=fechaInicio.getTime();
                                fechaFin = hourFormat.parse(hsalida);
                                tiempoFinal=fechaFin.getTime();
                            }

                            
                  //////////////////////////////tiempo de ocmida          
                            if(lineas.equals(hcentrada)||lineas.equals(hcsalida)){
                                
                            }else{                               
                                fechaInicioC = hourFormat.parse(hcentrada);
                                tiempoInicialC=fechaInicioC.getTime();
                                fechaFinC = hourFormat.parse(hcsalida);
                                tiempoFinalC=fechaFinC.getTime();
                            }

    
                        } catch (ParseException ex) {
                            Logger.getLogger(act_tablas1.class.getName()).log(Level.SEVERE, null, ex);
                        }
             
                    if(tiempoFinal<tiempoInicial){  
                        resta=(long) (tiempoFinal - (tiempoInicial- 8.64e+7 )  );
                 
    
                     }else{
                    
                     resta=tiempoFinal - tiempoInicial;
  
                    }
                    if(tiempoFinalC<tiempoInicialC){  
                       
                        restaC=(long) (tiempoFinalC  - (tiempoInicialC - 8.64e+7));
    
                     }else{
                     restaC=tiempoFinalC - tiempoInicialC;
                    
  
                    }
                     
                    

                   
                    
                    long hora  = (resta/3600000);
                    long restohora = resta%3600000;
                    long minuto = restohora/60000;
                    
                    long horaC  = (restaC/3600000);
                    long restohoraC = restaC%3600000;
                    long minutoC = restohoraC/60000;
                    
                    
                    
                    
                    String tiempofinalC = (horaC+":"+minutoC);
                    i++;
                    datos[i] = tiempofinalC;
                    
                    String tiempofinal = (hora + ":" + minuto);
                    i++;
                    datos[i] = tiempofinal;
        
                 modelTabla.addRow(datos);
                 
            } 
                }
            }
            
            
            table.setModel(modelTabla);
            res.close();
         Conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(act_tablas1.class.getName()).log(Level.SEVERE, null, ex);
        }
        
            }
     
     public void actualizarp( JTable table, String sql, int column,String[] columna,JTable turnos) {
        

        modelTabla = new DefaultTableModel(null,columna){
        public boolean isCellEditable(int rowIndex, int mColIndex) {
        return false;
        }};

       
        
        try {
            String barra = File.separator;
            String proyecto = System.getProperty("user.dir")+barra+"rehu";
            File af = new File(proyecto);
            String db= "jdbc:sqlite:"+proyecto;
            
            Conexion  = DriverManager.getConnection(db);
        } catch (SQLException ex) {
            Logger.getLogger(act_tablas1.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            
            Statement us = Conexion.createStatement();
            
            ResultSet res = us.executeQuery(sql);
            
            Object datos[]= new Object[column];
            Object lineas = "----";
            
            
            
            
            
            
            while(res.next()){
                //System.out.println("resultados obtenidos");
                for(int i=0; i<column;i++){
                    
                   
                    
                    
                    
                    datos[i]= res.getObject(i+1);
             
 
                    
   
                if(i==4){
                    
                    String hentrada = String.valueOf(datos[1]);     
                    String hsalida = String.valueOf(datos[4]);
                    String hcentrada = String.valueOf(datos[2]);
                    String hcsalida = String.valueOf(datos[3]);
                    
                    
                    long tiempoInicial=0;
                    long tiempoFinal=0;
                    long resta;
                    
                    long tiempoInicialC=0;
                    long tiempoFinalC=0; 
                    long restaC;
                    
                    
                        try {
                           
                            if(lineas.equals(hentrada)||lineas.equals(hsalida)){
                                
                            }else{
                                if(hentrada.contains("-")){
                                    fechaInicio = hourFormat.parse(hentrada.substring(3));
                                    System.out.println("Se detecto - ");
                                }else{
                                    fechaInicio = hourFormat.parse(hentrada);
                                }
                                
                                System.out.println(hentrada);
                                System.out.println(hsalida);
                                
                                tiempoInicial=fechaInicio.getTime();
                                
                                if(hsalida.contains("-")){
                                    fechaFin = hourFormat.parse(hsalida);
                                }else{
                                    fechaFin = hourFormat.parse(hsalida);
                                }
                                
                                tiempoFinal=fechaFin.getTime();
                            }

                            
                  //////////////////////////////tiempo de ocmida          
                            if(lineas.equals(hcentrada)||lineas.equals(hcsalida)){
                                
                            }else{
                                
                                fechaInicioC = hourFormat.parse(hcentrada);
                                tiempoInicialC=fechaInicioC.getTime();
                                fechaFinC = hourFormat.parse(hcsalida);
                                tiempoFinalC=fechaFinC.getTime();
                            }

    
                        } catch (ParseException ex) {
                            Logger.getLogger(act_tablas1.class.getName()).log(Level.SEVERE, null, ex);
                        }
             
                    if(tiempoFinal<tiempoInicial){  
                        resta=(long) (tiempoFinal - (tiempoInicial- 8.64e+7 )  );
                 
    
                     }else{
                    
                     resta=tiempoFinal - tiempoInicial;
  
                    }
                    if(tiempoFinalC<tiempoInicialC){  
                       
                        restaC=(long) (tiempoFinalC  - (tiempoInicialC - 8.64e+7));
    
                     }else{
                     restaC=tiempoFinalC - tiempoInicialC;
                    
  
                    }
                     
                    

                   
                    
                    long hora  = (resta/3600000);
                    long restohora = resta%3600000;
                    long minuto = restohora/60000;
                    
                    long horaC  = (restaC/3600000);
                    long restohoraC = restaC%3600000;
                    long minutoC = restohoraC/60000
                            ;
                    
                    
                    DecimalFormat formatter = new DecimalFormat("##");
                    
                    String tiempofinalC = (String.format("%02d",horaC)+":"+String.format("%02d",minutoC));
                    i++;
                    datos[i] = tiempofinalC;
                    
                    String tiempofinal = (String.format("%02d",hora) + ":" + String.format("%02d",minuto));
                    i++;
                    datos[i] = tiempofinal;
                    
                    
         
                    
                    
   
        DefaultTableModel modelTabla2;
        modelTabla2=(DefaultTableModel) turnos.getModel();
        int row = modelTabla2.getRowCount();
        
//        
//         for(int x=0;x<row;x++){
//             
//            try {
//                
//                d = hourFormat.parse( String.valueOf(modelTabla2.getValueAt(x, 1)));
//                dd = hourFormat.parse(String.valueOf(datos[1]));
//                
//               
//            } catch (ParseException ex) {
//                Logger.getLogger(turnoauto.class.getName()).log(Level.SEVERE, null, ex);
//            }
//            
//                max = (long) (d.getTime()+(5.4e+6));
//                min = (long) (d.getTime()-(5.4e+6));
//                entradaa= (long)(dd.getTime());
//               // System.out.println("Maximo  "+max+"minimo  "+min+"real  "+entradaa);
//                
//                if(min<=entradaa && max>=entradaa ){
//                     turencontrado = String.valueOf(modelTabla2.getValueAt(x, 0));
//                 }     
//                
//            
//         }

//         if("".equals(turencontrado)){
//             turencontrado="libre";
//         }
                
                    i++;
                    datos[i]=res.getObject(6);
                    turencontrado="";
                }
                
            }
                        
                modelTabla.addRow(datos);
                
                
            }
            
            table.setModel(modelTabla);
            res.close();
            
            
          Conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(act_tablas1.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
            }
     DateFormat fechaFormat = new SimpleDateFormat("EEEE, d/MMM/yyyy");
     DateFormat fechaentrada = new SimpleDateFormat("yyyy/MM/dd");
     
     DateFormat fechaFormatG = new SimpleDateFormat("EEEE, d-MMM-yyyy");
     DateFormat fechaentradaG = new SimpleDateFormat("yyyy-MM-dd");
     
     
    public void colorear(JTable table,JTable turnos,int tolerancia) {
 
        
        DefaultTableModel modelTablaturnos = (DefaultTableModel) turnos.getModel();
        
        modelTabla= (DefaultTableModel) table.getModel();
        String horaentrada = "00:00" ;
        boolean turen;
        String entrada;
        String tiempocomida;
    
        
        
        Date dattt = new Date();
        String fechaa;
        
        for(int i=0;i<table.getRowCount();i++){
            
             fechaa = String.valueOf(table.getValueAt(i, 0));
           
             
             
             
            try {
                
                if(fechaa.contains("/")){
                    dattt =  fechaentrada.parse(fechaa);
                }else{
                    dattt =  fechaentradaG.parse(fechaa);
                }
               
            } catch (ParseException ex) {
                Logger.getLogger(act_tablas1.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
            if(fechaa.contains("/")){
            table.setValueAt(fechaFormat.format(dattt), i, 0);
            }else{
                table.setValueAt(fechaFormatG.format(dattt), i, 0);
            }
            
            entrada  = String.valueOf(table.getValueAt(i, 1));
           // tiempocomida = String.valueOf(table.getValueAt(i, 6));
            
         
            
             
            if(5==4){
                
                
            }else{
           
                
                String nturno = String.valueOf(table.getValueAt(i, 7));
               
                int colum= turnos.getColumnCount();
                int row = turnos.getRowCount();
                int indxdone=100;
                
                String tabla[]=new String[row];
                //System.out.println(String.valueOf(modelTablaturnos.getValueAt(0, 0)));
                  turen=true;
                  
                
                if(nturno.contains("/")){/////////////////////TURNOS DOBLES
                    int numreg = 0;
                    Object prim = table.getValueAt(i, 0);
                    
                    for(int s=0;s<table.getRowCount();s++){////////////////////BUSQUEDA DE MAS DE 2 REGISTROS POR DIA
                        
                        if(prim.equals(table.getValueAt(s,0))){
                            numreg++;
                        }
                        
                    }
                    
                    
                    System.err.println("cotiene doble turno");
                    
                    String separarturno = String.valueOf(table.getValueAt(i, 7));
                    
                    if(numreg>1){///////////////////////PRIMER TURNO
                        
                        int indexx = separarturno.indexOf("/");
                        
                        nturno = separarturno.substring(indexx+1);
                        
                        
                        
                        System.err.println("primero turno extraido "+ nturno);
                        
                    }else{//////////////////////SEGUNDO TURNO
                        
                        int indexx = separarturno.indexOf("/");
                        
                        nturno = separarturno.substring(0, indexx);
                        //nturno
                        
                         System.err.println("segundo turno extraido "+ nturno);
                        
                        
                    }
                    
                    
                }
                  
           /////////////////////////////////////////////////////////////////////////////
                for(int x=0;x<row;x++){
                    tabla[x]=  (String) modelTablaturnos.getValueAt(x, 0);
 
                       if(tabla[x].equals(nturno)){
                           indxdone=x;
                       }
    
                }
                
                
              if(indxdone==100){
                  turen=false;
              }else{
                  horaentrada=(String) turnos.getValueAt(indxdone,1);
              }
              
              
              
              
              
            try {
                d2 = hourFormat.parse(horaentrada);
                if(entrada.contains("T")){
                    dd2 = hourFormat.parse(entrada.substring(2));
                }else if(entrada.contains("R")){
                    dd2 = hourFormat.parse(entrada.substring(2));
                }else{
                     dd2 = hourFormat.parse(entrada);
                }
               
               
               
            } catch (ParseException ex) {
                Logger.getLogger(act_tablas1.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
            
            long ent= dd2.getTime();
            long entstol =d2.getTime();
            long tol= d2.getTime()+600000;
             
            //System.out.println(turen);     
                
            if(!turen){
                
                modelTabla.setValueAt(entrada, i, 1);
               
            }else if(entstol>=ent){
                
                modelTabla.setValueAt(entrada, i, 1);
                
                
            }else if(ent<=tol){
                
                //modelTabla.setValueAt("T -"+entrada, i, 1);
                
            }else if(ent>tol){
                
                //modelTabla.setValueAt("R -"+entrada, i, 1);
                
            }
            
            
            
            
            
            
            
            }
            
        }
        
         table.setModel(modelTabla);
    }
    public void colorear2(JTable table,JTable turnos,int tolerancia,String turno) {
 
        
        DefaultTableModel modelTablaturnos = (DefaultTableModel) turnos.getModel();
        
        modelTabla= (DefaultTableModel) table.getModel();
        String horaentrada = "00:00" ;
        boolean turen;
        String entrada;
        String tiempocomida;
    
        
        
        Date dattt = new Date();
        String fechaa;
        
        for(int i=0;i<table.getRowCount();i++){
            
             fechaa = String.valueOf(table.getValueAt(i, 0));
           
             
             
             
            try {
                
                if(fechaa.contains("/")){
                    dattt =  fechaentrada.parse(fechaa);
                }else{
                    dattt =  fechaentradaG.parse(fechaa);
                }
               
            } catch (ParseException ex) {
                Logger.getLogger(act_tablas1.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
            if(fechaa.contains("/")){
            table.setValueAt(fechaFormat.format(dattt), i, 0);
            }else{
                table.setValueAt(fechaFormatG.format(dattt), i, 0);
            }
            
            entrada  = String.valueOf(table.getValueAt(i, 2));
           // tiempocomida = String.valueOf(table.getValueAt(i, 6));
            
         
            
             
            if(5==4){
                
                
            }else{
           
                
                String nturno = turno;
               
                int colum= turnos.getColumnCount();
                int row = turnos.getRowCount();
                int indxdone=100;
                
                String tabla[]=new String[row];
                //System.out.println(String.valueOf(modelTablaturnos.getValueAt(0, 0)));
                  turen=true;
                for(int x=0;x<row;x++){
                    tabla[x]=  (String) modelTablaturnos.getValueAt(x, 0);
                  //  System.out.println("Nombre turno "+tabla[x]+" A comparar "+nturno);
                    
 
                       if(tabla[x].equals(nturno)){
                           indxdone=x;
                       }
    
                }
                
              if(indxdone==100){
                  turen=false;
              }else{
                  horaentrada=(String) turnos.getValueAt(indxdone,1);
                 // System.out.println("Hora entrada encontrada "+horaentrada);
              }
              
              
              
              
              
            try {
                d2 = hourFormat.parse(horaentrada);
                if(entrada.contains("T")){
                    dd2 = hourFormat.parse(entrada.substring(2));
                }else if(entrada.contains("R")){
                    dd2 = hourFormat.parse(entrada.substring(2));
                }else{
                     dd2 = hourFormat.parse(entrada);
                }
               
            } catch (ParseException ex) {
                Logger.getLogger(act_tablas1.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
            
            long ent= dd2.getTime();
            long entstol =d2.getTime();
            long tol= d2.getTime()+600000;
             
          //  System.out.println(turen);     
                
            if(!turen){
                
                modelTabla.setValueAt(entrada, i, 2);
               
            }else if(entstol>=ent){
                
                modelTabla.setValueAt(entrada, i, 2);
                
                
            }else if(ent<=tol){
                
               // modelTabla.setValueAt("T - "+entrada, i, 2);
                
            }else if(ent>tol){
                
              //  modelTabla.setValueAt("R - "+entrada, i, 2);
                
            }
            
            
            
            
            
            
            
            }
            
        }
        
         table.setModel(modelTabla);
    }


    
    
    
    
    
    
}
