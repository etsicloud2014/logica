    /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.*;
import java.util.ArrayList;
import java.util.List;
/**
*
* @author borja
*/
public class Diccionario {
	//Lista del tipo de palabras: en las posiciones pares (empezando por 0)
	//Se encuentran los temas, y en los impares el lugar en la lista de palabras
	//donde empieza ese tema
      private static List<String> tipo = new ArrayList<String>();
      //Lista de todas las palabras clave
      private static List<String> palabras= new ArrayList<String>();
    public Diccionario(String ruta){
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
            if(i==0){
                tipo.add(linea);
                i++;
                
             
         }
            else{
                cadena=linea.split(";");
                tipo.add(lastIndex.toString());
                lastIndex+=cadena.length;
                for(i=0;i<cadena.length;i++)
                    palabras.add(cadena[i]);
                i=0;
            }
         }


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
    	
        String[] cadena=new String[palabras.size()];
        palabras.toArray(cadena);
        for (int i=0;i<palabras.size();i++){
        }
        return cadena;
    }
    public List<String> getTemas(){
    	
        List<String> aux = new ArrayList<String>();
        String[] cadena =new String[tipo.size()];

        aux.addAll(tipo);
        for (int i=1;i<aux.size();i=i+2){
            aux.set(i, "0");
        }
        aux.toArray(cadena);

        return aux;
    }
    
    
    public String getTipo(String palabra){

    	
    	//Devuelve el tema al que pertenece palabra
        int i,index, iTipo=1;
        boolean b=false;
        //Comprobaos que la palabra si que esta en la lista de palabras
        for (i=0;i<palabras.size();i++){
            if (palabra.equalsIgnoreCase(palabras.get(i))){
                b=true;
            }
            
                
            
        }
        if (!b){
                System.out.println("La palabra no está en la lista");
                return null;
            }
        index=palabras.indexOf(palabra);
        if (index<0)
        return null;
        for (i=1;i<tipo.size();i=i+2){
            if (index>Integer.parseInt(tipo.get(i))){
                iTipo=i;
                
            }
            
    }
        return tipo.get(iTipo-1);
    }
}
