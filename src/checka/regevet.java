/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checka;

import static com.sun.javafx.scene.control.skin.Utils.getResource;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.Writer;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import java.util.stream.Stream;
import javax.print.event.PrintJobEvent;
import javax.swing.JOptionPane;
import jdk.nashorn.internal.runtime.regexp.RegExp;

/**
 *
 * @author DC45-61
 */
public class regevet {
 File fichero = null;
 PrintWriter pw = null;
 
 Date dat = new Date();
 DateFormat formatodate = new SimpleDateFormat("HH:mm:ss dd/MM/yy");
 

 Stream ffiche;
 
public void wlog(String mensaj){
   
        Logger logger = Logger.getLogger("MyLog");
        FileHandler fh;

        try {

            fh = new FileHandler("LOG",true);
            logger.addHandler(fh);

            SimpleFormatter formatter = new SimpleFormatter();
            fh.setFormatter(formatter);

            logger.info(mensaj);
           
            fh.close();

        } catch (SecurityException | IOException e) {
            e.printStackTrace();
            
        }
    
}
    
    
}
