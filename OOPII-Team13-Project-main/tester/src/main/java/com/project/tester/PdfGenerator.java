package com.project.tester;

import java.io.*;
import org.apache.pdfbox.pdmodel.PDDocument; 
import org.apache.pdfbox.pdmodel.PDPage; 
import org.apache.pdfbox.pdmodel.PDPageContentStream; 
import org.apache.pdfbox.pdmodel.font.PDType1Font;  
 
public class PdfGenerator {
    public void createPDF(String pdfInformation) {
        int numPages = 5;

        try{
                PDDocument document = new PDDocument();
                for (int i = 1; i <= numPages; i++) 
                {
                    PDPage page = new PDPage();
                    document.addPage(page);
                    PDPageContentStream contentStream = new PDPageContentStream(document, page);
                    contentStream.beginText();
                    contentStream.setFont(PDType1Font.TIMES_ROMAN, 12);
                    contentStream.newLineAtOffset(100, 700);
                    contentStream.showText(pdfInformation+i);
                    contentStream.newLineAtOffset(400, -650);
                    contentStream.showText("page "+i);
                    contentStream.endText();
                    contentStream.close();
                }
                document.save("feedback.pdf");
                document.close(); 
            }
            catch(IOException e){
                e.printStackTrace();
            }    
   
        
    }
}