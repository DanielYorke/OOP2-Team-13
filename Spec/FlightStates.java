//816019400
//Daniel Yorke
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Flight
{
    private String flightNo;
    private String destination;
    private String origin;
    private LocalDateTime flightDate;
    private LuggageManifest manifest;
    
    Flight (String flightNo, String destination, String origin, LocalDateTime flightDate){
        this.flightNo = flightNo;
        this.destination = destination;
        this.origin = origin;
        this.flightDate = flightDate;
        manifest = new LuggageManifest();
    }
    
    Flight (String flightNo, String destination, String origin, LocalDateTime flightDate, LuggageManifest manifest){
        this.flightNo = flightNo;
        this.destination = destination;
        this.origin = origin;
        this.flightDate = flightDate;
        this.manifest = manifest;
    }
    
    
    public String checkInLuggage(Passenger p){
        if(p.equalsFlight(flightNo)){
            Flight f = new Flight(this.flightNo, this.destination , this.origin , this. flightDate, this.manifest);
            return manifest.addLuggage(p,f);
        }
        return "Invalid Flight";
    }
    
    
    public String printLuggageManifest( ){
        return manifest.toString();
    }
    
    public static int getAllowedLuggage( char cabinClass){
        if( cabinClass == 'F')
            return 3;
        if( cabinClass == 'B')
            return 2;
        if( cabinClass == 'P')
            return 1;
        if( cabinClass == 'E')
            return 0;
        return -1;
    }
    
    public String toString(){
        String output = new String();
        output = "";
        output += String.format("%s DESTINATION: %s ORIGIN:%s %s", getFlightNo(), getDestination(), getOrigin(), getFlightDate().toString());
        return output;
    }
    
    
    
    // accessors
    public String getFlightNo(){
        return flightNo;
    }
    
    public String getDestination(){
        return destination;
    }
    
    public String getOrigin(){
        return origin;
    }
    
    public LocalDateTime getFlightDate(){
        return flightDate;
    }
    
    public LuggageManifest getManifest(){
        return manifest;
    }
}
