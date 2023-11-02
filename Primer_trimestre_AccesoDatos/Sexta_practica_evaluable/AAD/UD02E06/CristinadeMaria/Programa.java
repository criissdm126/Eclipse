package AAD.UD02E06.CristinadeMaria;

import java.io.*;
import java.util.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.*;
import org.xml.sax.*;

public class Programa {

    public static void main(String[] args) {
    	
        try {
            // Crear una estructura intermedia para almacenar los objetos Coche
            Collection<Coche> coches = new ArrayList<>();

            // Cargar el archivo XML (concesionario.xml) y parsearlo usando DOM
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse("concesionario.xml");

            // Recuperar la lista de nodos de coche del documento XML
            NodeList cocheNodes = document.getElementsByTagName("coche");

            for (int i = 0; i < cocheNodes.getLength(); i++) {
                Element cocheElement = (Element) cocheNodes.item(i);
                Integer id = Integer.parseInt(cocheElement.getAttribute("id"));
                String marca = cocheElement.getAttribute("marca");
                String modelo = cocheElement.getAttribute("modelo");

                // Validar y convertir el precio
                String precioStr = cocheElement.getAttribute("precio");
                Float precio = null;
                // int precio2 = (int) precio;
                if (precioStr != null && !precioStr.isEmpty()) {
                    try {
                    	precio = Float.parseFloat(precioStr);
                    } catch (NumberFormatException e) {
                        // Handle the case where "precio" is not a valid number
                        // You can log an error or take appropriate action
                        e.printStackTrace();
                    }
                }
                Coche coche = new Coche(id, marca, modelo, precio);
                coches.add(coche);
            }

            // Volcar la colección de coches en un archivo de texto (listaCoches.txt)
            FileWriter writer = new FileWriter("listaCoches.txt");

            writer.write("Id#Marca#Modelo#Precio\n");

            for (Coche coche : coches) {
                writer.write(coche.getId() + "#" + coche.getMarca() + "#" + coche.getModelo() + "#" + coche.getPrecio() + "\n");
                if (coche.getPrecio() != null) {
                    int precioAsInt = (int) coche.getPrecio();
                    writer.write(String.valueOf(precioAsInt));
                }

                writer.write("\n");
            }

            writer.close();

            // Calcular el número de coches y el valor total
            int numCoches = coches.size();
            double valorTotal = coches.stream().filter(Objects::nonNull).mapToDouble(Coche::getPrecio).sum();

            System.out.println("El concesionario dispone de " + numCoches + " coches con un valor total de " + valorTotal + " €");

            // Crear un nuevo documento DOM y almacenar los coches en un archivo XML (coches.xml)
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document cochesDoc = docBuilder.newDocument();

            Element rootElement = cochesDoc.createElement("coches");
            cochesDoc.appendChild(rootElement);

            for (Coche coche : coches) {
                Element cocheElement = cochesDoc.createElement("coche");
                cocheElement.setAttribute("id", String.valueOf(coche.getId()));
                cocheElement.setAttribute("marca", coche.getMarca());
                cocheElement.setAttribute("modelo", coche.getModelo());
                cocheElement.setAttribute("precio", String.valueOf(coche.getPrecio()));
                rootElement.appendChild(cocheElement);
            }

            // Volcar el documento a un archivo XML (coches.xml)
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(cochesDoc);
            StreamResult result = new StreamResult(new FileWriter("coches.xml"));
            transformer.transform(source, result);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
