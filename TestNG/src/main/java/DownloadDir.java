import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.util.HashMap;

public class DownloadDir {

    WebDriver driver;
    @Test
    public void start(){
        // Create an instance of ChromeOptions
        ChromeOptions options = new ChromeOptions();

// Set the download directory
        String downloadDir = "C:\\Downloads";
        HashMap<String, Object> chromePrefs = new HashMap<>();
        chromePrefs.put("download.default_directory", downloadDir);
        options.setExperimentalOption("prefs", chromePrefs);

// Create an instance of the ChromeDriver with the options
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);

    }
}
