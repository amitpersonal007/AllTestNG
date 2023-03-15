import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class IMEIGenerator {
    private static final int NUM_IMEI = 30;
    private static final String CSV_FILE = "/Users/amits/Downloads/new_file_n.csv";

    public static void main(String[] args) {
        try {
            FileWriter writer = new FileWriter(CSV_FILE);
            writer.write("IMEI\n"); // write header row

            for (int i = 0; i < NUM_IMEI; i++) {
                String imei = generateRandomIMEI();
                writer.write(imei + "\n"); // write IMEI to file
            }

            writer.close();
            System.out.println("IMEI numbers written to file " + CSV_FILE);
        } catch (IOException e) {
            System.out.println("An error occurred while writing to file " + CSV_FILE);
            e.printStackTrace();
        }
    }

    private static String generateRandomIMEI() {
        Random rand = new Random();
        StringBuilder sb = new StringBuilder();

        // First 8 digits are TAC (Type Allocation Code)
        for (int i = 0; i < 8; i++) {
            sb.append(rand.nextInt(10));
        }

        // Next 6 digits are FAC (Final Assembly Code)
        sb.append("0000");

        // Last digit is the Luhn checksum
        int[] imeiArr = new int[15];
        for (int i = 0; i < 14; i++) {
            imeiArr[i] = Character.getNumericValue(sb.charAt(i));
        }
        imeiArr[14] = calculateLuhnChecksum(imeiArr);
        sb.append(imeiArr[14]);

        return sb.toString();
    }

    private static int calculateLuhnChecksum(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            int digit = arr[i];
            if (i % 2 == 0) {
                digit *= 2;
                if (digit > 9) {
                    digit -= 9;
                }
            }
            sum += digit;
        }
        int checksum = (10 - (sum % 10)) % 10;
        return checksum;
    }
}

