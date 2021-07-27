package comparator;

import entity.Aircraft;

import java.util.Comparator;

public class AmountPassengersComparator implements Comparator<Aircraft> {
    @Override
    public int compare(Aircraft o1, Aircraft o2) {
        if (o1.getAmountPassengers() > o2.getAmountPassengers()) {
            return 1;
        } else if (o1.getAmountPassengers() < o2.getAmountPassengers()) {
            return -1;
        }
        return 0;
    }
}
