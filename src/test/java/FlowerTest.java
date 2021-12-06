import Flower.Flower;
import Flower.FlowerComparator;
import Xml.AbstractFlowersBuilder;
import Xml.FlowerBuilderFactory;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;

public class FlowerTest {
    private static final Logger log = Logger.getLogger(FlowerTest.class.getName());

    @Test
    public void singleFlowerTest() {
        String type = "stax";
        AbstractFlowersBuilder builder = FlowerBuilderFactory.createFlowerBuilder(type);
        builder.buildSetFlowers("src/main/java/Xml/flowers.xml");

        Set<Flower> flowers = builder.getFlowers();

        Flower flower = new Flower();
        flower.setId("b");
        flower.setName("Kvitka");
        flower.setOrigin("USA");
        flower.setSoil(Flower.Soil.GROUND);
        flower.setMultiplying(Flower.Multiplying.SEMEN);
        flower.getVisualParameters().setAverageSize(Flower.VisualParameters.Size.MEDIUM);
        flower.getVisualParameters().setLeafColor(Flower.VisualParameters.Color.GREEN);
        flower.getVisualParameters().setStalkColor(Flower.VisualParameters.Color.GREEN);
        flower.getGrowingTips().setIrrigation(Float.parseFloat("250.3"));
        flower.getGrowingTips().setLighting(false);
        flower.getGrowingTips().setTemperature(Float.parseFloat("18.3"));

        List<Flower> flowerArray = new ArrayList<>(flowers);
        flowerArray.sort(new FlowerComparator());

        Flower actualFlower = flowerArray.get(1);

        Assert.assertEquals(actualFlower, flower);
    }

    @Test
    public void arrayTest() throws InterruptedException {
        String type = "stax";
        AbstractFlowersBuilder builder = FlowerBuilderFactory.createFlowerBuilder(type);
        builder.buildSetFlowers("src/main/java/Xml/flowers.xml");

        Set<Flower> flowers = builder.getFlowers();

        Flower flower = new Flower();
        flower.setId("a");
        flower.setName("Troyanda");
        flower.setOrigin("Ukraine");
        flower.setSoil(Flower.Soil.PODSOL);
        flower.setMultiplying(Flower.Multiplying.LEAF);
        flower.getVisualParameters().setAverageSize(Flower.VisualParameters.Size.MEDIUM);
        flower.getVisualParameters().setLeafColor(Flower.VisualParameters.Color.BLUE);
        flower.getVisualParameters().setStalkColor(Flower.VisualParameters.Color.GREEN);
        flower.getGrowingTips().setIrrigation(Float.parseFloat("400.5"));
        flower.getGrowingTips().setLighting(true);
        flower.getGrowingTips().setTemperature(Float.parseFloat("12.5"));

        Flower anotherFlower = new Flower();
        anotherFlower.setId("b");
        anotherFlower.setName("Kvitka");
        anotherFlower.setOrigin("USA");
        anotherFlower.setSoil(Flower.Soil.GROUND);
        anotherFlower.setMultiplying(Flower.Multiplying.SEMEN);
        anotherFlower.getVisualParameters().setAverageSize(Flower.VisualParameters.Size.MEDIUM);
        anotherFlower.getVisualParameters().setLeafColor(Flower.VisualParameters.Color.GREEN);
        anotherFlower.getVisualParameters().setStalkColor(Flower.VisualParameters.Color.GREEN);
        anotherFlower.getGrowingTips().setIrrigation(Float.parseFloat("250.3"));
        anotherFlower.getGrowingTips().setLighting(false);
        anotherFlower.getGrowingTips().setTemperature(Float.parseFloat("18.3"));

        List<Flower> expectedFlowers = new ArrayList<>();
        expectedFlowers.add(flower);
        expectedFlowers.add(anotherFlower);

        List<Flower> flowerArray = new ArrayList<>(flowers);
        flowerArray.sort(new FlowerComparator());

        Assert.assertEquals(flowerArray, expectedFlowers);
    }

    @Test
    public void objectTest(){
        Flower flower = new Flower();
        flower.setId("a");
        flower.setName("Troyanda");
        flower.setOrigin("Ukraine");
        flower.setSoil(Flower.Soil.PODSOL);
        flower.setMultiplying(Flower.Multiplying.LEAF);
        flower.getVisualParameters().setAverageSize(Flower.VisualParameters.Size.MEDIUM);
        flower.getVisualParameters().setLeafColor(Flower.VisualParameters.Color.BLUE);
        flower.getVisualParameters().setStalkColor(Flower.VisualParameters.Color.GREEN);
        flower.getGrowingTips().setIrrigation(Float.parseFloat("400.5"));
        flower.getGrowingTips().setLighting(true);
        flower.getGrowingTips().setTemperature(Float.parseFloat("12.5"));

        Flower anotherFlower = new Flower();
        anotherFlower.setId("a");
        anotherFlower.setName("Troyanda");
        anotherFlower.setOrigin("Ukraine");
        anotherFlower.setSoil(Flower.Soil.PODSOL);
        anotherFlower.setMultiplying(Flower.Multiplying.LEAF);
        anotherFlower.getVisualParameters().setAverageSize(Flower.VisualParameters.Size.MEDIUM);
        anotherFlower.getVisualParameters().setLeafColor(Flower.VisualParameters.Color.BLUE);
        anotherFlower.getVisualParameters().setStalkColor(Flower.VisualParameters.Color.GREEN);
        anotherFlower.getGrowingTips().setIrrigation(Float.parseFloat("400.5"));
        anotherFlower.getGrowingTips().setLighting(true);
        anotherFlower.getGrowingTips().setTemperature(Float.parseFloat("12.5"));


        Assert.assertEquals(flower, anotherFlower);
    }

    @Test
    public void arrayObjectTest(){
        Flower flower = new Flower();
        flower.setId("a");
        flower.setName("Troyanda");
        flower.setOrigin("Ukraine");
        flower.setSoil(Flower.Soil.PODSOL);
        flower.setMultiplying(Flower.Multiplying.LEAF);
        flower.getVisualParameters().setAverageSize(Flower.VisualParameters.Size.MEDIUM);
        flower.getVisualParameters().setLeafColor(Flower.VisualParameters.Color.BLUE);
        flower.getVisualParameters().setStalkColor(Flower.VisualParameters.Color.GREEN);
        flower.getGrowingTips().setIrrigation(Float.parseFloat("400.5"));
        flower.getGrowingTips().setLighting(true);
        flower.getGrowingTips().setTemperature(Float.parseFloat("12.5"));

        Flower anotherFlower = new Flower();
        anotherFlower.setId("b");
        anotherFlower.setName("Kvitka");
        anotherFlower.setOrigin("USA");
        anotherFlower.setSoil(Flower.Soil.GROUND);
        anotherFlower.setMultiplying(Flower.Multiplying.SEMEN);
        anotherFlower.getVisualParameters().setAverageSize(Flower.VisualParameters.Size.MEDIUM);
        anotherFlower.getVisualParameters().setLeafColor(Flower.VisualParameters.Color.GREEN);
        anotherFlower.getVisualParameters().setStalkColor(Flower.VisualParameters.Color.GREEN);
        anotherFlower.getGrowingTips().setIrrigation(Float.parseFloat("250.3"));
        anotherFlower.getGrowingTips().setLighting(false);
        anotherFlower.getGrowingTips().setTemperature(Float.parseFloat("18.3"));

        List<Flower> expectedFlowers = new ArrayList<>();
        expectedFlowers.add(flower);
        expectedFlowers.add(anotherFlower);

        Flower thirdFlower = new Flower();
        thirdFlower.setId("b");
        thirdFlower.setName("Kvitka");
        thirdFlower.setOrigin("USA");
        thirdFlower.setSoil(Flower.Soil.GROUND);
        thirdFlower.setMultiplying(Flower.Multiplying.SEMEN);
        thirdFlower.getVisualParameters().setAverageSize(Flower.VisualParameters.Size.MEDIUM);
        thirdFlower.getVisualParameters().setLeafColor(Flower.VisualParameters.Color.GREEN);
        thirdFlower.getVisualParameters().setStalkColor(Flower.VisualParameters.Color.GREEN);
        thirdFlower.getGrowingTips().setIrrigation(Float.parseFloat("250.3"));
        thirdFlower.getGrowingTips().setLighting(false);
        thirdFlower.getGrowingTips().setTemperature(Float.parseFloat("18.3"));

        Flower fourthFlower = new Flower();
        fourthFlower.setId("a");
        fourthFlower.setName("Troyanda");
        fourthFlower.setOrigin("Ukraine");
        fourthFlower.setSoil(Flower.Soil.PODSOL);
        fourthFlower.setMultiplying(Flower.Multiplying.LEAF);
        fourthFlower.getVisualParameters().setAverageSize(Flower.VisualParameters.Size.MEDIUM);
        fourthFlower.getVisualParameters().setLeafColor(Flower.VisualParameters.Color.BLUE);
        fourthFlower.getVisualParameters().setStalkColor(Flower.VisualParameters.Color.GREEN);
        fourthFlower.getGrowingTips().setIrrigation(Float.parseFloat("400.5"));
        fourthFlower.getGrowingTips().setLighting(true);
        fourthFlower.getGrowingTips().setTemperature(Float.parseFloat("12.5"));

        List<Flower> anotherExpectedFlowers = new ArrayList<>();
        anotherExpectedFlowers.add(thirdFlower);
        anotherExpectedFlowers.add(fourthFlower);

        anotherExpectedFlowers.sort(new FlowerComparator());

        Assert.assertEquals(expectedFlowers, anotherExpectedFlowers);
    }
}
