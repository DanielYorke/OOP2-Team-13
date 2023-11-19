package com.project.tester;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import static org.mockito.Mockito.*;

public class LuggageManagementSystemTest {

    @Test
    public void testLuggageManagementSystem_Main() throws FileNotFoundException {

        File mockedFile = Mockito.mock(File.class);
        Scanner mockedScanner = Mockito.mock(Scanner.class);

        String flightFileContent = "ABC123 Destination Origin\nDEF456 Destination2 Origin2";
        String passengerFileContent = "Passenger1 John Doe ABC123\nPassenger2 Jane Smith DEF456";


        when(mockedFile.exists()).thenReturn(true);
        when(mockedScanner.hasNextLine()).thenReturn(true, false); 
        when(mockedScanner.nextLine()).thenReturn(flightFileContent, passengerFileContent); 

        whenNew(File.class).withAnyArguments().thenReturn(mockedFile);
        whenNew(Scanner.class).withAnyArguments().thenReturn(mockedScanner);

        LuggageManagementSystem.main(new String[0]);

        verify(mockedFile, times(2)).exists(); 
        verify(mockedScanner, times(4)).hasNextLine(); 
        verify(mockedScanner, times(4)).nextLine(); 
        
        // Add more assertions or verifications based on the expected behavior For example, check certain outputs or specific method calls in the LuggageManagementSystem.main method
    }
}
