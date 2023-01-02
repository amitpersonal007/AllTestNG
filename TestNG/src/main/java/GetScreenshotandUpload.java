import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class GetScreenshotandUpload {
	
	WebDriver driver;
	@Test
	protected void screenshotgenerator() throws IOException {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
		
		driver.navigate().to("https://www.orangehrm.com/features/hr-administration");
		
	WebElement ele = driver.findElement(By.xpath("//div[@class='d-flex web-menu-btn']//li[1]//a[1]"));
	
	File file =ele.getScreenshotAs(OutputType.FILE); 
	String path = file.getAbsolutePath();
	OkHttpClient client = new OkHttpClient().newBuilder()
			  .build();
			MediaType mediaType = MediaType.parse("text/plain");
			RequestBody body = new MultipartBody.Builder().setType(MultipartBody.FORM)
			  .addFormDataPart("fileContent","",
			    RequestBody.create(MediaType.parse("application/octet-stream"),
			    new File(path)))
			  .addFormDataPart("projectId","11")
			  .addFormDataPart("name","TESTSIGMA")
			  .addFormDataPart("uploadType","Attachment")
			  .addFormDataPart("platformType","TestsigmaLab")
			  .addFormDataPart("isPublic","true")
			  .addFormDataPart("applicationId","25")
			  .addFormDataPart("Version","1234sd0014")
			  .build();
			Request request = new Request.Builder()
			  .url("https://app.testsigma.com/api/v1/uploads/621")
			  .method("PUT", body)
			  .addHeader("Authorization", "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiIzMTllN2FhNi0yNzE2LTQ4ZWYtYTk5MS02NTkyN2ZlNWZjYzQiLCJkb21haW4iOiJ0ZXN0c2lnbWF0ZWNoLmNvbSIsInRlbmFudElkIjoyODE3fQ.QtozWfaxGYZcUuPIbNzfEXFLstWZ_MuNTaS1w2pQKy5c2RgivzucUmPx21gsQ_6ePqG0LS5Cn3PAeEBGjW1QRQ")
			  .build();
			Response response = client.newCall(request).execute();
			
  
	        System.out.println(response.code());
	
	
	}
	
	@AfterTest
	private  void teardown() {
		
		driver.quit();
	}

}
