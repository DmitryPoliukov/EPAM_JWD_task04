import entity.Airline;
import entity.Aircraft;
import exception.IllegalFuelConsumptionException;
import exception.UnsupportedCategoryException;
import inputdata.InputData;
import service.AirlineService;

import java.io.FileNotFoundException;
import java.util.List;

public class Runner {
    public static void main(String[] args) throws FileNotFoundException {
        InputData inputData = new InputData();
        Airline airlineDmitry = new Airline();
        AirlineService airlineService = new AirlineService();
        try {
            airlineService.initAircraft(airlineDmitry);
        } catch (UnsupportedCategoryException e) {
            e.printStackTrace();
        }
        airlineDmitry.initAllAircraft();
        airlineDmitry.initPassengerAircraft();
        System.out.println(airlineDmitry.cargoAirplanes);
        //System.out.println(airlineDmitry.passengerAirplanes);
        //System.out.println(airlineDmitry.helicopters);
        //System.out.println();

        /*try {
            List<Aircraft> searchFuel = airlineService.searchFuelConsumptionRange(airlineDmitry, 0, 100);
            System.out.println(searchFuel);
        } catch (IllegalFuelConsumptionException e) {
            e.printStackTrace();
        }

        double summaryLifting = airlineService.calculateLiftingCapacity(airlineDmitry);
        System.out.println(summaryLifting);

        double calculatePass = airlineService.calculateAmountPassengers(airlineDmitry);
        System.out.println(calculatePass);
        Comparator<Aircraft> twoStepsComparator = Comparator.comparing(Aircraft::getFuelConsumption).
                thenComparing(Aircraft::getLiftingCapacity);
        try {
            airlineService.sortAllAircraft(airlineDmitry, twoStepsComparator );
            airlineService.sortPassengerAircraft(airlineDmitry, new AmountPassengersComparator());
        } catch (InvalidIndexException e) {
            e.printStackTrace();
        }
        System.out.println(airlineDmitry.allAircrafts);
        System.out.println(airlineDmitry.passengerAircrafts);

         */




    }
}
