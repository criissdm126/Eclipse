package AAD.UD02E06.CristinadeMaria;


import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.util.ArrayList;
import java.util.List;

public class XML {
	
    private Document document;

    public XML(String xmlFilePath) throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        document = builder.parse(xmlFilePath);
    }

    public List<Coche> getCoches() {
        List<Coche> coches = new ArrayList<>();
        NodeList cocheNodes = document.getElementsByTagName("coche");

        for (int i = 0; i < cocheNodes.getLength(); i++) {
            Element cocheElement = (Element) cocheNodes.item(i);
            Integer id = Integer.parseInt(cocheElement.getAttribute("id"));
            String marca = cocheElement.getAttribute("marca");
            String modelo = cocheElement.getAttribute("modelo");
            Float precio = Float.parseFloat(cocheElement.getAttribute("precio"));

            Coche coche = new Coche(id, marca, modelo, precio);
            coches.add(coche);
        }

        return coches;
    }
}






