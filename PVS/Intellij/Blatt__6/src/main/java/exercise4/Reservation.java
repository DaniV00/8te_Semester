package main.java.exercise4;

import java.time.LocalDateTime;
import java.util.List;

public class Reservation {
    private final String reservationId;
    private final String flightNumber;
    private final String passengerId;
    private final LocalDateTime reservationTime;

    public Reservation(String reservationId, String flightNumber, String passengerId, LocalDateTime reservationTime) {
        this.reservationId = reservationId;
        this.flightNumber = flightNumber;
        this.passengerId = passengerId;
        this.reservationTime = reservationTime;
    }

    public String getReservationId() {
        return reservationId;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public String getPassengerId() {
        return passengerId;
    }

    public LocalDateTime getReservationTime() {
        return reservationTime;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "reservationId='" + reservationId + '\'' +
                ", flightNumber='" + flightNumber + '\'' +
                ", passengerId='" + passengerId + '\'' +
                ", reservationTime=" + reservationTime +
                '}';
    }
}
