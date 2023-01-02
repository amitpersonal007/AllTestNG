

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.text.PDFTextStripperByArea;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class EmulateGeolocation {

    public static String hubURL = "https://hub.lambdatest.com/wd/hub";
    private WebDriver driver;

    @Test
    public void setup() throws InterruptedException, IOException {
    	DesiredCapabilities capabilities = new DesiredCapabilities();
    	capabilities.setCapability("browserName", "Chrome");
    	capabilities.setCapability("browserVersion", "104.0");
    	HashMap<String, Object> ltOptions = new HashMap<String, Object>();
    	ltOptions.put("username", "engineeringtestsigma");
    	ltOptions.put("accessKey", "XK6ARxr0FsuYM7Uur0FdNVMMRRTrG7VGMWiEwLE5ASBSN8gqOO");
    	ltOptions.put("geoLocation", "IN");
    	ltOptions.put("platformName", "Windows 11");
    	ltOptions.put("project", "Untitled");
    	capabilities.setCapability("LT:Options", ltOptions);

        ChromeOptions options = new ChromeOptions();

     
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);

        driver = new RemoteWebDriver(new URL(hubURL), capabilities);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.hyundai.com/in/en/click-to-buy/request-a-brochure");
       // driver.findElement(By.xpath("https://www.hyundai.com/in/en/click-to-buy/request-a-brochure"));
        WebElement Element=driver.findElement(By.xpath("//a[@href='/content/dam/hyundai/in/en/data/brochure/Tucson_suv_brochure.pdf']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", Element);
        
        Element.click();
        
        Thread.sleep(5000);
        
        try (PDDocument document = PDDocument.load(new File("C:\\\\Users\\\\ltuser\\\\Downloads\\\\Tucson_suv_brochure.pdf"))) {
//Tucson_suv_brochure.pdf
            document.getClass();

            if (!document.isEncrypted()) {
            
                PDFTextStripperByArea stripper = new PDFTextStripperByArea();
                stripper.setSortByPosition(true);

                PDFTextStripper tStripper = new PDFTextStripper();

                String pdfFileInText = tStripper.getText(document);
                //System.out.println("Text:" + st);

                // split by whitespace
                String lines[] = pdfFileInText.split("\\r?\\n");
                for (String line : lines) {
                    System.out.println(line);
                }

            }
        

        driver.quit();
    }

   
}}