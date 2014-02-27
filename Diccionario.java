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
      private static List<String> tipo = new ArrayList<String>();
      private static List<String>  palabras= new ArrayList<String>();
    public Diccionario(){
    final String ruta="/home/borja/NetBeansProjects/Diccionario/palabras.txt"; 
      File archivo = null;
      FileReader fr = null;
      BufferedReader br = null;
      
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
         /*
          for(i=0;i<palabras.size();i++)
            System.out.println(palabras.get(i));
          for(i=0;i<tipo.size();i++)
            System.out.println(tipo.get(i));
          
          */
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
    
    public static void main(String[] args){
      
    }
    public String[] getPalabras(){
        String[] cadena=new String[palabras.size()];    
        palabras.toArray(cadena);
        for (int i=0;i<palabras.size();i++){
        }
        return cadena;
    } 
    public String getTipo(String palabra){
        int i,index, iTipo=1;
        String cadena;
        boolean b=false;
        System.out.println(palabra);
        //Comprobaos que la palabra si que esta en la lista de palabras
        for (i=0;i<palabras.size();i++){
            if (palabra.equals(palabras.get(i))){
                b=true;
            }
            
                
            
        }
        if (!b){
                System.out.println("La palabra no está en la lista");
                return null;
            }
        index=palabras.indexOf(palabra);
        System.out.println(index);
        if (index<0)
        return null;
        for (i=1;i<tipo.size();i=i+2){
            System.out.println(i);
            if (index>Integer.parseInt(tipo.get(i))){
                iTipo=i;
                System.out.println("iTipo: "+iTipo);
                
            }
        
    }
        
        return tipo.get(iTipo-1);
    }
}
