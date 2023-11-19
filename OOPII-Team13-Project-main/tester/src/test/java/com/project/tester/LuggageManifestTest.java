package com.project.tester;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class LuggageManifestTest {

    private LuggageManifest luggageManifest;
    private Flight testFlight;
    private Passenger testPassenger;

    @BeforeEach
    public void setUp() {
        luggageManifest = new LuggageManifest();
        LocalDateTime flightDateTime = LocalDateTime.now();
        testFlight = new Flight("ABC123", "Destination", "Origin", flightDateTime);
        testPassenger = new Passenger("AB123456", "John", "Doe", "ABC123");
    }

    @Test
    public void testAddLuggage() {
        // Add luggage for a passenger and flight
        String addLuggageResult = luggageManifest.addLuggage(testPassenger, testFlight);

        // Ensure luggage is added successfully
        assertFalse(addLuggageResult.isEmpty());
    }

    @Test
    public void testGetExcessLuggageCost() {
        // Test excess luggage cost calculation
        double excessLuggageCost = luggageManifest.getExcessLuggageCost(5, 3);

        // Ensure excess luggage cost is calculated correctly
        assertEquals(70, excessLuggageCost);
    }

    @Test
    public void testGetExcessLuggageCostByPassenger() {
        // Add luggage for a passenger and flight
        luggageManifest.addLuggage(testPassenger, testFlight);

        // Test getting excess luggage cost for a specific passenger
        String excessLuggageCost = luggageManifest.getExcessLuggageCostByPassenger("AB123456");

        // Ensure excess luggage cost for the passenger is retrieved correctly
        assertFalse(excessLuggageCost.isEmpty());
    }

    @Test
    public void testToString() {
        // Add luggage for a passenger and flight
        luggageManifest.addLuggage(testPassenger, testFlight);

        // Test string representation of the luggage manifest
        String manifestString = luggageManifest.toString();

        // Ensure the string representation is not empty
        assertFalse(manifestString.isEmpty());
    }

    @Test
    public void testGetSlips() {
        // Add luggage for a passenger and flight
        luggageManifest.addLuggage(testPassenger, testFlight);

        // Test getting the list of slips from the luggage manifest
        ArrayList<LuggageSlip> slips = luggageManifest.getSlips();

        // Ensure the list of slips is not null
        assertNotNull(slips);
    }
}
