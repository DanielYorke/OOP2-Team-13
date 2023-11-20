package com.project.tester;

import java.util.ArrayList;

public class FlightMarkScheme extends MarkScheme{
    private ArrayList<Test> tests;
    private int score;
    private String filename;
    FlightMarkScheme(String file){
        score = 0;
        filename = file;
        tests.add(new AttributeTest("private","Passenger","flightNo",filename));
        tests.add(new AttributeTest("private","int","destination",filename));
        tests.add(new AttributeTest("private","String","origin",filename));
        tests.add(new AttributeTest("private","LocalDateTime","flightDate",filename));
        tests.add(new AttributeTest("private","LuggageManifest","manifest",filename));

        // add method Flight test methods
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
}