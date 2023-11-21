package com.project.tester;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class LuggageManifestTest {

    private LuggageManifest testLuggageManifest;
    private Flight sampleFlight;
    private Passenger samplePassenger;

    @BeforeEach
    public void initializeTestData() {
        testLuggageManifest = new LuggageManifest();
        LocalDateTime dateTime = LocalDateTime.of(2024, 5, 15, 14, 0);
        sampleFlight = new Flight("FL123", "Paris", "London", dateTime);
        samplePassenger = new Passenger("PAX456", "Jane", "Doe", "FL123");
    }

    @Test
    public void testDataAddLuggage() {
        String addLuggageResult = testLuggageManifest.addLuggage(samplePassenger, sampleFlight);
        assertFalse(addLuggageResult.isEmpty());
    }

    @Test
    public void testDataExcessLuggageCost() {
        double excessLuggageCost = testLuggageManifest.getExcessLuggageCost(7, 4);
        assertEquals(90, excessLuggageCost);
    }

    @Test
    public void testDataExcessLuggageCostByPassenger() {
        testLuggageManifest.addLuggage(samplePassenger, sampleFlight);
        String excessLuggageCost = testLuggageManifest.getExcessLuggageCostByPassenger("PAX456");
        assertFalse(excessLuggageCost.isEmpty());
    }

    @Test
    public void testDataToString() {
        testLuggageManifest.addLuggage(samplePassenger, sampleFlight);
        String manifestString = testLuggageManifest.toString();
        assertFalse(manifestString.isEmpty());
    }

    @Test
    public void testDataGetSlips() {
        testLuggageManifest.addLuggage(samplePassenger, sampleFlight);
        ArrayList<LuggageSlip> slips = testLuggageManifest.getSlips();
        assertNotNull(slips);
    }
}
