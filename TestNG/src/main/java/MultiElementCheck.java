import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class MultiElementCheck {
    WebDriver driver;

    @Test
    public void execute() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        int count = 0;
        while (count < 20) {
            boolean isElement1Displayed = false;
            boolean isElement2Displayed = false;
            boolean isElement3Displayed = false;

            try {
                WebElement element1 = driver.findElement(By.xpath("//xpath/to/element1"));
                isElement1Displayed = element1.isDisplayed();
                if (isElement1Displayed) {
                    System.out.println("Element 1 is displayed.");
                    break;
                }
            } catch (NoSuchElementException e) {
                // Element not found, do nothing
            }

            try {
                WebElement element2 = driver.findElement(By.xpath("//xpath/to/element2"));
                isElement2Displayed = element2.isDisplayed();
                if (isElement2Displayed) {
                    System.out.println("Element 2 is displayed.");
                    break;
                }
            } catch (NoSuchElementException e) {
                // Element not found, do nothing
            }

            try {
                WebElement element3 = driver.findElement(By.xpath("//xpath/to/element3"));
                isElement3Displayed = element3.isDisplayed();
                if (isElement3Displayed) {
                    System.out.println("Element 3 is displayed.");
                    break;
                }
            } catch (NoSuchElementException e) {
                // Element not found, do nothing
            }

            count++;
            Thread.sleep(1000); // Wait for 1 second before checking again

        }

        if (count == 20) {
            System.out.println("None of the 3 elements were displayed within 20 iterations.");
        }

        driver.quit();

    }
}
