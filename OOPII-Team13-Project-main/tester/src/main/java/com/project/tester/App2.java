package com.project.tester;

public class App2 {
    public static void main(String[] args) {
        BasicMarkScheme markScheme = new BasicMarkScheme();
        markScheme.addTest(new PassenngerMarkScheme("Passenger.java"));
        markScheme.addTest(new LuggageSlipMarkScheme("LuggageSlip.java"));
        markScheme.addTest(new LuggageManifestMarkScheme("LuggageManifest.java"));;
        markScheme.addTest(new FlightMarkScheme("Flight.java"));
        System.out.println(markScheme);
    }
}
