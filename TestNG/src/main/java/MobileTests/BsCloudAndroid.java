package MobileTests;

import java.net.URL;
import java.util.concurrent.TimeUnit;
import java.net.MalformedURLException;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

public class BsCloudAndroid {

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
    
    caps.setCapability("app", "bs://68ee515386570c9cf4fceaaa8279b4ec65b58ba2");
    
    
   
   driver = new IOSDriver<IOSElement>(new URL("https://"+userName+":"+accessKey+"@hub-cloud.browserstack.com/wd/hub"), caps);

    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
   driver.launchApp();
   Thread.sleep(10000);
 driver.findElement(By.xpath("//android.widget.TextView[@text =\"Login\"]")).click();
 driver.findElement(By.xpath("//android.widget.EditText[@resource-id=\"i0116\"]")).click();
 driver.findElement(By.xpath("//android.widget.EditText[@resource-id=\"i0116\"]")).sendKeys("qa3@ntucfirstcampus.com");
 driver.findElement(By.xpath("//android.widget.Button[@resource-id=\"idSIButton9\"]")).click();
 driver.findElement(By.xpath("(//android.widget.EditText)[2]")).click();
 driver.findElement(By.xpath("(//android.widget.EditText)[2]")).sendKeys("Welcome@2022");
 driver.findElement(By.xpath(" //android.widget.TextView[@resource-id=\"submitButton\"]")).click();
// driver.findElement(By.xpath("")).click();

 
   
    // The driver.quit statement is required, otherwise the test continues to execute, leading to a timeout.//android.widget.TextView[@text ="Login"]
    
  }
  
  @AfterTest
  public void tear() {
	  driver.quit();
	 
  }
 
}
