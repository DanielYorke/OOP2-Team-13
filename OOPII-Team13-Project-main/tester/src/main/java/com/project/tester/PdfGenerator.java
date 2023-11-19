package com.project.tester;

import org.apache.pdfbox.pdmodel.PDDocument; 
import org.apache.pdfbox.pdmodel.PDPage; 
import org.apache.pdfbox.pdmodel.PDPageContentStream; 
import org.apache.pdfbox.pdmodel.font.PDType1Font;  

import java.io.IOException;
import java.util.ArrayList;

public class PdfGenerator {
    public void createPDF(ArrayList<String> pdfInformation) {

        try {
            ArrayList<String> pdfContents = new ArrayList<String>();
            pdfContents = pdfInformation;

            PDDocument pdfDocument = new PDDocument();
          
            PDPage page = new PDPage();
            pdfDocument.addPage(page);

            PDPageContentStream contentStream = new PDPageContentStream(pdfDocument, page);

            contentStream.setFont(PDType1Font.TIMES_ROMAN, 12);

            contentStream.beginText();
            contentStream.newLineAtOffset(90, 710);

            for(String line: pdfContents){
                contentStream.showText(line);
                contentStream.newLineAtOffset(0, -15);
            }
            
            contentStream.endText();

            contentStream.close();

            pdfDocument.save("Student-Feedback.pdf");

            pdfDocument.close();

            System.out.println("PDF created successfully with Times Roman font.");

        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
}
