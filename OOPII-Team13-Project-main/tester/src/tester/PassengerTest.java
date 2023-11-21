package com.project.tester;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class PassengerTest {

    @Test
    public void testConstructor() {
        Passenger samplePassenger = new Passenger("XY789012", "Alice", "Doe", "FL345");

        assertEquals("XY789012", samplePassenger.getPassportNumber());
        assertEquals("FL345", samplePassenger.getFlightNo());
        assertEquals("Alice", samplePassenger.getFirstName());
        assertEquals("Doe", samplePassenger.getLastName());
    }

    @Test
    public void testNumLuggage(){
        Passenger samplePassenger = new Passenger("Z1234567", "John", "Smith", "FL678");
        assertInstanceOf(int.class, samplePassenger.readNumLuggage());
    }

    @Test
    public void testRandomCabinClass() {
        Passenger samplePassenger = new Passenger("AB234567", "Jane", "Johnson", "FL901");

        char cabinClass = samplePassenger.cabinClass;
        assertTrue(cabinClass == 'F' || cabinClass == 'B' || cabinClass == 'P' || cabinClass == 'E');
    }

    @Test
    public void testToString() {
        Passenger samplePassenger = new Passenger("CD890123", "Emma", "Wilson", "FL234");

        String expectedOutput = "PP NO: CD890123 Name: E.Wilson NUMLUGGAGE: " + samplePassenger.readNumLuggage() + " CLASS: " + samplePassenger.cabinClass;
        assertEquals(expectedOutput, samplePassenger.toString());
    }
}

