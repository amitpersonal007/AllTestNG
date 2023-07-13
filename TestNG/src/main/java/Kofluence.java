import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Kofluence {

    WebDriver driver;

    @Test
    public void executr() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://app.kofluence.com/login");

        driver.findElement(By.xpath("//input[@id='mobileInput']")).sendKeys("8008007796");
        driver.findElement(By.xpath("//button[@id='getOtpBtn']")).click();
        driver.findElement(By.xpath("//input[@id='otpInput']")).sendKeys("010119");
        driver.findElement(By.xpath("//button[@id='otpSubmit']")).click();
        driver.findElement(By.xpath("//span[normalize-space()='Demo_StunningHeroXpulse']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[contains(text(),'Shortlist')]")).click();
        Thread.sleep(9000);
       driver.findElement(By.xpath("//div[contains(text(),'FOLLOWERS')]/following-sibling::div[contains(@class, 'TitleHeading_sortingContainer')]/DIV[1]")).click();
        Thread.sleep(9000);
        driver.findElement(By.xpath("//div[contains(text(),'FOLLOWERS')]/following-sibling::div[contains(@class, 'TitleHeading_sortingContainer')]/DIV[1]/DIV[1]\n")).click();
        Thread.sleep(9000);

        List<WebElement> elementList =driver.findElements(By.xpath("//tr[position() > 1]//td[6]\n"));
        //driver.findElement(By.xpath("")).sendKeys("");
        List<String> textList = new ArrayList<String>();
        for (WebElement element : elementList) {
            String textValue = element.getText();
           textList.add(textValue);
        }
        System.out.println(textList);



        boolean isAscending = true;
        double previousValue1 = Double.NEGATIVE_INFINITY;

        for (String value : textList) {
            double currentValue = Double.parseDouble(value.replace("K", ""));
            if (currentValue < previousValue1) {
                isAscending = false;
                break;
            }
            previousValue1 = currentValue;
        }

        if (isAscending) {
            System.out.println("The list is in ascending order by its value.");
        } else {
            System.out.println("The list is not in ascending order by its value.");
        }


        driver.quit();

    }
}
