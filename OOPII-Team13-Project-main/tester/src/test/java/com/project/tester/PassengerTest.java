package com.project.tester;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class PassengerTest {

    @Test
    public void testPassengerConstructor() {
        // Create a passenger instance
        Passenger testPassenger = new Passenger("AB123456", "John", "Doe", "FL123");

        // Ensure the constructor initializes the instance variables correctly
        assertEquals("AB123456", testPassenger.getPassportNumber());
        assertEquals("FL123", testPassenger.getFlightNo());
        assertEquals("John", testPassenger.getFirstName());
        assertEquals("Doe", testPassenger.getLastName());
    }

    @Test
    public void testNumLuggage(){
        Passenger testPassenger = new Passenger("AB123456", "John", "Doe", "FL123");
        assertInstanceOf(int, testPassenger.getNumLuggage());
    }
    
    @Test
    public void testAssignRandomCabinClass() {
        // Create a passenger instance
        Passenger testPassenger = new Passenger("CD789012", "Jane", "Smith", "FL456");

        // Ensure the random cabin class assignment is within the expected range
        char cabinClass = testPassenger.toCharCc();
        assertTrue(cabinClass == 'F' || cabinClass == 'B' || cabinClass == 'P' || cabinClass == 'E');
    }

    @Test
    public void testToString() {
        // Create a passenger instance
        Passenger testPassenger = new Passenger("EF345678", "Alice", "Johnson", "FL789");

        // Ensure the toString() method returns the expected string format
        String expectedOutput = "PP NO: EF345678 Name: A.Johnson NUMLUGGAGE: " + testPassenger.readNumLuggage() + " CLASS: " + testPassenger.toCharCc();
        assertEquals(expectedOutput, testPassenger.toString());
    }
}
