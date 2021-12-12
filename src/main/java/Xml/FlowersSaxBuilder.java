package Xml;

import Flower.Flower;
import Flower.FlowerErrorHandler;
import Flower.FlowerHandler;
import org.xml.sax.XMLReader;
import org.xml.sax.SAXException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.Set;

public class FlowersSaxBuilder extends AbstractFlowersBuilder{
    /**
     * Set of flowers which were obtained from Xml.
     */
    private Set<Flower> flowers;
    private FlowerHandler handler;
    private XMLReader reader;

    public FlowersSaxBuilder(){
        handler = new FlowerHandler();
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = factory.newSAXParser();
            reader = saxParser.getXMLReader();
            reader.setErrorHandler(new FlowerErrorHandler());
            reader.setContentHandler(handler);
        } catch (ParserConfigurationException | SAXException e) {
            e.printStackTrace(); // log
        }
    }

    /**
     * Method obtaining all the Flowers as Set.
     * @return Set of Flowers.
     */
    public Set<Flower> getFlowers() {
        return flowers;
    }

    /**
     * Method that builds the set based on the data from Xml document.
     * @param filename Name of Xml file containing data.
     */
    @Override
    public void buildSetFlowers(String filename) {
        try {
            reader.parse(filename);
            flowers = handler.getFlowers();
        } catch (IOException | SAXException e) {
            e.printStackTrace();
        }
    }
}
