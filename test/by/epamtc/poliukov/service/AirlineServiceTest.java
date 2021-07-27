package by.epamtc.poliukov.service;

import by.epamtc.poliukov.comparator.FuelConsumptionComparator;
import by.epamtc.poliukov.comparator.MaximumFlightRangeComparator;
import by.epamtc.poliukov.entity.Aircraft;
import by.epamtc.poliukov.entity.Airline;
import by.epamtc.poliukov.entity.helicopter.Helicopter;
import by.epamtc.poliukov.exception.IllegalFuelConsumptionException;
import by.epamtc.poliukov.exception.InvalidIndexException;
import by.epamtc.poliukov.exception.UnsupportedCategoryException;
import org.junit.Before;
import org.junit.Test;
import by.epamtc.poliukov.reader.InputData;


import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.junit.Assert.*;

public class AirlineServiceTest {
    private Airline airlineTT;
    private AirlineService airlineService;
    @Before
    public void initAirLine() throws FileNotFoundException {
        airlineTT = new Airline();
        airlineService = new AirlineService();
        try {
            airlineService.initAircraft(airlineTT);
        } catch (UnsupportedCategoryException e) {
            e.printStackTrace();
        }
        airlineTT.initAllAircraft();
        airlineTT.initPassengerAircraft();
    }

    @Test
    public void searchFuelConsumptionRange() throws IllegalFuelConsumptionException {
        List<Aircraft> expected = new ArrayList<>();
        expected.add(new Helicopter("helicopter", "Robinson R 44" , 650, 210, 57, 0.380, 3));
        List<Aircraft> actual =  airlineService.searchFuelConsumptionRange(airlineTT, 0, 220);
        assertTrue(expected.equals(actual));
    }

    @Test
    public void calculateLiftingCapacity() {
        double expected = 418.047;
        double actual = airlineService.calculateLiftingCapacity(airlineTT);
        assertEquals(expected, actual, 0.001);

    }

    @Test
    public void calculateAmountPassengers() {
        int expected = 1740;
        int actual = airlineService.calculateAmountPassengers(airlineTT);
        assertEquals(expected, actual, 0);
    }

    @Test
    public void sortAllAircraft() throws InvalidIndexException {
        airlineService.sortAllAircraft(airlineTT, new MaximumFlightRangeComparator());
        Iterator<Aircraft> actualIterator = airlineTT.allAircraftsIterator();
        boolean isSorted = false;
        if(!actualIterator.hasNext()) {
            isSorted = true;
        }
        Aircraft aircraftFirst = actualIterator.next();
        Aircraft aircraftSecond;
        while(actualIterator.hasNext()) {
            aircraftSecond = actualIterator.next();
            if(new MaximumFlightRangeComparator().compare(aircraftFirst, aircraftSecond) == -1) {
                isSorted = true;
            }
            aircraftFirst = aircraftSecond;
        }
        assertEquals(true, isSorted);
    }

    @Test
    public void sortPassengerAircraft() throws InvalidIndexException {
        airlineService.sortPassengerAircraft(airlineTT, new FuelConsumptionComparator());
        Iterator<Aircraft> actualIterator = airlineTT.passengerAircraftsIterator();
        boolean isSorted = false;
        if(!actualIterator.hasNext()) {
            isSorted = true;
        }
        Aircraft aircraftFirst = actualIterator.next();
        Aircraft aircraftSecond;
        while(actualIterator.hasNext()) {
            aircraftSecond = actualIterator.next();
            if(new FuelConsumptionComparator().compare(aircraftFirst, aircraftSecond) == -1) {
                isSorted = true;
            }
            aircraftFirst = aircraftSecond;
        }
        assertEquals(true, isSorted);

    }
    @Test(expected = IllegalFuelConsumptionException.class)
    public void checkNegativeLimitForFuelException() throws IllegalFuelConsumptionException {
        airlineService.searchFuelConsumptionRange(airlineTT, -5, 800);
    }

    @Test(expected = InvalidIndexException.class)
    public void checkGetNegativeIndex() throws InvalidIndexException {
        airlineTT.get(-1);
    }

    @Test(expected = UnsupportedCategoryException.class)
    public void checkUnsupportedCategoryException() throws UnsupportedCategoryException {
        InputData inputData = new InputData();
        String line = "helicopter123d, Eurocopter EC 135, 620, 239, 209, 1.498, 6";
        inputData.readAircraftParams(line);
    }

}