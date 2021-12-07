package Flower;

import java.util.Comparator;

/**
 * Class to implement Comparator interface and gain the ability to compare Flower objects.
 */
public class FlowerComparator implements Comparator<Flower> {

    @Override
    public int compare(Flower a, Flower b) {
        return a.compareTo(b);
    }
}
