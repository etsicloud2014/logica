/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package diccionario;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author borja
 */
public class Diccionario {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args){
      final String ruta="/home/borja/NetBeansProjects/Diccionario/palabras.txt"; 
      File archivo = null;
      FileReader fr = null;
      BufferedReader br = null;
      List<String> tipo = new ArrayList<String>();
      List<String>  palabras= new ArrayList<String>();
      String[] cadena;
      int i=0;
      Integer lastIndex=0;
      
 
      try {
         // Apertura del fichero y creacion de BufferedReader para poder
         // hacer una lectura comoda (disponer del metodo readLine()).
         archivo = new File (ruta);
         fr = new FileReader (archivo);
         br = new BufferedReader(fr);
 
         // Lectura del fichero
         String linea;
         while((linea=br.readLine())!=null){
            System.out.println(linea);
            if(i==0){
                tipo.add(linea);
                i++;
                
             
         }
            else{
                cadena=linea.split(";");
                tipo.add(lastIndex.toString());
                lastIndex=cadena.length;
                for(i=0;i<cadena.length;i++)
                    palabras.add(cadena[i]);
                i=0;
            }
         }
          for(i=0;i<palabras.size();i++)
            System.out.println(palabras.get(i));
          for(i=0;i<tipo.size();i++)
            System.out.println(tipo.get(i));
      }
      catch(Exception e){
         e.printStackTrace();
      }finally{
         // En el finally cerramos el fichero, para asegurarnos
         // que se cierra tanto si todo va bien como si salta 
         // una excepcion.
         try{                    
            if( null != fr ){   
               fr.close();     
            }                  
         }catch (Exception e2){ 
            e2.printStackTrace();
         }
      }
    }
    public String[] getPalabras(){
        return null;
    } 
    public String getTipo(String palabra){
        return null;
    }
}
