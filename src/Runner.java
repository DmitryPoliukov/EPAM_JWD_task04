import comparator.AmountPassengersComparator;
import entity.Airline;
import entity.Aircraft;
import exception.IllegalFuelConsumptionException;
import exception.UnsupportedCategoryException;
import inputstream.InputData;
import service.AirlineService;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;

public class Runner {
    public static void main(String[] args) throws FileNotFoundException {
        InputData inputData = new InputData();
        Airline airlineDmitry = new Airline();
        AirlineService airlineService = new AirlineService();
        try {
            inputData.initAircraft(airlineDmitry);
        } catch (UnsupportedCategoryException e) {
            e.printStackTrace();
        }
        airlineDmitry.initAllAircraft();
        airlineDmitry.initPassengerAircraft();
       // System.out.println(airlineDmitry.cargoAirplanes);
        //System.out.println(airlineDmitry.passengerAirplanes);
        //System.out.println(airlineDmitry.helicopters);
        //System.out.println();
        try {
            ArrayList<E> searchFuel = airlineService.searchFuelConsumptionRange(airlineDmitry, 0, 100);
            System.out.println(searchFuel);
        } catch (IllegalFuelConsumptionException e) {
            e.printStackTrace();
        }
        double summaryLifting = airlineService.calculateLiftingCapacity(airlineDmitry);
        System.out.println(summaryLifting);
        Comparator<Aircraft> twoStepsComparator = Comparator.comparing(Aircraft::getFuelConsumption).
                thenComparing(Aircraft::getLiftingCapacity);
        airlineService.sortAllAircraft(airlineDmitry, twoStepsComparator );
        System.out.println(airlineDmitry.allAircrafts);

        airlineService.sortPassengerAircraft(airlineDmitry, new AmountPassengersComparator());
        System.out.println(airlineDmitry.passengerAircrafts);



    }
}
