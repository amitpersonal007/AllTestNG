import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class OpenEcx {
    WebDriver driver;

    @Test
    public void run() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://ehub-test.ecxetrading.com/");
        driver.findElement(By.xpath("//input[@id='Email']\n")).sendKeys("testsigma@openecx.com");
        driver.findElement(By.xpath("//input[@id='Password']\n")).sendKeys("T35t0p3nECX5igm4!");
        driver.findElement(By.xpath("//button\n")).click();
        Thread.sleep(50000);

    }
    @AfterTest
    public void tear(){
        driver.quit();
    }

}
