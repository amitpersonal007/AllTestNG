import java.time.LocalDate;

public class TestRandom {
    public static void main(String[] args) {
        // get the current date
        LocalDate currentDate = LocalDate.now();

        // add two days to the current date
        LocalDate futureDate = currentDate.plusDays(2);

        // output the day of the month of the future date
        System.out.println("Current date: " + currentDate.getDayOfMonth());
        System.out.println("Future date (+2 days): " + futureDate.getDayOfMonth());
    }
}

