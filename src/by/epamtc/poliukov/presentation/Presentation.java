package by.epamtc.poliukov.presentation;

import by.epamtc.poliukov.entity.Aircraft;
import by.epamtc.poliukov.entity.Airline;

import java.util.Iterator;

public class Presentation {

    public void printAllAircrafts(Airline airline) {
        Iterator<Aircraft> allAircraftsIterator = airline.allAircraftsIterator();
        while (allAircraftsIterator.hasNext()) {
            System.out.print(allAircraftsIterator.next());
        }
    }

    public void printPassengerAircrafts(Airline airline) {
        Iterator<Aircraft> passengerAircraftsIterator = airline.passengerAircraftsIterator();
        while (passengerAircraftsIterator.hasNext()) {
            System.out.print(passengerAircraftsIterator.next());
        }
    }
}
