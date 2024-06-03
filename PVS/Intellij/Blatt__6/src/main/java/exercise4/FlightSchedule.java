package main.java.exercise4;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class FlightSchedule {
    public void addFlight(Flight flight) {
        // TODO in exercise a
    }

    public Flight getFlight(String flightNumber) {
        // TODO in exercise a
        return null;
    }

    public Reservation makeReservation(String flightNumber, Passenger passenger) {
        // TODO in exercise a
        return null;
    }

    public Map<Passenger, List<Flight>> getPassengerRoutes() {
        // TODO in exercise d
        return null;
    }

    public static boolean validateRoute(List<Flight> rout) {
        // TODO in exercise e
        return false;
    }

    public Map<Flight, Integer> getFlightStatistics() {
        // TODO in exercise f
        return null;
    }

    public Map<LocalDate, Integer> getDailyPassengerCount() {
        // TODO in exercise g
        return null;
    }

    public Map<String, Integer> getPassengerCountPerDestination() {
        // TODO in exercise h
        return null;
    }
}
