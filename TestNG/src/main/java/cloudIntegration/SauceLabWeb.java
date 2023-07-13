package cloudIntegration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class SauceLabWeb {
	
	
	@Test
	public void filesend() throws MalformedURLException, InterruptedException {
		ChromeOptions browserOptions = new ChromeOptions();
		browserOptions.setCapability("platformName", "Windows 11");
		browserOptions.setCapability("browserVersion", "latest");
		Map<String, Object> sauceOptions = new HashMap<>();
		sauceOptions.put("build", "<your build id>");
		sauceOptions.put("name", "<your test name>");
		browserOptions.setCapability("sauce:options", sauceOptions);

		URL url = new URL("https://testsigma-prod:513c92de-cf49-4731-a434-2a2bcd733689@ondemand.us-west-1.saucelabs.com:443/wd/hub");
		RemoteWebDriver driver = new RemoteWebDriver(url, browserOptions);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://ehub-test.ecxetrading.com/");
		driver.findElement(By.xpath("//input[@id='Email']\n")).sendKeys("testsigma@openecx.com");
		driver.findElement(By.xpath("//input[@id='Password']\n")).sendKeys("T35t0p3nECX5igm4!");
		driver.findElement(By.xpath("//button\n")).click();
		Thread.sleep(50000);

		driver.quit();
		
//	driver.get("https://www.africau.edu/images/default/sample.pdf");
//	JavascriptExecutor js = (JavascriptExecutor)driver;
//	js.executeScript("document.querySelector(\"#viewer\").shadowRoot.querySelector(\"#toolbar\").shadowRoot.querySelector(\"#downloads\").shadowRoot.querySelector(\"#download\").shadowRoot.querySelector(\"#icon\").click();");
//
	}

}
