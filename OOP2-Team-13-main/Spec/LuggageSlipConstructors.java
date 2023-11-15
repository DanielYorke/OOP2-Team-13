    LuggageSlip (Passenger p, Flight f)
        this.label = "";
        this.owner = p;
        this.luggageSlipID = f.getFlightNo() + "_" + p.getLastName() + "_" + luggageSlipIDCounter;
        luggageSlipIDCounter ++;

    LuggageSlip (Passenger p, Flight f, String label)
        this.label = label;
        this.owner = p;
        this.luggageSlipID = f.getFlightNo() + "_" + p.getLastName() + "_" + luggageSlipIDCounter;
        luggageSlipIDCounter ++;
    
