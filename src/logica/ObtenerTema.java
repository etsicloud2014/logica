package logica;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
/**
 *
 * @author lrodriguez054
 */
public class ObtenerTema {

    public static int BuscarPalabra(String texto, String palabraBuscada)
    {
        int posicionInicial = 0;
        int longitud = 0;
        int cantidadPalabra = 0;
        char[] cadenaPorCaracter=texto.toCharArray();

        for (int i = 0; i < texto.length(); i++)
        {
            longitud++;
            if (cadenaPorCaracter[i] == ' ' || i == texto.length() - 1)
            {
                if ( texto.substring(posicionInicial, longitud).trim().toUpperCase().equals(palabraBuscada.trim().toUpperCase()))
                {
                    cantidadPalabra++;
                }
                posicionInicial = i;
            }
        }

        return cantidadPalabra;
    }

    public static void buscarPalabraEnArchivo(String direccionArchivo, String palabraBuscada)
    {
        boolean existe = false;
        int nroLinea=0;
        int totalPalabrasEncontradas = 0;
     
        File archivo;
        FileReader leerArchivo=null;
           
        try
        {
            archivo = new File (direccionArchivo);
       
            leerArchivo = new FileReader (archivo);
            BufferedReader memoriaParaLectura = new BufferedReader(leerArchivo);
       
            String textoLinea=null;
       
      
            while((textoLinea = memoriaParaLectura.readLine())!=null)
            {
                nroLinea++;
                int cantidadPalabra = BuscarPalabra(textoLinea, palabraBuscada);
             
                if (cantidadPalabra > 0)
                {
                     //System.out.println("Cantidad de palabras: [" + cantidadPalabra + "]\n");
                     //System.out.println("En La línea: [" + nroLinea + "]\n");
                     //System.out.println("Texto de la Línea: [" + textoLinea + "]\n\n");


                    totalPalabrasEncontradas += cantidadPalabra;
                    
                   
                    existe = true;
                }
            }
            if (!existe)
            {
                //System.out.println("Palabra no encontrada\n");
            }
            else
            {
                //System.out.println("Cantidad total de palabras encontradas: [" + totalPalabrasEncontradas + "]\n");
            }
        }
        catch (Exception ex)
        {
           ex.printStackTrace();
        }
        finally
        {
            try
            {
                if (null != leerArchivo)
                {
                    leerArchivo.close();
                }
            }
            catch (Exception ex1)
            {
                ex1.printStackTrace();
            }
        }
    }
   
}
