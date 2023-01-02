import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LocalPdf {
	
	
	
	@Test
	public void pdflocal() throws IOException{
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("file:///C:/Users/Amit/Documents/cdriver.pdf");
		URL  url1 = new URL(driver.getCurrentUrl()); 
	    String url = String.valueOf(url1);
		
		//String url = "file:///C:/Users/Amit/Documents/cdriver.pdf";
		
		URL pdfURL = new URL(url);
	    InputStream is = pdfURL.openStream();
	    BufferedInputStream bis = new BufferedInputStream(is);
	    PDDocument doc = PDDocument.load(bis);
		PDFTextStripper strip = new PDFTextStripper();
		String stripText = strip.getText(doc);

	    System.out.println(stripText);
	}
	


}
