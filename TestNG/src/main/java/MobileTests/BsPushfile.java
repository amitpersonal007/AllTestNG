package MobileTests;



import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
import java.net.MalformedURLException;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

public class BsPushfile {

  public static String userName = "rukmangada1";
  public static String accessKey = "PzpzSFEGNQUaWXpzNok5";
 
  IOSDriver<IOSElement> driver;

  @Test
  public void run()throws MalformedURLException, InterruptedException {
    DesiredCapabilities caps = new DesiredCapabilities();

    caps.setCapability("device", "iPhone 13");
    caps.setCapability("osVersion", "15.0");
    caps.setCapability("project", "My First Project");
    caps.setCapability("build", "Amit Appium Test");
    caps.setCapability("name", "Amit TestNg");
    
    
   caps.setCapability("browserstack.uploadMedia", new String[]{"media://3b0be784c50072e616dbdb70bd451d41d3d3fbb3"});
   // caps.setCapability("app", "bs://ee899069d3d1b89fb4b487783da7027e131ea19d");
    
    
   
   driver = new IOSDriver<IOSElement>(new URL("https://"+userName+":"+accessKey+"@hub-cloud.browserstack.com/wd/hub"), caps);

    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
   

    driver.get("https://the-internet.herokuapp.com/upload");
    driver.context("NATIVE_APP");
    
   
    WebElement uploadElement = driver.findElement(By.xpath("(//XCUIElementTypeButton[@name=\"Choose File\"])[1]"));
    uploadElement.click();
    WebElement chooseFile = driver.findElement(By.xpath("(//XCUIElementTypeButton[@name=\"Choose File\"])[2]"));
    
    chooseFile.click();
    
    driver.runAppInBackground(Duration.ofMinutes(-1));
    Thread.sleep(10000);
   
   Thread.sleep(50000);
    
  }
  
  @AfterTest
  public void tear() {
	  driver.quit();
	 
  }
 
}
