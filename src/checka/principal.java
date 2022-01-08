/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checka;


import com.github.fedy2.weather.YahooWeatherService;
import com.github.fedy2.weather.data.Channel;
import com.github.fedy2.weather.data.unit.DegreeUnit;
import com.panamahitek.ArduinoException;
import com.panamahitek.PanamaHitek_Arduino;
import groovy.sql.InOutParameter;
import java.awt.Color;
import java.awt.Component;
import java.awt.Desktop;
import java.awt.FileDialog;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemTray;
import java.awt.TrayIcon;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableRowSorter;
import jssc.SerialPortEvent;
import jssc.SerialPortEventListener;
import jssc.SerialPortException;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import static java.nio.charset.StandardCharsets.UTF_8;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import javafx.scene.control.CheckBox;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.RowFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.TableModel;
import javax.xml.bind.JAXBException;


import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRPrintPage;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRTableModelDataSource;
import net.sf.jasperreports.view.JasperViewer;
import org.jfree.io.IOUtils;
import org.jfree.util.ObjectList;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;


/**
 *
 * @author DC45-61
 */
public final class principal extends javax.swing.JFrame implements Runnable{

    /**
     * Creates new form principal
     */
    
    final long id_software = 1992883123;
    final String tip_lic_1 = "n9abrr";
    final String tip_lic_2 = "a1zuu3";
    
    DefaultComboBoxModel modeloCombot = new DefaultComboBoxModel();
    DefaultComboBoxModel modeloComboc = new DefaultComboBoxModel();
    corte corte = new corte();
    NewClass export = new NewClass();
    PanamaHitek_Arduino ino = new PanamaHitek_Arduino();
    
    String m_rec;
    String nombre;
    String id;
    String indx;
    String idstatus;
    int ventana_solicitada;
    DateFormat hourFormat = new SimpleDateFormat("HH:mm");
    DateFormat fechaFormat = new SimpleDateFormat("yyyy/MM/dd");
    DateFormat fechaFormatextra = new SimpleDateFormat("yyyy-MM-dd");
    DateFormat fechaFormat22 = new SimpleDateFormat("dd/MM/yyyy");
    JFreeChart Grafica1;
    DefaultCategoryDataset Datos = new DefaultCategoryDataset();
    
    
    boolean pararhilo;
    boolean reinicioauto = true;
    
    Thread h1;
    String hora,minutos,segundos,ampm;
    Calendar calendario;
    Date fechahoy = new Date();
    Calendar calendarioo = new GregorianCalendar();
    boolean porcodigo;
    
    private ImageIcon imagenicon;
    private TrayIcon trayicon;
    private SystemTray systemtray;
    
    
    DefaultTableModel modelTabla;
    TableRowSorter trs;
    
    JTable jtablerespaldo = new JTable();
    
    DefaultTableModel modelTablarespaldo = new DefaultTableModel();
    
    int activo = 0;
     
    Connection Conexion;
    act_tablas act_t = new act_tablas();
    conexionBD c = new conexionBD();
    public static boolean ventanas=false;
    
   
    
    regevet log2 = new regevet();
    act_tablas1 act_t1 = new act_tablas1();
    turnoauto turna = new turnoauto();
    act_tablas_resumen tresum = new act_tablas_resumen();
    //////////////////////////////////////VARIABLES DE CONFIGURACION!!!!////////////////////////////////////////
    String url;
    String user;
    String pass;
    String port;
    String contraseña;

   ImageIcon imageIconav;
   ImageIcon dialog2ico;
    
    Update updt = new Update();
    DefaultTableModel modelosinerror = new DefaultTableModel();
    List<JCheckBox> checkboxes = new ArrayList<>();
    
    public principal()  {
      
    initComponents();
    //this.setResizable(false);
    //this.setLocation(0, 0);
    // jTabbedPane1.setEnabledAt(7, false);
    arcon();
    jTable5.setAutoCreateRowSorter(true);
   // actualizar();
    jButton88.setEnabled(false);
    jPanel54.setVisible(false);
    imagenicon = new ImageIcon(this.getClass().getResource("/ico/rehuico.png"));
    dialog2ico = new ImageIcon(this.getClass().getResource("/ico/clock.png"));
 
    jLabel25.setIcon(new javax.swing.ImageIcon(this.getClass().getResource("/ico/aviso.gif")));
    Image img= new ImageIcon("logo").getImage();
    ImageIcon img2=new ImageIcon(img.getScaledInstance(200,133, Image.SCALE_SMOOTH));
    jLabel19.setIcon(img2);
    
      
    jButton34.setVisible(false);
    jPanel4.setVisible(false);
    
    jComboBox7.setToolTipText(""
    + "<html><body><pre>"
    + "Seleccione un horario.\n Mixto mas de un horario. \n Libre si no quiere asignarle horario."
    + "</pre></body></html>");
    
       jTable5.setDefaultRenderer(Object.class, new FormatoTabla2());
       jTable1.setDefaultRenderer(Object.class, new FormatoTabla());
       jTable3.setDefaultRenderer(Object.class, new FormatoTabla());
       jTable2.setDefaultRenderer(Object.class, new FormatoTabla());
       jTable14.setDefaultRenderer(Object.class,new FormatoTabla());
       jTable12.setDefaultRenderer(Object.class,new FormatoTabla());
       jTable4.setDefaultRenderer(Object.class,new FormatoTabla());
       jTable9.setDefaultRenderer(Object.class, new FormatoTabla());
       jTable15.setDefaultRenderer(Object.class, new FormatoTabla());
       jTable8.setDefaultRenderer(Object.class, new FormatoTabla());
       jTable6.setDefaultRenderer(Object.class, new FormatoTabla3());
       jTable7.setDefaultRenderer(Object.class, new FormatoTabla());
       jTable18.setDefaultRenderer(Object.class, new FormatoTabla2());
       
       
      
       diseñotab3();
      
      
       jLabel20.setVisible(false);
       jLabel22.setVisible(false);
       jLabel23.setVisible(false);
       jLabel24.setVisible(false);
       
       Calendar calendar = Calendar.getInstance();
       calendar.setTime(fechahoy);
       calendar.add(Calendar.DAY_OF_MONTH, -6);
       jda.setCalendar(calendarioo);
       
       jdde.setCalendar(calendar);
       jdde2.setCalendar(calendar);
       

       
      
     this.setIconImage(imagenicon.getImage());
     
//JOptionPane.showMessageDialog(null, "Entr carga propi");
        carga_propiedades();
       // JOptionPane.showMessageDialog(null, "sale carga propi");
//        try {
//            Conexion = DriverManager.getConnection(c.getUrl(), c.getUser(),null);
//                    
//        } catch (SQLException e) {
//            log2.wlog("ERROR INTENTANDO CONECTAR CON LA BASE DE DATOS");
//           JOptionPane.showMessageDialog(null,"error "+c.getUrl()+ c.getUser()+c.getPassbd());
//        }
        
        conectarbd();
       // jButton15.setEnabled(false);
       
        
       
        
        
        act_tabla();
        //JOptionPane.showMessageDialog(null, "act_taab");
        actualizart_turnos();
        //JOptionPane.showMessageDialog(null, "actualizar_tur");
        actualizart_registro();
       // JOptionPane.showMessageDialog(null, "actualizar_reg");
        actualizart_personal();
       // JOptionPane.showMessageDialog(null, "actualizar_pers");
        actualizart_permisos();
      // lllllllllllllllllllllllllllllllllllllllll
        actualizart_conceptosnomi();
        actualizart_automi();
       // lllllllllllllllllllllllllllllllllllllllll   
        actualizart_cotizaciones();
        
        
       inicializarcombofechas();
       actualizart_faltas();
       iniciarnominas();
       cargarconfig();
       
       h1 = new Thread((Runnable) this);
       h1.start();
       
        try {
            ino.sendData("3");         
            // jtablerespaldo.setModel(modelTablarespaldo=(DefaultTableModel) jTable5.getModel());
            //actualizar();
            // graficar();
        } catch (ArduinoException ex) {
            Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SerialPortException ex) {
            Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        corte.fechacorte();
    }
    public void cargar_sd(){
        try {
            ino.sendData("3");
        } catch (ArduinoException | SerialPortException ex) {
            Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public void actualizart_conceptosnomi(){
        String sqlcorreccion = "SELECT CVE,concepto,perded,metodo,valor FROM conceptosnomi ";
        String columnassqlcorreccion[]= {"CVE","CONCEPTO","PER/DED","METODO","VALOR"};
            
        act_t.actualizar(jTable11, sqlcorreccion, 5, columnassqlcorreccion );
    }
    public void actualizart_automi(){
        String sqlcorreccion = "SELECT indx,generar,personas,dias,hora,directorio FROM automi ";
        String columnassqlcorreccion[]= {"Index","GENERAR","PERSONAS","DIAS","HORA","DIRECTORIO"};
            
        act_t.actualizar(jTable19, sqlcorreccion, 6, columnassqlcorreccion );
    }
    
    public void actualizart_cotizaciones(){
        
        String sqlcorreccion = "SELECT CVE,nombre,dias,tarifa,total,percepcion,deduccion FROM cotizacion ";
        String columnassqlcorreccion[]= {"CVE","Nombre","Dias","Tarifa","Total","Percepciones Valor*Cant=Total","Deducciones Valor*Cant=Total"};
            
        act_t.actualizar(jTable12, sqlcorreccion, 7, columnassqlcorreccion );
        
        Object datos = "" ;
        String entraf="";
        String salif="";
        
        int indexbuf=0;
        int cc=0;
        int cc2=0;
        
        for(int w=0;w<jTable12.getRowCount();w++){  
        entraf = String.valueOf(jTable12.getValueAt(w,5));
        salif="<html> ";            
        while(entraf.contains("|")){         
            entraf = entraf.substring( entraf.indexOf("|")+1);    
            cc++;           
            if(entraf.indexOf("|")==-1){
                salif+=entraf.substring(0)+"</html>";  
            }else{
                salif+=entraf.substring(0,entraf.indexOf("|"))+" <br>";
            }
        } 
        jTable12.setValueAt(salif, w, 4);        
        if(cc==0){
            jTable12.setRowHeight(w,18);
        }else{
            jTable12.setRowHeight(w,cc*18);
        }      
        cc=0;
                }
        
        
        for(int w=0;w<jTable12.getRowCount();w++){  
        entraf = String.valueOf(jTable12.getValueAt(w,6));
        salif="<html> ";            
        while(entraf.contains("|")){         
            entraf = entraf.substring( entraf.indexOf("|")+1);    
            cc++;           
            if(entraf.indexOf("|")==-1){
                salif+=entraf.substring(0)+"</html>";  
            }else{
                salif+=entraf.substring(0,entraf.indexOf("|"))+" <br>";
            }
        } 
        jTable12.setValueAt(salif, w, 5);        
        
        if(jTable12.getRowHeight(w)<cc*18){
            
             if(cc==0){
            jTable12.setRowHeight(w,18);
        }else{
            jTable12.setRowHeight(w,cc*18);
        }     
            
        }
        
         cc=0;
                }
        
        
        
      
    }
    
    private void actualizar(){
        
         int disp = updt.buscar();
         
   
    }
private void cargarconfig(){
       int column=12;
         Object datos[]= new Object[column];
    try {
       String sql = "SELECT nombre,rfc,callenum, entrecalle,colonia,poblacion,municipio,telefono1, telefono2, estado, email,web FROM empresa where indx = '1'";

          
            
            Statement us;
            
            us = Conexion.createStatement();
            ResultSet res = us.executeQuery(sql);
            
          
            int x=0;
            while(res.next()&&x<100){
                x++;
                for(int i=0; i<column;i++){
                    datos[i]= res.getObject(i+1);
                   // System.out.println(res.getObject(i+1));
                    
                }
            
            }
            us.close();
        } catch (SQLException ex) {
            Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
            log2.wlog("Cargar configuracion() " +ex.getMessage());
            
        }
       jTextField14.setText(String.valueOf(datos[0]));
       jTextField15.setText(String.valueOf(datos[1]));
       jTextField16.setText(String.valueOf(datos[2]));
       jTextField17.setText(String.valueOf(datos[3]));
       jTextField19.setText(String.valueOf(datos[4]));
       jTextField18.setText(String.valueOf(datos[5]));
       jTextField20.setText(String.valueOf(datos[6]));
       jTextField22.setText(String.valueOf(datos[7]));
       jTextField23.setText(String.valueOf(datos[8]));
       jTextField21.setText(String.valueOf(datos[9]));
       jTextField24.setText(String.valueOf(datos[10]));
       jTextField25.setText(String.valueOf(datos[11]));
     ///////////////////////////////////////////////////////77asistencias///////////////////////////////77
     c.cargar();
     jFormattedTextField11.setText(c.getRetardos());
     jFormattedTextField10.setText(c.tiempotolerancia);
    
}

private void iniciarnominas(){
    DefaultComboBoxModel modeloCombottt = new DefaultComboBoxModel();

    int roww = jTable3.getRowCount() ;

    for(int x=0;x<roww;x++){
       
        modeloCombottt.addElement(jTable3.getValueAt(x,1));
        
        
    }  
    
    jComboBox15.setModel(modeloCombottt);
    
//    jDateChooser2.setDate(new Date());
   // jDateChooser1.setDate(new Date());
  
}    
    
private void actualizart_permisos(){
    
    
   String fecha1 = fechaFormat.format(jdde1.getDate());
   String fecha2 = fechaFormat.format(jda1.getDate());
    //BETWEEN '"+fecha1+"' and '"+fecha2+"'
    String sqlcorreccion = "SELECT * FROM permisos where '"+fechaFormat.format(fechahoy)+"' BETWEEN fecha_inicio and fecha_final order by indx DESC";
    String columnassqlcorreccion[]= {"Folio","Fecha inicio","Fecha final","Hora","Aplica a","Tipo","Motivo","Autorizado"};
            
    act_t.actualizar(jTable4, sqlcorreccion, 8, columnassqlcorreccion );
    
     diseñotab6();
}
graficas graf = new graficas();
public void graficar(){
String fecha1 = fechaFormat.format(jdde2.getDate());
String fecha2 = fechaFormat.format(jda2.getDate());

ChartPanel Panel = new ChartPanel(graf.estadis(jTable1,jTable3,fecha1,fecha2));
//jPanel11.setLayout(new java.awt.FlowLayout());
jPanel11.add(Panel);

jPanel11.validate();
}
private void instanciarTray(){
    trayicon = new TrayIcon(imagenicon.getImage(),"Tolki del icono",popupMenu1);
    trayicon.setImageAutoSize(true);
    systemtray = SystemTray.getSystemTray();
    


} 

public  Connection conectarbd(){
    
            
        try {
            String barra = File.separator;
            String proyecto = System.getProperty("user.dir")+barra+"rehu";
            File af = new File(proyecto);
            String db= "jdbc:sqlite:"+proyecto;
            
            if(af.exists()){
                Conexion  = DriverManager.getConnection(db);
               
            }else{
                JOptionPane.showMessageDialog(null, "No existe Base de Datos \n Aceptar para crearla");
                Conexion  = DriverManager.getConnection(db);
                
                 Statement uss = Conexion.createStatement();
            
                
                uss.execute("CREATE TABLE `config` (\n" +
"  `nombre` varchar(15) NOT NULL,\n" +
"  `valor` varchar(15) NOT NULL,\n" +
"  `reg` varchar(15) NOT NULL\n" +
")");
                uss.execute(
"CREATE TABLE `permisos` (\n" +
"  `indx` INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
"  `fecha_inicio` varchar(15) DEFAULT NULL,\n" +
"  `fecha_final` varchar(15) DEFAULT NULL,\n" +
"  `Hora` varchar(50) DEFAULT NULL,\n" +
"  `aplica_a` varchar(100) DEFAULT NULL,\n" +
"  `tipo` varchar(50) DEFAULT NULL,\n" +
"  `motivo` varchar(250) DEFAULT NULL,\n" +
"  `autorizado` varchar(5) DEFAULT NULL\n" +
")");

uss.execute(                
"CREATE TABLE `personal` (	\n" +
"  `indx` INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
"  `codigo` int(11) DEFAULT NULL,\n" +
"  `nombre` varchar(90) NOT NULL,\n" +
"  `domicilio` varchar(90) DEFAULT NULL,\n" +
"  `telcel` varchar(15) DEFAULT NULL,\n" +
"  `telca` varchar(15) DEFAULT NULL,\n" +
"  `turno` varchar(60) DEFAULT NULL\n" +
")");
uss.execute(
"CREATE TABLE `registro` (\n" +
"  `indx` INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
"  `codigo` varchar(10) NOT NULL,\n" +
"  `personal` varchar(90) NOT NULL,\n" +
"  `entrada` varchar(10) NOT NULL,\n" +
"  `c_entrada` varchar(10) NOT NULL,\n" +
"  `c_salida` varchar(10) NOT NULL,\n" +
"  `salida` varchar(10) NOT NULL,\n" +
"  `fecha` varchar(10) NOT NULL,\n" +
"  `opt` varchar(1) NOT NULL,\n" +
"  `turnoreg` varchar(60) DEFAULT NULL\n" +
") ");

uss.execute(
"CREATE TABLE `turnos` (\n" +
"  `nombre` varchar(10) NOT NULL,\n" +
"  `entrada` varchar(10) NOT NULL,\n" +
"  `tiempo_comida` varchar(10) NOT NULL,\n" +
"  `salida` varchar(10) NOT NULL,\n" +
"  `indx` INTEGER PRIMARY KEY AUTOINCREMENT\n" +
") ");


                
                
            }
            
            
            
            
            
           
            return Conexion  ;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
            log2.wlog("Crear tablas" +ex.getMessage());
            Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
        }
               
      return null;        
}



int timerc=0;
int regre=200;
boolean mensajew=false;

int climacont=1800;
int count5=0;
boolean para=true;
    public void run(){
  Thread ct = Thread.currentThread();
  
  while(ct == h1) {   
      try {
          Thread.sleep(1000);
          
      } catch (InterruptedException ex) {
          log2.wlog("ERROR GRAVE HILO DEL RELOJ "+ ex.getMessage());
        
          System.exit(0);
          Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
      }

  if(climacont==1800){
      consultarurl();
      climacont=0;
  }else{
      climacont++;
  }
  
  
  if(para&&aux!=0){
  if(jProgressBar1.getValue()>=fracc){
      para=false;
      jButton88.setEnabled(true);
      jProgressBar1.setEnabled(false);
      jLabel26.setText("");
      jProgressBar1.setVisible(false);
      _2cargar(true);
  }
  }
  
  
  
  Date gg = new Date();
  lbHora.setText(hourFormat.format(gg));
  fechalabel.setText(fechaFormat22.format(fechahoy));
 
  }
    }
    
    public void automi(){
        
      
       
    }
    public void buscarpuerto(){
 
        try {
            
            Process p = Runtime.getRuntime().exec ("rest.bat");
            System.exit(0);
            
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null,"Problemas al intentar reiniciar");
            log2.wlog("Buscarpuerto " +ex.getMessage());
            Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
            
        }
         
          
        
         }
    
    
    
    public void arcon() {
        
        ArrayList<String> puertocargado = new ArrayList<String>();
     
        
        if(ino.getPortsAvailable()!=0){
            
          puertocargado = (ArrayList<String>) ino.getSerialPorts();
          jComboBox8.removeAllItems();
          for(int c=0;c<puertocargado.size();c++){
          jComboBox8.addItem(puertocargado.get(c));
          }
          
        }
        c.cargar();
      
        
        try {
          //Se inicia la comunicaciï¿½n con el Puerto Serie
           if(c.getPort().equals("auto")){
           ino.arduinoRXTX(puertocargado.get(0), 9600,listener);
           ino.setByteSize(8);
           activo=1;
           }else{
           ino.arduinoRXTX(c.getPort(), 9600,listener);
           ino.setByteSize(8);
           activo=1;
           }
        } catch (ArduinoException ex) {
            
           activo=0;
           jLabel26.setForeground(Color.red);
           jLabel26.setFont(new Font ("Serif", Font.BOLD, 16));
           jLabel26.setText("SIN CONEXION CON EL CHECADOR SOLO MANUAL");
           
           log2.wlog("ERROR EN CONECTAR CON ARDUINO "+ex.getMessage());
        
        }
           
    }
    int conti;
    long sizetemp=0;
    long fracc=0;
    long aux=0;     
    boolean vamos = true;
    public SerialPortEventListener listener = new SerialPortEventListener() {
        public void serialEvent(SerialPortEvent spe ) {
           try {
                 
                if (ino.isMessageAvailable()) {                  
                    m_rec = ino.printMessage();
                    String mensaje = m_rec;
                    jTextPane1.setText(jTextPane1.getText()+"\n"+m_rec);
                 // System.out.println(m_rec);
                    
                    
                    
                    boolean hg = mensaje.contains("LA GUAR");
                    boolean rd = mensaje.contains("ove fin");
                    boolean pd = mensaje.contains("ame fin");
                    boolean nmtch = mensaje.contains("did not mat");
                    boolean damehoora = mensaje.contains("damehora");
                    boolean tamano = mensaje.contains("+");
                    boolean carga_SD = mensaje.contains("%");
               
//                    if(vamos&&carga_SD){
//                       
//                    }else{
//                        System.out.println("Se ejecuto el corte al no aver archivo");
//                        corte.fechacorte();
//                        vamos=false;
//                    }
                    
                    if(tamano){
                         System.out.println(mensaje);
                        try {
                            jLabel26.setText("CARGANDO DATOS DEL CHECADOR");
                            aux=0;
                            sizetemp=Long.parseLong(mensaje.substring(1));
                            fracc=(sizetemp/25);
                            jProgressBar1.setMaximum((int)fracc);   
                            System.out.println("El tamaño es ");
                            System.out.println(fracc);
                        } catch (Exception e) {
                            System.out.println("erroral recibir tamaño");
                        }
                    }
                    if(carga_SD){
                        try{
                        aux+=1;
                        
                        System.out.println("Aux = "+aux);
                        jProgressBar1.setValue((int)aux);
                        FileWriter writer = new FileWriter("MyFile.txt", true);
                        writer.write(m_rec+"\n");                        
                        writer.close();
                        
                        }catch (IOException ex) {
                            Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    
                    if(damehoora){
                        jTextPane1.setText("");
                        mensajew= true;
                        activo=1;
                        mandarhora();
                    }
                    
                    if(hg){
                        jLhuella.setIcon(imgregristro(2));
                        
                        jLabel46.setForeground(Color.green);
                        jLabel46.setFont(new Font ("Serif", Font.BOLD, 16));
                        jLabel46.setText("HUELLA CAPTURADA");
                        jButton25.setEnabled(false);
                        jButton26.setEnabled(true);
                        jButton27.setEnabled(true);
                  
                    }
                    if(rd){
                        
                        jLabel46.setText("RETIRAR DEDO");
                        jLhuella.setIcon(imgregristro(1));
                        jLhuella.repaint();
                    }
                    if(pd){
                        jLabel46.setText("COLOCAR DEDO NUEVAMENTE");
                        jLhuella.setIcon(imgregristro(4));
                        jLhuella.repaint();
                    }
                    if(nmtch){
                        conti++;
                        jLhuella.setIcon(imgregristro(3));
                        jLhuella.repaint();
                        jLabel46.setForeground(Color.red);
                        jLabel46.setFont(new Font ("Serif", Font.BOLD, 16));
                        jLabel46.setText("HUELLA NO CAPTURADA REINTENTAR");
                        jButton26.setEnabled(true);
                        jButton27.setEnabled(true);
                        if(conti>=4){
                            jLabel46.setFont(new Font ("Serif", Font.BOLD, 12));
                            jLabel46.setText("HUELLA NO CAPTURADA MAXIMO DE INTENTOS");
                            jButton25.setEnabled(false);
                        }
                        
                    }
                    
                analiz();
                
                }
                
            } catch (SerialPortException | ArduinoException ex) {
                
                 JOptionPane.showMessageDialog(null, "herror listen com");
                 log2.wlog("ERROR AL RECIVIR COMUNICACION DE ARDUINO");
                 log2.wlog("ERROR SERIALEVENT "+ex.getMessage());
                 Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
                 
            }
            
            
        }
    };
    
   
    
        
    public void mandarhora(){
        
        try {
            ino.sendData("1-| El CALDERO |--|    "+lbHora.getText()+"   |-");
        } catch (ArduinoException | SerialPortException ex) {
            log2.wlog("ERROR AL MANDAR HORA AL ARDUINO "+ex.getMessage());
            Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void analiz(){
       
      
        porcodigo = m_rec.contains("kk");
       
        if(m_rec.contains("Encontrado")){
         System.out.println(m_rec);
        if(m_rec.length()>16){
        id = m_rec.substring(15,17);
        }else{
        id = m_rec.substring(15,16);
        }
        jLabel20.setText("El id es "+id);
        int idbuf = Integer.parseInt(id.trim());
        id = Integer.toString(idbuf);
        
        log2.wlog("ID captado="+id);
       ////////////////////////////////////////////////////////////////////////////////////////////////////////////// 
        try {
            
            String sql="Select nombre from personal where codigo = "+id;
            PreparedStatement us = Conexion.prepareStatement(sql);   
            ResultSet res = us.executeQuery();
            
            
            if(res.next()){
            jLabel22.setText(String.valueOf(res.getObject(1)));
            nombre = String.valueOf(res.getObject(1));
                
            validas(); 
            
            
            }else{
                try {
                    ino.sendData("#     CODIGO      NO ENCONTRADO");
                    
                } catch (ArduinoException | SerialPortException ex) {
                    Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
                    log2.wlog("ERROR ANALIZ "+ex.getMessage());
                }
            }
            us.close();
           
        } catch (SQLException ex) {
            
            log2.wlog("ERROR AL CONSULTAR NOMBRE DEL ID = "+id+" "+ex.getMessage());
               Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
        }
   
        }
        
    }
    public void ob_nombre(){
        
        try {
            
            //JOptionPane.showMessageDialog(null, id);
            String sql="Select nombre from personal where codigo = "+id;
            PreparedStatement us = Conexion.prepareStatement(sql);   
            ResultSet res = us.executeQuery();
            
            
            if(res.next()){
            jLabel22.setText(String.valueOf(res.getObject(1)));
            nombre = String.valueOf(res.getObject(1));
                
            validas(); 
            }else{
                try {
                    ino.sendData("#     CODIGO      NO ENCONTRADO");
                    
                } catch (ArduinoException | SerialPortException ex) {
                    Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            us.close();
           
        } catch (SQLException ex) {
            
            log2.wlog("ERROR AL CONSULTAR NOMBRE DEL ID = "+id);
               Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void validas(){
       
        try {
       
            String extracOpt= "SELECT opt from registro where codigo = '"+id+"' ORDER BY indx DESC";
            String extracIndx = "SELECT indx from registro where codigo = '"+id+"' ORDER BY indx DESC";
      
            PreparedStatement us1 = Conexion.prepareStatement(extracIndx);
            ResultSet res1 = us1.executeQuery();
            
           // JOptionPane.showMessageDialog(null, "Primer if");
            
            if(res1.next()){
                indx = String.valueOf(res1.getObject(1));
            }
           //JOptionPane.showMessageDialog(null, "segundo if");
           
            PreparedStatement us2 = Conexion.prepareStatement(extracOpt);
            ResultSet res2 = us2.executeQuery();
            
            String buferprueba = consultarpermisos();
            
            if(res2.next()){               
                
               idstatus = String.valueOf(res2.getObject(1));
               jLabel23.setText(idstatus);
               
               if(consultarpermisos()!=null){
                   regs2(buferprueba);
                   //JOptionPane.showMessageDialog(null, "Se ejecuto regs 2 "+buferprueba);
               }else{
                   regs();
               }
               
               
               
               
                }else{
               
                idstatus = "0";
                regs();
                if(consultarpermisos()!=null){
                   regs2(buferprueba);
                   JOptionPane.showMessageDialog(null, "Se ejecuto regs 2 "+buferprueba);
                }else{
                   regs();
                }
                
                }
            
            
        


        } catch (SQLException ex) {
            log2.wlog("ERROR AL CONSULTAR ESTADO Y INDEX DEL ID = "+id);
               Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void regs(){
        pararhilo=false;
        Date date = new Date();
        int opt = Integer.parseInt(idstatus);
        String tt = "Libre";
//        
//          try {
       
        for(int x=0;x<jTable3.getRowCount();x++){   
            //System.out.println(id+"entrofor"+jTable3.getModel().getValueAt(x,0));
            
            int ide = Integer.parseInt(id.replace(" ",""));
            int comp = Integer.parseInt(String.valueOf(jTable3.getModel().getValueAt(x, 0)));

            if(ide==comp){
                
                tt=String.valueOf(jTable3.getModel().getValueAt(x, 5));
            }else{
                
            }
            
        }
        
        log2.wlog("brinco if no encontro turno por codigo, Valor id="+id);
//         } catch (Exception e) {
//             log2.wlog("Error buscando turno = "+e);
//        }
             log2.wlog("turno encontrado = "+tt+" Id consultado = "+id);
        String[] arry = registrarretados();
        String reoto = arry[0];
        tt= arry[1];
             
        
        String sqlentradalibre= "INSERT INTO registro (codigo,personal,entrada,c_entrada,c_salida,salida,fecha,opt,turnoreg)VALUES ('"+id+"','"+jLabel22.getText()+"','"+hourFormat.format(date)+"','----','----','----','"+fechaFormat.format(date)+"','3','"+tt+"')";
        String sqlentrada= "INSERT INTO registro (codigo,personal,entrada,c_entrada,c_salida,salida,fecha,opt,turnoreg)VALUES ('"+id+"','"+jLabel22.getText()+"','"+reoto+hourFormat.format(date)+"','----','----','----','"+fechaFormat.format(date)+"','1','"+tt+"')";
        String sqlecomida= "UPDATE registro SET c_entrada = '"+hourFormat.format(date)+"', opt = '2' where registro.indx = '"+indx+"'";
        String sqlscomida= "UPDATE registro SET c_salida = '"+hourFormat.format(date)+"', opt = '3' where registro.indx = '"+indx+"'";
        String sqlsalida= "UPDATE registro SET salida = '"+hourFormat.format(date)+"', opt = '0' where registro.indx = '"+indx+"'";
       // System.out.println("rdyr  "+porcodigo);
        if(porcodigo){
            try {
                String porcod= "INSERT INTO permisos (fecha_inicio,fecha_final,hora,aplica_a,tipo,motivo,autorizado)VALUES ('"+fechaFormat.format(date)+"','"+fechaFormat.format(date)+"','"+hourFormat.format(date)+"','"+jLabel22.getText()+"','Checada Con Codigo','Con Codigo','No')";
                PreparedStatement us = Conexion.prepareStatement(porcod);
                us.executeUpdate();      
                porcodigo=false;
               us.close();
            } catch (SQLException ex) {
                Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        switch (opt){
            
                case 0:{
                    
                    
                    
                    
                    if("Libre".equals(tt)){                        
                        try {
                            PreparedStatement us = Conexion.prepareStatement(sqlentradalibre);
                            us.execute();
                            
                            // trayicon.displayMessage("ENTRADA "+hourFormat.format(date), nombre, TrayIcon.MessageType.INFO);
                            
                            try {
                                
                                ino.sendData("*ENTRADA    "+hourFormat.format(date)+nombre);
                                
                            } catch (ArduinoException | SerialPortException ex) {
                                Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            
                        } catch (SQLException ex) {
                            Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
                            
                        }
                        
                    }else{
                        try {
                            PreparedStatement us = Conexion.prepareStatement(sqlentrada);
                            us.execute();
                            //  trayicon.displayMessage("ENTRADA "+hourFormat.format(date), nombre, TrayIcon.MessageType.INFO);
                            
                            try {
                                
                                ino.sendData("*ENTRADA    "+hourFormat.format(date)+nombre);
                                
                            } catch (ArduinoException | SerialPortException ex) {
                                Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            us.close();
                        } catch (SQLException ex) {
                            Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        
                        
                        
                        
                    }
                    act_tabla();
                    break;
                }
                
                case 1:{
                    

                    
//                    boolean sepu = turna.salidasincomer(id , hourFormat.format(date));
//                    boolean sapu = turna.salirsalida(id, hourFormat.format(date));
//                    
//                    System.out.println(sepu);
//                    System.out.println(sapu);
//                    
//                    if(sepu&&sapu){
                    try {
                        PreparedStatement us = Conexion.prepareStatement(sqlecomida);
                        us.executeUpdate();
                        try {
                            ino.sendData("*EN.COMIDA  "+hourFormat.format(date)+nombre);
                            
                        } catch (ArduinoException | SerialPortException ex) {
                              Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
                        }
                     
                    } catch (SQLException ex) {
                          Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    
//                    }else{
//                         try {
//                        PreparedStatement us = Conexion.prepareStatement(sqlsalida);
//                        us.executeUpdate();
//                        try {
//                            ino.sendData("*SALIDA     "+hourFormat.format(date)+nombre);
//                            
//                        } catch (ArduinoException | SerialPortException ex) {
//                              Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
//                        }
//                    } catch (SQLException ex) {
//                          Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
//                        }
//                        
                        
//                    }
         
                    act_tabla();
                    break;
                    
                }
                case 2:{
                    
//                    boolean sapu = turna.salirsalida(id, hourFormat.format(date));
//                    if(sapu){
//  
//                    }else{
//                        
//                        
//                        try {
//                        PreparedStatement us = Conexion.prepareStatement(sqlsalida);
//                        us.executeUpdate();
//                        try {
//                            ino.sendData("*SALIDA     "+hourFormat.format(date)+nombre);
//                          
//                        } catch (ArduinoException | SerialPortException ex) {
//                              Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
//                        }
//                    } catch (SQLException ex) {
//                          Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
//                        }
//                        
//                        
//                    }
                    
                    try {
                        
                        PreparedStatement us = Conexion.prepareStatement(sqlscomida);
                        us.execute();
                        try {
                            ino.sendData("*SA.COMIDA  "+hourFormat.format(date)+nombre);
                          
                        } catch (ArduinoException | SerialPortException ex) {
                              Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        
                    } catch (SQLException ex) {
                         Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    
                    
                    act_tabla();
                    break;
                    
                }
                case 3:{
                    
                  
                    String sqlsalida_de_cys = "UPDATE registro SET salida = '"+hourFormat.format(date)+"', c_salida = '' , opt = '0' where registro.indx = '"+indx+"'";
                    
                    
                    try {
                        PreparedStatement us = Conexion.prepareStatement(sqlsalida);
                        us.executeUpdate();
                        //trayicon.displayMessage("SALIDA "+hourFormat.format(date), nombre, TrayIcon.MessageType.INFO);
                        try {
                            ino.sendData("*SALIDA     "+hourFormat.format(date)+nombre);
                           
                        } catch (ArduinoException | SerialPortException ex) {
                               Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
                        }
                     
                    } catch (SQLException ex) {
                          Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    act_tabla();
                    break;
                    
                }
               

        }
    actualizart_permisos();
    }
    public void regs2(String dobleturno){
        pararhilo=false;
        Date date = new Date();
        int opt = Integer.parseInt(idstatus);
        String tt = "Libre";


        String[] arry = registrarretados2(dobleturno);
        
        String reoto = arry[0];
        tt= arry[1];
             
        
        String sqlentradalibre= "INSERT INTO registro (codigo,personal,entrada,c_entrada,c_salida,salida,fecha,opt,turnoreg)VALUES ('"+id+"','"+jLabel22.getText()+"','"+hourFormat.format(date)+"','----','----','----','"+fechaFormat.format(date)+"','3','"+tt+"')";
        String sqlentrada= "INSERT INTO registro (codigo,personal,entrada,c_entrada,c_salida,salida,fecha,opt,turnoreg)VALUES ('"+id+"','"+jLabel22.getText()+"','"+reoto+hourFormat.format(date)+"','----','----','----','"+fechaFormat.format(date)+"','1','"+tt+"')";
        String sqlecomida= "UPDATE registro SET c_entrada = '"+hourFormat.format(date)+"', opt = '2' where registro.indx = '"+indx+"'";
        String sqlscomida= "UPDATE registro SET c_salida = '"+hourFormat.format(date)+"', opt = '3' where registro.indx = '"+indx+"'";
        String sqlsalida= "UPDATE registro SET salida = '"+hourFormat.format(date)+"', opt = '0' where registro.indx = '"+indx+"'";
       // System.out.println("rdyr  "+porcodigo);
        if(porcodigo){
            try {
                String porcod= "INSERT INTO permisos (fecha_inicio,fecha_final,hora,aplica_a,tipo,motivo,autorizado)VALUES ('"+fechaFormat.format(date)+"','"+fechaFormat.format(date)+"','"+hourFormat.format(date)+"','"+jLabel22.getText()+"','Checada Con Codigo','Con Codigo','No')";
                PreparedStatement us = Conexion.prepareStatement(porcod);
                us.executeUpdate();      
                porcodigo=false;
               us.close();
            } catch (SQLException ex) {
                Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        switch (opt){
            
                case 0:{
                    
                    
                    
                    
                    if("Libre".equals(tt)){                        
                        try {
                            PreparedStatement us = Conexion.prepareStatement(sqlentradalibre);
                            us.execute();
                            
                            // trayicon.displayMessage("ENTRADA "+hourFormat.format(date), nombre, TrayIcon.MessageType.INFO);
                            
                            try {
                                
                                ino.sendData("*ENTRADA    "+hourFormat.format(date)+nombre);
                                
                            } catch (ArduinoException | SerialPortException ex) {
                                Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            
                        } catch (SQLException ex) {
                            Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        
                    }else{
                        try {
                            PreparedStatement us = Conexion.prepareStatement(sqlentrada);
                            us.execute();
                            //  trayicon.displayMessage("ENTRADA "+hourFormat.format(date), nombre, TrayIcon.MessageType.INFO);
                            
                            try {
                                
                                ino.sendData("*ENTRADA    "+hourFormat.format(date)+nombre);
                                
                            } catch (ArduinoException | SerialPortException ex) {
                                Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            us.close();
                        } catch (SQLException ex) {
                            Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        
                        
                        
                        
                    }
                    act_tabla();
                    break;
                }
                
                case 1:{
                    

                    
//                    boolean sepu = turna.salidasincomer(id , hourFormat.format(date));
//                    boolean sapu = turna.salirsalida(id, hourFormat.format(date));
//                    
//                    System.out.println(sepu);
//                    System.out.println(sapu);
//                    
//                    if(sepu&&sapu){
                    try {
                        PreparedStatement us = Conexion.prepareStatement(sqlecomida);
                        us.executeUpdate();
                        try {
                            ino.sendData("*EN.COMIDA  "+hourFormat.format(date)+nombre);
                            
                        } catch (ArduinoException | SerialPortException ex) {
                              Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
                        }
                     
                    } catch (SQLException ex) {
                          Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    
//                    }else{
//                         try {
//                        PreparedStatement us = Conexion.prepareStatement(sqlsalida);
//                        us.executeUpdate();
//                        try {
//                            ino.sendData("*SALIDA     "+hourFormat.format(date)+nombre);
//                            
//                        } catch (ArduinoException | SerialPortException ex) {
//                              Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
//                        }
//                    } catch (SQLException ex) {
//                          Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
//                        }
//                        
                        
//                    }
         
                    act_tabla();
                    break;
                    
                }
                case 2:{
                    
//                    boolean sapu = turna.salirsalida(id, hourFormat.format(date));
//                    if(sapu){
//  
//                    }else{
//                        
//                        
//                        try {
//                        PreparedStatement us = Conexion.prepareStatement(sqlsalida);
//                        us.executeUpdate();
//                        try {
//                            ino.sendData("*SALIDA     "+hourFormat.format(date)+nombre);
//                          
//                        } catch (ArduinoException | SerialPortException ex) {
//                              Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
//                        }
//                    } catch (SQLException ex) {
//                          Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
//                        }
//                        
//                        
//                    }
                    
                    try {
                        
                        PreparedStatement us = Conexion.prepareStatement(sqlscomida);
                        us.execute();
                        try {
                            ino.sendData("*SA.COMIDA  "+hourFormat.format(date)+nombre);
                          
                        } catch (ArduinoException | SerialPortException ex) {
                              Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        
                    } catch (SQLException ex) {
                         Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    
                    
                    act_tabla();
                    break;
                    
                }
                case 3:{
                    
                  
                    String sqlsalida_de_cys = "UPDATE registro SET salida = '"+hourFormat.format(date)+"', c_salida = '' , opt = '0' where registro.indx = '"+indx+"'";
                    
                    
                    try {
                        PreparedStatement us = Conexion.prepareStatement(sqlsalida);
                        us.executeUpdate();
                        //trayicon.displayMessage("SALIDA "+hourFormat.format(date), nombre, TrayIcon.MessageType.INFO);
                        try {
                            ino.sendData("*SALIDA     "+hourFormat.format(date)+nombre);
                           
                        } catch (ArduinoException | SerialPortException ex) {
                               Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
                        }
                     
                    } catch (SQLException ex) {
                          Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    act_tabla();
                    break;
                    
                }
               

        }
    actualizart_permisos();
    }
    
    
    String _id;
    String _indx;
    String _nombre;
    String _hora;
    String _fecha;
    String _metodo;
    String _idstatus;
    
    public void _2cargar(boolean txt){ 
        String aux="";   
        String texto="";
        
        
    
    try{
     
   
      
   /**abrimos el archivo seleccionado*/
          
     File abre = new File("MyFile.txt");
     
     if("MyFile.txt".equals(abre.getName())){
     if(abre!=null)
   {     
       
      FileReader archivos=new FileReader(abre);
      BufferedReader lee=new BufferedReader(archivos);
      int iterador=0;
      String _fecha_anterior=" ";
      while((aux=lee.readLine())!=null)
      {
         int c = aux.indexOf("#");
         int g = aux.lastIndexOf("#");
         int cc = aux.indexOf("%");
         int gg = aux.lastIndexOf("%");
         
         _id = aux.substring(0,2).replace(" ","");
         _fecha= aux.substring(c+1,g);
         _hora= aux.substring(cc+1,gg);
       
         
          //JOptionPane.showMessageDialog(null, id22+"-"+fecha22+"-"+hora22);
         texto += ("\n"+aux.substring(0,2)+" - "+aux.substring(c+1, g)+" - "+aux.substring(cc+1,gg));
         
         
//         if(iterador==1){
//             _fecha_anterior = _fecha;
//             iterador=0;
//         }else{
//             iterador++;
//         }
          try {
            Conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
        }
          corte.es_fechacorte(_fecha,_hora);
//         if(_fecha.equals(_fecha_anterior)){
//             System.out.println("NO SE HIZO CORTE");
//         }else{
//             if(_fecha_anterior.equals(" ")){
//                 
//             }else{
//             System.out.println("Se ejecuto el codigo corte");
//             System.out.print(_fecha);
//             System.out.println(_fecha_anterior);
//             corte._fechacorte(_fecha_anterior, _fecha, _hora);
//                 
//             }
//             
//         }
         
           
         
          conectarbd();
         _ob_nombre();
        
      }
      //JOptionPane.showMessageDialog(null,"Registro Cargado ");
         lee.close();
    }
    }else{
         JOptionPane.showMessageDialog(null,"Favor abrir archivo valido");
     }    
     abre.delete();
   }
   catch(IOException ex)
   {
     JOptionPane.showMessageDialog(null,ex+"" +
           "\nNo se ha encontrado el archivo",
                 "ADVERTENCIA!!!",JOptionPane.WARNING_MESSAGE);
    }
     

    }
    public void _cargar(boolean txt){
        JFileChooser file=new JFileChooser();
        FileNameExtensionFilter filterr = new FileNameExtensionFilter("Archivo TXT","txt",".txt","TXT");
        file.setFileFilter(filterr);
        file.showOpenDialog(this);
        String aux="";   
        String texto="";
        
           
    
    try{
     
   
      
   /**abrimos el archivo seleccionado*/
     File abre = file.getSelectedFile();
    

     if("DATALOE.TXT".equals(file.getName())){
     if(abre!=null)
   {     
      FileReader archivos=new FileReader(abre);
      BufferedReader lee=new BufferedReader(archivos);
      int iterador=0;
      String _fecha_anterior=" ";
      while((aux=lee.readLine())!=null)
      {
         int c = aux.indexOf("#");
         int g = aux.lastIndexOf("#");
         int cc = aux.indexOf("%");
         int gg = aux.lastIndexOf("%");
         
         _id = aux.substring(0,2);
         _fecha= aux.substring(c+1,g);
         _hora= aux.substring(cc+1,gg);
       
         
          //JOptionPane.showMessageDialog(null, id22+"-"+fecha22+"-"+hora22);
         texto += ("\n"+aux.substring(0,2)+" - "+aux.substring(c+1, g)+" - "+aux.substring(cc+1,gg));
         
         if(iterador==1){
             _fecha_anterior = _fecha;
             iterador=0;
         }else{
             iterador++;
         }
          try {
            Conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
        }
         if(_fecha.equals(_fecha_anterior)){
             
         }else{
             if(_fecha_anterior.equals(" ")){
                 
             }else{
                 System.out.println("Se ejecuto el codigo corte");
             System.out.print(_fecha);
             System.out.println(_fecha_anterior);
             corte._fechacorte(_fecha_anterior, _fecha, _hora);
                 
             }
             
         }
         
          conectarbd();
         
         _ob_nombre();
        
      }
      JOptionPane.showMessageDialog(null,"Registro Cargado ");
         lee.close();
    }
    }else{
         JOptionPane.showMessageDialog(null,"Favor abrir archivo valido");
     }
     
   }
   catch(IOException ex)
   {
     JOptionPane.showMessageDialog(null,ex+"" +
           "\nNo se ha encontrado el archivo",
                 "ADVERTENCIA!!!",JOptionPane.WARNING_MESSAGE);
    }
     

    }
    public void _ob_nombre(){
        
        try {
            
            //JOptionPane.showMessageDialog(null, id);
            String sql="Select nombre from personal where codigo = "+_id;
            PreparedStatement us = Conexion.prepareStatement(sql);   
            ResultSet res = us.executeQuery();
            
            
            if(res.next()){
            jLabel22.setText(String.valueOf(res.getObject(1)));
            _nombre = String.valueOf(res.getObject(1));
                
            _validas(); 
            }else{
//                try {
//                    ino.sendData("#     CODIGO      NO ENCONTRADO");
//                    
//                } catch (ArduinoException | SerialPortException ex) {
//                    Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
//                }
            }
            us.close();
           
        } catch (SQLException ex) {
            
            log2.wlog("ERROR AL CONSULTAR NOMBRE DEL ID = "+id);
               Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 
    public void _validas(){
       
        try {
       
            String extracOpt= "SELECT opt from registro where codigo = '"+_id+"' ORDER BY indx DESC";
            String extracIndx = "SELECT indx from registro where codigo = '"+_id+"' ORDER BY indx DESC";
      
            PreparedStatement us1 = Conexion.prepareStatement(extracIndx);
            ResultSet res1 = us1.executeQuery();
            
           // JOptionPane.showMessageDialog(null, "Primer if");
            
            if(res1.next()){
                _indx = String.valueOf(res1.getObject(1));
            }
           //JOptionPane.showMessageDialog(null, "segundo if");
           
            PreparedStatement us2 = Conexion.prepareStatement(extracOpt);
            ResultSet res2 = us2.executeQuery();
            
            String buferprueba = _consultarpermisos();
            
            if(res2.next()){               
                
               _idstatus = String.valueOf(res2.getObject(1));
               jLabel23.setText(_idstatus);
               
               if(_consultarpermisos()!=null){
                   _regs2(buferprueba);
                   //JOptionPane.showMessageDialog(null, "Se ejecuto regs 2 "+buferprueba);
               }else{
                   _regs(_hora,_fecha,_metodo);
               }
               
               
               
               
                }else{
               
                _idstatus = "0";
                   _regs(_hora,_fecha,_metodo);
                if(_consultarpermisos()!=null){
                   _regs2(buferprueba);
                   JOptionPane.showMessageDialog(null, "Se ejecuto regs 2 "+buferprueba);
                }else{
                   _regs(_hora,_fecha,_metodo);
                }
                
                }
            
            
        


        } catch (SQLException ex) {
            log2.wlog("ERROR AL CONSULTAR ESTADO Y INDEX DEL ID = "+id);
               Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void _regs(String horaqq,String fechaqq,String metodoqq){
        pararhilo=false;
        Date date = new Date();
       
        int opt = Integer.parseInt(_idstatus);
        String tt = "Libre";
//        
//          try {
       
        for(int x=0;x<jTable3.getRowCount();x++){   
            //System.out.println(id+"entrofor"+jTable3.getModel().getValueAt(x,0));
            
            int ide = Integer.parseInt(_id.replace(" ",""));
            int comp = Integer.parseInt(String.valueOf(jTable3.getModel().getValueAt(x, 0)));

            if(ide==comp){
                
                tt=String.valueOf(jTable3.getModel().getValueAt(x, 5));
            }else{
                
            }
            
        }
        
        log2.wlog("brinco if no encontro turno por codigo, Valor id="+_id);
//         } catch (Exception e) {
//             log2.wlog("Error buscando turno = "+e);
//        }
             log2.wlog("turno encontrado = "+tt+" Id consultado = "+_id);
        String[] arry = _registrarretados();
        String reoto = arry[0];
        tt= arry[1];
             
        
        String sqlentradalibre= "INSERT INTO registro (codigo,personal,entrada,c_entrada,c_salida,salida,fecha,opt,turnoreg)VALUES ('"+_id+"','"+jLabel22.getText()+"','"+_hora+"','----','----','----','"+_fecha+"','3','"+tt+"')";
        String sqlentrada= "INSERT INTO registro (codigo,personal,entrada,c_entrada,c_salida,salida,fecha,opt,turnoreg)VALUES ('"+_id+"','"+jLabel22.getText()+"','"+reoto+_hora+"','----','----','----','"+_fecha+"','1','"+tt+"')";
        String sqlecomida= "UPDATE registro SET c_entrada = '"+_hora+"', opt = '2' where registro.indx = '"+_indx+"'";
        String sqlscomida= "UPDATE registro SET c_salida = '"+_hora+"', opt = '3' where registro.indx = '"+_indx+"'";
        String sqlsalida= "UPDATE registro SET salida = '"+_hora+"', opt = '0' where registro.indx = '"+_indx+"'";
       // System.out.println("rdyr  "+porcodigo);
        if(porcodigo){
            try {
                String porcod= "INSERT INTO permisos (fecha_inicio,fecha_final,hora,aplica_a,tipo,motivo,autorizado)VALUES ('"+_fecha+"','"+_fecha+"','"+_hora+"','"+jLabel22.getText()+"','Checada Con Codigo','Con Codigo','No')";
                PreparedStatement us = Conexion.prepareStatement(porcod);
                us.executeUpdate();      
                porcodigo=false;
                us.close();
            } catch (SQLException ex) {
                Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        switch (opt){
            
                case 0:{
                    
                    
                    
                    
                    if("Libre".equals(tt)){                        
                        try {
                            PreparedStatement us = Conexion.prepareStatement(sqlentradalibre);
                            us.execute();
                            us.close();
                            // trayicon.displayMessage("ENTRADA "+hourFormat.format(date), nombre, TrayIcon.MessageType.INFO);
                            
                       
                            
                        } catch (SQLException ex) {
                            Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
                            
                        }
                        
                    }else{
                        try {
                            PreparedStatement us = Conexion.prepareStatement(sqlentrada);
                            us.execute();
                            //  trayicon.displayMessage("ENTRADA "+hourFormat.format(date), nombre, TrayIcon.MessageType.INFO);
                            
                           
                            us.close();
                        } catch (SQLException ex) {
                            Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        
                        
                        
                        
                    }
                    act_tabla();
                    break;
                }
                
                case 1:{
                    

                    
//                    boolean sepu = turna.salidasincomer(id , hourFormat.format(date));
//                    boolean sapu = turna.salirsalida(id, hourFormat.format(date));
//                    
//                    System.out.println(sepu);
//                    System.out.println(sapu);
//                    
//                    if(sepu&&sapu){
                    try {
                        PreparedStatement us = Conexion.prepareStatement(sqlecomida);
                        us.executeUpdate();
                        us.close();
                     
                    } catch (SQLException ex) {
                          Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    
//                    }else{
//                         try {
//                        PreparedStatement us = Conexion.prepareStatement(sqlsalida);
//                        us.executeUpdate();
//                        try {
//                            ino.sendData("*SALIDA     "+hourFormat.format(date)+nombre);
//                            
//                        } catch (ArduinoException | SerialPortException ex) {
//                              Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
//                        }
//                    } catch (SQLException ex) {
//                          Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
//                        }
//                        
                        
//                    }
         
                    act_tabla();
                    break;
                    
                }
                case 2:{
                    
//                    boolean sapu = turna.salirsalida(id, hourFormat.format(date));
//                    if(sapu){
//  
//                    }else{
//                        
//                        
//                        try {
//                        PreparedStatement us = Conexion.prepareStatement(sqlsalida);
//                        us.executeUpdate();
//                        try {
//                            ino.sendData("*SALIDA     "+hourFormat.format(date)+nombre);
//                          
//                        } catch (ArduinoException | SerialPortException ex) {
//                              Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
//                        }
//                    } catch (SQLException ex) {
//                          Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
//                        }
//                        
//                        
//                    }
                    
                    try {
                        
                        PreparedStatement us = Conexion.prepareStatement(sqlscomida);
                        us.execute();
                        us.close();
                        
                    } catch (SQLException ex) {
                         Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    
                    
                    act_tabla();
                    break;
                    
                }
                case 3:{
                    
                  
                    String sqlsalida_de_cys = "UPDATE registro SET salida = '"+hourFormat.format(date)+"', c_salida = '' , opt = '0' where registro.indx = '"+indx+"'";
                    
                    
                    try {
                        PreparedStatement us = Conexion.prepareStatement(sqlsalida);
                        us.executeUpdate();
                        //trayicon.displayMessage("SALIDA "+hourFormat.format(date), nombre, TrayIcon.MessageType.INFO);
                        us.close();
                     
                    } catch (SQLException ex) {
                          Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    act_tabla();
                    break;
                    
                }
               

        }
    actualizart_permisos();
    }
    public void _regs2(String dobleturno){
        pararhilo=false;
        Date date = new Date();
        int opt = Integer.parseInt(_idstatus);
        String tt = "Libre";


        String[] arry = registrarretados2(dobleturno);
        
        String reoto = arry[0];
        tt= arry[1];
             
        
        String sqlentradalibre= "INSERT INTO registro (codigo,personal,entrada,c_entrada,c_salida,salida,fecha,opt,turnoreg)VALUES ('"+_id+"','"+jLabel22.getText()+"','"+_hora+"','----','----','----','"+_fecha+"','3','"+tt+"')";
        String sqlentrada= "INSERT INTO registro (codigo,personal,entrada,c_entrada,c_salida,salida,fecha,opt,turnoreg)VALUES ('"+_id+"','"+jLabel22.getText()+"','"+reoto+_hora+"','----','----','----','"+_fecha+"','1','"+tt+"')";
        String sqlecomida= "UPDATE registro SET c_entrada = '"+_hora+"', opt = '2' where registro.indx = '"+_indx+"'";
        String sqlscomida= "UPDATE registro SET c_salida = '"+_hora+"', opt = '3' where registro.indx = '"+_indx+"'";
        String sqlsalida= "UPDATE registro SET salida = '"+_hora+"', opt = '0' where registro.indx = '"+_indx+"'";
       // System.out.println("rdyr  "+porcodigo);
       
        
        switch (opt){
            
                case 0:{
                    
                    
                    
                    
                    if("Libre".equals(tt)){                        
                        try {
                            PreparedStatement us = Conexion.prepareStatement(sqlentradalibre);
                            us.execute();
                            
                            // trayicon.displayMessage("ENTRADA "+hourFormat.format(date), nombre, TrayIcon.MessageType.INFO);
                            
                            
                            
                        } catch (SQLException ex) {
                            Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        
                    }else{
                        try {
                            PreparedStatement us = Conexion.prepareStatement(sqlentrada);
                            us.execute();
                            //  trayicon.displayMessage("ENTRADA "+hourFormat.format(date), nombre, TrayIcon.MessageType.INFO);
                            
                            
                            us.close();
                        } catch (SQLException ex) {
                            Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        
                        
                        
                        
                    }
                    act_tabla();
                    break;
                }
                
                case 1:{
                    

                    
//                    boolean sepu = turna.salidasincomer(id , hourFormat.format(date));
//                    boolean sapu = turna.salirsalida(id, hourFormat.format(date));
//                    
//                    System.out.println(sepu);
//                    System.out.println(sapu);
//                    
//                    if(sepu&&sapu){
                    try {
                        PreparedStatement us = Conexion.prepareStatement(sqlecomida);
                        us.executeUpdate();
                        us.close();
                     
                    } catch (SQLException ex) {
                          Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    
//                    }else{
//                         try {
//                        PreparedStatement us = Conexion.prepareStatement(sqlsalida);
//                        us.executeUpdate();
//                        try {
//                            ino.sendData("*SALIDA     "+hourFormat.format(date)+nombre);
//                            
//                        } catch (ArduinoException | SerialPortException ex) {
//                              Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
//                        }
//                    } catch (SQLException ex) {
//                          Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
//                        }
//                        
                        
//                    }
         
                    act_tabla();
                    break;
                    
                }
                case 2:{
                    
//                    boolean sapu = turna.salirsalida(id, hourFormat.format(date));
//                    if(sapu){
//  
//                    }else{
//                        
//                        
//                        try {
//                        PreparedStatement us = Conexion.prepareStatement(sqlsalida);
//                        us.executeUpdate();
//                        try {
//                            ino.sendData("*SALIDA     "+hourFormat.format(date)+nombre);
//                          
//                        } catch (ArduinoException | SerialPortException ex) {
//                              Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
//                        }
//                    } catch (SQLException ex) {
//                          Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
//                        }
//                        
//                        
//                    }
                    
                    try {
                        
                        PreparedStatement us = Conexion.prepareStatement(sqlscomida);
                        us.execute();
                        us.close();
                        
                    } catch (SQLException ex) {
                         Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    
                    
                    act_tabla();
                    break;
                    
                }
                case 3:{
                    
                  
                    String sqlsalida_de_cys = "UPDATE registro SET salida = '"+hourFormat.format(date)+"', c_salida = '' , opt = '0' where registro.indx = '"+indx+"'";
                    
                    
                    try {
                        PreparedStatement us = Conexion.prepareStatement(sqlsalida);
                        us.executeUpdate();
                        //trayicon.displayMessage("SALIDA "+hourFormat.format(date), nombre, TrayIcon.MessageType.INFO);
                       us.close();
                     
                    } catch (SQLException ex) {
                          Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    act_tabla();
                    break;
                    
                }
               

        }
    actualizart_permisos();
    }
    public String _consultarpermisos(){
        String indx2 = "";
        String tipo2 = "";
        String turno99 = null;
        String rr = null;
        try {

            String sql9 = "Select indx,tipo,motivo from permisos where aplica_a like '%"+_nombre+"%' and '"+_fecha+"' BETWEEN fecha_inicio and fecha_final order by indx DESC";
            //String columna[]= {"Fecha","ENTRADA","EN.COMIDA","SA.COMIDA","SALIDA","T.Comida","T.Horas","Turno"};
            
            Statement us = Conexion.createStatement();
            ResultSet res = us.executeQuery(sql9);
            String[] pp;
            while(res.next()){
              indx2 = String.valueOf(res.getObject(1));
              tipo2 = String.valueOf(res.getObject(2));
              turno99 = String.valueOf(res.getObject(3));
            }
            System.out.println(indx2);
            System.out.println(turno99);
            System.out.println(tipo2);
            us.close();
        } catch (SQLException ex) {
            Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        if(tipo2.equals("Dobla turno")){
            
          rr = turno99;
            
        }else{
            
        }
        
        return rr;
    }
    public String [] _registrarretados(){
      String retu[]={"",""}; 
      int row = jTable1.getRowCount();
      int indxdone=0;
      String nturno="";
      String tabla[]=new String[row];
      boolean turen;
      String horaentrada="";
      
      
           String sql="Select turno from personal where codigo = "+_id;
           PreparedStatement us;   
      
      
          
        try {
            
            
            us = Conexion.prepareStatement(sql);
            ResultSet res = us.executeQuery();
            
        
            
            
            
            if(res.next()){
                //System.out.println("ENtrotroer");
                nturno = String.valueOf(res.getObject(1));
          
      
                     for(int x=0;x<row;x++){
                     tabla[x]=  (String) jTable1.getModel().getValueAt(x, 0);
 
                       if(tabla[x].equals(nturno)){
                           indxdone=x;
                          // System.out.println("ENcontro turnnnnO"+tabla[x]);
                       }
    
                     }
                     
                }
            
            us.close();
            if(nturno.contains("/")){
               // System.out.println("SE detecto doble turno");
                
                String sql4="Select opt from registro where codigo = "+_id+" AND fecha = '"+_fecha+"'" ;
                PreparedStatement us4;  
                us4 = Conexion.prepareStatement(sql4);
                ResultSet res4 = us4.executeQuery();
                if(res4.next()){
                    
                    String opttemp =String.valueOf(res4.getObject(1));
                    System.out.println(opttemp);
                    if(opttemp.equals("0")){
                        System.out.println("ejecutar con segundo turno");
                        nturno =  nturno.substring(nturno.indexOf("/")+1);
                      //  System.err.println(segundoturno);
                        for(int x=0;x<row;x++){
                     tabla[x]=  (String) jTable1.getModel().getValueAt(x, 0);
 
                       if(tabla[x].equals(nturno)){
                           indxdone=x;
                          // System.out.println("ENcontro turnnnnO"+tabla[x]);
                       }
    
                     }
                        
                    }
                    
                    
                }else{
                    System.out.println("Primer turno");
                    nturno =  nturno.substring(0,nturno.indexOf("/"));
                    for(int x=0;x<row;x++){
                     tabla[x]=  (String) jTable1.getModel().getValueAt(x, 0);
 
                       if(tabla[x].equals(nturno)){
                           indxdone=x;
                          // System.out.println("ENcontro turnnnnO"+tabla[x]);
                       }
    
                     }
                    
                }
                us.close();
                
            }
            
            } catch (SQLException ex) {
            Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
        }
                
              if(indxdone==100){
                  turen=false;
              }else{
                  horaentrada=(String) jTable1.getValueAt(indxdone,1);
              }
              
              
              String entrada = _hora;
              Date d2=new Date();
              Date dd2=new Date(); 
               
              
              
            try {
                d2= hourFormat.parse(horaentrada);
                dd2= hourFormat.parse(_hora);
               
               
            } catch (ParseException ex) {
                Logger.getLogger(act_tablas1.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
            
            long ent= dd2.getTime();
            long entstol =d2.getTime();
            long tol= d2.getTime()+600000;
             
         // System.out.println("ent"+ent);
           // System.out.println("entsto1"+entstol);
           // System.out.println("tol"+tol);
            
         if(entstol>=ent){
                
                retu[0]= "";
                 System.out.println("Sin retardo");
                
            }else if(ent<=tol){
                
                retu[0]="T -";
                 System.out.println("tolerancio");
                
            }else if(ent>tol){
                
                retu[0]="R -";
                 System.out.println("retardo");
                
            }
            
      
      
      
      //  System.out.println(retu);
         retu[1] = nturno;
      return  retu;
      
    }
 
    
    public void act_tabla(){
       Date dede= new Date();
       String verultfecha = act_t.obtener_ultimafecha();
 
       
           // System.out.println(verultfecha);
            String sql = "Select codigo, personal, entrada, c_entrada, c_salida, salida, fecha from registro where fecha = '"+verultfecha+"'   order by registro . indx DESC";
            String columna[] = {"ID","NOMBRE","ENTRADA","C_ENTRADA","C_SALIDA","SALIDA","FECHA"};
            
            act_t.actualizar(jTable5, sql, 7, columna);
            diseñotab();
            
            
      
        
    }
    public void diseñotab(){
        TableColumnModel columnModel = jTable5.getColumnModel();
        //String columnas[]={"CODIGO","NOMBRE","ENTRADA","C-ENTRADA","C-SALIDA","SALIDA","FECHA"};
                
                columnModel.getColumn(0).setPreferredWidth(25);
                columnModel.getColumn(1).setPreferredWidth(250);
                columnModel.getColumn(2).setPreferredWidth(40);
                columnModel.getColumn(3).setPreferredWidth(40);
                columnModel.getColumn(4).setPreferredWidth(40);
                columnModel.getColumn(5).setPreferredWidth(40);
                columnModel.getColumn(6).setPreferredWidth(70);
                
//                DefaultTableCellRenderer tcr =  new DefaultTableCellRenderer();
//                tcr.setHorizontalAlignment(CENTER);
//                
//              for(int x=0;x<7;x++){
//                   columnModel.getColumn(x).setCellRenderer(tcr);
//              }
            
                jTable5.setColumnModel(columnModel);
                
    }
    public void diseñotab2(){
        TableColumnModel columnModel2 = jTable13.getColumnModel();
                columnModel2.getColumn(0).setPreferredWidth(180);
                columnModel2.getColumn(1).setPreferredWidth(90);
                columnModel2.getColumn(2).setPreferredWidth(90);
                columnModel2.getColumn(3).setPreferredWidth(90);
                columnModel2.getColumn(4).setPreferredWidth(90);
                columnModel2.getColumn(5).setPreferredWidth(90);
                columnModel2.getColumn(6).setPreferredWidth(90);
                columnModel2.getColumn(7).setPreferredWidth(120);
               // columnModel2.getColumn(8).setPreferredWidth(90);
                
                
//                DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
//                tcr.setHorizontalAlignment(CENTER);
//                
//                for(int x=0;x<8;x++){
//                    columnModel2.getColumn(x).setCellRenderer(tcr);
//                }
       
                jTable13.setColumnModel(columnModel2);
    }
    
    public void diseñotab3(){
        
        TableColumnModel columnMode3 = jTable3.getColumnModel();
                columnMode3.getColumn(0).setPreferredWidth(40);
                columnMode3.getColumn(1).setPreferredWidth(400);
                columnMode3.getColumn(2).setPreferredWidth(400);
                columnMode3.getColumn(3).setPreferredWidth(130);
                columnMode3.getColumn(4).setPreferredWidth(130); 
                columnMode3.getColumn(5).setPreferredWidth(120);
                columnMode3.getColumn(6).setPreferredWidth(170);
                columnMode3.getColumn(7).setPreferredWidth(170); 
                columnMode3.getColumn(8).setPreferredWidth(180);
                columnMode3.getColumn(9).setPreferredWidth(180);
          
//                DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
//                tcr.setHorizontalAlignment(RIGHT);
//                
//                for(int x=0;x<5;x++){
//                    columnMode3.getColumn(x).setCellRenderer(tcr);
//                }
            jTable3.setColumnModel(columnMode3);
    }
     public void diseñotab4(){
        TableColumnModel columnModel2 = jTable13.getColumnModel();
                columnModel2.getColumn(0).setPreferredWidth(190);
                columnModel2.getColumn(1).setPreferredWidth(320);
                columnModel2.getColumn(2).setPreferredWidth(90);
                columnModel2.getColumn(3).setPreferredWidth(90);
                columnModel2.getColumn(4).setPreferredWidth(90);
                columnModel2.getColumn(5).setPreferredWidth(90);
                columnModel2.getColumn(6).setPreferredWidth(90);
                columnModel2.getColumn(7).setPreferredWidth(90);
                
                
//                DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
//                tcr.setHorizontalAlignment(CENTER);
//                
//                for(int x=0;x<8;x++){
//                    columnModel2.getColumn(x).setCellRenderer(tcr);
//                }
       
                jTable13.setColumnModel(columnModel2);
    }
     
    public void diseñotab5(){
        String columna[] = {"Dia ","Tiempo Laborado","Tiempo en comida"};
        
        
        DefaultTableModel modelTablares = new DefaultTableModel(null,columna){
        public boolean isCellEditable(int rowIndex, int mColIndex) {
        return false;
        }};
        jTable13.setModel(modelTablares);
        
        TableColumnModel columnModel9 = jTable13.getColumnModel();
                columnModel9.getColumn(0).setPreferredWidth(150);
                columnModel9.getColumn(1).setPreferredWidth(100);
                columnModel9.getColumn(2).setPreferredWidth(100);
//                columnModel9.getColumn(3).setPreferredWidth(20);
//                columnModel9.getColumn(4).setPreferredWidth(20);
//                columnModel9.getColumn(5).setPreferredWidth(20);
//                columnModel9.getColumn(6).setPreferredWidth(20);
//                columnModel9.getColumn(7).setPreferredWidth(20);
//                columnModel9.getColumn(8).setPreferredWidth(20);
//                columnModel9.getColumn(9).setPreferredWidth(30);
//                columnModel9.getColumn(10).setPreferredWidth(30);
//                columnModel9.getColumn(11).setPreferredWidth(20);
//                columnModel9.getColumn(12).setPreferredWidth(20);
                
//                DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
//                tcr.setHorizontalAlignment(CENTER);
//                
//                for(int x=0;x<2;x++){
//                    columnModel9.getColumn(x).setCellRenderer(tcr);
//                }
       
                jTable13.setColumnModel(columnModel9);
                
    }
    
   public void diseñotab6(){
       
                TableColumnModel columnModel8 = jTable4.getColumnModel();
                columnModel8.getColumn(0).setPreferredWidth(6);
                columnModel8.getColumn(1).setPreferredWidth(60);
                columnModel8.getColumn(2).setPreferredWidth(60);
                columnModel8.getColumn(3).setPreferredWidth(40);
                columnModel8.getColumn(4).setPreferredWidth(200);
                columnModel8.getColumn(5).setPreferredWidth(140);
                columnModel8.getColumn(6).setPreferredWidth(390);
                columnModel8.getColumn(7).setPreferredWidth(10);
                
                
                jTable4.setColumnModel(columnModel8);
                jTable18.setColumnModel(columnModel8);
    }
   
    public void carga_propiedades(){
        
        c.cargar();
        
    }
    
    public void actualizart_personal(){
        
        String sql="Select codigo,nombre,domicilio,telcel,telca,turno,cotizacion,Puesto,rfc,nosocial from personal order by nombre";
        String columna[]= {"ID","Nombre","Domicilio","Tel. Cel", "Tel. Ca","Turno","Cotizacion","Puesto","RFC","No.Social"};
  
    
            act_t.actualizar(jTable3, sql, 10, columna);
       
        diseñotab3();
    }
    
    public void actualizart_registro(){
        
        
            String sqlcorreccion = "SELECT * FROM registro order by indx DESC";
            String columnassqlcorreccion[]= {"indx","codigo","personal","entrada","c_entrada","c_salida","salida","fecha"};
            act_t.actualizar(jTable2, sqlcorreccion, 8, columnassqlcorreccion );
        
        
    }
    
    public void actualizart_faltas(){
        
        String sqlcorreccion = "SELECT indx,fecha,hora,motivo,descripcion,aplica_a,gravante FROM faltas ";
        String columnassqlcorreccion[]= {"INDX","FECHA","HORA","MOTIVO","DESCRIPCION","Aplica","Gravante"};
            
        act_t.actualizar(jTable14, sqlcorreccion, 7, columnassqlcorreccion );
        
    }
            
    
  
    public void actualizart_turnos(){
        
        
            String sqlcorreccion = "SELECT nombre,entrada,tiempo_comida,salida,dias FROM turnos ";
            String columnassqlcorreccion[]= {"Nombre","Entrada","Tiempo Comida","Salida","Dias"};
            
            act_t.actualizar(jTable1, sqlcorreccion,5, columnassqlcorreccion );
       
        
    }

    public JTable getjTable1() {
        return jTable1;
    }
 
       
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        treport = new javax.swing.ButtonGroup();
        confpuert = new javax.swing.ButtonGroup();
        popupMenu1 = new java.awt.PopupMenu();
        menuItem1 = new java.awt.MenuItem();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jDialog1 = new javax.swing.JDialog();
        jTabbedPane3 = new javax.swing.JTabbedPane();
        jPanel14 = new javax.swing.JPanel();
        jttelcel1 = new javax.swing.JTextField();
        jtnombre1 = new javax.swing.JTextField();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jttelca1 = new javax.swing.JTextField();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jtlocalidad1 = new javax.swing.JTextField();
        jComboBox10 = new javax.swing.JComboBox<>();
        jLabel48 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jComboBox11 = new javax.swing.JComboBox<>();
        jComboBox12 = new javax.swing.JComboBox<>();
        jComboBox7 = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLhuella = new javax.swing.JLabel();
        jButton25 = new javax.swing.JButton();
        jtlrfc = new javax.swing.JTextField();
        jLabel162 = new javax.swing.JLabel();
        jtPUESTO = new javax.swing.JTextField();
        jLabel163 = new javax.swing.JLabel();
        jLabel164 = new javax.swing.JLabel();
        jtnosocial1 = new javax.swing.JTextField();
        jPanel46 = new javax.swing.JPanel();
        jComboBox20 = new javax.swing.JComboBox<>();
        jLabel111 = new javax.swing.JLabel();
        jPanel45 = new javax.swing.JPanel();
        jButton26 = new javax.swing.JButton();
        jButton27 = new javax.swing.JButton();
        jDialogTurnos = new javax.swing.JDialog();
        jPanel12 = new javax.swing.JPanel();
        jCminutosentrada = new javax.swing.JComboBox<>();
        jChorentrada = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jBcancelarturno = new javax.swing.JButton();
        jBaceptarturno = new javax.swing.JButton();
        jPanel15 = new javax.swing.JPanel();
        jLabel51 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jChorasalida = new javax.swing.JComboBox<>();
        jCminutosalida = new javax.swing.JComboBox<>();
        jPanel16 = new javax.swing.JPanel();
        jLabel53 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        tiempocomida = new javax.swing.JComboBox<>();
        mincomida = new javax.swing.JComboBox<>();
        jCheckBox1 = new javax.swing.JCheckBox();
        jPanel42 = new javax.swing.JPanel();
        jCheckBox2 = new javax.swing.JCheckBox();
        jCheckBox3 = new javax.swing.JCheckBox();
        jCheckBox4 = new javax.swing.JCheckBox();
        jCheckBox5 = new javax.swing.JCheckBox();
        jCheckBox6 = new javax.swing.JCheckBox();
        jCheckBox7 = new javax.swing.JCheckBox();
        jCheckBox8 = new javax.swing.JCheckBox();
        DialogPermisos = new javax.swing.JDialog();
        jCalendar3 = new com.toedter.calendar.JCalendar();
        jCalendar4 = new com.toedter.calendar.JCalendar();
        jLabel4 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jComboBox5 = new javax.swing.JComboBox<>();
        jLabel28 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        jComboBox6 = new javax.swing.JComboBox<>();
        jLabel30 = new javax.swing.JLabel();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        jButton18 = new javax.swing.JButton();
        jButton28 = new javax.swing.JButton();
        jPanel54 = new javax.swing.JPanel();
        jLabel149 = new javax.swing.JLabel();
        jLabel150 = new javax.swing.JLabel();
        jComboBox25 = new javax.swing.JComboBox<>();
        jComboBox26 = new javax.swing.JComboBox<>();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jDialog4 = new javax.swing.JDialog();
        jPanel18 = new javax.swing.JPanel();
        jLabel64 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel65 = new javax.swing.JLabel();
        jPasswordField1 = new javax.swing.JPasswordField();
        jButton33 = new javax.swing.JButton();
        jButton32 = new javax.swing.JButton();
        jDialog5 = new javax.swing.JDialog();
        jPanel19 = new javax.swing.JPanel();
        jCminutosentrada8 = new javax.swing.JComboBox<>();
        jChorentrada8 = new javax.swing.JComboBox<>();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jChorentrada9 = new javax.swing.JComboBox<>();
        jCminutosentrada9 = new javax.swing.JComboBox<>();
        jChorentrada10 = new javax.swing.JComboBox<>();
        jChorentrada11 = new javax.swing.JComboBox<>();
        jCminutosentrada10 = new javax.swing.JComboBox<>();
        jCminutosentrada11 = new javax.swing.JComboBox<>();
        jChorentrada12 = new javax.swing.JComboBox<>();
        jChorentrada13 = new javax.swing.JComboBox<>();
        jCminutosentrada12 = new javax.swing.JComboBox<>();
        jCminutosentrada13 = new javax.swing.JComboBox<>();
        jChorentrada14 = new javax.swing.JComboBox<>();
        jCminutosentrada14 = new javax.swing.JComboBox<>();
        jPanel20 = new javax.swing.JPanel();
        jLabel37 = new javax.swing.JLabel();
        jTextField10 = new javax.swing.JTextField();
        jBcancelarturno1 = new javax.swing.JButton();
        jBaceptarturno1 = new javax.swing.JButton();
        jPanel21 = new javax.swing.JPanel();
        jLabel68 = new javax.swing.JLabel();
        jLabel69 = new javax.swing.JLabel();
        jChorasalida7 = new javax.swing.JComboBox<>();
        jCminutosalida7 = new javax.swing.JComboBox<>();
        jChorasalida8 = new javax.swing.JComboBox<>();
        jCminutosalida8 = new javax.swing.JComboBox<>();
        jChorasalida9 = new javax.swing.JComboBox<>();
        jCminutosalida9 = new javax.swing.JComboBox<>();
        jChorasalida10 = new javax.swing.JComboBox<>();
        jCminutosalida10 = new javax.swing.JComboBox<>();
        jChorasalida11 = new javax.swing.JComboBox<>();
        jCminutosalida11 = new javax.swing.JComboBox<>();
        jChorasalida12 = new javax.swing.JComboBox<>();
        jCminutosalida12 = new javax.swing.JComboBox<>();
        jChorasalida13 = new javax.swing.JComboBox<>();
        jCminutosalida13 = new javax.swing.JComboBox<>();
        jPanel22 = new javax.swing.JPanel();
        jLabel70 = new javax.swing.JLabel();
        jLabel71 = new javax.swing.JLabel();
        tiempocomida1 = new javax.swing.JComboBox<>();
        mincomida3 = new javax.swing.JComboBox<>();
        jLabel38 = new javax.swing.JLabel();
        mincomida4 = new javax.swing.JComboBox<>();
        jLabel72 = new javax.swing.JLabel();
        jCheckBox12 = new javax.swing.JCheckBox();
        jLabel40 = new javax.swing.JLabel();
        jCheckBox13 = new javax.swing.JCheckBox();
        jPanel23 = new javax.swing.JPanel();
        jCheckBox14 = new javax.swing.JCheckBox();
        jCheckBox15 = new javax.swing.JCheckBox();
        jCheckBox16 = new javax.swing.JCheckBox();
        jCheckBox17 = new javax.swing.JCheckBox();
        jCheckBox18 = new javax.swing.JCheckBox();
        jCheckBox19 = new javax.swing.JCheckBox();
        jCheckBox20 = new javax.swing.JCheckBox();
        jCheckBox21 = new javax.swing.JCheckBox();
        jCheckBox22 = new javax.swing.JCheckBox();
        jPanel24 = new javax.swing.JPanel();
        jLabel73 = new javax.swing.JLabel();
        jLabel74 = new javax.swing.JLabel();
        mincomida5 = new javax.swing.JComboBox<>();
        jLabel75 = new javax.swing.JLabel();
        jLabel76 = new javax.swing.JLabel();
        jCminutosentrada15 = new javax.swing.JComboBox<>();
        jChorentrada15 = new javax.swing.JComboBox<>();
        jLabel77 = new javax.swing.JLabel();
        grupodegraficas = new javax.swing.ButtonGroup();
        jDialog6 = new javax.swing.JDialog();
        jTextField11 = new javax.swing.JTextField();
        jComboBox18 = new javax.swing.JComboBox<>();
        jScrollPane14 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jCalendar1 = new com.toedter.calendar.JCalendar();
        jButton46 = new javax.swing.JButton();
        jButton47 = new javax.swing.JButton();
        jFormattedTextField7 = new javax.swing.JFormattedTextField();
        jComboBox3 = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        jTextField29 = new javax.swing.JTextField();
        jDialog7 = new javax.swing.JDialog();
        jCalendar2 = new com.toedter.calendar.JCalendar();
        jCalendar5 = new com.toedter.calendar.JCalendar();
        jButton59 = new javax.swing.JButton();
        jButton60 = new javax.swing.JButton();
        jLabel86 = new javax.swing.JLabel();
        jLabel102 = new javax.swing.JLabel();
        jLabel105 = new javax.swing.JLabel();
        jLabel106 = new javax.swing.JLabel();
        jDialogConceptos = new javax.swing.JDialog();
        jPanel50 = new javax.swing.JPanel();
        jLabel113 = new javax.swing.JLabel();
        jTextField27 = new javax.swing.JTextField();
        jRadioButton9 = new javax.swing.JRadioButton();
        jRadioButton8 = new javax.swing.JRadioButton();
        jButton70 = new javax.swing.JButton();
        jButton71 = new javax.swing.JButton();
        jLabel114 = new javax.swing.JLabel();
        jComboBox19 = new javax.swing.JComboBox<>();
        jLabel115 = new javax.swing.JLabel();
        jFormattedTextField17 = new javax.swing.JFormattedTextField();
        buttonGroup3 = new javax.swing.ButtonGroup();
        jDialog10 = new javax.swing.JDialog();
        jCalendar8 = new com.toedter.calendar.JCalendar();
        jCalendar9 = new com.toedter.calendar.JCalendar();
        jBcancelarturno2 = new javax.swing.JButton();
        jBaceptarturno2 = new javax.swing.JButton();
        jDialog3 = new javax.swing.JDialog();
        jPanel59 = new javax.swing.JPanel();
        jLabel151 = new javax.swing.JLabel();
        jComboBox27 = new javax.swing.JComboBox<>();
        jPanel61 = new javax.swing.JPanel();
        jScrollPane23 = new javax.swing.JScrollPane();
        jPanel60 = new javax.swing.JPanel();
        jCheckBox9 = new javax.swing.JCheckBox();
        jBcancelarturno3 = new javax.swing.JButton();
        jBaceptarturno3 = new javax.swing.JButton();
        jButton85 = new javax.swing.JButton();
        jTextField28 = new javax.swing.JTextField();
        jPanel53 = new javax.swing.JPanel();
        jCheckBox10 = new javax.swing.JCheckBox();
        jCheckBox11 = new javax.swing.JCheckBox();
        jCheckBox23 = new javax.swing.JCheckBox();
        jCheckBox24 = new javax.swing.JCheckBox();
        jCheckBox25 = new javax.swing.JCheckBox();
        jCheckBox26 = new javax.swing.JCheckBox();
        jCheckBox27 = new javax.swing.JCheckBox();
        jPanel62 = new javax.swing.JPanel();
        jComboBox14 = new javax.swing.JComboBox<>();
        buttonGroup4 = new javax.swing.ButtonGroup();
        buttonGrouporden = new javax.swing.ButtonGroup();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel36 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable5 = new javax.swing.JTable();
        jButton9 = new javax.swing.JButton();
        jTextField4 = new javax.swing.JTextField();
        fechalabel = new javax.swing.JLabel();
        lbHora = new javax.swing.JLabel();
        jButton34 = new javax.swing.JButton();
        jPanel37 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel67 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel147 = new javax.swing.JLabel();
        jLabel148 = new javax.swing.JLabel();
        jProgressBar1 = new javax.swing.JProgressBar();
        jPanel5 = new javax.swing.JPanel();
        jButton19 = new javax.swing.JButton();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        labetolerancia = new javax.swing.JLabel();
        laberetardos = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        labetotalhoras = new javax.swing.JLabel();
        jda = new com.toedter.calendar.JCalendar();
        jdde = new com.toedter.calendar.JCalendar();
        jComboBox1 = new javax.swing.JComboBox<>();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jButton21 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton12 = new javax.swing.JButton();
        jButton58 = new javax.swing.JButton();
        jTabbedPane5 = new javax.swing.JTabbedPane();
        jPanel55 = new javax.swing.JPanel();
        jScrollPane9 = new javax.swing.JScrollPane();
        jTable13 = new javax.swing.JTable();
        jPanel56 = new javax.swing.JPanel();
        jScrollPane21 = new javax.swing.JScrollPane();
        jTable18 = new javax.swing.JTable();
        jPanel57 = new javax.swing.JPanel();
        jLabel31 = new javax.swing.JLabel();
        jRadioButton11 = new javax.swing.JRadioButton();
        jRadioButton12 = new javax.swing.JRadioButton();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        jButton4 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jdde1 = new com.toedter.calendar.JCalendar();
        jda1 = new com.toedter.calendar.JCalendar();
        jComboBox4 = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jButton11 = new javax.swing.JButton();
        jButton29 = new javax.swing.JButton();
        jButton81 = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        jButton30 = new javax.swing.JButton();
        jScrollPane7 = new javax.swing.JScrollPane();
        jPanel11 = new javax.swing.JPanel();
        jdde2 = new com.toedter.calendar.JCalendar();
        jda2 = new com.toedter.calendar.JCalendar();
        jComboBox9 = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jComboBox13 = new javax.swing.JComboBox<>();
        jRadioButton5 = new javax.swing.JRadioButton();
        jRadioButton6 = new javax.swing.JRadioButton();
        jRadioButton7 = new javax.swing.JRadioButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton55 = new javax.swing.JButton();
        jButton57 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton86 = new javax.swing.JButton();
        jPanel47 = new javax.swing.JPanel();
        jTabbedPane4 = new javax.swing.JTabbedPane();
        jPanel17 = new javax.swing.JPanel();
        jPanel25 = new javax.swing.JPanel();
        jLabel56 = new javax.swing.JLabel();
        jComboBox15 = new javax.swing.JComboBox<>();
        jLabel57 = new javax.swing.JLabel();
        jButton45 = new javax.swing.JButton();
        jLabel87 = new javax.swing.JLabel();
        jButton53 = new javax.swing.JButton();
        jFormattedTextField6 = new javax.swing.JFormattedTextField();
        jLabel103 = new javax.swing.JLabel();
        TF_salsem = new javax.swing.JFormattedTextField();
        jLabel104 = new javax.swing.JLabel();
        jFormattedTextField8 = new javax.swing.JFormattedTextField();
        jLabelss = new javax.swing.JLabel();
        jButton79 = new javax.swing.JButton();
        jLabel146 = new javax.swing.JLabel();
        jLabel110 = new javax.swing.JLabel();
        jButton61 = new javax.swing.JButton();
        jPanel26 = new javax.swing.JPanel();
        jLabel90 = new javax.swing.JLabel();
        jLabel85 = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        jTable6 = new javax.swing.JTable();
        jPanel27 = new javax.swing.JPanel();
        jScrollPane11 = new javax.swing.JScrollPane();
        jTable7 = new javax.swing.JTable();
        jPanel28 = new javax.swing.JPanel();
        jLabel60 = new javax.swing.JLabel();
        jLabel78 = new javax.swing.JLabel();
        jComboBox16 = new javax.swing.JComboBox<>();
        jLabel79 = new javax.swing.JLabel();
        jTextField13 = new javax.swing.JTextField();
        jButton43 = new javax.swing.JButton();
        jButton44 = new javax.swing.JButton();
        jFormattedTextField4 = new javax.swing.JFormattedTextField();
        jFormattedTextField5 = new javax.swing.JFormattedTextField();
        jLabel84 = new javax.swing.JLabel();
        jLabel88 = new javax.swing.JLabel();
        jScrollPane16 = new javax.swing.JScrollPane();
        jTable9 = new javax.swing.JTable();
        jPanel29 = new javax.swing.JPanel();
        jScrollPane12 = new javax.swing.JScrollPane();
        jTable8 = new javax.swing.JTable();
        jButton42 = new javax.swing.JButton();
        jButton41 = new javax.swing.JButton();
        jFormattedTextField2 = new javax.swing.JFormattedTextField();
        jFormattedTextField3 = new javax.swing.JFormattedTextField();
        jTextField12 = new javax.swing.JTextField();
        jComboBox17 = new javax.swing.JComboBox<>();
        jLabel80 = new javax.swing.JLabel();
        jLabel81 = new javax.swing.JLabel();
        jLabel82 = new javax.swing.JLabel();
        jLabel83 = new javax.swing.JLabel();
        jLabel89 = new javax.swing.JLabel();
        jPanel30 = new javax.swing.JPanel();
        TF_subpercep = new javax.swing.JLabel();
        TF_subdeduc = new javax.swing.JLabel();
        jLabel98 = new javax.swing.JLabel();
        TF_total = new javax.swing.JFormattedTextField();
        TF_nombre_emp = new javax.swing.JTextField();
        TF_domicilio_emp1 = new javax.swing.JTextField();
        Tf_rfc_emp2 = new javax.swing.JTextField();
        TF_nombre_perso = new javax.swing.JTextField();
        TF_codigo_perso = new javax.swing.JTextField();
        TF_puesto_perso = new javax.swing.JTextField();
        Tf_rfc_perso = new javax.swing.JTextField();
        TF_nosocial_perso1 = new javax.swing.JTextField();
        TF_periodo_perso2 = new javax.swing.JTextField();
        TF_dias_perso3 = new javax.swing.JTextField();
        TF_tarifa_perso4 = new javax.swing.JTextField();
        TF_fechaemision_perso5 = new javax.swing.JTextField();
        jScrollPane18 = new javax.swing.JScrollPane();
        TF_texto_c = new javax.swing.JTextArea();
        jScrollPane19 = new javax.swing.JScrollPane();
        jTable10 = new javax.swing.JTable();
        jPanel51 = new javax.swing.JPanel();
        jScrollPane15 = new javax.swing.JScrollPane();
        jTable15 = new javax.swing.JTable();
        jButton62 = new javax.swing.JButton();
        jPanel48 = new javax.swing.JPanel();
        jButton67 = new javax.swing.JButton();
        jButton69 = new javax.swing.JButton();
        jScrollPane17 = new javax.swing.JScrollPane();
        jTable12 = new javax.swing.JTable();
        jPanel49 = new javax.swing.JPanel();
        jScrollPane13 = new javax.swing.JScrollPane();
        jTable11 = new javax.swing.JTable();
        jButton64 = new javax.swing.JButton();
        jButton65 = new javax.swing.JButton();
        jButton66 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jButton36 = new javax.swing.JButton();
        jButton37 = new javax.swing.JButton();
        jdde3 = new com.toedter.calendar.JCalendar();
        jda3 = new com.toedter.calendar.JCalendar();
        jScrollPane10 = new javax.swing.JScrollPane();
        jTable14 = new javax.swing.JTable();
        jPanel58 = new javax.swing.JPanel();
        jScrollPane22 = new javax.swing.JScrollPane();
        jTable19 = new javax.swing.JTable();
        jButton80 = new javax.swing.JButton();
        jButton82 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jButton10 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        jButton39 = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel31 = new javax.swing.JPanel();
        jPanel34 = new javax.swing.JPanel();
        jTextField14 = new javax.swing.JTextField();
        jTextField15 = new javax.swing.JTextField();
        jTextField16 = new javax.swing.JTextField();
        jTextField17 = new javax.swing.JTextField();
        jTextField18 = new javax.swing.JTextField();
        jTextField19 = new javax.swing.JTextField();
        jTextField20 = new javax.swing.JTextField();
        jTextField21 = new javax.swing.JTextField();
        jTextField22 = new javax.swing.JTextField();
        jTextField23 = new javax.swing.JTextField();
        jTextField24 = new javax.swing.JTextField();
        jTextField25 = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jButton49 = new javax.swing.JButton();
        jButton52 = new javax.swing.JButton();
        jPanel43 = new javax.swing.JPanel();
        jPanel44 = new javax.swing.JPanel();
        jLabel58 = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        jFormattedTextField10 = new javax.swing.JFormattedTextField();
        jFormattedTextField11 = new javax.swing.JFormattedTextField();
        jButton56 = new javax.swing.JButton();
        jPanel65 = new javax.swing.JPanel();
        jLabel161 = new javax.swing.JLabel();
        jButton87 = new javax.swing.JButton();
        jButton38 = new javax.swing.JButton();
        jPanel66 = new javax.swing.JPanel();
        jLabel165 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jButton20 = new javax.swing.JButton();
        jPanel32 = new javax.swing.JPanel();
        jPanel38 = new javax.swing.JPanel();
        jComboBox8 = new javax.swing.JComboBox<>();
        jButton16 = new javax.swing.JButton();
        jRadioButton10 = new javax.swing.JRadioButton();
        jButton89 = new javax.swing.JButton();
        jPanel39 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        jTextField26 = new javax.swing.JTextField();
        jButton50 = new javax.swing.JButton();
        jButton51 = new javax.swing.JButton();
        jButton17 = new javax.swing.JButton();
        jPanel52 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jPanel35 = new javax.swing.JPanel();
        jPanel40 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jButton13 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jPanel41 = new javax.swing.JPanel();
        jButton24 = new javax.swing.JButton();
        jButton48 = new javax.swing.JButton();
        jButton54 = new javax.swing.JButton();
        jPanel33 = new javax.swing.JPanel();
        jButton35 = new javax.swing.JButton();
        jPanel63 = new javax.swing.JPanel();
        jLabel61 = new javax.swing.JLabel();
        jTextField9 = new javax.swing.JTextField();
        jLabel62 = new javax.swing.JLabel();
        jLabel63 = new javax.swing.JLabel();
        jLabel66 = new javax.swing.JLabel();
        jTextField8 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        jButton31 = new javax.swing.JButton();
        jPanel64 = new javax.swing.JPanel();
        jLabel157 = new javax.swing.JLabel();
        jLabel158 = new javax.swing.JLabel();
        jLabel159 = new javax.swing.JLabel();
        jLabel160 = new javax.swing.JLabel();
        jTextField32 = new javax.swing.JTextField();
        jTextField33 = new javax.swing.JTextField();
        jTextField34 = new javax.swing.JTextField();
        jButton22 = new javax.swing.JButton();
        jButton88 = new javax.swing.JButton();
        jButton23 = new javax.swing.JButton();

        popupMenu1.setLabel("popupMenu1");
        popupMenu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                popupMenu1ActionPerformed(evt);
            }
        });

        menuItem1.setLabel("Menu Principal");
        menuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItem1ActionPerformed(evt);
            }
        });
        popupMenu1.add(menuItem1);

        jDialog1.setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        jDialog1.setTitle("Nuevo Personal");
        jDialog1.setBackground(new java.awt.Color(255, 255, 255));
        jDialog1.setIconImage(new ImageIcon(this.getClass().getResource("/ico/businessman.png")).getImage());
        jDialog1.setMinimumSize(new java.awt.Dimension(850, 450));
        jDialog1.setModal(true);
        jDialog1.setResizable(false);

        jPanel14.setMaximumSize(new java.awt.Dimension(501, 329));
        jPanel14.setMinimumSize(new java.awt.Dimension(501, 329));
        jPanel14.setPreferredSize(new java.awt.Dimension(501, 329));

        jtnombre1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtnombre1ActionPerformed(evt);
            }
        });

        jLabel35.setText("Nombre :");

        jLabel36.setText("Tel. Cel :");

        jLabel45.setText("Tel. Casa :");

        jttelca1.setMaximumSize(new java.awt.Dimension(168, 20));
        jttelca1.setMinimumSize(new java.awt.Dimension(168, 20));
        jttelca1.setPreferredSize(new java.awt.Dimension(168, 20));
        jttelca1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jttelca1ActionPerformed(evt);
            }
        });

        jLabel46.setText("CAPTURANDO....");

        jLabel47.setText("Domicilio : ");

        jtlocalidad1.setMaximumSize(new java.awt.Dimension(403, 20));
        jtlocalidad1.setMinimumSize(new java.awt.Dimension(403, 20));
        jtlocalidad1.setPreferredSize(new java.awt.Dimension(403, 20));

        jComboBox10.setPreferredSize(new java.awt.Dimension(28, 25));

        jLabel48.setText("Codigo:");

        jLabel39.setText("Turno:");

        jPanel13.setVisible(false);

        jComboBox11.setEnabled(false);
        jComboBox11.setMaximumSize(new java.awt.Dimension(118, 25));
        jComboBox11.setMinimumSize(new java.awt.Dimension(118, 25));
        jComboBox11.setPreferredSize(new java.awt.Dimension(118, 25));

        jComboBox12.setEnabled(false);
        jComboBox12.setMaximumSize(new java.awt.Dimension(118, 25));
        jComboBox12.setMinimumSize(new java.awt.Dimension(118, 25));
        jComboBox12.setPreferredSize(new java.awt.Dimension(118, 25));

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jComboBox11, 0, 147, Short.MAX_VALUE)
            .addComponent(jComboBox12, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addComponent(jComboBox11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jComboBox7.setMinimumSize(new java.awt.Dimension(118, 25));
        jComboBox7.setPreferredSize(new java.awt.Dimension(118, 25));
        jComboBox7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jComboBox7MouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jComboBox7MouseReleased(evt);
            }
        });
        jComboBox7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox7ActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel5.setText(" ");

        jLabel49.setText("Primero :");

        jLabel50.setText("Segundo :");

        jPanel6.setFocusable(false);
        jPanel6.setMaximumSize(new java.awt.Dimension(256, 288));

        jLhuella.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ico/huellabus.jpg"))); // NOI18N
        jLhuella.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2), javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 6)));
        jLhuella.setMaximumSize(new java.awt.Dimension(250, 250));
        jLhuella.setMinimumSize(new java.awt.Dimension(250, 250));
        jLhuella.setName(""); // NOI18N
        jLhuella.setPreferredSize(new java.awt.Dimension(250, 250));

        jButton25.setText("Capturar Huella");
        jButton25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton25ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLhuella, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jButton25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jLhuella, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton25)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jtlrfc.setMaximumSize(new java.awt.Dimension(403, 20));
        jtlrfc.setMinimumSize(new java.awt.Dimension(403, 20));
        jtlrfc.setPreferredSize(new java.awt.Dimension(403, 20));

        jLabel162.setText("RFC :");

        jtPUESTO.setMaximumSize(new java.awt.Dimension(403, 20));
        jtPUESTO.setMinimumSize(new java.awt.Dimension(403, 20));
        jtPUESTO.setPreferredSize(new java.awt.Dimension(403, 20));

        jLabel163.setText("No. Social :");

        jLabel164.setText("Puesto:");

        jtnosocial1.setMaximumSize(new java.awt.Dimension(403, 20));
        jtnosocial1.setMinimumSize(new java.awt.Dimension(403, 20));
        jtnosocial1.setPreferredSize(new java.awt.Dimension(403, 20));

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel14Layout.createSequentialGroup()
                                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel47, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel35))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jtlocalidad1, javax.swing.GroupLayout.DEFAULT_SIZE, 422, Short.MAX_VALUE)
                                    .addComponent(jtnombre1)))
                            .addGroup(jPanel14Layout.createSequentialGroup()
                                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel14Layout.createSequentialGroup()
                                        .addComponent(jLabel36)
                                        .addGap(11, 11, 11))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                                        .addComponent(jLabel162)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel14Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel46))
                                    .addGroup(jPanel14Layout.createSequentialGroup()
                                        .addComponent(jttelcel1, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel45)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jttelca1, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel14Layout.createSequentialGroup()
                                        .addComponent(jtlrfc, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel163)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jtnosocial1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel14Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel50)
                                    .addComponent(jLabel49))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel14Layout.createSequentialGroup()
                                .addGap(61, 61, 61)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel14Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabel39)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jComboBox7, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(9, 9, 9)
                        .addComponent(jLabel48)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox10, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel164)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtPUESTO, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 154, Short.MAX_VALUE)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabel46, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel35)
                            .addComponent(jtnombre1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel47)
                            .addComponent(jtlocalidad1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(7, 7, 7)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel162)
                            .addComponent(jtlrfc, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel163)
                            .addComponent(jtnosocial1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jttelcel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel45)
                            .addComponent(jLabel36)
                            .addComponent(jttelca1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel39)
                            .addComponent(jComboBox7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel48)
                            .addComponent(jComboBox10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel164)
                            .addComponent(jtPUESTO, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel14Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel49)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel50))
                            .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(38, Short.MAX_VALUE))
        );

        jTabbedPane3.addTab("General", new javax.swing.ImageIcon(getClass().getResource("/ico/pass.png")), jPanel14); // NOI18N

        jPanel46.setFocusable(false);

        jComboBox20.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox20.setMinimumSize(new java.awt.Dimension(56, 30));
        jComboBox20.setPreferredSize(new java.awt.Dimension(56, 30));

        jLabel111.setText("Tipo de cotizacion:");

        javax.swing.GroupLayout jPanel46Layout = new javax.swing.GroupLayout(jPanel46);
        jPanel46.setLayout(jPanel46Layout);
        jPanel46Layout.setHorizontalGroup(
            jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel46Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel111)
                    .addComponent(jComboBox20, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(687, Short.MAX_VALUE))
        );
        jPanel46Layout.setVerticalGroup(
            jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel46Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel111)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(252, Short.MAX_VALUE))
        );

        jTabbedPane3.addTab("Cotizacion", new javax.swing.ImageIcon(getClass().getResource("/ico/get-money.png")), jPanel46, ""); // NOI18N

        javax.swing.GroupLayout jPanel45Layout = new javax.swing.GroupLayout(jPanel45);
        jPanel45.setLayout(jPanel45Layout);
        jPanel45Layout.setHorizontalGroup(
            jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 845, Short.MAX_VALUE)
        );
        jPanel45Layout.setVerticalGroup(
            jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 313, Short.MAX_VALUE)
        );

        jTabbedPane3.addTab("Documentos", new javax.swing.ImageIcon(getClass().getResource("/ico/record.png")), jPanel45); // NOI18N

        jButton26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ico/cancel.png"))); // NOI18N
        jButton26.setText("Cancelar");
        jButton26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton26ActionPerformed(evt);
            }
        });

        jButton27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ico/acep.png"))); // NOI18N
        jButton27.setText("Aceptar");
        jButton27.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton27ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane3)
            .addGroup(jDialog1Layout.createSequentialGroup()
                .addGap(312, 312, 312)
                .addComponent(jButton26)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton27)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog1Layout.createSequentialGroup()
                .addComponent(jTabbedPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton26)
                    .addComponent(jButton27)))
        );

        jTabbedPane3.getAccessibleContext().setAccessibleName("Nuevo Personal");

        jDialogTurnos.setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        jDialogTurnos.setTitle("Nuevo Horario");
        jDialogTurnos.setBackground(new java.awt.Color(255, 255, 255));
        jDialogTurnos.setIconImage(new ImageIcon(this.getClass().getResource("/ico/clock.png")).getImage());
        jDialogTurnos.setMinimumSize(new java.awt.Dimension(482, 294));

        jPanel12.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder("Entrada"), "Entrada"));

        jCminutosentrada.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "00", "05", "10", "15", "20", "25", "30", "35", "40", "45", "50", "55" }));
        jCminutosentrada.setMaximumSize(new java.awt.Dimension(45, 20));
        jCminutosentrada.setMinimumSize(new java.awt.Dimension(45, 20));
        jCminutosentrada.setPreferredSize(new java.awt.Dimension(45, 20));

        jChorentrada.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23" }));
        jChorentrada.setMaximumSize(new java.awt.Dimension(45, 20));
        jChorentrada.setMinimumSize(new java.awt.Dimension(45, 20));
        jChorentrada.setPreferredSize(new java.awt.Dimension(45, 20));

        jLabel6.setText("Hora:");

        jLabel7.setText("Minutos:");

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(0, 16, Short.MAX_VALUE)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jChorentrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel7))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jCminutosentrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCminutosentrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jChorentrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel11.setText("Nombre:");

        jTextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jBcancelarturno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ico/cancel.png"))); // NOI18N
        jBcancelarturno.setText("Cancelar");
        jBcancelarturno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBcancelarturnoActionPerformed(evt);
            }
        });

        jBaceptarturno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ico/acep.png"))); // NOI18N
        jBaceptarturno.setText("Aceptar");
        jBaceptarturno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBaceptarturnoActionPerformed(evt);
            }
        });

        jPanel15.setBorder(javax.swing.BorderFactory.createTitledBorder("Salida"));

        jLabel51.setText("Hora:");

        jLabel52.setText("Minutos:");

        jChorasalida.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23" }));
        jChorasalida.setMaximumSize(new java.awt.Dimension(45, 20));
        jChorasalida.setMinimumSize(new java.awt.Dimension(45, 20));
        jChorasalida.setPreferredSize(new java.awt.Dimension(45, 20));

        jCminutosalida.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "00", "05", "10", "15", "20", "25", "30", "35", "40", "45", "50", "55" }));
        jCminutosalida.setMaximumSize(new java.awt.Dimension(45, 20));
        jCminutosalida.setMinimumSize(new java.awt.Dimension(45, 20));
        jCminutosalida.setPreferredSize(new java.awt.Dimension(45, 20));

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jChorasalida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel51))
                .addGap(18, 18, 18)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel52)
                    .addComponent(jCminutosalida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel51)
                    .addComponent(jLabel52))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jChorasalida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCminutosalida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel16.setBorder(javax.swing.BorderFactory.createTitledBorder("Tiempo Comida"));

        jLabel53.setText("Horas:");

        jLabel54.setText("Minutos:");

        tiempocomida.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23" }));
        tiempocomida.setMaximumSize(new java.awt.Dimension(45, 20));
        tiempocomida.setMinimumSize(new java.awt.Dimension(45, 20));
        tiempocomida.setPreferredSize(new java.awt.Dimension(45, 20));
        tiempocomida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tiempocomidaActionPerformed(evt);
            }
        });

        mincomida.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "00", "05", "10", "15", "20", "25", "30", "35", "40", "45", "50", "55" }));
        mincomida.setMaximumSize(new java.awt.Dimension(45, 20));
        mincomida.setMinimumSize(new java.awt.Dimension(45, 20));
        mincomida.setPreferredSize(new java.awt.Dimension(45, 20));

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tiempocomida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel53))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel54)
                    .addComponent(mincomida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel53)
                    .addComponent(jLabel54))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tiempocomida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mincomida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jCheckBox1.setSelected(true);
        jCheckBox1.setText("Derecho a Comida");
        jCheckBox1.setMaximumSize(new java.awt.Dimension(830, 24));
        jCheckBox1.setMinimumSize(new java.awt.Dimension(830, 24));
        jCheckBox1.setPreferredSize(new java.awt.Dimension(830, 24));
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });

        jPanel42.setBorder(javax.swing.BorderFactory.createTitledBorder("Turno"));
        jPanel42.setToolTipText("Seleccione los dias que aplica este horario.");

        jCheckBox2.setSelected(true);
        jCheckBox2.setText("Lunes");
        jCheckBox2.setName("L"); // NOI18N

        jCheckBox3.setSelected(true);
        jCheckBox3.setText("Martes");
        jCheckBox3.setName("M"); // NOI18N
        jCheckBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox3ActionPerformed(evt);
            }
        });

        jCheckBox4.setSelected(true);
        jCheckBox4.setText("Miercoles");
        jCheckBox4.setName("X"); // NOI18N
        jCheckBox4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox4ActionPerformed(evt);
            }
        });

        jCheckBox5.setSelected(true);
        jCheckBox5.setText("Jueves");
        jCheckBox5.setName("J"); // NOI18N
        jCheckBox5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox5ActionPerformed(evt);
            }
        });

        jCheckBox6.setSelected(true);
        jCheckBox6.setText("Viernes");
        jCheckBox6.setName("V"); // NOI18N
        jCheckBox6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox6ActionPerformed(evt);
            }
        });

        jCheckBox7.setSelected(true);
        jCheckBox7.setText("Sabado");
        jCheckBox7.setName("S"); // NOI18N
        jCheckBox7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox7ActionPerformed(evt);
            }
        });

        jCheckBox8.setSelected(true);
        jCheckBox8.setText("Domingo");
        jCheckBox8.setName("D"); // NOI18N
        jCheckBox8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel42Layout = new javax.swing.GroupLayout(jPanel42);
        jPanel42.setLayout(jPanel42Layout);
        jPanel42Layout.setHorizontalGroup(
            jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel42Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jCheckBox2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jCheckBox5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jCheckBox6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jCheckBox7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jCheckBox8))
        );
        jPanel42Layout.setVerticalGroup(
            jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel42Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBox2)
                    .addComponent(jCheckBox3)
                    .addComponent(jCheckBox4)
                    .addComponent(jCheckBox5)
                    .addComponent(jCheckBox6)
                    .addComponent(jCheckBox7)
                    .addComponent(jCheckBox8))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jDialogTurnosLayout = new javax.swing.GroupLayout(jDialogTurnos.getContentPane());
        jDialogTurnos.getContentPane().setLayout(jDialogTurnosLayout);
        jDialogTurnosLayout.setHorizontalGroup(
            jDialogTurnosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogTurnosLayout.createSequentialGroup()
                .addGroup(jDialogTurnosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jDialogTurnosLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jDialogTurnosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jDialogTurnosLayout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(10, 10, 10)
                        .addGroup(jDialogTurnosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCheckBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jDialogTurnosLayout.createSequentialGroup()
                        .addGap(125, 125, 125)
                        .addComponent(jBcancelarturno)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jBaceptarturno))
                    .addGroup(jDialogTurnosLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel42, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        jDialogTurnosLayout.setVerticalGroup(
            jDialogTurnosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogTurnosLayout.createSequentialGroup()
                .addGroup(jDialogTurnosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDialogTurnosLayout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jCheckBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialogTurnosLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jDialogTurnosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jDialogTurnosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jPanel16, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel15, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel42, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jDialogTurnosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBcancelarturno)
                    .addComponent(jBaceptarturno))
                .addGap(0, 32, Short.MAX_VALUE))
        );

        jPanel12.getAccessibleContext().setAccessibleName("");
        jPanel12.getAccessibleContext().setAccessibleDescription("");

        DialogPermisos.setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        DialogPermisos.setTitle("Nuevo Permiso");
        DialogPermisos.setIconImage(new ImageIcon(this.getClass().getResource("/ico/tactics.png")).getImage());
        DialogPermisos.setMinimumSize(new java.awt.Dimension(600, 500));
        DialogPermisos.setModal(true);

        jCalendar3.setMinimumSize(new java.awt.Dimension(200, 150));
        jCalendar3.setPreferredSize(new java.awt.Dimension(200, 150));

        jCalendar4.setMinimumSize(new java.awt.Dimension(200, 150));
        jCalendar4.setPreferredSize(new java.awt.Dimension(200, 150));

        jLabel4.setFont(new java.awt.Font("Dialog", 2, 12)); // NOI18N
        jLabel4.setText("Fecha de Inicio:");

        jLabel12.setFont(new java.awt.Font("Dialog", 2, 12)); // NOI18N
        jLabel12.setText("Fecha Final:");

        jLabel27.setFont(new java.awt.Font("Dialog", 2, 12)); // NOI18N
        jLabel27.setText("Tipo:");

        jComboBox5.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jComboBox5.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Llegar tarde", "Dobla turno", "Salir temprano", "No asistir (Sin goce de sueldo)", "No asistir (Con goce de sueldo)", "Vacaciones", "Sanción", "Incapacidad ", "Otro" }));
        jComboBox5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox5ActionPerformed(evt);
            }
        });

        jLabel28.setFont(new java.awt.Font("Dialog", 2, 12)); // NOI18N
        jLabel28.setText("Motivo:");

        jLabel29.setFont(new java.awt.Font("Dialog", 2, 12)); // NOI18N
        jLabel29.setText("Aplicar a:");

        jComboBox6.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jComboBox6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox6ActionPerformed(evt);
            }
        });

        jLabel30.setFont(new java.awt.Font("Dialog", 2, 12)); // NOI18N
        jLabel30.setText("Autorizado:");

        buttonGroup2.add(jRadioButton3);
        jRadioButton3.setText("SI");

        buttonGroup2.add(jRadioButton4);
        jRadioButton4.setText("No");
        jRadioButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton4ActionPerformed(evt);
            }
        });

        jButton18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ico/cancel.png"))); // NOI18N
        jButton18.setText("Cancelar");
        jButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton18ActionPerformed(evt);
            }
        });

        jButton28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ico/acep.png"))); // NOI18N
        jButton28.setText("Aceptar");
        jButton28.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton28ActionPerformed(evt);
            }
        });

        jLabel149.setText("Primer Turno:");

        jLabel150.setText("Segundo Turno:");

        jComboBox25.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jComboBox25.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox25.setPreferredSize(new java.awt.Dimension(56, 25));

        jComboBox26.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jComboBox26.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox26.setPreferredSize(new java.awt.Dimension(56, 25));

        javax.swing.GroupLayout jPanel54Layout = new javax.swing.GroupLayout(jPanel54);
        jPanel54.setLayout(jPanel54Layout);
        jPanel54Layout.setHorizontalGroup(
            jPanel54Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel54Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel54Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBox25, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel149))
                .addGap(32, 32, 32)
                .addGroup(jPanel54Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBox26, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel150))
                .addContainerGap(48, Short.MAX_VALUE))
        );
        jPanel54Layout.setVerticalGroup(
            jPanel54Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel54Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel54Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel149)
                    .addComponent(jLabel150))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel54Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout DialogPermisosLayout = new javax.swing.GroupLayout(DialogPermisos.getContentPane());
        DialogPermisos.getContentPane().setLayout(DialogPermisosLayout);
        DialogPermisosLayout.setHorizontalGroup(
            DialogPermisosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DialogPermisosLayout.createSequentialGroup()
                .addGroup(DialogPermisosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(DialogPermisosLayout.createSequentialGroup()
                        .addGap(189, 189, 189)
                        .addComponent(jButton18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton28))
                    .addGroup(DialogPermisosLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(DialogPermisosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel4)
                            .addComponent(jLabel12)
                            .addComponent(jCalendar4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jCalendar3, javax.swing.GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(DialogPermisosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(DialogPermisosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel28)
                                .addComponent(jTextField6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel30)
                            .addGroup(DialogPermisosLayout.createSequentialGroup()
                                .addComponent(jRadioButton3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jRadioButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel29)
                            .addComponent(jLabel27)
                            .addComponent(jComboBox5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel54, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox6, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        DialogPermisosLayout.setVerticalGroup(
            DialogPermisosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DialogPermisosLayout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(DialogPermisosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(DialogPermisosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(DialogPermisosLayout.createSequentialGroup()
                        .addComponent(jCalendar3, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCalendar4, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(DialogPermisosLayout.createSequentialGroup()
                        .addComponent(jComboBox5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel29)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jComboBox6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel54, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel28)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(jLabel30)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(DialogPermisosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jRadioButton3)
                            .addComponent(jRadioButton4))
                        .addGap(34, 34, 34)))
                .addGroup(DialogPermisosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton18)
                    .addComponent(jButton28))
                .addContainerGap())
        );

        jDialog4.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        jDialog4.setBackground(new java.awt.Color(255, 255, 255));
        jDialog4.setMinimumSize(new java.awt.Dimension(327, 215));
        jDialog4.setModal(true);
        jDialog4.setResizable(false);

        jLabel64.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel64.setText("Acceso Restringido ");

        jLabel10.setForeground(new java.awt.Color(255, 0, 0));

        jLabel65.setText("Contraseña:");

        jPasswordField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPasswordField1ActionPerformed(evt);
            }
        });
        jPasswordField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jPasswordField1KeyPressed(evt);
            }
        });

        jButton33.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ico/cancel.png"))); // NOI18N
        jButton33.setText("Cancelar");
        jButton33.setPreferredSize(new java.awt.Dimension(71, 23));
        jButton33.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton33ActionPerformed(evt);
            }
        });

        jButton32.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ico/acep.png"))); // NOI18N
        jButton32.setText("Aceptar");
        jButton32.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton32ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                        .addComponent(jLabel64)
                        .addGap(69, 69, 69))
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addComponent(jLabel65)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(jButton33, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton32)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addComponent(jLabel64)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel65)
                    .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton33, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton32, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jDialog4Layout = new javax.swing.GroupLayout(jDialog4.getContentPane());
        jDialog4.getContentPane().setLayout(jDialog4Layout);
        jDialog4Layout.setHorizontalGroup(
            jDialog4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jDialog4Layout.setVerticalGroup(
            jDialog4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jDialog5.setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        jDialog5.setMinimumSize(new java.awt.Dimension(800, 550));
        jDialog5.setModal(true);

        jPanel19.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder("Entrada"), "Entrada"));

        jCminutosentrada8.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "00", "05", "10", "15", "20", "25", "30", "35", "40", "45", "50", "55" }));
        jCminutosentrada8.setMaximumSize(new java.awt.Dimension(45, 20));
        jCminutosentrada8.setMinimumSize(new java.awt.Dimension(45, 20));
        jCminutosentrada8.setPreferredSize(new java.awt.Dimension(45, 20));

        jChorentrada8.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23" }));
        jChorentrada8.setMaximumSize(new java.awt.Dimension(45, 20));
        jChorentrada8.setMinimumSize(new java.awt.Dimension(45, 20));
        jChorentrada8.setPreferredSize(new java.awt.Dimension(45, 20));

        jLabel32.setText("Hora:");

        jLabel33.setText("Minutos:");

        jChorentrada9.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23" }));
        jChorentrada9.setMaximumSize(new java.awt.Dimension(45, 20));
        jChorentrada9.setMinimumSize(new java.awt.Dimension(45, 20));
        jChorentrada9.setPreferredSize(new java.awt.Dimension(45, 20));

        jCminutosentrada9.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "00", "05", "10", "15", "20", "25", "30", "35", "40", "45", "50", "55" }));
        jCminutosentrada9.setMaximumSize(new java.awt.Dimension(45, 20));
        jCminutosentrada9.setMinimumSize(new java.awt.Dimension(45, 20));
        jCminutosentrada9.setPreferredSize(new java.awt.Dimension(45, 20));

        jChorentrada10.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23" }));
        jChorentrada10.setMaximumSize(new java.awt.Dimension(45, 20));
        jChorentrada10.setMinimumSize(new java.awt.Dimension(45, 20));
        jChorentrada10.setPreferredSize(new java.awt.Dimension(45, 20));

        jChorentrada11.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23" }));
        jChorentrada11.setMaximumSize(new java.awt.Dimension(45, 20));
        jChorentrada11.setMinimumSize(new java.awt.Dimension(45, 20));
        jChorentrada11.setPreferredSize(new java.awt.Dimension(45, 20));

        jCminutosentrada10.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "00", "05", "10", "15", "20", "25", "30", "35", "40", "45", "50", "55" }));
        jCminutosentrada10.setMaximumSize(new java.awt.Dimension(45, 20));
        jCminutosentrada10.setMinimumSize(new java.awt.Dimension(45, 20));
        jCminutosentrada10.setPreferredSize(new java.awt.Dimension(45, 20));

        jCminutosentrada11.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "00", "05", "10", "15", "20", "25", "30", "35", "40", "45", "50", "55" }));
        jCminutosentrada11.setMaximumSize(new java.awt.Dimension(45, 20));
        jCminutosentrada11.setMinimumSize(new java.awt.Dimension(45, 20));
        jCminutosentrada11.setPreferredSize(new java.awt.Dimension(45, 20));

        jChorentrada12.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23" }));
        jChorentrada12.setMaximumSize(new java.awt.Dimension(45, 20));
        jChorentrada12.setMinimumSize(new java.awt.Dimension(45, 20));
        jChorentrada12.setPreferredSize(new java.awt.Dimension(45, 20));

        jChorentrada13.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23" }));
        jChorentrada13.setMaximumSize(new java.awt.Dimension(45, 20));
        jChorentrada13.setMinimumSize(new java.awt.Dimension(45, 20));
        jChorentrada13.setPreferredSize(new java.awt.Dimension(45, 20));

        jCminutosentrada12.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "00", "05", "10", "15", "20", "25", "30", "35", "40", "45", "50", "55" }));
        jCminutosentrada12.setMaximumSize(new java.awt.Dimension(45, 20));
        jCminutosentrada12.setMinimumSize(new java.awt.Dimension(45, 20));
        jCminutosentrada12.setPreferredSize(new java.awt.Dimension(45, 20));

        jCminutosentrada13.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "00", "05", "10", "15", "20", "25", "30", "35", "40", "45", "50", "55" }));
        jCminutosentrada13.setMaximumSize(new java.awt.Dimension(45, 20));
        jCminutosentrada13.setMinimumSize(new java.awt.Dimension(45, 20));
        jCminutosentrada13.setPreferredSize(new java.awt.Dimension(45, 20));

        jChorentrada14.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23" }));
        jChorentrada14.setMaximumSize(new java.awt.Dimension(45, 20));
        jChorentrada14.setMinimumSize(new java.awt.Dimension(45, 20));
        jChorentrada14.setPreferredSize(new java.awt.Dimension(45, 20));

        jCminutosentrada14.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "00", "05", "10", "15", "20", "25", "30", "35", "40", "45", "50", "55" }));
        jCminutosentrada14.setMaximumSize(new java.awt.Dimension(45, 20));
        jCminutosentrada14.setMinimumSize(new java.awt.Dimension(45, 20));
        jCminutosentrada14.setPreferredSize(new java.awt.Dimension(45, 20));

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addGap(0, 16, Short.MAX_VALUE)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addComponent(jChorentrada12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jCminutosentrada13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jChorentrada10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jChorentrada11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCminutosentrada10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCminutosentrada11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addComponent(jChorentrada9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jCminutosentrada9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel32)
                            .addComponent(jChorentrada8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel19Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel33))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel19Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jCminutosentrada8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addComponent(jChorentrada14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jCminutosentrada14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addComponent(jChorentrada13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jCminutosentrada12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel19Layout.createSequentialGroup()
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel32)
                    .addComponent(jLabel33))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCminutosentrada8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jChorentrada8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCminutosentrada9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jChorentrada9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCminutosentrada10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jChorentrada11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jChorentrada10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCminutosentrada11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jChorentrada13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCminutosentrada12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jChorentrada12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCminutosentrada13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jChorentrada14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCminutosentrada14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jLabel37.setText("Nombre:");

        jTextField10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField10ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel37)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jBcancelarturno1.setText("Cancelar");
        jBcancelarturno1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBcancelarturno1ActionPerformed(evt);
            }
        });

        jBaceptarturno1.setText("Aceptar");
        jBaceptarturno1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBaceptarturno1ActionPerformed(evt);
            }
        });

        jPanel21.setBorder(javax.swing.BorderFactory.createTitledBorder("Salida"));

        jLabel68.setText("Hora:");

        jLabel69.setText("Minutos:");

        jChorasalida7.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23" }));
        jChorasalida7.setMaximumSize(new java.awt.Dimension(45, 20));
        jChorasalida7.setMinimumSize(new java.awt.Dimension(45, 20));
        jChorasalida7.setPreferredSize(new java.awt.Dimension(45, 20));

        jCminutosalida7.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "00", "05", "10", "15", "20", "25", "30", "35", "40", "45", "50", "55" }));
        jCminutosalida7.setMaximumSize(new java.awt.Dimension(45, 20));
        jCminutosalida7.setMinimumSize(new java.awt.Dimension(45, 20));
        jCminutosalida7.setPreferredSize(new java.awt.Dimension(45, 20));

        jChorasalida8.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23" }));
        jChorasalida8.setMaximumSize(new java.awt.Dimension(45, 20));
        jChorasalida8.setMinimumSize(new java.awt.Dimension(45, 20));
        jChorasalida8.setPreferredSize(new java.awt.Dimension(45, 20));

        jCminutosalida8.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "00", "05", "10", "15", "20", "25", "30", "35", "40", "45", "50", "55" }));
        jCminutosalida8.setMaximumSize(new java.awt.Dimension(45, 20));
        jCminutosalida8.setMinimumSize(new java.awt.Dimension(45, 20));
        jCminutosalida8.setPreferredSize(new java.awt.Dimension(45, 20));

        jChorasalida9.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23" }));
        jChorasalida9.setMaximumSize(new java.awt.Dimension(45, 20));
        jChorasalida9.setMinimumSize(new java.awt.Dimension(45, 20));
        jChorasalida9.setPreferredSize(new java.awt.Dimension(45, 20));

        jCminutosalida9.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "00", "05", "10", "15", "20", "25", "30", "35", "40", "45", "50", "55" }));
        jCminutosalida9.setMaximumSize(new java.awt.Dimension(45, 20));
        jCminutosalida9.setMinimumSize(new java.awt.Dimension(45, 20));
        jCminutosalida9.setPreferredSize(new java.awt.Dimension(45, 20));

        jChorasalida10.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23" }));
        jChorasalida10.setMaximumSize(new java.awt.Dimension(45, 20));
        jChorasalida10.setMinimumSize(new java.awt.Dimension(45, 20));
        jChorasalida10.setPreferredSize(new java.awt.Dimension(45, 20));

        jCminutosalida10.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "00", "05", "10", "15", "20", "25", "30", "35", "40", "45", "50", "55" }));
        jCminutosalida10.setMaximumSize(new java.awt.Dimension(45, 20));
        jCminutosalida10.setMinimumSize(new java.awt.Dimension(45, 20));
        jCminutosalida10.setPreferredSize(new java.awt.Dimension(45, 20));

        jChorasalida11.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23" }));
        jChorasalida11.setMaximumSize(new java.awt.Dimension(45, 20));
        jChorasalida11.setMinimumSize(new java.awt.Dimension(45, 20));
        jChorasalida11.setPreferredSize(new java.awt.Dimension(45, 20));

        jCminutosalida11.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "00", "05", "10", "15", "20", "25", "30", "35", "40", "45", "50", "55" }));
        jCminutosalida11.setMaximumSize(new java.awt.Dimension(45, 20));
        jCminutosalida11.setMinimumSize(new java.awt.Dimension(45, 20));
        jCminutosalida11.setPreferredSize(new java.awt.Dimension(45, 20));

        jChorasalida12.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23" }));
        jChorasalida12.setMaximumSize(new java.awt.Dimension(45, 20));
        jChorasalida12.setMinimumSize(new java.awt.Dimension(45, 20));
        jChorasalida12.setPreferredSize(new java.awt.Dimension(45, 20));

        jCminutosalida12.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "00", "05", "10", "15", "20", "25", "30", "35", "40", "45", "50", "55" }));
        jCminutosalida12.setMaximumSize(new java.awt.Dimension(45, 20));
        jCminutosalida12.setMinimumSize(new java.awt.Dimension(45, 20));
        jCminutosalida12.setPreferredSize(new java.awt.Dimension(45, 20));

        jChorasalida13.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23" }));
        jChorasalida13.setMaximumSize(new java.awt.Dimension(45, 20));
        jChorasalida13.setMinimumSize(new java.awt.Dimension(45, 20));
        jChorasalida13.setPreferredSize(new java.awt.Dimension(45, 20));

        jCminutosalida13.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "00", "05", "10", "15", "20", "25", "30", "35", "40", "45", "50", "55" }));
        jCminutosalida13.setMaximumSize(new java.awt.Dimension(45, 20));
        jCminutosalida13.setMinimumSize(new java.awt.Dimension(45, 20));
        jCminutosalida13.setPreferredSize(new java.awt.Dimension(45, 20));

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addComponent(jChorasalida8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jCminutosalida8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addComponent(jChorasalida9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jCminutosalida9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addComponent(jChorasalida10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jCminutosalida10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addComponent(jChorasalida11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jCminutosalida11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addComponent(jChorasalida12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jCminutosalida12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addComponent(jChorasalida13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jCminutosalida13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jChorasalida7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel68))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel69)
                            .addComponent(jCminutosalida7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel21Layout.createSequentialGroup()
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel68)
                    .addComponent(jLabel69))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jChorasalida7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCminutosalida7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jChorasalida8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCminutosalida8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jChorasalida9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCminutosalida9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCminutosalida10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jChorasalida10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jChorasalida11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCminutosalida11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jChorasalida12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCminutosalida12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jChorasalida13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCminutosalida13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel22.setBorder(javax.swing.BorderFactory.createTitledBorder("Comida"));

        jLabel70.setText("Hora:");

        jLabel71.setText("Minutos:");

        tiempocomida1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23" }));
        tiempocomida1.setMaximumSize(new java.awt.Dimension(45, 20));
        tiempocomida1.setMinimumSize(new java.awt.Dimension(45, 20));
        tiempocomida1.setPreferredSize(new java.awt.Dimension(45, 20));
        tiempocomida1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tiempocomida1ActionPerformed(evt);
            }
        });

        mincomida3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "00", "05", "10", "15", "20", "25", "30", "35", "40", "45", "50", "55" }));
        mincomida3.setMaximumSize(new java.awt.Dimension(45, 20));
        mincomida3.setMinimumSize(new java.awt.Dimension(45, 20));
        mincomida3.setPreferredSize(new java.awt.Dimension(45, 20));

        jLabel38.setText("Tiempo");

        mincomida4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "00", "05", "10", "15", "20", "25", "30", "35", "40", "45", "50", "55" }));
        mincomida4.setMaximumSize(new java.awt.Dimension(45, 20));
        mincomida4.setMinimumSize(new java.awt.Dimension(45, 20));
        mincomida4.setPreferredSize(new java.awt.Dimension(45, 20));

        jLabel72.setText("Minutos:");

        jCheckBox12.setText("Libre");
        jCheckBox12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox12ActionPerformed(evt);
            }
        });

        jLabel40.setText("Hora de inicio");

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel22Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel22Layout.createSequentialGroup()
                                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tiempocomida1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel70))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel71)
                                    .addComponent(mincomida3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jCheckBox12)))
                    .addGroup(jPanel22Layout.createSequentialGroup()
                        .addComponent(jLabel72)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(mincomida4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel22Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(jLabel38)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jLabel40)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addComponent(jLabel38)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel72)
                    .addComponent(mincomida4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel40)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jCheckBox12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel70)
                    .addComponent(jLabel71))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tiempocomida1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mincomida3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jCheckBox13.setSelected(true);
        jCheckBox13.setText("Derecho a Comida");
        jCheckBox13.setMaximumSize(new java.awt.Dimension(830, 24));
        jCheckBox13.setMinimumSize(new java.awt.Dimension(830, 24));
        jCheckBox13.setPreferredSize(new java.awt.Dimension(830, 24));
        jCheckBox13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox13ActionPerformed(evt);
            }
        });

        jPanel23.setBorder(javax.swing.BorderFactory.createTitledBorder("Dia"));

        jCheckBox14.setSelected(true);
        jCheckBox14.setText("Lunes");

        jCheckBox15.setSelected(true);
        jCheckBox15.setText("Martes");

        jCheckBox16.setSelected(true);
        jCheckBox16.setText("Miercoles");

        jCheckBox17.setSelected(true);
        jCheckBox17.setText("Sabado");

        jCheckBox18.setSelected(true);
        jCheckBox18.setText("Viernes");

        jCheckBox19.setSelected(true);
        jCheckBox19.setText("Jueves");

        jCheckBox20.setSelected(true);
        jCheckBox20.setText("Domingo");

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckBox14)
                    .addComponent(jCheckBox15)
                    .addComponent(jCheckBox16)
                    .addComponent(jCheckBox19)
                    .addComponent(jCheckBox18)
                    .addComponent(jCheckBox17)
                    .addComponent(jCheckBox20)))
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jCheckBox14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jCheckBox15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jCheckBox16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jCheckBox19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jCheckBox18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jCheckBox17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jCheckBox20)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jCheckBox21.setText("Entrada Libre");
        jCheckBox21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox21ActionPerformed(evt);
            }
        });

        jCheckBox22.setText("Salida Libre");
        jCheckBox22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox22ActionPerformed(evt);
            }
        });

        jPanel24.setBorder(javax.swing.BorderFactory.createTitledBorder("Tolerancia"));

        jLabel73.setText("Tolerancia:");

        jLabel74.setText("Minutos:");

        mincomida5.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "00", "05", "10", "15", "20", "25", "30", "35", "40", "45", "50", "55" }));
        mincomida5.setMaximumSize(new java.awt.Dimension(45, 20));
        mincomida5.setMinimumSize(new java.awt.Dimension(45, 20));
        mincomida5.setPreferredSize(new java.awt.Dimension(45, 20));

        jLabel75.setText("Falta:");

        jLabel76.setText("Minutos:");

        jCminutosentrada15.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "00", "05", "10", "15", "20", "25", "30", "35", "40", "45", "50", "55" }));
        jCminutosentrada15.setMaximumSize(new java.awt.Dimension(45, 20));
        jCminutosentrada15.setMinimumSize(new java.awt.Dimension(45, 20));
        jCminutosentrada15.setPreferredSize(new java.awt.Dimension(45, 20));

        jChorentrada15.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "00", "01", "02", "03", "04", "05" }));
        jChorentrada15.setMaximumSize(new java.awt.Dimension(45, 20));
        jChorentrada15.setMinimumSize(new java.awt.Dimension(45, 20));
        jChorentrada15.setPreferredSize(new java.awt.Dimension(45, 20));

        jLabel77.setText("Hora:");

        javax.swing.GroupLayout jPanel24Layout = new javax.swing.GroupLayout(jPanel24);
        jPanel24.setLayout(jPanel24Layout);
        jPanel24Layout.setHorizontalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel73)
                    .addComponent(jLabel75))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel24Layout.createSequentialGroup()
                        .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jChorentrada15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel77))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel76)
                            .addComponent(jCminutosentrada15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(mincomida5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel74))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        jPanel24Layout.setVerticalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addComponent(jLabel73)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addComponent(jLabel74)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mincomida5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel77)
                    .addComponent(jLabel76)
                    .addComponent(jLabel75))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCminutosentrada15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jChorentrada15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jDialog5Layout = new javax.swing.GroupLayout(jDialog5.getContentPane());
        jDialog5.getContentPane().setLayout(jDialog5Layout);
        jDialog5Layout.setHorizontalGroup(
            jDialog5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog5Layout.createSequentialGroup()
                .addGroup(jDialog5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jDialog5Layout.createSequentialGroup()
                        .addGap(182, 182, 182)
                        .addComponent(jBcancelarturno1)
                        .addGap(18, 18, 18)
                        .addComponent(jBaceptarturno1))
                    .addGroup(jDialog5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jDialog5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCheckBox21))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jDialog5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCheckBox22)
                            .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jDialog5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCheckBox13, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jDialog5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(161, Short.MAX_VALUE))
        );
        jDialog5Layout.setVerticalGroup(
            jDialog5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addGroup(jDialog5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBox13, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBox21)
                    .addComponent(jCheckBox22))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jDialog5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel24, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addGroup(jDialog5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBcancelarturno1)
                    .addComponent(jBaceptarturno1))
                .addContainerGap())
        );

        jDialog6.setMinimumSize(new java.awt.Dimension(574, 373));

        jTextField11.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Motivo", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        jComboBox18.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Llegar tarde", "Retardos acumulados", "Falta a trabajar", "Falta Administrativa", "Otro" }));

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Detalles", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        jScrollPane14.setViewportView(jTextArea1);

        jButton46.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ico/cancel.png"))); // NOI18N
        jButton46.setText("Cancelar");
        jButton46.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton46ActionPerformed(evt);
            }
        });

        jButton47.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ico/acep.png"))); // NOI18N
        jButton47.setText("Aceptar");
        jButton47.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton47ActionPerformed(evt);
            }
        });

        jFormattedTextField7.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Hora", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        try {
            jFormattedTextField7.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jFormattedTextField7.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jFormattedTextField7.setToolTipText("");
        jFormattedTextField7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFormattedTextField7ActionPerformed(evt);
            }
        });

        jComboBox3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel13.setText("Aplica a:");

        jTextField29.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Gravante $$", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        javax.swing.GroupLayout jDialog6Layout = new javax.swing.GroupLayout(jDialog6.getContentPane());
        jDialog6.getContentPane().setLayout(jDialog6Layout);
        jDialog6Layout.setHorizontalGroup(
            jDialog6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jDialog6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDialog6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jCalendar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jDialog6Layout.createSequentialGroup()
                            .addGap(23, 23, 23)
                            .addComponent(jFormattedTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jComboBox3, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jDialog6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane14)
                    .addGroup(jDialog6Layout.createSequentialGroup()
                        .addGroup(jDialog6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField11)
                            .addComponent(jComboBox18, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(8, 8, 8)
                        .addComponent(jTextField29)))
                .addContainerGap())
            .addGroup(jDialog6Layout.createSequentialGroup()
                .addGap(170, 170, 170)
                .addComponent(jButton46)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton47)
                .addContainerGap(180, Short.MAX_VALUE))
        );
        jDialog6Layout.setVerticalGroup(
            jDialog6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialog6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jDialog6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jDialog6Layout.createSequentialGroup()
                        .addComponent(jComboBox18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jDialog6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jDialog6Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addComponent(jCalendar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jFormattedTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jDialog6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton46)
                    .addComponent(jButton47))
                .addContainerGap())
        );

        jDialog7.setMinimumSize(new java.awt.Dimension(651, 390));
        jDialog7.setModal(true);
        jDialog7.setResizable(false);
        jDialog7.setSize(new java.awt.Dimension(651, 390));

        jButton59.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ico/acep.png"))); // NOI18N
        jButton59.setText("Aceptar");
        jButton59.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton59ActionPerformed(evt);
            }
        });

        jButton60.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ico/cancel.png"))); // NOI18N
        jButton60.setText("Cancelar");
        jButton60.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton60ActionPerformed(evt);
            }
        });

        jLabel86.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel86.setText("DEL :");

        jLabel102.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel102.setText("AL :");

        jLabel105.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel105.setText("Nombre del Personal :");

        jLabel106.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel106.setText("Consultar Asistencias de :");

        javax.swing.GroupLayout jDialog7Layout = new javax.swing.GroupLayout(jDialog7.getContentPane());
        jDialog7.getContentPane().setLayout(jDialog7Layout);
        jDialog7Layout.setHorizontalGroup(
            jDialog7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog7Layout.createSequentialGroup()
                .addGroup(jDialog7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDialog7Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel106)
                        .addGap(26, 26, 26)
                        .addComponent(jLabel105))
                    .addGroup(jDialog7Layout.createSequentialGroup()
                        .addGap(136, 136, 136)
                        .addComponent(jLabel86)
                        .addGap(299, 299, 299)
                        .addComponent(jLabel102))
                    .addGroup(jDialog7Layout.createSequentialGroup()
                        .addGroup(jDialog7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jDialog7Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jCalendar5, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jDialog7Layout.createSequentialGroup()
                                .addGap(191, 191, 191)
                                .addComponent(jButton60)))
                        .addGap(18, 18, 18)
                        .addGroup(jDialog7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jDialog7Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jButton59))
                            .addComponent(jCalendar2, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jDialog7Layout.setVerticalGroup(
            jDialog7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialog7Layout.createSequentialGroup()
                .addGap(0, 33, Short.MAX_VALUE)
                .addGroup(jDialog7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDialog7Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel106))
                    .addComponent(jLabel105))
                .addGap(6, 6, 6)
                .addGroup(jDialog7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel102)
                    .addComponent(jLabel86))
                .addGap(6, 6, 6)
                .addGroup(jDialog7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCalendar5, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCalendar2, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jDialog7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton59)
                    .addComponent(jButton60))
                .addContainerGap())
        );

        jDialogConceptos.setMinimumSize(new java.awt.Dimension(270, 325));
        jDialogConceptos.setModal(true);

        jPanel50.setBackground(new java.awt.Color(255, 255, 255));
        jPanel50.setMaximumSize(new java.awt.Dimension(270, 325));
        jPanel50.setMinimumSize(new java.awt.Dimension(270, 325));
        jPanel50.setName(""); // NOI18N
        jPanel50.setPreferredSize(new java.awt.Dimension(270, 325));

        jLabel113.setText("Concepto:");

        jTextField27.setText("Ejemplo");

        jRadioButton9.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup3.add(jRadioButton9);
        jRadioButton9.setSelected(true);
        jRadioButton9.setText("Percepcion");
        jRadioButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton9ActionPerformed(evt);
            }
        });

        jRadioButton8.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup3.add(jRadioButton8);
        jRadioButton8.setText("Deduccion");

        jButton70.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ico/cancel.png"))); // NOI18N
        jButton70.setText("Cancelar");
        jButton70.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton70ActionPerformed(evt);
            }
        });

        jButton71.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ico/acep.png"))); // NOI18N
        jButton71.setText("Aceptar");
        jButton71.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton71ActionPerformed(evt);
            }
        });

        jLabel114.setText("Metodo: ");

        jComboBox19.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Importe", "Porcentual", "Ajuste" }));
        jComboBox19.setMinimumSize(new java.awt.Dimension(76, 30));
        jComboBox19.setPreferredSize(new java.awt.Dimension(76, 30));

        jLabel115.setText("Valor:");

        jFormattedTextField17.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        jFormattedTextField17.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jFormattedTextField17.setText("0");
        jFormattedTextField17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFormattedTextField17ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel50Layout = new javax.swing.GroupLayout(jPanel50);
        jPanel50.setLayout(jPanel50Layout);
        jPanel50Layout.setHorizontalGroup(
            jPanel50Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel50Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel50Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel50Layout.createSequentialGroup()
                        .addGroup(jPanel50Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel114)
                            .addComponent(jLabel115))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel50Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBox19, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel50Layout.createSequentialGroup()
                                .addComponent(jFormattedTextField17, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel50Layout.createSequentialGroup()
                        .addComponent(jLabel113)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField27)))
                .addGap(23, 23, 23))
            .addGroup(jPanel50Layout.createSequentialGroup()
                .addGroup(jPanel50Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel50Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jRadioButton9)
                        .addGap(18, 18, 18)
                        .addComponent(jRadioButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel50Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton70)
                        .addGap(18, 18, 18)
                        .addComponent(jButton71)))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        jPanel50Layout.setVerticalGroup(
            jPanel50Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel50Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel50Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel113)
                    .addComponent(jTextField27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel50Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton9)
                    .addComponent(jRadioButton8))
                .addGap(18, 18, 18)
                .addGroup(jPanel50Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel114)
                    .addComponent(jComboBox19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel50Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel115)
                    .addComponent(jFormattedTextField17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 75, Short.MAX_VALUE)
                .addGroup(jPanel50Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton70)
                    .addComponent(jButton71))
                .addGap(55, 55, 55))
        );

        javax.swing.GroupLayout jDialogConceptosLayout = new javax.swing.GroupLayout(jDialogConceptos.getContentPane());
        jDialogConceptos.getContentPane().setLayout(jDialogConceptosLayout);
        jDialogConceptosLayout.setHorizontalGroup(
            jDialogConceptosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel50, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jDialogConceptosLayout.setVerticalGroup(
            jDialogConceptosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel50, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jDialog10.setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        jDialog10.setMinimumSize(new java.awt.Dimension(651, 367));
        jDialog10.setModal(true);

        jCalendar8.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Al:", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 0, 14))); // NOI18N

        jCalendar9.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Del:", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 0, 14))); // NOI18N

        jBcancelarturno2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ico/cancel.png"))); // NOI18N
        jBcancelarturno2.setText("Cancelar");
        jBcancelarturno2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBcancelarturno2ActionPerformed(evt);
            }
        });

        jBaceptarturno2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ico/acep.png"))); // NOI18N
        jBaceptarturno2.setText("Aceptar");
        jBaceptarturno2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBaceptarturno2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jDialog10Layout = new javax.swing.GroupLayout(jDialog10.getContentPane());
        jDialog10.getContentPane().setLayout(jDialog10Layout);
        jDialog10Layout.setHorizontalGroup(
            jDialog10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog10Layout.createSequentialGroup()
                .addGroup(jDialog10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDialog10Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jCalendar9, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jCalendar8, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jDialog10Layout.createSequentialGroup()
                        .addGap(207, 207, 207)
                        .addComponent(jBcancelarturno2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jBaceptarturno2)))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        jDialog10Layout.setVerticalGroup(
            jDialog10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog10Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jDialog10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCalendar8, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCalendar9, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jDialog10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBcancelarturno2)
                    .addComponent(jBaceptarturno2))
                .addContainerGap(43, Short.MAX_VALUE))
        );

        jDialog3.setMinimumSize(new java.awt.Dimension(621, 459));
        jDialog3.setModal(true);
        jDialog3.setSize(new java.awt.Dimension(621, 459));

        jPanel59.setMaximumSize(new java.awt.Dimension(621, 459));
        jPanel59.setMinimumSize(new java.awt.Dimension(621, 459));
        jPanel59.setPreferredSize(new java.awt.Dimension(621, 459));

        jLabel151.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel151.setText("Generar:");

        jComboBox27.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jComboBox27.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NOMINAS", "REPORTES DE PERSONAS", "REPORTES DE TURNOS", "MENSAJES PARA EMPLEADOS", "AVISO O ALERTA " }));
        jComboBox27.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox27ActionPerformed(evt);
            }
        });

        jPanel61.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jPanel60.setLayout(new java.awt.GridLayout(0, 1));
        jScrollPane23.setViewportView(jPanel60);

        jCheckBox9.setText("Todos");
        jCheckBox9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox9ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel61Layout = new javax.swing.GroupLayout(jPanel61);
        jPanel61.setLayout(jPanel61Layout);
        jPanel61Layout.setHorizontalGroup(
            jPanel61Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jCheckBox9)
            .addComponent(jScrollPane23, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel61Layout.setVerticalGroup(
            jPanel61Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel61Layout.createSequentialGroup()
                .addComponent(jCheckBox9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane23, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jBcancelarturno3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ico/cancel.png"))); // NOI18N
        jBcancelarturno3.setText("Cancelar");
        jBcancelarturno3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBcancelarturno3ActionPerformed(evt);
            }
        });

        jBaceptarturno3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ico/acep.png"))); // NOI18N
        jBaceptarturno3.setText("Aceptar");
        jBaceptarturno3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBaceptarturno3ActionPerformed(evt);
            }
        });

        jButton85.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton85.setText("Carpeta de Destino");
        jButton85.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton85ActionPerformed(evt);
            }
        });

        jTextField28.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jPanel53.setBorder(javax.swing.BorderFactory.createTitledBorder("Dias:"));

        jCheckBox10.setText("Martes");
        jCheckBox10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox10ActionPerformed(evt);
            }
        });

        jCheckBox11.setText("Lunes");

        jCheckBox23.setText("Miercoles");

        jCheckBox24.setText("Viernes");

        jCheckBox25.setText("Jueves");

        jCheckBox26.setText("Sabado");

        jCheckBox27.setText("Domingo");

        javax.swing.GroupLayout jPanel53Layout = new javax.swing.GroupLayout(jPanel53);
        jPanel53.setLayout(jPanel53Layout);
        jPanel53Layout.setHorizontalGroup(
            jPanel53Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jCheckBox26)
            .addComponent(jCheckBox24)
            .addComponent(jCheckBox25)
            .addComponent(jCheckBox23)
            .addComponent(jCheckBox11)
            .addComponent(jCheckBox10)
            .addComponent(jCheckBox27)
        );
        jPanel53Layout.setVerticalGroup(
            jPanel53Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel53Layout.createSequentialGroup()
                .addComponent(jCheckBox11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox23)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox25)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox24)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox26)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox27)
                .addContainerGap(98, Short.MAX_VALUE))
        );

        jPanel62.setBorder(javax.swing.BorderFactory.createTitledBorder("Hora:"));

        jComboBox14.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "12:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00", "19:00", "20:00", "21:00", "22:00", "23:00", "00:00", "01:00", "02:00", "03:00", "04:00", "05:00", "06:00", "07:00", "08:00", "09:00", "10:00", "11:00", " " }));

        javax.swing.GroupLayout jPanel62Layout = new javax.swing.GroupLayout(jPanel62);
        jPanel62.setLayout(jPanel62Layout);
        jPanel62Layout.setHorizontalGroup(
            jPanel62Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jComboBox14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel62Layout.setVerticalGroup(
            jPanel62Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel62Layout.createSequentialGroup()
                .addComponent(jComboBox14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 9, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel59Layout = new javax.swing.GroupLayout(jPanel59);
        jPanel59.setLayout(jPanel59Layout);
        jPanel59Layout.setHorizontalGroup(
            jPanel59Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel59Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextField28)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton85)
                .addGap(37, 37, 37))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel59Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBcancelarturno3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBaceptarturno3)
                .addGap(174, 174, 174))
            .addGroup(jPanel59Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel59Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel61, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel59Layout.createSequentialGroup()
                        .addComponent(jLabel151)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jComboBox27, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel53, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel62, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(63, Short.MAX_VALUE))
        );
        jPanel59Layout.setVerticalGroup(
            jPanel59Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel59Layout.createSequentialGroup()
                .addGroup(jPanel59Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel59Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(jPanel59Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel53, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel62, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel59Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel59Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel151)
                            .addComponent(jComboBox27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel61, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel59Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton85)
                    .addComponent(jTextField28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel59Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBcancelarturno3)
                    .addComponent(jBaceptarturno3))
                .addContainerGap(53, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jDialog3Layout = new javax.swing.GroupLayout(jDialog3.getContentPane());
        jDialog3.getContentPane().setLayout(jDialog3Layout);
        jDialog3Layout.setHorizontalGroup(
            jDialog3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel59, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jDialog3Layout.setVerticalGroup(
            jDialog3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel59, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("CHECKA  V2.0.0");
        setMaximumSize(new java.awt.Dimension(1392, 746));
        setMinimumSize(new java.awt.Dimension(1392, 746));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowIconified(java.awt.event.WindowEvent evt) {
                formWindowIconified(evt);
            }
        });

        jTabbedPane1.setBackground(new java.awt.Color(51, 51, 255));
        jTabbedPane1.setToolTipText("");
        jTabbedPane1.setEnabled(false);
        jTabbedPane1.setFocusable(false);
        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTabbedPane1.setOpaque(true);
        jTabbedPane1.setPreferredSize(new java.awt.Dimension(1300, 733));
        jTabbedPane1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTabbedPane1FocusGained(evt);
            }
        });
        jTabbedPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPane1MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTabbedPane1MousePressed(evt);
            }
        });

        jPanel36.setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jScrollPane4KeyPressed(evt);
            }
        });

        jTable5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTable5.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "PERSONAL", "ENTRADA", "E.COMIDA", "S.COMIDA", "SALIDA"
            }
        ));
        jTable5.setGridColor(new java.awt.Color(51, 51, 51));
        jTable5.setRowHeight(30);
        jTable5.setSelectionBackground(new java.awt.Color(51, 51, 255));
        jTable5.setSelectionForeground(new java.awt.Color(51, 51, 255));
        jTable5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTable5KeyPressed(evt);
            }
        });
        jScrollPane4.setViewportView(jTable5);

        jButton9.setBackground(new java.awt.Color(255, 255, 255));
        jButton9.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ico/acep.png"))); // NOI18N
        jButton9.setText("<html>     CHECAR</html>");
        jButton9.setToolTipText("");
        jButton9.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jButton9.setEnabled(false);
        jButton9.setHideActionText(true);
        jButton9.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jButton9.setMargin(new java.awt.Insets(1, 14, 12, 14));
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jTextField4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField4.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createTitledBorder(null, "ID Personal", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION), javax.swing.BorderFactory.createEtchedBorder()));
        jTextField4.setEnabled(false);
        jTextField4.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField4FocusGained(evt);
            }
        });
        jTextField4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTextField4MousePressed(evt);
            }
        });
        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });
        jTextField4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField4KeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField4KeyTyped(evt);
            }
        });

        fechalabel.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        fechalabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fechalabel.setText("**/**/**");

        lbHora.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 48)); // NOI18N
        lbHora.setText("19:38");
        lbHora.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jButton34.setForeground(java.awt.Color.red);
        jButton34.setText("CANCELAR");
        jButton34.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton34ActionPerformed(evt);
            }
        });

        jPanel37.setBackground(new java.awt.Color(255, 255, 255));

        jLabel24.setBackground(new java.awt.Color(0, 0, 0));
        jLabel24.setMaximumSize(new java.awt.Dimension(2, 2));
        jLabel24.setMinimumSize(new java.awt.Dimension(2, 2));

        jLabel20.setBackground(new java.awt.Color(0, 0, 0));
        jLabel20.setMaximumSize(new java.awt.Dimension(2, 2));
        jLabel20.setMinimumSize(new java.awt.Dimension(2, 2));

        jLabel23.setBackground(new java.awt.Color(0, 0, 0));
        jLabel23.setMaximumSize(new java.awt.Dimension(2, 2));
        jLabel23.setMinimumSize(new java.awt.Dimension(2, 2));

        jLabel22.setBackground(new java.awt.Color(0, 0, 0));
        jLabel22.setMaximumSize(new java.awt.Dimension(2, 2));
        jLabel22.setMinimumSize(new java.awt.Dimension(2, 2));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Dialog", 2, 12)); // NOI18N
        jLabel2.setOpaque(true);

        javax.swing.GroupLayout jPanel37Layout = new javax.swing.GroupLayout(jPanel37);
        jPanel37.setLayout(jPanel37Layout);
        jPanel37Layout.setHorizontalGroup(
            jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel37Layout.createSequentialGroup()
                .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel37Layout.createSequentialGroup()
                        .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel37Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
            .addGroup(jPanel37Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel67, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jPanel37Layout.setVerticalGroup(
            jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel37Layout.createSequentialGroup()
                .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel37Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(jLabel67, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ico/ca1.png"))); // NOI18N
        jLabel9.setToolTipText("");
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLabel9MouseReleased(evt);
            }
        });

        jLabel26.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 0, 0));
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel26.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel147.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel147.setText(" --°");

        jLabel148.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ico/039-sun.png"))); // NOI18N
        jLabel148.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel148MouseClicked(evt);
            }
        });

        jProgressBar1.setMaximum(0);
        jProgressBar1.setToolTipText("");
        jProgressBar1.setOpaque(true);

        javax.swing.GroupLayout jPanel36Layout = new javax.swing.GroupLayout(jPanel36);
        jPanel36.setLayout(jPanel36Layout);
        jPanel36Layout.setHorizontalGroup(
            jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel36Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField4)
                    .addComponent(jButton9)
                    .addGroup(jPanel36Layout.createSequentialGroup()
                        .addComponent(jLabel148)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel147))
                    .addGroup(jPanel36Layout.createSequentialGroup()
                        .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lbHora, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(fechalabel, javax.swing.GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
                            .addGroup(jPanel36Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jPanel37, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel36Layout.createSequentialGroup()
                        .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel26, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 570, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jProgressBar1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 570, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(226, 226, 226)
                        .addComponent(jButton34, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(jLabel9))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 1174, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );
        jPanel36Layout.setVerticalGroup(
            jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel36Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel36Layout.createSequentialGroup()
                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(67, 67, 67)
                        .addComponent(jPanel37, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel148)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel36Layout.createSequentialGroup()
                                .addComponent(jLabel147)
                                .addGap(26, 26, 26)))
                        .addComponent(lbHora)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fechalabel))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 583, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel36Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jButton34)
                        .addContainerGap(16, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel36Layout.createSequentialGroup()
                        .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel36Layout.createSequentialGroup()
                                .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        jTabbedPane1.addTab("Checador", new javax.swing.ImageIcon(getClass().getResource("/ico/clock.png")), jPanel36); // NOI18N

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        jButton19.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jButton19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ico/buscar.png"))); // NOI18N
        jButton19.setText("<html><br><br><br><br>CONSULTAR</html>");
        jButton19.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton19.setMargin(new java.awt.Insets(2, 14, 12, 14));
        jButton19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton19ActionPerformed(evt);
            }
        });

        jLabel42.setBackground(new java.awt.Color(255, 157, 157));
        jLabel42.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel42.setText("Total de Retardos :");
        jLabel42.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel42.setMaximumSize(new java.awt.Dimension(129, 17));
        jLabel42.setMinimumSize(new java.awt.Dimension(129, 17));
        jLabel42.setOpaque(true);
        jLabel42.setPreferredSize(new java.awt.Dimension(129, 17));

        jLabel43.setBackground(new java.awt.Color(255, 255, 153));
        jLabel43.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel43.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel43.setText("Total de Tolerancias :");
        jLabel43.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel43.setOpaque(true);

        labetolerancia.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labetolerancia.setText("0");

        laberetardos.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        laberetardos.setText("0");

        jLabel44.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel44.setText("Total de Horas:");

        labetotalhoras.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        labetotalhoras.setText("00:00");
        labetotalhoras.setToolTipText("");

        jda.setBackground(new java.awt.Color(255, 255, 255));
        jda.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Fecha final :", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        jda.setMaximumSize(new java.awt.Dimension(196, 180));
        jda.setPreferredSize(new java.awt.Dimension(196, 180));

        jdde.setBackground(new java.awt.Color(255, 255, 255));
        jdde.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Fecha de inicio :", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        jdde.setMaximumSize(new java.awt.Dimension(196, 180));
        jdde.setMinSelectableDate(new java.util.Date(-62135744335000L));
        jdde.setPreferredSize(new java.awt.Dimension(196, 180));

        jComboBox1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jRadioButton1.setBackground(new java.awt.Color(255, 255, 255));
        treport.add(jRadioButton1);
        jRadioButton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jRadioButton1.setText("Por turno:");
        jRadioButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioButton1MouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jRadioButton1MouseReleased(evt);
            }
        });
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });

        jRadioButton2.setBackground(new java.awt.Color(255, 255, 255));
        treport.add(jRadioButton2);
        jRadioButton2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jRadioButton2.setSelected(true);
        jRadioButton2.setText("Por personal:");
        jRadioButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioButton2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jRadioButton2MouseEntered(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jRadioButton2MouseReleased(evt);
            }
        });
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });

        jButton21.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jButton21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ico/exportar.png"))); // NOI18N
        jButton21.setText("<html><br><br><br><br>EXPORTAR</html>");
        jButton21.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton21.setMargin(new java.awt.Insets(2, 14, 12, 14));
        jButton21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton21ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Seleccionar un parametro:");

        jButton12.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jButton12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ico/resumir.png"))); // NOI18N
        jButton12.setText("<html><br><br><br><br>RESUMEN</html>");
        jButton12.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton12.setMargin(new java.awt.Insets(2, 14, 12, 14));
        jButton12.setPreferredSize(new java.awt.Dimension(89, 93));
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        jButton58.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jButton58.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ico/nomi.png"))); // NOI18N
        jButton58.setText("<html><br><br><br><br>Hacer Nomina</html>");
        jButton58.setEnabled(false);
        jButton58.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton58.setMargin(new java.awt.Insets(2, 2, 12, 2));
        jButton58.setPreferredSize(new java.awt.Dimension(89, 93));

        jTabbedPane5.setBackground(new java.awt.Color(0, 204, 204));
        jTabbedPane5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTabbedPane5.setVerifyInputWhenFocusTarget(false);

        jTable13.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTable13.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "FECHA", "ENTRADA", "EN.COMIDA", "SA.COMIDA", "SALIDA", "T.COMIDA", "T.LABORADO", "TURNO"
            }
        ));
        jTable13.setRowHeight(35);
        jTable13.setSelectionForeground(new java.awt.Color(51, 51, 255));
        jScrollPane9.setViewportView(jTable13);

        javax.swing.GroupLayout jPanel55Layout = new javax.swing.GroupLayout(jPanel55);
        jPanel55.setLayout(jPanel55Layout);
        jPanel55Layout.setHorizontalGroup(
            jPanel55Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel55Layout.createSequentialGroup()
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 1107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel55Layout.setVerticalGroup(
            jPanel55Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane9, javax.swing.GroupLayout.DEFAULT_SIZE, 532, Short.MAX_VALUE)
        );

        jTabbedPane5.addTab("Asistencias", new javax.swing.ImageIcon(getClass().getResource("/ico/cehcador_micro.png")), jPanel55); // NOI18N

        jTable18.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jTable18.setModel(modelosinerror);
        jTable18.setRowHeight(25);
        jTable18.setSelectionForeground(new java.awt.Color(51, 51, 255));
        jScrollPane21.setViewportView(jTable18);

        javax.swing.GroupLayout jPanel56Layout = new javax.swing.GroupLayout(jPanel56);
        jPanel56.setLayout(jPanel56Layout);
        jPanel56Layout.setHorizontalGroup(
            jPanel56Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel56Layout.createSequentialGroup()
                .addComponent(jScrollPane21, javax.swing.GroupLayout.PREFERRED_SIZE, 1120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel56Layout.setVerticalGroup(
            jPanel56Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane21)
        );

        jTabbedPane5.addTab("Permisos", new javax.swing.ImageIcon(getClass().getResource("/ico/tactics_micro.png")), jPanel56); // NOI18N

        javax.swing.GroupLayout jPanel57Layout = new javax.swing.GroupLayout(jPanel57);
        jPanel57.setLayout(jPanel57Layout);
        jPanel57Layout.setHorizontalGroup(
            jPanel57Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1112, Short.MAX_VALUE)
        );
        jPanel57Layout.setVerticalGroup(
            jPanel57Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 532, Short.MAX_VALUE)
        );

        jTabbedPane5.addTab("Faltas", new javax.swing.ImageIcon(getClass().getResource("/ico/falta_micro.png")), jPanel57); // NOI18N

        jLabel31.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel31.setText("00:00");

        buttonGrouporden.add(jRadioButton11);
        jRadioButton11.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        jRadioButton11.setText("Orden Fecha");

        buttonGrouporden.add(jRadioButton12);
        jRadioButton12.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        jRadioButton12.setText("Orden Personal");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jdde, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jda, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jRadioButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addGap(93, 93, 93)
                                        .addComponent(jRadioButton2)))
                                .addGap(18, 18, 18))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jButton21)
                                            .addComponent(jButton58, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jButton19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(jLabel1)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addGap(14, 14, 14)
                                        .addComponent(jRadioButton11)
                                        .addGap(4, 4, 4)
                                        .addComponent(jRadioButton12)))
                                .addGap(26, 26, 26)))
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(laberetardos)
                                        .addGap(183, 183, 183))
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addComponent(jLabel43)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(labetolerancia)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel44)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel31)
                                    .addComponent(labetotalhoras)))
                            .addComponent(jTabbedPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 1117, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 0, 0))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jRadioButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jRadioButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jRadioButton11)
                            .addComponent(jRadioButton12))
                        .addGap(8, 8, 8)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jdde, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jda, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton19, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton21, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jTabbedPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 571, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel43)
                            .addComponent(labetolerancia)
                            .addComponent(labetotalhoras)
                            .addComponent(jLabel44))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(laberetardos)
                            .addComponent(jLabel31)))
                    .addComponent(jButton58, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0))
        );

        jTabbedPane5.getAccessibleContext().setAccessibleName("Permisos");

        jTabbedPane1.addTab("Consultar", new javax.swing.ImageIcon(getClass().getResource("/ico/binoculars.png")), jPanel5, ""); // NOI18N

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));

        jTable4.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jTable4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "FOLIO", "FECHA INICIO", "FECHA FINAL", "SOLICITANTE", "TIPO", "MOTIVO", "AUTORIZADO"
            }
        ));
        jTable4.setRowHeight(30);
        jTable4.setSelectionForeground(new java.awt.Color(51, 51, 255));
        jScrollPane5.setViewportView(jTable4);

        jButton4.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ico/agregar.png"))); // NOI18N
        jButton4.setText("<html><br><br><br><br>AGREGAR</html>");
        jButton4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton4.setMargin(new java.awt.Insets(2, 14, 12, 14));
        jButton4.setPreferredSize(new java.awt.Dimension(75, 23));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton7.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ico/eliminar.png"))); // NOI18N
        jButton7.setText("<html><br><br><br><br>ELIMINAR</html>");
        jButton7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton7.setMargin(new java.awt.Insets(2, 14, 12, 14));
        jButton7.setMinimumSize(new java.awt.Dimension(85, 93));
        jButton7.setPreferredSize(new java.awt.Dimension(75, 23));
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ico/autorizar.png"))); // NOI18N
        jButton8.setText("<html><br><br><br><br>AUTORIZAR</html>");
        jButton8.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton8.setMargin(new java.awt.Insets(2, 14, 12, 14));
        jButton8.setPreferredSize(new java.awt.Dimension(75, 23));
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jdde1.setBackground(new java.awt.Color(255, 255, 255));
        jdde1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Fecha inicio :", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        jdde1.setMaxSelectableDate(new java.util.Date(253370790065000L));
        jdde1.setMaximumSize(new java.awt.Dimension(196, 180));
        jdde1.setPreferredSize(new java.awt.Dimension(196, 180));

        jda1.setBackground(new java.awt.Color(255, 255, 255));
        jda1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Fecha final : ", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "Dobla Turno ", "Llegar tarde", "Salir temprano", "No asistir (Sin goce de sueldo)", "No asistir (Com goce de sueldo)", "Vacaciones", "Sanción", "Incapacidad ", "Otro" }));
        jComboBox4.setPreferredSize(new java.awt.Dimension(208, 23));
        jComboBox4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox4ActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Dialog", 2, 10)); // NOI18N
        jLabel8.setText("Tipo de permiso:");

        jButton11.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        jButton11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ico/buscar.png"))); // NOI18N
        jButton11.setText("<html><br><br><br><br>CONSULTAR</html>");
        jButton11.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton11.setMargin(new java.awt.Insets(2, 14, 12, 14));
        jButton11.setOpaque(false);
        jButton11.setPreferredSize(new java.awt.Dimension(75, 23));
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jButton29.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jButton29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ico/denergar.png"))); // NOI18N
        jButton29.setText("<html><br><br><br><br>DENEGAR</html>");
        jButton29.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton29.setMargin(new java.awt.Insets(2, 14, 12, 14));
        jButton29.setMinimumSize(new java.awt.Dimension(75, 23));
        jButton29.setPreferredSize(new java.awt.Dimension(75, 23));
        jButton29.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton29ActionPerformed(evt);
            }
        });

        jButton81.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        jButton81.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ico/buscar.png"))); // NOI18N
        jButton81.setText("<html><br><br><br><br>PERMISOS ACTIVOS</html>");
        jButton81.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton81.setMargin(new java.awt.Insets(2, 2, 12, 2));
        jButton81.setMinimumSize(new java.awt.Dimension(0, 0));
        jButton81.setOpaque(false);
        jButton81.setPreferredSize(new java.awt.Dimension(75, 23));
        jButton81.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton81ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGap(77, 77, 77)
                                .addComponent(jLabel8))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jdde1, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jda1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
                                    .addComponent(jButton8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton29, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jComboBox4, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(jButton81, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 1080, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton29, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jdde1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jda1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton81, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 599, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(65, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Permisos", new javax.swing.ImageIcon(getClass().getResource("/ico/tactics.png")), jPanel8); // NOI18N

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));

        jButton30.setText("Actualizar");
        jButton30.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton30ActionPerformed(evt);
            }
        });

        jPanel11.setLayout(new java.awt.CardLayout());
        jScrollPane7.setViewportView(jPanel11);

        jdde2.setBackground(new java.awt.Color(255, 255, 255));
        jdde2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Fecha de inicio :", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        jda2.setBackground(new java.awt.Color(255, 255, 255));
        jda2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Fecha final :", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        jComboBox9.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Puntualidad", "Tiempo Laborado", " " }));

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel3.setText("Grafica de:");

        jLabel41.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel41.setText("Por:");

        jRadioButton5.setBackground(new java.awt.Color(255, 255, 255));
        grupodegraficas.add(jRadioButton5);
        jRadioButton5.setText("Turno");
        jRadioButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton5ActionPerformed(evt);
            }
        });

        jRadioButton6.setBackground(new java.awt.Color(255, 255, 255));
        grupodegraficas.add(jRadioButton6);
        jRadioButton6.setText("Horario");
        jRadioButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton6ActionPerformed(evt);
            }
        });

        jRadioButton7.setBackground(new java.awt.Color(255, 255, 255));
        grupodegraficas.add(jRadioButton7);
        jRadioButton7.setSelected(true);
        jRadioButton7.setText("En general");
        jRadioButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton30)
                                .addGap(81, 81, 81))
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel10Layout.createSequentialGroup()
                                        .addComponent(jRadioButton5)
                                        .addGap(10, 10, 10)
                                        .addComponent(jRadioButton6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jRadioButton7))
                                    .addGroup(jPanel10Layout.createSequentialGroup()
                                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jComboBox9, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel41)
                                            .addComponent(jComboBox13, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jdde2, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 0, Short.MAX_VALUE)))))
                        .addGap(6, 6, 6))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jda2, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 1092, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane7))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel10Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jComboBox9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addComponent(jLabel41)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jRadioButton5)
                            .addComponent(jRadioButton6)
                            .addComponent(jRadioButton7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jComboBox13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jdde2, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jda2, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                        .addComponent(jButton30)))
                .addGap(42, 42, 42))
        );

        jTabbedPane1.addTab("Graficas", new javax.swing.ImageIcon(getClass().getResource("/ico/line-chart.png")), jPanel10); // NOI18N

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane3.setBackground(new java.awt.Color(204, 204, 255));
        jScrollPane3.setBorder(null);
        jScrollPane3.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane3.setToolTipText("");
        jScrollPane3.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        jScrollPane3.setAutoscrolls(true);
        jScrollPane3.setFocusable(false);
        jScrollPane3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jScrollPane3.setName(""); // NOI18N
        jScrollPane3.setPreferredSize(new java.awt.Dimension(1258, 624));

        jTable3.setAutoCreateRowSorter(true);
        jTable3.setFont(new java.awt.Font("Dialog", 0, 17)); // NOI18N
        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "NOMBRE", "DOMICILIO", "TEL. CELULAR", "TEL. CASA", "TURNO", "Cotizacion", "Title 8", "Title 9", "Title 10"
            }
        ));
        jTable3.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jTable3.setMaximumSize(new java.awt.Dimension(1800, 640));
        jTable3.setMinimumSize(new java.awt.Dimension(1800, 640));
        jTable3.setOpaque(false);
        jTable3.setPreferredSize(new java.awt.Dimension(1800, 800));
        jTable3.setRowHeight(30);
        jTable3.setSelectionForeground(new java.awt.Color(51, 51, 255));
        jScrollPane3.setViewportView(jTable3);
        if (jTable3.getColumnModel().getColumnCount() > 0) {
            jTable3.getColumnModel().getColumn(0).setResizable(false);
            jTable3.getColumnModel().getColumn(6).setResizable(false);
        }

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ico/agregar.png"))); // NOI18N
        jButton2.setToolTipText("Agrega un personal nuevo");
        jButton2.setAlignmentX(0.5F);
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.setIconTextGap(3);
        jButton2.setLabel("<html><br><br><br><br>AGREGAR</html>");
        jButton2.setMargin(new java.awt.Insets(2, 14, 12, 14));
        jButton2.setPreferredSize(new java.awt.Dimension(65, 65));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton5.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ico/editar.png"))); // NOI18N
        jButton5.setText("<html><br><br><br><br>EDITAR</html>");
        jButton5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton5.setMargin(new java.awt.Insets(2, 14, 12, 14));
        jButton5.setMaximumSize(new java.awt.Dimension(75, 23));
        jButton5.setPreferredSize(new java.awt.Dimension(65, 65));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ico/eliminar.png"))); // NOI18N
        jButton6.setText("<html><br><br><br><br>ELIMINAR</html>");
        jButton6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton6.setMargin(new java.awt.Insets(2, 14, 12, 14));
        jButton6.setPreferredSize(new java.awt.Dimension(65, 65));
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton55.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jButton55.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ico/nomi.png"))); // NOI18N
        jButton55.setText("<html><br><br><br><br>Hacer Nomina</html>");
        jButton55.setEnabled(false);
        jButton55.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton55.setMargin(new java.awt.Insets(2, 2, 12, 2));
        jButton55.setPreferredSize(new java.awt.Dimension(65, 65));
        jButton55.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton55ActionPerformed(evt);
            }
        });

        jButton57.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jButton57.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ico/binoculars.png"))); // NOI18N
        jButton57.setText("<html><br><br><br><br>Consultar\n\n</html>");
        jButton57.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton57.setMargin(new java.awt.Insets(2, 2, 12, 2));
        jButton57.setPreferredSize(new java.awt.Dimension(65, 65));
        jButton57.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton57ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jButton5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE)
                    .addComponent(jButton6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton55, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton57, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 1258, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(jButton55, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton57, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 624, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 40, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Personal ", new javax.swing.ImageIcon(getClass().getResource("/ico/businessman.png")), jPanel2); // NOI18N

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jButton1.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ico/agregar.png"))); // NOI18N
        jButton1.setText("<html><br><br><br><br>AGREGAR</html>");
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setMargin(new java.awt.Insets(2, 14, 12, 14));
        jButton1.setPreferredSize(new java.awt.Dimension(65, 65));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ico/eliminar.png"))); // NOI18N
        jButton3.setText("<html><br><br><br><br>ELIMINAR</html>");
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton3.setMargin(new java.awt.Insets(2, 14, 12, 14));
        jButton3.setPreferredSize(new java.awt.Dimension(65, 65));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jTable1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NOMBRE", "ENTRADA", "T.COMIDA", "SALIDA"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTable1.setGridColor(new java.awt.Color(0, 0, 0));
        jTable1.setOpaque(false);
        jTable1.setPreferredSize(new java.awt.Dimension(452, 402));
        jTable1.setRowHeight(30);
        jTable1.setSelectionForeground(new java.awt.Color(51, 51, 255));
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
            jTable1.getColumnModel().getColumn(2).setResizable(false);
            jTable1.getColumnModel().getColumn(3).setResizable(false);
        }

        jButton86.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        jButton86.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ico/editar.png"))); // NOI18N
        jButton86.setText("<html><br><br><br><br>EDITAR</html>");
        jButton86.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton86.setMargin(new java.awt.Insets(2, 14, 12, 14));
        jButton86.setMaximumSize(new java.awt.Dimension(83, 89));
        jButton86.setPreferredSize(new java.awt.Dimension(65, 65));
        jButton86.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton86ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(6, 6, 6))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton86, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1234, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 653, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton86, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Horarios", new javax.swing.ImageIcon(getClass().getResource("/ico/calendar.png")), jPanel1); // NOI18N

        jTabbedPane4.setBackground(new java.awt.Color(0, 204, 204));
        jTabbedPane4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTabbedPane4.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);
        jTabbedPane4.setOpaque(true);

        jPanel17.setBackground(new java.awt.Color(0, 204, 204));
        jPanel17.setVerifyInputWhenFocusTarget(false);
        jPanel17.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel25.setBackground(new java.awt.Color(255, 255, 255));
        jPanel25.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Formulario", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        jPanel25.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel56.setText("Personal:");
        jPanel25.add(jLabel56, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        jComboBox15.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jComboBox15.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jComboBox15.setInheritsPopupMenu(true);
        jComboBox15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox15ActionPerformed(evt);
            }
        });
        jPanel25.add(jComboBox15, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 161, 30));

        jLabel57.setText("Periodo:");
        jPanel25.add(jLabel57, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, -1, -1));

        jButton45.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jButton45.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ico/buscar.png"))); // NOI18N
        jButton45.setText("<html><br><br><br><br>CALCULAR</html>");
        jButton45.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton45.setMargin(new java.awt.Insets(2, 14, 12, 14));
        jButton45.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton45ActionPerformed(evt);
            }
        });
        jPanel25.add(jButton45, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 370, -1, 67));

        jLabel87.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ico/flecha derecha.png"))); // NOI18N
        jPanel25.add(jLabel87, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 10, -1, -1));

        jButton53.setFont(new java.awt.Font("Tahoma", 1, 8)); // NOI18N
        jButton53.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ico/exportar.png"))); // NOI18N
        jButton53.setText("<html><br><br><br><br><br><br>VISTA PREVIA</html>");
        jButton53.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton53.setMargin(new java.awt.Insets(1, 1, 12, 1));
        jButton53.setMaximumSize(new java.awt.Dimension(93, 93));
        jButton53.setMinimumSize(new java.awt.Dimension(93, 93));
        jButton53.setPreferredSize(new java.awt.Dimension(93, 93));
        jButton53.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton53ActionPerformed(evt);
            }
        });
        jPanel25.add(jButton53, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 440, -1, 67));

        jFormattedTextField6.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        jFormattedTextField6.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jFormattedTextField6.setText("0");
        jFormattedTextField6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jFormattedTextField6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFormattedTextField6ActionPerformed(evt);
            }
        });
        jPanel25.add(jFormattedTextField6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 210, 60, -1));

        jLabel103.setText("Dias del periodo :");
        jPanel25.add(jLabel103, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, -1, -1));

        TF_salsem.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TF_salsem.setText("0");
        TF_salsem.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        TF_salsem.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                TF_salsemFocusLost(evt);
            }
        });
        TF_salsem.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                TF_salsemInputMethodTextChanged(evt);
            }
        });
        TF_salsem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TF_salsemActionPerformed(evt);
            }
        });
        TF_salsem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TF_salsemKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TF_salsemKeyTyped(evt);
            }
        });
        jPanel25.add(TF_salsem, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 260, 60, -1));

        jLabel104.setText("Salario semanal del periodo:");
        jPanel25.add(jLabel104, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, -1, -1));

        jFormattedTextField8.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        jFormattedTextField8.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jFormattedTextField8.setText("0");
        jFormattedTextField8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jFormattedTextField8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFormattedTextField8ActionPerformed(evt);
            }
        });
        jPanel25.add(jFormattedTextField8, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 310, 60, -1));

        jLabelss.setText("Salario diario :");
        jPanel25.add(jLabelss, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, -1, -1));

        jButton79.setText("Seleccionar Fechas");
        jButton79.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton79ActionPerformed(evt);
            }
        });
        jPanel25.add(jButton79, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 160, 30));

        jLabel146.setFont(new java.awt.Font("Dialog", 0, 13)); // NOI18N
        jLabel146.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel146.setText("00/00/0000");
        jLabel146.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Del:", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        jPanel25.add(jLabel146, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 80, -1));

        jLabel110.setFont(new java.awt.Font("Dialog", 0, 13)); // NOI18N
        jLabel110.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel110.setText("00/00/0000");
        jLabel110.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Al:", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        jPanel25.add(jLabel110, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 100, 80, -1));

        jButton61.setFont(new java.awt.Font("Tahoma", 1, 8)); // NOI18N
        jButton61.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ico/exportar.png"))); // NOI18N
        jButton61.setText("<html><br><br><br><br><br><br>GUARDAR MODELO</html>");
        jButton61.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton61.setMargin(new java.awt.Insets(1, 1, 14, 1));
        jButton61.setMaximumSize(new java.awt.Dimension(93, 93));
        jButton61.setMinimumSize(new java.awt.Dimension(93, 93));
        jButton61.setPreferredSize(new java.awt.Dimension(93, 93));
        jButton61.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton61ActionPerformed(evt);
            }
        });
        jPanel25.add(jButton61, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 510, -1, 67));

        jPanel17.add(jPanel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 189, 610));

        jPanel26.setBackground(new java.awt.Color(255, 255, 255));
        jPanel26.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Asistencias durante el periodo", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        jLabel90.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel90.setText("00");
        jLabel90.setToolTipText("");
        jLabel90.setBorder(javax.swing.BorderFactory.createTitledBorder("Horas Laboradas:"));

        jLabel85.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel85.setText("00");
        jLabel85.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Total de Retardos", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        jTable6.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Fecha", "Entrada", "Salida", "T.Laborado"
            }
        ));
        jTable6.setSelectionForeground(new java.awt.Color(51, 51, 255));
        jScrollPane8.setViewportView(jTable6);
        if (jTable6.getColumnModel().getColumnCount() > 0) {
            jTable6.getColumnModel().getColumn(1).setPreferredWidth(30);
            jTable6.getColumnModel().getColumn(2).setPreferredWidth(30);
            jTable6.getColumnModel().getColumn(3).setPreferredWidth(30);
        }

        javax.swing.GroupLayout jPanel26Layout = new javax.swing.GroupLayout(jPanel26);
        jPanel26.setLayout(jPanel26Layout);
        jPanel26Layout.setHorizontalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addComponent(jLabel90, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel85, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(108, 159, Short.MAX_VALUE))
            .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        jPanel26Layout.setVerticalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel90)
                    .addComponent(jLabel85))
                .addGap(93, 93, 93))
        );

        jPanel17.add(jPanel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 360, 390, 250));

        jPanel27.setBackground(new java.awt.Color(255, 255, 255));
        jPanel27.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Faltas durante el periodo", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        jTable7.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Fecha", "Motivo", "Gravante"
            }
        ));
        jTable7.setSelectionForeground(new java.awt.Color(51, 51, 255));
        jScrollPane11.setViewportView(jTable7);

        javax.swing.GroupLayout jPanel27Layout = new javax.swing.GroupLayout(jPanel27);
        jPanel27.setLayout(jPanel27Layout);
        jPanel27Layout.setHorizontalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 368, Short.MAX_VALUE)
        );
        jPanel27Layout.setVerticalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel17.add(jPanel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 360, 380, 250));

        jPanel28.setBackground(new java.awt.Color(204, 255, 204));
        jPanel28.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Percepciones", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N
        jPanel28.setMaximumSize(new java.awt.Dimension(298, 424));
        jPanel28.setMinimumSize(new java.awt.Dimension(298, 424));
        jPanel28.setPreferredSize(new java.awt.Dimension(298, 424));
        jPanel28.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel60.setText("Concepto:");
        jPanel28.add(jLabel60, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jLabel78.setText("Cantidad:");
        jPanel28.add(jLabel78, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 20, -1, -1));

        jComboBox16.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Otro", "Horas extraordinarias", "Gratificaciones extraordinarias", "Salario Base" }));
        jComboBox16.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox16ItemStateChanged(evt);
            }
        });
        jComboBox16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jComboBox16MouseClicked(evt);
            }
        });
        jPanel28.add(jComboBox16, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, 30));

        jLabel79.setText("Valor:");
        jPanel28.add(jLabel79, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 20, -1, -1));
        jPanel28.add(jTextField13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 171, -1));

        jButton43.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ico/mas.png"))); // NOI18N
        jButton43.setText("Agregar");
        jButton43.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton43ActionPerformed(evt);
            }
        });
        jPanel28.add(jButton43, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, -1, -1));

        jButton44.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ico/menos.png"))); // NOI18N
        jButton44.setText("Quitar");
        jButton44.setMaximumSize(new java.awt.Dimension(101, 33));
        jButton44.setMinimumSize(new java.awt.Dimension(101, 33));
        jButton44.setPreferredSize(new java.awt.Dimension(101, 33));
        jButton44.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton44ActionPerformed(evt);
            }
        });
        jPanel28.add(jButton44, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 100, -1, -1));

        jFormattedTextField4.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        jFormattedTextField4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jFormattedTextField4.setText("1");
        jFormattedTextField4.setToolTipText("");
        jPanel28.add(jFormattedTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 70, 35, -1));

        jFormattedTextField5.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        jFormattedTextField5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jFormattedTextField5.setText("0");
        jPanel28.add(jFormattedTextField5, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 70, 35, -1));

        jLabel84.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel84.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel84.setText("$0");
        jLabel84.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Percepciones Totales", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 12))); // NOI18N
        jPanel28.add(jLabel84, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 300, 168, -1));

        jLabel88.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ico/flecha derecha.png"))); // NOI18N
        jPanel28.add(jLabel88, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 10, -1, -1));

        jTable9.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Concepto", "Cantidad", "Valor", "Total"
            }
        ));
        jTable9.setSelectionForeground(new java.awt.Color(51, 51, 255));
        jScrollPane16.setViewportView(jTable9);

        jPanel28.add(jScrollPane16, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 280, 160));

        jPanel17.add(jPanel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 0, -1, 360));

        jPanel29.setBackground(new java.awt.Color(255, 204, 204));
        jPanel29.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Deducciones", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N
        jPanel29.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable8.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Concepto", "Cantidad", "Valor", "Total"
            }
        ));
        jTable8.setMinimumSize(new java.awt.Dimension(60, 100));
        jTable8.setSelectionForeground(new java.awt.Color(51, 51, 255));
        jScrollPane12.setViewportView(jTable8);

        jPanel29.add(jScrollPane12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 280, 160));

        jButton42.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ico/mas.png"))); // NOI18N
        jButton42.setText("Agregar");
        jButton42.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton42ActionPerformed(evt);
            }
        });
        jPanel29.add(jButton42, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, -1, -1));

        jButton41.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ico/menos.png"))); // NOI18N
        jButton41.setText("Quitar");
        jButton41.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton41ActionPerformed(evt);
            }
        });
        jPanel29.add(jButton41, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 100, 112, -1));

        jFormattedTextField2.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        jFormattedTextField2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jFormattedTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFormattedTextField2ActionPerformed(evt);
            }
        });
        jPanel29.add(jFormattedTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 70, 34, -1));

        jFormattedTextField3.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        jFormattedTextField3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jFormattedTextField3.setText("1");
        jFormattedTextField3.setMaximumSize(new java.awt.Dimension(6, 20));
        jPanel29.add(jFormattedTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 70, 35, -1));
        jPanel29.add(jTextField12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 180, -1));

        jComboBox17.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Otro", "(ISR) Impuesto sobre la renta ", "(IVA) Impuesto al valor agregado", "(IMSS) Cotizacion seguro social" }));
        jPanel29.add(jComboBox17, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 180, 30));

        jLabel80.setText("Concepto:");
        jPanel29.add(jLabel80, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jLabel81.setText("Cantidad:");
        jPanel29.add(jLabel81, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 20, -1, -1));

        jLabel82.setText("Valor:");
        jPanel29.add(jLabel82, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 20, -1, -1));

        jLabel83.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel83.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel83.setText("$0");
        jLabel83.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Deducciones Totales", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N
        jPanel29.add(jLabel83, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 300, 156, -1));

        jLabel89.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ico/flecha derecha.png"))); // NOI18N
        jPanel29.add(jLabel89, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 10, -1, -1));

        jPanel17.add(jPanel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 0, -1, 360));

        jPanel30.setBackground(new java.awt.Color(255, 255, 204));
        jPanel30.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Detalles", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        jPanel30.setAutoscrolls(true);
        jPanel30.setMaximumSize(new java.awt.Dimension(519, 420));
        jPanel30.setMinimumSize(new java.awt.Dimension(519, 420));

        TF_subpercep.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        TF_subdeduc.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel98.setText("Sub Total");

        TF_total.setBorder(javax.swing.BorderFactory.createTitledBorder("TOTAL"));
        TF_total.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("$#,##0.00"))));
        TF_total.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TF_total.setMaximumSize(new java.awt.Dimension(74, 41));
        TF_total.setMinimumSize(new java.awt.Dimension(74, 41));
        TF_total.setPreferredSize(new java.awt.Dimension(74, 41));
        TF_total.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TF_totalActionPerformed(evt);
            }
        });

        TF_nombre_emp.setBorder(javax.swing.BorderFactory.createTitledBorder("Empresa o Razon Social"));
        TF_nombre_emp.setMaximumSize(new java.awt.Dimension(172, 36));
        TF_nombre_emp.setMinimumSize(new java.awt.Dimension(172, 36));
        TF_nombre_emp.setPreferredSize(new java.awt.Dimension(172, 36));

        TF_domicilio_emp1.setBorder(javax.swing.BorderFactory.createTitledBorder("Domicilio"));
        TF_domicilio_emp1.setMaximumSize(new java.awt.Dimension(172, 36));
        TF_domicilio_emp1.setMinimumSize(new java.awt.Dimension(172, 36));
        TF_domicilio_emp1.setPreferredSize(new java.awt.Dimension(172, 36));

        Tf_rfc_emp2.setBorder(javax.swing.BorderFactory.createTitledBorder("RFC Emisor"));
        Tf_rfc_emp2.setMaximumSize(new java.awt.Dimension(172, 36));
        Tf_rfc_emp2.setMinimumSize(new java.awt.Dimension(172, 36));
        Tf_rfc_emp2.setPreferredSize(new java.awt.Dimension(172, 36));

        TF_nombre_perso.setBorder(javax.swing.BorderFactory.createTitledBorder("Empleado"));
        TF_nombre_perso.setMaximumSize(new java.awt.Dimension(172, 36));
        TF_nombre_perso.setMinimumSize(new java.awt.Dimension(172, 36));
        TF_nombre_perso.setPreferredSize(new java.awt.Dimension(172, 36));

        TF_codigo_perso.setBorder(javax.swing.BorderFactory.createTitledBorder("Codigo"));
        TF_codigo_perso.setMaximumSize(new java.awt.Dimension(172, 36));
        TF_codigo_perso.setMinimumSize(new java.awt.Dimension(172, 36));
        TF_codigo_perso.setPreferredSize(new java.awt.Dimension(172, 36));

        TF_puesto_perso.setBorder(javax.swing.BorderFactory.createTitledBorder("Puesto"));
        TF_puesto_perso.setMaximumSize(new java.awt.Dimension(172, 36));
        TF_puesto_perso.setMinimumSize(new java.awt.Dimension(172, 36));
        TF_puesto_perso.setPreferredSize(new java.awt.Dimension(172, 36));

        Tf_rfc_perso.setBorder(javax.swing.BorderFactory.createTitledBorder("RFC Receptor"));
        Tf_rfc_perso.setMaximumSize(new java.awt.Dimension(172, 36));
        Tf_rfc_perso.setMinimumSize(new java.awt.Dimension(172, 36));
        Tf_rfc_perso.setPreferredSize(new java.awt.Dimension(172, 36));

        TF_nosocial_perso1.setBorder(javax.swing.BorderFactory.createTitledBorder("No. Social"));
        TF_nosocial_perso1.setMaximumSize(new java.awt.Dimension(172, 36));
        TF_nosocial_perso1.setMinimumSize(new java.awt.Dimension(172, 36));
        TF_nosocial_perso1.setPreferredSize(new java.awt.Dimension(172, 36));

        TF_periodo_perso2.setBorder(javax.swing.BorderFactory.createTitledBorder("Periodo"));
        TF_periodo_perso2.setMaximumSize(new java.awt.Dimension(172, 36));
        TF_periodo_perso2.setMinimumSize(new java.awt.Dimension(172, 36));
        TF_periodo_perso2.setPreferredSize(new java.awt.Dimension(172, 36));

        TF_dias_perso3.setBorder(javax.swing.BorderFactory.createTitledBorder("Dias"));
        TF_dias_perso3.setMaximumSize(new java.awt.Dimension(172, 36));
        TF_dias_perso3.setMinimumSize(new java.awt.Dimension(172, 36));
        TF_dias_perso3.setPreferredSize(new java.awt.Dimension(172, 36));

        TF_tarifa_perso4.setBorder(javax.swing.BorderFactory.createTitledBorder("Tarifa"));
        TF_tarifa_perso4.setMaximumSize(new java.awt.Dimension(172, 36));
        TF_tarifa_perso4.setMinimumSize(new java.awt.Dimension(172, 36));
        TF_tarifa_perso4.setPreferredSize(new java.awt.Dimension(172, 36));

        TF_fechaemision_perso5.setBorder(javax.swing.BorderFactory.createTitledBorder("Fecha Emision"));
        TF_fechaemision_perso5.setMaximumSize(new java.awt.Dimension(172, 36));
        TF_fechaemision_perso5.setMinimumSize(new java.awt.Dimension(172, 36));
        TF_fechaemision_perso5.setPreferredSize(new java.awt.Dimension(172, 36));

        TF_texto_c.setColumns(20);
        TF_texto_c.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        TF_texto_c.setLineWrap(true);
        TF_texto_c.setRows(5);
        TF_texto_c.setText("Recibí de esta empresa la cantidad que señala este recibo, estando conforme con las percepciones y las reteniones descritas, por lo que certifico que no se me adeuda cantidad alguna por ningun concepto. ");
        jScrollPane18.setViewportView(TF_texto_c);

        jTable10.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "concepto", "Cantidad", "Valor", "Percep", "Deduciones"
            }
        ));
        jTable10.setMinimumSize(new java.awt.Dimension(60, 100));
        jTable10.setSelectionBackground(new java.awt.Color(204, 255, 255));
        jTable10.setSelectionForeground(new java.awt.Color(0, 0, 0));
        jScrollPane19.setViewportView(jTable10);

        javax.swing.GroupLayout jPanel30Layout = new javax.swing.GroupLayout(jPanel30);
        jPanel30.setLayout(jPanel30Layout);
        jPanel30Layout.setHorizontalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel30Layout.createSequentialGroup()
                .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel30Layout.createSequentialGroup()
                        .addComponent(jScrollPane18, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel30Layout.createSequentialGroup()
                                .addComponent(jLabel98)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(TF_subpercep, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TF_subdeduc, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(TF_total, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel30Layout.createSequentialGroup()
                        .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TF_nombre_emp, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TF_nombre_perso, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel30Layout.createSequentialGroup()
                                .addComponent(TF_domicilio_emp1, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Tf_rfc_emp2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel30Layout.createSequentialGroup()
                                    .addComponent(TF_dias_perso3, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(TF_tarifa_perso4, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(TF_fechaemision_perso5, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel30Layout.createSequentialGroup()
                                    .addComponent(TF_codigo_perso, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(TF_puesto_perso, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(Tf_rfc_perso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel30Layout.createSequentialGroup()
                        .addComponent(TF_nosocial_perso1, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TF_periodo_perso2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel30Layout.createSequentialGroup()
                        .addComponent(jScrollPane19)
                        .addGap(1, 1, 1)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel30Layout.setVerticalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel30Layout.createSequentialGroup()
                .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TF_nombre_emp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TF_domicilio_emp1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Tf_rfc_emp2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TF_nombre_perso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TF_codigo_perso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TF_puesto_perso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Tf_rfc_perso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TF_nosocial_perso1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TF_periodo_perso2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TF_dias_perso3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TF_tarifa_perso4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TF_fechaemision_perso5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addComponent(jScrollPane19, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel30Layout.createSequentialGroup()
                        .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(TF_subpercep, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(TF_subdeduc, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel98, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(TF_total, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane18, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 57, Short.MAX_VALUE))
        );

        jPanel17.add(jPanel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 0, 570, 360));

        jPanel51.setBackground(new java.awt.Color(255, 255, 255));
        jPanel51.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Permiso durante el periodo", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        jTable15.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Fecha", "Hora", "Tipo", "Motivo"
            }
        ));
        jTable15.setSelectionForeground(new java.awt.Color(51, 51, 255));
        jScrollPane15.setViewportView(jTable15);
        if (jTable15.getColumnModel().getColumnCount() > 0) {
            jTable15.getColumnModel().getColumn(0).setPreferredWidth(50);
        }

        jButton62.setText("jButton62");
        jButton62.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton62ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel51Layout = new javax.swing.GroupLayout(jPanel51);
        jPanel51.setLayout(jPanel51Layout);
        jPanel51Layout.setHorizontalGroup(
            jPanel51Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane15, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
            .addGroup(jPanel51Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton62, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel51Layout.setVerticalGroup(
            jPanel51Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel51Layout.createSequentialGroup()
                .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addComponent(jButton62, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel17.add(jPanel51, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 360, 400, 250));

        jTabbedPane4.addTab("Generador Nomina", new javax.swing.ImageIcon(getClass().getResource("/ico/nomiCH.png")), jPanel17); // NOI18N

        jPanel48.setBackground(new java.awt.Color(255, 255, 255));
        jPanel48.setOpaque(false);

        jButton67.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        jButton67.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ico/eliminar.png"))); // NOI18N
        jButton67.setText("<html><br><br><br><br>ELIMINAR</html>");
        jButton67.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton67.setMargin(new java.awt.Insets(2, 14, 12, 14));
        jButton67.setPreferredSize(new java.awt.Dimension(75, 23));
        jButton67.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton67ActionPerformed(evt);
            }
        });

        jButton69.setBackground(new java.awt.Color(255, 255, 255));
        jButton69.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        jButton69.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ico/agregar.png"))); // NOI18N
        jButton69.setToolTipText("Agrega un personal nuevo");
        jButton69.setAlignmentX(0.5F);
        jButton69.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton69.setIconTextGap(3);
        jButton69.setLabel("<html><br><br><br><br>AGREGAR</html>");
        jButton69.setMargin(new java.awt.Insets(2, 14, 12, 14));
        jButton69.setPreferredSize(new java.awt.Dimension(75, 23));
        jButton69.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton69ActionPerformed(evt);
            }
        });

        jTable12.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jTable12.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, "<html>Salario Base : 1*1098=1098.0 <br>Bonificacion : 1*902=902.0 <br>Prueba : 2*3=6.0</html>", null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "CVE", "Nombre", "dias", "tarifa", "total", "Percepciones Valor*Cant=Total", "Deducciones Valor*Cant =Total"
            }
        ));
        jTable12.setRowHeight(15);
        jTable12.setSelectionBackground(new java.awt.Color(255, 255, 255));
        jTable12.setSelectionForeground(new java.awt.Color(51, 51, 255));
        jScrollPane17.setViewportView(jTable12);
        if (jTable12.getColumnModel().getColumnCount() > 0) {
            jTable12.getColumnModel().getColumn(0).setPreferredWidth(20);
        }

        javax.swing.GroupLayout jPanel48Layout = new javax.swing.GroupLayout(jPanel48);
        jPanel48.setLayout(jPanel48Layout);
        jPanel48Layout.setHorizontalGroup(
            jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel48Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jButton67, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton69, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane17, javax.swing.GroupLayout.PREFERRED_SIZE, 1019, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(240, Short.MAX_VALUE))
        );
        jPanel48Layout.setVerticalGroup(
            jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel48Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane17, javax.swing.GroupLayout.DEFAULT_SIZE, 583, Short.MAX_VALUE)
                    .addGroup(jPanel48Layout.createSequentialGroup()
                        .addComponent(jButton69, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton67, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jTabbedPane4.addTab("Cotizaciones", new javax.swing.ImageIcon(getClass().getResource("/ico/get-moneyCH.png")), jPanel48, ""); // NOI18N

        jPanel49.setBackground(new java.awt.Color(255, 255, 255));
        jPanel49.setEnabled(false);

        jTable11.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "CVE", "Cocepto", "PER / DED", "Valor / %", "Tipo"
            }
        ));
        jScrollPane13.setViewportView(jTable11);
        if (jTable11.getColumnModel().getColumnCount() > 0) {
            jTable11.getColumnModel().getColumn(0).setResizable(false);
            jTable11.getColumnModel().getColumn(2).setResizable(false);
            jTable11.getColumnModel().getColumn(4).setResizable(false);
        }

        jButton64.setBackground(new java.awt.Color(255, 255, 255));
        jButton64.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        jButton64.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ico/agregar.png"))); // NOI18N
        jButton64.setToolTipText("Agrega un personal nuevo");
        jButton64.setAlignmentX(0.5F);
        jButton64.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton64.setIconTextGap(3);
        jButton64.setLabel("<html><br><br><br><br>AGREGAR</html>");
        jButton64.setMargin(new java.awt.Insets(2, 14, 12, 14));
        jButton64.setPreferredSize(new java.awt.Dimension(75, 23));
        jButton64.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton64ActionPerformed(evt);
            }
        });

        jButton65.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        jButton65.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ico/editar.png"))); // NOI18N
        jButton65.setText("<html><br><br><br><br>EDITAR</html>");
        jButton65.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton65.setMargin(new java.awt.Insets(2, 14, 12, 14));
        jButton65.setMaximumSize(new java.awt.Dimension(75, 23));
        jButton65.setPreferredSize(new java.awt.Dimension(75, 23));
        jButton65.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton65ActionPerformed(evt);
            }
        });

        jButton66.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        jButton66.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ico/eliminar.png"))); // NOI18N
        jButton66.setText("<html><br><br><br><br>ELIMINAR</html>");
        jButton66.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton66.setMargin(new java.awt.Insets(2, 14, 12, 14));
        jButton66.setPreferredSize(new java.awt.Dimension(75, 23));
        jButton66.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton66ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel49Layout = new javax.swing.GroupLayout(jPanel49);
        jPanel49.setLayout(jPanel49Layout);
        jPanel49Layout.setHorizontalGroup(
            jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel49Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jButton65, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton66, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton64, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 617, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel49Layout.setVerticalGroup(
            jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel49Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel49Layout.createSequentialGroup()
                        .addComponent(jButton64, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton65, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton66, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane4.addTab("Conceptos", new javax.swing.ImageIcon(getClass().getResource("/ico/balanceCH.png")), jPanel49); // NOI18N

        javax.swing.GroupLayout jPanel47Layout = new javax.swing.GroupLayout(jPanel47);
        jPanel47.setLayout(jPanel47Layout);
        jPanel47Layout.setHorizontalGroup(
            jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane4)
        );
        jPanel47Layout.setVerticalGroup(
            jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel47Layout.createSequentialGroup()
                .addComponent(jTabbedPane4)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Retribuciones", new javax.swing.ImageIcon(getClass().getResource("/ico/nomi.png")), jPanel47); // NOI18N

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jButton36.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        jButton36.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ico/agregar.png"))); // NOI18N
        jButton36.setText("<html><br><br><br><br>AGREGAR</html>");
        jButton36.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton36.setMargin(new java.awt.Insets(2, 14, 12, 14));
        jButton36.setPreferredSize(new java.awt.Dimension(75, 23));
        jButton36.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton36ActionPerformed(evt);
            }
        });

        jButton37.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        jButton37.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ico/eliminar.png"))); // NOI18N
        jButton37.setText("<html><br><br><br><br>ELIMINAR</html>");
        jButton37.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton37.setMargin(new java.awt.Insets(2, 14, 12, 14));
        jButton37.setMinimumSize(new java.awt.Dimension(85, 93));
        jButton37.setPreferredSize(new java.awt.Dimension(75, 23));
        jButton37.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton37ActionPerformed(evt);
            }
        });

        jdde3.setBackground(new java.awt.Color(255, 255, 255));
        jdde3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Fecha de inicio :", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        jdde3.setMaximumSize(new java.awt.Dimension(196, 180));
        jdde3.setMinSelectableDate(new java.util.Date(-62135744335000L));
        jdde3.setPreferredSize(new java.awt.Dimension(196, 180));

        jda3.setBackground(new java.awt.Color(255, 255, 255));
        jda3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Fecha final :", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        jda3.setMaximumSize(new java.awt.Dimension(196, 180));
        jda3.setPreferredSize(new java.awt.Dimension(196, 180));

        jTable14.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTable14.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "INDX", "FECHA", "HORA", "MOTIVO", "DESCRIPCION", "ANEXO"
            }
        ));
        jTable14.setRowHeight(35);
        jTable14.setSelectionForeground(new java.awt.Color(51, 51, 255));
        jScrollPane10.setViewportView(jTable14);
        if (jTable14.getColumnModel().getColumnCount() > 0) {
            jTable14.getColumnModel().getColumn(0).setResizable(false);
            jTable14.getColumnModel().getColumn(5).setResizable(false);
        }

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jdde3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jda3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jButton36, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(86, 86, 86)
                        .addComponent(jButton37, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane10, javax.swing.GroupLayout.DEFAULT_SIZE, 1119, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton37, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton36, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jdde3, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jda3, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 173, Short.MAX_VALUE))
                    .addComponent(jScrollPane10))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Faltas", new javax.swing.ImageIcon(getClass().getResource("/ico/falta.png")), jPanel3); // NOI18N

        jPanel58.setToolTipText("");

        jTable19.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Index", "Generar", "De Codigos", "Dias", "Hora", "Direccion"
            }
        ));
        jScrollPane22.setViewportView(jTable19);

        jButton80.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        jButton80.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ico/agregar.png"))); // NOI18N
        jButton80.setText("<html><br><br><br><br>AGREGAR</html>");
        jButton80.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton80.setMargin(new java.awt.Insets(2, 14, 12, 14));
        jButton80.setPreferredSize(new java.awt.Dimension(75, 23));
        jButton80.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton80ActionPerformed(evt);
            }
        });

        jButton82.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        jButton82.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ico/eliminar.png"))); // NOI18N
        jButton82.setText("<html><br><br><br><br>ELIMINAR</html>");
        jButton82.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton82.setMargin(new java.awt.Insets(2, 14, 12, 14));
        jButton82.setMinimumSize(new java.awt.Dimension(85, 93));
        jButton82.setPreferredSize(new java.awt.Dimension(75, 23));
        jButton82.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton82ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel58Layout = new javax.swing.GroupLayout(jPanel58);
        jPanel58.setLayout(jPanel58Layout);
        jPanel58Layout.setHorizontalGroup(
            jPanel58Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel58Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel58Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton80, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton82, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane22, javax.swing.GroupLayout.DEFAULT_SIZE, 1252, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel58Layout.setVerticalGroup(
            jPanel58Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel58Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel58Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel58Layout.createSequentialGroup()
                        .addComponent(jButton80, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton82, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(226, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Asistente", new javax.swing.ImageIcon(getClass().getResource("/ico/bot2.png")), jPanel58); // NOI18N

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jPanel4FocusGained(evt);
            }
        });

        jTable2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Indx", "Codigo", "Nombre", "Entrada", "E.Comida", "S.Comida", "Salida", "Fecha"
            }
        ));
        jTable2.setRowHeight(20);
        jTable2.setSelectionForeground(new java.awt.Color(51, 51, 255));
        jScrollPane2.setViewportView(jTable2);

        jButton10.setFont(new java.awt.Font("Dialog", 1, 9)); // NOI18N
        jButton10.setText("ACTUALIZAR");
        jButton10.setMaximumSize(new java.awt.Dimension(70, 24));
        jButton10.setMinimumSize(new java.awt.Dimension(70, 24));
        jButton10.setPreferredSize(new java.awt.Dimension(70, 24));
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jButton15.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        jButton15.setText("MOSTRAR TODO");
        jButton15.setMaximumSize(new java.awt.Dimension(70, 20));
        jButton15.setMinimumSize(new java.awt.Dimension(70, 20));
        jButton15.setPreferredSize(new java.awt.Dimension(93, 24));
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });

        jButton39.setText("Eliminar");
        jButton39.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton39ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton15, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
                    .addComponent(jButton39, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1260, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton39)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 641, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 23, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("", new javax.swing.ImageIcon(getClass().getResource("/ico/archives.png")), jPanel4); // NOI18N

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel7MouseClicked(evt);
            }
        });
        jPanel7.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentHidden(java.awt.event.ComponentEvent evt) {
                jPanel7ComponentHidden(evt);
            }
        });

        jTabbedPane2.setBackground(new java.awt.Color(0, 204, 204));
        jTabbedPane2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTabbedPane2.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);
        jTabbedPane2.setToolTipText("");
        jTabbedPane2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTabbedPane2.setOpaque(true);

        jPanel31.setBackground(new java.awt.Color(255, 255, 255));
        jPanel31.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jPanel34.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Fiscal", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        jTextField14.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jTextField14.setText("Prueba de letra");
        jTextField14.setBorder(javax.swing.BorderFactory.createTitledBorder("Nombre o Razon Social"));
        jTextField14.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTextField14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField14ActionPerformed(evt);
            }
        });

        jTextField15.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jTextField15.setText("Prueba de letra");
        jTextField15.setBorder(javax.swing.BorderFactory.createTitledBorder("RFC"));
        jTextField15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField15ActionPerformed(evt);
            }
        });

        jTextField16.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jTextField16.setText("Prueba de letra");
        jTextField16.setBorder(javax.swing.BorderFactory.createTitledBorder("Calle y numero"));
        jTextField16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField16ActionPerformed(evt);
            }
        });

        jTextField17.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jTextField17.setText("Prueba de letra");
        jTextField17.setBorder(javax.swing.BorderFactory.createTitledBorder("Entre calles"));
        jTextField17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField17ActionPerformed(evt);
            }
        });

        jTextField18.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jTextField18.setText("Prueba de letra");
        jTextField18.setBorder(javax.swing.BorderFactory.createTitledBorder("Poblacion"));
        jTextField18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField18ActionPerformed(evt);
            }
        });

        jTextField19.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jTextField19.setText("Prueba de letra");
        jTextField19.setBorder(javax.swing.BorderFactory.createTitledBorder("Colonia"));
        jTextField19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField19ActionPerformed(evt);
            }
        });

        jTextField20.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jTextField20.setText("Prueba de letra");
        jTextField20.setBorder(javax.swing.BorderFactory.createTitledBorder("Municipio"));
        jTextField20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField20ActionPerformed(evt);
            }
        });

        jTextField21.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jTextField21.setText("Prueba de letra");
        jTextField21.setBorder(javax.swing.BorderFactory.createTitledBorder("Estado"));
        jTextField21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField21ActionPerformed(evt);
            }
        });

        jTextField22.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jTextField22.setText("Prueba de letra");
        jTextField22.setBorder(javax.swing.BorderFactory.createTitledBorder("Telefono 1"));
        jTextField22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField22ActionPerformed(evt);
            }
        });

        jTextField23.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jTextField23.setText("Prueba de letra");
        jTextField23.setBorder(javax.swing.BorderFactory.createTitledBorder("Telefono 2"));
        jTextField23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField23ActionPerformed(evt);
            }
        });

        jTextField24.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jTextField24.setText("Prueba de letra");
        jTextField24.setBorder(javax.swing.BorderFactory.createTitledBorder("Email"));
        jTextField24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField24ActionPerformed(evt);
            }
        });

        jTextField25.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jTextField25.setText("Prueba de letra");
        jTextField25.setBorder(javax.swing.BorderFactory.createTitledBorder("Sitio Web"));
        jTextField25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField25ActionPerformed(evt);
            }
        });

        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setToolTipText("");
        jLabel19.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jLabel19.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel19.setMaximumSize(new java.awt.Dimension(200, 133));
        jLabel19.setMinimumSize(new java.awt.Dimension(200, 133));
        jLabel19.setPreferredSize(new java.awt.Dimension(200, 133));

        jButton49.setText("Logotipo");
        jButton49.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton49ActionPerformed(evt);
            }
        });

        jButton52.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ico/save.png"))); // NOI18N
        jButton52.setText("Guardar");
        jButton52.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton52ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel34Layout = new javax.swing.GroupLayout(jPanel34);
        jPanel34.setLayout(jPanel34Layout);
        jPanel34Layout.setHorizontalGroup(
            jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel34Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel34Layout.createSequentialGroup()
                        .addComponent(jTextField14, javax.swing.GroupLayout.PREFERRED_SIZE, 389, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextField15, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel34Layout.createSequentialGroup()
                        .addComponent(jTextField16, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField17, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel34Layout.createSequentialGroup()
                        .addGroup(jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel34Layout.createSequentialGroup()
                                .addGroup(jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jTextField24, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField22)
                                    .addComponent(jTextField19, javax.swing.GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextField25, javax.swing.GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
                                    .addComponent(jTextField18)
                                    .addComponent(jTextField23))
                                .addGap(4, 4, 4))
                            .addGroup(jPanel34Layout.createSequentialGroup()
                                .addComponent(jButton49)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                            .addGroup(jPanel34Layout.createSequentialGroup()
                                .addComponent(jButton52)
                                .addGap(127, 127, 127)))
                        .addGroup(jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField21, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE)
                            .addComponent(jTextField20, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel34Layout.setVerticalGroup(
            jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel34Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel34Layout.createSequentialGroup()
                        .addGroup(jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton49)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                        .addComponent(jButton52))
                    .addGroup(jPanel34Layout.createSequentialGroup()
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel31Layout = new javax.swing.GroupLayout(jPanel31);
        jPanel31.setLayout(jPanel31Layout);
        jPanel31Layout.setHorizontalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel31Layout.createSequentialGroup()
                .addComponent(jPanel34, javax.swing.GroupLayout.PREFERRED_SIZE, 630, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(732, Short.MAX_VALUE))
        );
        jPanel31Layout.setVerticalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel31Layout.createSequentialGroup()
                .addComponent(jPanel34, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 232, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Empresa", new javax.swing.ImageIcon(getClass().getResource("/ico/empresa.png")), jPanel31, "dsad"); // NOI18N
        jPanel31.getAccessibleContext().setAccessibleName("");

        jPanel43.setBackground(new java.awt.Color(255, 255, 255));

        jPanel44.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel44.setPreferredSize(new java.awt.Dimension(244, 77));

        jLabel58.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel58.setText("Tiempo de tolerancia Min:");

        jLabel59.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel59.setText("NO. De retardos permitidos:");

        jFormattedTextField10.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        jFormattedTextField10.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jFormattedTextField10.setText("0");
        jFormattedTextField10.setToolTipText("");

        jFormattedTextField11.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        jFormattedTextField11.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jFormattedTextField11.setText("0");
        jFormattedTextField11.setToolTipText("");

        jButton56.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ico/save.png"))); // NOI18N
        jButton56.setText("Guardar");
        jButton56.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton56ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel44Layout = new javax.swing.GroupLayout(jPanel44);
        jPanel44.setLayout(jPanel44Layout);
        jPanel44Layout.setHorizontalGroup(
            jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel44Layout.createSequentialGroup()
                .addGroup(jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel44Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel59)
                            .addComponent(jLabel58))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jFormattedTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jFormattedTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel44Layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(jButton56)))
                .addContainerGap(43, Short.MAX_VALUE))
        );
        jPanel44Layout.setVerticalGroup(
            jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel44Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel58)
                    .addComponent(jFormattedTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jFormattedTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel59))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton56)
                .addContainerGap())
        );

        jPanel65.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel161.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel161.setText("Cargar Asistencias");

        jButton87.setText("Abrir Archivo");
        jButton87.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton87ActionPerformed(evt);
            }
        });

        jButton38.setText("jButton38");
        jButton38.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton38ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel65Layout = new javax.swing.GroupLayout(jPanel65);
        jPanel65.setLayout(jPanel65Layout);
        jPanel65Layout.setHorizontalGroup(
            jPanel65Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel65Layout.createSequentialGroup()
                .addContainerGap(65, Short.MAX_VALUE)
                .addGroup(jPanel65Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel65Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jButton38))
                    .addGroup(jPanel65Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel65Layout.createSequentialGroup()
                            .addComponent(jButton87, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(69, 69, 69))
                        .addGroup(jPanel65Layout.createSequentialGroup()
                            .addComponent(jLabel161, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(59, 59, 59)))))
        );
        jPanel65Layout.setVerticalGroup(
            jPanel65Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel65Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel161)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton38)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton87, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel66.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel66.setPreferredSize(new java.awt.Dimension(244, 77));

        jLabel165.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel165.setText("Tiempo Tolerancia Min.");

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "5", "10", "15", "20", "25", "30" }));
        jComboBox2.setToolTipText("");

        jButton20.setForeground(new java.awt.Color(204, 0, 0));
        jButton20.setText("CORTE");
        jButton20.setPreferredSize(new java.awt.Dimension(96, 33));
        jButton20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton20ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel66Layout = new javax.swing.GroupLayout(jPanel66);
        jPanel66.setLayout(jPanel66Layout);
        jPanel66Layout.setHorizontalGroup(
            jPanel66Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel66Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel66Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel66Layout.createSequentialGroup()
                        .addComponent(jLabel165)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(61, Short.MAX_VALUE))
        );
        jPanel66Layout.setVerticalGroup(
            jPanel66Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel66Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel66Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel165)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel43Layout = new javax.swing.GroupLayout(jPanel43);
        jPanel43.setLayout(jPanel43Layout);
        jPanel43Layout.setHorizontalGroup(
            jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel43Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel44, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel65, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel66, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(606, Short.MAX_VALUE))
        );
        jPanel43Layout.setVerticalGroup(
            jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel43Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel66, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
                    .addComponent(jPanel65, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel44, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE))
                .addContainerGap(484, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Asistencia", new javax.swing.ImageIcon(getClass().getResource("/ico/calendarch.png")), jPanel43); // NOI18N

        jPanel32.setBackground(new java.awt.Color(255, 255, 255));

        jPanel38.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Configuracion de puerto", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        jComboBox8.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "COM1", "COM2", "COM3", "COM4", "COM5", "COM6", "COM7", "COM8", "COM9", "COM10", "COM11", "COM12", "COM13", "COM14", "COM15", "COM16" }));
        jComboBox8.setEnabled(false);

        jButton16.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        jButton16.setText("Guardar");
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });

        jRadioButton10.setSelected(true);
        jRadioButton10.setText("Modo Automatico");
        jRadioButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton10ActionPerformed(evt);
            }
        });

        jButton89.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        jButton89.setText("Buscar");
        jButton89.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton89ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel38Layout = new javax.swing.GroupLayout(jPanel38);
        jPanel38.setLayout(jPanel38Layout);
        jPanel38Layout.setHorizontalGroup(
            jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel38Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBox8, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRadioButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton89, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel38Layout.setVerticalGroup(
            jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel38Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton10)
                    .addComponent(jButton89))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton16))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel39.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Comunicacion Serial", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        jTextPane1.setBackground(new java.awt.Color(0, 0, 0));
        jTextPane1.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jTextPane1.setForeground(new java.awt.Color(255, 255, 255));
        jTextPane1.setText("Prueba para La fuente terminal");
        jScrollPane6.setViewportView(jTextPane1);

        jTextField26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField26ActionPerformed(evt);
            }
        });

        jButton50.setText("Enviar");
        jButton50.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton50ActionPerformed(evt);
            }
        });

        jButton51.setText("Consultar numero deregistros");

        jButton17.setForeground(new java.awt.Color(255, 0, 0));
        jButton17.setText("BORRAR BD DEL SENSOR");
        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton17ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel39Layout = new javax.swing.GroupLayout(jPanel39);
        jPanel39.setLayout(jPanel39Layout);
        jPanel39Layout.setHorizontalGroup(
            jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel39Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton51, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel39Layout.createSequentialGroup()
                        .addGroup(jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel39Layout.createSequentialGroup()
                                .addComponent(jTextField26, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton50, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel39Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton17)
                .addGap(46, 46, 46))
        );
        jPanel39Layout.setVerticalGroup(
            jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel39Layout.createSequentialGroup()
                .addGroup(jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton50))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton51)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton17))
        );

        jPanel52.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "FIRMWARE", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        jLabel14.setText("Version :");

        jLabel15.setText("Fecha :");

        javax.swing.GroupLayout jPanel52Layout = new javax.swing.GroupLayout(jPanel52);
        jPanel52.setLayout(jPanel52Layout);
        jPanel52Layout.setHorizontalGroup(
            jPanel52Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel52Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel52Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14)
                    .addComponent(jLabel15))
                .addContainerGap(252, Short.MAX_VALUE))
        );
        jPanel52Layout.setVerticalGroup(
            jPanel52Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel52Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel15)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel32Layout = new javax.swing.GroupLayout(jPanel32);
        jPanel32.setLayout(jPanel32Layout);
        jPanel32Layout.setHorizontalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel32Layout.createSequentialGroup()
                .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel39, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel38, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel52, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(779, Short.MAX_VALUE))
        );
        jPanel32Layout.setVerticalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel32Layout.createSequentialGroup()
                .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel52, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel32Layout.createSequentialGroup()
                        .addComponent(jPanel38, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(jPanel39, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 222, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Checador", new javax.swing.ImageIcon(getClass().getResource("/ico/cehcador.png")), jPanel32); // NOI18N

        jPanel35.setBackground(new java.awt.Color(255, 255, 255));

        jPanel40.setBorder(javax.swing.BorderFactory.createTitledBorder("Conexion Base De Datos"));

        jTextField1.setBorder(javax.swing.BorderFactory.createTitledBorder("URL Base Datos"));
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jTextField2.setBorder(javax.swing.BorderFactory.createTitledBorder("Usuario"));

        jTextField3.setBorder(javax.swing.BorderFactory.createTitledBorder("Contraseña"));

        jButton13.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        jButton13.setText("Probar Conexion");

        jButton14.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        jButton14.setText("Guardar");

        javax.swing.GroupLayout jPanel40Layout = new javax.swing.GroupLayout(jPanel40);
        jPanel40.setLayout(jPanel40Layout);
        jPanel40Layout.setHorizontalGroup(
            jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel40Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField1)
                    .addComponent(jTextField2)
                    .addComponent(jTextField3)
                    .addGroup(jPanel40Layout.createSequentialGroup()
                        .addComponent(jButton13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                        .addComponent(jButton14)))
                .addContainerGap())
        );
        jPanel40Layout.setVerticalGroup(
            jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel40Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton13)
                    .addComponent(jButton14))
                .addContainerGap())
        );

        jPanel41.setBorder(javax.swing.BorderFactory.createTitledBorder("Ver Contenido"));

        jButton24.setText("Actualizar Tablas");
        jButton24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton24ActionPerformed(evt);
            }
        });

        jButton48.setText("Generar Faltas");
        jButton48.setEnabled(false);
        jButton48.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton48ActionPerformed(evt);
            }
        });

        jButton54.setText("Generar Tablas");
        jButton54.setEnabled(false);
        jButton54.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton54ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel41Layout = new javax.swing.GroupLayout(jPanel41);
        jPanel41.setLayout(jPanel41Layout);
        jPanel41Layout.setHorizontalGroup(
            jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel41Layout.createSequentialGroup()
                .addGroup(jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton24)
                    .addComponent(jButton54)
                    .addComponent(jButton48))
                .addGap(0, 331, Short.MAX_VALUE))
        );
        jPanel41Layout.setVerticalGroup(
            jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel41Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton54)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton48)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton24)
                .addGap(7, 7, 7))
        );

        javax.swing.GroupLayout jPanel35Layout = new javax.swing.GroupLayout(jPanel35);
        jPanel35.setLayout(jPanel35Layout);
        jPanel35Layout.setHorizontalGroup(
            jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel35Layout.createSequentialGroup()
                .addComponent(jPanel40, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel41, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(631, Short.MAX_VALUE))
        );
        jPanel35Layout.setVerticalGroup(
            jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel35Layout.createSequentialGroup()
                .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel41, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel40, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(409, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Base Datos", new javax.swing.ImageIcon(getClass().getResource("/ico/basedatos.png")), jPanel35, ""); // NOI18N

        jPanel33.setBackground(new java.awt.Color(255, 255, 255));

        jButton35.setText("Buscar Actualizaciones");
        jButton35.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton35ActionPerformed(evt);
            }
        });

        jPanel63.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel61.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel61.setText("Contraseña Admnistrador");

        jTextField9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField9ActionPerformed(evt);
            }
        });

        jLabel62.setText("Anterior:");

        jLabel63.setText("Nueva:");

        jLabel66.setText("Confirmar:");

        jButton31.setText("Cambiar");
        jButton31.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton31ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel63Layout = new javax.swing.GroupLayout(jPanel63);
        jPanel63.setLayout(jPanel63Layout);
        jPanel63Layout.setHorizontalGroup(
            jPanel63Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel63Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel63Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel63Layout.createSequentialGroup()
                        .addGroup(jPanel63Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel66)
                            .addComponent(jLabel62, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel63, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel63Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField7)
                            .addComponent(jTextField8)
                            .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(34, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel63Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel63Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel63Layout.createSequentialGroup()
                                .addComponent(jButton31)
                                .addGap(100, 100, 100))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel63Layout.createSequentialGroup()
                                .addComponent(jLabel61, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(23, 23, 23))))))
        );
        jPanel63Layout.setVerticalGroup(
            jPanel63Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel63Layout.createSequentialGroup()
                .addComponent(jLabel61)
                .addGap(18, 18, 18)
                .addGroup(jPanel63Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel62))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel63Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel63))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel63Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel66)
                    .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton31)
                .addGap(0, 10, Short.MAX_VALUE))
        );

        jPanel64.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel157.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel157.setText("Licencia");

        jLabel158.setText("Tipo de licencia:");

        jLabel159.setText("Llave:");

        jLabel160.setText("Vencimiento:");

        jTextField32.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField32ActionPerformed(evt);
            }
        });

        jButton22.setText("Activar");

        javax.swing.GroupLayout jPanel64Layout = new javax.swing.GroupLayout(jPanel64);
        jPanel64.setLayout(jPanel64Layout);
        jPanel64Layout.setHorizontalGroup(
            jPanel64Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel64Layout.createSequentialGroup()
                .addGroup(jPanel64Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel64Layout.createSequentialGroup()
                        .addGap(169, 169, 169)
                        .addComponent(jLabel157))
                    .addGroup(jPanel64Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel64Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel159)
                            .addComponent(jLabel158)
                            .addComponent(jLabel160, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel64Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField32, javax.swing.GroupLayout.DEFAULT_SIZE, 298, Short.MAX_VALUE)
                            .addComponent(jTextField33)
                            .addComponent(jTextField34))))
                .addContainerGap(19, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel64Layout.createSequentialGroup()
                .addGap(0, 165, Short.MAX_VALUE)
                .addComponent(jButton22, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(156, 156, 156))
        );
        jPanel64Layout.setVerticalGroup(
            jPanel64Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel64Layout.createSequentialGroup()
                .addComponent(jLabel157)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel64Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel158)
                    .addComponent(jTextField32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel64Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel159)
                    .addComponent(jTextField33, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel64Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel160)
                    .addComponent(jTextField34, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton22)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton88.setText("FILECHEK");
        jButton88.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton88ActionPerformed(evt);
            }
        });

        jButton23.setText("Provar servidor");
        jButton23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton23ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel33Layout = new javax.swing.GroupLayout(jPanel33);
        jPanel33.setLayout(jPanel33Layout);
        jPanel33Layout.setHorizontalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel33Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel63, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel64, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton35, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton88, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 504, Short.MAX_VALUE))
        );
        jPanel33Layout.setVerticalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel33Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel33Layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(jButton88)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton35)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton23))
                    .addComponent(jPanel64, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel63, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(291, 438, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Sistema", new javax.swing.ImageIcon(getClass().getResource("/ico/sistema.png")), jPanel33, "Sistema"); // NOI18N

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane2)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 654, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 10, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Opciones", new javax.swing.ImageIcon(getClass().getResource("/ico/sistemag.png")), jPanel7); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1376, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 746, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(1376, 707));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    
    private Object dialogrselectorfecha(String titulo,String namme){
       Object datos2[]= new Object[1];
       
       
       
       
    
       return datos2;
    }
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       
        
        jTextField5.setEditable(true);
        jTextField5.setText("");
        
        jDialogTurnos.validate();
        jDialogTurnos.setLocationRelativeTo(null);
        jDialogTurnos.setModal(true);
        jDialogTurnos.setVisible(true);
      
      
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    
    
    
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed





        try {
            
            int filaseleccionada = jTable1.getSelectedRow();
            String nombre2 = (String)jTable1.getValueAt(filaseleccionada, 0);
            int optc=JOptionPane.showConfirmDialog(null, "Se eliminara: "+ "\n" +nombre2, "Confirmar ", JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
            
            if(optc==0){
            String sql = "delete  from turnos where nombre = '"+nombre2+"'";
            
            PreparedStatement us = Conexion.prepareStatement(sql);
            us.executeUpdate();
            us.close();
            JOptionPane.showMessageDialog(null, "Eliminado correctamente");
            }
        } catch (SQLException ex) {
            Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        actualizart_turnos();
        
     
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jTabbedPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane1MouseClicked
    
       
    }//GEN-LAST:event_jTabbedPane1MouseClicked
    
    public void inicializarcombofechas(){
        jChorentrada.removeAllItems();
        jChorentrada.addItem("00");
        jChorasalida.removeAllItems();
        jChorasalida.addItem("00");
        tiempocomida.removeAllItems();
        tiempocomida.addItem("00");
        for(int x=1;x<24;x++){
            jChorentrada.addItem(Integer.toString(x));
            jChorasalida.addItem(Integer.toString(x));
            tiempocomida.addItem(Integer.toString(x));
            
            
        }
        
        
        jCminutosentrada.removeAllItems();
        jCminutosentrada.addItem("00");
        jCminutosalida.removeAllItems();
        jCminutosalida.addItem("00");
        mincomida.removeAllItems();
        mincomida.addItem("00");
        for(int x=1;x<60;x++){
            jCminutosentrada.addItem(Integer.toString(x));
            jCminutosalida.addItem(Integer.toString(x));
            mincomida.addItem(Integer.toString(x));
        }









        inicializarcombopersonas();
    }
   
    public void inicializarcombopersonas(){
        DefaultComboBoxModel modeloCombottt = new DefaultComboBoxModel();
        modeloCombottt.removeAllElements();
        
        int rowww = jTable3.getRowCount();
        for(int x=0;x<rowww;x++){
            
            modeloCombottt.addElement(jTable3.getValueAt(x,1)); 
            
        }
        
            
            jComboBox1.setModel(modeloCombottt);
           
       
    }
    
    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        actualizart_registro();
    }//GEN-LAST:event_jButton10ActionPerformed
   
    private void formWindowIconified(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowIconified
      
    }//GEN-LAST:event_formWindowIconified

    private void menuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItem1ActionPerformed
        systemtray.remove(trayicon);
        this.setVisible(true);
        
        
    }//GEN-LAST:event_menuItem1ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        
        if(jTable3.getSelectedRow()!=-1){
        try {
            int filaseleccionada = jTable3.getSelectedRow();
            String codigo = String.valueOf(jTable3.getValueAt(jTable3.getSelectedRow(), 0));
            String nmbr = String.valueOf(jTable3.getValueAt(filaseleccionada, 1));
            int optc=JOptionPane.showConfirmDialog(null, "Se eliminara a: "+ "\n" +nmbr, "Confirmar ", JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
            
            if(optc==0){
                
            String sqlsalida= "UPDATE registro SET codigo = '0' where registro.codigo = '"+codigo+"'";
            String sql = "delete  from personal where codigo = '"+codigo+"'";

            PreparedStatement us = Conexion.prepareStatement(sql);
            us.executeUpdate();
            us.close();
            PreparedStatement uss = Conexion.prepareStatement(sqlsalida);
            uss.executeUpdate();
            uss.close();
            
            JOptionPane.showMessageDialog(null, "Eliminado correctamente");      
        }
        } catch (SQLException ex) {
            Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        actualizart_personal();
        }else{
            JOptionPane.showMessageDialog(null , "Favor de seleccionar un personal");
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        pararhilo = false;  
        conti=0;
        jButton25.setEnabled(true);
        
        reinicioauto = false;
        
        
       initnp();
        if(jTable3.getSelectedRow()!=-1){
            jButton5.setEnabled(false);
    
                    
            int filaseleccionada = jTable3.getSelectedRow();
            int codd=(int) jTable3.getValueAt(filaseleccionada, 0);
            //.out.print(codd);

            jComboBox10.removeAllItems();
            jComboBox10.addItem(Integer.toString(codd));
            jComboBox10.setEditable(false);
            
            jtnombre1.setText((String) jTable3.getValueAt(filaseleccionada, 1));
            jtlocalidad1.setText((String) jTable3.getValueAt(filaseleccionada, 2));
            jttelca1.setText((String) jTable3.getValueAt(filaseleccionada, 4));
            jttelcel1.setText((String) jTable3.getValueAt(filaseleccionada, 3));
            jtPUESTO.setText((String) jTable3.getValueAt(filaseleccionada, 7));
            jtlrfc.setText((String) jTable3.getValueAt(filaseleccionada, 8));
            jtnosocial1.setText((String) jTable3.getValueAt(filaseleccionada,9));
            
            try { 
        Thread.sleep(300);
        
        
    } catch (InterruptedException ex) {
        Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
    }
            
         try {
             
        ino.sendData("2");
        
    } catch (ArduinoException | SerialPortException ex) {
       
        jLabel46.setForeground(Color.red);
        jLabel46.setFont(new Font ("Serif", Font.BOLD, 16));
        jLabel46.setText("FALLA! CONEXION CON EL CHECADOR");
        Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
    }
        abrirdialog1();
        }else{
            JOptionPane.showMessageDialog(null, "Favor de seleccionar un persoal");
        }

    }//GEN-LAST:event_jButton5ActionPerformed

    public void abrirdialog1(){
    jDialog1.setLocationRelativeTo(null);
    jDialog1.setModal(true);
    jDialog1.setVisible(true);  
    }
    public void abrirdialog3(){
    DialogPermisos.setLocationRelativeTo(null);
    DialogPermisos.setModal(true);
    DialogPermisos.setVisible(true);  
    }
    
    public void abrirdialog4(){
    jDialog4.setLocationRelativeTo(null);
    jDialog4.setModal(true);
    jDialog4.setVisible(true);  
 
    
    }
    
    private void abrirdialog6(){
    jComboBox3.setModel(jComboBox1.getModel());
    jDialog6.setLocationRelativeTo(null);
    jDialog6.setModal(true);
    jDialog6.setVisible(true);  
    
    
    
    
    }
    
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
   jButton25.setEnabled(true);
   conti=0;
   reinicioauto = false;
   jLabel49.setVisible(false);
    jLabel50.setVisible(false);
   initnp();
   nuevopersonal();
   abrirdialog1();
    
   



    }//GEN-LAST:event_jButton2ActionPerformed
public String buscar(String entrada ,JTable turnos ) throws SQLException{
        String turencontrado="";
       
        Date d = new Date();
        Date dd = new Date();
        long max;
        long min;
        long entradaa;
        
        
        c.cargar();
        

        DefaultTableModel modelTablar;
        modelTablar=(DefaultTableModel) turnos.getModel();
        int row = modelTablar.getRowCount();
        
         for(int x=0;x<row;x++){
             
            try {
                
                d = hourFormat.parse( String.valueOf(modelTablar.getValueAt(row, 1)));
                dd = hourFormat.parse(entrada);
                
            } catch (ParseException ex) {
                Logger.getLogger(turnoauto.class.getName()).log(Level.SEVERE, null, ex);
            }
            
                max = (long) (d.getTime()+(1.8e+6));
                min = (long) (d.getTime()-(1.8e+6));
                entradaa= (long)(dd.getTime());
                
                
                if(min<=entradaa && max>=entradaa ){
                     turencontrado = String.valueOf(modelTablar.getValueAt(row, 0));
                 }      
                
            
         }
       
        if("".equals(turencontrado)){
            turencontrado="Libre";
        }
                
        
        return turencontrado;
        
    }
    int contador=0;
    public void resumenpersonal3(JTable tabla, String nombre3){
        
        int lineastabla = tabla.getRowCount();
        DateFormat diaaFormat = new SimpleDateFormat("yy/MM/EEEE");
        
        SimpleDateFormat formattiempo = new SimpleDateFormat("HH:mm");
        SimpleDateFormat formattiempo2 = new SimpleDateFormat("mm");
        DefaultTableModel modelo9 = (DefaultTableModel) tabla.getModel();
        DefaultTableModel modelo8 = new DefaultTableModel();
        
        modelo8.addColumn("Dia");
        modelo8.addColumn("Tiempo laborado");
        modelo8.addColumn("Tiempo en comida");
        modelo8.addColumn("Tolerancia");
        modelo8.addColumn("Retardo");
        
       // String principio[] = {nombre3};
       // modelo8.addRow(principio);
        ///////CACHE//////////////////////
        int contd = 0;
        
        Object fechacache = new Object();
        Object fechacache2 = new Object();
        
       
       
        Date tiemporun = new Date();
        Date tiemporun2 = new Date();
        
        Date tiempo_comidarun = new Date();
        Date tiempo_comidarun2 = new Date();
        
        
        long total_horas_de_trabajo_de_fecha = 0;
        long total_horas_de_comida_de_fecha = 0;
        long total_tiempo_de_comida_total = 0;
        
        Date tiempofinal = new Date();
        Date tiempofinal_comida = new Date();
        Date tiempototalcomida2= new Date();
    
        
        //////////////////////////////////
        int tolerancia=0;
        int retardo=0;
        
        int tolerancia2=0;
        int retardo2=0;
        
        boolean turnolibre=false;
        for(int i =0 ;lineastabla>i;i++){
            Date tiempototalcomida ;
            try {
                
                tiempototalcomida = formattiempo.parse(String.valueOf(modelo9.getValueAt(i, 5)));
                total_tiempo_de_comida_total += (long) tiempototalcomida.getTime() ;
              //  System.out.println(formattiempo.format(tiempototalcomida));
            } catch (ParseException ex) {
                Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
            
            
            try {
               
                
                
                
                
                
                fechacache = modelo9.getValueAt(i, 0);
                tiemporun = formattiempo.parse(String.valueOf(modelo9.getValueAt(i, 6)));               
                tiempo_comidarun = formattiempo.parse(String.valueOf(modelo9.getValueAt(i, 5)));
                
                String prueba1 = String.valueOf(modelo9.getValueAt(i, 1));
              
                
                if(prueba1.contains("T")){
                    tolerancia++;
                  
                }
                
                if(prueba1.contains("R")){
                    retardo++;
                    
                }
                
                
                if(contd!=0){
                    
                    fechacache2 = modelo8.getValueAt( contd-1,0);
                    if(String.valueOf(modelo8.getValueAt(contd-1, 1 ))=="----"){
                        
                    }else{
                    tiemporun2 = formattiempo.parse(String.valueOf(modelo8.getValueAt(contd-1, 1 )));
                    }
                    tiempo_comidarun2 = formattiempo.parse(String.valueOf(modelo8.getValueAt(contd-1, 2 )));
                    
                    retardo2 = Integer.parseInt(String.valueOf(modelo8.getValueAt(contd-1, 4 )));
                    tolerancia2 = Integer.parseInt(String.valueOf(modelo8.getValueAt(contd-1, 3 )));        
              
                }
         
            } catch (ParseException ex) {
                Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
            
            if(i!=0){
                
                if(fechacache.equals(fechacache2)){
                    
                    total_horas_de_trabajo_de_fecha = (long) (tiemporun.getTime()+tiemporun2.getTime()-2.16e+7);
                    total_horas_de_comida_de_fecha = (long) (tiempo_comidarun.getTime()+tiempo_comidarun2.getTime()-2.16e+7);
                    
                    tiempofinal.setTime(total_horas_de_trabajo_de_fecha);
                    tiempofinal_comida.setTime(total_horas_de_comida_de_fecha);
                    
                    modelo8.setValueAt(formattiempo.format(tiempofinal), contd-1, 1);
                    modelo8.setValueAt(formattiempo.format(tiempofinal_comida), contd-1, 2);
                    
                    modelo8.setValueAt(tolerancia,contd-1, 3);
                    modelo8.setValueAt(retardo,contd-1, 4);
                    tolerancia=0;
                    retardo=0;
                   
                    
                }else{
                String dated2[] = {String.valueOf(fechacache),formattiempo.format(tiemporun),formattiempo.format(tiempo_comidarun),Integer.toString(tolerancia),Integer.toString(retardo)};     
                
                modelo8.addRow(dated2);
                
                tolerancia=0;
                retardo=0;
                contd++;
                    
                
                }
                
                
                
            }else{
                String dated[] = {String.valueOf(fechacache),formattiempo.format(tiemporun),formattiempo.format(tiempo_comidarun),Integer.toString(tolerancia),Integer.toString(retardo)}; 
                
                modelo8.addRow(dated);
                contd++;
                
            }
            
         if(String.valueOf(modelo9.getValueAt(1, 7 ))=="Libre"){
             turnolibre=true;
         }
         
        } 
        
       // System.out.println(total_tiempo_de_comida_total); 
        tiempototalcomida2.setTime((long) (total_tiempo_de_comida_total-2.16e+7));
        
        if(turnolibre){
            String dated4[] = {"TOTALES",labetotalhoras.getText(),"00:00",labetolerancia.getText(),laberetardos.getText()};
            modelo8.addRow(dated4);
        }else{
             String dated3[] = {"TOTALES",labetotalhoras.getText(),formattiempo.format(tiempototalcomida2),labetolerancia.getText(),laberetardos.getText()};
             modelo8.addRow(dated3);
        }
       
        jTable13.setModel(modelo8); 
    }
    
    public ArrayList resumenpersonal4(JTable tabla, String nombre3){
        
        ArrayList dats = null;
      
        
        int lineastabla = tabla.getRowCount();
        DateFormat diaaFormat = new SimpleDateFormat("yy/MM/EEEE");
        
        SimpleDateFormat formattiempo = new SimpleDateFormat("HH:mm");
        SimpleDateFormat formattiempo2 = new SimpleDateFormat("mm");
        DefaultTableModel modelo9 = (DefaultTableModel) tabla.getModel();
        DefaultTableModel modelo8 = new DefaultTableModel();
        
        modelo8.addColumn("Dia");
        modelo8.addColumn("Tiempo laborado");
        modelo8.addColumn("Tiempo en comida");
        modelo8.addColumn("Tolerancia");
        modelo8.addColumn("Retardo");
        
       // String principio[] = {nombre3};
       // modelo8.addRow(principio);
        ///////CACHE//////////////////////
        int contd = 0;
        
        Object fechacache = new Object();
        Object fechacache2 = new Object();
        
       
       
        Date tiemporun = new Date();
        Date tiemporun2 = new Date();
        
        Date tiempo_comidarun = new Date();
        Date tiempo_comidarun2 = new Date();
        
        
        long total_horas_de_trabajo_de_fecha = 0;
        long total_horas_de_comida_de_fecha = 0;
        long total_tiempo_de_comida_total = 0;
        
        Date tiempofinal = new Date();
        Date tiempofinal_comida = new Date();
        Date tiempototalcomida2= new Date();
    
        
        //////////////////////////////////
        int tolerancia=0;
        int retardo=0;
        
        int tolerancia2=0;
        int retardo2=0;
        
        boolean turnolibre=false;
        for(int i =0 ;lineastabla>i;i++){
            Date tiempototalcomida ;
            try {
                
                tiempototalcomida = formattiempo.parse(String.valueOf(modelo9.getValueAt(i, 5)));
                total_tiempo_de_comida_total += (long) tiempototalcomida.getTime() ;
               // System.out.println(formattiempo.format(tiempototalcomida));
            } catch (ParseException ex) {
                Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
            
            
            try {
               
                
                
                
                
                
                fechacache = modelo9.getValueAt(i, 0);
                tiemporun = formattiempo.parse(String.valueOf(modelo9.getValueAt(i, 6)));               
                tiempo_comidarun = formattiempo.parse(String.valueOf(modelo9.getValueAt(i, 5)));
                
                String prueba1 = String.valueOf(modelo9.getValueAt(i, 1));
              
                
                if(prueba1.contains("T")){
                    tolerancia++;
                  
                }
                
                if(prueba1.contains("R")){
                    retardo++;
                    
                }
                
                
                if(contd!=0){
                    
                    fechacache2 = modelo8.getValueAt( contd-1,0);
                    if(String.valueOf(modelo8.getValueAt(contd-1, 1 ))=="----"){
                        
                    }else{
                    tiemporun2 = formattiempo.parse(String.valueOf(modelo8.getValueAt(contd-1, 1 )));
                    }
                    tiempo_comidarun2 = formattiempo.parse(String.valueOf(modelo8.getValueAt(contd-1, 2 )));
                    
                    retardo2 = Integer.parseInt(String.valueOf(modelo8.getValueAt(contd-1, 4 )));
                    tolerancia2 = Integer.parseInt(String.valueOf(modelo8.getValueAt(contd-1, 3 )));        
              
                }
         
            } catch (ParseException ex) {
                Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
            
            if(i!=0){
                
                if(fechacache.equals(fechacache2)){
                    
                    total_horas_de_trabajo_de_fecha = (long) (tiemporun.getTime()+tiemporun2.getTime()-2.16e+7);
                    total_horas_de_comida_de_fecha = (long) (tiempo_comidarun.getTime()+tiempo_comidarun2.getTime()-2.16e+7);
                    
                    tiempofinal.setTime(total_horas_de_trabajo_de_fecha);
                    tiempofinal_comida.setTime(total_horas_de_comida_de_fecha);
                    
                    modelo8.setValueAt(formattiempo.format(tiempofinal), contd-1, 1);
                    modelo8.setValueAt(formattiempo.format(tiempofinal_comida), contd-1, 2);
                    
                    modelo8.setValueAt(tolerancia,contd-1, 3);
                    modelo8.setValueAt(retardo,contd-1, 4);
                    tolerancia=0;
                    retardo=0;
                   
                    
                }else{
                String dated2[] = {String.valueOf(fechacache),formattiempo.format(tiemporun),formattiempo.format(tiempo_comidarun),Integer.toString(tolerancia),Integer.toString(retardo)};     
                
                modelo8.addRow(dated2);
                
                tolerancia=0;
                retardo=0;
                contd++;
                    
                
                }
                
                
                
            }else{
                String dated[] = {String.valueOf(fechacache),formattiempo.format(tiemporun),formattiempo.format(tiempo_comidarun),Integer.toString(tolerancia),Integer.toString(retardo)}; 
                
                modelo8.addRow(dated);
                contd++;
                
            }
            
         if(String.valueOf(modelo9.getValueAt(1, 7 ))=="Libre"){
             turnolibre=true;
         }
         
        } 
        
        //System.out.println(total_tiempo_de_comida_total); 
        tiempototalcomida2.setTime((long) (total_tiempo_de_comida_total-2.16e+7));
        
        if(turnolibre){
            String dated4[] = {"TOTALES",labetotalhoras.getText(),"00:00",labetolerancia.getText(),laberetardos.getText()};
            modelo8.addRow(dated4);
        }else{
             String dated3[] = {"TOTALES",labetotalhoras.getText(),formattiempo.format(tiempototalcomida2),labetolerancia.getText(),laberetardos.getText()};
             modelo8.addRow(dated3);
        }
        
        
       dats.add(nombre3);
       dats.add(labetotalhoras.getText());
       dats.add(formattiempo.format(tiempototalcomida2));
       dats.add(labetolerancia);
       dats.add(laberetardos);
       
        
        return dats;
    }
    
    public void resumenTurnoResu(String nombre3, String fecha1, String fecha2){
  
        try {
            DefaultTableModel modelofinal = new DefaultTableModel();
            JTable buffer = new JTable();
                    
                    Conexion = (Connection) DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306","root","");
                    PreparedStatement us = Conexion.prepareStatement("Select codigo from personal where turno like '%"+nombre3+"%' and fecha BETWEEN '"+fecha1+"' and '"+fecha2+"' order by indx DESC");
                    
                    ResultSet res = us.executeQuery();
                    
                    Object datos[]= new Object[1];
                    
                    while(res.next()){
                    //System.out.println("resultados obtenidos");
                    for(int i=0; i<1;i++){
        
                    datos[i]= res.getObject(i+1);
                    
                    rporpersonalr(fecha1, fecha2,String.valueOf(res.getObject(i+1)));
                    
                    
                    }
                    
                    
                     }
                    us.close();
                    
                    
        } catch (SQLException ex) {
            Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    public void resuumenpersonal(JTable tabla,String nombre3){
        
     String fecha1 = fechaFormat.format(jdde.getDate());
     String fecha2 = fechaFormat.format(jda.getDate());
     
     Date fechaInicio=new Date();
     Date fechaFin=new Date();
     Date fechaInicioC=new Date();
     Date fechaFinC=new Date();
     Object lineas = "----";
     
     Calendar c = Calendar.getInstance();
     Calendar cc = Calendar.getInstance();
     
     cc.setTime(jdde.getDate());
     c.setTime(jda.getDate());
     
     
    
    

     DateFormat diaaFormat = new SimpleDateFormat("yy/MM/EEEE");
     Date dat = new Date();
     
     
     diseñotab5();
    
     DefaultTableModel modelo8 = (DefaultTableModel) tabla.getModel();
     
     long total_horas_de_trabajo_de_fecha = 0;
     long total_horas_de_comida_de_fecha = 0;
     int total_faltas_de_fecha = 0;
     int total_retardos_de_fecha = 0;
     Object datos[] = new Object[5];
     Object dato[]= new Object[12];
     //Domingo 1, lunes 2, martes 3, miercoles 4, jueves 5, viernes 6, Sabado 7
        
    // System.out.println(fechaFormat.format(cc.getTime()));
     if(cc.before(c)){
        
     int dia_de_semana1 = cc.get(Calendar.DAY_OF_WEEK)+1;
    // System.out.println(fechaFormat.format(c.getTime()));
     String fechaf = fechaFormat.format(cc.getTime());      
     String sqlnombre = "Select fecha,entrada,c_entrada,c_salida,salida from registro where personal like '%"+nombre3+"%' and fecha = '"+fechaf+"' order by indx DESC";
     
     
     
         try {
             
             PreparedStatement us;
             us = Conexion.prepareStatement(sqlnombre);
             ResultSet res = us.executeQuery();
            // System.out.println(sqlnombre);
                  
             while(res.next()){
             
                  for(int i=0; i<5;i++){               
                    
                    datos[i]= res.getObject(i+1);
                     
                    if(i==4){
                    
                    String hentrada = String.valueOf(datos[1]); 
                     // System.out.println(hentrada);
                    String hsalida = String.valueOf(datos[4]);
                   //  System.out.println(hsalida);
                    String hcentrada = String.valueOf(datos[2]);
                   //  System.out.println(hcentrada);
                    String hcsalida = String.valueOf(datos[3]);
                   //  System.out.println(hcsalida);
                    
                    
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
                    
                    
                    total_horas_de_trabajo_de_fecha = total_horas_de_trabajo_de_fecha + resta;
                    
                    String tiempofinalC = (horaC+":"+minutoC);
                    i++;
                    //dato[4] = tiempofinalC;
                    
                    String tiempofinal = (hora + ":" + minuto);
                    i++;
                  
                    
                    
                    
                     dat.setTime((long) (total_horas_de_trabajo_de_fecha-6.48e+7));
                     }
                     
                  }
                    
             }
             dato[dia_de_semana1]= hourFormat.format(dat);
             modelo8.addRow(dato);
             us.close();
          
         } catch (SQLException ex) {
             Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
         }
    
    
     
     cc.add(Calendar.DAY_OF_WEEK, +1);
     }
     
     jTable13.setModel(modelo8);
        
    }
    
    public void rporpersonal(String fecha1,String fecha2,String fecha3, String fecha4, String nombre3){
  
       
        
        DefaultTableModel modelTabla5 = (DefaultTableModel) jTable13.getModel();
              while(modelTabla5.getRowCount()>0)modelTabla5.removeRow(0);
              
                jTable13.setModel(modelTabla5);
                laberetardos.setText("0");
                labetolerancia.setText("0");
                labetotalhoras.setText("00:00");
                
        
       // System.out.println("Borrotablas"+contador);
        

        String sqlnombre = "Select fecha,entrada,c_entrada,c_salida,salida,turnoreg from registro where personal like '%"+nombre3+"%' and fecha BETWEEN '"+fecha1+"' and '"+fecha2+"' order by fecha ASC";
        String columna[]= {"Fecha","ENTRADA","EN.COMIDA","SA.COMIDA","SALIDA","T.Comida","T.Horas","Turno"};

        
        
        act_t1.actualizarp(jTable13, sqlnombre, 8, columna,jTable1);
       System.out.println("relleno tabla"+contador);
        contador++;
         
        
        DefaultTableModel  m2 = (DefaultTableModel) jTable13.getModel();
            
            if(m2.getRowCount()!=0){
               
           
                act_t1.colorear(jTable13, jTable1, 10);
                 try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
            }
                contar(jTable13);

            }
             diseñotab2();
              
               jTable13.setDefaultRenderer(Object.class, new FormatoTabla());
       
           
              
              
               
             
               
              

    }
    
    public JTable rporpersonalr(String fecha1,String fecha2, String nombre3){
        JTable retu = new JTable();
       
        
        DefaultTableModel modelTabla5 = (DefaultTableModel) jTable13.getModel();
              while(modelTabla5.getRowCount()>0)modelTabla5.removeRow(0);
                jTable13.setModel(modelTabla5);
                laberetardos.setText("0");
                labetolerancia.setText("0");
                labetotalhoras.setText("00:00");
                
        
      //  System.out.println("Borrotablas"+contador);
        

        String sqlnombre = "Select fecha,entrada,c_entrada,c_salida,salida,turnoreg from registro where personal like '%"+nombre3+"%' and fecha BETWEEN '"+fecha1+"' and '"+fecha2+"' order by fecha ASC";
        String columna[]= {"Fecha","ENTRADA","EN.COMIDA","SA.COMIDA","SALIDA","T.Comida","T.Horas","Turno"};

        
        
        act_t1.actualizarp(retu, sqlnombre, 8, columna,jTable1);
     //   System.out.println("relleno tabla"+contador);
        contador++;
         
        
        DefaultTableModel  m2 = (DefaultTableModel) jTable13.getModel();
            
            if(m2.getRowCount()!=0){
               
           
                act_t1.colorear(retu, jTable1, 10);
                 try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
            }
                contar(retu);

            }
             diseñotab2();
              
    
     return retu;
    }
    
    public void rporturno(String fecha1,String fecha2, String nombre3){
        
        
        
        DefaultTableModel modelTabla5 = (DefaultTableModel) jTable13.getModel();
        while(modelTabla5.getRowCount()>0)modelTabla5.removeRow(0);
       
                jTable13.setModel(modelTabla5);
                laberetardos.setText("0");
                labetolerancia.setText("0");
                labetotalhoras.setText("00:00");
                
        
       // System.out.println("Borrotablas"+contador);
        List list = new ArrayList();
        String sqlnombresturno = "Select nombre from personal where turno like '%"+nombre3+"%' order by indx DESC";
        System.out.println(nombre3);
        PreparedStatement us;
        try {
            
            us = Conexion.prepareStatement(sqlnombresturno);
            ResultSet res = us.executeQuery();
            int c=0;
               while(res.next()){
                   
               list.add(res.getObject(1));      
                       
                       }
               
             us.close();
               
               
             
        } catch (SQLException ex) {
            Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
        }
       
       
        String columna[]= {"Fecha","PERSONAL","ENTRADA","EN.COMIDA","SA.COMIDA","SALIDA ","T.Comida","T.Horas"};
        modelTabla = new DefaultTableModel(null,columna){
        public boolean isCellEditable(int rowIndex, int mColIndex) {
        return false;
        }};
        
        jTable13.setModel(modelTabla);
        
        for(int p=0;p<=list.size()-1;p++){
          //  System.out.println(list.get(p));
            String sqlnombre = "Select fecha,personal,entrada,c_entrada,c_salida,salida from registro where personal like '%"+list.get(p)+"%' and fecha BETWEEN '"+fecha1+"' and '"+fecha2+"' order by indx ASC";
            String columna2[]= {"Fecha","PERSONAL","ENTRADA","EN.COMIDA","SA.COMIDA","SALIDA ","T.Comida","T.Horas"};
            

            
            
            
            act_t1.actualizart(jTable13, sqlnombre,8, columna2,jTable1);
            
        }
       
//        String columna2[]= {"FECHA","PERSONAL","ENTRADA","EN.COMIDA","SA.COMIDA","SALIDA ","T.COMIDA","T.HORAS"};
//       
//        JTableHeader tableHeader = jTable13.getTableHeader();
//        TableColumnModel tableColumnModel = tableHeader.getColumnModel();
//        
//        for(int i = 0;i<=7;i++){
//                TableColumn tableColumn = tableColumnModel.getColumn(i);
//                tableColumn.setHeaderValue( columna2[i] );
//                 tableHeader.repaint();
//          
//        }
    
        
        
        
        diseñotab4();
        
    }

    private void popupMenu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_popupMenu1ActionPerformed
       
    }//GEN-LAST:event_popupMenu1ActionPerformed

    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField5ActionPerformed

    private void jBcancelarturnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBcancelarturnoActionPerformed
       jDialogTurnos.dispose();
       
    }//GEN-LAST:event_jBcancelarturnoActionPerformed

    private void jBaceptarturnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBaceptarturnoActionPerformed

            int he;
            int me;

            int hs;
            int ms;

            he = Integer.parseInt(String.valueOf(jChorentrada.getSelectedItem()));
            me = Integer.parseInt(String.valueOf(jCminutosentrada.getSelectedItem()));

            hs = Integer.parseInt(String.valueOf(jChorasalida.getSelectedItem()));
            ms = Integer.parseInt(String.valueOf(jCminutosalida.getSelectedItem()));

            float erl = (he*60)+me;
            float srl = (hs*60)+ms;
            float fn;

            if(erl>srl){
                fn = (((24*60)-erl )+( srl))/60;

            }else{

                fn = (srl-erl)/60;

            }
            int i = JOptionPane.showConfirmDialog(null, "El tiempo de jornada laboral sera de : "+fn+" Horas ", "Confirmar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            
           String dias = "";
           
          if(jCheckBox2.isSelected()){
              dias+="L";
          }
          if(jCheckBox3.isSelected()){
              dias+="M";
          }
          if(jCheckBox4.isSelected()){
              dias+="X";
          }
          if(jCheckBox5.isSelected()){
              dias+="J";
          }
          if(jCheckBox6.isSelected()){
              dias+="V";
          }
          if(jCheckBox7.isSelected()){
              dias+="S";
          }
          if(jCheckBox8.isSelected()){
              dias+="D";
          }
           
            System.err.println(dias);
            if(i==0){
               
                String nombre3 = jTextField5.getText();

                String entrada = String.valueOf(jChorentrada.getSelectedItem()+":"+String.valueOf(jCminutosentrada.getSelectedItem()));
                String tiempo_comida = String.valueOf(tiempocomida.getSelectedItem()+":"+String.valueOf(mincomida.getSelectedItem()));
                String salida = String.valueOf(jChorasalida.getSelectedItem()+":"+String.valueOf(jCminutosalida.getSelectedItem()));


                    insertarturno(nombre3, entrada, tiempo_comida, salida, dias);
                    
                    
                    actualizart_turnos();


            }
        
        jDialogTurnos.dispose();
    }//GEN-LAST:event_jBaceptarturnoActionPerformed
corte cor = new corte();
    private void jPanel7ComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jPanel7ComponentHidden
        //        jTextField1.setText(c.getUrl());
        //        jTextField2.setText(c.getUser());
        //        jTextField3.setText(c.getPass());
    }//GEN-LAST:event_jPanel7ComponentHidden

    private void jPanel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel7MouseClicked

    }//GEN-LAST:event_jPanel7MouseClicked

    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17ActionPerformed
        JOptionPane.showConfirmDialog(null, "Borrar BD del sensor puede dejar inutilizable el registro de personal?", "BORRAR BD DEL SENSOR", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
    }//GEN-LAST:event_jButton17ActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
      try {
            String sqlcorreccion = "SELECT * FROM registro order by indx DESC";
            String columnassqlcorreccion[]= {"indx","codigo","personal","entrada","c_entrada","c_salida","salida","fecha"};
            act_t.actualizartdo(jTable2, sqlcorreccion, 8, columnassqlcorreccion );
        } catch (SQLException ex) {
            Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton15ActionPerformed


    private void jTabbedPane1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTabbedPane1FocusGained
        
    }//GEN-LAST:event_jTabbedPane1FocusGained

    private void jButton20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton20ActionPerformed
        cor.corte();

    }//GEN-LAST:event_jButton20ActionPerformed
public void checada_manual(){
    
         
     if(!jTextField4.getText().contains(" ")){
        try {
            
            int idm = Integer.parseInt(jTextField4.getText());
            id= Integer.toString(idm);
            id.trim();
            String sql="Select codigo from personal where codigo ="+idm;
            System.out.println(idm);
            PreparedStatement us = Conexion.prepareStatement(sql);
            ResultSet res = us.executeQuery();

            if(res.next()){

                jLabel26.setText(String.valueOf(res.getObject(1)));
                ob_nombre();
            JOptionPane.showMessageDialog(null, "Registro con exito");

            }else{

                JOptionPane.showMessageDialog(null, "ID de personal no encontrado","Advertencia",JOptionPane.WARNING_MESSAGE);
               
            }
          us.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error accionbuton"+ ex);
            Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
        }
     }else{
         JOptionPane.showMessageDialog(null, "Insertar ID sin espacio");
     }
        
        actualizart_registro();
        jTextField4.setText("");
}
    private void jButton24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton24ActionPerformed
         act_tabla();
        //JOptionPane.showMessageDialog(null, "act_taab");
        actualizart_turnos();
        //JOptionPane.showMessageDialog(null, "actualizar_tur");
        actualizart_registro();
       // JOptionPane.showMessageDialog(null, "actualizar_reg");
        actualizart_personal(); 
       JOptionPane.showMessageDialog(null, "Actualizacion exitosa");
    }//GEN-LAST:event_jButton24ActionPerformed

    private void jButton25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton25ActionPerformed
       
        jLhuella.setIcon(imgregristro(4));
        
        jLabel46.setForeground(Color.red);
        jLabel46.setFont(new Font ("Serif", Font.BOLD, 18));
        jLabel46.setText("COLOCAR DEDO EN EL SENSOR");
        
        jButton26.setEnabled(false);
        jButton27.setEnabled(false);
        
        String id2 = (String) jComboBox10.getSelectedItem();

        try {
            ino.sendData(id2);
        } catch (ArduinoException | SerialPortException ex) {
            Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton25ActionPerformed

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
       if(jRadioButton10.isSelected()){
       c.setPort("auto");
    }else{ 
       c.setPort(String.valueOf(jComboBox8.getItemAt(jComboBox8.getSelectedIndex())));
            }
       c.guardartodo();
    }//GEN-LAST:event_jButton16ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
       
        
        if(jTable4.getSelectedRow()== -1){
           
           JOptionPane.showMessageDialog(null, "No hay permiso seleccionado");
        }else{
       int filaseleccionada = jTable4.getSelectedRow();
       String indxx= String.valueOf(jTable4.getValueAt(filaseleccionada, 0));
       String mnj1 = String.valueOf(jTable4.getModel().getValueAt(filaseleccionada, 5));
       String nombr = String.valueOf(jTable4.getModel().getValueAt(filaseleccionada, 4));
       int optc = JOptionPane.showConfirmDialog(null, "Se permiso folio: "+ indxx+ "\n Para:" +nombr, "Confirmar ", JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
            
            if(optc==0){
                
            
           try {
               String sql = "delete  from permisos where indx = '"+indxx+"'";
               
               PreparedStatement us = Conexion.prepareStatement(sql);
               us.executeUpdate();
               us.close();
              
                    
               JOptionPane.showMessageDialog(jPanel8, "Eliminado correctamente");
              
           } catch (SQLException ex) {
               Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
           }
            }
            actualizart_permisos();
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jComboBox4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox4ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
    DefaultComboBoxModel modeloCombotttt = new DefaultComboBoxModel();
    modeloCombotttt.removeAllElements();
    
    
    int roww = jTable3.getRowCount() ;

    for(int x=0;x<roww;x++){
       
        modeloCombotttt.addElement(jTable3.getValueAt(x,1));
        
        
    }   
        jComboBox6.setModel(modeloCombotttt);
        
        abrirdialog3();
    }//GEN-LAST:event_jButton4ActionPerformed
    
    private void jComboBox6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox6ActionPerformed
    

    }//GEN-LAST:event_jComboBox6ActionPerformed

    private void jRadioButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton4ActionPerformed

    private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton18ActionPerformed
        DialogPermisos.dispose();
    }//GEN-LAST:event_jButton18ActionPerformed

    private void jButton28ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton28ActionPerformed
        
       
            String fecha_inicio;
            String fecha_final;
            String aplica_a;
            String tipo;
            String motivo;
            String autorizado;
            
            fecha_inicio = fechaFormat.format(jCalendar3.getDate());
            fecha_final = fechaFormat.format(jCalendar4.getDate());
            aplica_a = String.valueOf(jComboBox6.getSelectedItem());
            tipo = String.valueOf(jComboBox5.getSelectedItem());
            
            
            motivo = String.valueOf(jComboBox25.getSelectedItem()+"/"+String.valueOf(jComboBox26.getSelectedItem()));
           
            
            //Conexion = (Connection) DriverManager.getConnection(c.getUrl(),c.getUser(),c.getPass());
            PreparedStatement enrollItmt;
                
            try {
            if(jRadioButton3.isSelected()){
                
                enrollItmt = Conexion.prepareStatement("INSERT INTO permisos (fecha_inicio,fecha_final,aplica_a,tipo,motivo,autorizado) VALUES ('"+fecha_inicio+"','"+fecha_final+"','"+aplica_a+"','"+tipo+"','"+motivo+"','si')");
                enrollItmt.execute();
                
                
                JOptionPane.showMessageDialog(null,"Permiso autorizado y agregado correctamente");
                
            }else{
                
                enrollItmt = Conexion.prepareStatement("INSERT INTO permisos (fecha_inicio,fecha_final,aplica_a,tipo,motivo,autorizado) VALUES ('"+fecha_inicio+"','"+fecha_final+"','"+aplica_a+"','"+tipo+"','"+motivo+"','no')");
                enrollItmt.execute();
                JOptionPane.showMessageDialog(null,"Permiso sin autorizar agregado correctamente");
            }
        } catch (Exception e) {
        }
            
            
        
        


        actualizart_permisos();
        DialogPermisos.dispose();
    }//GEN-LAST:event_jButton28ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
      
       if(jTable4.getSelectedRow()== -1){
           
           JOptionPane.showMessageDialog(null, "No hay permiso seleccionado");
           
           
       }else{
       int filaseleccionada = jTable4.getSelectedRow();
       String indxx= String.valueOf(jTable4.getValueAt(filaseleccionada, 0));
       String mnj1 = String.valueOf(jTable4.getModel().getValueAt(filaseleccionada, 6));
       String tipo =  String.valueOf(jTable4.getModel().getValueAt(filaseleccionada, 5));
       String nombr = String.valueOf(jTable4.getModel().getValueAt(filaseleccionada, 4));
       int optc = JOptionPane.showConfirmDialog(null, "Se autoriza a : "+nombr+"..."+ "\nPermiso de : " +tipo+"\nPor motivo de : "+mnj1, "Confirmar ", JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
       
       if(optc==0){
                
            
           try {
               String sql= "UPDATE permisos SET autorizado = 'si' where permisos.indx = '"+indxx+"'";
               
               PreparedStatement us = Conexion.prepareStatement(sql);
               us.executeUpdate();
               us.close();
               
                    
               JOptionPane.showMessageDialog(null, "Autorizado correctamente");
           } catch (SQLException ex) {
               Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
           }
            }
            actualizart_permisos();
       }
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton29ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton29ActionPerformed
       
        if(jTable4.getSelectedRow()== -1){
           
           JOptionPane.showMessageDialog(null, "No hay permiso seleccionado");
        }else{
       int filaseleccionada = jTable4.getSelectedRow();
       String indxx= String.valueOf(jTable4.getValueAt(filaseleccionada, 0));
       String mnj1 = String.valueOf(jTable4.getModel().getValueAt(filaseleccionada, 6));
       String tipo =  String.valueOf(jTable4.getModel().getValueAt(filaseleccionada, 5));
       String nombr = String.valueOf(jTable4.getModel().getValueAt(filaseleccionada, 4));
       int optc = JOptionPane.showConfirmDialog(null, "Se denega a : "+nombr+"..."+ "\nPermiso de : " +tipo+"\nPor motivo de : "+mnj1, "Confirmar ", JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
       
       if(optc==0){
                
            
           try {
               String sql= "UPDATE permisos SET autorizado = 'no' where permisos.indx = '"+indxx+"'";
               
               PreparedStatement us = Conexion.prepareStatement(sql);
               us.executeUpdate();
               us.close();
               
                    
               JOptionPane.showMessageDialog(null, "Denegado correctamente");
               
           } catch (SQLException ex) {
               Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
           }
            }
            actualizart_permisos();
        }
            
            
    }//GEN-LAST:event_jButton29ActionPerformed
graficas g = new graficas();
    private void jButton30ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton30ActionPerformed
        graficar();
    }//GEN-LAST:event_jButton30ActionPerformed

    private void jButton27ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton27ActionPerformed
        reinicioauto = true;
        insertar();
        jButton5.setEnabled(true);
        jDialog1.dispose();
    }//GEN-LAST:event_jButton27ActionPerformed

    private void jButton26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton26ActionPerformed
        reinicioauto= true;
        
        try {
            ino.sendData("124");
        } catch (ArduinoException | SerialPortException ex) {
            
            Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
        }

        jDialog1.dispose();
        jButton5.setEnabled(true);

    }//GEN-LAST:event_jButton26ActionPerformed

    private void jtnombre1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtnombre1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtnombre1ActionPerformed

    private void jttelca1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jttelca1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jttelca1ActionPerformed

    private void jComboBox7MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox7MouseReleased
       
        
    }//GEN-LAST:event_jComboBox7MouseReleased

    private void jComboBox7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox7MouseClicked
    
    }//GEN-LAST:event_jComboBox7MouseClicked

    private void jComboBox7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox7ActionPerformed
         
        String seleccion = String.valueOf(jComboBox7.getSelectedItem());
        
        if(seleccion.equals("Personalizado")){
            jDialogTurnos.setLocationRelativeTo(null);
            jDialogTurnos.setModal(true);
            jTextField5.setText("Personalizado-"+String.valueOf(jComboBox10.getSelectedItem()));
            jLabel5.setText("Personalizado-"+String.valueOf(jComboBox10.getSelectedItem()));
        
            jTextField5.setEditable(false);
            
            jDialogTurnos.setVisible(true);
          
            
            
            
            DialogPermisos.validate();
            
            
            
        }else{
            
            jLabel5.setText("");
            
        }
        
        if(seleccion.equals("Mixto")){
            jPanel13.setVisible(true);
            
            jLabel49.setVisible(true);
            jLabel50.setVisible(true);
            
            jComboBox11.setEnabled(true);
            jComboBox12.setEnabled(true);
            
            
        }else{
            
           
            jPanel13.setVisible(false);
            
            jLabel49.setVisible(false);
            jLabel50.setVisible(false);
            
            jComboBox11.setEnabled(false);
            jComboBox12.setEnabled(false);
            
        }
    }//GEN-LAST:event_jComboBox7ActionPerformed

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        
        if(jCheckBox1.isSelected()){
            setPanelEnabled(jPanel16, true);
        }else{
            setPanelEnabled(jPanel16, false);
        }
        
        
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void jButton31ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton31ActionPerformed
        String tpass  = c.getPassbd();
        String ttpass = jTextField7.getText();
        String nuevapass = jTextField8.getText();
        String confnuevapass = jTextField9.getText();
        
        if(nuevapass.equals(confnuevapass)){
        
        if(tpass.equals(ttpass)){
            c.setPassbd(nuevapass);
            c.guardartodo();
            JOptionPane.showMessageDialog(null, "Contrseña cambiada Correctamente");
        }else{
        JOptionPane.showMessageDialog(null, "Contraseña Anterior Incorrecta");
        
        }
        
    }else{
            JOptionPane.showMessageDialog(null, "Contrseña nueva no coincide");
        }
        
    }//GEN-LAST:event_jButton31ActionPerformed

    
    
    private void jPanel4FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jPanel4FocusGained
       jDialog4.setVisible(true);
    }//GEN-LAST:event_jPanel4FocusGained

    
    
    public void acceso(){
        String pa = c.getPassbd();
        String paa = new String (jPasswordField1.getPassword());
        
        if(pa.equals(paa)){
          //  System.out.println(jPasswordField1.getPassword());
               jLabel9.setIcon(new ImageIcon(getClass().getResource("/ico/ca2.png")));
               jTabbedPane1.setEnabled(true);
               jButton9.setEnabled(true);
               jTextField4.setEnabled(true);
               jTabbedPane1.setSelectedIndex(ventana_solicitada);
               jDialog4.dispose();
               jPasswordField1.setText("");
           }else{
           jPasswordField1.setText("");
            jLabel10.setText("CONTRASEÑA INCORRECTA");
           }
       
    }
     
    
    
    private void jTabbedPane1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane1MousePressed
        int itme =jTabbedPane1.getSelectedIndex();
        ventana_solicitada=itme;
        
        if(!jTabbedPane1.isEnabled()){
           jLabel10.setText("");
           abrirdialog4();
        }
    }//GEN-LAST:event_jTabbedPane1MousePressed

    private void jTextField9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField9ActionPerformed

    private void jButton33ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton33ActionPerformed
        jTabbedPane1.setSelectedIndex(0);
        jPasswordField1.setText("");
        jDialog4.dispose();

    }//GEN-LAST:event_jButton33ActionPerformed

    private void jButton32ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton32ActionPerformed
        acceso();
    }//GEN-LAST:event_jButton32ActionPerformed

    private void jPasswordField1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPasswordField1KeyPressed

        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            acceso();
        }
    }//GEN-LAST:event_jPasswordField1KeyPressed

    private void jPasswordField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPasswordField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPasswordField1ActionPerformed

    private void jButton35ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton35ActionPerformed
         actualizar();
    }//GEN-LAST:event_jButton35ActionPerformed

    private void jTextField10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField10ActionPerformed

    private void jBcancelarturno1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBcancelarturno1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBcancelarturno1ActionPerformed

    private void jBaceptarturno1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBaceptarturno1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBaceptarturno1ActionPerformed

    private void tiempocomida1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tiempocomida1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tiempocomida1ActionPerformed

    private void jCheckBox12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox12ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox12ActionPerformed

    private void jCheckBox13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox13ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox13ActionPerformed

    private void jCheckBox21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox21ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox21ActionPerformed

    private void jCheckBox22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox22ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox22ActionPerformed

    private void tiempocomidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tiempocomidaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tiempocomidaActionPerformed

    private void jRadioButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton6ActionPerformed
       jComboBox13.setEnabled(true);
    }//GEN-LAST:event_jRadioButton6ActionPerformed

    private void jRadioButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton7ActionPerformed
        jComboBox13.setEnabled(false);
    }//GEN-LAST:event_jRadioButton7ActionPerformed

    private void jRadioButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton5ActionPerformed
         jComboBox13.setEnabled(true);
    }//GEN-LAST:event_jRadioButton5ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
    String fecha1 = fechaFormat.format(jdde1.getDate());
    String fecha2 = fechaFormat.format(jda1.getDate());
    String sqlcorreccion = "SELECT * FROM permisos where fecha_inicio <= '"+fecha2+"' and fecha_final >= '"+fecha1+"' order by indx DESC";
    String columnassqlcorreccion[]= {"Folio","Fecha inicio","Fecha final","Hora","Aplica a","Tipo","Motivo","Autorizado"};
            
    act_t.actualizar(jTable4, sqlcorreccion, 8, columnassqlcorreccion );
    
     diseñotab6();
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton36ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton36ActionPerformed
        abrirdialog6();
    }//GEN-LAST:event_jButton36ActionPerformed

    private void jButton37ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton37ActionPerformed
        String indxx= String.valueOf(jTable14.getValueAt(jTable14.getSelectedRow(), 0));
        
        if(jTable14.getSelectedRow()== -1){
           
           JOptionPane.showMessageDialog(null, "No hay permiso seleccionado");
        }else{

           try {
               String sql = "delete  from faltas where indx = '"+indxx+"'";
               
               PreparedStatement us = Conexion.prepareStatement(sql);
               us.executeUpdate();
               us.close();
              
                    
               JOptionPane.showMessageDialog(jPanel8, "Eliminado correctamente");
              
           } catch (SQLException ex) {
               Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
           }
            
            actualizart_faltas();
        }
    }//GEN-LAST:event_jButton37ActionPerformed
    DefaultTableModel modelopercepciones = new DefaultTableModel();
    DefaultTableModel modeloperdeducciones = new DefaultTableModel();
    DefaultTableModel modelonominareporte = new DefaultTableModel();
   
    
    private void jButton45ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton45ActionPerformed
    DefaultTableModel  modelonominaasis = (DefaultTableModel) jTable6.getModel();
    while( modelonominaasis.getRowCount()>0) modelonominaasis.removeRow(0);
     
    modelopercepciones = (DefaultTableModel)jTable9.getModel();
    modeloperdeducciones = (DefaultTableModel)jTable8.getModel();
    modelonominareporte = (DefaultTableModel) jTable10.getModel();

    String fecha1 = fechaFormat.format(jCalendar9.getDate());
    String fecha2 = fechaFormat.format(jCalendar8.getDate());
    String fecha3 = fechaFormatextra.format(jCalendar9.getDate());
    String fecha4 = fechaFormatextra.format(jCalendar8.getDate()); 
    
     String nombre8 = String.valueOf(jComboBox15.getSelectedItem());  
     DecimalFormat formato1 = new DecimalFormat("####.##");   
     float salariobruto = Integer.parseInt(TF_salsem.getText());
     float salariodia = salariobruto/Integer.parseInt(jFormattedTextField6.getText()); 
     
       // System.out.println(salariodia);
     jFormattedTextField8.setText(formato1.format(salariodia));
     
     
     Object [] fila=new Object[4];
     
     DecimalFormat formato2 = new DecimalFormat("####");
     modelopercepciones.addRow(new Object []{"Salario Base",1,formato2.format(salariobruto),formato2.format(salariobruto)} );
     
     rporpersonal(fecha1, fecha2,fecha3,fecha4, nombre8);
     
     String sqlcorreccion = "SELECT fecha_inicio,hora,tipo,motivo FROM permisos where fecha_inicio <= '"+fecha2+"' and fecha_final >= '"+fecha1+"' and aplica_a = '"+nombre8+"' order by indx DESC";
     String columnassqlcorreccion[]= {"Fecha inicio","Hora","Tipo","Motivo"};       
     act_t.actualizar(jTable15, sqlcorreccion, 4, columnassqlcorreccion );
     String sqlcorreccion2 = "SELECT fecha,hora,motivo,gravante FROM faltas WHERE aplica_a = '"+nombre8+"'";
     String columnassqlcorreccion2[]= {"FECHA","HORA","MOTIVO","Gravante"};
     act_t.actualizar(jTable7, sqlcorreccion2, 4, columnassqlcorreccion2 );
   
     jLabel90.setText(labetotalhoras.getText());
     
     float totalrt = Float.parseFloat(laberetardos.getText())+(Float.parseFloat(labetolerancia.getText())/2);
     jLabel85.setText(String.valueOf(totalrt));
     
     for(int w=0;w<jTable13.getRowCount();w++){
         
         modelonominaasis.addRow(new Object[]{jTable13.getValueAt(w, 0),jTable13.getValueAt(w, 1),jTable13.getValueAt(w,4),jTable13.getValueAt(w,6)});
         
     }
      
      recalculopersepciones();  
      rellenardetalles();
      calculoreporotenominaa();
    }//GEN-LAST:event_jButton45ActionPerformed
    private void rellenardetalles(){
       String trabajador = String.valueOf(jComboBox15.getSelectedItem());
       Object datos[]= new Object[11];
       
       for(int u=0;jTable3.getRowCount()>u;u++){
         
           if(jTable3.getValueAt(u,1).equals(jComboBox15.getSelectedItem())){
              
               try {
                   String sqlpp="Select * from personal where nombre = '"+String.valueOf(jTable3.getValueAt(u, 1)+"';");
                   PreparedStatement us = Conexion.prepareStatement(sqlpp);
                   ResultSet respp = us.executeQuery();
                   if(respp.next()){
                       for(int i=0; i<11;i++){
                    datos[i]= respp.getObject(i+1);
                       }
                      
                   }
                  
                   us.close();
               } catch (SQLException ex) {
                   Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
               }
           }
       }
       String penombre=String.valueOf(datos[2]);
       String perfc=String.valueOf(datos[10]);
       String pepuesto=String.valueOf(datos[9]);
       String penosocial=String.valueOf(datos[8]);
       
       
        
       String enombre = jTextField14.getText();
       String erfc = jTextField15.getText();
       String ecallenumero = jTextField16.getText();    
       String periodo = jLabel146.getText()+" al "+jLabel110.getText(); 
       String diaslab = jFormattedTextField6.getText();
       String salariodia = jFormattedTextField8.getText();
       
/////////////////////////////////////////////////////////////////////////////////////////////////////////       
       TF_nombre_emp.setText(enombre);
       TF_domicilio_emp1.setText(ecallenumero);
       Tf_rfc_emp2.setText(erfc);
       
       TF_nombre_perso.setText(trabajador);
       TF_periodo_perso2.setText(periodo);
       TF_dias_perso3.setText(diaslab);
       TF_tarifa_perso4.setText(salariodia);
       Tf_rfc_perso.setText(perfc);
       TF_nosocial_perso1.setText(penosocial);
       TF_puesto_perso.setText(pepuesto);
       TF_codigo_perso.setText(String.valueOf(datos[1]));
       TF_fechaemision_perso5.setText(new SimpleDateFormat("dd/MM/yyyy").format(fechahoy));
       
       
       
       
       
       
       
        
    }
    private void recalculodeducciones(){
        
     float conteotot=0;
     
     for(int t=0;t<jTable8.getRowCount();t++){
       conteotot += Float.parseFloat(String.valueOf(jTable8.getValueAt(t,3)));
         
     }
        jLabel83.setText("$ "+Integer.toString((int)conteotot));
        recalculoliquido();
    }
    private void recalculoliquido(){
        float percepciones = Float.parseFloat(jLabel84.getText().replaceAll("[^\\d.]","0"));
        float decreciones = Float.parseFloat(jLabel83.getText().replaceAll("[^\\d.]","0"));
        float liquidototal = percepciones - decreciones;
        
       
        
        
    }
    private void recalculopersepciones(){
        
     float conteotot=0;
     
     for(int t=0;t<jTable9.getRowCount();t++){
       conteotot += Float.parseFloat(String.valueOf(jTable9.getValueAt(t,3)));
         
     }
        jLabel84.setText("$ "+Integer.toString((int)conteotot));
        
  
        
        recalculoliquido();
    }
    
    private void calculoreporotenominaa(){
        
       while(modelonominareporte.getRowCount()>0)modelonominareporte.removeRow(0);

       Object datos[]= new Object[5];
       Object datos2[]= new Object[5];
                //println(jTable9.getRowCount());
                
                
        for(int w=0;w<jTable9.getRowCount();w++){
           
           
           datos[0] = modelopercepciones.getValueAt(w,0);
           datos[1] = modelopercepciones.getValueAt(w,1);
           datos[2] = modelopercepciones.getValueAt(w,2);
           datos[3] = modelopercepciones.getValueAt(w,3);
           datos[4] = "0";
           modelonominareporte.addRow(datos);
           
        }
        
        for(int w=0;w<jTable8.getRowCount();w++){
           
           
           datos2[0] = modeloperdeducciones.getValueAt(w,0);
           datos2[1] = modeloperdeducciones.getValueAt(w,1);
           datos2[2] = modeloperdeducciones.getValueAt(w,2);
           datos2[3] = "0";
           datos2[4] = modeloperdeducciones.getValueAt(w,3);
           modelonominareporte.addRow(datos2);
           
        }
        TF_subpercep.setText(jLabel84.getText());
        TF_subdeduc.setText(jLabel83.getText());
        long total = Long.parseLong(TF_subpercep.getText().replaceAll("[^\\d.]", "")) - Long.parseLong(TF_subdeduc.getText().replaceAll("[^\\d.]", ""));
     
        TF_total.setValue(total);
    }
    
    public void contarfaltas(){
        
        
        
    }
 
    
    private void jButton43ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton43ActionPerformed
       String conceptoPer = jTextField13.getText();
       String cantidadPer = jFormattedTextField4.getText();
       String valorPer = jFormattedTextField5.getText();
        float totall = Float.parseFloat(cantidadPer) * Float.parseFloat(valorPer);
       
       //modelopercepciones = (DefaultTableModel)jTable9.getModel();
       
       modelopercepciones.addRow(new Object[]{conceptoPer,cantidadPer,valorPer,totall});
      // jTable9.setModel(modelTabla);
       recalculopersepciones();
       calculoreporotenominaa();
               
    }//GEN-LAST:event_jButton43ActionPerformed

    private void jButton44ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton44ActionPerformed
        modelopercepciones.removeRow(jTable9.getSelectedRow());
        recalculopersepciones();
        calculoreporotenominaa();
    }//GEN-LAST:event_jButton44ActionPerformed

    private void jButton42ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton42ActionPerformed
       String conceptoPer = jTextField12.getText();
       String cantidadPer = jFormattedTextField3.getText();
       String valorPer = jFormattedTextField2.getText();
       float totall = Float.parseFloat(cantidadPer) * Float.parseFloat(valorPer);
      // modeloperdeducciones = (DefaultTableModel)jTable8.getModel();
       
        modeloperdeducciones.addRow(new Object[] {conceptoPer,cantidadPer,valorPer,totall});
        
        
        
      recalculodeducciones();
      calculoreporotenominaa();
    }//GEN-LAST:event_jButton42ActionPerformed

    private void jButton41ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton41ActionPerformed
        if(jTable8.getRowCount()!=0){
        modeloperdeducciones.removeRow(jTable8.getSelectedRow());
        recalculodeducciones();
        calculoreporotenominaa();
        }
    }//GEN-LAST:event_jButton41ActionPerformed

    private void jButton46ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton46ActionPerformed
        jDialog6.dispose();
    }//GEN-LAST:event_jButton46ActionPerformed

    private void jButton47ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton47ActionPerformed
        PreparedStatement enrollItmt;
        
        String hora9 = jFormattedTextField7.getText();
        String fecha = fechaFormat.format(jCalendar1.getDate());
        String motivo = jTextField11.getText();
        String detalles = jTextArea1.getText();
        String aplicaa = String.valueOf(jComboBox3.getSelectedItem());
        String graban = jTextField29.getText();
        
        try {
            enrollItmt = Conexion.prepareStatement("INSERT INTO faltas (fecha,hora,motivo,descripcion,aplica_a,gravante) VALUES ('"+fecha+"','"+hora9+"','"+motivo+"','"+detalles+"','"+aplicaa+"','"+graban+"')");
            enrollItmt.execute();
        } catch (SQLException ex) {
            Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        actualizart_faltas();
        jDialog6.dispose();
        
    }//GEN-LAST:event_jButton47ActionPerformed

    private void jComboBox15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox15ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox15ActionPerformed

    private void jButton48ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton48ActionPerformed
        try {
            Statement uss = Conexion.createStatement();
            uss.execute(
                    "CREATE TABLE `faltas` (\n" +
                            "  `indx` INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                            "  `fecha` varchar(15) DEFAULT NULL,\n" +
                            "  `hora` varchar(15) DEFAULT NULL,\n" +
                            "  `motivo` varchar(60) DEFAULT NULL,\n" +
                            "  `descripcion` varchar(250) DEFAULT NULL,\n" +
                            "  `anexo` varchar(50) DEFAULT NULL\n"+
                            ")");   } catch (SQLException ex) {
            Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton48ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jLabel9MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseReleased
       
        
        if(jTabbedPane1.isEnabled()){
            jTabbedPane1.setEnabled(false);
            jButton9.setEnabled(false);
            jTextField4.setEnabled(false);
            jLabel9.setIcon(new ImageIcon (getClass().getResource("/ico/ca1.png")));
        }else{
             int itme =jTabbedPane1.getSelectedIndex();
             ventana_solicitada=itme;
             jLabel10.setText("");
             abrirdialog4();
        }
       
   
    }//GEN-LAST:event_jLabel9MouseReleased

    private void jButton34ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton34ActionPerformed

        if(reinicioauto){
            reinicioauto = false;
            jLabel26.setForeground(Color.red);
            jLabel26.setFont(new Font ("Serif", Font.BOLD, 16));
            jLabel26.setText("SIN CONEXION CON EL CHECADOR SOLO MANUAL");

            jButton34.setText("REINICIAR");
        }else{
            try {

                String barra = File.separator;
                String proyecto = System.getProperty("user.dir")+barra+"rest.bat";
                Process p = Runtime.getRuntime().exec (proyecto);
                System.exit(0);

            } catch (IOException ex) {

                JOptionPane.showMessageDialog(null, "xcaca");
                Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);

            }

        }
    }//GEN-LAST:event_jButton34ActionPerformed

    private void jScrollPane4KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jScrollPane4KeyPressed
        //jTextField6filtro.requestFocus();
    }//GEN-LAST:event_jScrollPane4KeyPressed

    private void jTable5KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable5KeyPressed
        // jTextField6filtro.requestFocus();
    }//GEN-LAST:event_jTable5KeyPressed

    private void jTextField4KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField4KeyTyped
        char caracter = evt.getKeyChar();

        // Verificar si la tecla pulsada no es un digito
        if(((caracter < '0') ||
            (caracter > '9')) &&
        (caracter != '\b' /*corresponde a BACK_SPACE*/))
        {
            evt.consume();// ignorar el evento de teclado
        }
    }//GEN-LAST:event_jTextField4KeyTyped

    private void jTextField4KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField4KeyPressed

        if(evt.getKeyCode()==KeyEvent.VK_ENTER){

            checada_manual();
        }
    }//GEN-LAST:event_jTextField4KeyPressed

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4ActionPerformed

    private void jTextField4FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField4FocusGained

    }//GEN-LAST:event_jTextField4FocusGained

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        checada_manual();
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jTextField14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField14ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField14ActionPerformed

    private void jTextField15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField15ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField15ActionPerformed

    private void jTextField16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField16ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField16ActionPerformed

    private void jTextField17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField17ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField17ActionPerformed

    private void jTextField18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField18ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField18ActionPerformed

    private void jTextField19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField19ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField19ActionPerformed

    private void jTextField20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField20ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField20ActionPerformed

    private void jTextField21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField21ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField21ActionPerformed

    private void jTextField22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField22ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField22ActionPerformed

    private void jTextField23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField23ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField23ActionPerformed

    private void jTextField24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField24ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField24ActionPerformed

    private void jTextField25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField25ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField25ActionPerformed

    private void jTextField26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField26ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField26ActionPerformed

    private void jButton52ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton52ActionPerformed
        try {
            String enombre = jTextField14.getText();
            String erfc = jTextField15.getText();
            String ecallenumero = jTextField16.getText();
            String eentrecalle = jTextField17.getText();
            String ecolonia = jTextField19.getText();
            String epoblacion = jTextField18.getText();
            String emunicipio = jTextField20.getText();
            String etelefono1 = jTextField22.getText();
            String etelefono2 = jTextField23.getText();
            String eestado = jTextField21.getText();
            String eemail = jTextField24.getText();
            String eweb = jTextField25.getText();
            
            
            Statement us9 = Conexion.createStatement();
            ResultSet res9 = us9.executeQuery("Select * from empresa");
            
            if(res9.next()){
                PreparedStatement enrollItmt;
                try {
                    
                    
                    enrollItmt = Conexion.prepareStatement("UPDATE empresa SET  nombre = '"+enombre+"', rfc = '"+erfc+"' , callenum = '"+ecallenumero+" ', entrecalle= '"+eentrecalle+"',colonia= '"+ecolonia+"',poblacion= '"+epoblacion+"',municipio= '"+emunicipio+"',telefono1= '"+etelefono1+"',telefono2= '"+etelefono2+"',estado= '"+eestado+"',email= '"+eemail+"',web= '"+eweb+"' WHERE indx = '1'");
                    enrollItmt.executeUpdate();
                    JOptionPane.showMessageDialog(null,"Guardado Correctamente");
                    
                    
                } catch (SQLException ex) {
                    Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }else{
                try {
                    PreparedStatement enrollItmt9;
                    enrollItmt9 = Conexion.prepareStatement("INSERT INTO empresa (nombre,rfc,callenum,entrecalle,colonia,poblacion,municipio,telefono1,telefono2,estado,email,web ) "
                            + "VALUES ('"+enombre+"','"+erfc+"','"+ecallenumero+"','"+eentrecalle+"','"+ecolonia+"','"+epoblacion+"','"+emunicipio+"','"+etelefono1+"','"+etelefono2+"','"+eestado+"','"+eemail+"','"+eweb+"') ");
                    enrollItmt9.execute();
                    JOptionPane.showMessageDialog(null,"Guardado Correctamente");
                } catch (SQLException ex) {
                    Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
            res9.close();
            us9.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
        }
       
      


            
            
        
        
        
    }//GEN-LAST:event_jButton52ActionPerformed

    private void jButton54ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton54ActionPerformed
        try {
            Statement uss = Conexion.createStatement();
            uss.execute(
                    "CREATE TABLE `empresa` (\n" +
                            "  `indx` INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                            "  `nombre` varchar(100) DEFAULT NULL,\n" +
                            "  `rfc` varchar(20) DEFAULT NULL,\n" +
                            "  `callenum` varchar(120) DEFAULT NULL,\n" +
                            "  `entrecalle` varchar(250) DEFAULT NULL,\n" +
                            "  `colonia` varchar(60) DEFAULT NULL,\n"+
                            "  `poblacion` varchar(60) DEFAULT NULL,\n" +
                            "  `municipio` varchar(60) DEFAULT NULL,\n" +
                            "  `telefono1` varchar(60) DEFAULT NULL,\n" +
                            "  `telefono2` varchar(60) DEFAULT NULL,\n" +
                            "  `estado` varchar(60) DEFAULT NULL,\n"+
                            "  `email` varchar(60) DEFAULT NULL,\n" +
                            "  `web` varchar(60) DEFAULT NULL\n"+
                            ")");   } catch (SQLException ex) {
            Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }//GEN-LAST:event_jButton54ActionPerformed

    private void jCheckBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox3ActionPerformed

    private void jCheckBox4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox4ActionPerformed

    private void jCheckBox5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox5ActionPerformed

    private void jCheckBox6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox6ActionPerformed

    private void jCheckBox7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox7ActionPerformed

    private void jCheckBox8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox8ActionPerformed

    private void jButton56ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton56ActionPerformed
        c.guardarconfasis(jFormattedTextField11.getText(),jFormattedTextField10.getText());
    }//GEN-LAST:event_jButton56ActionPerformed
 JasperPrint   jasperPrint;
 JasperViewer b ;
 
    private void jButton53ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton53ActionPerformed
         HashMap para = new HashMap();
         TableModel model = jTable10.getModel();
         JRTableModelDataSource datasocure = new JRTableModelDataSource(model); 
         Image img= new ImageIcon("logo").getImage();
         ImageIcon img2=new ImageIcon(img.getScaledInstance(81,50, Image.SCALE_SMOOTH));
         
         para.put("empre.nombre", TF_nombre_emp.getText());
         para.put("empre.domicilio", TF_domicilio_emp1.getText());
         para.put("empre.rfc", Tf_rfc_emp2.getText());
         para.put("emple.nombre",TF_nombre_perso.getText());
         para.put("emple.codigo", TF_codigo_perso.getText());
         para.put("emple.puesto",TF_puesto_perso.getText());
         para.put("emple.rfc", Tf_rfc_perso.getText());
         
         para.put("emple.imss", TF_nosocial_perso1.getText());
         para.put("emple.periodo", TF_periodo_perso2.getText());
         para.put("emple.todias", TF_dias_perso3.getText());
         para.put("emple.tarifa", TF_tarifa_perso4.getText());
         para.put("sub.devengos", TF_subpercep.getText());
         para.put("sub.deduc", TF_subdeduc.getText());
         para.put("sub.total", TF_total.getText());
         para.put("logo",img);
         para.put("firma",TF_texto_c.getText());
        try {
          JRPrintPage f;
             
         jasperPrint = JasperFillManager.fillReport(getClass().getResourceAsStream("report1.jasper"),para,datasocure);
         //JasperViewer.
       
         b.viewReport(jasperPrint,false);
           
            
        } catch (JRException ex) {
            Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        
        
        
        
        
        
        
        
        
        
        
    }//GEN-LAST:event_jButton53ActionPerformed

    private void jButton49ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton49ActionPerformed
        JFileChooser fc = new JFileChooser();
        fc.setDialogTitle("Elejir una imagen");
        FileNameExtensionFilter filtroImagen=new FileNameExtensionFilter("JPG, PNG ","jpg","png");
        
        fc.setFileFilter(filtroImagen);
        if(fc.showOpenDialog(this)==JFileChooser.APPROVE_OPTION){
            
            File logo = new File(fc.getSelectedFile().toString());
            
            
            try {
                Files.copy(logo.toPath(), new File("logo").toPath(), StandardCopyOption.REPLACE_EXISTING);

            } catch (IOException ex) {
                Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        Image img= new ImageIcon("logo").getImage();
        ImageIcon img2=new ImageIcon(img.getScaledInstance(jLabel19.getWidth()-10,jLabel19.getHeight()-10, Image.SCALE_SMOOTH));
        jLabel19.setIcon(img2);
            
            
        }
        
       
        
    }//GEN-LAST:event_jButton49ActionPerformed

    private void jFormattedTextField6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFormattedTextField6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jFormattedTextField6ActionPerformed

    private void TF_salsemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TF_salsemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TF_salsemActionPerformed

    private void jFormattedTextField8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFormattedTextField8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jFormattedTextField8ActionPerformed

    private void jButton57ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton57ActionPerformed
       if(jTable3.getSelectedRow()!=-1){      
       jLabel105.setText(String.valueOf( jTable3.getValueAt(jTable3.getSelectedRow(),1)));
       jDialog7.setModal(true);
       jDialog7.setLocationRelativeTo(null);
       jDialog7.setVisible(true);
       }else{
           JOptionPane.showMessageDialog(null, "Favor de seleccionar un persoal");
       }
       
    }//GEN-LAST:event_jButton57ActionPerformed

    private void jFormattedTextField7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFormattedTextField7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jFormattedTextField7ActionPerformed

    private void jButton59ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton59ActionPerformed
          
        String fecha1 = fechaFormat.format(jCalendar5.getDate());
        String fecha2 = fechaFormat.format(jCalendar4.getDate());
        String fecha3 = fechaFormatextra.format(jCalendar5.getDate());
        String fecha4 = fechaFormatextra.format(jCalendar4.getDate());     
        
         jdde.setDate(jCalendar5.getDate());
         jda.setDate(jCalendar4.getDate());
                  
        rporpersonal(fecha1, fecha2,fecha3,fecha4, jLabel105.getText());
        
        jTabbedPane1.setSelectedIndex(1);
        jDialog7.dispose();
    }//GEN-LAST:event_jButton59ActionPerformed

    private void jButton60ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton60ActionPerformed
      jDialog7.dispose();
    }//GEN-LAST:event_jButton60ActionPerformed

    private void jButton64ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton64ActionPerformed
    jDialogConceptos.setLocationRelativeTo(null);
    jDialogConceptos.setModal(true);
    jDialogConceptos.setVisible(true);  
    
    }//GEN-LAST:event_jButton64ActionPerformed

    private void jButton65ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton65ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton65ActionPerformed

    private void jButton66ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton66ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton66ActionPerformed

    private void jButton67ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton67ActionPerformed
        try {
            
            int filaseleccionada = jTable12.getSelectedRow();
            String nombre2 = (String)jTable12.getValueAt(filaseleccionada, 1);
            int cve = (int)jTable12.getValueAt(filaseleccionada, 0);
            int optc=JOptionPane.showConfirmDialog(null, "Se eliminara: "+ "\n" +nombre2, "Confirmar ", JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
            
            if(optc==0){
            String sql = "delete  from cotizacion where CVE = '"+cve+"'";
            
            PreparedStatement us = Conexion.prepareStatement(sql);
            us.executeUpdate();
            us.close();
            JOptionPane.showMessageDialog(null, "Eliminado correctamente");
            }
        } catch (SQLException ex) {
            Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        actualizart_cotizaciones();
    }//GEN-LAST:event_jButton67ActionPerformed
     DefaultTableModel modelopercepcionescotiza = new DefaultTableModel();
      
    DefaultTableModel modelodeduccionescotiza = new DefaultTableModel();
     
    private void jButton69ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton69ActionPerformed


    }//GEN-LAST:event_jButton69ActionPerformed

    private void jButton70ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton70ActionPerformed
        jDialogConceptos.dispose();
  
    }//GEN-LAST:event_jButton70ActionPerformed

    private void jButton71ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton71ActionPerformed
        PreparedStatement enrollItmt;
        
        String concepto = jTextField27.getText();
        String perded;
        if(jRadioButton9.isSelected()){
           perded = "Percepcion";
        }else{
           perded = "Deduccion";
        }
        
        String metodo = String.valueOf(jComboBox19.getSelectedItem());
        String valor = jFormattedTextField17.getText();
   
        
        try {
            enrollItmt = Conexion.prepareStatement("INSERT INTO conceptosnomi (concepto,perded,valor,metodo) VALUES ('"+concepto+"','"+perded+"','"+valor+"','"+metodo+"')");
            enrollItmt.execute();
        } catch (SQLException ex) {
            Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        actualizart_conceptosnomi();
        jDialogConceptos.dispose();
        
        
    }//GEN-LAST:event_jButton71ActionPerformed

    private void jRadioButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton9ActionPerformed
    
    
     
      public void consultarurl(){
    
   
    
    try {
			// Url con la foto
			URL url = new URL(
					"http://api.openweathermap.org/data/2.5/weather?id=4017957&appid=4f122e132b9208b22c96b4286a302f33");

			// establecemos conexion
			URLConnection urlCon = url.openConnection();

			// Sacamos por pantalla el tipo de fichero
			System.out.println(urlCon.getContentType());

			// Se obtiene el inputStream de la foto web y se abre el fichero
			// local.
			InputStream iss = urlCon.getInputStream();
                        
                       
                                 
			FileOutputStream fos = new FileOutputStream("foto.txt");

			// Lectura de la foto de la web y escritura en fichero local
			byte[] array = new byte[1000]; // buffer temporal de lectura.
			
                        int leido = iss.read(array);
                         
			while (leido > 0) {
				fos.write(array, 0, leido);
				leido = iss.read(array);
                                
			}

			// cierre de conexion y fichero.
                       
			iss.close();
			fos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
        try {
            JSONParser j = new JSONParser();
            Object obj;
          try {
              obj = j.parse(new FileReader("foto.txt"));
               JSONObject jsobjt = (JSONObject) obj;
               
               JSONObject js = (JSONObject) jsobjt.get("main");
               
               float ff = (float) Float.parseFloat(js.get("temp").toString());
               DecimalFormat formatop2 = new DecimalFormat("##°");
            //   System.out.println(formatop2.format(ff-273.15));
               jLabel147.setText(formatop2.format(ff-273.15));
              
          } catch (IOException ex) {
              Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
          }
           
            
        } catch (org.json.simple.parser.ParseException ex) {
            Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
        }
       
       
	}   


    private void jFormattedTextField17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFormattedTextField17ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jFormattedTextField17ActionPerformed
   DefaultTableModel nomirapi = new DefaultTableModel();
    private void jButton55ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton55ActionPerformed
 
        String sqlcorreccion = "SELECT tiposalario,periodo,percepcion,deduccion FROM cotizacion WHERE nombre='"+String.valueOf(jTable3.getValueAt(jTable3.getSelectedRow(),6))+"'";

        Statement us;
        Object datoss[]= new Object[4];
        try {
            us = Conexion.createStatement();
            ResultSet res = us.executeQuery(sqlcorreccion);
            
            while(res.next()){
                for(int i=0; i<4;i++){
                    datoss[i]= res.getObject(i+1);
                    //System.out.println(String.valueOf(res.getObject(i+1)));
                } 
            }
            us.close();
        } catch (SQLException ex) {
            Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
        }

        String entraf="";

        //PARA SACAR LAS PERCEPCIONES
        entraf = String.valueOf(datoss[2]);
        Object datos2[]= new Object[5];
        //System.out.println(entraf);
        while(entraf.contains("|")){         
            entraf = entraf.substring( entraf.indexOf("|")+1);             
            if(entraf.indexOf("|")==-1){
                datos2[0] = entraf.substring(0,entraf.indexOf(":"));
                entraf = entraf.substring(entraf.indexOf(":")+1);
                datos2[1] = entraf.substring(0,entraf.indexOf("*"));
                entraf = entraf.substring(entraf.indexOf("*")+1);
                datos2[2] = entraf.substring(0,entraf.indexOf("="));
                entraf = entraf.substring(entraf.indexOf("=")+1);
                datos2[3] = entraf.substring(0);
                datos2[4]="0";
            }else{
                
                datos2[0] = entraf.substring(0,entraf.indexOf(":"));
                entraf = entraf.substring(entraf.indexOf(":")+1);
                datos2[1] = entraf.substring(0,entraf.indexOf("*"));
                entraf = entraf.substring(entraf.indexOf("*")+1);
                datos2[2] = entraf.substring(0,entraf.indexOf("="));
                entraf = entraf.substring(entraf.indexOf("=")+1);
                datos2[3] = entraf.substring(0,entraf.indexOf("|"));
                
                datos2[4]="0";
                
            }
           nomirapi.addRow(datos2);
            //System.out.println("merenge"+datos2[0]);
        } 
        
        //PARA SACAR LAS DEDUCCIONES 
         entraf = String.valueOf(datoss[3]);
        Object datos3[]= new Object[5];
        System.out.println(entraf);
        while(entraf.contains("|")){         
            entraf = entraf.substring( entraf.indexOf("|")+1);             
            if(entraf.indexOf("|")==-1){
                datos3[0] = entraf.substring(0,entraf.indexOf(":"));
                entraf = entraf.substring(entraf.indexOf(":")+1);
                datos3[1] = entraf.substring(0,entraf.indexOf("*"));
                entraf = entraf.substring(entraf.indexOf("*")+1);
                datos3[2] = entraf.substring(0,entraf.indexOf("="));
                entraf = entraf.substring(entraf.indexOf("=")+1);
                datos3[3] = "0";
                datos3[4]=entraf.substring(0);
            }else{
                
                datos3[0] = entraf.substring(0,entraf.indexOf(":"));
                entraf = entraf.substring(entraf.indexOf(":")+1);
                datos3[1] = entraf.substring(0,entraf.indexOf("*"));
                entraf = entraf.substring(entraf.indexOf("*")+1);
                datos3[2] = entraf.substring(0,entraf.indexOf("="));
                entraf = entraf.substring(entraf.indexOf("=")+1);
                datos3[3] = "0";
                
                datos3[4]=entraf.substring(0,entraf.indexOf("|"));
                
            }
           nomirapi.addRow(datos3);
            //System.out.println("merenge"+datos2[0]);
        } 
 
    }//GEN-LAST:event_jButton55ActionPerformed

    private void jComboBox16MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox16MouseClicked
       
    }//GEN-LAST:event_jComboBox16MouseClicked

    private void jComboBox16ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox16ItemStateChanged
       if(String.valueOf(jComboBox16.getSelectedItem()).equals("Otro")){
           jTextField13.setText("");
       }else{
           jTextField13.setText(String.valueOf(jComboBox16.getSelectedItem()));
       }
       
    }//GEN-LAST:event_jComboBox16ItemStateChanged

    private void jBcancelarturno2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBcancelarturno2ActionPerformed
      jDialog10.dispose();
    }//GEN-LAST:event_jBcancelarturno2ActionPerformed

    private void jBaceptarturno2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBaceptarturno2ActionPerformed
        jLabel146.setText(fechaFormat22.format(jCalendar9.getDate()));
        jLabel110.setText(fechaFormat22.format(jCalendar8.getDate()));
         int dias=(int) (((jCalendar8.getDate().getTime()- jCalendar9.getDate().getTime())/8.64e+7)+2);
         jFormattedTextField6.setText(Integer.toString(dias));
        jDialog10.dispose();
    }//GEN-LAST:event_jBaceptarturno2ActionPerformed

    private void jButton79ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton79ActionPerformed
        jDialog10.setLocationRelativeTo(null);
        jDialog10.setVisible(true);
    }//GEN-LAST:event_jButton79ActionPerformed

    private void TF_salsemInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_TF_salsemInputMethodTextChanged
       // jFormattedTextField6.getText();
        
    }//GEN-LAST:event_TF_salsemInputMethodTextChanged

    private void TF_salsemFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TF_salsemFocusLost
        
       float sal = Float.parseFloat(TF_salsem.getText())/Float.parseFloat(jFormattedTextField6.getText());
        
       jFormattedTextField8.setText(String.valueOf(sal));
    }//GEN-LAST:event_TF_salsemFocusLost

    private void TF_salsemKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TF_salsemKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER) {
      float sal = Float.parseFloat(TF_salsem.getText())/Float.parseFloat(jFormattedTextField6.getText());
        
       jFormattedTextField8.setText(String.valueOf(sal));
   }
    }//GEN-LAST:event_TF_salsemKeyPressed

    private void TF_salsemKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TF_salsemKeyTyped
         char caracter = evt.getKeyChar();

        // Verificar si la tecla pulsada no es un digito
        if(((caracter < '0') ||
            (caracter > '9')) &&
        (caracter != '\b' /*corresponde a BACK_SPACE*/))
        {
            evt.consume();// ignorar el evento de teclado
        }
    }//GEN-LAST:event_TF_salsemKeyTyped

    private void jLabel148MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel148MouseClicked
        try {
            Desktop.getDesktop().browse(new URI("https://openweathermap.org/city/4017957") );
        } catch (URISyntaxException ex) {
            Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jLabel148MouseClicked

    private void jComboBox5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox5ActionPerformed
        
    DefaultComboBoxModel modeloComboDoblaturno1 = new DefaultComboBoxModel();
    DefaultComboBoxModel modeloComboDoblaturno2 = new DefaultComboBoxModel();  
        if(String.valueOf(jComboBox5.getSelectedItem()).equals("Dobla turno")){
                int roww = jTable1.getRowCount() ;
    jPanel54.setVisible(true);
    jTextField6.setEditable(false);
    
    for(int x=0;x<roww;x++){
       
        modeloComboDoblaturno1.addElement(jTable1.getValueAt(x,0));   
        modeloComboDoblaturno2.addElement(jTable1.getValueAt(x,0));
       
    }
    jComboBox26.setModel(modeloComboDoblaturno1);
    jComboBox25.setModel(modeloComboDoblaturno2);
        }else{
            
            jPanel54.setVisible(false);
            jTextField6.setEditable(true);
        }
        
    }//GEN-LAST:event_jComboBox5ActionPerformed

    private void jButton81ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton81ActionPerformed
        jdde1.setDate(fechahoy);
        jda1.setDate(fechahoy);
        actualizart_permisos();
    }//GEN-LAST:event_jButton81ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        String nombre3 = String.valueOf(jComboBox1.getSelectedItem());
        String fecha1 = fechaFormat.format(jdde.getDate());
        String fecha2 = fechaFormat.format(jda.getDate());

        if(jRadioButton1.isSelected()){

        }else{

            resumenpersonal3(jTable13,nombre3);
        }
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton21ActionPerformed

        String titulos=null;
        String totales=null;
        String fecha1 = fechaFormat.format(jdde.getDate());
        String fecha2 = fechaFormat.format(jda.getDate());
        String nombre3 = String.valueOf(jComboBox1.getSelectedItem());
        String tol = labetolerancia.getText();
        String ret = laberetardos.getText();
        String hrl = labetotalhoras.getText();

        if(jRadioButton1.isSelected()){
            titulos = "REPORTE DEL TURNO:  -  "+nombre3+"   - DE LA FECHA:  -  "+fecha1+"  -   A LA   FECHA: -  "+fecha2;
            totales = "TOTALES  Retardos = -  "+ret+" - Tolerancias = - "+tol+" - Tiempo laborado = - "+hrl;
            export.exportarExcel2(jTable13,titulos,totales);
        }else{
            titulos = "REPORTE DE: - "+nombre3+" - DE LA FECHA: - "+fecha1+" - A LA FECHA: - "+fecha2;
            totales = "TOTALES  Retardos = - "+ret+" - Tolerancias = - "+tol+" - Tiempo laborado = - "+hrl;
            export.exportarExcel(jTable13,titulos,totales);

        }

        /////////////////////////////////////////////////////////////////////////////////////////////
        //if (jTable1.getRowCount() > 0) {
            // JFileChooser chooser = new JFileChooser();
            // FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos de excel", "xls");
            // chooser.setFileFilter(filter);
            // chooser.setDialogTitle("Guardar archivo");
            // chooser.setAcceptAllFileFilterUsed(false);
            // if (chooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
                // List tb = new ArrayList();
                // List nom = new ArrayList();
                // tb.add(jTable13);
                // nom.add("Compras por factura");
                // String file = chooser.getSelectedFile().toString().concat(".xls");
                // try {
                    // checka.Exporter e = new Exporter(new File(file), tb, nom);
                    // if (e.export()) {
                        // JOptionPane.showMessageDialog(null, "Los datos fueron exportados a excel en el directorio seleccionado", "Mensaje de Informacion", JOptionPane.INFORMATION_MESSAGE);
                        // }
                    // } catch (Exception e) {
                    // JOptionPane.showMessageDialog(null, "Hubo un error " + e.getMessage(), " Error", JOptionPane.ERROR_MESSAGE);
                    // }
                // }
            // }else{
            // JOptionPane.showMessageDialog(this, "No hay datos para exportar","Mensaje de error",JOptionPane.ERROR_MESSAGE);
            // }
    }//GEN-LAST:event_jButton21ActionPerformed

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
       
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void jRadioButton2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioButton2MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton2MouseEntered

    private void jRadioButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioButton2MouseClicked
        DefaultComboBoxModel modeloCombottt = new DefaultComboBoxModel();
        modeloCombottt.removeAllElements();

        int roww = jTable3.getRowCount() ;

        for(int x=0;x<roww;x++){

            modeloCombottt.addElement(jTable3.getValueAt(x,1));

        }
        jComboBox1.setModel(modeloCombottt);
        jComboBox1.addItem("Libre");
      
    }//GEN-LAST:event_jRadioButton2MouseClicked

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
     
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jRadioButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioButton1MouseClicked
        DefaultComboBoxModel modeloCombottt = new DefaultComboBoxModel();
        modeloCombottt.removeAllElements();

        int roww = jTable1.getRowCount() ;

        for(int x=0;x<roww;x++){

            modeloCombottt.addElement(jTable1.getValueAt(x,0));

        }
        jComboBox1.setModel(modeloCombottt);
        jComboBox1.addItem("Libre");
      
   
    }//GEN-LAST:event_jRadioButton1MouseClicked

    private void jButton19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton19ActionPerformed
        String fecha1 = fechaFormat.format(jdde.getDate());
        String fecha2 = fechaFormat.format(jda.getDate());
        String fecha3 = fechaFormatextra.format(jdde.getDate());
        String fecha4 = fechaFormatextra.format(jda.getDate());
        String nombre3 = String.valueOf(jComboBox1.getSelectedItem());

        //System.out.println(fecha1+" - "+fecha2);
        //  System.out.println(fecha3+" - "+fecha4);
        if(jRadioButton1.isSelected()){
            
            if(jRadioButton11.isSelected()){
               
            DefaultTableModel modelTabla5 = (DefaultTableModel) jTable13.getModel();
           while(modelTabla5.getRowCount()>0)modelTabla5.removeRow(0);
               String sqlcorreccion = "SELECT fecha,personal,entrada,c_entrada,c_salida,salida FROM registro where turnoreg like '%"+nombre3+"%' and fecha BETWEEN '"+fecha1+"' and '"+fecha2+"' order by fecha ASC";
             String columna2[]= {"Fecha","PERSONAL","ENTRADA","EN.COMIDA","SA.COMIDA","SALIDA ","T.Comida","T.Horas"};
               act_t1.actualizart(jTable13, sqlcorreccion, 8, columna2,jTable1 );
              act_t1.colorear2(jTable13, jTable1, 20,nombre3);
              contarpturno(jTable13);
                
                
            }else{
                 jLabel31.setText("Turno: "+nombre3);
                 rporturno(fecha1, fecha2, nombre3);
                  act_t1.colorear2(jTable13, jTable1, 20,nombre3);
                 contarpturno(jTable13);
                 jTable13.setDefaultRenderer(Object.class, new FormatoTabla2());
                
            }
            
            
        }else{
            
            
            jLabel31.setText("Personal: "+nombre3);
            rporpersonal(fecha1, fecha2,fecha3,fecha4, nombre3);
            String sqlcorreccion = "SELECT * FROM permisos where aplica_a like '%"+nombre3+"%' and fecha_inicio <= '"+fecha2+"' and fecha_final >= '"+fecha1+"' order by indx ASC";
            String columnassqlcorreccion[]= {"Folio","Fecha inicio","Fecha final","Hora","Aplica a","Tipo","Motivo","Autorizado"};
            act_t.actualizar(jTable18, sqlcorreccion, 8, columnassqlcorreccion );
            diseñotab6();

            
        }
        
        
        
    }//GEN-LAST:event_jButton19ActionPerformed

    private void jButton80ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton80ActionPerformed
       jTextField28.setText(System.getProperty("user.dir"));
       jDialog3.setLocationRelativeTo(null);
       jDialog3.setVisible(true);
       
       
    }//GEN-LAST:event_jButton80ActionPerformed

    private void jButton82ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton82ActionPerformed
               if(jTable19.getSelectedRow()!=-1){
        try {
            int filaseleccionada = jTable19.getSelectedRow();
            String indx = String.valueOf(jTable19.getValueAt(filaseleccionada, 0));
         
            int optc=JOptionPane.showConfirmDialog(null, "Se eliminara: "+ "\n" +indx, "Confirmar ", JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
            
            if(optc==0){
                
         
            String sql = "delete  from automi where indx = '"+indx+"'";

            PreparedStatement us = Conexion.prepareStatement(sql);
            us.executeUpdate();
            us.close();
          
            JOptionPane.showMessageDialog(null, "Eliminado correctamente");      
        }
        } catch (SQLException ex) {
            Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        actualizart_automi();
        }else{
            JOptionPane.showMessageDialog(null , "Favor de seleccionar una tarea");
        }
    }//GEN-LAST:event_jButton82ActionPerformed

    private void jBcancelarturno3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBcancelarturno3ActionPerformed
        jDialog3.dispose();
    }//GEN-LAST:event_jBcancelarturno3ActionPerformed

    private void jBaceptarturno3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBaceptarturno3ActionPerformed
        
            PreparedStatement enrollItmt;
            String generar = String.valueOf(jComboBox27.getSelectedItem());
            String personas_auto = "";
            String hora_auto = "";
            String direccion_auto ="";
            String dias_auto="";
            
            for(int u=0;u<checkboxes.size();u++){
                if(checkboxes.get(u).isSelected()){
                    
                    personas_auto += "+"+checkboxes.get(u).getText();
                }
            }
            
            List<JCheckBox> checkboxesdias = new ArrayList<>();
            checkboxesdias.add(jCheckBox11);
            checkboxesdias.add(jCheckBox10);
            checkboxesdias.add(jCheckBox23);
            checkboxesdias.add(jCheckBox25);
            checkboxesdias.add(jCheckBox24);
            checkboxesdias.add(jCheckBox26);
            checkboxesdias.add(jCheckBox27);
            for(int u=0;u<checkboxesdias.size();u++){
                if(checkboxesdias.get(u).isSelected()){
                    
                    dias_auto +=  "+"+checkboxesdias.get(u).getText();
                }
            }
            System.out.println(personas_auto);
            System.out.println(dias_auto);
            hora_auto = String.valueOf(jComboBox14.getSelectedItem());
            System.out.println(hora_auto);
            
            direccion_auto = jTextField28.getText();
            System.out.println(direccion_auto);
          try {  
            PreparedStatement enrollItmt2;
            
            enrollItmt2 = Conexion.prepareStatement("INSERT INTO automi (generar,personas,dias,hora,directorio) VALUES ('"+generar+"','"+personas_auto+"','"+dias_auto+"','"+hora_auto+"','"+direccion_auto+"')");
            enrollItmt2.execute();
            JOptionPane.showMessageDialog(null,"Registro agregado correctamente");
        } catch (SQLException ex) {
            Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        jDialog3.dispose();
        actualizart_automi();
    }//GEN-LAST:event_jBaceptarturno3ActionPerformed
    
    private void jComboBox27ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox27ActionPerformed
       
        String opcion_seleccionado = String.valueOf(jComboBox27.getSelectedItem());
        
        if(opcion_seleccionado.equals("NOMINAS")){
            for(int x=0;x<checkboxes.size();x++){
                 checkboxes.remove(x);
                 jPanel60.removeAll();
                 
             }
           
            try {
                String sql9 = "Select nombre from personal";
                Statement us = Conexion.createStatement();
                ResultSet res = us.executeQuery(sql9);
               
                ArrayList<String> myArrayList = new ArrayList<String>();
                myArrayList.clear();
                
                while(res.next()){
                    
                    myArrayList.add(String.valueOf(res.getObject(1)));
                }
                res.close();
                us.close();
                
                Font fuente = new Font("Tahoma", 0,15);
                for(String element : myArrayList) {
                       JCheckBox box = new JCheckBox(element);
                       box.setFont(fuente);
                      // box.setName(element);
                       checkboxes.add(box);
                       jPanel60.add(box);
                       
                   }
                jPanel60.validate();
                jScrollPane23.validate();
                
            } catch (SQLException ex) {
                Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }else if(opcion_seleccionado.equals("REPORTES DE PERSONAS")) {
            for(int x=0;x<checkboxes.size();x++){
                 checkboxes.remove(x);
                 jPanel60.removeAll();
             }
            
            try {
                String sql9 = "Select nombre from personal";
                Statement us = Conexion.createStatement();
                ResultSet res = us.executeQuery(sql9);
               
                ArrayList<String> myArrayList = new ArrayList<String>();
                
                
                while(res.next()){
                    
                    myArrayList.add(String.valueOf(res.getObject(1)));
                }
                res.close();
                us.close();
                
                Font fuente = new Font("Tahoma", 0,15);
                for(String element : myArrayList) {
                       JCheckBox box = new JCheckBox(element);
                       box.setFont(fuente);
                      // box.setName(element);
                       checkboxes.add(box);
                       jPanel60.add(box);
                       
                   }
                jPanel60.validate();
                jScrollPane23.validate();
                
            } catch (SQLException ex) {
                Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
            
        }else if(opcion_seleccionado.equals("REPORTES DE TURNOS")) {
            for(int x=0;x<checkboxes.size();x++){
                 checkboxes.remove(x);
                 jPanel60.removeAll();
             }
            try {
                String sql9 = "Select nombre from turnos";
                Statement us = Conexion.createStatement();
                ResultSet res = us.executeQuery(sql9);
               
                ArrayList<String> myArrayList = new ArrayList<String>();
                
                
                while(res.next()){
                    
                    myArrayList.add(String.valueOf(res.getObject(1)));
                }
                res.close();
                us.close();
                
                Font fuente = new Font("Tahoma", 0,15);
                for(String element : myArrayList) {
                       JCheckBox box = new JCheckBox(element);
                       box.setFont(fuente);
                      // box.setName(element);
                       checkboxes.add(box);
                       jPanel60.add(box);
                       
                   }
                jPanel60.validate();
                jScrollPane23.validate();
                
            } catch (SQLException ex) {
                Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
        }else if(opcion_seleccionado.equals("MENSAJES PARA EMPLEADOS")) {
            for(int x=0;x<checkboxes.size();x++){
                 checkboxes.remove(x);
                 jPanel60.removeAll();
             }
            try {
                String sql9 = "Select nombre from personal";
                Statement us = Conexion.createStatement();
                ResultSet res = us.executeQuery(sql9);
               
                ArrayList<String> myArrayList = new ArrayList<String>();
                
                
                while(res.next()){
                    
                    myArrayList.add(String.valueOf(res.getObject(1)));
                }
                res.close();
                us.close();
                
                Font fuente = new Font("Tahoma", 0,15);
                for(String element : myArrayList) {
                       JCheckBox box = new JCheckBox(element);
                       box.setFont(fuente);
                      // box.setName(element);
                       checkboxes.add(box);
                       jPanel60.add(box);
                       
                   }
                jPanel60.validate();
                jScrollPane23.validate();
                
            } catch (SQLException ex) {
                Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
        }else{
            jPanel60.removeAll();
            jPanel60.validate();
            jScrollPane23.validate();
            
        }
        
        
    }//GEN-LAST:event_jComboBox27ActionPerformed

    private void jButton85ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton85ActionPerformed
        FileDialog dialogoArchivo;
        dialogoArchivo = new FileDialog(this, "Seleccionar ruta de guardado",FileDialog.SAVE);
        dialogoArchivo.setVisible(true);
        
      
        
        if(dialogoArchivo.getName().equals("")){ /* Validar que se haya Sel eccionado un Archivo*/
        
        }else{
            
         String directorio = dialogoArchivo.getDirectory();
         String nombreArchivo =dialogoArchivo.getFile(); 
         String rutatotal = directorio + nombreArchivo;
         jTextField28.setText(rutatotal);
            
        }
        
    }//GEN-LAST:event_jButton85ActionPerformed
  



    private void jCheckBox9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox9ActionPerformed
         if(jCheckBox9.isSelected()){
            if(!checkboxes.isEmpty()){
             for(int x=0;x<checkboxes.size();x++){
                 checkboxes.get(x).setSelected(true);
                 
             }
            }
         }else{
             
             if(jCheckBox9.isSelected()||!checkboxes.isEmpty()){
            
             for(int x=0;x<checkboxes.size();x++){
                 checkboxes.get(x).setSelected(false);
                 
             }
             }
         }
         
        
         
    }//GEN-LAST:event_jCheckBox9ActionPerformed

    private void jButton86ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton86ActionPerformed
        jTextField5.setEditable(false);
        if(jTable3.getSelectedRow()!=-1){
        
        }else{
            JOptionPane.showMessageDialog(null,"Favor de seleccionar un turno");
        }
        
        jDialogTurnos.validate();
        jDialogTurnos.setLocationRelativeTo(null);
        jDialogTurnos.setModal(true);
        jDialogTurnos.setVisible(true);
    }//GEN-LAST:event_jButton86ActionPerformed

    private void jTextField32ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField32ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField32ActionPerformed

    private void jButton87ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton87ActionPerformed
      _cargar(false);
    }//GEN-LAST:event_jButton87ActionPerformed

    private void jButton50ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton50ActionPerformed
        
        try {
            ino.sendData(jTextField26.getText());
        } catch (ArduinoException ex) {
            Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SerialPortException ex) {
            Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton50ActionPerformed

    private void jButton88ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton88ActionPerformed
         _2cargar(true);
    }//GEN-LAST:event_jButton88ActionPerformed

    private void jButton89ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton89ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton89ActionPerformed

    private void jRadioButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton10ActionPerformed
        if(jRadioButton10.isSelected()){
            jComboBox8.setEnabled(false);
        }else{
            jComboBox8.setEnabled(true);
        }
    }//GEN-LAST:event_jRadioButton10ActionPerformed

    private void jButton61ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton61ActionPerformed
     
        
      String nombre_c = JOptionPane.showInputDialog(null,"NOMBRE DEL MODELO DE COTIZACION",String.valueOf(jComboBox15.getSelectedItem()));
      if(nombre_c!= null){
      String percepcion_c="";
      String deducciones_c="";
      String nombre_emp_c = TF_nombre_emp.getText();
      String domicilio_emp_c = TF_domicilio_emp1.getText();
      String rfc_emp_c =  Tf_rfc_emp2.getText();
       
     
      String dias_c = TF_dias_perso3.getText();
      String tarifa_c = TF_tarifa_perso4.getText();
      String salsema_c = TF_salsem.getText();
      String texto_c = TF_texto_c.getText();
      String subdeduc = TF_subdeduc.getText();
      String subpercep = TF_subpercep.getText();
      String total = TF_total.getText();
      for(int u=0;u<jTable9.getRowCount();u++){
          
           percepcion_c = "|"+String.valueOf(jTable9.getValueAt(u,0));
           percepcion_c += ":"+String.valueOf(jTable9.getValueAt(u,1));
           percepcion_c += "*"+String.valueOf(jTable9.getValueAt(u,2));
           percepcion_c += "="+String.valueOf(jTable9.getValueAt(u,3));
           
      }
      for(int u=0;u<jTable8.getRowCount();u++){
          
           deducciones_c = "|"+String.valueOf(jTable8.getValueAt(u,0));
           deducciones_c += ":"+String.valueOf(jTable8.getValueAt(u,1));
           deducciones_c += "*"+String.valueOf(jTable8.getValueAt(u,2));
           deducciones_c += "="+String.valueOf(jTable8.getValueAt(u,3));
           
      }
      
                try {
                    PreparedStatement enrollItmt9;
                    enrollItmt9 = Conexion.prepareStatement("INSERT INTO cotizacion (nombre,empresa,domicilioempre,rfcemisor,dias,percepcion,deduccion,texto,subdeduc,subperce,total,tarifa,salsema ) "
                                                                      + "VALUES ('"+nombre_c+"','"+nombre_emp_c+"','"+domicilio_emp_c+"','"+rfc_emp_c+"','"+dias_c+"','"+percepcion_c+"','"+deducciones_c+"','"+texto_c+"','"+subdeduc+"','"+subpercep+"','"+total+"','"+tarifa_c+"','"+salsema_c+"') ");
                    enrollItmt9.execute();
                    JOptionPane.showMessageDialog(null,"Guardado Correctamente");
                    enrollItmt9.close();
                } catch (SQLException ex) {
                    Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
                }
                actualizart_cotizaciones();
      }
      
    }//GEN-LAST:event_jButton61ActionPerformed

    private void TF_totalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TF_totalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TF_totalActionPerformed

    private void jFormattedTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFormattedTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jFormattedTextField2ActionPerformed
private static Connection cnx = null;
    private void jButton23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton23ActionPerformed
        try {
            Class.forName("com.mysql.jdbc.Driver");
          
            cnx = DriverManager.getConnection("jdbc:mysql://loncheriacoquis.com:2083/loncheri_rehu1", "loncheri_roro", "lonche3131.");
        } catch (SQLException ex) {
            Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
        }
         
    }//GEN-LAST:event_jButton23ActionPerformed

    private void jButton62ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton62ActionPerformed
        String primera_lin = "Nombre Emisor: "+TF_nombre_emp.getText()+ " | Domicilio: "+TF_domicilio_emp1.getText()+" | RFC emisor: "+Tf_rfc_emp2.getText();
        String segunda_lin = "Nombre Receptor: "+TF_nombre_perso.getText()+ " | Codigo: "+TF_codigo_perso.getText()+" | Puesto: "+TF_puesto_perso.getText()+" | RFC receptor"+Tf_rfc_perso.getText();
        String tercera_lin = "No. Social: "+TF_nosocial_perso1.getText()+ " | Periodo: "+TF_periodo_perso2.getText()+" | Dias: "+TF_dias_perso3.getText()+" | Tarifa: "+TF_tarifa_perso4.getText()+" | Fecha Emision: "+TF_fechaemision_perso5.getText();
        String penul_lin = "Subtotal = "+TF_subpercep.getText()+" | "+TF_subdeduc.getText();
        String final_lin = "Recibí de este emisor la cantidad que señala este recibo.     | "+TF_total.getText();
        
        export.exportarExcel3(jTable10,primera_lin,segunda_lin,tercera_lin,penul_lin,final_lin);
    }//GEN-LAST:event_jButton62ActionPerformed

    private void jButton38ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton38ActionPerformed
        _2cargar(true);
    }//GEN-LAST:event_jButton38ActionPerformed

    private void jRadioButton2MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioButton2MouseReleased
       if(jRadioButton2.isSelected()){
           jRadioButton12.setEnabled(false);
           jRadioButton11.setEnabled(false);
       }else{
           jRadioButton12.setEnabled(true);
           jRadioButton11.setEnabled(true);
       }
    }//GEN-LAST:event_jRadioButton2MouseReleased

    private void jRadioButton1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioButton1MouseReleased
            if(jRadioButton2.isSelected()){
           jRadioButton12.setEnabled(false);
           jRadioButton11.setEnabled(false);
       }else{
           jRadioButton12.setEnabled(true);
           jRadioButton11.setEnabled(true);
       }
    }//GEN-LAST:event_jRadioButton1MouseReleased

    private void jCheckBox10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox10ActionPerformed
        
    }//GEN-LAST:event_jCheckBox10ActionPerformed

    private void jButton39ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton39ActionPerformed
        if(jTable2.getSelectedRow()!=-1){
            int filaseleccionada = jTable2.getSelectedRow();
            int codd=(int) jTable2.getValueAt(filaseleccionada, 0);
            try {
                PreparedStatement us1 = Conexion.prepareStatement("DELETE FROM registro WHERE indx ="+codd);
                us1.executeUpdate();
            } catch (Exception e) {
            }
            
            actualizart_registro();
        }else{
            JOptionPane.showMessageDialog(null,"Selecciona un registro");
        }
    }//GEN-LAST:event_jButton39ActionPerformed

    private void jTextField4MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField4MousePressed
        int itme =jTabbedPane1.getSelectedIndex();
        ventana_solicitada=itme;
        
        if(!jTabbedPane1.isEnabled()){
           jLabel10.setText("");
           abrirdialog4();
        }
    }//GEN-LAST:event_jTextField4MousePressed
    public void regs3(String idq, String horaq,String fechaq,String metodoq){
            String nombreq;
            String indxq;
            
            try{               
            String sql="Select nombre from personal where codigo = "+id;
            PreparedStatement us = Conexion.prepareStatement(sql);   
            ResultSet res = us.executeQuery();     
            if(res.next()){      
            nombreq = String.valueOf(res.getObject(1));
            }else{
               
            }
            us.close();
            
                   
        try {
       
            String extracOpt= "SELECT opt from registro where codigo = '"+idq+"' ORDER BY indx DESC";
            String extracIndx = "SELECT indx from registro where codigo = '"+idq+"' ORDER BY indx DESC";
      
            PreparedStatement us1 = Conexion.prepareStatement(extracIndx);
            ResultSet res1 = us1.executeQuery();
            if(res1.next()){
                indxq = String.valueOf(res1.getObject(1));
            }
          
            
           
            PreparedStatement us2 = Conexion.prepareStatement(extracOpt);
            ResultSet res2 = us2.executeQuery();
            
            String buferprueba = consultarpermisos();
            
            if(res2.next()){               
                
               idstatus = String.valueOf(res2.getObject(1));
               
               
               if(consultarpermisos()!=null){
                   regs2(buferprueba);
                   //JOptionPane.showMessageDialog(null, "Se ejecuto regs 2 "+buferprueba);
               }else{
                   regs();
               }
               
               
               
               
                }else{
               
                idstatus = "0";
                regs();
                if(consultarpermisos()!=null){
                   regs2(buferprueba);
                   JOptionPane.showMessageDialog(null, "Se ejecuto regs 2 "+buferprueba);
                }else{
                   regs();
                }
                
                }
            
            
        


        } catch (SQLException ex) {
            log2.wlog("ERROR AL CONSULTAR ESTADO Y INDEX DEL ID = "+id);
               Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        
        
        } catch (SQLException ex) {
            
            log2.wlog("ERROR AL CONSULTAR NOMBRE DEL ID = "+id+" "+ex.getMessage());
               Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
        
    }
    
    DefaultTableModel dm;
    private void filtro(String consulta, JTable jtableBuscar){
        
        dm = (DefaultTableModel) jtableBuscar.getModel();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<>(dm);
        jtableBuscar.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(consulta));
        
    }    
    public String consultarpermisos(){
        String indx2 = "";
        String tipo2 = "";
        String turno99 = null;
        String rr = null;
        try {
            String fecha_inicio = fechaFormat.format(fechahoy);
            String fecha_final = fechaFormat.format(fechahoy);
            String fecha_actual = fechaFormat.format(fechahoy);
            
            
            
            String sql9 = "Select indx,tipo,motivo from permisos where aplica_a like '%"+nombre+"%' and '"+fechaFormat.format(fechahoy)+"' BETWEEN fecha_inicio and fecha_final order by indx DESC";
            //String columna[]= {"Fecha","ENTRADA","EN.COMIDA","SA.COMIDA","SALIDA","T.Comida","T.Horas","Turno"};
            
            Statement us = Conexion.createStatement();
            ResultSet res = us.executeQuery(sql9);
            String[] pp;
            while(res.next()){
              indx2 = String.valueOf(res.getObject(1));
              tipo2 = String.valueOf(res.getObject(2));
              turno99 = String.valueOf(res.getObject(3));
            }
            System.out.println(indx2);
            System.out.println(turno99);
            System.out.println(tipo2);
            us.close();
        } catch (SQLException ex) {
            Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        if(tipo2.equals("Dobla turno")){
            
          rr = turno99;
            
        }else{
            
        }
        
        return rr;
    }
    
    public ImageIcon imgregristro(int optt){
        

      URL winh = this.getClass().getResource("/ico/huellawin.jpg");  
      URL finh = this.getClass().getResource("/ico/huellafail.jpg");
      URL nh = this.getClass().getResource("/ico/huellabus.jpg");
      URL leer= this.getClass().getResource("leerhuella.png");
      
      ImageIcon iconnh = new ImageIcon(nh);  
      ImageIcon iconwh = new ImageIcon(winh);  
      ImageIcon iconfh = new ImageIcon(finh);  
      ImageIcon iconleer = new javax.swing.ImageIcon(this.getClass().getResource("/ico/huella.gif"));
      
      ImageIcon retu = null;
      switch(optt){
          case 1:{
              retu = iconnh;
              break;
          }
          case 2:{
              retu = iconwh;
              break;
          }
          case 3:{
              retu = iconfh;
              break;
          }  
          case 4:{
              retu = iconleer;
              break;
          }
    }
 
      return retu;  
        
    }
    
      
    public void insertarturno(String nombre,String entrada, String tiempo_comida, String salida,String dias){
        

        try {
            PreparedStatement enrollItmt;
            enrollItmt = Conexion.prepareStatement("INSERT INTO turnos (nombre, entrada, tiempo_comida, salida, dias ) VALUES ('"+nombre+"','"+entrada+"','"+tiempo_comida+"','"+salida+"','"+dias+"') ");
            enrollItmt.execute();
           
        } catch (SQLException ex) {
            Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
        }
         
        
    }
      
    public void insertarturno2(String nombre,String l_e,String m_e,String mi_e,String j_e,String v_e,String s_e,String d_e,String l_s,String m_s,String mi_s,String j_s,String v_s,String s_s,String d_s,String t_comida,String h_comida,String tolerancia,String falta){
        

        try {
            PreparedStatement enrollItmt;
            enrollItmt = Conexion.prepareStatement("INSERT INTO turnos (nombre,l_e,m_e,mi_e,j_e,v_e,s_e,d_e,l_s,m_s,mi_s,j_s,v_s,s_s,d_s,t_comida,h_comida,tolerancia,falta) VALUES ('"+nombre+"','"+l_e+"','"+m_e+"','"+mi_e+"','"+j_e+"','"+v_e+"','"+s_e+"','"+d_e+"','"+l_s+"','"+m_s+"','"+mi_s+"','"+j_s+"','"+v_s+"','"+s_s+"','"+d_s+"','"+t_comida+"','"+h_comida+"','"+tolerancia+"','"+falta+"',) ");
            enrollItmt.execute();
           
        } catch (SQLException ex) {
            Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
        }
         
        
    }
     Date dddw = new Date();
     DateFormat hourmat = new SimpleDateFormat("HH:mm");
     
    public void contar(JTable tab){
       
        int retardos=0;
        int tolerancias=0;
        long totaldehoras=0;
        
     //   System.out.println(dddw);
        
        int row = tab.getRowCount();
        
          long buf=0;
        for(int i=0;i<row;i++){
            String analiz = String.valueOf(tab.getValueAt(i, 1));
            String analiz2 = String.valueOf(tab.getValueAt(i, 6));
         
            
            try {
                dddw.setTime(hourmat.parse(analiz2).getTime());
               
            } catch (ParseException ex) {
                  JOptionPane.showMessageDialog(null, "trioerror");
                Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
            }
           // System.out.println(dddw);
           
            try {
                buf += hourFormat.parse(analiz2).getTime()-2.16e+7;
               // System.out.println(hourFormat.parse(analiz2));
            } catch (ParseException ex) {
                Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
            }
            
              totaldehoras = buf;//- 21600000;
            //+= totaldehoras+d; 
          
          //  System.out.println(analiz);
         //   System.out.println(analiz2);
         //   System.out.println(totaldehoras);
            
          if(analiz.contains("R")){
               retardos++;
           }
          if(analiz.contains("T")){
               tolerancias++;
           }
        
   
        }
        
        long horaa  = (long) (totaldehoras/3600002.88);
        long restohora = totaldehoras%3600000;
        long minuto = restohora/60000;
        
        labetotalhoras.setText(horaa+":"+minuto);
        laberetardos.setText(Integer.toString(retardos));
        labetolerancia.setText(Integer.toString(tolerancias));
        
        
        
    }
    public void contarpturno(JTable tab){
       
        dddw= null;
        int retardos=0;
        int tolerancias=0;
        long totaldehoras=0;
        
      //  System.out.println(dddw);
        
        int row = tab.getRowCount();
        
          
        for(int i=0;i<row;i++){
            String analiz = String.valueOf(tab.getValueAt(i, 2));
            String analiz2 = String.valueOf(tab.getValueAt(i, 7));
         
            
            try {
                dddw = hourmat .parse(analiz2);
               
            } catch (ParseException ex) {
                  JOptionPane.showMessageDialog(null, "trioerror");
                Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
            }
          //  System.out.println(dddw);
            long d = (long) dddw.getTime() - 21600000;
            totaldehoras = (long)totaldehoras+d; 
          
           // System.out.println(analiz);
           // System.out.println(analiz2);
           // System.out.println(totaldehoras);
          if(analiz.contains("R")){
               retardos++;
           }
          if(analiz.contains("T")){
               tolerancias++;
           }
        
   
        }
        
        long horaa  = (long) (totaldehoras/3.6e+6);
        long restohora = totaldehoras%3600000;
        long minuto = restohora/60000;
        
        labetotalhoras.setText(horaa+":"+minuto);
        laberetardos.setText(Integer.toString(retardos));
        labetolerancia.setText(Integer.toString(tolerancias));
        
        
        
    }
    public void initnp(){
     
    DefaultComboBoxModel modeloCombottt = new DefaultComboBoxModel();
    DefaultComboBoxModel modeloCombotttmix = new DefaultComboBoxModel();
    DefaultComboBoxModel modeloCombotttmix2 = new DefaultComboBoxModel();
    
    modeloCombottt.removeAllElements();
    modeloCombotttmix.removeAllElements();
    modeloCombotttmix2.removeAllElements();
    
    int roww = jTable1.getRowCount() ;

    for(int x=0;x<roww;x++){
       
        modeloCombottt.addElement(jTable1.getValueAt(x,0));
        
        modeloCombotttmix.addElement(jTable1.getValueAt(x,0));
        modeloCombotttmix2.addElement(jTable1.getValueAt(x,0));
        
    }   
         
        modeloCombotttmix.addElement("Libre");
        modeloCombotttmix2.addElement("Libre");
        jComboBox11.setModel(modeloCombotttmix);
        jComboBox12.setModel(modeloCombotttmix2);
        
        
        jComboBox7.setModel(modeloCombottt);
        jComboBox7.addItem("Libre");
        jComboBox7.addItem("Mixto");
        jComboBox7.addItem("Personalizado");
        
                                 
        
        
    jButton25.setEnabled(true);
    DefaultComboBoxModel modeloCombott = new DefaultComboBoxModel();
    jLhuella.setIcon(imgregristro(1));
    jComboBox10.removeAllItems();
    
    jLabel46.setForeground(Color.black);
    jLabel46.setFont(new Font ("Serif", Font.BOLD, 16));
    jLabel46.setText("Capturando");
    jtlocalidad1.setText("");
    jtnombre1.setText("");
    
    jttelca1.setText("");
    jttelcel1.setText("");
     
    jComboBox20.removeAllItems();
    for(int v=0;v<jTable12.getRowCount();v++){
        
        jComboBox20.addItem(String.valueOf(jTable12.getValueAt(v,1)));
        
    } 
    
    
    
    }
   
    void setPanelEnabled(JPanel panel, Boolean isEnabled) { panel.setEnabled(isEnabled); Component[] components = panel.getComponents(); for (Component component : components) { if (component instanceof JPanel) { setPanelEnabled((JPanel) component, isEnabled); } component.setEnabled(isEnabled); } }
   
    
    public void nuevopersonal(){

    jComboBox10.removeAllItems();
    
        for(int x=1;x<128;x++){
        //modeloComboc.addElement(x);
        
        jComboBox10.addItem(Integer.toString(x));
        modeloComboc = (DefaultComboBoxModel) jComboBox10.getModel();
        
    }
        try {
       // Conexion = (Connection) DriverManager.getConnection(c.getUrl(),c.getUser(),c.getPass());
        String sql = "Select codigo from personal ";
        PreparedStatement us = Conexion.prepareStatement(sql);
        ResultSet res = us.executeQuery();
     
 
        while (res.next()) {
            String cobus = res.getObject("codigo").toString();
            int indexc = modeloComboc.getIndexOf(cobus);
            
            if(indexc!=-1){
                jComboBox10.removeItemAt(indexc);
            }
            
        }
            us.close();
    } catch (SQLException ex) {
        JOptionPane.showConfirmDialog(null, "error al eliminar codigos");
      //  Logger.getLogger(nuevo_personal.class.getName()).log(Level.SEVERE, null, ex);
    }
    try { 
        Thread.sleep(300);
        
        
    } catch (InterruptedException ex) {
       // Logger.getLogger(nuevo_personal.class.getName()).log(Level.SEVERE, null, ex);
    }
         try {
        ino.sendData("2");
    } catch (ArduinoException | SerialPortException ex) {
        jButton25.setEnabled(false);
        jLabel46.setForeground(Color.red);
        jLabel46.setFont(new Font ("Serif", Font.BOLD, 16));
        jLabel46.setText("FALLA! CONEXION CON EL CHECADOR");
       // Logger.getLogger(nuevo_personal.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
    
    public void insertar() {
    try {
        String codigoo= (String) jComboBox10.getSelectedItem();
        String nombre5 = jtnombre1.getText();
        String localidad = jtlocalidad1.getText();
        String telcel = jttelcel1.getText();
        String telca = jttelca1.getText();
        String turno = null;
        String cotizacion = (String) jComboBox20.getSelectedItem();
        String rfc = jtlrfc.getText();
        String puesto = jtPUESTO.getText();
        String nosocial = jtnosocial1.getText();
        if(jComboBox7.getSelectedItem().equals("Mixto")){
            
            turno = String.valueOf(jComboBox11.getSelectedItem())+"/"+String.valueOf(jComboBox12.getSelectedItem());
            
        }else{
            
            turno = String.valueOf(jComboBox7.getSelectedItem());
            
        }
        
        
        String sqldomicilio = localidad;
        
        
      
        
        PreparedStatement enrollItmt;
        
        if(jButton5.isEnabled()==false){
            
            enrollItmt = Conexion.prepareStatement("UPDATE personal SET  nombre = '"+nombre5+"', domicilio = '"+sqldomicilio+"' , telcel = '"+telcel+" ', telca= '"+telca+"',turno= '"+turno+"',cotizacion ='"+cotizacion+"',nosocial ='"+nosocial+"',puesto ='"+puesto+"',rfc ='"+rfc+"' WHERE codigo = "+codigoo );
            enrollItmt.execute();
            JOptionPane.showMessageDialog(null,"Registro editado correctamente");    
            
        }else{
            
        enrollItmt = Conexion.prepareStatement("INSERT INTO personal (codigo,nombre,domicilio,telcel,telca,turno,cotizacion,nosocial,puesto,rfc) VALUES ('"+codigoo+"','"+nombre5+"','"+sqldomicilio+"','"+telcel+"','"+telca+"','"+turno+"','"+cotizacion+"','"+nosocial+"','"+puesto+"','"+rfc+"')");
        enrollItmt.execute();  
        JOptionPane.showMessageDialog(null,"Registro agregado correctamente");    
        }
        
        
       
        
        
        
        try {
            ino.sendData("124");
        } catch (ArduinoException | SerialPortException ex) {
            Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        actualizart_personal();
        iniciarnominas();

        jButton5.setEnabled(true);
    } catch (SQLException ex) {
        Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
    }
        
    }
    
    public String [] registrarretados(){
      String retu[]={"",""}; 
      int row = jTable1.getRowCount();
      int indxdone=0;
      String nturno="";
      String tabla[]=new String[row];
      boolean turen;
      String horaentrada="";
      
      
           String sql="Select turno from personal where codigo = "+id;
           PreparedStatement us;   
      
      
          
        try {
            
            
            us = Conexion.prepareStatement(sql);
            ResultSet res = us.executeQuery();
            
        
            
            
            
            if(res.next()){
                //System.out.println("ENtrotroer");
                nturno = String.valueOf(res.getObject(1));
          
      
                     for(int x=0;x<row;x++){
                     tabla[x]=  (String) jTable1.getModel().getValueAt(x, 0);
 
                       if(tabla[x].equals(nturno)){
                           indxdone=x;
                          // System.out.println("ENcontro turnnnnO"+tabla[x]);
                       }
    
                     }
                     
                }
            
            us.close();
            if(nturno.contains("/")){
               // System.out.println("SE detecto doble turno");
                
                String sql4="Select opt from registro where codigo = "+id+" AND fecha = '"+ fechaFormat.format(fechahoy)+"'" ;
                PreparedStatement us4;  
                us4 = Conexion.prepareStatement(sql4);
                ResultSet res4 = us4.executeQuery();
                if(res4.next()){
                    
                    String opttemp =String.valueOf(res4.getObject(1));
                    System.out.println(opttemp);
                    if(opttemp.equals("0")){
                        System.out.println("ejecutar con segundo turno");
                        nturno =  nturno.substring(nturno.indexOf("/")+1);
                      //  System.err.println(segundoturno);
                        for(int x=0;x<row;x++){
                     tabla[x]=  (String) jTable1.getModel().getValueAt(x, 0);
 
                       if(tabla[x].equals(nturno)){
                           indxdone=x;
                          // System.out.println("ENcontro turnnnnO"+tabla[x]);
                       }
    
                     }
                        
                    }
                    
                    
                }else{
                    System.out.println("Primer turno");
                    nturno =  nturno.substring(0,nturno.indexOf("/"));
                    for(int x=0;x<row;x++){
                     tabla[x]=  (String) jTable1.getModel().getValueAt(x, 0);
 
                       if(tabla[x].equals(nturno)){
                           indxdone=x;
                          // System.out.println("ENcontro turnnnnO"+tabla[x]);
                       }
    
                     }
                    
                }
                us4.close();
                
            }
            
            } catch (SQLException ex) {
            Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
        }
                
              if(indxdone==100){
                  turen=false;
              }else{
                  horaentrada=(String) jTable1.getValueAt(indxdone,1);
              }
              
              
              String entrada = hourFormat.format(new Date());
              Date d2=new Date();
              Date dd2=new Date(); 
               
              
              
            try {
                d2= hourFormat.parse(horaentrada);
                dd2= hourFormat.parse(entrada);
               
               
            } catch (ParseException ex) {
                Logger.getLogger(act_tablas1.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
            
            long ent= dd2.getTime();
            long entstol =d2.getTime();
            long tol= d2.getTime()+600000;
             
         // System.out.println("ent"+ent);
           // System.out.println("entsto1"+entstol);
           // System.out.println("tol"+tol);
            
         if(entstol>=ent){
                
                retu[0]= "";
                
                
            }else if(ent<=tol){
                
                retu[0]="T -";
                
            }else if(ent>tol){
                
                retu[0]="R -";
                
            }
            
      
      
      
      //  System.out.println(retu);
         retu[1] = nturno;
      return  retu;
      
    }
    public String [] registrarretados2(String nturno){
      String retu[]={"",""}; 
      int row = jTable1.getRowCount();
      int indxdone=0;
      
      String tabla[]=new String[row];
      boolean turen;
      String horaentrada="";
     try{
            if(nturno.contains("/")){
                System.out.println("SE detecto doble turno");
                
                String sql4="Select opt from registro where codigo = "+id+" AND fecha = '"+ fechaFormat.format(fechahoy)+"'" ;
                PreparedStatement us4;  
                us4 = Conexion.prepareStatement(sql4);
                ResultSet res4 = us4.executeQuery();
                if(res4.next()){
                    
                    String opttemp =String.valueOf(res4.getObject(1));
                    System.out.println(opttemp);
                    if(opttemp.equals("0")){
                        System.out.println("ejecutar con segundo turno");
                        nturno =  nturno.substring(nturno.indexOf("/")+1);
                      //  System.err.println(segundoturno);
                        for(int x=0;x<row;x++){
                     tabla[x]=  (String) jTable1.getModel().getValueAt(x, 0);
 
                       if(tabla[x].equals(nturno)){
                           indxdone=x;
                          // System.out.println("ENcontro turnnnnO"+tabla[x]);
                       }
    
                     }
                        
                    }
                    
                    
                }else{
                    System.out.println("Primer turno");
                    nturno =  nturno.substring(0,nturno.indexOf("/"));
                    for(int x=0;x<row;x++){
                     tabla[x]=  (String) jTable1.getModel().getValueAt(x, 0);
 
                       if(tabla[x].equals(nturno)){
                           indxdone=x;
                          // System.out.println("ENcontro turnnnnO"+tabla[x]);
                       }
    
                     }
                    
                }
                
                
            }
            
            } catch (SQLException ex) {
            Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
        }
                
              if(indxdone==100){
                  turen=false;
              }else{
                  horaentrada=(String) jTable1.getValueAt(indxdone,1);
              }
              
              
              String entrada = hourFormat.format(new Date());
              Date d2=new Date();
              Date dd2=new Date(); 
               
              
              
            try {
                d2= hourFormat.parse(horaentrada);
                dd2= hourFormat.parse(entrada);
               
               
            } catch (ParseException ex) {
                Logger.getLogger(act_tablas1.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
            
            long ent= dd2.getTime();
            long entstol =d2.getTime();
            long tol= d2.getTime()+600000;
             
         // System.out.println("ent"+ent);
           // System.out.println("entsto1"+entstol);
           // System.out.println("tol"+tol);
            
         if(entstol>=ent){
                
                retu[0]= "";
                
                
            }else if(ent<=tol){
                
                retu[0]="T -";
                
            }else if(ent>tol){
                
                retu[0]="R -";
                
            }
            
      
      
      
      //  System.out.println(retu);
         retu[1] = nturno;
      return  retu;
      
    }
    
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
             javax.swing.UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            //}
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDialog DialogPermisos;
    private javax.swing.JTextField TF_codigo_perso;
    private javax.swing.JTextField TF_dias_perso3;
    private javax.swing.JTextField TF_domicilio_emp1;
    private javax.swing.JTextField TF_fechaemision_perso5;
    private javax.swing.JTextField TF_nombre_emp;
    private javax.swing.JTextField TF_nombre_perso;
    private javax.swing.JTextField TF_nosocial_perso1;
    private javax.swing.JTextField TF_periodo_perso2;
    private javax.swing.JTextField TF_puesto_perso;
    private javax.swing.JFormattedTextField TF_salsem;
    private javax.swing.JLabel TF_subdeduc;
    private javax.swing.JLabel TF_subpercep;
    private javax.swing.JTextField TF_tarifa_perso4;
    private javax.swing.JTextArea TF_texto_c;
    private javax.swing.JFormattedTextField TF_total;
    private javax.swing.JTextField Tf_rfc_emp2;
    private javax.swing.JTextField Tf_rfc_perso;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.ButtonGroup buttonGroup4;
    private javax.swing.ButtonGroup buttonGrouporden;
    private javax.swing.ButtonGroup confpuert;
    private javax.swing.JLabel fechalabel;
    private javax.swing.ButtonGroup grupodegraficas;
    private javax.swing.JButton jBaceptarturno;
    private javax.swing.JButton jBaceptarturno1;
    private javax.swing.JButton jBaceptarturno2;
    private javax.swing.JButton jBaceptarturno3;
    private javax.swing.JButton jBcancelarturno;
    private javax.swing.JButton jBcancelarturno1;
    private javax.swing.JButton jBcancelarturno2;
    private javax.swing.JButton jBcancelarturno3;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton20;
    private javax.swing.JButton jButton21;
    private javax.swing.JButton jButton22;
    private javax.swing.JButton jButton23;
    private javax.swing.JButton jButton24;
    private javax.swing.JButton jButton25;
    private javax.swing.JButton jButton26;
    private javax.swing.JButton jButton27;
    private javax.swing.JButton jButton28;
    private javax.swing.JButton jButton29;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton30;
    private javax.swing.JButton jButton31;
    private javax.swing.JButton jButton32;
    private javax.swing.JButton jButton33;
    private javax.swing.JButton jButton34;
    private javax.swing.JButton jButton35;
    private javax.swing.JButton jButton36;
    private javax.swing.JButton jButton37;
    private javax.swing.JButton jButton38;
    private javax.swing.JButton jButton39;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton41;
    private javax.swing.JButton jButton42;
    private javax.swing.JButton jButton43;
    private javax.swing.JButton jButton44;
    private javax.swing.JButton jButton45;
    private javax.swing.JButton jButton46;
    private javax.swing.JButton jButton47;
    private javax.swing.JButton jButton48;
    private javax.swing.JButton jButton49;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton50;
    private javax.swing.JButton jButton51;
    private javax.swing.JButton jButton52;
    private javax.swing.JButton jButton53;
    private javax.swing.JButton jButton54;
    private javax.swing.JButton jButton55;
    private javax.swing.JButton jButton56;
    private javax.swing.JButton jButton57;
    private javax.swing.JButton jButton58;
    private javax.swing.JButton jButton59;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton60;
    private javax.swing.JButton jButton61;
    private javax.swing.JButton jButton62;
    private javax.swing.JButton jButton64;
    private javax.swing.JButton jButton65;
    private javax.swing.JButton jButton66;
    private javax.swing.JButton jButton67;
    private javax.swing.JButton jButton69;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton70;
    private javax.swing.JButton jButton71;
    private javax.swing.JButton jButton79;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton80;
    private javax.swing.JButton jButton81;
    private javax.swing.JButton jButton82;
    private javax.swing.JButton jButton85;
    private javax.swing.JButton jButton86;
    private javax.swing.JButton jButton87;
    private javax.swing.JButton jButton88;
    private javax.swing.JButton jButton89;
    private javax.swing.JButton jButton9;
    private com.toedter.calendar.JCalendar jCalendar1;
    private com.toedter.calendar.JCalendar jCalendar2;
    private com.toedter.calendar.JCalendar jCalendar3;
    private com.toedter.calendar.JCalendar jCalendar4;
    private com.toedter.calendar.JCalendar jCalendar5;
    private com.toedter.calendar.JCalendar jCalendar8;
    private com.toedter.calendar.JCalendar jCalendar9;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox10;
    private javax.swing.JCheckBox jCheckBox11;
    private javax.swing.JCheckBox jCheckBox12;
    private javax.swing.JCheckBox jCheckBox13;
    private javax.swing.JCheckBox jCheckBox14;
    private javax.swing.JCheckBox jCheckBox15;
    private javax.swing.JCheckBox jCheckBox16;
    private javax.swing.JCheckBox jCheckBox17;
    private javax.swing.JCheckBox jCheckBox18;
    private javax.swing.JCheckBox jCheckBox19;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox20;
    private javax.swing.JCheckBox jCheckBox21;
    private javax.swing.JCheckBox jCheckBox22;
    private javax.swing.JCheckBox jCheckBox23;
    private javax.swing.JCheckBox jCheckBox24;
    private javax.swing.JCheckBox jCheckBox25;
    private javax.swing.JCheckBox jCheckBox26;
    private javax.swing.JCheckBox jCheckBox27;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JCheckBox jCheckBox4;
    private javax.swing.JCheckBox jCheckBox5;
    private javax.swing.JCheckBox jCheckBox6;
    private javax.swing.JCheckBox jCheckBox7;
    private javax.swing.JCheckBox jCheckBox8;
    private javax.swing.JCheckBox jCheckBox9;
    private javax.swing.JComboBox<String> jChorasalida;
    private javax.swing.JComboBox<String> jChorasalida10;
    private javax.swing.JComboBox<String> jChorasalida11;
    private javax.swing.JComboBox<String> jChorasalida12;
    private javax.swing.JComboBox<String> jChorasalida13;
    private javax.swing.JComboBox<String> jChorasalida7;
    private javax.swing.JComboBox<String> jChorasalida8;
    private javax.swing.JComboBox<String> jChorasalida9;
    private javax.swing.JComboBox<String> jChorentrada;
    private javax.swing.JComboBox<String> jChorentrada10;
    private javax.swing.JComboBox<String> jChorentrada11;
    private javax.swing.JComboBox<String> jChorentrada12;
    private javax.swing.JComboBox<String> jChorentrada13;
    private javax.swing.JComboBox<String> jChorentrada14;
    private javax.swing.JComboBox<String> jChorentrada15;
    private javax.swing.JComboBox<String> jChorentrada8;
    private javax.swing.JComboBox<String> jChorentrada9;
    private javax.swing.JComboBox<String> jCminutosalida;
    private javax.swing.JComboBox<String> jCminutosalida10;
    private javax.swing.JComboBox<String> jCminutosalida11;
    private javax.swing.JComboBox<String> jCminutosalida12;
    private javax.swing.JComboBox<String> jCminutosalida13;
    private javax.swing.JComboBox<String> jCminutosalida7;
    private javax.swing.JComboBox<String> jCminutosalida8;
    private javax.swing.JComboBox<String> jCminutosalida9;
    private javax.swing.JComboBox<String> jCminutosentrada;
    private javax.swing.JComboBox<String> jCminutosentrada10;
    private javax.swing.JComboBox<String> jCminutosentrada11;
    private javax.swing.JComboBox<String> jCminutosentrada12;
    private javax.swing.JComboBox<String> jCminutosentrada13;
    private javax.swing.JComboBox<String> jCminutosentrada14;
    private javax.swing.JComboBox<String> jCminutosentrada15;
    private javax.swing.JComboBox<String> jCminutosentrada8;
    private javax.swing.JComboBox<String> jCminutosentrada9;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox10;
    private javax.swing.JComboBox<String> jComboBox11;
    private javax.swing.JComboBox<String> jComboBox12;
    private javax.swing.JComboBox<String> jComboBox13;
    private javax.swing.JComboBox<String> jComboBox14;
    private javax.swing.JComboBox<String> jComboBox15;
    private javax.swing.JComboBox<String> jComboBox16;
    private javax.swing.JComboBox<String> jComboBox17;
    private javax.swing.JComboBox<String> jComboBox18;
    private javax.swing.JComboBox<String> jComboBox19;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox20;
    private javax.swing.JComboBox<String> jComboBox25;
    private javax.swing.JComboBox<String> jComboBox26;
    private javax.swing.JComboBox<String> jComboBox27;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JComboBox<String> jComboBox4;
    private javax.swing.JComboBox<String> jComboBox5;
    private javax.swing.JComboBox<String> jComboBox6;
    private javax.swing.JComboBox<String> jComboBox7;
    private javax.swing.JComboBox<String> jComboBox8;
    private javax.swing.JComboBox<String> jComboBox9;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JDialog jDialog10;
    private javax.swing.JDialog jDialog3;
    private javax.swing.JDialog jDialog4;
    private javax.swing.JDialog jDialog5;
    private javax.swing.JDialog jDialog6;
    private javax.swing.JDialog jDialog7;
    private javax.swing.JDialog jDialogConceptos;
    private javax.swing.JDialog jDialogTurnos;
    private javax.swing.JFormattedTextField jFormattedTextField10;
    private javax.swing.JFormattedTextField jFormattedTextField11;
    private javax.swing.JFormattedTextField jFormattedTextField17;
    private javax.swing.JFormattedTextField jFormattedTextField2;
    private javax.swing.JFormattedTextField jFormattedTextField3;
    private javax.swing.JFormattedTextField jFormattedTextField4;
    private javax.swing.JFormattedTextField jFormattedTextField5;
    private javax.swing.JFormattedTextField jFormattedTextField6;
    private javax.swing.JFormattedTextField jFormattedTextField7;
    private javax.swing.JFormattedTextField jFormattedTextField8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel102;
    private javax.swing.JLabel jLabel103;
    private javax.swing.JLabel jLabel104;
    private javax.swing.JLabel jLabel105;
    private javax.swing.JLabel jLabel106;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel110;
    private javax.swing.JLabel jLabel111;
    private javax.swing.JLabel jLabel113;
    private javax.swing.JLabel jLabel114;
    private javax.swing.JLabel jLabel115;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel146;
    private javax.swing.JLabel jLabel147;
    private javax.swing.JLabel jLabel148;
    private javax.swing.JLabel jLabel149;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel150;
    private javax.swing.JLabel jLabel151;
    private javax.swing.JLabel jLabel157;
    private javax.swing.JLabel jLabel158;
    private javax.swing.JLabel jLabel159;
    private javax.swing.JLabel jLabel160;
    private javax.swing.JLabel jLabel161;
    private javax.swing.JLabel jLabel162;
    private javax.swing.JLabel jLabel163;
    private javax.swing.JLabel jLabel164;
    private javax.swing.JLabel jLabel165;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JLabel jLabel89;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel90;
    private javax.swing.JLabel jLabel98;
    private javax.swing.JLabel jLabelss;
    private javax.swing.JLabel jLhuella;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel32;
    private javax.swing.JPanel jPanel33;
    private javax.swing.JPanel jPanel34;
    private javax.swing.JPanel jPanel35;
    private javax.swing.JPanel jPanel36;
    private javax.swing.JPanel jPanel37;
    private javax.swing.JPanel jPanel38;
    private javax.swing.JPanel jPanel39;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel40;
    private javax.swing.JPanel jPanel41;
    private javax.swing.JPanel jPanel42;
    private javax.swing.JPanel jPanel43;
    private javax.swing.JPanel jPanel44;
    private javax.swing.JPanel jPanel45;
    private javax.swing.JPanel jPanel46;
    private javax.swing.JPanel jPanel47;
    private javax.swing.JPanel jPanel48;
    private javax.swing.JPanel jPanel49;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel50;
    private javax.swing.JPanel jPanel51;
    private javax.swing.JPanel jPanel52;
    private javax.swing.JPanel jPanel53;
    private javax.swing.JPanel jPanel54;
    private javax.swing.JPanel jPanel55;
    private javax.swing.JPanel jPanel56;
    private javax.swing.JPanel jPanel57;
    private javax.swing.JPanel jPanel58;
    private javax.swing.JPanel jPanel59;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel60;
    private javax.swing.JPanel jPanel61;
    private javax.swing.JPanel jPanel62;
    private javax.swing.JPanel jPanel63;
    private javax.swing.JPanel jPanel64;
    private javax.swing.JPanel jPanel65;
    private javax.swing.JPanel jPanel66;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton10;
    private javax.swing.JRadioButton jRadioButton11;
    private javax.swing.JRadioButton jRadioButton12;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JRadioButton jRadioButton5;
    private javax.swing.JRadioButton jRadioButton6;
    private javax.swing.JRadioButton jRadioButton7;
    private javax.swing.JRadioButton jRadioButton8;
    private javax.swing.JRadioButton jRadioButton9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane15;
    private javax.swing.JScrollPane jScrollPane16;
    private javax.swing.JScrollPane jScrollPane17;
    private javax.swing.JScrollPane jScrollPane18;
    private javax.swing.JScrollPane jScrollPane19;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane21;
    private javax.swing.JScrollPane jScrollPane22;
    private javax.swing.JScrollPane jScrollPane23;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTabbedPane jTabbedPane3;
    private javax.swing.JTabbedPane jTabbedPane4;
    private javax.swing.JTabbedPane jTabbedPane5;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable10;
    private javax.swing.JTable jTable11;
    private javax.swing.JTable jTable12;
    private javax.swing.JTable jTable13;
    private javax.swing.JTable jTable14;
    private javax.swing.JTable jTable15;
    private javax.swing.JTable jTable18;
    private javax.swing.JTable jTable19;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable jTable4;
    private javax.swing.JTable jTable5;
    private javax.swing.JTable jTable6;
    private javax.swing.JTable jTable7;
    private javax.swing.JTable jTable8;
    private javax.swing.JTable jTable9;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField13;
    private javax.swing.JTextField jTextField14;
    private javax.swing.JTextField jTextField15;
    private javax.swing.JTextField jTextField16;
    private javax.swing.JTextField jTextField17;
    private javax.swing.JTextField jTextField18;
    private javax.swing.JTextField jTextField19;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField20;
    private javax.swing.JTextField jTextField21;
    private javax.swing.JTextField jTextField22;
    private javax.swing.JTextField jTextField23;
    private javax.swing.JTextField jTextField24;
    private javax.swing.JTextField jTextField25;
    private javax.swing.JTextField jTextField26;
    private javax.swing.JTextField jTextField27;
    private javax.swing.JTextField jTextField28;
    private javax.swing.JTextField jTextField29;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField32;
    private javax.swing.JTextField jTextField33;
    private javax.swing.JTextField jTextField34;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    private javax.swing.JTextPane jTextPane1;
    private com.toedter.calendar.JCalendar jda;
    private com.toedter.calendar.JCalendar jda1;
    private com.toedter.calendar.JCalendar jda2;
    private com.toedter.calendar.JCalendar jda3;
    private com.toedter.calendar.JCalendar jdde;
    private com.toedter.calendar.JCalendar jdde1;
    private com.toedter.calendar.JCalendar jdde2;
    private com.toedter.calendar.JCalendar jdde3;
    private javax.swing.JTextField jtPUESTO;
    private javax.swing.JTextField jtlocalidad1;
    private javax.swing.JTextField jtlrfc;
    private javax.swing.JTextField jtnombre1;
    private javax.swing.JTextField jtnosocial1;
    private javax.swing.JTextField jttelca1;
    private javax.swing.JTextField jttelcel1;
    private javax.swing.JLabel laberetardos;
    private javax.swing.JLabel labetolerancia;
    private javax.swing.JLabel labetotalhoras;
    private javax.swing.JLabel lbHora;
    private java.awt.MenuItem menuItem1;
    private javax.swing.JComboBox<String> mincomida;
    private javax.swing.JComboBox<String> mincomida3;
    private javax.swing.JComboBox<String> mincomida4;
    private javax.swing.JComboBox<String> mincomida5;
    private java.awt.PopupMenu popupMenu1;
    private javax.swing.JComboBox<String> tiempocomida;
    private javax.swing.JComboBox<String> tiempocomida1;
    private javax.swing.ButtonGroup treport;
    // End of variables declaration//GEN-END:variables
}
