/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.xml.sax.SAXException;

/**
 *
 * @author alumno
 */
public class AbrirXml {

    public AbrirXml() {

    }

    public AbrirXml(boolean debug) {
        if (debug == true) {
            dbg = true;
        }

    }
    private static boolean dbg = false;

    public static String[] open(String path) {
        /**
         * Devuelve campos del fichero parseado: En la posicion 0 el texto. En
         * la 1 en título.
         *
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
                    //If de debugeo
                    if (dbg == true) {
                        System.out.println("Texto : " + eElement.getElementsByTagName("text").item(0).getTextContent());
                    }
                    String[] items = new String[2];
                    items[0] = eElement.getElementsByTagName("text").item(0).getTextContent();
                    items[1] = eElement.getElementsByTagName("title").item(0).getTextContent();
                    return items;

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static int saveKind(String path, String tema) {
        //Abre el documento XML con la información parseado, y guarda el tema 
        //en el campo correspondiente
        
        //Abrimos el fichero y creamos la estructura XML
        File fXmlFile = new File(path);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);

            doc.getDocumentElement().normalize();
            //Buscamos el campo nodos
            NodeList nList = doc.getElementsByTagName("nodos");

            for (int temp = 0; temp < nList.getLength(); temp++) {

                Node nNode = nList.item(temp);

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                    Element eElement = (Element) nNode;
                    //Obtenemos el nodo kind que correspone al tema. En el escribimos el tema
                    eElement.getElementsByTagName("kind").item(0).setTextContent(tema);
                }
                // Escritura del fichero
                TransformerFactory transformerFactory = TransformerFactory.newInstance();
                Transformer transformer = transformerFactory.newTransformer();
                DOMSource source = new DOMSource(doc);
                StreamResult result = new StreamResult(new File(path));
                transformer.transform(source, result);
            }

        } catch (Exception e) {

            e.printStackTrace();
            return 1;

        }
        return 0;
    }
}
