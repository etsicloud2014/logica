/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import org.xml.sax.SAXException;

/**
 *
 * @author alumno
 */
public class PruebaExterno {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException, TransformerException {
        
            //Creamos un objeto Diccionario y le pasamos el archivo de las palabras
            Diccionario dic = new Diccionario("/home/alumno/palabras.txt");
            /*
            Proceso para lanzar una aplicacion externa y leer el resultado
            Process p = Runtime.getRuntime().exec ("/home/alumno/pruueba.sh");
            // Se obtiene el stream de salida del programa
            InputStream is = p.getInputStream();
            
            // Se prepara un BufferedReader para poder leer la salida más comodamente.
            BufferedReader br = new BufferedReader (new InputStreamReader (is));
            String cadena=br.readLine();
            while(cadena!=null){
            System.out.println(cadena);
            cadena=br.readLine();
            
            }
            */           
            //Printamos el titulo del fichero
            //System.out.println(AbrirXml.open("/home/alumno/nuevo_fich_parseado.xml")[1]);
            //Obtenemos la lista de plabaras clave
            String [] palabras =dic.getPalabras();
            //Creamos una lista con los temas: en las posiciones pares
            //estan los temas, y en las impares los contadores inicializados en 0
            List<String> temas =dic.getTemas();
            //Obtenemos el texto del docuemtno
            String texto=AbrirXml.open("/home/alumno/nuevo_fich_parseado.xml")[0];
            //Quitamos los saltos de linea
            texto = texto.replaceAll("[\n\r]","");
            
            
            System.out.println(ObtenerTema.BuscarPalabra(texto, "beca"));
            
            
            
            
            
            
            
            //Separamos todas las palabras
            /*Parte de obtenr tema palabra por palabra
            String delimitadores= "[ .,;?!¡¿\'\"\\[\\]]+";
            String[] palabrasSeparadas = texto.split(delimitadores);
            //Comprobamos si cada palabra es clave, si lo es, obetenemos el tema
            //y aumentamos el contador de ese tema
            for (String palabrasSeparada : palabrasSeparadas) {
                for (String palabra : palabras){
                    if (palabra.equalsIgnoreCase(palabrasSeparada)){
                        int indice;
                        int aux;
                        //Indice es la posición en la que se enceuntra el contador del tema
                        indice=temas.indexOf(dic.getTipo(palabrasSeparada))+1;
                        aux=Integer.parseInt(temas.get(indice))+1;
                        //Aumentamos el contador
                        temas.set(indice, Integer.toString(aux));
                    }
                    
                }
            }
            int ContadorTema=1;
            for (int i=1;i<temas.size();i=i+2){
            	if(Integer.parseInt(temas.get(i))>Integer.parseInt(temas.get(ContadorTema))){
            		ContadorTema=i;
            	}
            }
            
            AbrirXml.saveKind("/home/alumno/nuevo_fich_parseado.xml", temas.get(ContadorTema-1));
            */

    }
    
}
