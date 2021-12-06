package Xml;

public class FlowerBuilderFactory {
    private enum TypeParser {
        SAX, STAX, DOM
    }

    private FlowerBuilderFactory() {
    }

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
