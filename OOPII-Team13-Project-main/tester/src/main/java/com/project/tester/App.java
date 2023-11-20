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
                    String nestedOutputFolder = outputFolder + File.separator + entryName.substring(0, entryName.lastIndexOf('.'));
                    extractAndProcessStudentSubmissions(outputPath, nestedOutputFolder);
                }
            }
        }
    }    

    public static String processStudentSubmission(String submissionPath) {
        File submissionFile = new File(submissionPath);
        if (submissionFile.isFile() && submissionPath.endsWith(".zip")) {
            try {
                 String outputFolder = "extractedFiles_" + submissionFile.getName(); // Unique output folder for each submission
                extractAndProcessStudentSubmissions(submissionPath, outputFolder);
                return outputFolder;
            } catch (IOException e) {
                e.printStackTrace();
            } 
        }
        return null;
    }
    
    //Daniel_Yorke_816019400_OOP1_A1.zip 
    //Faith_Rose_ID_A1.zip
    public static void processSubmission(Scanner in, PdfGenerator pdfFile) {
        String pdfInformation = "";
        double data = 0;

        System.out.println("Student ID for this file: ");
        String studentID = in.nextLine();
        System.out.println("Please input the zip file containing student submissions: ");
        String zipFileName = in.nextLine();
        System.out.println("Enter additional Path name e.g=/Assignment 1: ");
        String additionalPath = in.nextLine();
        

        String outputFolder = processStudentSubmission(zipFileName)+additionalPath;
        System.out.println(outputFolder);
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
            String specFolder = "Spec";
            File[] files = {
                new File(specFolder + "/PassengerAttributeSpec.java"),
                new File(specFolder + "/PassengerClassSignatures.java"),
                // new File(outputFolder + "/File3.java")
            };
            
            List<String> fileNames = new ArrayList<>();
            
            if (files != null) {
                for (File file : files) {
                    fileNames.add(file.getName());
                }
            }

            List<TextSimilarityChecker> checkers = new ArrayList<>();
            TextSimilarityChecker checker;
            List<Double> similarityValues = new ArrayList<>();

            for (int i = 0; i < fileNames.size(); i++) {
                for (int j = i + 1; j < fileNames.size(); j++) {
                    for (int similarityMetric = 1; similarityMetric <= 8; similarityMetric++) {
                        //TextSimilarityChecker checker;
                        //String assignmentFolder = outputFolder;
                        pdfInformation = "Passenger Class Feedback: \n";
                        if (similarityMetric == 1 ) {
                             System.out.println("-------------------------------------------------------- Attribute Feedback-----------------------------------------------------");

                            checker = new JaccardSimilarityChecker(similarityMetric);
                            double checker1 = checker.evaluate("Spec/PassengerAttributeSpec.java",outputFolder+"/Passenger.java");
                            similarityValues.add(checker1);
                            System.out.println(checker1);

                            checker = new JaccardSimilarityChecker(similarityMetric);
                            double checker2 = checker.evaluate("Spec/LuggageSlipAttributeSpec.java",outputFolder+"/LuggageSlip.java");
                            similarityValues.add(checker2);
                            System.out.println(checker2);

                            checker = new JaccardSimilarityChecker(similarityMetric);
                            double checker3 = checker.evaluate("Spec/FlightAttributeSpec.java",outputFolder+"/Flight.java");
                            similarityValues.add(checker3);
                            System.out.println(checker3);
                            
                            checker = new JaccardSimilarityChecker(similarityMetric);
                            double checker5 = checker.evaluate("Spec/LuggageManifestAttributeSpec.java",outputFolder+"/LuggageManifest.java");
                            similarityValues.add(checker5);
                            System.out.println(checker5);
                            //System.out.println(data);
                            pdfInformation += "PassengerAttributeSpec: " +checker1+checker2+checker3+checker5;
                        }else if (similarityMetric == 2) {
                            System.out.println("----------------------------------------------------Class Signature Feedback----------------------------------------------------");
                            checker = new JaccardSimilarityChecker(similarityMetric);
                            data = checker.evaluate("Spec/PassengerClassSignatures.java", outputFolder+"/Passenger.java");
                            checkers.add(checker);
                            System.out.println(data);

                            checker = new JaccardSimilarityChecker(similarityMetric);
                            data= checker.evaluate("Spec/LuggageSlipClassSignatures.java",outputFolder+"/LuggageSlip.java");
                            checkers.add(checker);
                            System.out.println(data);

                            checker = new JaccardSimilarityChecker(similarityMetric);
                            data= checker.evaluate("Spec/FlightClassSignatures.java",outputFolder+"/Flight.java");
                            checkers.add(checker);
                            System.out.println(data);


                            checker = new JaccardSimilarityChecker(similarityMetric);
                            data= checker.evaluate("Spec/LuggageManifestClassSignatures.java",outputFolder+"/LuggageManifest.java");
                            checkers.add(checker);
                            System.out.println(data);
                            pdfInformation += "PassengerClassSignatures: " + data;
                        } else if (similarityMetric == 3) {
                            System.out.println("-------------------------------------------------------Class States Feedback------------------------------------------------------");
                            checker = new JaccardSimilarityChecker(similarityMetric);
                            double checker1 = checker.evaluate("Spec/PassengerStates.java", outputFolder+"/Passenger.java");
                            similarityValues.add(checker1);
                            System.out.println(checker1);

                            //checker = new JaccardSimilarityChecker(similarityMetric);
                            //checker.evaluate("Spec/LuggageSlipStates.java",outputFolder+"/LuggageSlip.java");
                            //checkers.add(checker);
                            //System.out.println(data);

                            checker = new JaccardSimilarityChecker(similarityMetric);
                            double checker2= checker.evaluate("Spec/FlightStates.java",outputFolder+"/Flight.java");
                            similarityValues.add(checker2);
                            System.out.println(checker2);

                            checker = new JaccardSimilarityChecker(similarityMetric);
                            double checker3= checker.evaluate("Spec/LuggageManifestStates.java",outputFolder+"/LuggageManifest.java");
                            similarityValues.add(checker3);
                            System.out.println(checker3);

                            pdfInformation += "PassengerStates: " + data;
                        } else if (similarityMetric == 4) {
                            System.out.println("-------------------------------------------------------Access Modifier Feedback------------------------------------------------------");
                            checker = new JaccardSimilarityChecker(similarityMetric);
                            double checker1= checker.evaluate("Spec/PassengerAccessModifiers.java", outputFolder+"/Passenger.java");
                            similarityValues.add(checker1);
                            System.out.println(checker1);

                            checker = new JaccardSimilarityChecker(similarityMetric);
                            double checker2= checker.evaluate("Spec/LuggageSlipAccessModifiers.java",outputFolder+"/LuggageSlip.java");
                            similarityValues.add(checker2);
                            System.out.println(checker2);

                            checker = new JaccardSimilarityChecker(similarityMetric);
                            double checker3= checker.evaluate("Spec/FlightAccessModifiers.java",outputFolder+"/Flight.java");
                            similarityValues.add(checker3);
                            System.out.println(checker3);

                            checker = new JaccardSimilarityChecker(similarityMetric);
                            double checker5= checker.evaluate("Spec/LuggageManifestAccessModifiers.java",outputFolder+"/LuggageManifest.java");
                            similarityValues.add(checker5);
                            System.out.println(checker5);

                            pdfInformation += "PassengerAccessModifiers: " + data;
                        } else if (similarityMetric == 5) {
                            System.out.println("--------------------------------------------------------Constructor Feedback--------------------------------------------------------");
                            checker = new JaccardSimilarityChecker(similarityMetric);
                            double checker1 = checker.evaluate("Spec/PassengerConstructors.java", outputFolder+"/Passenger.java");
                            similarityValues.add(checker1);
                            System.out.println(checker1);
                            
                            checker = new JaccardSimilarityChecker(similarityMetric);
                            double checker2= checker.evaluate("Spec/LuggageSlipConstructors.java",outputFolder+"/LuggageSlip.java");
                            similarityValues.add(checker2);
                            System.out.println(checker2);

                            checker = new JaccardSimilarityChecker(similarityMetric);
                            double checker3= checker.evaluate("Spec/FlightConstructors.java",outputFolder+"/Flight.java");
                            similarityValues.add(checker3);
                            System.out.println(checker3);

                            checker = new JaccardSimilarityChecker(similarityMetric);
                            double checker5= checker.evaluate("Spec/LuggageManifestConstructors.java",outputFolder+"/LuggageManifest.java");
                            similarityValues.add(checker5);
                            System.out.println(checker5);
                            
                            pdfInformation += "PassengerConstructors: " + data;
                        } 
                    }
                }
            }
        
            pdfFile.createPDF(pdfInformation);
            // Perform operations with 'checkers'
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int submissionNumber = 0;

            System.out.println("How many student submissions will you be processing?: ");
            submissionNumber = in.nextInt();
            in.nextLine();

            PdfGenerator pdfFile = new PdfGenerator();

            for (int o = 1; o <= submissionNumber; o++) {
                processSubmission(in, pdfFile);

                // Prompt for next submission details if there are more submissions
                if (o < submissionNumber) {
                    System.out.println("\nProcessing next submission...\n");
                }
            }
        }
    }
}

