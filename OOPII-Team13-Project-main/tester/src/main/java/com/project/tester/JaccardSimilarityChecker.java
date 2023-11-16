package com.project.tester;

/*import java.util.HashSet;
import java.util.Set;*/

public class JaccardSimilarityChecker extends TextSimilarityChecker {
    public JaccardSimilarityChecker() {
        super(1);
    }
    public JaccardSimilarityChecker(int similarityMetric) {
        super(similarityMetric);
    }


    @Override
    protected double calculateSimilarity(String text1, String text2) {
        double similarity= -999.9;
        String similarityMetricChecker="";
        if (similarityMetric == 1) {
            similarityMetricChecker="Attribute Similarity Percentage:";
            similarity= new Jaccard().measure(text1, text2);
            if (similarity<=0.1)
            {
                similarity=similarity*10;
            }
            if(similarity>=0.8)
            {
                System.out.println("\nAll Attributes with Correct Naming Convention. "+similarityMetricChecker);
                return similarity;
            }
            else if(similarity<0.8)
            {  
                //double simPercent=(similarity*9*25);
                if(similarity>=0.7)
                {
                    // return 
                    System.out.println("\nMost Attributes with Correct Naming Convention. "+similarityMetricChecker);
                }
                if(similarity>=0.4)
                {
                    System.out.println("\nSome Attributes with Correct Naming Convention. "+similarityMetricChecker);
                }
                else if(similarity<0.4)
                {
                    System.out.println("\nBarely any Attributes with Correct Naming Convention. "+similarityMetricChecker);
                }
            }
        }
        if (similarityMetric == 2) {
            similarityMetricChecker="Class Signatures Similarity Percentage:";
            similarity= new Jaccard().measure(text1, text2);
            if (similarity<=0.1)
            {
                similarity=similarity*10;
            }
            if(similarity>=0.8)
            {
                System.out.println("\nAll Class Signatures are Correct. "+similarityMetricChecker);
                return similarity;
            }
            else if(similarity<0.8)
            {  
                //double simPercent=(similarity*9*25);
                if(similarity>=0.7)
                {
                    System.out.println("\nMost Class Signatures are Correct. "+similarityMetricChecker);
                }
                if(similarity>=0.4)
                {
                    System.out.println("\nSome Class Signatures are Correct. "+similarityMetricChecker);
                }
                else if(similarity<0.4)
                {
                    System.out.println("\nBarely any Class Signatures are Correct. "+similarityMetricChecker);
                }
            }
        }
        if (similarityMetric == 3) {
            similarityMetricChecker="State Variables Similarity Percentage:";
            similarity= new Jaccard().measure(text1, text2);
            if (similarity<=0.1)
            {
                similarity=similarity*10;
            }
            if(similarity>=0.8)
            {
                System.out.println("\nAll States are Correct. "+similarityMetricChecker);
                return similarity;
            }
            else if(similarity<0.8)
            {  
                //double simPercent=(similarity*9*25);
                if(similarity>=0.7)
                {
                    System.out.println("\nMost States are Correct. "+similarityMetricChecker);
                }
                if(similarity>=0.4)
                {
                    System.out.println("\nSome States are Correct. "+similarityMetricChecker);
                }
                else if(similarity<0.4)
                {
                    System.out.println("\nBarely any States are Correct. "+similarityMetricChecker);
                }
            }
        }
        if (similarityMetric == 4) {
            similarityMetricChecker="Access Modifiers Similarity Percentage:";
            similarity= new Jaccard().measure(text1, text2);
            if (similarity<=0.16)
            {
                similarity=similarity*5;
            }
            if(similarity>=0.8)
            {
                System.out.println("\nAll Access Modifiers are Correct. "+similarityMetricChecker);
                return similarity;
            }
            else if(similarity<0.8)
            {  
                //double simPercent=(similarity*9*25);
                if(similarity>=0.7)
                {
                    System.out.println("\nMost Access Modifiers are Correct. "+similarityMetricChecker);
                    return similarity;
                }
                if(similarity>=0.4)
                {
                    System.out.println("\nSome Access Modifiers are Correct. "+similarityMetricChecker);
                }
                else if(similarity<0.4)
                {
                    System.out.println("\nBarely any Access Modifiers are Correct. "+similarityMetricChecker);
                }
            }
        
        }
        if (similarityMetric == 5) {
            similarityMetricChecker="Constructors Similarity Percentage:";
            similarity= new Jaccard().measure(text1, text2);
            if (similarity<=0.1)
            {
                similarity=similarity*10;
            }
            if(similarity>=0.8)
            {
                System.out.println("\nAll Constructors are Correct. "+similarityMetricChecker);
                return similarity;
            }
            else if(similarity<0.8)
            {  
                //double simPercent=(similarity*9*25);
                if(similarity>=0.7)
                {
                    System.out.println("\nMost Constructors are Correct. "+similarityMetricChecker);
                }
                if(similarity>=0.4)
                {
                    System.out.println("\nSome Constructors are Correct. "+similarityMetricChecker);
                }
                else if(similarity<0.4)
                {
                    System.out.println("\nBarely any Constructors are Correct. "+similarityMetricChecker);
                }
            }
        }
        if (similarityMetric == 6) {
            similarityMetricChecker="Methods Similarity Percentage:";
            similarity= new Jaccard().measure(text1, text2);
            if (similarity<=0.1)
            {
                similarity=similarity*10;
            }
            if(similarity>=0.8)
            {
                System.out.println("\nAll Methods are Correct. "+similarityMetricChecker);
                return similarity;
            }
            else if(similarity<0.8)
            {  
                //double simPercent=(similarity*9*25);
                if(similarity>=0.7)
                {
                    System.out.println("\nMost Methods are Correct. "+similarityMetricChecker);
                }
                if(similarity>=0.4)
                {
                    System.out.println("\nSome Methods are Correct. "+similarityMetricChecker);
                }
                else if(similarity<0.4)
                {
                    System.out.println("\nBarely any Methods are Correct. "+similarityMetricChecker);
                }
            }
        } 
        if (similarityMetric == 7) {
            similarityMetricChecker="Relationships Similarity Percentage:";
            similarity= new Jaccard().measure(text1, text2);
            if (similarity<=0.1)
            {
                similarity=similarity*10;
            }
            if(similarity>=0.8)
            {
                System.out.println("\nAll Relationships are Correct. "+similarityMetricChecker);
                return similarity;
            }
            else if(similarity<0.8)
            {  
                //double simPercent=(similarity*9*25);
                if(similarity>=0.7)
                {
                    System.out.println("\nMost Relationships are Correct. "+similarityMetricChecker);
                }
                if(similarity>=0.4)
                {
                    System.out.println("\nSome Relationships are Correct. "+similarityMetricChecker);
                }
                else if(similarity<0.4)
                {
                    System.out.println("\nBarely any Access Modifiers are Correct. "+similarityMetricChecker);
                }
            }
        }
        if (similarityMetric == 8) {
            similarityMetricChecker="Abstractions Similarity Percentage:";
            similarity= new Jaccard().measure(text1, text2);
            if (similarity<=0.1)
            {
                similarity=similarity*10;
            }
            if(similarity>=0.8)
            {
                System.out.println("\nAll Abstractions are Correct. "+similarityMetricChecker);
                return similarity;
            }
            else if(similarity<0.8)
            {  
                //double simPercent=(similarity*9*25);
                if(similarity>=0.7)
                {
                    System.out.println("\nMost Abstractions are Correct. "+similarityMetricChecker);
                }
                if(similarity>=0.4)
                {
                    System.out.println("\nSome Abstractions are Correct. "+similarityMetricChecker);
                }
                else if(similarity<0.4)
                {
                    System.out.println("\nBarely any Abstractions are Correct. "+similarityMetricChecker);
                }
            }
        }//*/       
        return similarity;
    }
}