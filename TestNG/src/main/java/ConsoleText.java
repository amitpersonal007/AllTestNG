
import java.util.logging.Level;
import java.util.stream.Collectors;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ConsoleText {
	
	
	
	
	@Test
	public void execution() throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();    
		LoggingPreferences logPrefs = new LoggingPreferences();
		logPrefs.enable(LogType.BROWSER, Level.ALL);
		options.setCapability("goog:loggingPrefs", logPrefs);
		WebDriver driver = new ChromeDriver(options);
		
		driver.get("https://rebuy-staging-automation.myshopify.com/");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("rebuyacademy");
		driver.findElement(By.xpath("//button[text()=\"Enter\"]")).click();
		
		Thread.sleep(5000);
		
		 LogEntries logEntries = driver.manage().logs().get("browser");
	        List<LogEntry> logEntryList = logEntries.getAll().stream().filter(logEntry -> logEntry.getLevel().equals(Level.INFO)).collect(Collectors.toList());
		
	      
	        String mess = logEntryList.toString();
	        
	        if (mess.toString().contains("Increased conversion rates")) {
	        	System.out.println("Succ");
	        	
	        }
	        
	        else {
	        	System.out.println("faoil");
	        }
		
	
		
	}
	

}
