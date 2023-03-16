import com.opencsv.CSVWriter;

import java.io.FileWriter;
import java.io.IOException;

public class WriteCSV {
    public static void main(String[] args) {
        String filePath = "/Users/amits/Downloads/TESTING - Sheet1.csv";

        String[] headers = {"IMEI"};
        String value = "TESTSIGMA";
        int numRows = 10; // The number of rows to write

        try {
            CSVWriter writer = new CSVWriter(new FileWriter(filePath));
            writer.writeNext(headers);
            for (int i = 0; i < numRows; i++) {
                String[] row = {value};
                writer.writeNext(row);
            }
            writer.close();
            System.out.println("Data written to " + filePath + " successfully!");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file: " + e.getMessage());
        }
    }
}
