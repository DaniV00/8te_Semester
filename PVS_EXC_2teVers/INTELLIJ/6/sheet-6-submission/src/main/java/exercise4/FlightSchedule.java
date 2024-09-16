package exercise4;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FlightSchedule {
    HashMap<String, Flight > flightAndNr;
    HashMap<Reservation,Passenger > passengerAndRes;
    int resid = 0;


    public void addFlight(Flight flight) {
    flightAndNr.put(flight.getFlightNumber(), flight);
         }

    public Flight getFlight(String flightNumber) {
        return flightAndNr.get(flightNumber);
    }

    public Reservation makeReservation(String flightNumber, Passenger passenger) {
        Reservation res = new Reservation(String.valueOf(resid), flightNumber, passenger.getPassengerId(), LocalDateTime.now() );
        resid++;
        passengerAndRes.put(res,passenger);
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
