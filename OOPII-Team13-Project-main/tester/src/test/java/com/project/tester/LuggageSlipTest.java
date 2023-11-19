package com.project.tester;

import static org.junit.Assert.*;
import org.junit.*;


public class LuggageSlipTest {
    private Passenger passenger;
    private Flight flight;
 
    @Before
    public void setUp() {
        // Create sample Passenger and Flight objects for testing
        passenger = new Passenger("John", "Doe", "AB123456", 2, 'E');
        flight = new Flight("ABC123");
    }

    @Test
    public void testLuggageSlipCreation() {
        LuggageSlip luggageSlip = new LuggageSlip(passenger, flight);
        assertNotNull(luggageSlip);
        assertEquals(passenger, luggageSlip.getPassenger());
        assertEquals(flight.getFlightNo() + "_Doe_1", luggageSlip.getLuggageSlipID());
    }

    @Test
    public void testLuggageSlipWithLabelCreation() {
        String label = "Fragile";
        LuggageSlip luggageSlip = new LuggageSlip(passenger, flight, label);
        assertNotNull(luggageSlip);
        assertEquals(passenger, luggageSlip.getPassenger());
        assertEquals(flight.getFlightNo() + "_Doe_2", luggageSlip.getLuggageSlipID());
        assertEquals(label, luggageSlip.getLabel());
    }

    @Test
    public void testHasOwner() {
        LuggageSlip luggageSlip = new LuggageSlip(passenger, flight);
        assertTrue(luggageSlip.hasOwner("AB123456"));
        assertFalse(luggageSlip.hasOwner("CD789012"));
    }

    @Test
    public void testToString() {
        LuggageSlip luggageSlip = new LuggageSlip(passenger, flight);
        String expectedOutput = flight.getFlightNo() + "_Doe_1 PP NO. AB123456 NAME: J.Doe NUMLUGGAGE: 2 CLASS: E";
        assertEquals(expectedOutput, luggageSlip.toString());
    }
}
