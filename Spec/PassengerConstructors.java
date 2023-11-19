    
    Passenger(String passportNumber,String firstName, String lastName, String flightNo)
        this.passportNumber = passportNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.flightNo = flightNo;
        Random rand = new Random();
        this.numLuggage = rand.nextInt(3);
        assignRandomCabinClass();

