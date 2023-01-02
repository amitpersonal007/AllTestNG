package cloudIntegration;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class SauceLabWeb {
	
	
	@Test
	public void filesend() throws MalformedURLException {
		ChromeOptions browserOptions = new ChromeOptions();
		browserOptions.setCapability("platformName", "Windows 11");
		browserOptions.setCapability("browserVersion", "latest");
		Map<String, Object> sauceOptions = new HashMap<>();
		sauceOptions.put("build", "<your build id>");
		sauceOptions.put("name", "<your test name>");
		browserOptions.setCapability("sauce:options", sauceOptions);

		URL url = new URL("https://testsigma-prod:513c92de-cf49-4731-a434-2a2bcd733689@ondemand.us-west-1.saucelabs.com:443/wd/hub");
		RemoteWebDriver driver = new RemoteWebDriver(url, browserOptions);
		
	driver.get("https://www.africau.edu/images/default/sample.pdf");
	JavascriptExecutor js = (JavascriptExecutor)driver;
	js.executeScript("document.querySelector(\"#viewer\").shadowRoot.querySelector(\"#toolbar\").shadowRoot.querySelector(\"#downloads\").shadowRoot.querySelector(\"#download\").shadowRoot.querySelector(\"#icon\").click();");
	
	}

}
