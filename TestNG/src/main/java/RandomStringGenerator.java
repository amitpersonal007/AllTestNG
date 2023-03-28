import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class RandomStringGenerator {

    public static void main(String[] args) {

        String staticValue = "RZASA";
        String csvFile = "/Users/amits/Downloads/TESTING - Sheet1.csv";
        int numStrings = 10;
        Random random = new Random();

        // Generate 10 random strings
        String[] randomStrings = new String[numStrings];
        for (int i = 0; i < numStrings; i++) {
            String randomNum = String.format("%05d", random.nextInt(100000));
            randomStrings[i] = staticValue + randomNum;
        }

        // Update the CSV file
        try {
            FileWriter writer = new FileWriter(csvFile);
            for (String randomString : randomStrings) {
                writer.append(randomString + "\n");
            }
            writer.flush();
            writer.close();
            System.out.println("Random strings updated in " + csvFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
