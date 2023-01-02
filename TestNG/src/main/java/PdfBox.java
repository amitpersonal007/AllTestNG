

import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.URL;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.lowagie.text.pdf.codec.Base64.InputStream;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PdfBox {
	
	
	
	@Test
	public void validatepdf() throws IOException{
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("file:///C:/Users/Amit/Downloads/CE%20Vs%20Cloud%20(1).pdf");
        URL url = new URL(driver.getCurrentUrl());
        java.io.InputStream is = url.openStream();
        BufferedInputStream fileToParse = new BufferedInputStream(is);
        PDDocument document = null;
        try {
            document = PDDocument.load(fileToParse);
            String output = new PDFTextStripper().getText(document);
            System.out.println(output);
        } finally {
            if (document != null) {
                document.close();
            }
            fileToParse.close();
            is.close();
        }
        
    }
		
}

	
	

