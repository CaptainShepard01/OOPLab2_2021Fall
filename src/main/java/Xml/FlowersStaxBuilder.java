package Xml;

import Flower.Flower;

import javax.xml.stream.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class FlowersStaxBuilder extends AbstractFlowersBuilder{
    /**
     * Set of flowers which were obtained from Xml.
     */
    private Set<Flower> flowers;
    private XMLInputFactory inputFactory;

    public FlowersStaxBuilder() {
        inputFactory = XMLInputFactory.newInstance();
        flowers = new HashSet<Flower>();
    }

    public Set<Flower> getFlowers() {
        return flowers;
    }

    /**
     * Method that builds the set based on the data from Xml document.
     * @param filename Name of Xml file containing data.
     */
    @Override
    public void buildSetFlowers(String filename) {
        XMLStreamReader reader;
        String name;
        try (FileInputStream inputStream = new FileInputStream(new File(filename))) {
            reader = inputFactory.createXMLStreamReader(inputStream);
            // StAX parsing
            while (reader.hasNext()) {
                int type = reader.next();
                if (type == XMLStreamConstants.START_ELEMENT) {
                    name = reader.getLocalName();
                    if (name.equals(FlowerXmlTag.FLOWER.getValue())) {
                        Flower flower = buildFlower(reader);
                        flowers.add(flower);
                    }
                }
            }
        } catch (XMLStreamException | IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Method to build single Flower from xml stream reader data.
     * @param reader xml stream reader.
     * @return Flower object.
     * @throws XMLStreamException
     */
    private Flower buildFlower(XMLStreamReader reader)
            throws XMLStreamException {
        Flower flower = new Flower();
        flower.setSoil(Flower.Soil.valueOf(reader.getAttributeValue(null, FlowerXmlTag.SOIL.getValue())));

        flower.setMultiplying(Flower.Multiplying.valueOf(reader.getAttributeValue(null,
                FlowerXmlTag.MULTIPLYING.getValue())));
        String name;
        while (reader.hasNext()) {
            int type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT -> {
                    name = reader.getLocalName();
                    switch (FlowerXmlTag.valueOf(name.toUpperCase())) {
                        case VISUAL_PARAMETERS -> flower.setVisualParameters(getXMLVisualParameters(reader));
                        case GROWING_TIPS -> flower.setGrowingTips(getXMLGrowingTips(reader));
                        default -> flower.initiateField(getXMLText(reader), FlowerXmlTag.valueOf(name.toUpperCase()));
                    }
                }
                case XMLStreamConstants.END_ELEMENT -> {
                    name = reader.getLocalName();
                    if (FlowerXmlTag.valueOf(name.toUpperCase()) == FlowerXmlTag.FLOWER) {
                        return flower;
                    }
                }
            }
        }
        throw new XMLStreamException("Unknown element in tag <flower>");
    }

    /**
     * Method to get visual parameters of single Flower.
     * @param reader xml stream reader.
     * @return Visual parameters of the Flower.
     * @throws XMLStreamException
     */
    private Flower.VisualParameters getXMLVisualParameters(XMLStreamReader reader)
            throws XMLStreamException {
        Flower flower = new Flower();
        int type;
        String name;
        while (reader.hasNext()) {
            type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    name = reader.getLocalName();
                    flower.initiateField(getXMLText(reader), FlowerXmlTag.valueOf(name.toUpperCase()));
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    name = reader.getLocalName();
                    if (FlowerXmlTag.valueOf(name.toUpperCase()) == FlowerXmlTag.VISUAL_PARAMETERS) {
                        return flower.getVisualParameters();
                    }
            }
        }
        throw new XMLStreamException("Unknown element in tag <visual_parameters>");
    }

    /**
     * Method to get growing tips for a single Flower.
     * @param reader xml stream reader.
     * @return Growing tips for the Flower.
     * @throws XMLStreamException
     */
    private Flower.GrowingTips getXMLGrowingTips(XMLStreamReader reader)
            throws XMLStreamException {
        Flower flower = new Flower();
        int type;
        String name;
        while (reader.hasNext()) {
            type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    name = reader.getLocalName();
                    flower.initiateField(getXMLText(reader), FlowerXmlTag.valueOf(name.toUpperCase()));
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    name = reader.getLocalName();
                    if (FlowerXmlTag.valueOf(name.toUpperCase()) == FlowerXmlTag.GROWING_TIPS) {
                        return flower.getGrowingTips();
                    }
            }
        }
        throw new XMLStreamException("Unknown element in tag <groving_tips>");
    }

    /**
     * Method to get xml text from xml stream reader.
     * @param reader xml stream reader.
     * @return String (xml text).
     * @throws XMLStreamException
     */
    private String getXMLText(XMLStreamReader reader) throws XMLStreamException {
        String text = null;
        if (reader.hasNext()) {
            reader.next();
            text = reader.getText();
        }
        return text;
    }
}
