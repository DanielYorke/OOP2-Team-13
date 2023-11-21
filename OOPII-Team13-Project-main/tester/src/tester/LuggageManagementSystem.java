package com.project.tester;
// 816019400
// Daniel Yorke

import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.time.LocalDateTime;

public class LuggageManagementSystem{
    
        public static void main(String[] args){
            ArrayList<Flight> flights = new ArrayList<Flight>();
            ArrayList<Passenger> passengers = new ArrayList<Passenger>();
            //ArrayList<String> data = new ArrayList<String>(); // store line in array
            LocalDateTime d = LocalDateTime.of(2023,1,23,10,00,00);
            
            String line = new String();
            try{
                String filename = "FlightList.txt";
                File file = new File(filename);
                Scanner inFile = new Scanner(file);
                
                while(inFile.hasNextLine()){
                    //read data from file
                    line =  inFile.nextLine();
                    String[] strSplit = line.split(" ", 3);
                    ArrayList<String> data = new ArrayList<String>(Arrays.asList(strSplit));
                    
                    //put data into system
                    flights.add(new Flight(data.get(0), data.get(1) , data.get(2) , d));
                }
                //System.out.println("Flight file close");
                inFile.close();
            }
            catch(FileNotFoundException e){
                //Flight file not found!
                System.out.println("Flight file not fond!");
            }
            try{
                String filename = "PassengerList.txt";
                File file = new File(filename);
                Scanner inPassenger = new Scanner(file);
                while(inPassenger.hasNextLine()){
                    // read file line
                    int i = 0;
                    line =  inPassenger.nextLine();

                    String[] strSplit = new String[4];
                    strSplit = line.split("\\s", 4);
                    ArrayList<String> data2 = new ArrayList<String>(Arrays.asList(strSplit));
                    
                    //add flight No to text files.
                    passengers.add(new Passenger(data2.get(0),data2.get(1),data2.get(2),data2.get(3)));
                }
                
                inPassenger.close();
                //System.out.println("Passenger file close");
            }
            catch(FileNotFoundException e){
                System.out.println("Flight passenger not fond!");
            }
            
            for(Passenger p : passengers){
                System.out.println(p);
                
                for(Flight f : flights){
                    //find which flight passenger p is on
                    if(p.flightNo==(f.getFlightNo())){

                        System.out.println(f.checkInLuggage(p));
                    }
                }
                
                
            }

            for(Flight f : flights){
                System.out.println(f.printLuggageManifest());
            }
            
    }
}



