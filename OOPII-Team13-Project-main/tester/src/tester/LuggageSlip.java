package com.project.tester;
//816019400
//Daniel Yorke
public class LuggageSlip{
    private Passenger owner ;
    private static int luggageSlipIDCounter = 1;
    private String luggageSlipID;
    private String label;
    
    
    
    LuggageSlip (Passenger p, Flight f){
        
        this.label = "";
        this.owner = p;
        this.luggageSlipID = f.getFlightNo() + "_" + p.getLastName() + "_" + luggageSlipIDCounter;
        luggageSlipIDCounter ++;
        
    }
    
    LuggageSlip (Passenger p, Flight f, String label){
        this.label = label;
        this.owner = p;
        this.luggageSlipID = f.getFlightNo() + "_" + p.getLastName() + "_" + luggageSlipIDCounter;
        luggageSlipIDCounter ++;
    }
    
    public boolean hasOwner (String passportNumber) {
        if(this.owner.getPassportNumber().equals(passportNumber)){
            return true;
        }
        return false;
    }
    
    public String toString(){
        String output = new String();
        output = String.format("%s PP NO. %s NAME: %c.%s NUMLUGGAGE: %d CLASS: %c",this.luggageSlipID ,owner.getPassportNumber(), owner.getFirstName().charAt(0), owner.getLastName(), owner.readNumLuggage(), owner.cabinClass);
        if(! label.equals("")){
            output += " $105";
        }
        return output;
    }
    
    // accessors 
    
    public Passenger getPassenger(){
        return this.owner;
    }
    
    public int getLuggageSlipIDCounter(){
        return this.luggageSlipIDCounter;
    }
    
    public String getLuggageSlipID(){
        return this.luggageSlipID;
    }
    
    public String getLabel(){
        return this.label;
    }
    

}