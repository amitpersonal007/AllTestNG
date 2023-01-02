package MobileTests;

import io.appium.java_client.ios.IOSDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class LtTest {
	private static IOSDriver driver;
	
	@BeforeClass
	public void SetUp() throws MalformedURLException {
		
		 DesiredCapabilities capabilities = new DesiredCapabilities();
         capabilities.setCapability("deviceName", "iPhone 11");
         capabilities.setCapability("platformVersion", "14");
         capabilities.setCapability("platformName", "ios");
         capabilities.setCapability("isRealMobile", true);
         capabilities.setCapability("app", "lt://APP100201621651837558105942"); 
         capabilities.setCapability("deviceOrientation", "PORTRAIT");
         capabilities.setCapability("build", "Amit Lambdatest Automation");
         capabilities.setCapability("name", "Sample App Automation IOS");
         capabilities.setCapability("console", true);
         capabilities.setCapability("network", false);
         capabilities.setCapability("visual", true);
         capabilities.setCapability("devicelog", true);

         driver = new IOSDriver(new URL("https://amit.sabyasachi7:iZNeUV4DmTSij2LhklkFeZ1VuDoUzgeY7dpVhPFbbAAVz9ktRe@beta-hub.lambdatest.com/wd/hub"), capabilities);

		
	}
	
	@Test
	public void execute() throws InterruptedException {
		
		for(int i=0;i<=4000;i++) {
			
			driver.launchApp();
			driver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"terms_condition_checkbox\"]")).click();
			//driver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"terms_condition_agree_button\"]")).click();
			//Thread.sleep(5000);
			//driver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"Continue\"]")).click();
			//driver.findElement(By.xpath("")).click();
			//driver.findElement(By.xpath("")).click();
			driver.getPageSource();
			Thread.sleep(5000);
			System.out.print(driver.getContext());
			
		}
		
		driver.closeApp();
		
   
    }
    }