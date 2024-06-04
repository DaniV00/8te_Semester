package main.java.exercise4;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FlightSchedule {

    HashMap<String,Flight> flightsHash = new HashMap<>();
    Flight flight;
    int reserveID = 0;
    HashMap<Reservation,Passenger> reservePass = new HashMap<>();


    public void addFlight(Flight flight) {
        flightsHash.put(flight.getFlightNumber(), flight);
        flight = new Flight(flight.getFlightNumber(),flight.getOrigin(),flight.getDestination(),flight.getDepartureTime(),flight.getArrivalTime());
        this.flight = flight;
    }

    public Flight getFlight(String flightNumber) {
        Flight flightTemp = flightsHash.get(flightNumber);
        return flightTemp;
    }

    public Reservation makeReservation(String flightNumber, Passenger passenger) {
        String stringResID = String.valueOf(reserveID);
        Reservation reserve = new Reservation(stringResID,flightNumber, passenger.getPassengerId(), LocalDateTime.now());
        reservePass.put(reserve,passenger);
        System.out.println(stringResID);
        System.out.println(reservePass);
        reserveID = reserveID +1;


        return reserve;//

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
