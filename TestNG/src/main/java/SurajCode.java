import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.util.concurrent.TimeUnit;



public class SurajCode {

    public static void main(String[] args) throws InterruptedException, IOException {

        WebDriver driver = new ChromeDriver();



        driver.manage().window().maximize();

        driver.manage().deleteAllCookies();



        driver.get("https://classic.freecrm.com/index.html");



        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);



        Thread.sleep(3000);

        driver.findElement(By.name("username")).sendKeys("surajkpatra");

        driver.findElement(By.name("password")).sendKeys("Suraj@120496");



        WebElement loginBtn = driver.findElement(By.xpath("//input[contains(@type,'submit')]"));



        flash(driver,loginBtn); //highlight element



        drawBorder(driver, loginBtn); //draw border





        //take screenshot

        //File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

        //FileUtils.copyFile(src,new File("C:\\Users\\Chintu\\eclipse-workspace\\SeleniumPractice\\src\\test\\resources\\screenshots\\LoginButton.png"));



        //display an alert

        //generateAlert(driver, "There is an issue with the login button");



        clickElementByJS(driver, loginBtn);



    }



    private static void drawBorder(WebDriver driver, WebElement element) {



        JavascriptExecutor js =((JavascriptExecutor)driver);

        js.executeScript("arguments[0].style.border = '3px solid red'", element);



    }



    public static void flash(WebDriver driver, WebElement element) {



        //JavascriptExecutor js = ((JavascriptExecutor) driver);

        String bgColor = element.getCssValue("backgroundColor");

        for(int i=0;i<100;i++) {

            changeColor("rgb(0,200,0)",element,driver);

            changeColor(bgColor, element, driver);

        }

    }



    private static void changeColor(String color, WebElement element, WebDriver driver) {



        JavascriptExecutor js= ((JavascriptExecutor)driver);

        js.executeScript("arguments[0].style.backgroundColor = '"+color +"'", element);



        try {

            Thread.sleep(20);

        } catch (InterruptedException e) {



            e.printStackTrace();

        }



    }



    public static void generateAlert(WebDriver driver, String message) {

        JavascriptExecutor js = ((JavascriptExecutor)driver);

        js.executeScript("alert('"+message+"')");

    }

    public static void clickElementByJS(WebDriver driver, WebElement element) {
        JavascriptExecutor js = ((JavascriptExecutor)driver);

        js.executeScript("arguments[0].click():", element);

    }



}