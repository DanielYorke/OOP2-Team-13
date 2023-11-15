//816019400
//Daniel Yorke
import java.util.Random;

public class Passenger
{
    private String passportNumber;
    private String flightNo;
    private String firstName;
    private String lastName;
    private int numLuggage;
    private char cabinClass;
    
    Passenger(String passportNumber ,String firstName, String lastName, String flightNo){
        this.passportNumber = passportNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.flightNo = flightNo;
        Random rand = new Random();
        this.numLuggage = rand.nextInt(3);
        assignRandomCabinClass();
        
    }
    
    public void assignRandomCabinClass( ){
        char[] cabinClasses= {'F','B','P','E'};
        Random rand = new Random();
        this.cabinClass = cabinClasses[rand.nextInt(3)];
        
    }
    
    public String toString(){
        String output = new String();
        output = String.format("PP NO. %s NAME: %c.%s NUMLUGGAGE: %d CLASS: %c",getPassportNumber(), getFirstName().charAt(0),getLastName(), getNumLuggage(),getCabinClass());
        return output;
    }
        
    
    public boolean equalsFlight(String obj){
        if(this.flightNo.equals(obj)){
            return true;
        }
        return false;
    }
    
    // accessors
    
    public String getPassportNumber(){
        return this.passportNumber;
    }
    
    public String getFlightNo(){
        return this.flightNo;
    }
    
    public String getFirstName(){
        return this.firstName;
    }
    
    public String getLastName(){
        return this.lastName;
    }
    
    public int getNumLuggage(){
        return numLuggage;
    }
    
    public char getCabinClass(){
        return cabinClass;
    }
    
}
