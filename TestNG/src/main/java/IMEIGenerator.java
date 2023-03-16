import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class IMEIGenerator {
    public static void main(String[] args) {
        int numOfIMEIs = 10;
        String[] imeis = new String[numOfIMEIs];

        // Generate 30 random 7-digit numbers and concatenate them with "0000002"
        Random random = new Random();
        for (int i = 0; i < numOfIMEIs; i++) {
            int randomNum = random.nextInt(9000000) + 1000000;
            imeis[i] = "0000002" + String.valueOf(randomNum);
        }
        // Create a new CSV file with header "IMEI" and write the IMEI values to it
        String csvFile = "/Users/amits/Desktop/CSVFiles/newcsvfile.csv";
        File file = new File(csvFile);
        String absolutePath = file.getAbsolutePath();
        System.out.println(absolutePath);
        String csvHeader = "IMEI";
        try (FileWriter writer = new FileWriter(csvFile)) {
            writer.append(csvHeader);
            writer.append("\n");

            for (String imei : imeis) {
                writer.append(imei);
                writer.append("\n");
            }
            System.out.println("IMEIs generated and saved to file: " + csvFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
