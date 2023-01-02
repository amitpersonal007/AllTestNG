import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.google.api.client.util.Key;

import io.github.bonigarcia.wdm.WebDriverManager;

public class KeyboardWeb {
	
	WebDriver driver;

	
	
	@Test
	public void keytest() throws InterruptedException, AWTException {
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		
		driver.get("https://infinceqabusinessclient-org-idp.fisquare.com/if/flow/infince-login/?next=%2F");
		
//		Robot robot = new Robot();
//		robot.keyPress(KeyEvent.VK_TAB);
//		Thread.sleep(5000);
//		robot.keyPress(KeyEvent.VK_TAB);
//		Thread.sleep(5000);
//		robot.keyPress(KeyEvent.VK_ENTER);

	
//	Actions build = new Actions(driver);
//	
	Thread.sleep(10000);
//	build.sendKeys(Keys.ENTER).perform();
//	Thread.sleep(5000);
//	build.sendKeys(Keys.TAB).perform();

		
		
		
		
	}
//	@AfterTest
//	public void tear() {
//		
//		driver.quit();
//		
//	}
	
}
