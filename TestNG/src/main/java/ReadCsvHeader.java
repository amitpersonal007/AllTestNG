import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;
import java.util.List;

public class ReadCsvHeader {

    @Test
    public void csvreaderhead() throws CsvValidationException, IOException {


        File s1 = getLastModified("/Users/amits/Downloads");
        Reader reader2 = new FileReader(s1.getAbsolutePath());
        CSVReader csvreader = new CSVReader(reader2);


        // Get the header from the CSV file
        String[] header = csvreader.readNext();

        // Convert the header to a list
        List<String> headerList = Arrays.asList(header);

        // Print the header content
        System.out.println(headerList);

        // Close the reader when done
        csvreader.close();


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
