package by.epamtc.poliukov.reader;

import by.epamtc.poliukov.entity.Aircraft;
import by.epamtc.poliukov.entity.airoplain.cargo.CargoAirplane;
import by.epamtc.poliukov.entity.airoplain.passenger.PassengerAirplane;
import by.epamtc.poliukov.entity.helicopter.Helicopter;
import by.epamtc.poliukov.exception.UnsupportedCategoryException;

public class InputData {

    public Aircraft readAircraftParams(String line) throws UnsupportedCategoryException {
        String[] params = line.split(", ");
        String category = params[0];
        String name = params[1];
    try {
        double maximumFlightRange = Double.parseDouble(params[2]);
        double cruisingSpeed = Double.parseDouble(params[3]);
        double fuelConsumption = Double.parseDouble(params[4]);
        double liftingCapacity = Double.parseDouble(params[5]);
        if (category.equals("cargo airplane")) {
            double cargoCompartmentVolume = Double.parseDouble(params[6]);
            return new CargoAirplane(category, name, maximumFlightRange, cruisingSpeed,
                    fuelConsumption, liftingCapacity, cargoCompartmentVolume);
        } else if (category.equals("passenger airplane")) {
            int amountPassengers = Integer.parseInt(params[6]);
            return new PassengerAirplane(category, name, maximumFlightRange, cruisingSpeed,
                    fuelConsumption, liftingCapacity, amountPassengers);

        } else if (category.equals("helicopter")) {
            int amountPassengers = Integer.parseInt(params[6]);
            return new Helicopter(category, name, maximumFlightRange, cruisingSpeed,
                    fuelConsumption, liftingCapacity, amountPassengers);
        } else {
            throw new UnsupportedCategoryException("Unsupported category of aircraft " + category);
        }

    } catch (NumberFormatException e) {
        System.out.println("Incorrect number parameter in " + name);
    }
    return null;
    }
}
