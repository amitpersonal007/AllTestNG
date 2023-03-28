import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class HippoVideo {


    @Test
    public void filesend() throws MalformedURLException {
        ChromeOptions browserOptions = new ChromeOptions();
        browserOptions.setCapability("platformName", "Windows 11");
        browserOptions.setCapability("browserVersion", "latest");
        DesiredCapabilities caps = new DesiredCapabilities();
        ChromeOptions options = new ChromeOptions();

        options.addArguments("--use-fake-ui-for-media-stream");
        options.addArguments("--use-fake-device-for-media-stream");
        options.addArguments("--disable-notifications");
        options.addArguments("--auto-select-desktop-capture-source=Entire screen");
        options.addArguments("--auto-accept-camera-and-microphone-capture");



        URL url = new URL("https://testsigma-prod:513c92de-cf49-4731-a434-2a2bcd733689@ondemand.us-west-1.saucelabs.com:443/wd/hub");
        RemoteWebDriver driver = new RemoteWebDriver(url, options);

        driver.get("https://pre.hippovideo.io/video-templates/home?api_key=5EY0i8mD46BMmohMPWiNRgtt&email=deepa%2Btestingtemplatebuilder%40hippovideo.io\n");
driver.findElement(By.xpath("//div[@class='hvvtlisting-header']//a[@class='create-flow-btn']\n")).click();
driver.findElement(By.xpath("//div[@class='slides']//div[2]\n")).click();
driver.findElement(By.xpath("//button[normalize-space()='Camera Only']\n")).click();
        driver.quit();


    }}