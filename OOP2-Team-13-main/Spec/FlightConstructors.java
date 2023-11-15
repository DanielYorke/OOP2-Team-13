    Flight (String flightNo, String destination, String origin, LocalDateTime flightDate)
        this.flightNo = flightNo;
        this.destination = destination;
        this.origin = origin;
        this.flightDate = flightDate;
        manifest = new LuggageManifest();
    
    
    Flight (String flightNo, String destination, String origin, LocalDateTime flightDate, LuggageManifest manifest)
        this.flightNo = flightNo;
        this.destination = destination;
        this.origin = origin;
        this.flightDate = flightDate;
        this.manifest = manifest;
    
    