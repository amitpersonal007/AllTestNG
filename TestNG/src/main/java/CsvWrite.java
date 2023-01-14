
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvException;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CsvWrite {
	
	
	@Test
       public void pdflocal() throws IOException, CsvException{
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
	    File s1 = getLastModified("/Users/amitsavyasachi/Downloads");
		String fileName2 = s1.getAbsolutePath();
		Reader reader = new FileReader(fileName2);
		String replace = "TEstSIGMA";
		CSVReader csvreader = new CSVReader(reader);
		List<String[]> data = csvreader.readAll();
		
		data.get(3)[21] = replace;
		csvreader.close();
		
		CSVWriter writer = new CSVWriter(new FileWriter(fileName2));
		writer.writeAll(data);
		writer.flush();
		writer.close();
    		
		driver.quit();

		
	}
	
	public static File getLastModified(String directoryFilePath)
	{
	    File directory = new File(directoryFilePath);
	    File[] files = directory.listFiles(File::isFile);
	    long lastModifiedTime = Long.MIN_VALUE;
	    File chosenFile = null;

	    if (files != null)
	    {
	        for (File file : files)
	        {
	            if (file.lastModified() > lastModifiedTime)
	            {
	                chosenFile = file;
	                lastModifiedTime = file.lastModified();
	            }
	        }
	    }

	    return chosenFile;
	}
	

}
