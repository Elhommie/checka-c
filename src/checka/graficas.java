/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checka;

import java.awt.Color;
import java.sql.Connection;
import javax.swing.JTable;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author DC45-61
 */
public class graficas {
Connection Conexion;   
String datos[][];
act_tablas1 act_t1 = new act_tablas1();
DefaultCategoryDataset Datos = new DefaultCategoryDataset();
JFreeChart Grafica1;
 
public void graff(){
    
    
    
}

public JFreeChart estadis(JTable turnos,JTable personal,String fecha1,String fecha2){
    JTable perbufer = new JTable();
    float retardos=0;
    float tolerancias=0;
    String sqlnombre="";
    String columna[]= {"Fecha","ENTRADA","EN.COMIDA","SA.COMIDA","SALIDA","T.Comida","T.Horas","Turno"};
    int row;
    int row2 = personal.getRowCount();
    for(int i=0;i<row2;i++){
    perbufer.removeAll();
    String nombre = String.valueOf(personal.getValueAt(i,1));
    
        
    sqlnombre = "Select fecha,entrada,c_entrada,c_salida,salida,turnoreg from registro where personal like '%"+nombre+"%' and fecha BETWEEN '"+fecha1+"' and '"+fecha2+"' order by fecha ASC"; 
    act_t1.actualizarp(perbufer, sqlnombre, 8, columna,turnos);
    act_t1.colorear(perbufer, turnos, 10);
    
    row = perbufer.getRowCount();
        for(int i2=0;i2<row;i2++){
            String analiz = String.valueOf(perbufer.getValueAt(i2, 1));
            String analiz2 = String.valueOf(perbufer.getValueAt(i2, 6));
  
          if(analiz.contains("R")){
               retardos++;
           }
          if(analiz.contains("T")){
               tolerancias=+(float)+.5;
           }
        
   
        }
        if(nombre.length()>15){
            nombre = nombre.substring(0,15);
        }
        
Datos.addValue(tolerancias, "Tolerancia", nombre);
Datos.addValue(retardos, "Retardos", nombre);
retardos=0;
tolerancias=0;
    }
    
   

Grafica1 = ChartFactory.createStackedBarChart("Puntualidad","Personal", "", Datos,PlotOrientation.HORIZONTAL, true, true, false);
 CategoryPlot plot = Grafica1.getCategoryPlot();
 org.jfree.chart.axis.CategoryAxis domainAxis = plot.getDomainAxis();
// domainAxis.setCategoryLabelPositions(CategoryLabelPositions.createUpRotationLabelPositions(Math.PI / 6.0));
 
 NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
 rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
 
 plot.setBackgroundPaint(Color.white);
 plot.setDomainGridlinePaint(Color.black);
 plot.setRangeGridlinePaint(Color.black);
 BarRenderer renderer = (BarRenderer) plot.getRenderer();
 renderer.setSeriesPaint(0, Color.YELLOW);
 renderer.setSeriesPaint(1, Color.red);
    
return Grafica1;
}
}