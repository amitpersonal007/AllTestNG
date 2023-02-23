import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MultiElementDispalyCheck {

    WebDriver driver;


    @Test
    public void execute(){

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.get("https://www.orangehrm.com/");

        WebElement ele1 = driver.findElement(By.xpath("//input[@id='Form_getForm_action_submitForm']"));
        WebElement ele2 = driver.findElement(By.xpath("//div[@class='d-flex web-menu-btn']//li[1]//a[1]"));

        boolean ele1visibility = ele1.isDisplayed();
        boolean ele2visibility = ele2.isDisplayed();


        if(ele1visibility || ele2visibility){
            System.out.println("Element is visible");
        }

        else {
            System.out.println("Element is not visible");
        }
        
    }
    
}
