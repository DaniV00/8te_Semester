package main.java.exercise4;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;

public class Flight {
    private final String flightNumber;
    private final String origin;
    private final String destination;
    private final LocalDateTime departureTime;
    private final LocalDateTime arrivalTime;
    public FlightSchedule sched = new FlightSchedule();


    public Flight(String flightNumber, String origin, String destination, LocalDateTime departureTime, LocalDateTime arrivalTime) {
        this.flightNumber = flightNumber;
        this.origin = origin;
        this.destination = destination;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
    }

    public boolean boardFlight(Passenger passenger) {
        FlightSchedule sched = new FlightSchedule();
        boolean canBoard;
        if(sched.reservePass.containsValue(passenger)) {
             canBoard = true;
        }
        else {

             canBoard = false;
        }
        System.out.println(sched.reservePass);

        System.out.println(canBoard);
        return canBoard;
    }

    public List<Passenger> getMissingPassengers() {
        // TODO in exercise c
        return null;
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
