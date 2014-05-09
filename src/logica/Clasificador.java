package logica;

import java.util.ArrayList;




public class Clasificador {
	
    public static String clasificar(String path){
		DiccionarioXml dic = new DiccionarioXml("/home/borja/proyectos/ecloud/logica/palabras.xml");
	    String palabras[]=dic.getPalabras();
	    /*for(String palabra:palabras)
	    	System.out.println(palabra);
	    	*/
	    ArrayList<Integer> contadoresTema= new ArrayList<Integer>();
	    ArrayList<Integer> contadoresSubTema= new ArrayList<Integer>();
	 for(int i=0;i<dic.getNTemas();i++){
		 contadoresTema.add(0);
	 }
	 for(int i=0;i<dic.getNSubTemas();i++){
		 contadoresSubTema.add(0);
	 }
	 //Obtenemos el texto del docuemtno
	 int marcadorTema=-1,marcadorSubTema=-1;
	 int cantidad;
	
	 String texto=AbrirXml.open(path)[0];
	 for(String palabra:palabras){
		 
		 if(palabra.equals("%"))
			 marcadorTema++;
	
		 else if (palabra.equals("*"))
			 marcadorSubTema++;
		 else{
			 cantidad=ObtenerTema.BuscarPalabra(texto, palabra);
			 contadoresTema.set(marcadorTema, contadoresTema.get(marcadorTema)+cantidad);
			 contadoresSubTema.set(marcadorSubTema, contadoresSubTema.get(marcadorSubTema)+cantidad);
	
		 }
		 
	 }
	 int posicion=0;
	 int mayor=0;
	 for(int i=0;i<contadoresTema.size();i++){
		 
		 
		 if (contadoresTema.get(i)>mayor){
			 mayor=contadoresTema.get(i);
			 posicion=i;
		 }
	 }
	 String tema=dic.getTema(posicion);
	 posicion=0;
	 mayor=0;
	 for(int i=0;i<contadoresSubTema.size();i++){
		
		 
		 if (contadoresSubTema.get(i)>mayor){
			 mayor=contadoresSubTema.get(i);
			 posicion=i;
			 
		 }
		
		 
	 }
	 String subTema=dic.getSubTema(posicion);
	 //System.out.println("El tema es: "+tema+" y el subtema: "+subTema);
	 AbrirXml.saveKind(path, tema);
	 AbrirXml.saveSubKind(path, subTema);
	 return path;
    }
}
