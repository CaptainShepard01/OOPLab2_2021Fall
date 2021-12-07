package Xml;

import Flower.Flower;
import Flower.FlowerComparator;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String type = "sax";
        AbstractFlowersBuilder builder = FlowerBuilderFactory.createFlowerBuilder(type);
        builder.buildSetFlowers("src/main/java/Xml/flowers.xml");
        List<Flower> resultArray = new ArrayList<>(builder.getFlowers());
        resultArray.sort(new FlowerComparator());
        System.out.println(resultArray);
    }
}
