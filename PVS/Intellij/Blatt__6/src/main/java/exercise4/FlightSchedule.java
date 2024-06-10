package main.java.exercise4;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

public class FlightSchedule {

    public static HashMap<String,Flight> flightsHash = new HashMap<>();
    Flight flight;
    int reserveID = 0;
    public static HashMap<Reservation,Passenger> reservePass = new HashMap<>();
    //TODO: REMEMBER THAT THE FUKKN STATIC VALUE ALLOWS THE HASHMAP(OR VARIABLE) TO RETAIN VALUE AMONG CLASSES


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
        System.out.println(reservePass);
        reserveID = reserveID +1;

        return reserve;//

    }



    public Map<Passenger, List<Flight>> getPassengerRoutes() {

        Map<Passenger, List<Flight>>  passroutes = new HashMap<>();
        List<Flight> flightList = new ArrayList<>();
        AtomicBoolean switcher = new AtomicBoolean(false);
        reservePass.forEach(((reservation, passenger) -> {
            flightsHash.forEach(((s, flight1) -> {
                if(s.equals(reservation.getFlightNumber())){
                    flightList.add(flight1);
                    switcher.set(true);

                }
                else{
                }
            }));
            passroutes.put(passenger,flightList);
            switcher.set(false);

        }));


        return passroutes;
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
