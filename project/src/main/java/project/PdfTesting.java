package project;

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
                    contentStream.beginText();
                    contentStream.setFont(PDType1Font.HELVETICA_BOLD, 12);
                    contentStream.newLineAtOffset(100, 700);
                    contentStream.showText("This is a test on page "+i);
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