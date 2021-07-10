package entity.airoplain.passenger;

import entity.Aircraft;

public class PassengerAirplane extends Aircraft {
    private int amountPassengers;

    public PassengerAirplane(String category, String name, double maximumFlightRange, double cruisingSpeed,
                             double fuelConsumption, double liftingCapacity, int amountPassengers) {
        super(category, name, maximumFlightRange, cruisingSpeed, fuelConsumption, liftingCapacity);
        this.amountPassengers = amountPassengers;
    }

    public int getAmountPassengers() {
        return amountPassengers;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", amountPassengers=" + amountPassengers +
                '}' + System.lineSeparator();
    }
}
