package DesktopTesting;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.appium.java_client.windows.WindowsDriver;
import io.appium.java_client.windows.WindowsElement;

public class DesktopExcelTc2 {
	
	// private static WindowsDriver<WindowsElement> wdriver = null;
	 public static RemoteWebDriver wdriver=null;
	   // private static WebElement CalculatorResult = null;

	
	    @BeforeClass
	    public static void setup() {
	        try {
	            DesiredCapabilities capabilities = new DesiredCapabilities();
	            capabilities.setCapability("app", "‪D:\\Esign.exe");
	           // capabilities.setCapability("appArguments", "C:\\Users\\Amit\\Documents\\test2.xlsx");
	            capabilities.setCapability("ms:waitForAppLaunch", "10");
	            wdriver=new WindowsDriver(new URL("http://0.0.0.0:4723/wd/hub"),capabilities);
	           // wdriver = new WindowsDriver<WindowsElement>(new URL("http://127.0.0.1:4723"), capabilities);
	            wdriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	            wdriver.manage().window().maximize();
	            
	           
	            
	            
	            Assert.assertNotNull(wdriver);

	        }catch(Exception e){
	            e.printStackTrace();
	        } 
	    }

	    @AfterTest
	    public static void TearDown()
	    {
	       
	            wdriver.quit();
	      
	    }
	    
	    @Test
	    public void start() throws InterruptedException  {
	    	
	    	
	    	
//	   wdriver.launchApp();
//	   
//	 
//	//Rectangle coordinate=   wdriver.findElementByName("A").getRect();
//  wdriver.findElementByAccessibilityId("A1").click();
//  Actions build = new Actions(wdriver); //Select Al
//  build.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();
//  wdriver.findElementByName("Select All").click();
//  wdriver.findElementByAccessibilityId("FormatCellsMenu").click();
//  
//  wdriver.findElementByName("AutoFit Column Width").click();
//  wdriver.findElementByName("Close").click();
//	 wdriver.findElementByName("Don't Save").click();
//      	
	    }

}
