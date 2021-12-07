package Flower;

import Xml.FlowerXmlTag;

import java.util.Comparator;
import java.util.Objects;
import java.util.concurrent.Flow;

/** Represents a Flower.
 * @author Anton Balykov
 */

public class Flower implements Comparable<Flower>{
    private String id;
    private String name;
    /** Represents proper soil.
     */
    private Soil soil;
    /** Represents homeland of this flower.
     */
    private String origin;
    /** All visual parameters of this flower.
     */
    private VisualParameters visualParameters = new VisualParameters();
    /** How to grow and look after this flower.
     */
    private GrowingTips growingTips = new GrowingTips();
    /** In what manner does this flower replicate.
     */
    private Multiplying multiplying;

    public Flower() {
    }

    /** Creates a flower with the specified parameters.
     *
     * @param id Flower's id.
     * @param name Flower's name.
     * @param soil Flower's proper soil.
     * @param origin Flower's origin country.
     * @param visualParameters Flower's visual identity.
     * @param multiplying Flower's way of replicating.
     */
    public Flower(String id, String name, Soil soil, String origin, VisualParameters visualParameters, Multiplying multiplying) {
        this.id = id;
        this.name = name;
        this.soil = soil;
        this.origin = origin;
        this.visualParameters = visualParameters;
        this.multiplying = multiplying;
    }

    /**
     * Gets Flower's id.
     * @return A string representing the flower's id.
     */
    public String getId() {
        return id;
    }

    /**
     * Gets Flower's name.
     * @return A string representing the flower's name.
     */
    public String getName() {
        return name;
    }

    /**
     * Gets Flower's proper soil.
     * @return An enum object representing the flower's soil.
     */
    public Soil getSoil() {
        return soil;
    }

    /**
     * Gets Flower's origin.
     * @return A string representing the flower's origin country.
     */
    public String getOrigin() {
        return origin;
    }

    /**
     * Gets all visual parameters.
     * @return A class representing flower's visual parameters.
     */
    public VisualParameters getVisualParameters() {
        return visualParameters;
    }

    /**
     * Gets all growing tips.
     * @return A class representing flower's growing tips.
     */
    public GrowingTips getGrowingTips() {
        return growingTips;
    }

    /**
     * Gets Flower's multiplying way.
     * @return An enum object representing the flower's way of replicating.
     */
    public Multiplying getMultiplying() {
        return multiplying;
    }

    /**
     * Sets the Flower's id.
     * @param id A string containing the flower's id.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Sets the Flower's name.
     * @param name A string containing the flower's name.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets the Flower's soil.
     * @param soil An enum object representing the flower's soil.
     */
    public void setSoil(Soil soil) {
        this.soil = soil;
    }

    /**
     * Sets the Flower's origin.
     * @param origin A string containing the flower's origin country.
     */
    public void setOrigin(String origin) {
        this.origin = origin;
    }

    /**
     * Sets the Flower's all visual parameters.
     * @param visualParameters A class containing all the flower's visual parameters.
     */
    public void setVisualParameters(VisualParameters visualParameters) {
        this.visualParameters = visualParameters;
    }

    /**
     * Sets the Flower's all growing tips.
     * @param growingTips A class containing all the flower's growing tips.
     */
    public void setGrowingTips(GrowingTips growingTips) {
        this.growingTips = growingTips;
    }

    /**
     * Sets the Flower's multiplying.
     * @param multiplying An enum object representing the flower's way of replicating.
     */
    public void setMultiplying(Multiplying multiplying) {
        this.multiplying = multiplying;
    }

    @Override
    public int compareTo(Flower o) {
        return id.compareTo(o.id);
    }

    /**
     * Inner class containing useful tips for growing the flower.
     */
    public class GrowingTips {
        /**
         * Shows proper temperature.
         */
        private float temperature;
        /**
         * Shows whether flower likes lighting or not.
         */
        private boolean lighting;
        /**
         * Shows how much do you need to irrigate flower per week (in ml).
         */
        private float irrigation;

        public GrowingTips() {
        }

        /**
         * Creates a growing tip with specified parameters.
         * @param temperature Proper temperature.
         * @param lighting Does flower like lighting.
         * @param irrigation How much do you need to irrigate flower per week (in ml).
         */
        public GrowingTips(float temperature, boolean lighting, float irrigation) {
            this.temperature = temperature;
            this.lighting = lighting;
            this.irrigation = irrigation;
        }

        /**
         * Gets flower's proper temperature.
         * @return A float representing the most relevant temperature for the flower.
         */
        public float getTemperature() {
            return temperature;
        }

        /**
         * Gets flower's preference for lighting.
         * @return A boolean representing whether flower likes lighting.
         */
        public boolean isLighting() {
            return lighting;
        }

        /**
         * Gets flower's irrigation amount.
         * @return A float representing a proper amount of irrigation per week (in ml).
         */
        public float getIrrigation() {
            return irrigation;
        }

        /**
         * Sets flower's proper temperature.
         * @param temperature A float representing how much is this flower's proper temperature.
         */
        public void setTemperature(float temperature) {
            this.temperature = temperature;
        }

        /**
         * Sets flower's lighting preference.
         * @param lighting A boolean representing whether flower does like the lighting or not.
         */
        public void setLighting(boolean lighting) {
            this.lighting = lighting;
        }

        /**
         * Sets flower's proper irrigation per week (in ml).
         * @param irrigation A float representing the proper amount of irrigation for this flower per week (in ml).
         */
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

            return temperature - anotherGrowingTips.temperature < 1e-5 && lighting == anotherGrowingTips.lighting && irrigation - anotherGrowingTips.irrigation < 1e-5;
        }

        public String toString(){
            final StringBuilder sb = new StringBuilder("\nGroving tips:\n\tTemperature: ");
            sb.append(temperature).append("\n\tLight: ").append(lighting);
            sb.append("\n\tIrrigation: ").append(irrigation).append('\n');
            return sb.toString();
        }
    }

    /**
     * Inner class containing visual identity of the flower.
     */
    public class VisualParameters{
        /**
         * Represents color of the flower's stalk.
         */
        private Color stalkColor;
        /**
         * Represents color of the flower's leaves.
         */
        private Color leafColor;
        /**
         * Represents flower's average size.
         */
        private Size averageSize;

        public VisualParameters() {
        }

        /**
         * Creates visual parameters which describe this flower the best.
         * @param stalkColor Flower's stalk color.
         * @param leafColor Flower's leaves color.
         * @param averageSize Flower's average size.
         */
        public VisualParameters(Color stalkColor, Color leafColor, Size averageSize) {
            this.stalkColor = stalkColor;
            this.leafColor = leafColor;
            this.averageSize = averageSize;
        }

        /**
         * Gets the color of flower's stalk.
         * @return An enum object representing flower's stalk color.
         */
        public Color getStalkColor() {
            return stalkColor;
        }

        /**
         * Gets the color of flower's leaves.
         * @return An enum object representing flower's leaves color.
         */
        public Color getLeafColor() {
            return leafColor;
        }

        /**
         * Gets the average size of flower.
         * @return An enum object representing flower's average size.
         */
        public Size getAverageSize() {
            return averageSize;
        }

        /**
         * Sets Flower's stalk color.
         * @param stalkColor An enum object representing flower's stalk color.
         */
        public void setStalkColor(Color stalkColor) {
            this.stalkColor = stalkColor;
        }

        /**
         * Sets Flower's leaves color.
         * @param leafColor An enum object representing flower's leaves color.
         */
        public void setLeafColor(Color leafColor) {
            this.leafColor = leafColor;
        }

        /**
         * Sets Flower's average size.
         * @param averageSize An enum object representing flower's average size.
         */
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

        /**
         * Enum to choose a color for flower's leaves and stalk.
         */
        public enum Color{
            RED,
            GREEN,
            YELLOW,
            BLUE
        }

        /**
         * Enum to choose a size for flower's average size.
         */
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

    /**
     * Enum to choose a proper soil for the flower.
     */
    public enum Soil{
        PODSOL,
        GROUND,
        TURF_PODSOL
    }

    /**
     * Enum to choose a flower's way of replicating.
     */
    public enum Multiplying{
        LEAF,
        STEM,
        SEMEN
    }

    /**
     * Method to initiate Flower's fields from Xml tag and value.
     * @param value String containing data.
     * @param currentXmlTag Xml tag defines which field data initializes.
     */
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