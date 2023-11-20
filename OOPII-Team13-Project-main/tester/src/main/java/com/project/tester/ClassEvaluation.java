package com.project.tester;

//import java.util.ArrayList;

public abstract class ClassEvaluation
{
    protected String className;
    protected String file1;
    protected String file2;
    protected int currentSimilarityMetric;
    protected TextSimilarityChecker checker;
    protected double evaluation = 0;
    protected FeedBack feedback;
    //protected ArrayList<String> information = new ArrayList<String>();
    
    public ClassEvaluation(int currentSimilarityMetric, String file1, String file2, String classTestName)
    {
        this.className = classTestName;
        this.file1 = file1;
        this.file2 = file2;
        this.currentSimilarityMetric = currentSimilarityMetric;
        this.evaluation = getEvaluation();
    }

    public abstract void setEvaluator();
    
    public double getEvaluation(){
        double calculation;
        setEvaluator();
        calculation = checker.evaluate(file1, file2);
        
        return calculation;
    }

    public String getFeedBack(){
        String feedBackDetails = "";
        
        feedback = new FeedBack(currentSimilarityMetric, evaluation);
        
        feedBackDetails = feedback.getEvaluationFeedback();
        
        return feedBackDetails;
    }
    
    public String toString(){
        String evaluationDetails = "";
        
        evaluationDetails = "Class Name: " + className
                            //+ "File 1: " + file1
                            //+ "File 2: " + file2
                            + " Evaluation: " + evaluation
                            + " Feedback: " + getFeedBack();
        
        return evaluationDetails;
    }
}
