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
        String pdfInformation = new String(); // here
        PdfGenerator pdfFile = new PdfGenerator(); // here
        double data = 0; // here

        System.out.println("Please input the zip file containing student submissions: ");
        String zipFileName = in.nextLine();
        String outputFolder = "extractedFiles";
//Daniel_Yorke_816019400_OOP1_A1.zip
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
                        pdfInformation = "Passenger Class Feedback: \n";
                        if (similarityMetric == 1 ) {
                             System.out.println("-------------------------------------------------------- Attribute Feedback-----------------------------------------------------");

                            checker = new JaccardSimilarityChecker(similarityMetric);
                            double checker1 = checker.evaluate("Spec/PassengerAttributeSpec.java","extractedFiles/Assignment 1/Passenger.java");
                            similarityValues.add(checker1);
                            System.out.println(checker1);

                            checker = new JaccardSimilarityChecker(similarityMetric);
                            double checker2 = checker.evaluate("Spec/LuggageSlipAttributeSpec.java","extractedFiles/Assignment 1/LuggageSlip.java");
                            similarityValues.add(checker2);
                            System.out.println(checker2);

                            checker = new JaccardSimilarityChecker(similarityMetric);
                            double checker3 = checker.evaluate("Spec/FlightAttributeSpec.java","extractedFiles/Assignment 1/Flight.java");
                            similarityValues.add(checker3);
                            System.out.println(checker3);

                            //checker = new JaccardSimilarityChecker(similarityMetric);
                            //double checker4 = checker.evaluate("Spec/LuggageManagementSystem.java","extractedFiles/Assignment 1/LuggageManagementSystem.java");
                            //similarityValues.add(checker4);
                            //System.out.println(checker4); 
                            
                            checker = new JaccardSimilarityChecker(similarityMetric);
                            double checker5 = checker.evaluate("Spec/LuggageManifestAttributeSpec.java","extractedFiles/Assignment 1/LuggageManifest.java");
                            similarityValues.add(checker5);
                            System.out.println(checker5);
                            //System.out.println(data);
                            pdfInformation += "PassengerAttributeSpec: " +checker1+checker2+checker3+checker5;
                        }else if (similarityMetric == 2) {
                            System.out.println("----------------------------------------------------Class Signature Feedback----------------------------------------------------");
                            checker = new JaccardSimilarityChecker(similarityMetric);
                            data = checker.evaluate("Spec/PassengerClassSignatures.java", "extractedFiles/Assignment 1/Passenger.java");
                            checkers.add(checker);
                            System.out.println(data);

                            checker = new JaccardSimilarityChecker(similarityMetric);
                            data= checker.evaluate("Spec/LuggageSlipClassSignatures.java","extractedFiles/Assignment 1/LuggageSlip.java");
                            checkers.add(checker);
                            System.out.println(data);

                            checker = new JaccardSimilarityChecker(similarityMetric);
                            data= checker.evaluate("Spec/FlightClassSignatures.java","extractedFiles/Assignment 1/Flight.java");
                            checkers.add(checker);
                            System.out.println(data);

                            checker = new JaccardSimilarityChecker(similarityMetric);
                            data=  checker.evaluate("Spec/LuggageManagementSystemClassSignatures.java","extractedFiles/Assignment 1/LuggageManagementSystem.java");
                            checkers.add(checker);
                            System.out.println(data);

                            checker = new JaccardSimilarityChecker(similarityMetric);
                            data= checker.evaluate("Spec/LuggageManifestClassSignatures.java","extractedFiles/Assignment 1/LuggageManifest.java");
                            checkers.add(checker);
                            System.out.println(data);
                            pdfInformation += "PassengerClassSignatures: " + data;
                        } else if (similarityMetric == 3) {
                            System.out.println("-------------------------------------------------------Class States Feedback------------------------------------------------------");
                            checker = new JaccardSimilarityChecker(similarityMetric);
                            double checker1 = checker.evaluate("Spec/PassengerStates.java", "extractedFiles/Assignment 1/Passenger.java");
                            similarityValues.add(checker1);
                            System.out.println(checker1);

                            //checker = new JaccardSimilarityChecker(similarityMetric);
                            //checker.evaluate("Spec/LuggageSlipStates.java","extractedFiles/Assignment 1/LuggageSlip.java");
                            //checkers.add(checker);
                            //System.out.println(data);

                            checker = new JaccardSimilarityChecker(similarityMetric);
                            double checker2= checker.evaluate("Spec/FlightStates.java","extractedFiles/Assignment 1/Flight.java");
                            similarityValues.add(checker2);
                            System.out.println(checker2);

                            //checker = new JaccardSimilarityChecker(similarityMetric);
                            //double checker4= checker.evaluate("Spec/LuggageManagementSystemStates.java","extractedFiles/Assignment 1/LuggageManagementSystem.java");
                            //similarityValues.add(checker4);
                            //System.out.println(checker4);

                            checker = new JaccardSimilarityChecker(similarityMetric);
                            double checker3= checker.evaluate("Spec/LuggageManifestStates.java","extractedFiles/Assignment 1/LuggageManifest.java");
                            similarityValues.add(checker3);
                            System.out.println(checker3);

                            pdfInformation += "PassengerStates: " + data;
                        } else if (similarityMetric == 4) {
                            System.out.println("-------------------------------------------------------Access Modifier Feedback------------------------------------------------------");
                            checker = new JaccardSimilarityChecker(similarityMetric);
                            double checker1= checker.evaluate("Spec/PassengerAccessModifiers.java", "extractedFiles/Assignment 1/Passenger.java");
                            similarityValues.add(checker1);
                            System.out.println(checker1);

                            checker = new JaccardSimilarityChecker(similarityMetric);
                            double checker2= checker.evaluate("Spec/LuggageSlipAccessModifiers.java","extractedFiles/Assignment 1/LuggageSlip.java");
                            similarityValues.add(checker2);
                            System.out.println(checker2);

                            checker = new JaccardSimilarityChecker(similarityMetric);
                            double checker3= checker.evaluate("Spec/FlightAccessModifiers.java","extractedFiles/Assignment 1/Flight.java");
                            similarityValues.add(checker3);
                            System.out.println(checker3);

                            checker = new JaccardSimilarityChecker(similarityMetric);
                            double checker4= checker.evaluate("Spec/LuggageManagementSystemAccessModifiers.java","extractedFiles/Assignment 1/LuggageManagementSystem.java");
                            similarityValues.add(checker4);
                            System.out.println(checker4);

                            checker = new JaccardSimilarityChecker(similarityMetric);
                            double checker5= checker.evaluate("Spec/LuggageManifestAccessModifiers.java","extractedFiles/Assignment 1/LuggageManifest.java");
                            similarityValues.add(checker5);
                            System.out.println(checker5);

                            pdfInformation += "PassengerAccessModifiers: " + data;
                        } else if (similarityMetric == 5) {
                            System.out.println("--------------------------------------------------------Constructor Feedback--------------------------------------------------------");
                            checker = new JaccardSimilarityChecker(similarityMetric);
                            double checker1 = checker.evaluate("Spec/PassengerConstructors.java", "extractedFiles/Assignment 1/Passenger.java");
                            similarityValues.add(checker1);
                            System.out.println(checker1);
                            
                            checker = new JaccardSimilarityChecker(similarityMetric);
                            double checker2= checker.evaluate("Spec/LuggageSlipConstructors.java","extractedFiles/Assignment 1/LuggageSlip.java");
                            similarityValues.add(checker2);
                            System.out.println(checker2);

                            checker = new JaccardSimilarityChecker(similarityMetric);
                            double checker3= checker.evaluate("Spec/FlightConstructors.java","extractedFiles/Assignment 1/Flight.java");
                            similarityValues.add(checker3);
                            System.out.println(checker3);

                            //checker = new JaccardSimilarityChecker(similarityMetric);
                            //double checker4= checker.evaluate("Spec/LuggageManagementSystemConstructors.java","extractedFiles/Assignment 1/LuggageManagementSystem.java");
                            //similarityValues.add(checker4);
                            //System.out.println(checker4);

                            checker = new JaccardSimilarityChecker(similarityMetric);
                            double checker5= checker.evaluate("Spec/LuggageManifestConstructors.java","extractedFiles/Assignment 1/LuggageManifest.java");
                            similarityValues.add(checker5);
                            System.out.println(checker5);
                            
                            pdfInformation += "PassengerConstructors: " + data;
                        } 
                    }
                }
            }
            pdfFile.createPDF(pdfInformation);
            // Perform operations with 'checkers'
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // Handle closing resources here if necessary
        }
        
        
    }
}



