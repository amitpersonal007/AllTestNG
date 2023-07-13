import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class HighCharts {

    WebDriver driver;
    @Test
    public void stetup() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("https://www.highcharts.com/demo/line-basic");

        Thread.sleep(20000);

        WebElement chartElement = driver.findElement(By.xpath("(//*[name()='path'][@aria-label='x, 2017, 165,174. Installation & Developers.'])[1]"));

        Actions actions = new Actions(driver);
        actions.moveToElement(chartElement).perform();

        // Wait for the tooltip to appear (you may need to modify the wait time based on your scenario)
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement tooltipElement = driver.findElement(By.xpath("(//*[name()='path'][@class='highcharts-halo highcharts-color-0'])[1]"));

        // Get the text value from the tooltip
        String tooltipText = tooltipElement.getText();
        System.out.println("Tooltip value: " + tooltipText);

    }
    @AfterTest
    public void teardown(){
        driver.quit();
    }

}
