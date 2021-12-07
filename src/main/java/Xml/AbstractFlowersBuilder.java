package Xml;

import Flower.Flower;

import java.util.HashSet;
import java.util.Set;

/**
 * Abstract class which uses Factory pattern to build set of data from Xml.
 */
public abstract class AbstractFlowersBuilder {
    /**
     * Set of Flowers.
     */
    protected Set<Flower> flowers;
    public AbstractFlowersBuilder() {
        flowers = new HashSet<Flower>();
    }
    public AbstractFlowersBuilder(Set<Flower> flowers) {
        this.flowers = flowers;
    }
    public Set<Flower> getFlowers() {
        return flowers;
    }
    public abstract void buildSetFlowers(String filename);
}
