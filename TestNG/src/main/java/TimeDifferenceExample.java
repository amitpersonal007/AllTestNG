import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeDifferenceExample {
    public static void main(String[] args) {
        String startTimeString = "2023-04-26 09:30:00";
        String endTimeString = "2023-04-26 10:45:30";
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        try {
            Date startTime = format.parse(startTimeString);
            Date endTime = format.parse(endTimeString);

            long duration = endTime.getTime() - startTime.getTime();

            long diffInSeconds = duration / 1000 % 60;
            long diffInMinutes = duration / (60 * 1000) % 60;
            long diffInHours = duration / (60 * 60 * 1000);

            System.out.printf("%02d:%02d:%02d", diffInHours, diffInMinutes, diffInSeconds);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}

