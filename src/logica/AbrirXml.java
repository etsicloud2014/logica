package logica;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;

import model.Noticia;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.xml.sax.SAXException;

import Interfaz.NoticiaBean;

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
         * la 1 en título. En el 2 el tip. EN el 3 la fech. En el 4 la fuente. En 
         * el 5 el subtema
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
                    String[] items = new String[6];
                    items[0] = eElement.getElementsByTagName("text").item(0).getTextContent();
                    items[1] = eElement.getElementsByTagName("title").item(0).getTextContent();
                    items[2] = eElement.getElementsByTagName("kind").item(0).getTextContent();
                    items[3] = eElement.getElementsByTagName("date").item(0).getTextContent();
                    items[4] = eElement.getElementsByTagName("source").item(0).getTextContent();
                    Node nodoMeta=eElement.getElementsByTagName("meta").item(0);
                    Element metaElement = (Element) nodoMeta;
                    items[5]=metaElement.getElementsByTagName("subkind").item(0).getTextContent();
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
    public static int saveSubKind(String path, String subTema) {
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
                    NodeList listaMeta=eElement.getElementsByTagName("meta");
                    Node nodoMeta=listaMeta.item(0);
                    Element metaElement = (Element) nodoMeta;
                    metaElement.getElementsByTagName("subkind").item(0).setTextContent(subTema);
                  
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
    public static void save(NoticiaBean nb){
		Date d=new Date();
		File fXmlFile = new File("/home/borja/Dropbox/Uni/Servicios telematicos avanzados/workspace2014/Ecloud/src/logica/plantilla.xml");
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
                    eElement.getElementsByTagName("kind").item(0).setTextContent(nb.getTema());
                    eElement.getElementsByTagName("title").item(0).setTextContent(nb.getTitulo());
                    eElement.getElementsByTagName("source").item(0).setTextContent("user");
                    eElement.getElementsByTagName("date").item(0).setTextContent(d.toString());
                    eElement.getElementsByTagName("text").item(0).setTextContent(nb.getTexto());
                }
                // Escritura del fichero
                TransformerFactory transformerFactory = TransformerFactory.newInstance();
                Transformer transformer = transformerFactory.newTransformer();
                DOMSource source = new DOMSource(doc);
                StreamResult result = new StreamResult(new File("/home/borja/proyectos/ecloud/noticias/"+nb.getTitulo()+"_parseado.xml"));
                transformer.transform(source, result);
                AbrirXml.saveSubKind("/home/borja/proyectos/noticias/"+nb.getTitulo()+"_parseado.xml", nb.getSubTema());

                
            }

        } catch (Exception e) {

            e.printStackTrace();


        }

	}
}
