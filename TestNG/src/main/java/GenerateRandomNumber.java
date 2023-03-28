import java.util.concurrent.ThreadLocalRandom;

public class GenerateRandomNumber {
    public static void main(String[] args) {
        long lowerBound = 40; // Change this to the lower bound of the range
        long upperBound = 94; // Change this to the upper bound of the range

        long randomNumber = generateRandomLong(lowerBound, upperBound);
        System.out.println("Random long number between " + lowerBound + " and " + upperBound + ": " + randomNumber);
    }

    public static long generateRandomLong(long lowerBound, long upperBound) {
        if (upperBound < lowerBound) {
            throw new IllegalArgumentException("Invalid bounds");
        }
        return ThreadLocalRandom.current().nextLong(lowerBound, upperBound + 1);
    }
}
