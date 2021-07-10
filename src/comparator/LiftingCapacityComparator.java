package comparator;

import entity.Aircraft;

import java.util.Comparator;

public class LiftingCapacityComparator implements Comparator<Aircraft> {
    @Override
    public int compare(Aircraft o1, Aircraft o2) {
        if(o1.getLiftingCapacity() > o2.getLiftingCapacity()) {
            return 1;
        }
        else if(o1.getLiftingCapacity() < o2.getLiftingCapacity()) {
            return -1;
        }
        return 0;
    }
}
