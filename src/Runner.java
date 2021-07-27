import comparator.AmountPassengersComparator;
import entity.Aircraft;
import entity.Airline;
import exception.IllegalFuelConsumptionException;
import exception.InvalidIndexException;
import exception.UnsupportedCategoryException;
import presentation.Presentation;
import service.AirlineService;

import java.io.*;
import java.util.Comparator;
import java.util.List;

public class Runner {
    public static void main(String[] args) {
        Airline airlineTT = new Airline();
        Presentation presentation = new Presentation();

        AirlineService airlineService = new AirlineService();
        try {
            airlineService.initAircraft(airlineTT);
        } catch (UnsupportedCategoryException | FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        airlineTT.initAllAircraft();
        airlineTT.initPassengerAircraft();
        System.out.println("Airline contains has the following aircrafts:");
        presentation.printAllAircrafts(airlineTT);

        int calculatePass = airlineService.calculateAmountPassengers(airlineTT);
        System.out.println("Total amount passengers= " + calculatePass);
        double summaryLifting = airlineService.calculateLiftingCapacity(airlineTT);
        System.out.println("Total lifting capacity= " + summaryLifting);

        Comparator<Aircraft> twoStepsComparator = Comparator.comparing(Aircraft::getFuelConsumption).
                thenComparing(Aircraft::getLiftingCapacity);
        try {
            airlineService.sortAllAircraft(airlineTT, twoStepsComparator);
            airlineService.sortPassengerAircraft(airlineTT, new AmountPassengersComparator());
        } catch (InvalidIndexException e) {
            throw new RuntimeException(e.getMessage());
        }
        System.out.println("Sort all aircrafts by fuel consumption first and then sort by lifting capacity:");
        presentation.printAllAircrafts(airlineTT);

        System.out.println("Sort passenger aircraft by amount passenger:");
        presentation.printPassengerAircrafts(airlineTT);

        try {
            System.out.println("Aircraft with fuel consumption from 0 to 100:");
            List<Aircraft> searchFuel = airlineService.searchFuelConsumptionRange(airlineTT, 0, 100);
            System.out.println(searchFuel);
        } catch (IllegalFuelConsumptionException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
