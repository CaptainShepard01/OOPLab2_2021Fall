package Xml;

/**
 * Actual factory for different builders.
 */
public class FlowerBuilderFactory {
    /**
     * Enum containing possible types of parser.
     */
    private enum TypeParser {
        SAX, STAX, DOM
    }

    private FlowerBuilderFactory() {
    }

    /**
     * Method creating actual builder determined by type.
     * @param typeParser String represents type of parser to use.
     * @return AbstractFlowersBuilder, abstract class.
     */
    public static AbstractFlowersBuilder createFlowerBuilder(String typeParser) {
        TypeParser type = TypeParser.valueOf(typeParser.toUpperCase());
        switch (type) {
            case DOM -> {
                return new FlowersDomBuilder();
            }
            case STAX -> {
                return new FlowersStaxBuilder();
            }
            case SAX -> {
                return new FlowersSaxBuilder();
            }
            default -> throw new EnumConstantNotPresentException(
                    type.getDeclaringClass(), type.name());
        }
    }
}
