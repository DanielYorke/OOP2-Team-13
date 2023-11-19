    String passportNumber;
    String flightNo;
    String firstName;
    String lastName;
    int numLuggage;
    char cabinClass;

        this.passportNumber = passportNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.flightNo = flightNo;
        Random rand = new Random();
        this.numLuggage = rand.nextInt(3);

