package cloudIntegration;

import java.net.URL;
import java.util.HashMap;
import java.awt.AWTException;
import java.net.MalformedURLException;

import org.testng.annotations.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class BrowserstackWeb {

  public static String userName = "rukmangada1";
  public static String accessKey = "PzpzSFEGNQUaWXpzNok5";
 


  @Test
  public void run()throws MalformedURLException, InterruptedException, AWTException {
	  
	  MutableCapabilities capabilities = new MutableCapabilities();
	  capabilities.setCapability("browserName", "Safari");
	  capabilities.setCapability("browserVersion", "14.1");
	  HashMap<String, Object> browserstackOptions = new HashMap<String, Object>();
	  browserstackOptions.put("os", "OS X");
	  browserstackOptions.put("osVersion", "Big Sur");
	  browserstackOptions.put("projectName", "Amit Safari");
	  browserstackOptions.put("buildName", "Build 001");
	  browserstackOptions.put("sessionName", "Amit Safari Pop up test");
	  browserstackOptions.put("local", "false");
	  browserstackOptions.put("seleniumVersion", "3.141.59");
	  capabilities.setCapability("bstack:options", browserstackOptions);

    URL bsurl = new URL("https://"+userName+":"+accessKey+"@hub-cloud.browserstack.com/wd/hub");
     
     final WebDriver driver = new RemoteWebDriver (bsurl,  capabilities);
    driver.get("https://zs-uat.fairprice.com.sg/");
Actions build = new Actions(driver);

new Actions(driver)
.sendKeys("abc")
.perform();

build.keyDown(Keys.TAB).keyUp(Keys.TAB).build().perform();
//	Thread.sleep(5000);
//	robot.keyPress(KeyEvent.VK_TAB);
//	Thread.sleep(5000);
//	robot.keyPress(KeyEvent.VK_ENTER);
    
    driver.quit();
 
 
  }
  
//  @AfterTest
//  public void tear() {
//	  
//	  driver.quit();
//	 
//  }
 
}
