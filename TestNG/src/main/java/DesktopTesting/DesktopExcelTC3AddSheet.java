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

public class DesktopExcelTC3AddSheet {
	
	 private static WindowsDriver<WindowsElement> wdriver = null;
	 
	    @BeforeClass
	    public static void setup() {
	        try {
	            DesiredCapabilities capabilities = new DesiredCapabilities();
	            capabilities.setCapability("app", "C:\\Program Files\\Microsoft Office\\root\\Office16\\EXCEL.EXE");
	           
	            capabilities.setCapability("ms:waitForAppLaunch", "8");
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
	   wdriver.findElementByName("Blank workbook").click();
	   Thread.sleep(5000);
	   wdriver.findElementByName("Add Sheet").click();
	WindowsElement ele=   wdriver.findElementByName("Sheet2");
	Actions build = new Actions(wdriver);
	build.doubleClick(ele).perform();
	build.sendKeys(Keys.BACK_SPACE).perform();
	ele.sendKeys("Test1");
	build.sendKeys(Keys.ENTER).perform();
	 wdriver.findElementByName("Add Sheet").click();
	 WindowsElement ele2=   wdriver.findElementByName("Sheet3");
	
		build.doubleClick(ele2).perform();
		build.sendKeys(Keys.BACK_SPACE).perform();
		ele.sendKeys("Test2");
		build.sendKeys(Keys.ENTER).perform();
	
		 wdriver.findElementByAccessibilityId("FileTabButton").click();
		  wdriver.findElementByName("Save As").click();
		  wdriver.findElementByName("Browse").click();
		  
		  wdriver.findElementByAccessibilityId("1001").clear();
		  wdriver.findElementByAccessibilityId("1001").sendKeys("TestsigmaExcelSheet");
		  wdriver.findElementByAccessibilityId("FileTypeControlHost").click();
		  
		  for(int i=0;i<=2;i++) {
			  build.sendKeys(Keys.ARROW_DOWN).perform();
		  }
		  build.sendKeys(Keys.ENTER).perform();
		  wdriver.findElementByAccessibilityId("2").click();
		  wdriver.findElementByName("Options").click();
		  wdriver.findElementByName("Add-ins").click();
		  wdriver.findElementByName("Go...").click();
		  wdriver.findElementByName("Solver Add-in").click();
		  wdriver.findElementByName("OK").click();
		  wdriver.findElementByAccessibilityId("FileTabButton").click();
		  wdriver.findElementByName("Options").click();
		  wdriver.findElementByName("General").click();
		  build.keyDown(Keys.ALT).sendKeys("c").keyDown(Keys.ALT).perform();
		  wdriver.findElementByName("OK").click();		  
		  wdriver.findElementByName("Close").click();
		  wdriver.findElementByName("Don't Save").click();
      	
	    }

}
