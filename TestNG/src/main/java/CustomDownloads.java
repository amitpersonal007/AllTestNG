import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class CustomDownloads {
    WebDriver driver;

    @Test
    public void start(){



//        String downloadFilepath = "/Users/amits/Desktop/Sample";
//        HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
//        chromePrefs.put("profile.default_content_settings.popups", 0);
//        chromePrefs.put("download.default_directory", downloadFilepath);
//        ChromeOptions options = new ChromeOptions();
//        options.setExperimentalOption("prefs", chromePrefs);
//
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.get("https://staging-board.srush.io/");






    }
}
