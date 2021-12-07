package Flower;

import Xml.FlowerXmlTag;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;

/**
 * Class to get set of Flowers.
 */
public class FlowerHandler extends DefaultHandler {
    /**
     * Set of flowers which were obtained from Xml.
     */
    private Set<Flower> flowers;
    private Flower current;
    /**
     * Flower xml tag which we are at now.
     */
    private FlowerXmlTag currentXmlTag;
    private EnumSet<FlowerXmlTag> withText;
    private static final String ELEMENT_FLOWER = "Flower";

    public FlowerHandler() {
        flowers = new HashSet<>();
        withText = EnumSet.range(FlowerXmlTag.ID, FlowerXmlTag.IRRIGATION);
    }

    public Set<Flower> getFlowers() {
        return flowers;
    }

    public void startElement(String uri, String localName, String qName, Attributes attrs) {
        if (ELEMENT_FLOWER.equals(qName)) {
            current = new Flower();
            current.setSoil(Flower.Soil.valueOf(attrs.getValue(0)));
            if (attrs.getLength() == 2) {
                current.setMultiplying(Flower.Multiplying.valueOf(attrs.getValue(1)));
            }
        } else {
            FlowerXmlTag temp = FlowerXmlTag.valueOf(qName.toUpperCase());
            if (withText.contains(temp)) {
                currentXmlTag = temp;
            }
        }
    }

    public void endElement(String uri, String localName, String qName) {
        if (ELEMENT_FLOWER.equals(qName)) {
            flowers.add(current);
        }
    }

    public void characters(char[] ch, int start, int length) {
        String data = new String(ch, start, length).strip();
        if (current != null)
            current.initiateField(data, currentXmlTag);
        currentXmlTag = null;
    }
}
