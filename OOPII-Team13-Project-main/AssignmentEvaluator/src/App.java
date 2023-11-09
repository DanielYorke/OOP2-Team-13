import java.io.*;
import java.util.Scanner;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class App {
    public static void extractAndProcessStudentSubmissions(String zipFileName, String outputFolder) throws IOException {
        byte[] buffer = new byte[1024];

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

                // Process Java files within the extracted submission
                if (entryName.endsWith(".zip")) {
                    processStudentSubmission(outputPath);
                }
            }
        }
    }

    public static void processStudentSubmission(String submissionPath) {
        File submissionFile = new File(submissionPath);

        // Check if the submission is a zip file
        if (submissionFile.isFile() && submissionPath.endsWith(".zip")) {
            try {
                // Extract the contents of the student's submission
                extractAndProcessStudentSubmissions(submissionPath, "studentSubmission");

                // Now you can process the Java files within the extracted student submission
                // Iterate through the files, look for ".java" files, and analyze them.
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
            return; // Exit the program if the zip file is not found
        }

        try {
            extractAndProcessStudentSubmissions(zipFileName, outputFolder);
            System.out.println("Student submissions extracted and processed successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            in.close();
        }
    }
}
