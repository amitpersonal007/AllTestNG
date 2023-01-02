
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

public class DesktopPowerPointTc1 {
	
	 private static WindowsDriver<WindowsElement> wdriver = null;
	  
	    @BeforeClass
	    public static void setup() {
	        try {
	            DesiredCapabilities capabilities = new DesiredCapabilities();
	            capabilities.setCapability("app", "C:\\Program Files\\Microsoft Office\\root\\Office16\\POWERPNT.EXE");
	            capabilities.setCapability("appArguments", "C:\\Users\\Amit\\Documents\\ppt01.pptx");
	            capabilities.setCapability("ms:waitForAppLaunch", "5");
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
	       
	          wdriver.quit();
	      
	    }
	    
	    @Test
	    public void start() throws InterruptedException  {
	    	
	   wdriver.launchApp();   
	   wdriver.findElementByName("Customize Toolbar").click();
	   wdriver.findElementByName("Show Below the Ribbon").click();
	   wdriver.findElementByAccessibilityId("Slide256Image").click();
	   
	   
 
  Actions build = new Actions(wdriver); 
  
  for(int i=0;i<=5;i++) {
	  build.sendKeys(Keys.ENTER).perform();
  }
  
  wdriver.findElementByAccessibilityId("1071").click();
  wdriver.findElementByAccessibilityId("1071").click();
  
  wdriver.findElementByAccessibilityId("Slide257Image").click();
  wdriver.findElementByName("Title TextBox").click();
  
  wdriver.findElementByName("Title TextBox").sendKeys("Sample Testigma Script");
  
  Thread.sleep(3000);
  
  wdriver.findElementByAccessibilityId("Slide261Image").click();
  wdriver.findElementByName("Title TextBox").click();
  
  wdriver.findElementByName("Title TextBox").sendKeys("Text Test Sample");
  wdriver.findElementByName("Content Placeholder").click();
  wdriver.findElementByName("Content Placeholder").sendKeys("Welcome to testsigma platform");
  
 
  wdriver.findElementByAccessibilityId("TabTransitions").click();
  wdriver.findElementByName("Transition Effects").click(); 
  wdriver.findElementByName("Curtains").click();
  
  Thread.sleep(4000);
  
  wdriver.findElementByAccessibilityId("TabHome").click();
  build.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();
  
  wdriver.findElementByAccessibilityId("AlignCenter").click();
  wdriver.findElementByName("Title TextBox").click();
  build.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();
  wdriver.findElementByAccessibilityId("AlignCenter").click();

  wdriver.findElementByName("Open").click();
  
  wdriver.findElementByName("Arial Black").click();
  
  
  wdriver.findElementByName("Customize Toolbar").click();
  wdriver.findElementByName("Show Above the Ribbon").click();
  
  wdriver.findElementByAccessibilityId("FileTabButton").click();
  wdriver.findElementByName("Save As").click();
  wdriver.findElementByName("Browse").click();
  wdriver.findElementByAccessibilityId("1001").clear();
  wdriver.findElementByAccessibilityId("1001").sendKeys("TestsigmaTestfiles");
  wdriver.findElementByAccessibilityId("FileTypeControlHost").click(); 
 
  for(int i=0;i<=4;i++) {
	  build.sendKeys(Keys.ARROW_DOWN).perform();
  }
  build.sendKeys(Keys.ENTER).perform();
  wdriver.findElementByAccessibilityId("2").click();
  
  wdriver.findElementByName("Open").click();
  wdriver.findElementByName("Browse").click();  
  wdriver.findElementByName("File name:").click();
  wdriver.findElementByName("File name:").sendKeys("ppt1");
  wdriver.findElementByAccessibilityId("1090").click();
 wdriver.findElementByAccessibilityId("1148").sendKeys("ppt1"); 
 
 build.sendKeys(Keys.ENTER).perform();
 
 wdriver.findElementByAccessibilityId("FileTabButton").click();  
 wdriver.findElementByName("Info").click();  
 wdriver.findElementByName("Check for Issues").click(); 
 wdriver.findElementByName("Inspect Document").click();
 
 wdriver.findElementByAccessibilityId("2").click();  
 
 wdriver.findElementByName("Inspect").click();  

 wdriver.findElementByName("Remove All Document Properties and Personal Information").click();
 build.sendKeys(Keys.ARROW_RIGHT).perform();
 build.sendKeys(Keys.ENTER).perform();
 wdriver.findElementByName("Close").click();
 wdriver.findElementByName("Don't Save").click();
 
	    }

}
