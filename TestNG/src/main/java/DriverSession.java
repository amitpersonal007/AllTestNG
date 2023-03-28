import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class DriverSession {


    @Test
    public void Sesstion(){
        WebDriver admindriver;
        WebDriver customerdriver;

        WebDriverManager.chromedriver().setup();

        admindriver= new ChromeDriver();
        customerdriver= new ChromeDriver();

        admindriver.get("https://www.orangehrm.com/");
        admindriver.findElement(By.xpath("")).click();
        customerdriver.get("https://fast.com/");
        admindriver.findElement(By.xpath("")).sendKeys("");

    }
}
