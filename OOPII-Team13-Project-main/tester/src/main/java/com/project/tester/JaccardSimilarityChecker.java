package com.project.tester;

public class JaccardSimilarityChecker extends TextSimilarityChecker {
    private double similarity = -999.9;
    
    public JaccardSimilarityChecker() {
        super(1);
    }
    
    public JaccardSimilarityChecker(int similarityMetric) {
        super(similarityMetric);
    }
    
    public double calculateSimilarity(String text1, String text2){
        similarity = new Jaccard().measure(text1, text2);
        if (similarity <= 0.1){
            similarity = similarity * 10;
        }
        
        return similarity;
    }
}
