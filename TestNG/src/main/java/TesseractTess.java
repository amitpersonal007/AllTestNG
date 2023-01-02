import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

public class TesseractTess {
	
	WebDriver driver;
	@Test
	public void test() throws IOException, TesseractException {
		
		final String URLSL = "https://krukmangada:846508c1-b42d-4fc7-a1e1-0770df454237@ondemand.us-west-1.saucelabs.com:443/wd/hub";
		    DesiredCapabilities caps = DesiredCapabilities.chrome();
		    caps.setCapability("platform", "Windows 10");
		    caps.setCapability("version", "latest");
		    caps.setCapability("name", "Amit Test");
		    caps.setCapability("extendedDebugging", "true");
		    caps.setCapability("buildNumber", "3.0");
		    WebDriver driver = new RemoteWebDriver(new java.net.URL(URLSL), caps);
		driver.get("https://opensource-demo.orangehrmlive.com/");
		
	
		
		try {

			WebElement wb=driver.findElement(By.xpath("//span[normalize-space()='( Username : Admin | Password : admin123 )']"));
			 File elementImage= wb.getScreenshotAs(OutputType.FILE);
			 File tempfile;
			 tempfile = File.createTempFile("temp", ".png");
				String temppath=tempfile.getAbsolutePath();
				 FileUtils.copyFile(elementImage,new File(temppath));
				 Path destinationpath=Files.createTempDirectory("tessdata").toAbsolutePath();
				 File dir = new File(destinationpath.toString());
				 File engtraineddata=File.createTempFile("eng", ".traineddata",dir);
				 Path we=engtraineddata.toPath();
				 URL url1 = new URL("https://testsigmacommunityvid.s3.ap-south-1.amazonaws.com/tessdata/eng.traineddata");
				FileUtils.copyURLToFile(url1, engtraineddata);
				Files.move(we, we.resolveSibling("eng.traineddata"));						
				 ITesseract image=new Tesseract();
				 String tessdatapath=destinationpath.toString();
		      image.setDatapath(tessdatapath);
		      String text=image.doOCR(new File(temppath));
			System.out.println(text);
			driver.quit();
			
		}catch(Exception e) {
			
			e.printStackTrace();
			
		}	
	}

}
