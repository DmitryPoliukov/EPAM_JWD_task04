package inputstream;

import entity.Airline;
import entity.Aircraft;
import entity.airoplain.cargo.CargoAirplane;
import entity.airoplain.passenger.PassengerAirplane;
import entity.helicopter.Helicopter;
import exception.UnsupportedCategoryException;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class InputData {
    File file = new File(".\\resources\\1.txt");
    Scanner scanner = new Scanner(file);
    public InputData() throws FileNotFoundException {
    }

    public void initAircraft(Airline airline) throws UnsupportedCategoryException {
        while(scanner.hasNextLine()) {
            String line = scanner.nextLine();
            Aircraft aircraft = readAircraftParams(line);
            if(aircraft instanceof CargoAirplane) {
                airline.addCargoAirplane((CargoAirplane) aircraft);
            }
            else if(aircraft instanceof PassengerAirplane) {
                airline.addPassengerAirplane((PassengerAirplane) aircraft);
            }
            else if(aircraft instanceof Helicopter) {
                airline.addHelicopter((Helicopter) aircraft);
            }
        }
    }

    private Aircraft readAircraftParams(String line) throws UnsupportedCategoryException {
        String[] params = line.split(", ");
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
            throw new UnsupportedCategoryException();
        }
    }
}
