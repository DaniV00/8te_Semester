package main.java.exercise4;

import java.time.LocalDateTime;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Flight extends FlightSchedule {
    private final String flightNumber;
    private final String origin;
    private final String destination;
    private final LocalDateTime departureTime;
    private final LocalDateTime arrivalTime;
    public static List<Passenger> boardedPass = new ArrayList<>();



    public Flight(String flightNumber, String origin, String destination, LocalDateTime departureTime, LocalDateTime arrivalTime) {
        this.flightNumber = flightNumber;
        this.origin = origin;
        this.destination = destination;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
    }

    public boolean boardFlight(Passenger passenger) {
        boolean canBoard = false;
        for(Reservation r : reservePass.keySet()){
            if(reservePass.containsValue(passenger) && r.getFlightNumber().equals(flightNumber) && r.getPassengerId() == passenger.getPassengerId()) {
                boardedPass.add(passenger);
                canBoard = true;
            }
            else {

            }
        }

        System.out.println(reservePass);

        System.out.println(canBoard);
        return canBoard;
    }

    public List<Passenger> getMissingPassengers() {
        List<Passenger> missingPassengers = new ArrayList<>();
        reservePass.forEach((reservation, passenger) ->{
            if(!boardedPass.contains(passenger) && reservation.getFlightNumber().equals(flightNumber)){
                missingPassengers.add(passenger);
            }
            else{

            }
        });
        return missingPassengers;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public String getOrigin() {
        return origin;
    }

    public String getDestination() {
        return destination;
    }

    public LocalDateTime getDepartureTime() {
        return departureTime;
    }

    public LocalDateTime getArrivalTime() {
        return arrivalTime;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "flightNumber='" + flightNumber + '\'' +
                ", origin='" + origin + '\'' +
                ", destination='" + destination + '\'' +
                ", departureTime=" + departureTime +
                ", arrivalTime=" + arrivalTime +
                '}';
    }
}
