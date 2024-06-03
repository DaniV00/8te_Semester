package Exercise4;

import exercise4.Flight;
import exercise4.FlightSchedule;
import exercise4.Passenger;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;

public class ScheduleTest {
    private FlightSchedule schedule;
    private Passenger passenger1;
    private Passenger passenger2;
    private Flight flight1;
    private Flight flight2;

    @BeforeEach
    public void setup() {
        schedule = new FlightSchedule();
        passenger1 = new Passenger("1001", "TestPassenger1", "TestPassenger1@test.com");
        passenger2 = new Passenger("1002", "TestPassenger2", "TestPassenger2@test.com");

        flight1 = new Flight("OOP201", "Berlin", "Paris",
                LocalDateTime.of(2024, Month.APRIL, 2, 10, 4),
                LocalDateTime.of(2024, Month.APRIL, 2, 14, 20)
        );
        flight2 = new Flight("OOP202", "Paris", "London",
                LocalDateTime.of(2024, Month.APRIL, 2, 15, 34),
                LocalDateTime.of(2024, Month.APRIL, 2, 16, 40)
        );
        schedule.addFlight(flight1);
        schedule.addFlight(flight2);
    }

    @Test
    public void testMakeReservation() {
        schedule.makeReservation(flight1.getFlightNumber(), passenger1);
        schedule.makeReservation(flight2.getFlightNumber(), passenger1);
        schedule.makeReservation(flight2.getFlightNumber(), passenger2);

        var routesMap = schedule.getPassengerRoutes();
        assertTrue(routesMap.get(passenger1).contains(flight1));
        assertTrue(routesMap.get(passenger1).contains(flight2));
        assertTrue(routesMap.get(passenger2).contains(flight2));
        assertFalse(routesMap.get(passenger2).contains(flight1));
    }

    @Test
    public void testBoardFlight() {
        schedule.makeReservation(flight1.getFlightNumber(), passenger1);
        var missing = flight1.getMissingPassengers();
        assertTrue(missing.contains(passenger1));
        assertTrue(flight1.boardFlight(passenger1));
        missing = flight1.getMissingPassengers();
        assertFalse(missing.contains(passenger1));
    }

    @Test
    public void testValidateRoute() {
        schedule.makeReservation(flight1.getFlightNumber(), passenger1);
        schedule.makeReservation(flight2.getFlightNumber(), passenger1);
        var routesMap = schedule.getPassengerRoutes();
        var isValid = schedule.validateRoute(routesMap.get(passenger1));
        assertTrue(isValid);
    }

    @Test
    public void testFlightStatistics() {
        schedule.makeReservation(flight1.getFlightNumber(), passenger1);
        schedule.makeReservation(flight2.getFlightNumber(), passenger1);
        schedule.makeReservation(flight2.getFlightNumber(), passenger2);
        var flightMap = schedule.getFlightStatistics();
        assertTrue(flightMap.get(flight1) == 1);
        assertTrue(flightMap.get(flight2) == 2);
    }

    @Test
    public void testDailyPassengerCount() {
        schedule.makeReservation(flight1.getFlightNumber(), passenger1);
        schedule.makeReservation(flight2.getFlightNumber(), passenger1);
        schedule.makeReservation(flight2.getFlightNumber(), passenger2);
        var dailyMap = schedule.getDailyPassengerCount();
        assertTrue(dailyMap.get(LocalDate.of(2024, Month.APRIL, 2)) == 3);
    }

    @Test
    public void testPassengerCountPerDestination() {
        schedule.makeReservation(flight1.getFlightNumber(), passenger1);
        schedule.makeReservation(flight2.getFlightNumber(), passenger1);
        schedule.makeReservation(flight2.getFlightNumber(), passenger2);
        var destinationMap = schedule.getPassengerCountPerDestination();
        assertTrue(destinationMap.get("London") == 2);
        assertTrue(destinationMap.get("Paris") == 1);
    }
}
