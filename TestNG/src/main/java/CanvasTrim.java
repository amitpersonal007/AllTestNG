
import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CanvasTrim {
	WebDriver driver;
	
	@Test
	public void navigation() throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
	    driver= new ChromeDriver();
	    
	    driver.get("https://rccsentinelnew-qa.azurewebsites.net");
//	    TakesScreenshot scrShot =((TakesScreenshot)driver);
//	    File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);

        
    
	}
	
}


