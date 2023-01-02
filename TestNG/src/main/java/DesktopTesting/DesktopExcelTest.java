package DesktopTesting;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.windows.WindowsDriver;
import io.appium.java_client.windows.WindowsElement;

public class DesktopExcelTest {
	
	 private static WindowsDriver<WindowsElement> wdriver = null;
	   // private static WebElement CalculatorResult = null;

	
	    @BeforeClass
	    public static void setup() {
	        try {
	            DesiredCapabilities capabilities = new DesiredCapabilities();
	            capabilities.setCapability("app", "C:\\Program Files\\Microsoft Office\\root\\Office16\\EXCEL.EXE");
	            capabilities.setCapability("appArguments", "C:\\Users\\Amit\\Documents\\test.xlsx");
	            capabilities.setCapability("ms:waitForAppLaunch", "10");
	            wdriver = new WindowsDriver<WindowsElement>(new URL("http://127.0.0.1:4723"), capabilities);
	            wdriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	            wdriver.manage().window().maximize();
	            
	            //Thread.sleep(5000);
	            
	            
	            Assert.assertNotNull(wdriver);

	        }catch(Exception e){
	            e.printStackTrace();
	        } finally {
	        }
	    }

	    @AfterTest
	    public static void TearDown()
	    {
	       
	            wdriver.quit();
	      
	    }
	    
	    @Test
	    public void start() throws InterruptedException  {
	    	
	   wdriver.launchApp();
	   
	 
	  
	  wdriver.findElementByAccessibilityId("C3").click();
	  
	  wdriver.findElementByName("Format as Table").click();
	  Actions build = new Actions(wdriver);
	  build.sendKeys(Keys.ARROW_DOWN).perform();
	  build.sendKeys(Keys.ARROW_RIGHT).perform();
	  build.sendKeys(Keys.ENTER).perform();
	  build.sendKeys(Keys.ENTER).perform();
	  
	  
	  wdriver.findElementByAccessibilityId("TabHome").click();
	  wdriver.findElementByAccessibilityId("C3").click();
	  build.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();
	  
	  wdriver.findElementByAccessibilityId("AlignCenter").click();
	  
	  wdriver.findElementByName("Close").click();
	 
	  
	  wdriver.findElementByName("Don't Save").click();
	
	  Thread.sleep(5000);

	     	
	    }

}
