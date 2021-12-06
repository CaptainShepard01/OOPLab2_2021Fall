package Xml;

public class Main {
    public static void main(String[] args) {
        String type = "sax";
        AbstractFlowersBuilder builder = FlowerBuilderFactory.createFlowerBuilder(type);
        builder.buildSetFlowers("src/main/java/Xml/flowers.xml");
        System.out.println(builder.getFlowers());
    }
}
