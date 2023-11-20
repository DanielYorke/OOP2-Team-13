package com.project.tester;

import java.util.ArrayList;

public class PassenngerMarkScheme extends MarkScheme{
    private ArrayList<Test> tests;
    private int score;
    private String filename;
    PassenngerMarkScheme(String file){
        this.filename = file;
        score = 0;
        tests = new ArrayList<Test>();

        //private
        tests.add(new AttributeTest("private","String","passportNumber",filename));
        tests.add(new AttributeTest("private","String","flightNo",filename));
        tests.add(new AttributeTest("private","String","firstName",filename));
        tests.add(new AttributeTest("private","String","lastName",filename));
        tests.add(new AttributeTest("private","int","numLuggage",filename));
        tests.add(new AttributeTest("private","char","cabinClass",filename));
        // add method test Passenger (String, passportNumber, String, firstName, String lastName,String flightNo)
        // add method test assignRandomCabinClass( )
        // add method test toString()
    }
    public int execute(){
        for(Test t: tests){
            score += t.execute();
        }
        return score;
    }
    public void addTest(Test t){
        tests.add(t);
    }
    public void removeTest(Test t){
        tests.remove(t);
    }
    public String toString(){
        return String.format("Passenger Class : %d/16", execute());
    }
    // public static void main(String[] args) {
    //     System.out.println("\tPasseneger mark scheme test");
    //     PassenngerMarkScheme t = new PassenngerMarkScheme("Passenger.java");
    //     System.out.println("\t pass instantation Passeneger mark scheme test");
        
    //     System.out.println(t.execute());
    // }
}
