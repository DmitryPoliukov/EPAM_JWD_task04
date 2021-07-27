package comparator;

import entity.Aircraft;

import java.util.Comparator;

public class MaximumFlightRangeComparator implements Comparator<Aircraft> {
    @Override
    public int compare(Aircraft o1, Aircraft o2) {
        if (o1.getMaximumFlightRange() > o2.getMaximumFlightRange()) {
            return 1;
        } else if (o1.getMaximumFlightRange() < o2.getMaximumFlightRange()) {
            return -1;
        }
        return 0;
    }
}
