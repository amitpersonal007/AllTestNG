import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CallHubTest {
    WebDriver driver;

   @BeforeTest
    public void setup() throws InterruptedException {

       WebDriverManager.chromedriver().setup();
       driver =new ChromeDriver();
       driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
       //driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
       driver.manage().window().maximize();
       driver.get("https://app.callhub.io/login/?lang=en");
      // Thread.sleep(5000);
    }

    @Test (priority = 1)
    public void login(){
       try {
           driver.findElement(By.xpath("//input[@id='id_user']")).sendKeys("amit.savyasachi@testsigma.com");
           driver.findElement(By.xpath("//button[@id='change-btn-text']")).click();
           driver.findElement(By.xpath("//input[@id='id_password']")).sendKeys("Test@123");
           driver.findElement(By.xpath("//button[@id='change-btn-text']")).click();
           String currentURl = driver.getCurrentUrl();
           Assert.assertEquals(currentURl,"https://app.callhub.io/guide/");

       }
       catch(Exception e){
           e.printStackTrace();
           System.out.println(e.getMessage());
       }

    }

    @Test (priority = 2)
    public void navigation(){

       //Point 1
     driver.findElement(By.cssSelector("a[href='/number/']")).click();
     driver.findElement(By.xpath("//a[@href='/number/search/cc/']")).click();
     WebElement Countrydropdown = driver.findElement(By.id("id_country_iso"));
     Select sel = new Select(Countrydropdown);
     sel.selectByVisibleText("UNITED STATES (+1)");
//     WebElement type = driver.findElement(By.id("id_country_iso"));
//     Select seltype = new Select(type);
//     seltype.selectByVisibleText("Any");


    String textoffirstrow= driver.findElement(By.xpath("//tbody/tr/td")).getText();

     String pattern = "\\d(\\d{3})"; //Code for trimming the area code from the number
        Pattern regex = Pattern.compile(pattern);
        Matcher matcher = regex.matcher(textoffirstrow);
        String areacode = "";
        if (matcher.find()) {
            areacode = matcher.group(1);
        } else {
            System.out.println("No match found.");
        }
        System.out.println("Next three digits: " + areacode);

        driver.findElement(By.xpath("//input[@id='id_prefix']")).sendKeys(areacode);
        driver.findElement(By.xpath("//input[@id='add']")).click();
        WebDriverWait wait = new WebDriverWait(driver, 10);

        //wait until table is visible and validate if the dollar value is same [Point 2]
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@class='table table-striped table-condensed common-no-margin-all']")));
            System.out.println("Table Is Visible");
            String dollarvalue = driver.findElement(By.xpath("//tbody/tr//td[2]")).getText();
            Assert.assertTrue(dollarvalue.contains("2.00"), "Dollar Value does not match");

        } catch (Exception e) {
            System.out.println("Table is not visible or Dollar value does not match for the country");
        }

        //tap modal and validate the number
        driver.findElement(By.xpath("(//tbody/tr//td)[4]/a")).click();

        WebElement element = driver.findElement(By.xpath("//div[@class='bootbox modal fade in']"));
        // Assert if call hub modal pop up is present post clicking on the Buy button
        if (element.isDisplayed()) {
            System.out.println("Modal Popup is displayed");
         String modaltext =driver.findElement(By.xpath("//div[@class='bootbox modal fade in']/div")).getText();
            Assert.assertTrue(modaltext.contains(textoffirstrow), "Text does not match in modal");

        } else {
            System.out.println("Modal Popup is not displayed");
        }
        driver.navigate().refresh();
    }
    @Test (priority = 3)

    //Point 3
    public void computesum(){

       String numberfromtable= driver.findElement(By.xpath("//tbody/tr/td")).getText();

                String remainingDigits = numberfromtable.substring(4);
                long remainingNumber = Long.parseLong(remainingDigits);
                long sum = 0;
                while (remainingNumber > 0) {
                    sum += remainingNumber % 10;
                    remainingNumber /= 10;
                }

                if (sum % 2 == 0) {
                    System.out.println("The resulting number is even.");
                } else {
                    System.out.println("The resulting number is odd.");
                }
            }

    @AfterTest
    public void teardown(){
       driver.quit();
    }
}
