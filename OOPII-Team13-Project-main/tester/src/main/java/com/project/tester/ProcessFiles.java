package com.project.tester;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProcessFiles {

    private ArrayList<ClassEvaluation> fileProcessInformation = new ArrayList<ClassEvaluation>(); 
    private ArrayList<String> file1; 
    private String file2; 

    public ProcessFiles(ArrayList<ClassEvaluation> al, ArrayList<String> file1, String file2){
        fileProcessInformation = al;
        this.file1 = file1;
        this.file2 = file2;
    }


    public void processFiles(){
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
        try { // here uses the readinfile
            ReadInZipFile.extractAndProcessStudentSubmissions(zipFileName, outputFolder);
            System.out.println("Student submissions extracted and processed successfully.");
            
            //File folder = new File(outputFolder);
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

            for (int i = 0; i < fileNames.size(); i++) {
                for (int j = i + 1; j < fileNames.size(); j++) {
                    for (int similarityMetric = 1; similarityMetric <= 8; similarityMetric++) {
                        
                        if (similarityMetric == 1 ) {
                            fileProcessInformation.add(new JaccardEvaluator(similarityMetric, file1.get(0), file2));
                        } else if (similarityMetric == 2) {
                            fileProcessInformation.add(new JaccardEvaluator(similarityMetric, file1.get(1), file2));
                        } else if (similarityMetric == 3) {
                            fileProcessInformation.add(new JaccardEvaluator(similarityMetric, file1.get(2), file2));
                        } else if (similarityMetric == 4) {
                            fileProcessInformation.add(new JaccardEvaluator(similarityMetric, file1.get(3), file2));
                        } else if (similarityMetric == 5) {
                            fileProcessInformation.add(new JaccardEvaluator(similarityMetric, file1.get(4), file2));
                        } else if (similarityMetric == 6) {
                            fileProcessInformation.add(new JaccardEvaluator(similarityMetric, file1.get(5), file2));
                        } else if (similarityMetric == 7) {
                            fileProcessInformation.add(new JaccardEvaluator(similarityMetric, file1.get(6), file2));
                        } else if (similarityMetric == 8) {
                            fileProcessInformation.add(new JaccardEvaluator(similarityMetric, file1.get(7), file2));
                        } 
                    }
                }
            }

            // Perform operations with 'checkers'
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // Handle closing resources here if necessary
        }
        
        
    
    }
}
