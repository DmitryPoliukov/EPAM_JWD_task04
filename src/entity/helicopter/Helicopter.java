package entity.helicopter;

import entity.Aircraft;

public class Helicopter extends Aircraft {
    private int amountPassengers;

    public int getAmountPassengers() {
        return amountPassengers;
    }

    public Helicopter(String category, String name, double maximumFlightRange, double cruisingSpeed,
                      double fuelConsumption, double liftingCapacity, int amountPassengers) {
        super(category, name, maximumFlightRange, cruisingSpeed, fuelConsumption, liftingCapacity);
        this.amountPassengers = amountPassengers;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", amountPassengers=" + amountPassengers +
                '}' + System.lineSeparator();
    }
}
