package service;

import entity.Airline;
import entity.Aircraft;
import exception.IllegalFuelConsumptionException;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

public class AirlineService {

    public ArrayList<E> searchFuelConsumptionRange(Airline airline, double low, double high) throws IllegalFuelConsumptionException {
        ArrayList<E> aircraftFuelConsumptionRange = new ArrayList<E>();
        if((low < 0) || (high < 0)) {
            throw new IllegalFuelConsumptionException("Invalid fuel consumption");
        }
        if(high < low) {
           double temp = low;
           low = high;
           high = temp;
        }
        Iterator<E> allAircraft = airline.allAircraftIterator();
        for (Iterator<E> it = allAircraft; it.hasNext(); ) {
            E aircraft = it.next();
            double fuelConsumption = aircraft.getFuelConsumption();
            if(fuelConsumption >= low && fuelConsumption <= high) {
                aircraftFuelConsumptionRange.add(aircraft);
            }
        }
        return aircraftFuelConsumptionRange;
    }

    public double calculateLiftingCapacity(Airline airline) {
        Iterator<E> iterator = airline.allAircraftIterator();
        double summaryCapacity = 0;
        while (iterator.hasNext()) {
            summaryCapacity += iterator.next().getLiftingCapacity();
        }
        return summaryCapacity;
    }

    public double calculateAmountPassengers(Airline airline) {
        Iterator<E> passengerAirplaneIterator = airline.passengerAirplanesIterator();
        Iterator<E> helicopterIterator = airline.helicoptersIterator();
        double summaryAmountPassengers = 0;
        while (passengerAirplaneIterator.hasNext()) {
            summaryAmountPassengers += passengerAirplaneIterator.next().getAmountPassengers();
        }
        while (helicopterIterator.hasNext()) {
            summaryAmountPassengers += passengerAirplaneIterator.next().getAmountPassengers();
        }
        return summaryAmountPassengers;
    }

    public void sortAllAircraft(Airline airline, Comparator comparator) {
        for (int i = 0; i < airline.getAllAircraftsSize() - 1; i++){
            for (int j = airline.getAllAircraftsSize() - 1; j > i; j--){
                if (comparator.compare(airline.get(j-1), airline.get(j)) == 1) {
                    toSwapAllAircraft(airline, j - 1, j);
                }
            }
        }
    }

    public void sortPassengerAircraft(Airline airline, Comparator comparator) {
        for (int i = 0; i < airline.getPassengerAircraftSize() - 1; i++){
            for (int j = airline.getPassengerAircraftSize() - 1; j > i; j--){
                if (comparator.compare(airline.getPassengerAircraft(j-1), airline.getPassengerAircraft(j)) == 1) {
                    toSwapPassengerAircraft(airline, j - 1, j);
                }
            }
        }
    }


    public void toSwapAllAircraft(Airline airline, int index1, int index2) {
        Aircraft temp = airline.get(index1);
        airline.set(index1, airline.get(index2));
        airline.set(index2, temp);
    }

    public void toSwapPassengerAircraft(Airline airline, int index1, int index2) {
        Aircraft temp = airline.getPassengerAircraft(index1);
        airline.setPassengerAircraft(index1, airline.getPassengerAircraft(index2));
        airline.setPassengerAircraft(index2, temp);
    }


}
