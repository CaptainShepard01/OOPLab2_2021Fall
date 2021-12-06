package Flower;

import Xml.FlowerXmlTag;

import java.util.Comparator;
import java.util.Objects;
import java.util.concurrent.Flow;

public class Flower implements Comparable<Flower>{
    private String id;
    private String name;
    private Soil soil;
    private String origin;
    private VisualParameters visualParameters = new VisualParameters();
    private GrowingTips growingTips = new GrowingTips();
    private Multiplying multiplying;

    public Flower() {
    }

    public Flower(String id, String name, Soil soil, String origin, VisualParameters visualParameters, Multiplying multiplying) {
        this.id = id;
        this.name = name;
        this.soil = soil;
        this.origin = origin;
        this.visualParameters = visualParameters;
        this.multiplying = multiplying;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Soil getSoil() {
        return soil;
    }

    public String getOrigin() {
        return origin;
    }

    public VisualParameters getVisualParameters() {
        return visualParameters;
    }

    public GrowingTips getGrowingTips() {
        return growingTips;
    }

    public Multiplying getMultiplying() {
        return multiplying;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSoil(Soil soil) {
        this.soil = soil;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public void setVisualParameters(VisualParameters visualParameters) {
        this.visualParameters = visualParameters;
    }

    public void setGrowingTips(GrowingTips growingTips) {
        this.growingTips = growingTips;
    }

    public void setMultiplying(Multiplying multiplying) {
        this.multiplying = multiplying;
    }

    @Override
    public int compareTo(Flower o) {
        return id.compareTo(o.id);
    }

    public class GrowingTips {
        private float temperature;
        private boolean lighting;
        private float irrigation;

        public GrowingTips() {
        }

        public GrowingTips(float temperature, boolean lighting, float irrigation) {
            this.temperature = temperature;
            this.lighting = lighting;
            this.irrigation = irrigation;
        }

        public float getTemperature() {
            return temperature;
        }

        public boolean isLighting() {
            return lighting;
        }

        public float getIrrigation() {
            return irrigation;
        }

        public void setTemperature(float temperature) {
            this.temperature = temperature;
        }

        public void setLighting(boolean lighting) {
            this.lighting = lighting;
        }

        public void setIrrigation(float irrigation) {
            this.irrigation = irrigation;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }

            if (!(obj instanceof GrowingTips anotherGrowingTips)) {
                return false;
            }

            return temperature == anotherGrowingTips.temperature && lighting == anotherGrowingTips.lighting && irrigation == anotherGrowingTips.irrigation;
        }

        public String toString(){
            final StringBuilder sb = new StringBuilder("\nGroving tips:\n\tTemperature: ");
            sb.append(temperature).append("\n\tLight: ").append(lighting);
            sb.append("\n\tIrrigation: ").append(irrigation).append('\n');
            return sb.toString();
        }
    }

    public class VisualParameters{
        private Color stalkColor;
        private Color leafColor;
        private Size averageSize;

        public VisualParameters() {
        }

        public VisualParameters(Color stalkColor, Color leafColor, Size averageSize) {
            this.stalkColor = stalkColor;
            this.leafColor = leafColor;
            this.averageSize = averageSize;
        }

        public Color getStalkColor() {
            return stalkColor;
        }

        public Color getLeafColor() {
            return leafColor;
        }

        public Size getAverageSize() {
            return averageSize;
        }

        public void setStalkColor(Color stalkColor) {
            this.stalkColor = stalkColor;
        }

        public void setLeafColor(Color leafColor) {
            this.leafColor = leafColor;
        }

        public void setAverageSize(Size averageSize) {
            this.averageSize = averageSize;
        }

        public String toString(){
            final StringBuilder sb = new StringBuilder("\nVisual parameters:\n\tStalk color: ");
            sb.append(stalkColor).append("\n\tLeaf color: ").append(leafColor);
            sb.append("\n\tAverage size: ").append(averageSize).append('\n');
            return sb.toString();
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }

            if (!(obj instanceof VisualParameters anotherVisualParameters)) {
                return false;
            }

            return stalkColor.equals(anotherVisualParameters.stalkColor) && leafColor.equals(anotherVisualParameters.leafColor) && averageSize.equals(anotherVisualParameters.averageSize);
        }

        public enum Color{
            RED,
            GREEN,
            YELLOW,
            BLUE
        }

        public enum Size{
            BIG,
            MEDIUM,
            SMALL
        }
    }

    public String toString(){
        final StringBuilder sb = new StringBuilder("\nId: ");
        sb.append(id).append("\nName: ");
        sb.append(name).append("\nSoil: ").append(soil);
        sb.append("\nMultiplying: ").append(multiplying);
        sb.append("\nOrigin: ").append(origin).append(visualParameters).append(growingTips);
        sb.append('\n');
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (!(obj instanceof Flower anotherFlower)) {
            return false;
        }

        return id.equals(anotherFlower.id) && name.equals(anotherFlower.name) && soil.equals(anotherFlower.soil) && origin.equals(anotherFlower.origin) && visualParameters.equals(anotherFlower.visualParameters) && growingTips.equals(anotherFlower.growingTips) && multiplying.equals(anotherFlower.multiplying);
    }

    public enum Soil{
        PODSOL,
        GROUND,
        TURF_PODSOL
    }

    public enum Multiplying{
        LEAF,
        STEM,
        SEMEN
    }

    public void initiateField(String value, FlowerXmlTag currentXmlTag){
        if(currentXmlTag!=null) {
            switch (currentXmlTag) {
                case ID -> setId(value);
                case NAME -> setName(value);
                case ORIGIN -> setOrigin(value);
                case LIGHTING -> getGrowingTips().setLighting(Boolean.parseBoolean(value));
                case TEMPERATURE -> getGrowingTips().setTemperature(Float.parseFloat(value));
                case IRRIGATION -> getGrowingTips().setIrrigation(Float.parseFloat(value));
                case LEAF_COLOR -> getVisualParameters().setLeafColor(VisualParameters.Color.valueOf(value));
                case STALK_COLOR -> getVisualParameters().setStalkColor(VisualParameters.Color.valueOf(value));
                case AVERAGE_SIZE -> getVisualParameters().setAverageSize(VisualParameters.Size.valueOf(value));
                default -> throw new EnumConstantNotPresentException(currentXmlTag.getDeclaringClass(), currentXmlTag.name());
            }
        }
    }
}