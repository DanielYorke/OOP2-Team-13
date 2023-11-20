package com.project.tester;

import java.util.ArrayList;

public class LuggageManifestMarkScheme extends MarkScheme{
    private ArrayList<Test> tests;
    private int score;
    private String filename;
    LuggageManifestMarkScheme(String file){
        score = 0;
        filename = file;
        tests = new ArrayList<Test>();
        //adding 2 because this test is worth 2 marks but AttributeTest only returns 1 score
        tests.add(new AttributeTest("private","ArrayList<LuggageSlip>","slips",filename));
        tests.add(new AttributeTest("private","ArrayList<LuggageSlip>","slips",filename));

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
    public String toString(){
        return String.format("LuggageManifest Class : %d/20", execute());
    }
}