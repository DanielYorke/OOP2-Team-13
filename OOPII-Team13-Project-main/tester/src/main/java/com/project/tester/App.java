package com.project.tester;


import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class App {
    public static void extractAndProcessStudentSubmissions(String zipFileName, String outputFolder) throws IOException {
        byte[] buffer = new byte[1024];
        File outputDirectory = new File(outputFolder);
        if (outputDirectory.exists()) {
            System.out.println("Files have already been extracted. Skipping extraction.");
            return;
        }

        try (ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(zipFileName))) {
            ZipEntry zipEntry;

            while ((zipEntry = zipInputStream.getNextEntry()) != null) {
                String entryName = zipEntry.getName();
                String outputPath = outputFolder + File.separator + entryName;

                File entryFile = new File(outputPath);

                if (zipEntry.isDirectory()) {
                    entryFile.mkdirs();
                } else {
                    new File(entryFile.getParent()).mkdirs();

                    try (FileOutputStream fos = new FileOutputStream(entryFile)) {
                        int length;
                        while ((length = zipInputStream.read(buffer)) > 0) {
                            fos.write(buffer, 0, length);
                        }
                    }
                }
                if (entryName.endsWith(".zip")) {
                }
            }
        }
    }

    public static void processStudentSubmission(String submissionPath) {
        File submissionFile = new File(submissionPath);
        if (submissionFile.isFile() && submissionPath.endsWith(".zip")) {
            try {
                extractAndProcessStudentSubmissions(submissionPath, "studentSubmission");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Please input the zip file containing student submissions: ");
        String zipFileName = in.nextLine();
        String outputFolder = "extractedFiles";

        File zipFile = new File(zipFileName);

        if (!zipFile.exists() || !zipFile.isFile() || !zipFileName.endsWith(".zip")) {
            System.out.println("No valid zip file found.");
            in.close();
            return; 
        }
        try {
            extractAndProcessStudentSubmissions(zipFileName, outputFolder);
            System.out.println("Student submissions extracted and processed successfully.");
            
            File folder = new File(outputFolder);
            File[] files = {
                new File(outputFolder + "/PassengerAttributeSpec.java"),
                new File(outputFolder + "/PassengerClassSignatures.java"),
                // new File(outputFolder + "/File3.java")
            };
            
            List<String> fileNames = new ArrayList<>();
            
            if (files != null) {
                for (File file : files) {
                    fileNames.add(file.getName());
                }
            }
            
            List<TextSimilarityChecker> checkers = new ArrayList<>();
            
            for (int i = 0; i < fileNames.size(); i++) {
                for (int j = i + 1; j < fileNames.size(); j++) {
                    for (int similarityMetric = 1; similarityMetric <= 8; similarityMetric++) {
                        TextSimilarityChecker checker;
                        
                        if (similarityMetric == 1 ) {
                            checker = new JaccardSimilarityChecker(similarityMetric);
                            checkers.add(checker);
                            System.out.println(checker.evaluate("PassengerAttributeSpec.java","Passenger.java"));
                        } else if (similarityMetric == 2) {
                            checker = new JaccardSimilarityChecker(similarityMetric);
                            checkers.add(checker);
                            System.out.println(checker.evaluate("PassengerClassSignatures.java", "Passenger.java"));
                        } else if (similarityMetric == 3) {
                            checker = new JaccardSimilarityChecker(similarityMetric);
                            checkers.add(checker);
                            System.out.println(checker.evaluate("PassengerStates.java", "Passenger.java"));
                        } else if (similarityMetric == 4) {
                            checker = new JaccardSimilarityChecker(similarityMetric);
                            checkers.add(checker);
                            System.out.println(checker.evaluate("PassengerAccessModifiers.java", "Passenger.java"));
                        } else if (similarityMetric == 5) {
                            checker = new JaccardSimilarityChecker(similarityMetric);
                            checkers.add(checker);
                            System.out.println(checker.evaluate("PassengerConstructors.java", "Passenger.java"));
                        } 
                    }
                }
            }
            
            // Perform operations with 'checkers'
            
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // Handle closing resources here if necessary
        }
        
        
    }
}



