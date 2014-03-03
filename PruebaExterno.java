/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pruebaexterno;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

/**
 *
 * @author alumno
 */
public class PruebaExterno {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        Diccionario dic = new Diccionario("/home/alumno/palabras.txt");
         Process p = Runtime.getRuntime().exec ("/home/alumno/pruueba.sh"); 
         /* Se obtiene el stream de salida del programa */
        InputStream is = p.getInputStream();
            
        /* Se prepara un BufferedReader para poder leer la salida más comodamente. */
        BufferedReader br = new BufferedReader (new InputStreamReader (is)); 
        String cadena=br.readLine();
        while(cadena!=null){
        System.out.println(cadena);
        cadena=br.readLine();
        
        }
        System.out.println(AbrirXml.open("/home/alumno/nuevo_fich_parseado.xml")[1]);
        String [] palabras =dic.getPalabras();
        List<String> temas =dic.getTemas();
        for (String palabra : palabras) {
            System.out.println(palabra);
        }
        for (String tema : temas){
            System.out.println(tema);
        }
        String texto=AbrirXml.open("/home/alumno/nuevo_fich_parseado.xml")[0];
        String delimitadores= "[ .,;?!¡¿\'\"\\[\\]]+";
        String[] palabrasSeparadas = texto.split(delimitadores);
        for (String palabrasSeparada : palabrasSeparadas) {
            System.out.println(palabrasSeparada);
            if (palabras.equals(palabrasSeparada)){
                dic.getTipo(palabrasSeparada);
                //TODO comprobar que el tema esta y si esta aumentar contadores
            }
        }
        
    }
    
}
