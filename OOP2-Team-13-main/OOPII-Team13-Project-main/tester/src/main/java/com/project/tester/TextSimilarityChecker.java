package com.project.tester;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public abstract class TextSimilarityChecker {

    public int similarityMetric;
    public TextSimilarityChecker(int similarityMetric) {
        this.similarityMetric= similarityMetric;
    }

    public double evaluate(String filename1, String filename2) {
        try {
            String text1 = Files.readString(Path.of(filename1));
            String text2 = Files.readString(Path.of(filename2));

            return calculateSimilarity(text1, text2);
        } catch (IOException e) {
            e.printStackTrace();
            return -999.9;
        }
    }

    protected abstract double calculateSimilarity(String text1, String text2);
    protected Set<String> tokenize(String text) {  
        String[] words = text.split("\\s+");
        return new HashSet<>(List.of(words));
    }
}
