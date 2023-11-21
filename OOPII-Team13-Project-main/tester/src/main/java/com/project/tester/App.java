package com.project.tester;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class App{

    public static void main(String[] args) {
        PdfGenerator pdfFile = new PdfGenerator();

        ArrayList<ClassEvaluation> passengerEvaluations = new ArrayList<ClassEvaluation>();
        ArrayList<ClassEvaluation> luggageSlipEvaluations = new ArrayList<ClassEvaluation>();
        ArrayList<ClassEvaluation> luggageManifestEvaluations = new ArrayList<ClassEvaluation>();
        ArrayList<ClassEvaluation> flightEvaluations = new ArrayList<ClassEvaluation>();


        ArrayList<String> passengerInformationFile = new ArrayList<String>();
        String passengerClassName = "Passenger Class Feedback: ";
        String fixedPClassName = "extractedFiles/Assignment 1/Passenger.java";
        passengerInformationFile.add("Spec/PassengerAttributeSpec.java");
        passengerInformationFile.add("Spec/PassengerClassSignatures.java");
        passengerInformationFile.add("Spec/PassengerStates.java");
        passengerInformationFile.add("Spec/PassengerAccessModifiers.java");
        passengerInformationFile.add("Spec/PassengerConstructors.java");


        ArrayList<String> luggageSlipInformationFile = new ArrayList<String>();
        String luggageSClassName = "Luggage Slip Feedback: ";
        String fixedLSClassName = "extractedFiles/Assignment 1/LuggageSlip.java";
        luggageSlipInformationFile.add("Spec/LuggageSlipAttributeSpec.java");
        luggageSlipInformationFile.add("Spec/LuggageSlipClassSignatures.java");
        luggageSlipInformationFile.add("Spec/LuggageStates.java");
        luggageSlipInformationFile.add("Spec/LuggageSlipAccessModifiers.java");
        luggageSlipInformationFile.add("Spec/LuggageSlipConstructors.java");


        ArrayList<String> luggageManifestInformationFile = new ArrayList<String>();
        String luggageMClassName = "Luggage Manifest Feedback: ";
        String fixedLMClassName = "extractedFiles/Assignment 1/LuggageSlip.java";
        luggageManifestInformationFile.add("Spec/LuggageManifestAttributeSpec.java");
        luggageManifestInformationFile.add("Spec/LuggageManifestClassSignatures.java");
        luggageManifestInformationFile.add("Spec/LuggageManifestStates.java");
        luggageManifestInformationFile.add("Spec/LuggageManifestAccessModifiers.java");
        luggageManifestInformationFile.add("Spec/LuggageManifestConstructors.java");


        ArrayList<String> flightInformationFile = new ArrayList<String>();
        String flightClassName = "FLight Feedback: ";
        String fixedFlightClassName = "extractedFiles/Assignment 1/LuggageSlip.java";
        flightInformationFile.add("Spec/FlightAttributeSpec.java");
        flightInformationFile.add("Spec/FlightClassSignatures.java");
        flightInformationFile.add("Spec/FlightStates.java");
        flightInformationFile.add("Spec/FlightAccessModifiers.java");
        flightInformationFile.add("Spec/FlightConstructors.java");


        ProcessFiles passengerPF = new ProcessFiles (passengerEvaluations, passengerInformationFile, fixedPClassName);
        ProcessFiles luggageSlipPF = new ProcessFiles (luggageSlipEvaluations, luggageSlipInformationFile, fixedLSClassName);
        ProcessFiles luggageManifestPF = new ProcessFiles (luggageManifestEvaluations, luggageManifestInformationFile, fixedLMClassName);
        ProcessFiles flightPF = new ProcessFiles (flightEvaluations, flightInformationFile, fixedFlightClassName);

        Scanner input = new Scanner(System.in);
        String outputFolder;

        //for loop to take in three files(provided)
        for(int i = 1; i < 4; i = i + 1){
            ArrayList<String> stringContents = new ArrayList<String>();
            System.out.println("Please input the zip file containing student submissions: ");
            String zipFileName;

            if(input.hasNextLine()){
                zipFileName = input.nextLine();
            
                outputFolder = ReadInZipFile.processStudentSubmission(zipFileName); 

                File zipFile = new File(zipFileName);

                if (!zipFile.exists() || !zipFile.isFile() || !zipFileName.endsWith(".zip")) {
                    System.out.println("No valid zip file found.");
                    input.close();
                    return; 
                }
                else{
                        passengerPF.processFiles(zipFileName, outputFolder);
                        luggageSlipPF.processFiles(zipFileName, outputFolder);
                        luggageManifestPF.processFiles(zipFileName, outputFolder);
                        flightPF.processFiles(zipFileName, outputFolder);

                        stringContents.add(passengerClassName);
                        for(ClassEvaluation evaluation: passengerEvaluations){
                            stringContents.add(evaluation.toString());
                        }

                        stringContents.add("");

                        stringContents.add(luggageSClassName);
                        for(ClassEvaluation evaluation: luggageSlipEvaluations){
                            stringContents.add(evaluation.toString());
                        }

                        stringContents.add("");

                        stringContents.add(luggageMClassName);
                        for(ClassEvaluation evaluation: luggageManifestEvaluations){
                            stringContents.add(evaluation.toString());
                        }

                        stringContents.add("");

                        stringContents.add(flightClassName);
                        for(ClassEvaluation evaluation: flightEvaluations){
                            stringContents.add(evaluation.toString());
                        }

                        pdfFile.createPDF(stringContents, outputFolder);
                    }
            }
            stringContents.clear();
        }
        input.close();
    }
}
