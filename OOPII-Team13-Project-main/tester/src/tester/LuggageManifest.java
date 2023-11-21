package com.project.tester;
//816019400
//Daniel Yorke
import java.util.ArrayList;
public class LuggageManifest{
    private  ArrayList<LuggageSlip> slips;
       
    LuggageManifest(){
        slips = new ArrayList<LuggageSlip>();
    }
    //flag
    public String addLuggage(Passenger p, Flight f){
           
           String output = new String();
           LuggageSlip l;
           for(int i = 0; i < p.readNumLuggage();i++){
               LuggageSlip lug = new LuggageSlip(p,f);
               this.slips.add(lug);
               output += lug.toString();
               output += " " + getExcessLuggageCostByPassenger(p.getPassportNumber());
               output += "\n";
           }
           return output;
    }
    
    public double getExcessLuggageCost( int numPieces, int numAllowedPieces){
           double cost = 0;
           if(numPieces > numAllowedPieces){
               cost += (numPieces - numAllowedPieces) * 35;
           }
           return cost;
    }
    
    public String getExcessLuggageCostByPassenger(String passportNumber){
        String output = new String();
        output ="";
            for(LuggageSlip s : slips){
               // searches for passanger with same passport number
               if (s.hasOwner(passportNumber)){
                   //find cost of excess luggage
                   Passenger p = s.getPassenger();
                   double  cost = getExcessLuggageCost(p.readNumLuggage() , Flight.getAllowedLuggage(p.cabinClass));
                   if( cost > 0){
                       output += String.format(" %.2f", cost);
                       return output;
                   }
               }
           }
           output = "No Cost";
           return output;
        }
          

   public String toString(){
       String output = new String();
       output = "";
       for( LuggageSlip slip : slips){
           output += slip.toString();
           output += " " + getExcessLuggageCostByPassenger(slip.getPassenger().getPassportNumber());
           output += "\n";
        }
        return output;
   }
   
    //accessors
   public ArrayList getSlips(){
       return this.slips;
   }
}
