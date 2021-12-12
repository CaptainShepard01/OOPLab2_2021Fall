package Xml;

import Flower.Flower;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class FlowersDomBuilder extends FlowersSaxBuilder {
    /**
     * Set of flowers which were obtained from Xml.
     */
    private Set<Flower> flowers;
    private DocumentBuilder docBuilder;

    public FlowersDomBuilder() {
        flowers = new HashSet<>();
        // configuration
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            docBuilder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
    }

    public Set<Flower> getFlowers() {
        return flowers;
    }

    /**
     * Method that builds the set based on the data from Xml document.
     *
     * @param filename Name of Xml file containing data.
     */
    @Override
    public void buildSetFlowers(String filename) {
        Document doc;
        try {
            doc = docBuilder.parse(filename);
            Element root = doc.getDocumentElement();
            // getting a list of <student> child elements
            NodeList flowersList = root.getElementsByTagName("Flower");
            for (int i = 0; i < flowersList.getLength(); i++) {
                Element flowerElement = (Element) flowersList.item(i);
                Flower flower = buildFlower(flowerElement);
                flowers.add(flower);
            }
        } catch (IOException | SAXException e) {
            e.printStackTrace();
        }
    }

    /**
     * Method to build single Flower from data of Flower Element.
     *
     * @param flowerElement One of Flower elements.
     * @return Flower object.
     */
    private Flower buildFlower(Element flowerElement) {
        return new Flower(flowerElement);
    }

    /**
     * @param element     Element form xml containing data.
     * @param elementName Name of element.
     * @return String which is a content of element.
     */
    public static String getElementTextContent(Element element, String elementName) {
        NodeList nList = element.getElementsByTagName(elementName);
        Node node = nList.item(0);
        String text = node.getTextContent();
        return text;
    }
}
