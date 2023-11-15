public class LuggageSlip
    private Passenger owner;
    private static int luggageSlipIDCounter;
    private String luggageSlipID;
    private String label;
    
    
    
    LuggageSlip (Passenger p, Flight f)
    
    LuggageSlip (Passenger p, Flight f, String label)

    public boolean hasOwner (String passportNumber) 
    
    public String toString()

    public Passenger getPassenger()
    
    public int getLuggageSlipIDCounter()
    
    public String getLuggageSlipID()
    
    public String getLabel()