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

public class WordAutomation {
	
	 private static WindowsDriver<WindowsElement> wdriver = null;
	   // private static WebElement CalculatorResult = null;

	
	    @BeforeClass
	    public static void setup() {
	        try {
	            DesiredCapabilities capabilities = new DesiredCapabilities();
	            capabilities.setCapability("app", "C:\\Program Files\\Microsoft Office\\root\\Office16\\WINWORD.EXE");
	           // capabilities.setCapability("appArguments", "C:\\Users\\Amit\\Documents\\Doc1.docx");
	            capabilities.setCapability("ms:waitForAppLaunch", "6");
	            wdriver = new WindowsDriver<WindowsElement>(new URL("http://127.0.0.1:4723"), capabilities);
	            wdriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	            wdriver.manage().window().maximize();
	           
	            Assert.assertNotNull(wdriver);

	        }catch(Exception e){
	            e.printStackTrace();
	        } finally {
	        }
	    }

	    @AfterTest
	    public static void TearDown()
	    {
	       
	           // wdriver.quit();
	      
	    }
	    
	    @Test
	    public void start() throws InterruptedException  {
	    	 Actions build = new Actions(wdriver);
	   wdriver.launchApp();
	   wdriver.findElementByName("Blank document").click();
	   wdriver.findElementByAccessibilityId("Body").click();
	   build.sendKeys("Test").sendKeys(Keys.ENTER).sendKeys("Test 1").sendKeys(Keys.ENTER).sendKeys("Test2").perform();
	   
	   
	   build.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();
	   
	   wdriver.findElementByName("Numbering").click();
	   wdriver.findElementByAccessibilityId("FileTabButton").click();
	   wdriver.findElementByName("Save As").click();
	   wdriver.findElementByName("Browse").click();
	
	   
	   wdriver.findElementByAccessibilityId("1001").clear();
	   wdriver.findElementByAccessibilityId("1001").sendKeys("Numbering");
	   wdriver.findElementByAccessibilityId("2").click();
	   wdriver.findElementByName("Home").click();
	   wdriver.findElementByName("Blank document").click();
	   wdriver.findElementByAccessibilityId("Body").click();
	   build.sendKeys("Hello").sendKeys(Keys.ENTER).sendKeys("Jan").sendKeys(Keys.ENTER).sendKeys("Testsigma").perform();
	   wdriver.findElementByAccessibilityId("TellMeTextBoxAutomationId").click();
	   wdriver.findElementByName("Find").click(); //Search document"
	   wdriver.findElementByName("Search document").click();
	   wdriver.findElementByName("Search document").sendKeys("Jan");
	   Thread.sleep(5000);
	   build.sendKeys(Keys.ESCAPE).perform();
	   wdriver.findElementByAccessibilityId("FileTabButton").click();  
	   wdriver.findElementByName("Open").click();
	   wdriver.findElementByName("Browse").click();
	   wdriver.findElementByName("File name:").click();
	   wdriver.findElementByAccessibilityId("1090").click();
	  wdriver.findElementByAccessibilityId("1148").sendKeys("Doc1"); 
	  
	  
	  for (int i=0;i<=2;i++) {
		  build.sendKeys(Keys.TAB).perform();
	  }
	  
	  for (int i=0;i<=7;i++) {
		  build.sendKeys(Keys.ARROW_DOWN).perform();
	  }
	  
	  build.sendKeys(Keys.ENTER).perform();
	  
	  wdriver.findElementByName("Close").click();
	  wdriver.findElementByName("Don't Save").click();
	    	
	    }

}
