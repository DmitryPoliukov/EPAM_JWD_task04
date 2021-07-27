package by.epamtc.poliukov.entity;

import by.epamtc.poliukov.entity.airoplain.cargo.CargoAirplane;
import by.epamtc.poliukov.entity.airoplain.passenger.PassengerAirplane;
import by.epamtc.poliukov.entity.helicopter.Helicopter;
import by.epamtc.poliukov.exception.InvalidIndexException;
import by.epamtc.poliukov.validator.Validator;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Airline implements Serializable {
    private Validator validator = new Validator();
    private static final long serialVersionUID = 1L;

    private List<PassengerAirplane> passengerAirplanes = new ArrayList<>();
    private List<CargoAirplane> cargoAirplanes = new ArrayList<>();
    private List<Helicopter> helicopters = new ArrayList<>();
    private List<Aircraft> allAircrafts = new ArrayList<>();
    private List<Aircraft> passengerAircrafts = new ArrayList<>();

    public Airline(ArrayList<Aircraft> allAircrafts) {
        this.allAircrafts = allAircrafts;
    }

    public Airline() {
    }

    public void initAllAircraft() {
        allAircrafts.addAll(passengerAirplanes);
        allAircrafts.addAll(cargoAirplanes);
        allAircrafts.addAll(helicopters);
    }

    public void initPassengerAircraft() {
        passengerAircrafts.addAll(passengerAirplanes);
        passengerAircrafts.addAll(helicopters);
    }

    public boolean addPassengerAirplane(PassengerAirplane passengerAirplane) {
        if (validator.isNull(passengerAirplane)) {
            return false;
        }
        return passengerAirplanes.add(passengerAirplane);
    }


    public boolean addCargoAirplane(CargoAirplane cargoAirplane) {
        if (validator.isNull(cargoAirplane)) {
            return false;
        }
        return cargoAirplanes.add(cargoAirplane);
    }

    public boolean addHelicopter(Helicopter helicopter) {
        if (validator.isNull(helicopter)) {
            return false;
        }
        return helicopters.add(helicopter);
    }

    public boolean removePassengerAirplane(PassengerAirplane passengerAirplane) {
        if (validator.isNull(passengerAirplane)) {
            return false;
        }
        return passengerAirplanes.remove(passengerAirplane);
    }


    public boolean removeCargoAirplane(CargoAirplane cargoAirplane) {
        if (validator.isNull(cargoAirplane)) {
            return false;
        }
        return cargoAirplanes.remove(cargoAirplane);
    }

    public Iterator<PassengerAirplane> passengerAirplanesIterator() {
        return passengerAirplanes.iterator();
    }
    public Iterator<CargoAirplane> cargoAirplanesIterator() {
        return cargoAirplanes.iterator();
    }
    public Iterator<Helicopter> helicoptersIterator() {
        return helicopters.iterator();
    }
    public Iterator<Aircraft> allAircraftsIterator() {
        return allAircrafts.iterator();
    }
    public Iterator<Aircraft> passengerAircraftsIterator() {
        return passengerAircrafts.iterator();
    }

    public int getAllAircraftsSize() {
        return allAircrafts.size();
    }
    public int getPassengerAircraftSize() {
        return passengerAircrafts.size();
    }

    public Aircraft get(int index) throws InvalidIndexException {
        if (validator.isNegative(index) || index >= allAircrafts.size()) {
            throw new InvalidIndexException("Invalid index");
        }
        return allAircrafts.get(index);
    }
    public Aircraft getPassengerAircraft(int index) throws InvalidIndexException {
        if (validator.isNegative(index) || index >= passengerAircrafts.size()) {
            throw new InvalidIndexException("Invalid index");
        }
        return passengerAircrafts.get(index);
    }

    public boolean set(int index, Aircraft aircraft) {
        if (validator.isNull(aircraft)) {
            return false;
        }
        if (validator.isNegative(index) || index >= allAircrafts.size()) {
            return false;
        }
        allAircrafts.set(index, aircraft);
        return true;
    }
    public boolean setPassengerAircraft(int index, Aircraft aircraft) {
        if (validator.isNull(aircraft)) {
            return false;
        }
        if (validator.isNegative(index) || index >= passengerAircrafts.size()) {
            return false;
        }
        passengerAircrafts.set(index, aircraft);
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Airline airline = (Airline) o;
        if (cargoAirplanes == null) {
            if (airline.cargoAirplanes != null) {
                return false;
            }
        } else if (!cargoAirplanes.equals(airline.cargoAirplanes)) {
            return false;
        }
        if (helicopters == null) {
            if (airline.helicopters != null) {
                return false;
            }
        } else if (!helicopters.equals(airline.helicopters)) {
            return false;
        }
        if (passengerAirplanes == null) {
            return airline.passengerAirplanes == null;
        } else return passengerAirplanes.equals(airline.passengerAirplanes);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (cargoAirplanes == null ? 0 : cargoAirplanes.hashCode());
        result = prime * result + (helicopters == null ? 0 : helicopters.hashCode());
        result = prime * result + (passengerAirplanes == null ? 0 : passengerAirplanes.hashCode());

        return result;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName()
                + "[allAircrafts=" + allAircrafts
                + ']';
    }
}
