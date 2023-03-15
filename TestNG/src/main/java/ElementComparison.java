import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ElementComparison {

    public static void main(String[] args) {
        String webpageUrl = "https://www.orangehrm.com/";
        final String CSV_FILE = "/Users/amits/Downloads/new_file_n.csv";
        String columnName = "column1";

        // Set up Selenium WebDriver
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();


        // Load webpage
        driver.get("https://www.orangehrm.com/");

        // Get all elements from webpage
        List<String> webpageElements = new ArrayList<>();
        List<WebElement> elements = driver.findElements(By.xpath("//button"));
        for (WebElement element : elements) {
            String text = element.getText().trim();
            if (!text.isEmpty()) {
                webpageElements.add(text);
            }
        }

        // Read column from CSV file
        List<String> csvColumn = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(CSV_FILE))) {
            String line = reader.readLine(); // Skip header row
            while ((line = reader.readLine()) != null) {
                String[] values = line.split(",");
                csvColumn.add(values[0]); // Assuming the column is the first one
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Compare lists
        if (webpageElements.equals(csvColumn)) {
            System.out.println("The lists are equal.");
        } else {
            System.out.println("The lists are not equal.");
        }

        // Clean up
        driver.quit();
    }

}

