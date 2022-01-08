/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checka;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.Font;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;

/**
 *
 * @author DC45-61
 */
public class NewClass {
    
    public void exportarExcel(JTable t,String titulos,String totales) {
        
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos de excel", "xls");
        chooser.setFileFilter(filter);
        chooser.setDialogTitle("Guardar archivo");
        chooser.setAcceptAllFileFilterUsed(false);
        
        
        DefaultTableModel popo = new DefaultTableModel();
        popo = (DefaultTableModel) t.getModel();
        popo.addColumn("ASIS");
        t.setModel(popo);
        
        if (chooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
            String ruta = chooser.getSelectedFile().toString().concat(".xls");
            try {
                File archivoXLS = new File(ruta);
                
                if (archivoXLS.exists()) {
                    archivoXLS.delete();
                }
                
                
                archivoXLS.createNewFile();
                Workbook libro = new HSSFWorkbook();
                FileOutputStream archivo = new FileOutputStream(archivoXLS);
                
                Sheet hoja = libro.createSheet("Exportado 11");
                hoja.setDisplayGridlines(true);
    
             ///////////////////777ESTILO TITULOS    
             HSSFCellStyle my_style = (HSSFCellStyle) libro.createCellStyle();
             HSSFFont my_font = (HSSFFont) libro.createFont();
             
                my_style.setFillForegroundColor(IndexedColors.DARK_BLUE.getIndex()); 
                my_style.setFillPattern(CellStyle.SOLID_FOREGROUND);      
                my_style.setBottomBorderColor(IndexedColors.BLACK.getIndex());
                my_style.setBorderBottom(HSSFCellStyle.BORDER_MEDIUM); 
                my_style.setBorderTop(HSSFCellStyle.BORDER_MEDIUM); 
                my_style.setBorderRight(HSSFCellStyle.BORDER_MEDIUM); 
                my_style.setBorderLeft(HSSFCellStyle.BORDER_MEDIUM);
                my_font.setFontHeightInPoints((short)13);  
                my_font.setColor(IndexedColors.WHITE.getIndex());
                my_style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
                my_style.setFont(my_font);
               
                
            ////////////////////77ESTILO CELDAS
            HSSFFont my_font2 = (HSSFFont) libro.createFont();
            HSSFCellStyle my_style2 = (HSSFCellStyle) libro.createCellStyle();
                
                my_style2.setBottomBorderColor(IndexedColors.BLACK.getIndex());
                my_style2.setBorderRight(HSSFCellStyle.BORDER_THIN);
                my_style2.setAlignment(HSSFCellStyle.ALIGN_CENTER);
                my_font2.setFontHeightInPoints((short)13);  
                my_style2.setFont(my_font2);
                
                
            //////////////////////ESTILO CELDAS 2
            HSSFFont my_font3 = (HSSFFont) libro.createFont();
            HSSFCellStyle my_style3 = (HSSFCellStyle) libro.createCellStyle();
            
                my_style3.setFillForegroundColor(IndexedColors.LIGHT_CORNFLOWER_BLUE.getIndex()); 
                my_style3.setFillPattern(CellStyle.SOLID_FOREGROUND);                 
                my_style3.setBottomBorderColor(IndexedColors.BLACK.getIndex());
                my_style3.setBorderRight(HSSFCellStyle.BORDER_THIN);
                my_style3.setAlignment(HSSFCellStyle.ALIGN_CENTER);
                
                
               // my_font3.setColor(IndexedColors.WHITE.getIndex());
                
                my_font3.setFontHeightInPoints((short)13);  
                my_style3.setFont(my_font3);
            
            
                int titulo=0;
                String s[]= {titulos,"2","3","4","5","6 ","7","8","9"};
                
                hoja.addMergedRegion(new CellRangeAddress(0,0,0,8));
                hoja.addMergedRegion(new CellRangeAddress(1,1,0,8));
                
                for (int f = 0; f < t.getRowCount(); f++) {
                    Row fila = hoja.createRow(f);
                    
                    for (int c = 0; c < t.getColumnCount(); c++) {
                        Cell celda = fila.createCell(c);
                        
                        
                        celda.setCellStyle(my_style);
                        
                        if (f == 0  ) {
                            
                            celda.setCellValue(s[titulo]);
                            titulo++;
                           // System.out.println(t.getColumnName(c));
                            
                        }
                        
                        if (f == 1 ) {
                            
                            celda.setCellValue(totales);
                            titulo++;
                           // System.out.println(t.getColumnName(c));
                            
                        }

                        if (f == 2) {
                            
                            celda.setCellValue(t.getColumnName(c));
                            
                      
                            
                        }
                        
                    }
                }
                
                int filaInicio = 3;
                
                
                for (int f = 0; f < t.getRowCount(); f++) {
                    Row fila = hoja.createRow(filaInicio);
                    filaInicio++;
                    
                    
                    
                    for (int c = 0; c < t.getColumnCount(); c++) {
                        Cell celda = fila.createCell(c);
                        
                        
                        
                        if(f%2==0){
            
                             celda.setCellStyle(my_style3);
                        }else {
                             celda.setCellStyle(my_style2);
                            }
                        
                       
                        
                        
                        if(c==8){
                            if(String.valueOf(t.getValueAt(f, 1)).contains("-")){
                            celda.setCellValue(String.valueOf(t.getValueAt(f, 1)).substring(0,1));
                            }else{
                                
                                celda.setCellValue("NO");
                            }
                            
                            
                        }else if(c==1){
                             
                            if(String.valueOf(t.getValueAt(f, c)).contains("-")){
                                celda.setCellValue(String.valueOf(t.getValueAt(f, c)).substring(3));
                            }else{
                                celda.setCellValue(String.valueOf(t.getValueAt(f, c)));
                            }
                             
                             
                            
                        }else if (t.getValueAt(f, c) instanceof Double) {
                            celda.setCellValue(Double.parseDouble(t.getValueAt(f, c).toString()));
                            
                        } else if (t.getValueAt(f, c) instanceof Float) {
                            celda.setCellValue(Float.parseFloat((String) t.getValueAt(f, c)));
                        } else {
                            celda.setCellValue(String.valueOf(t.getValueAt(f, c)));
                        }
                        
                        
                        
                        
                    }
                }
               
                
                hoja.autoSizeColumn(0,false);
                hoja.autoSizeColumn(1,false);
                hoja.autoSizeColumn(2,false);
                hoja.autoSizeColumn(3,false);
                hoja.autoSizeColumn(4,false);
                hoja.autoSizeColumn(5,false);
                hoja.autoSizeColumn(6,false);
                hoja.autoSizeColumn(7,false);
                
                libro.write(archivo);
                archivo.close();
                Desktop.getDesktop().open(archivoXLS);
            } catch (IOException | NumberFormatException e) {
                
            }
        }
    }
    public void exportarExcel2(JTable t,String titulos,String totales) {
        
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos de excel", "xls");
        chooser.setFileFilter(filter);
        chooser.setDialogTitle("Guardar archivo");
        chooser.setAcceptAllFileFilterUsed(false);
        
        
        DefaultTableModel popo = new DefaultTableModel();
        popo = (DefaultTableModel) t.getModel();
        popo.addColumn("ASIS");
        t.setModel(popo);
        
        if (chooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
            String ruta = chooser.getSelectedFile().toString().concat(".xls");
            try {
                File archivoXLS = new File(ruta);
                
                if (archivoXLS.exists()) {
                    archivoXLS.delete();
                }
                
                
                archivoXLS.createNewFile();
                Workbook libro = new HSSFWorkbook();
                FileOutputStream archivo = new FileOutputStream(archivoXLS);
                
                Sheet hoja = libro.createSheet("Exportado 11");
                hoja.setDisplayGridlines(true);
    
             ///////////////////777ESTILO TITULOS    
             HSSFCellStyle my_style = (HSSFCellStyle) libro.createCellStyle();
             HSSFFont my_font = (HSSFFont) libro.createFont();
             
                my_style.setFillForegroundColor(IndexedColors.DARK_BLUE.getIndex()); 
                my_style.setFillPattern(CellStyle.SOLID_FOREGROUND);      
                my_style.setBottomBorderColor(IndexedColors.BLACK.getIndex());
                my_style.setBorderBottom(HSSFCellStyle.BORDER_MEDIUM); 
                my_style.setBorderTop(HSSFCellStyle.BORDER_MEDIUM); 
                my_style.setBorderRight(HSSFCellStyle.BORDER_MEDIUM); 
                my_style.setBorderLeft(HSSFCellStyle.BORDER_MEDIUM);
                my_font.setFontHeightInPoints((short)13);  
                my_font.setColor(IndexedColors.WHITE.getIndex());
                my_style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
                my_style.setFont(my_font);
               
                
            ////////////////////77ESTILO CELDAS
            HSSFFont my_font2 = (HSSFFont) libro.createFont();
            HSSFCellStyle my_style2 = (HSSFCellStyle) libro.createCellStyle();
                
                my_style2.setBottomBorderColor(IndexedColors.BLACK.getIndex());
                my_style2.setBorderRight(HSSFCellStyle.BORDER_THIN);
                my_style2.setAlignment(HSSFCellStyle.ALIGN_CENTER);
                my_font2.setFontHeightInPoints((short)13);  
                my_style2.setFont(my_font2);
                
                
            //////////////////////ESTILO CELDAS 2
            HSSFFont my_font3 = (HSSFFont) libro.createFont();
            HSSFCellStyle my_style3 = (HSSFCellStyle) libro.createCellStyle();
            
                my_style3.setFillForegroundColor(IndexedColors.LIGHT_CORNFLOWER_BLUE.getIndex()); 
                my_style3.setFillPattern(CellStyle.SOLID_FOREGROUND);                 
                my_style3.setBottomBorderColor(IndexedColors.BLACK.getIndex());
                my_style3.setBorderRight(HSSFCellStyle.BORDER_THIN);
                my_style3.setAlignment(HSSFCellStyle.ALIGN_CENTER);
                
                
               // my_font3.setColor(IndexedColors.WHITE.getIndex());
                
                my_font3.setFontHeightInPoints((short)13);  
                my_style3.setFont(my_font3);
            
            
                int titulo=0;
                String s[]= {titulos,"2","3","4","5","6 ","7","8","9"};
                
                hoja.addMergedRegion(new CellRangeAddress(0,0,0,8));
                hoja.addMergedRegion(new CellRangeAddress(1,1,0,8));
                
                for (int f = 0; f < t.getRowCount(); f++) {
                    Row fila = hoja.createRow(f);
                    
                    for (int c = 0; c < t.getColumnCount(); c++) {
                        Cell celda = fila.createCell(c);
                        
                        
                        celda.setCellStyle(my_style);
                        
                        if (f == 0  ) {
                            
                            celda.setCellValue(s[titulo]);
                            titulo++;
                           // System.out.println(t.getColumnName(c));
                            
                        }
                        
                        if (f == 1 ) {
                            
                            celda.setCellValue(totales);
                            titulo++;
                           // System.out.println(t.getColumnName(c));
                            
                        }

                        if (f == 2) {
                            
                            celda.setCellValue(t.getColumnName(c));
                            
                      
                            
                        }
                        
                    }
                }
                
                int filaInicio = 3;
                
                
                for (int f = 0; f < t.getRowCount(); f++) {
                    Row fila = hoja.createRow(filaInicio);
                    filaInicio++;
                    
                    
                    
                    for (int c = 0; c < t.getColumnCount(); c++) {
                        Cell celda = fila.createCell(c);
                        
                        
                        
                        if(f%2==0){
            
                             celda.setCellStyle(my_style3);
                        }else {
                             celda.setCellStyle(my_style2);
                            }
                        
                       
                        
                        
                        if(c==8){
                            if(String.valueOf(t.getValueAt(f, 2)).contains("-")){
                               celda.setCellValue(String.valueOf(t.getValueAt(f, 2)).substring(0,1));
                            }else{
                                
                                celda.setCellValue("NO");
                            }
                            
                            
                        }else if(c==2){ 
                           //  System.out.println(String.valueOf(t.getValueAt(f, c)));
                            if(String.valueOf(t.getValueAt(f, c)).contains("-")){
                                celda.setCellValue(String.valueOf(t.getValueAt(f, c)).substring(3));
                            }else{
                                celda.setCellValue(String.valueOf(t.getValueAt(f, c)));
                            }
                             
                             
                            
                        }else if (t.getValueAt(f, c) instanceof Double) {
                            celda.setCellValue(Double.parseDouble(t.getValueAt(f, c).toString()));
                            
                        } else if (t.getValueAt(f, c) instanceof Float) {
                            celda.setCellValue(Float.parseFloat((String) t.getValueAt(f, c)));
                        } else {
                            celda.setCellValue(String.valueOf(t.getValueAt(f, c)));
                        }
                        
                        
                        
                        
                    }
                }
               
                
                hoja.autoSizeColumn(0,false);
                hoja.autoSizeColumn(1,false);
                hoja.autoSizeColumn(2,false);
                hoja.autoSizeColumn(3,false);
                hoja.autoSizeColumn(4,false);
                hoja.autoSizeColumn(5,false);
                hoja.autoSizeColumn(6,false);
                hoja.autoSizeColumn(7,false);
                
                libro.write(archivo);
                archivo.close();
                Desktop.getDesktop().open(archivoXLS);
            } catch (IOException | NumberFormatException e) {
                
            }
        }
    }
    
    
    public void exportarExcel3(JTable t,String ln1,String ln2,String ln3,String lnp,String lnf) {
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos de excel", "xls");
        chooser.setFileFilter(filter);
        chooser.setDialogTitle("Guardar archivo");
        chooser.setAcceptAllFileFilterUsed(false);
        if (chooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
            String ruta = chooser.getSelectedFile().toString().concat(".xls");
            try {
                File archivoXLS = new File(ruta);
                if (archivoXLS.exists()) {
                    archivoXLS.delete();
                }
                archivoXLS.createNewFile();
                Workbook libro = new HSSFWorkbook();
                FileOutputStream archivo = new FileOutputStream(archivoXLS);
                Sheet hoja = libro.createSheet("Mi hoja de trabajo 1");
                hoja.setDisplayGridlines(true);
                 HSSFCellStyle my_style = (HSSFCellStyle) libro.createCellStyle();
                 HSSFFont my_font = (HSSFFont) libro.createFont();
                 my_font.setFontHeightInPoints((short)13);  
                 my_style.setFont(my_font);
                
                 
                 ///////////////////////////////////////////////////////////////////////////////////////
                 HSSFFont my_font2 = (HSSFFont) libro.createFont();
                 HSSFCellStyle my_style2 = (HSSFCellStyle) libro.createCellStyle();
                
                my_style2.setBottomBorderColor(IndexedColors.BLACK.getIndex());
                my_style2.setBorderRight(HSSFCellStyle.BORDER_THIN);
                my_style2.setAlignment(HSSFCellStyle.ALIGN_CENTER);
                my_font2.setFontHeightInPoints((short)13);  
                my_style2.setFont(my_font2);
                ///////////////////////////////////////////////////////////////
                Row filat = hoja.createRow(0);
                Cell celdat = filat.createCell(0);
              
                celdat.setCellStyle(my_style);
                celdat.setCellValue(ln1);
                filat = hoja.createRow(1);
                celdat = filat.createCell(0);
                celdat.setCellStyle(my_style);
                celdat.setCellValue(ln2);
                filat = hoja.createRow(2);
                celdat = filat.createCell(0);
                celdat.setCellStyle(my_style);
                celdat.setCellValue(ln3);
                
                
                hoja.addMergedRegion(new CellRangeAddress(0,0,0,12));
                hoja.addMergedRegion(new CellRangeAddress(1,1,0,12));
                hoja.addMergedRegion(new CellRangeAddress(2,2,0,12));
                
                for (int f = 0; f < t.getRowCount(); f++) {
                    Row fila = hoja.createRow(f+3);
                    for (int c = 0; c < t.getColumnCount(); c++) {
                        Cell celda = fila.createCell(c+2);
                        if (f == 0) {
                            celda.setCellValue(t.getColumnName(c));
                            celda.setCellStyle(my_style2);
                        }
                    }
                }
                
                int filaInicio = 4;
                for (int f = 0; f < t.getRowCount(); f++) {
                    Row fila = hoja.createRow(filaInicio);
                    filaInicio++;
                    for (int c = 0; c < t.getColumnCount(); c++) {
                        Cell celda = fila.createCell(c+2);
                       
                            celda.setCellValue(String.valueOf(t.getValueAt(f, c)));
                            celda.setCellStyle(my_style2);
                    }
                }
                
                
                filat = hoja.createRow(t.getRowCount()+5);
                celdat = filat.createCell(0);
                celdat.setCellStyle(my_style);
                celdat.setCellValue(lnp);
                hoja.addMergedRegion(new CellRangeAddress(t.getRowCount()+5,t.getRowCount()+5,0,6));
                HSSFCellStyle my_style5 = (HSSFCellStyle) libro.createCellStyle();
                my_style5.setAlignment(HSSFCellStyle.ALIGN_RIGHT);
                my_style5.setFont(my_font);
                celdat.setCellStyle(my_style5);
                filat = hoja.createRow(t.getRowCount()+6);
                celdat = filat.createCell(0);
                celdat.setCellStyle(my_style);
                celdat.setCellValue(lnf);
                hoja.addMergedRegion(new CellRangeAddress(t.getRowCount()+6,t.getRowCount()+6,0,6));
                
                
                hoja.autoSizeColumn(0,false);
                hoja.autoSizeColumn(1,false);
                hoja.autoSizeColumn(2,false);
                hoja.autoSizeColumn(3,false);
                hoja.autoSizeColumn(4,false);
                hoja.autoSizeColumn(5,false);
                hoja.autoSizeColumn(6,false);
               
                
                
                libro.write(archivo);
                archivo.close();
                Desktop.getDesktop().open(archivoXLS);
            } catch (IOException | NumberFormatException e) {
                
            }
        }

     }
}
