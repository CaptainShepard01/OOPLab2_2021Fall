package Xml;

public enum FlowerXmlTag {
    FLOWERS("Flowers"),
    FLOWER("Flower"),
    SOIL("soil"),
    MULTIPLYING("multiplying"),
    ID("id"),
    NAME("name"),
    ORIGIN("origin"),
    TEMPERATURE("temperature"),
    LIGHTING("lighting"),
    STALK_COLOR("stalk_color"),
    LEAF_COLOR("leaf_color"),
    AVERAGE_SIZE("average_size"),
    IRRIGATION("irrigation"),
    VISUAL_PARAMETERS("visual_parameters"),
    GROWING_TIPS("growing_tips");
    private String value;
    FlowerXmlTag(String value){
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
