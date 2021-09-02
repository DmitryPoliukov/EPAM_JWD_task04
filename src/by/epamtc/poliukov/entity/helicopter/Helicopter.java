package by.epamtc.poliukov.entity.helicopter;

import by.epamtc.poliukov.entity.Aircraft;
import by.epamtc.poliukov.validator.Validator;

import java.io.Serializable;


public class Helicopter extends Aircraft implements Serializable {
    private Validator validator = new Validator();
    private static final long serialVersionUID = 1L;
    private int amountPassengers;

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

    public Helicopter(String category, String name, double maximumFlightRange, double cruisingSpeed,
                      double fuelConsumption, double liftingCapacity, int amountPassengers) {
        super(category, name, maximumFlightRange, cruisingSpeed, fuelConsumption, liftingCapacity);
        this.amountPassengers = amountPassengers;
    }

    public Helicopter() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Helicopter that = (Helicopter) o;
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
