package by.epamtc.poliukov.entity.airoplain.passenger;

import by.epamtc.poliukov.entity.Aircraft;
import by.epamtc.poliukov.validator.Validator;

public class PassengerAirplane extends Aircraft {
    private Validator validator = new Validator();
    private static final long serialVersionUID = 1L;

    private int amountPassengers;

    public PassengerAirplane(String category, String name, double maximumFlightRange, double cruisingSpeed,
                             double fuelConsumption, double liftingCapacity, int amountPassengers) {
        super(category, name, maximumFlightRange, cruisingSpeed, fuelConsumption, liftingCapacity);
        this.amountPassengers = amountPassengers;
    }

    public PassengerAirplane() {
    }

    public int getAmountPassengers() {
        return amountPassengers;
    }
    public boolean setAmountPassengers(int amountPassengers) {
        if (validator.isNegative(amountPassengers)) {
            return false;
        }
        this.amountPassengers = amountPassengers;
        return true;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        PassengerAirplane that = (PassengerAirplane) o;
        return amountPassengers == that.amountPassengers;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + Integer.hashCode(amountPassengers);
        return result;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder(super.toString());
        builder.append(", amountPassengers= ");
        builder.append(amountPassengers);
        builder.append("]");
        builder.append(System.lineSeparator());
        return builder.toString();
    }
}
