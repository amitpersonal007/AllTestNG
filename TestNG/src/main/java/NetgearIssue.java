import java.io.IOException;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NetgearIssue {
static WebDriver driver;
	
	@BeforeTest
	public void Stepup() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
	}
	
	@Test
	public static void usejs() throws IOException, InterruptedException {
//		driver.get("https://testsigmacommunityvid.s3.ap-south-1.amazonaws.com/checkorder.zip");
//		driver.get("chrome://downloads/");
//		
//		String path=" return document.querySelector(\"body > downloads-manager\").shadowRoot.querySelector(\"#frb0\").shadowRoot.querySelector(\"#file-link\").firstChild.nodeValue";
//		
		 JavascriptExecutor jse=(JavascriptExecutor)driver;
		 
Object st =  jse.executeScript("return 8+4/2+10*3+5*10");

         //String select=  (String) jse.executeScript(path);
         
         System.out.println(st);
         
         
         
		
		
		
		
	
//		driver.get("https://maint-qa.insight.netgear.com/");
//		driver.findElement(By.xpath("//u[@id='signup-link']")).click();
//		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("equisdsd1@mailnator.com");
//		String sd=driver.findElement(By.xpath("//input[@id='email']")).getAttribute("value");
//		Thread.sleep(4000);
//		driver.findElement(By.xpath("//input[@id='ip_cnfEmail']")).click();
//		Thread.sleep(9000);
//		driver.findElement(By.xpath("//input[@id='ip_cnfEmail']")).sendKeys(sd);
//		driver.findElement(By.xpath("//input[@id='ip_firstName']")).click();
//		driver.findElement(By.xpath("//input[@id='ip_firstName']")).sendKeys("Elon");
//		driver.findElement(By.xpath("//input[@id='ip_lastName']")).click();
//		driver.findElement(By.xpath("//input[@id='ip_lastName']")).sendKeys("Watson");
//		driver.findElement(By.xpath("//input[@id='ip_pwdSignup']")).click();
//		driver.findElement(By.xpath("//input[@id='ip_pwdSignup']")).sendKeys("Test@321$");
//		driver.findElement(By.xpath("//input[@id='ip_cnfPwd']")).click();
//		driver.findElement(By.xpath("//input[@id='ip_cnfPwd']")).sendKeys("Test@321$");
//		driver.findElement(By.xpath("//md-checkbox[@class='md-primary text-input md-auto-horizontal-margin ng-pristine ng-untouched ng-empty ng-invalid ng-invalid-required']")).click();
//		driver.findElement(By.xpath("//button[@id='signupBtn_i']")).click();
	
	
		
	}
//	@AfterTest
//	public void teardown() {
//		driver.quit();
//		
//	}

}