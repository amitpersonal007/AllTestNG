import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CsvRead {
	
	
	@Test
       public void pdflocal() throws IOException, CsvException{
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		File s1 = getLastModified("/Users/amits/Downloads");
		System.out.println(s1.getName());
		Reader reader = new FileReader(s1.getAbsolutePath());
		File file = new File(s1.getName());
		String fileName = file.getName();
		
		CSVReader csvreader = new CSVReader(reader);
		System.out.println("The name of the CSV file is: " + fileName);
		List<String[]> data = csvreader.readAll();
		System.out.println(data.size());
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