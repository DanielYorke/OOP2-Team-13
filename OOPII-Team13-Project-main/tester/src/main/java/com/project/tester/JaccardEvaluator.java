package com.project.tester;

public class JaccardEvaluator extends ClassEvaluation{
    
    public JaccardEvaluator(int currentSimilarityMetric, String file1, String file2, String classTestName){
        super(currentSimilarityMetric, file1, file2, classTestName);
    }
    
    public void setEvaluator(){
        checker = new JaccardSimilarityChecker(currentSimilarityMetric);
    }
}