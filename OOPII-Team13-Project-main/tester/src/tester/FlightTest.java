package com.project.tester;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.*;
import java.time.LocalDateTime;

public class FlightTest {

    @Test
    public void luggageTestValid() {
        LocalDateTime dateTime = LocalDateTime.of(2024, 5, 15, 14, 0);
        Flight flight = new Flight("XYZ789", "Paris", "London", dateTime);
        Passenger passenger = new Passenger("PAX123", "Alice", "Smith", "FL789");
        String luggageStatus = flight.checkInLuggage(passenger);
        assertEquals("Luggage checked in successfully", luggageStatus);
    }

    @Test
    public void luggageTestInvalid() {
        LocalDateTime dateTime = LocalDateTime.of(2022, 3, 8, 8, 30);
        Flight flight = new Flight("ABC123", "Berlin", "Madrid", dateTime);
        Passenger passenger = new Passenger("PAX456", "Bob", "Johnson", "FL456");
        String luggageStatus = flight.checkInLuggage(passenger);
        assertEquals("Invalid Flight", luggageStatus);
    }

    @Test
    public void allowedLuggageTest() {
        assertEquals(3, Flight.getAllowedLuggage('F'));
        assertEquals(2, Flight.getAllowedLuggage('B'));
        assertEquals(1, Flight.getAllowedLuggage('P'));
        assertEquals(0, Flight.getAllowedLuggage('E'));
        assertEquals(-1, Flight.getAllowedLuggage('X'));
    }

    @Test
    public void luggageManifestTest() {
        LocalDateTime dateTime = LocalDateTime.now();
        Flight flight = new Flight("DEF456", "Tokyo", "New York", dateTime);
        assertNotNull(flight.printLuggageManifest());
    }

    @Test
    public void testToString() {
        LocalDateTime dateTime = LocalDateTime.of(2023, 11, 19, 10, 30);
        Flight flight = new Flight("GHI789", "Sydney", "Auckland", dateTime);
        String expectedOutput = "GHI789 DESTINATION: Sydney ORIGIN:Auckland 2023-11-19T10:30";
        assertEquals(expectedOutput, flight.toString());
    }
}
