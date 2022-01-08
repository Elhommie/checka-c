/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checka;

import java.awt.Color;
import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author DC45-61
 */
public class FormatoTabla extends DefaultTableCellRenderer{    
    Font normal = new Font( "Arial",Font.PLAIN,12 );
    Font negrilla = new Font( "Helvetica",Font.BOLD,18 );
    Font cursiva = new Font( "Times new roman",Font.ITALIC,12 );

  @Override 
    public Component getTableCellRendererComponent ( JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column ) 
    {
       Color colorgr=new Color(204,204,255);
        Color colorred=new Color(255,157,157);
         Color colorama=new Color(255,255,153);

        Component componente = super.getTableCellRendererComponent (table, value, isSelected, hasFocus, row, column);
       
        
      
      
        if(String.valueOf(table.getValueAt(row,1)).contains("R -"))
        {
        componente.setBackground(colorred);
       }else if(String.valueOf(table.getValueAt(row,1)).contains("T -")){
        componente.setBackground(colorama);   
       }else if(row%2==0){
            
            componente.setBackground(Color.white); 
         }else {
            componente.setBackground(colorgr); 
         }
    
       
          
              DefaultTableCellRenderer tcr = (DefaultTableCellRenderer) table.getCellRenderer(0,0);
              tcr.setHorizontalAlignment(SwingConstants.LEFT);
        

        
       
       
       
        return componente;
 }
}

