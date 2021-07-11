package reader;

import entity.Aircraft;
import entity.airoplain.cargo.CargoAirplane;
import entity.airoplain.passenger.PassengerAirplane;
import entity.helicopter.Helicopter;
import exception.UnsupportedCategoryException;

public class InputData {

    public Aircraft readAircraftParams(String line) throws UnsupportedCategoryException {
        String[] params = line.split(", ");
    try {
        String category = params[0];
        String name = params[1];
        double maximumFlightRange = Double.parseDouble(params[2]) ;
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
        }
        else {
            throw new UnsupportedCategoryException("Unsupported category of aircraft");
        }

    }
    catch (NumberFormatException e) {

    }
    return null;

    }
}
