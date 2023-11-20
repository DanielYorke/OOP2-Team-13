package com.project.tester;

import java.util.ArrayList;

public class BasicMarkScheme implements Test{
    private int score;
    private ArrayList<Test> tests;
    BasicMarkScheme(){
        score = 0;
        tests = new ArrayList<Test>();
    }
    public  int execute(){
        for(Test t: tests){
            score += t.execute();
        }
        return score;
    }
    public  void addTest(Test t){
        tests.add(t);
    }
    public  void removeTest(Test t){
        tests.add(t);
    }
    public String toString() {
        String output = "";
        for(Test t : tests){
            output += t.toString() + "\n";
        }
        output += String.format("Grade : %d/100", execute());
        return output;
    }
}