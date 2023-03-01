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
        boolean ele1visibility = false;
        boolean ele2visibility = false;

        WebElement ele1 = null;
        WebElement ele2 = null;

        driver.get("https://www.orangehrm.com/");

        try{
           ele1 = driver.findElement(By.xpath("//input[@id='Form_getForm_action_submitForm']"));
            ele1visibility = ele1.isDisplayed();
        }catch (Exception e){
            e.printStackTrace();
        }
        try{
         ele2 = driver.findElement(By.xpath("//div[@class='ld-flex web-menu-btn']//li[1]//a[1]"));
            ele2visibility = ele2.isDisplayed();
        }catch(Exception e){
            e.printStackTrace();
        }
        System.out.println("Is Displayed Verifeid");

        if(ele1visibility || ele2visibility){
            System.out.println("Element is visible");
        }

        else {
            System.out.println("Element is not visible");
        }
        
    }
    
}
