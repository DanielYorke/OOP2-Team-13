import java.util.HashSet;
import java.util.Set;

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
            if(similarity>=0.2)
            {
                System.out.println("All Attributes with Correct Naming Convention\n"+similarityMetricChecker);
                //return 100.0;
                return similarity;
            }
            else if(similarity<0.2)
            {  
                double simPercent=(similarity*0.2*25);
                if(similarity>=0.15)
                {
                    System.out.println("Most Attributes with Correct Naming Convention\n"+similarityMetricChecker);
                }
                if(similarity>=0.1)
                {
                    System.out.println("Some Attributes with Correct Naming Convention\n"+similarityMetricChecker);
                }
                else if(similarity<0.15)
                {
                    System.out.println("Barely any Attributes with Correct Naming Convention\n"+similarityMetricChecker);
                }
                similarity=simPercent;
            }
        }
        if (similarityMetric == 2) {
            similarityMetricChecker="Class Signatures Similarity Percentage:";
            similarity= new Jaccard().measure(text1, text2);
            if(similarity>=0.2)
            {
                System.out.println("All Class Signatures are Correct\n"+similarityMetricChecker);
                return 100.0;
            }
            else if(similarity<0.2)
            {  
                double simPercent=(similarity*0.2*25);
                if(similarity>=0.15)
                {
                    System.out.println("Most Class Signatures are Correct\n"+similarityMetricChecker);
                }
                if(similarity>=0.1)
                {
                    System.out.println("Some Class Signatures are Correct\n"+similarityMetricChecker);
                }
                else if(similarity<0.15)
                {
                    System.out.println("Barely any Class Signatures are Correct\n"+similarityMetricChecker);
                }
                similarity=simPercent;
            }
        }
        if (similarityMetric == 3) {
            similarityMetricChecker="State Variables Similarity Percentage:";
            similarity= new Jaccard().measure(text1, text2);
            if(similarity>=0.2)
            {
                System.out.println("All States are Correct\n"+similarityMetricChecker);
                return 100.0;
            }
            else if(similarity<0.2)
            {  
                double simPercent=(similarity*0.2*25);
                if(similarity>=0.15)
                {
                    System.out.println("Most States are Correct\n"+similarityMetricChecker);
                }
                if(similarity>=0.1)
                {
                    System.out.println("Some States are Correct\n"+similarityMetricChecker);
                }
                else if(similarity<0.15)
                {
                    System.out.println("Barely any States are Correct\n"+similarityMetricChecker);
                }
                similarity=simPercent;
            }
        }
        if (similarityMetric == 4) {
            similarityMetricChecker="Access Modifiers Similarity Percentage:";
            similarity= new Jaccard().measure(text1, text2);
            if(similarity>=0.2)
            {
                System.out.println("All Access Modifiers are Correct\n"+similarityMetricChecker);
                return 100.0;
            }
            else if(similarity<0.2)
            {  
                double simPercent=(similarity*0.2*25);
                if(similarity>=0.15)
                {
                    System.out.println("Most Access Modifiers are Correct\n"+similarityMetricChecker);
                }
                if(similarity>=0.1)
                {
                    System.out.println("Some Access Modifiers are Correct\n"+similarityMetricChecker);
                }
                else if(similarity<0.15)
                {
                    System.out.println("Barely any Access Modifiers are Correct\n"+similarityMetricChecker);
                }
                similarity=simPercent;
            }
        }
        if (similarityMetric == 5) {
            similarityMetricChecker="Constructors Similarity Percentage:";
            similarity= new Jaccard().measure(text1, text2);
            if(similarity>=0.2)
            {
                System.out.println("All Constructors are Correct\n"+similarityMetricChecker);
                return 100.0;
            }
            else if(similarity<0.2)
            {  
                double simPercent=(similarity*0.2*25);
                if(similarity>=0.15)
                {
                    System.out.println("Most Constructors are Correct\n"+similarityMetricChecker);
                }
                if(similarity>=0.1)
                {
                    System.out.println("Some Constructors are Correct\n"+similarityMetricChecker);
                }
                else if(similarity<0.15)
                {
                    System.out.println("Barely any Constructors are Correct\n"+similarityMetricChecker);
                }
                similarity=simPercent;
            }
        }
        if (similarityMetric == 6) {
            similarityMetricChecker="Methods Similarity Percentage:";
            similarity= new Jaccard().measure(text1, text2);
            if(similarity>=0.2)
            {
                System.out.println("All Methods are Correct\n"+similarityMetricChecker);
                return 100.0;
            }
            else if(similarity<0.2)
            {  
                double simPercent=(similarity*0.2*25);
                if(similarity>=0.15)
                {
                    System.out.println("Most Methods are Correct\n"+similarityMetricChecker);
                }
                if(similarity>=0.1)
                {
                    System.out.println("Some Methods are Correct\n"+similarityMetricChecker);
                }
                else if(similarity<0.15)
                {
                    System.out.println("Barely any Methods are Correct\n"+similarityMetricChecker);
                }
                similarity=simPercent;
            }
        } 
        if (similarityMetric == 7) {
            similarityMetricChecker="Relationships Similarity Percentage:";
            similarity= new Jaccard().measure(text1, text2);
            if(similarity>=0.2)
            {
                System.out.println("All Relationships are Correct\n"+similarityMetricChecker);
                return 100.0;
            }
            else if(similarity<0.2)
            {  
                double simPercent=(similarity*0.2*25);
                if(similarity>=0.15)
                {
                    System.out.println("Most Relationships are Correct\n"+similarityMetricChecker);
                }
                if(similarity>=0.1)
                {
                    System.out.println("Some Relationships are Correct\n"+similarityMetricChecker);
                }
                else if(similarity<0.15)
                {
                    System.out.println("Barely any Access Modifiers are Correct\n"+similarityMetricChecker);
                }
                similarity=simPercent;
            }
        }
        if (similarityMetric == 8) {
            similarityMetricChecker="Abstractions Similarity Percentage:";
            similarity= new Jaccard().measure(text1, text2);
            if(similarity>=0.2)
            {
                System.out.println("All Abstractions are Correct\n"+similarityMetricChecker);
                return 100.0;
            }
            else if(similarity<0.2)
            {  
                double simPercent=(similarity*0.2*25);
                if(similarity>=0.15)
                {
                    System.out.println("Most Abstractions are Correct\n"+similarityMetricChecker);
                }
                if(similarity>=0.1)
                {
                    System.out.println("Some Abstractions are Correct\n"+similarityMetricChecker);
                }
                else if(similarity<0.15)
                {
                    System.out.println("Barely any Abstractions are Correct\n"+similarityMetricChecker);
                }
                similarity=simPercent;
            }
        }       
        return similarity;
    }
}