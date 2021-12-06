package Flower;

import java.util.Comparator;

public class FlowerComparator implements Comparator<Flower> {

    @Override
    public int compare(Flower a, Flower b) {
        return a.compareTo(b);
    }
}
