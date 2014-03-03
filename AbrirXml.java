/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pruebaexterno;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
/**
 *
 * @author alumno
 */
public class AbrirXml {
    
    public AbrirXml(){
        
    }
    public AbrirXml(boolean debug){
        if (debug==true){
            dbg=true;
        }
        
    }
    private static boolean dbg=false;
  public static String[] open(String path){
 /**
         *Devuelve el campo text del fichero parseado
         */
    try {
	File fXmlFile = new File(path);
	DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	Document doc = dBuilder.parse(fXmlFile);
 
	
	doc.getDocumentElement().normalize();
 
 
	NodeList nList = doc.getElementsByTagName("nodos");
 
 
	for (int temp = 0; temp < nList.getLength(); temp++) {
 
		Node nNode = nList.item(temp);
 
 
		if (nNode.getNodeType() == Node.ELEMENT_NODE) {
 
			Element eElement = (Element) nNode;
 
                        if (dbg==true)
			System.out.println("Texto : " + eElement.getElementsByTagName("text").item(0).getTextContent());
                      String [] items= new String[2]; 
                      items[0]=eElement.getElementsByTagName("text").item(0).getTextContent();
                      items[1]=eElement.getElementsByTagName("title").item(0).getTextContent();

                    return items;
                
		}
	}
    } catch (Exception e) {
	e.printStackTrace();
    }
        return null;
  }
}
