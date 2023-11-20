package com.project.tester;

public class FeedBack {
    private int similarityMetric; // aspect type tested
    private double similarity; // value of the evaluation
    private String testType;
    private String similarityMetricChecker ="Similarity Percentage:";
    
    public FeedBack(int similarityMetric, double similarity){
        this.similarityMetric = similarityMetric;
        this.similarity = similarity;
    }
    
    public String getTestType(){
        
        if(similarityMetric == 1){
            testType = "Attributes";
        }
        if(similarityMetric == 2){
            testType = "Class Signature";
        }
        if(similarityMetric == 3){
            testType = "States";
        }
        if(similarityMetric == 4){
            testType = "Access Modifiers";
        }
        if(similarityMetric == 5){
            testType = "Constructors";
        }
        if(similarityMetric == 6){
            testType = "Method Similarity Percentage";
        }
        if(similarityMetric == 7){
            testType = "Relationship Similarity";
        }
        if(similarityMetric == 8){
            testType = "Abstraction Similarity";
        }
        
        return testType;
    }
    
    public String getEvaluationFeedback(){
        String feedbackDetails = "";
        
        if(similarity>=0.8){
            feedbackDetails ="All " + getTestType() + " are Correct. " + similarityMetricChecker + similarity;
        }
        else if(similarity>=0.7){
            feedbackDetails ="Most " + getTestType() + " are Correct. " + similarityMetricChecker + similarity;
        }
        else if(similarity>=0.4){
            feedbackDetails ="Some " + getTestType() + " are Correct. " + similarityMetricChecker + similarity;
        }
        else if(similarity<0.4){
            feedbackDetails ="Barely any " + getTestType() + " are Correct. " +similarityMetricChecker + similarity;
        }
        
        return feedbackDetails;
    }
}
