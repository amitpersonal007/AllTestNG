import java.time.Instant;
import java.time.format.DateTimeFormatter;

public class NewLogicTest {
    public static void main(String[] args) {
        String inputString = "U1,U2,U3";
        String substring = "U1";

        String outputString = appendTimestampToSubstring(inputString, substring);
        System.out.println("Output String: " + outputString);
    }
    public static String appendTimestampToSubstring(String inputString, String substring) {
        Instant timestamp = Instant.now();
        String timestampString = formatTimestamp(timestamp);
        String replacement = substring + timestampString;
       // String replacement = substring + timestamp;
        String outputString = inputString.replace(substring, replacement);
        return outputString;
    }
    public static String formatTimestamp(Instant timestamp) {
        DateTimeFormatter formatter = DateTimeFormatter.ISO_INSTANT;
        return formatter.format(timestamp);
    }
}

