package entity.airoplain.cargo;

import entity.Aircraft;

public class CargoAirplane extends Aircraft {

    private double cargoCompartmentVolume;


    public CargoAirplane(String category, String name, double maximumFlightRange, double cruisingSpeed,
                          double fuelConsumption, double liftingCapacity, double cargoCompartmentVolume) {
        super(category, name, maximumFlightRange, cruisingSpeed, fuelConsumption, liftingCapacity);
        this.cargoCompartmentVolume = cargoCompartmentVolume;
    }

    public double getCargoCompartmentVolume() {
        return cargoCompartmentVolume;
    }

    @Override
    public String toString() {
        return super.toString()  +
                ", cargoCompartmentVolume=" + cargoCompartmentVolume +
                '}' + System.lineSeparator();
    }
}
