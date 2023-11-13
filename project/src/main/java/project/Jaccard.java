package project;
//http://www.java2s.com/example/java/java.lang/compute-jaccards-coefficient-of-similarity.html
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;


public class Jaccard implements SimilarityMetric {
    @Override
    public double measure(String p1, String p2) {
        Collection<String> tweet1 = new HashSet<>(Arrays.asList(p1.split(" ")));
        Collection<String> tweet2 = new HashSet<>(Arrays.asList(p2.split(" ")));

        Collection<String> intersectionOfTweets = new HashSet<>(tweet1);
        intersectionOfTweets.retainAll(tweet2);

        Collection<String> unionOfTweets = new HashSet<>(tweet1);
        unionOfTweets.addAll(tweet2);

        double jaccardsCoefficient = (double) intersectionOfTweets.size() / (double) unionOfTweets.size();
        return jaccardsCoefficient;
    }
}