package by.epamtc.poliukov.validator;

import by.epamtc.poliukov.entity.Aircraft;
import by.epamtc.poliukov.entity.airoplain.cargo.CargoAirplane;
import by.epamtc.poliukov.entity.airoplain.passenger.PassengerAirplane;
import by.epamtc.poliukov.entity.helicopter.Helicopter;


public class Validator {

    public boolean isNull(Aircraft aircraft) {
        return aircraft == null;
    }
    public boolean isNull(String words) {
        return words == null;
    }
    public boolean isNegative(int number) {
        return number < 0;
    }
    public boolean isNegative(double number) {
        return number < 0;
    }
    public boolean isPositive(int number) {
        return number > 0;
    }
    public boolean isPositive(double number) {
        return number > 0;
    }

    private boolean isValidAircraft(Aircraft aircraft) {

        if (!isPositive(aircraft.getMaximumFlightRange())) {
            return false;
        }
        if (!isPositive(aircraft.getCruisingSpeed())) {
            return false;
        }
        if (!isPositive(aircraft.getFuelConsumption())) {
            return false;
        }
        return isPositive(aircraft.getLiftingCapacity());
    }
    public boolean isValidHelicopter(Helicopter helicopter) {
        if (isValidAircraft(helicopter)) {
            return !isNegative(helicopter.getAmountPassengers());
        }
        return false;
    }

    public boolean isValidPassengerAirplane(PassengerAirplane passengerAirplane) {
        if (isValidAircraft(passengerAirplane)) {
            return isPositive(passengerAirplane.getAmountPassengers());
        }
        return false;
    }

    public boolean isValidCargoAirplane(CargoAirplane cargoAirplane) {
        if (isValidAircraft(cargoAirplane)) {
            return isPositive(cargoAirplane.getCargoCompartmentVolume());
        }
        return false;
    }
}
