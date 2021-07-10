package validator;

import entity.Aircraft;
import entity.airoplain.cargo.CargoAirplane;
import entity.airoplain.passenger.PassengerAirplane;
import entity.helicopter.Helicopter;


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

        if(!isPositive(aircraft.getMaximumFlightRange())) {
            return false;
        }
        if(!isPositive(aircraft.getCruisingSpeed())) {
            return false;
        }
        if(!isPositive(aircraft.getFuelConsumption())) {
            return false;
        }
        if(!isPositive(aircraft.getLiftingCapacity())) {
            return false;
        }
        return true;
    }
    public boolean isValidHelicopter(Helicopter helicopter) {
        if(isValidAircraft(helicopter)) {
            if(!isNegative(helicopter.getAmountPassengers())) {
                return true;
            }
        }
        return false;
    }

    public boolean isValidPassengerAirplane(PassengerAirplane passengerAirplane) {
        if(isValidAircraft(passengerAirplane)) {
            if(isPositive(passengerAirplane.getAmountPassengers())) {
                return true;
            }
        }
        return false;
    }

    public boolean isValidCargoAirplane(CargoAirplane cargoAirplane) {
        if(isValidAircraft(cargoAirplane)) {
            if(isPositive(cargoAirplane.getCargoCompartmentVolume())) {
                return true;
            }
        }
        return false;
    }
}
