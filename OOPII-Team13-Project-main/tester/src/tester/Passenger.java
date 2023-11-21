package com.project.tester;
import java.util.Random;
public class Passenger
{
    // instance variables - replace the example below with your own
    public String passportNumber;
    public String flightNo;
    public String firstName;
    public String lastName;
    public int numLuggage;
    public char cabinClass;

    public String getPassportNumber(){
        return passportNumber;
    }
    
    public String getFlightNo(){
        return flightNo;
    }
    
    public String getFirstName(){
        return firstName;
    }
    
        public String getLastName(){
        return lastName;
    }
    
    public int readNumLuggage(){
        return numLuggage;
    }
    
    public char toCharCc(){
        return cabinClass;
    }
        
    // Constructor for objects of class Passenger
    public Passenger(String passportNumber, String firstName, String lastName, 
    String flightNo)
    {
        // initialise instance variables
        setPassportNumber(passportNumber);
        setFlightNo(flightNo);
        setFirstName(firstName);
        setLastName(lastName);
        assignRandomCabinClass( );
    }
    //Mutators-fix every same string value
    private void setPassportNumber(String value)
    { 
           passportNumber = value;  
    } 
    
    private void setFlightNo(String value)
    {
           flightNo = value;  
    }
    
    private void setFirstName(String value)
    { 
           firstName = value;  
    }
    
    private void setLastName(String value)
    { 
           lastName = value;  
    }
    
    public void assignRandomCabinClass( )
    {
        Random r;
        r= new Random();
        int cabinRandomInteger;
        cabinRandomInteger=r.nextInt(3);
        numLuggage = r.nextInt(3);
        if (cabinRandomInteger==0)
        {
            cabinClass='F';
        }
        else if (cabinRandomInteger==1)
        {
            cabinClass='B';
        }
        else if (cabinRandomInteger==2)
        {
            cabinClass='P';
        }
        else if (cabinRandomInteger==3)
        {
            cabinClass='E';
        }
        return;
    }
    
    public String toString( )
    {
        String name= getFirstName().substring(0,1)+"."+getLastName();
        String details= "PP NO: "+getPassportNumber()+" Name: "+name+" NUMLUGGAGE: "+readNumLuggage()+" CLASS: "+toCharCc();
        return details;
    }
}
