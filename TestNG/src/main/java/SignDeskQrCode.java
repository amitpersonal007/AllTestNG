import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.TakesScreenshot;
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

public class SignDeskQrCode {
	WebDriver driver;
	
	@Test
	public void getqrcode() throws InterruptedException, IOException {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
		//driver.get("https://infinceqanewbusinessclient.fisquare.com/home/");
		driver.get("https://signdesk.in/emandate-uat/#/inviteemandate/create/495cb1eda58dbbe3d3d7d7a61a240d20965bfa44e23b4029/invite");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//img[@src='./assets/img/pdf-preview.png']")).click();
		Thread.sleep(5000);
		
	
		WebElement ele = driver.findElement(By.xpath("//div[@class='textLayer']")); // element 1
		Rectangle dimension = ele.getRect();
		File file =ele.getScreenshotAs(OutputType.FILE);  // Getting Element Screenshot
//		File DestFile=new File("C:\\Users\\Amit\\git\\repository\\TestNG\\src\\main\\resources\\image.png");  // file path
//		
//		FileUtils.copyFile(file, DestFile); // Putting screenshot to the file 
		
		BufferedImage image = ImageIO.read(file); 
//		int height = image.getHeight();
//		int width = image.getWidth();
		
		/**
		 * Crops an image to the specified region
		 * @param bufferedImage the image that will be crop
		 * @param x the upper left x coordinate that this region will start
		 * @param y the upper left y coordinate that this region will start
		 * @param width the width of the region that will be crop
		 * @param height the height of the region that will be crop
		 * @return the image that was cropped.
		 */
		//System.out.println(height+" "+width);
		//BufferedImage croppedImage = image.getSubimage(230, 180, width-200, height-200); //Trimming the screenshot and storing the image as buffered image
		BufferedImage croppedImage = image.getSubimage(550, 375, 85,90);  //550, 375, 83,90
		File pathFile = new File("C:\\Users\\Amit\\Desktop\\Folder\\cool.png"); 
	    ImageIO.write(croppedImage,"png", pathFile);

	    		
	    System.out.println(pathFile.getAbsolutePath());
	    Date date = new Date();
	    Calendar calendar = Calendar.getInstance();
	    long timeMilli = date.getTime();
	    long timeMilli2 = calendar.getTimeInMillis();
	    String version = String.valueOf(timeMilli+timeMilli2);
	    
	    System.out.println(version);
	    OkHttpClient client = new OkHttpClient().newBuilder()
				  .build();
				MediaType mediaType = MediaType.parse("text/plain");
				RequestBody body = new MultipartBody.Builder().setType(MultipartBody.FORM)
				  .addFormDataPart("fileContent",pathFile.getAbsolutePath(),
				    RequestBody.create(MediaType.parse("application/octet-stream"),
				    new File( pathFile.getAbsolutePath())))
				  .addFormDataPart("projectId","11")
				  .addFormDataPart("name","TESTSIGMA")
				  .addFormDataPart("uploadType","Attachment")
				  .addFormDataPart("platformType","TestsigmaLab")
				  .addFormDataPart("isPublic","true")
				  .addFormDataPart("applicationId","25")
				  .addFormDataPart("Version",version)
				  .build();
				Request request = new Request.Builder()
				  .url("https://app.testsigma.com/api/v1/uploads/621")
				  .method("PUT", body)
				  .addHeader("Authorization", "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiIzMTllN2FhNi0yNzE2LTQ4ZWYtYTk5MS02NTkyN2ZlNWZjYzQiLCJkb21haW4iOiJ0ZXN0c2lnbWF0ZWNoLmNvbSIsInRlbmFudElkIjoyODE3fQ.QtozWfaxGYZcUuPIbNzfEXFLstWZ_MuNTaS1w2pQKy5c2RgivzucUmPx21gsQ_6ePqG0LS5Cn3PAeEBGjW1QRQ")
				  .build();
				Response response = client.newCall(request).execute();
	    				System.out.println(response.code() + response.body().string());
	    		
	
	}
	
	@AfterTest
	public void endtest() {
		driver.quit();
	}

}
