package com.project.tester;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class ReadInZipFile {
    
    //extractAndProcessStudentSubmissions - this method is used over in app
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
}
