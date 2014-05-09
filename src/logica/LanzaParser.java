package logica;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class LanzaParser {
	public static String lanzar(){
	//Proceso para lanzar una aplicacion externa y leer el resultado
	 Process proc;
	try {
		proc = Runtime.getRuntime().exec ("/home/borja/proyectos/ecloud/parseador/parse.py");
	
     // Se obtiene el stream de salida del programa
     InputStream iStream = proc.getInputStream();
     
     // Se prepara un BufferedReader para poder leer la salida más comodamente.
     BufferedReader br = new BufferedReader (new InputStreamReader (iStream));
     String cadena=br.readLine();
     System.out.println(cadena);
	 String path=Clasificador.clasificar(cadena);
	 return path;
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return null;
	}
}
}