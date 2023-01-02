import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FindElements {
	WebDriver driver;
	
	String name=null;
	String name2=null;
	
	@Test
	public void navigation() throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
	    driver= new ChromeDriver();
		
        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://app.thelayer.com/sso/logon");
		
		driver.findElement(By.xpath("//input[@id='UserName']")).sendKeys("rojie.rajan");
		driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("Quadwave@123");
		driver.findElement(By.xpath("//input[@value='Sign In']")).click();
		
		driver.get("https://app.thelayer.com/Settings/ProductCategory/edit/147");
		driver.findElement(By.xpath("//a[normalize-space()='Service Core Fields']")).click();
		
		TreeSet<String> var1 = getListofCheckedItems();
		TreeSet<String> var2 = listafterscroll();
		
		
		
		//TreeSet<String> var3 = new TreeSet<>(var2.toString());
		
		System.out.println(var1.size());
		System.out.println(var2.remove(var2.first()));
		System.out.println(var2.size());
		
		for(String valueFromVar: var2) {
			if(var1.contains(valueFromVar)) {
				System.out.println(valueFromVar);
				
			}else {
				System.out.println("NP");
				System.out.println("NP");
			}
			
		}
		
//		if(var2.toString().contains(var1.toString())==false) {
//			var2.removeAll(var1);
//			System.out.println(var2);
//			
//		}else if(var2.toString().contains(var1.toString())==false) {
//			var2.removeAll(var1);
//			System.out.println("sample----"+var2);
//			
//		}
	
		}
	 
	public TreeSet<String> getListofCheckedItems() throws InterruptedException {
		 HashSet<String> s =new HashSet<String>();
		 Thread.sleep(5000);
	List<WebElement> listings = driver.findElements(By.xpath("//tr/td[5]/input[@checked=\"checked\"]//ancestor::tr/td[6]/input[contains(@name,\"ServiceCoreFieldsViewModelList\")]"));
	  for (WebElement checkedItems : listings) {
		   s.add(checkedItems.getAttribute("value")) ;
      } 
	  TreeSet<String> treeSet = new TreeSet<String>(s);
     
	  return  treeSet;
	}
	
	public TreeSet<String> listafterscroll() throws InterruptedException {
		
		
		 driver.get("https://app.thelayer.com/SalesOrderCapture/Index/1086?baseCategoryId=147&productTypeId=2&page=1&pageSize=2500");
		 HashSet<String> scrollList =new HashSet<String>();
		 
		  ((JavascriptExecutor) driver).executeScript("document.querySelector(\"#divHandsOnTable_SalesOrderDataCapture > div.ht_master.handsontable.innerBorderLeft > div\").scrollLeft=1000");
		  Thread.sleep(5000);
		  List<WebElement> listings2 = driver.findElements(By.xpath("//tr/th/div/span[@class=\"colHeader columnSorting\"][last()]")); 
		   for (WebElement webElement2 : listings2) {
			   scrollList.add(webElement2.getText());
	        }
		   
		   ((JavascriptExecutor) driver).executeScript("document.querySelector(\"#divHandsOnTable_SalesOrderDataCapture > div.ht_master.handsontable.innerBorderLeft > div\").scrollLeft=2500");  
		   Thread.sleep(5000);
		   List<WebElement> listings3 = driver.findElements(By.xpath("//tr/th/div/span[@class=\"colHeader columnSorting\"][last()]"));
		   for (WebElement webElement3 : listings3) {
			   scrollList.add(webElement3.getText());
	        }
		   
		   ((JavascriptExecutor) driver).executeScript("document.querySelector(\"#divHandsOnTable_SalesOrderDataCapture > div.ht_master.handsontable.innerBorderLeft > div\").scrollLeft=4000");
			  Thread.sleep(5000);
			   List<WebElement> listings4 = driver.findElements(By.xpath("//tr/th/div/span[@class=\"colHeader columnSorting\"][last()]")); 
			  
			   for (WebElement webElement4 : listings4) {
				   scrollList.add(webElement4.getText());
		           
		        }
			    
			   ((JavascriptExecutor) driver).executeScript("document.querySelector(\"#divHandsOnTable_SalesOrderDataCapture > div.ht_master.handsontable.innerBorderLeft > div\").scrollLeft=5500");
				  Thread.sleep(5000);
				   List<WebElement> listings5 = driver.findElements(By.xpath("//tr/th/div/span[@class=\"colHeader columnSorting\"][last()]")); 
				  
				   for (WebElement webElement5 : listings5) {
					   scrollList.add(webElement5.getText());
			           
			        }
				   
				   ((JavascriptExecutor) driver).executeScript("document.querySelector(\"#divHandsOnTable_SalesOrderDataCapture > div.ht_master.handsontable.innerBorderLeft > div\").scrollLeft=7000");
					  Thread.sleep(5000);
					   List<WebElement> listings6 = driver.findElements(By.xpath("//tr/th/div/span[@class=\"colHeader columnSorting\"][last()]")); 
					   Thread.sleep(5000);
					   for (WebElement webElement6 : listings6) {
						   scrollList.add(webElement6.getText());
				           
				        }
					   
 ((JavascriptExecutor) driver).executeScript("document.querySelector(\"#divHandsOnTable_SalesOrderDataCapture > div.ht_master.handsontable.innerBorderLeft > div\").scrollLeft=7200");
	 Thread.sleep(5000);
				List<WebElement> listings7 = driver.findElements(By.xpath("//tr/th/div/span[@class=\"colHeader columnSorting\"]")); 
						   Thread.sleep(5000);
						   for (WebElement webElement7 : listings7) {
							   scrollList.add(webElement7.getText());
					           
					        }
						   
						   TreeSet<String> treeSet2 = new TreeSet<String>(scrollList);
				          
			   return treeSet2;
			   	   
	}
	
	@AfterTest
	public void tear() {
		driver.quit();
		
		
	}

}
