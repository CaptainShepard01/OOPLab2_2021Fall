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
    private Set<Flower> flowers;
    private XMLInputFactory inputFactory;

    public FlowersStaxBuilder() {
        inputFactory = XMLInputFactory.newInstance();
        flowers = new HashSet<Flower>();
    }

    public Set<Flower> getFlowers() {
        return flowers;
    }

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
        } catch (XMLStreamException | FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

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

    private String getXMLText(XMLStreamReader reader) throws XMLStreamException {
        String text = null;
        if (reader.hasNext()) {
            reader.next();
            text = reader.getText();
        }
        return text;
    }

    /*public void buildSetFlowers(String fileName) {
        Flower.Flower flower = null;
        XMLInputFactory inputFactory = XMLInputFactory.newInstance();
        try {
            XMLEventReader reader = inputFactory.createXMLEventReader(
                    new FileInputStream(fileName));
            while (reader.hasNext()) {
                XMLEvent event = reader.nextEvent();
                if (event.isStartElement()) {
                    StartElement startElement = event.asStartElement();
                    if (startElement.getName().getLocalPart().equals("flower")) {
                        flower = new Flower.Flower();
                        Attribute soil = startElement.getAttributeByName(new QName("soil"));
                        if (soil != null) {
                            flower.setSoil(Flower.Flower.Soil.valueOf(soil.getValue()));
                        }

                        Attribute multiplying = startElement.getAttributeByName(new QName("multiplying"));
                        if (multiplying != null) {
                            flower.setMultiplying(Flower.Flower.Multiplying.valueOf(multiplying.getValue()));
                        }
                    } else if (startElement.getName().getLocalPart().equals("visual_parameters")) {
                        event = reader.nextEvent();
                        StartElement startElement1 = event.asStartElement();
                        if(startElement1.getName().getLocalPart().equals("stalk_color")){
                            event = reader.nextEvent();
                            flower.getVisualParameters().setStalkColor(Flower.Flower.VisualParameters.Color.valueOf(String.valueOf(event.asCharacters().getData())));
                        }
                        else if(startElement1.getName().getLocalPart().equals("leaf_color")){
                            event = reader.nextEvent();
                            flower.getVisualParameters().setLeafColor(Flower.Flower.VisualParameters.Color.valueOf(String.valueOf(event.asCharacters().getData())));
                        }
                        else if(startElement1.getName().getLocalPart().equals("average_size")){
                            event = reader.nextEvent();
                            flower.getVisualParameters().setAverageSize(Flower.Flower.VisualParameters.Size.valueOf(String.valueOf(event.asCharacters().getData())));
                        }
                    } else if (startElement.getName().getLocalPart().equals("growing_tips")) {
                        event = reader.nextEvent();
                        StartElement startElement1 = event.asStartElement();
                        if(startElement1.getName().getLocalPart().equals("temperature")){
                            event = reader.nextEvent();
                            flower.getGrowingTips().setTemperature(Float.parseFloat(String.valueOf(event.asCharacters())));
                        }
                        else if(startElement1.getName().getLocalPart().equals("lighting")){
                            event = reader.nextEvent();
                            flower.getGrowingTips().setLighting(Boolean.parseBoolean(String.valueOf(event.asCharacters())));
                        }
                        else if(startElement1.getName().getLocalPart().equals("irrigation")){
                            event = reader.nextEvent();
                            flower.getGrowingTips().setIrrigation(Float.parseFloat(String.valueOf(event.asCharacters())));
                        }
                    }
                }
                if (event.isEndElement()) {
                    EndElement endElement = event.asEndElement();
                    if (endElement.getName().getLocalPart().equals("flower")) {
                        flowers.add(flower);
                    }
                }
            }
        } catch (FileNotFoundException | XMLStreamException e) {
            e.printStackTrace();
        }
    }*/
}
