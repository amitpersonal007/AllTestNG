package MobileTests;

import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.net.MalformedURLException;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class GleacBs {

  public static String userName = "rukmangada1";
  public static String accessKey = "PzpzSFEGNQUaWXpzNok5";
 
  AndroidDriver<AndroidElement> driver;

  @Test
  public void run()throws MalformedURLException, InterruptedException {
    DesiredCapabilities caps = new DesiredCapabilities();

    caps.setCapability("device", "Google Pixel 6");
    caps.setCapability("osVersion", "12.0");
    caps.setCapability("project", "Amit Appium Project");
    caps.setCapability("build", "Amit Appium Test");
    caps.setCapability("name", "Amit TestNg");
    caps.setCapability("realMobile", "true");
    caps.setCapability("browserstack.networkLogs", "true");
    
    
    caps.setCapability("app", "bs://c558ea74d26439336a3d90c23a34732bc7541b05");
    
    
   
   driver = new AndroidDriver<AndroidElement>(new URL("https://"+userName+":"+accessKey+"@hub-cloud.browserstack.com/wd/hub"), caps);

    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
   driver.launchApp();
   Thread.sleep(10000);
 driver.findElement(By.xpath("//android.widget.Button[@content-desc=\"Continue\"]")).click();
 driver.findElement(By.xpath("//android.view.View[@content-desc=\"Continue\"]")).click();
 driver.findElement(By.xpath("//android.widget.Button[@content-desc=\"Create Account\"]//following::android.widget.ImageView[2]")).click();
 driver.findElement(By.xpath("//android.widget.EditText[@resource-id=\"identifierId\"]")).clear();
 driver.findElement(By.xpath("//android.widget.EditText[@resource-id=\"identifierId\"]")).sendKeys("gleacautomation@gmail.com");
 driver.findElement(By.xpath("//*[@text=\"Next\"]")).click();
 driver.findElement(By.xpath("//android.view.View[@resource-id=\"password\"]/android.view.View/android.view.View/android.widget.EditText")).click();
 driver.findElement(By.xpath("//android.view.View[@resource-id=\"password\"]/android.view.View/android.view.View/android.widget.EditText")).sendKeys("Arun@696");
 driver.findElement(By.xpath("//*[@text=\"Next\"]")).click();
// driver.findElement(By.xpath("//*[@text=\"Don’t turn on\"]")).click();
// driver.findElement(By.xpath("")).click();
//
// driver.findElement(By.xpath("")).click();

 driver.findElement(By.xpath("//android.widget.Button[@text =\"I agree\"]")).click();
// driver.findElement(By.xpath("//*[@text=\"Don’t turn on\"]")).click();
// driver.findElement(By.xpath("//android.widget.Button[@text =\"Accept\"]")).click();

 
   Thread.sleep(5000);  //*[@text="Don’t turn on"]
    // The driver.quit statement is required, otherwise the test continues to execute, leading to a timeout.//android.widget.TextView[@text ="Login"]
    
  }
  
  @AfterTest
  public void tear() {
	  this.driver.quit();
	 
  }
 
}
