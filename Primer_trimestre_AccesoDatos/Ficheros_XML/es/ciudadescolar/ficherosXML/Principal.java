package es.ciudadescolar.ficherosXML;


import java.io.*;
import java.util.*;
import org.w3c.dom.*;
import javax.xml.parsers.*;
import org.xml.sax.*;

public class Principal {

	public static void main(String[] args) {
		
		List<Alumno> alumnos = null;
		File ficheroXml = new File("alumnos.xml");
		try {
			alumnos = analizarDOM(ficheroXml);
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		for(Alumno a1:alumnos) {
			System.out.println(a1);
		}

	}
	
	// MÉTODO PARA ANALIZAR
	private static List<Alumno> analizarDOM (File file) throws ParserConfigurationException, SAXException, IOException {
		
		List<Alumno> alumnos = new ArrayList<Alumno>();
		
		Alumno a1 = null;
		
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		dbf.setValidating(true); // se valida con el dtd
		dbf.setIgnoringElementContentWhitespace(true); // eliminar espacios en blanco
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document document = db.parse(file); // sera una estructura en memoria que representa el documento xml
		
		Element raiz = document.getDocumentElement(); // recuperar el elemento raiz que es alumnos		
		NodeList nodosalumnos = raiz.getChildNodes(); // lista de nodos "Alumno" bajo el nodo raíz
		
		for(int i=0; i<nodosalumnos.getLength(); i++) {
			Element elementalumno = (Element) nodosalumnos.item(i);
			
			 a1 = new Alumno();
			a1.setExpediente(elementalumno.getFirstChild().getNodeValue());
			a1.setNombre(elementalumno.getFirstChild().getNextSibling().getTextContent());
			a1.setEdad(Integer.parseInt(elementalumno.getLastChild().getTextContent()));
			
			alumnos.add(a1);
			
			/*
			// EXPEDIENTE
			// OPCIÓN 1
			System.out.println("expediente: " + elementalumno.getFirstChild().getNodeValue());
			
			// OPCIÓN 2
			// System.out.println("expediente: " + elementalumno.getFirstChild().getTextContent());
			
			// NOMBRE
			// OPCIÓN 1
			System.out.println("nombre: " + elementalumno.getFirstChild().getNextSibling().getNodeValue());
			
			// OPCION 2
			System.out.println("nombre: " + elementalumno.getFirstChild().getNextSibling().getTextContent());
			
			// EDAD
			// OPCIÓN 1
			System.out.println("edad: " + elementalumno.getLastChild().getFirstChild().getNodeValue());
			
			// OPCION 2
			System.out.println("edad: " + elementalumno.getLastChild().getTextContent());
			
			// OPCION 3
			System.out.println("edad: " + elementalumno.getLastChild().getPreviousSibling().getFirstChild().getNodeValue());
			*/
		}
		
		return alumnos;
	}

}

