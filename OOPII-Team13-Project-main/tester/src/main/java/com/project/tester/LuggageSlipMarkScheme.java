package com.project.tester;

import java.util.ArrayList;

public class LuggageSlipMarkScheme extends MarkScheme{
    private ArrayList<Test> tests;
    private int score;
    private String filename;
    LuggageSlipMarkScheme(String file){
        score = 0;
        this.filename = file;
        tests = new ArrayList<Test>();
        tests.add(new AttributeTest("private","Passenger","owner",filename));
        tests.add(new AttributeTest("private","int","luggageSlipIDCounter",filename));
        tests.add(new AttributeTest("private","String","luggageSlipID",filename));
        tests.add(new AttributeTest("private","String","label",filename));

        // add method test LuggageSlip (Passenger p, Flight f)
        // add method test LuggageSlip (Passenger p, Flight f, String label)
        // add method test hasOwner (String passportNumber)
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
        return String.format("LuggageSlip Class : %d/14", execute());
    }
}