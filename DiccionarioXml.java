import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


public class DiccionarioXml {
	private static List<String> palabras= new ArrayList<String>();
	private static int nTemas;
	private static int nSubTemas;
	private static List<String> temas= new ArrayList<String>();
	private static List<String> subTemas= new ArrayList<String>();
	public DiccionarioXml(String ruta){
		//Abrimos el xml donde se encuentran las palabras clave
		//con los temas y subtemas
		 try {
	            File fXmlFile = new File(ruta);
	            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	            Document doc = dBuilder.parse(fXmlFile);

	            doc.getDocumentElement().normalize();
	            //Obetenmos el nodo raiz
	            NodeList nList = doc.getElementsByTagName("temas");
	            for (int temp = 0; temp < nList.getLength(); temp++) {

	                Node nNode = nList.item(temp);
	                //Obtenemos los temas
	                NodeList nList2 =nNode.getChildNodes();
	                for(int temp2 = 0; temp2 < nList2.getLength(); temp2++){
	                	Node nNode2 = nList2.item(temp2);
	                	//Necesario para obtener el tag
	                	if (nNode2.getNodeType() == Node.ELEMENT_NODE) {
		                //Obtenemos los subtemas
	                		//separamos por % los temas
	                		palabras.add("%");
	                		nTemas++;
	                		temas.add(nNode2.getNodeName());
		                NodeList nList3 =nNode2.getChildNodes();
		                for(int temp3 = 0; temp3 < nList3.getLength(); temp3++){
		                	Node nNode3 = nList3.item(temp3);
		                	if (nNode3.getNodeType() == Node.ELEMENT_NODE) {
		                		subTemas.add(nNode3.getNodeName());
		                		//Separamos por * los subtemas
		                		palabras.add("*");
		                		nSubTemas++;
			                //Obtenemos las palabra de cada subtema
			                Element eElement = (Element) nNode3;
			                String cadena[];
			                cadena=eElement.getTextContent().trim().split(";");
			                for(int i=0;i<cadena.length;i++)
			                    palabras.add(cadena[i]);
			                
		                	}
	                	}
	                }
	                }
	                
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	}
public String[] getPalabras(){
    	
        String[] cadena=new String[palabras.size()];
        palabras.toArray(cadena);
        for (int i=0;i<palabras.size();i++){
        }
        return cadena;
    }
public int getNTemas(){
	return nTemas;
}
public int getNSubTemas(){
	return nSubTemas;
}
public String getTema(int contador){
	return temas.get(contador);
}
public String getSubTema(int contador){
	return subTemas.get(contador);
}
}
