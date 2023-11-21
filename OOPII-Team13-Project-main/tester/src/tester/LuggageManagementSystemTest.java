package com.project.tester;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import static org.mockito.Mockito.*;

public class LuggageManagementSystemTest {

    @Test
    public void testDataProcessing_Main() throws FileNotFoundException {

        File mockedDataFile = Mockito.mock(File.class);
        Scanner mockedDataScanner = Mockito.mock(Scanner.class);

        String flightInfo = "FLG123 CityA CityB\nFLG456 CityX CityY";
        String passengerInfo = "PassengerOne Alice Smith FLG123\nPassengerTwo Bob Johnson FLG456";

        when(mockedDataFile.exists()).thenReturn(true);
        when(mockedDataScanner.hasNextLine()).thenReturn(true, false);
        when(mockedDataScanner.nextLine()).thenReturn(flightInfo, passengerInfo);

        whenNew(File.class).withAnyArguments().thenReturn(mockedDataFile);
        whenNew(Scanner.class).withAnyArguments().thenReturn(mockedDataScanner);

        LuggageManagementSystem.main(new String[0]);

        verify(mockedDataFile, times(2)).exists();
        verify(mockedDataScanner, times(4)).hasNextLine();
        verify(mockedDataScanner, times(4)).nextLine();
    }
}
