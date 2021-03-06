package by.epamtc.poliukov.entity.airoplain.cargo;

import by.epamtc.poliukov.entity.Aircraft;
import by.epamtc.poliukov.validator.Validator;

import java.io.Serializable;

public class CargoAirplane extends Aircraft implements Serializable {
    private Validator validator = new Validator();
    private static final long serialVersionUID = 1L;
    private double cargoCompartmentVolume;


    public CargoAirplane(String category, String name, double maximumFlightRange, double cruisingSpeed,
                          double fuelConsumption, double liftingCapacity, double cargoCompartmentVolume) {
        super(category, name, maximumFlightRange, cruisingSpeed, fuelConsumption, liftingCapacity);
        this.cargoCompartmentVolume = cargoCompartmentVolume;
    }

    public CargoAirplane() {
    }

    public double getCargoCompartmentVolume() {
        return cargoCompartmentVolume;
    }
    public boolean setCargoCompartmentVolume(int cargoCompartmentVolume) {
        if (validator.isNegative(cargoCompartmentVolume)) {
            return false;
        }
        this.cargoCompartmentVolume = cargoCompartmentVolume;
        return true;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        CargoAirplane that = (CargoAirplane) o;
        return cargoCompartmentVolume == that.cargoCompartmentVolume;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + Double.hashCode(cargoCompartmentVolume);
        return result;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder(super.toString());
        builder.append(", cargoCompartmentVolume= ");
        builder.append(cargoCompartmentVolume);
        builder.append("]");
        builder.append(System.lineSeparator());
        return builder.toString();
    }
}
