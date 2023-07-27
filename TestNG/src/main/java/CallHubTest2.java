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
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CallHubTest2 {
    WebDriver driver;
    String country;
    String dollar;

    @BeforeTest
    public void setup() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://app.callhub.io/login/?lang=en");
    }

    @Test(priority = 1)
    public void login() {
        try {
            driver.findElement(By.xpath("//input[@id='id_user']"))
                    .sendKeys("amit.savyasachi@testsigma.com");
            driver.findElement(By.xpath("//button[@id='change-btn-text']"))
                    .click();
            driver.findElement(By.xpath("//input[@id='id_password']"))
                    .sendKeys("Test@123");
            driver.findElement(By.xpath("//button[@id='change-btn-text']"))
                    .click();
            String currentURL = driver.getCurrentUrl();
            Assert.assertEquals(currentURL, "https://app.callhub.io/guide/");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

    @Test(priority = 2, dataProvider = "countryAndDollarData")
    public void navigation(String country, String dollar) {

        //Point 1
        this.country = country;
        this.dollar = dollar;

        driver.findElement(By.cssSelector("a[href='/number/']")).click();
        driver.findElement(By.xpath("//a[@href='/number/search/cc/']"))
                .click();
        WebElement countryDropdown = driver.findElement(By.id("id_country_iso"));
        Select sel = new Select(countryDropdown);
        sel.selectByVisibleText(country);
        driver.findElement(By.xpath("//input[@id='add']")).click();

        String textOfFirstRow = driver.findElement(By.xpath("//tbody/tr/td"))
                .getText();

        String pattern = "\\d(\\d{3})"; // Code for trimming the area code from the number
        Pattern regex = Pattern.compile(pattern);
        Matcher matcher = regex.matcher(textOfFirstRow);
        String areaCode = "";
        if (matcher.find()) {
            areaCode = matcher.group(1);
        } else {
            System.out.println("No match found.");
        }
        System.out.println("Next three digits: " + areaCode);

        driver.findElement(By.xpath("//input[@id='id_prefix']"))
                .sendKeys(areaCode);
        driver.findElement(By.xpath("//input[@id='add']")).click();
        WebDriverWait wait = new WebDriverWait(driver, 10);

        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//table[@class='table table-striped table-condensed common-no-margin-all']")));
            System.out.println("Table Is Visible");
            String dollarValue = driver.findElement(By.xpath("//tbody/tr//td[2]"))
                    .getText();
            Assert.assertTrue(dollarValue.contains(dollar), "Dollar Value does not match");
        } catch (Exception e) {
            System.out.println("Table is not visible or Dollar value does not match for the country");
        }

        driver.findElement(By.xpath("(//tbody/tr//td)[4]/a")).click();
//Point 2
        WebElement element = driver.findElement(
                By.xpath("//div[@class='bootbox modal fade in']"));
        if (element.isDisplayed()) {
            System.out.println("Modal Popup is displayed");
            String modalText = driver.findElement(
                            By.xpath("//div[@class='bootbox modal fade in']/div"))
                    .getText();
            System.out.println(modalText);
            System.out.println(textOfFirstRow);
            SoftAssert softAssert = new SoftAssert();
            softAssert.assertTrue(modalText.contains(textOfFirstRow), "Text does not match in modal");
        } else {
            System.out.println("Modal Popup is not displayed");
        }

        driver.navigate().refresh();
    }

    @Test(priority = 3, dependsOnMethods = "navigation") //Point3
    public void computeSum() {
        String numberFromTable = driver.findElement(By.xpath("//tbody/tr/td"))
                .getText();

        String remainingDigits = numberFromTable.substring(4);
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

    @DataProvider(name = "countryAndDollarData")
    public Object[][] countryAndDollarData() {
        return new Object[][]{
                {"UNITED STATES (+1)", "2.00"},


                // Add more test data as needed
        };
    }

    @AfterTest
    public void teardown() {
        driver.quit();
    }
}

