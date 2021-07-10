package service;

import entity.Aircraft;
import entity.Airline;
import entity.airoplain.cargo.CargoAirplane;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class AirlineServiceTest {

    @Test
    public void searchFuelConsumptionRange() {
    }

    @Test
    public void testSearchFuelConsumptionRange() {
    }

    @Test
    public void calculateLiftingCapacity() {
    }

    @Test
    public void calculateAmountPassengers() {
    }

    @Test
    public void sortAllAircraft() {
       /* AirlineService airlineService = new AirlineService();
        ArrayList<Aircraft> actual = new ArrayList<>();
        actual.add(new CargoAirplane("cargo airplane", "DD" , 2779, 750, 100000000, 47,  1210) );
        actual.add(new CargoAirplane("cargo airplane", "Da" , 2779, 750, 100000000, 47,  1210) );
        actual.add(new CargoAirplane("cargo airplane", "BB" , 2779, 750, 100000000, 47,  1210) );
        actual.add(new CargoAirplane("cargo airplane", "AA" , 2779, 750, 100000000, 47,  1210) );
        actual.add(new CargoAirplane("cargo airplane", "CC" , 2779, 750, 100000000, 47,  1210) );
        Airline airline = new Airline(actual);
        airline.initAllAircraft();

        ArrayList<Aircraft> expected = new ArrayList<>();
        expected.add(new CargoAirplane("cargo airplane", "AA" , 2779, 750, 100000000, 47,  1210) );
        expected.add(new CargoAirplane("cargo airplane", "BB" , 2779, 750, 100000000, 47,  1210) );
        expected.add(new CargoAirplane("cargo airplane", "CC" , 2779, 750, 100000000, 47,  1210) );
        expected.add(new CargoAirplane("cargo airplane", "Da" , 2779, 750, 100000000, 47,  1210) );
        expected.add(new CargoAirplane("cargo airplane", "DD" , 2779, 750, 100000000, 47,  1210) );

        airlineService.sortAllAircraft(airline, new NameComparator());
        assertTrue(expected.equals(actual));
*/
    }

    @Test
    public void sortPassengerAircraft() {
    }
}