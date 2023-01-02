import java.io.File;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ChromeExtension {
	
	
	
	
	@Test
	public void execution() {
		
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		String userProfile= "C:\\Users\\Amit\\AppData\\Local\\Google\\Chrome\\User Data\\Profile 2";
		
		options.addArguments("user-data-dir="+userProfile);
		options.addArguments("--start-maximized");
//		options.addArguments("--user-data-dir=C:/Users/Amit/AppData/Local/Google/Chrome/User Datas");
//		
//		options.addArguments("--profile-directory=Default");
		
	//	options.addArguments("load-extension=C:\\Users\\Amit\\Downloads\\Sample");
		//options.addExtensions(new File("D:\\HoppiVideo.crx"));
		WebDriver driver = new ChromeDriver(options);
		
		driver.get("chrome-extension://cijidiollmnkegoghpfobabpecdkeiah/popup.html");
		
		
		
	}
	

}
