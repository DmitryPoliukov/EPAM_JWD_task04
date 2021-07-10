package entity;

import entity.airoplain.cargo.CargoAirplane;
import entity.airoplain.passenger.PassengerAirplane;
import entity.helicopter.Helicopter;
import exception.InvalidIndexException;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Airline implements Serializable {
    private static final long serialVersionUID = 1L;

    public List<PassengerAirplane> passengerAirplanes = new ArrayList<>() ;
    public List<CargoAirplane> cargoAirplanes = new ArrayList<>();
    public List<Helicopter> helicopters = new ArrayList<>();
    public List<Aircraft> allAircrafts = new ArrayList<>();
    public List<Aircraft> passengerAircrafts = new ArrayList<>();

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
        if(isNull(passengerAirplane)) {
            return false;
        }
        return passengerAirplanes.add(passengerAirplane);
    }


    public boolean addCargoAirplane(CargoAirplane cargoAirplane) {
        if(isNull(cargoAirplane)) {
            return false;
        }
        return cargoAirplanes.add(cargoAirplane);
    }

    public boolean addHelicopter(Helicopter helicopter) {
        if(isNull(helicopter)) {
            return false;
        }
        return helicopters.add(helicopter);
    }

    public boolean removePassengerAirplane(PassengerAirplane passengerAirplane) {
        if(isNull(passengerAirplane)) {
            return false;
        }
        return passengerAirplanes.remove(passengerAirplane);
    }


    public boolean removeCargoAirplane(CargoAirplane cargoAirplane) {
        if(isNull(cargoAirplane)) {
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
    public Iterator<Aircraft> allAircraftIterator() {
        return allAircrafts.iterator();
    }
    public Iterator<Aircraft> passengerAircrafts () {
        return passengerAircrafts.iterator();
    }

    public int getAllAircraftsSize() {
        return allAircrafts.size();
    }
    public int getPassengerAircraftSize() {
        return passengerAircrafts.size();
    }

    public Aircraft get(int index) throws InvalidIndexException {
        if(!isPositiveInt(index) || index >= allAircrafts.size()) {
            throw new InvalidIndexException("Invalid index");
        }
        return allAircrafts.get(index);
    }
    public Aircraft getPassengerAircraft(int index) throws InvalidIndexException {
        if(!isPositiveInt(index) || index >= passengerAircrafts.size()) {
            throw new InvalidIndexException("Invalid index");
        }
        return passengerAircrafts.get(index);
    }

    public boolean set(int index, Aircraft aircraft) {
        if(isNull(aircraft)) {
            return false;
        }
        if(!isPositiveInt(index) || index >= allAircrafts.size()) {
            return false;
        }
        allAircrafts.set(index, aircraft);
        return true;
    }
    public boolean setPassengerAircraft(int index, Aircraft aircraft) {
        if(isNull(aircraft)) {
            return false;
        }
        if(!isPositiveInt(index) || index >= passengerAircrafts.size()) {
            return false;
        }
        passengerAircrafts.set(index, aircraft);
        return true;
    }

    private boolean isNull(Aircraft aircraft) {
        return aircraft == null;
    }
    private boolean isPositiveInt(int number) {
        return number > 0;
    }



}
