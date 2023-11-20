package com.project.tester;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.*;
import java.time.LocalDateTime;


public class FlightTest {

    @Test
    public void testCheckInLuggage_ValidFlight() {
        // Create a flight instance
        LocalDateTime flightDateTime = LocalDateTime.now();
        Flight testFlight = new Flight("ABC123", "Destination", "Origin", flightDateTime);
        
        // Create a passenger and check-in luggage for the valid flight
        Passenger testPassenger = new Passenger("AB123456", "John", "Doe", "FL123");
        String checkInStatus = testFlight.checkInLuggage(testPassenger);

        // Ensure luggage check-in is successful for the valid flight
        assertEquals("Luggage checked in successfully", checkInStatus.toString());
    }

    @Test
    public void testCheckInLuggage_InvalidFlight() {
        // Create a flight instance
        LocalDateTime flightDateTime = LocalDateTime.now();
        Flight testFlight = new Flight("XYZ789", "Destination", "Origin", flightDateTime);

        // Create a passenger and try to check-in luggage for an invalid flight
        Passenger testPassenger = new Passenger("AB123456", "Jane", "Smith", "FL123");
        String checkInStatus = testFlight.checkInLuggage(testPassenger);

        // Ensure luggage check-in fails for the invalid flight
        assertEquals("Invalid Flight", checkInStatus);
    }

    @Test
    public void testGetAllowedLuggage() {
        // Test cases for different cabin classes
        assertEquals(3, Flight.getAllowedLuggage('F'));
        assertEquals(2, Flight.getAllowedLuggage('B'));
        assertEquals(1, Flight.getAllowedLuggage('P'));
        assertEquals(0, Flight.getAllowedLuggage('E'));
        assertEquals(-1, Flight.getAllowedLuggage('X')); // Invalid cabin class
    }

    @Test
    public void testPrintLuggageManifest() {
        // Create a flight instance
        LocalDateTime flightDateTime = LocalDateTime.now();
        Flight testFlight = new Flight("DEF456", "Destination", "Origin", flightDateTime);

        // Ensure printing the luggage manifest produces a non-null string
        assertNotNull(testFlight.printLuggageManifest());
    }

    @Test
    public void testToString() {
        // Create a flight instance
        LocalDateTime flightDateTime = LocalDateTime.of(2023, 11, 19, 10, 30);
        Flight testFlight = new Flight("GHI789", "Destination", "Origin", flightDateTime);

        // Ensure toString() method returns the expected string format
        String expectedOutput = "GHI789 DESTINATION: Destination ORIGIN:Origin 2023-11-19T10:30";
        assertEquals(expectedOutput, testFlight.toString());
    }
}
