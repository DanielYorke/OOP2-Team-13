package com.project.tester;

public class JaccardEvaluator extends ClassEvaluation{
    
    public JaccardEvaluator(int currentSimilarityMetric, String file1, String file2){
        super(currentSimilarityMetric, file1, file2);
    }
    
    public void setEvaluator(){
        checker = new JaccardSimilarityChecker(currentSimilarityMetric);
    }
}
