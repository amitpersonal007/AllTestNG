import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class PdfFix {

    WebDriver driver;


    @Test
    public void start() throws InterruptedException, IOException {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
        driver.get("https://admin-uat.fairprice.com.sg/\n");
        Thread.sleep(5000);
        driver.findElement(By.xpath("//input[@id='okta-signin-username']\n")).sendKeys("dx.team@ntucenterprise.sg\n");
        driver.findElement(By.xpath("//input[contains(@id,'okta-signin-password')]\n")).sendKeys("Okta@E2E12345\n");
        driver.findElement(By.id("okta-signin-submit")).click();
        driver.get("https://admin-uat.fairprice.com.sg/customer-support/delivery-orders/70963393");

        driver.findElement(By.xpath("//input[@id='okta-signin-username']\n")).sendKeys("dx.team@ntucenterprise.sg\n");
        driver.findElement(By.xpath("//input[contains(@id,'okta-signin-password')]\n")).sendKeys("Okta@E2E12345\n");
        driver.findElement(By.id("okta-signin-submit")).click();

        Thread.sleep(5000);
        driver.findElement(By.xpath("//button[@class='invoice-button print-icon']\n")).click();
        Thread.sleep(10000);

        Set<String> windowHandles = driver.getWindowHandles();

        // Switch to the first window by index (0-based)
        driver.switchTo().window(new ArrayList<String>(windowHandles).get(1));


        BufferedInputStream fileParse;

        String url1 = driver.getCurrentUrl();
        System.out.println(url1);

        Thread.sleep(10000);

// Use JavaScript to convert the blob URL to a data URL
       // Use JavaScript to convert the blob URL to a data URL
        String script = "var xhr = new XMLHttpRequest();\n" +
                "xhr.open('GET', '" +url1 + "', false);\n" +
                "xhr.responseType = 'blob';\n" +
                "xhr.send(null);\n" +
                "return xhr.response;";

        String base64Data = (String) ((JavascriptExecutor) driver).executeScript(script);


        // Get the data URL from the JavaScript variable
        String dataUrl = (String) ((JavascriptExecutor) driver).executeScript("return window.dataUrl;");

// Convert the data URL to a byte array
        byte[] byteArray = Base64.getDecoder().decode(dataUrl.split(",")[1]);

// Load the byte array into a PDDocument object
        PDDocument document = PDDocument.load(new ByteArrayInputStream(byteArray));

        PDFTextStripper stripper = new PDFTextStripper();
        String text = stripper.getText(document);

// Print the text to the console
        System.out.println(text);

// Close the PDF document
        document.close();

    }

    @AfterTest
    public void tear(){
        driver.quit();
    }

}
