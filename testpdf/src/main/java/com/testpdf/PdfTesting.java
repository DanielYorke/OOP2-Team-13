package com.testpdf;

import java.io.*;
import org.apache.pdfbox.pdmodel.PDDocument; 
import org.apache.pdfbox.pdmodel.PDPage; 
import org.apache.pdfbox.pdmodel.PDPageContentStream; 
import org.apache.pdfbox.pdmodel.font.PDType1Font;  
 
public class PdfTesting {
    public static void main(String[] args) {
        int numPages = 5;
        try{
                PDDocument document = new PDDocument();
                for (int i = 1; i <= numPages; i++) 
                {
                    PDPage page = new PDPage();
                    document.addPage(page);
                    PDPageContentStream contentStream = new PDPageContentStream(document, page);
                    // PDPageContentStream contentStream2 = new PDPageContentStream(document, page);
                    // contentStream2.beginText();
                    // contentStream2.endText();
                    contentStream.beginText();
                    contentStream.setFont(PDType1Font.TIMES_ROMAN, 12);
                    contentStream.newLineAtOffset(100, 700);
                    contentStream.showText("This is a test on page "+i);
                    contentStream.newLineAtOffset(400, -650);
                    contentStream.showText("page "+i);
                    contentStream.endText();
                    contentStream.close();
                    // contentStream2.close();
                }
                document.save("feedback.pdf");
                document.close(); 
            }
            catch(IOException e){
                e.printStackTrace();
            }    
   
        
    }
}



// import java.io.File;
// import java.io.FileWriter;
// import java.io.IOException; 
 
// public class PdfTesting {
//     public static void main(String args[]) throws Exception
//     {
//         try
//         {
//             File myObj = new File("filename.pdf");
//             if (myObj.createNewFile())
//             {
//               System.out.println("File created: " + myObj.getName());
//             } 
//             else 
//             {
//               System.out.println("File already exists.");
//             }
//         } 
//         catch (IOException e) 
//         {
//             System.out.println("An error occurred.");
//             e.printStackTrace();
//         }

//         try
//             {
//             FileWriter writer = new FileWriter("filename.pdf");
//             writer.write("This is a test");
//             writer.close();
//             System.out.println("Successfully wrote to file");
//             }
//         catch (IOException e) 
//             {
//             System.out.println("An error occurred.");
//             e.printStackTrace();
//             }
//     }
//     }

