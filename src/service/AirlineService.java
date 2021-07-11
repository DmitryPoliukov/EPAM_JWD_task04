package service;

import entity.Airline;
import entity.Aircraft;
import entity.airoplain.cargo.CargoAirplane;
import entity.airoplain.passenger.PassengerAirplane;
import entity.helicopter.Helicopter;
import exception.IllegalFuelConsumptionException;
import exception.InvalidIndexException;
import exception.UnsupportedCategoryException;
import reader.InputData;
import validator.Validator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class AirlineService {
    Validator validator = new Validator();
    InputData inputData = new InputData();

    public AirlineService() throws FileNotFoundException {
    }


    public void initAircraft(Airline airline) throws UnsupportedCategoryException, FileNotFoundException {
        File file = new File(".\\resources\\aircraftsForReading.txt");
        Scanner scanner = new Scanner(file);
        while(scanner.hasNextLine()) {
            String line = scanner.nextLine();
            Aircraft aircraft = inputData.readAircraftParams(line);
            if(aircraft instanceof CargoAirplane) {
                if(validator.isValidCargoAirplane((CargoAirplane) aircraft)) {
                    airline.addCargoAirplane((CargoAirplane) aircraft);
                }
            }
            else if(aircraft instanceof PassengerAirplane) {
                if(validator.isValidPassengerAirplane((PassengerAirplane) aircraft)) {
                    airline.addPassengerAirplane((PassengerAirplane) aircraft);
                }
            }
            else if(aircraft instanceof Helicopter) {
                if(validator.isValidHelicopter((Helicopter) aircraft)){
                    airline.addHelicopter((Helicopter) aircraft);
                }
            }
        }
    }

    public List<Aircraft> searchFuelConsumptionRange(Airline airline, double low, double high) throws IllegalFuelConsumptionException {
        List<Aircraft> aircraftFuelConsumptionRange = new ArrayList<>();
        if((low < 0) || (high < 0)) {
            throw new IllegalFuelConsumptionException("Invalid fuel consumption");
        }
        if(high < low) {
           double temp = low;
           low = high;
           high = temp;
        }
        Iterator<Aircraft> allAircraft = airline.allAircraftsIterator();
        for (Iterator<Aircraft> it = allAircraft; it.hasNext(); ) {
            Aircraft aircraft = it.next();
            double fuelConsumption = aircraft.getFuelConsumption();
            if(fuelConsumption >= low && fuelConsumption <= high) {
                aircraftFuelConsumptionRange.add(aircraft);
            }
        }
        return aircraftFuelConsumptionRange;
    }

    public double calculateLiftingCapacity(Airline airline) {
        Iterator<Aircraft> iterator = airline.allAircraftsIterator();
        double summaryCapacity = 0;
        while (iterator.hasNext()) {
            summaryCapacity += iterator.next().getLiftingCapacity();
        }
        return summaryCapacity;
    }

    public double calculateAmountPassengers(Airline airline) {
        Iterator<Aircraft> iterator = airline.passengerAircraftsIterator();
        double summaryAmountPassengers = 0;
        while (iterator.hasNext()) {
            summaryAmountPassengers += iterator.next().getAmountPassengers();
        }
        return summaryAmountPassengers;
    }

    public void sortAllAircraft(Airline airline, Comparator comparator) throws InvalidIndexException {
        for (int i = 0; i < airline.getAllAircraftsSize() - 1; i++){
            for (int j = airline.getAllAircraftsSize() - 1; j > i; j--){
                if (comparator.compare(airline.get(j-1), airline.get(j)) == 1) {
                    toSwapAllAircraft(airline, j - 1, j);
                }
            }
        }
    }

    public void sortPassengerAircraft(Airline airline, Comparator comparator) throws InvalidIndexException {
        for (int i = 0; i < airline.getPassengerAircraftSize() - 1; i++){
            for (int j = airline.getPassengerAircraftSize() - 1; j > i; j--){
                if (comparator.compare(airline.getPassengerAircraft(j-1), airline.getPassengerAircraft(j)) == 1) {
                    toSwapPassengerAircraft(airline, j - 1, j);
                }
            }
        }
    }


    public void toSwapAllAircraft(Airline airline, int index1, int index2) throws InvalidIndexException {
        Aircraft temp = airline.get(index1);
        airline.set(index1, airline.get(index2));
        airline.set(index2, temp);
    }

    public void toSwapPassengerAircraft(Airline airline, int index1, int index2) throws InvalidIndexException {
        Aircraft temp = airline.getPassengerAircraft(index1);
        airline.setPassengerAircraft(index1, airline.getPassengerAircraft(index2));
        airline.setPassengerAircraft(index2, temp);
    }


}
