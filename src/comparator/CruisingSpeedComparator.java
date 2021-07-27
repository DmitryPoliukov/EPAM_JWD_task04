package comparator;

import entity.Aircraft;

import java.util.Comparator;

public class CruisingSpeedComparator implements Comparator<Aircraft> {
    @Override
    public int compare(Aircraft o1, Aircraft o2) {
        if (o1.getCruisingSpeed() > o2.getCruisingSpeed()) {
            return 1;
        } else if (o1.getCruisingSpeed() < o2.getCruisingSpeed()) {
            return -1;
        }
        return 0;
    }
}
