import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CodeMirror {
	
	
	@Test
	public void codemirror() {
		
		WebDriver driver;
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.get("http://codemirror.net/demo/theme.html");

		String js_call = "window.editor.setValue(\"Hello World\"); ";

		JavascriptExecutor js = (JavascriptExecutor)driver;

		js.executeScript(js_call);
		
		//driver.quit();
		
	}

}
