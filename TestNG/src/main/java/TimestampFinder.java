import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TimestampFinder {
    public static void main(String[] args) {
        String inputString = "U1,U220210719153659,U3";

        String appendedText = findAppendedTextWithTimestamp(inputString);
        System.out.println("Appended Text with Timestamp: " + appendedText);

        String dataWithoutTimestamps = findDataWithoutTimestamp(inputString);
        System.out.println("Data without Timestamp: " + dataWithoutTimestamps);
    }

    public static String findAppendedTextWithTimestamp(String inputString) {
        Pattern pattern = Pattern.compile("\\bU(\\d{14})\\b");
        Matcher matcher = pattern.matcher(inputString);

        StringBuilder appendedText = new StringBuilder();
        while (matcher.find()) {
            String timestampStr = matcher.group(1);
            appendedText.append("U").append(timestampStr.substring(1)).append(",");
        }

        // Remove the trailing comma if any
        if (appendedText.length() > 0) {
            appendedText.setLength(appendedText.length() - 1);
        } else {
            appendedText.append("Not Found");
        }

        return appendedText.toString();
    }

    public static String findDataWithoutTimestamp(String inputString) {
        Pattern pattern = Pattern.compile("\\bU\\d+\\b");
        Matcher matcher = pattern.matcher(inputString);

        StringBuilder dataWithoutTimestamps = new StringBuilder();
        while (matcher.find()) {
            String data = matcher.group();
            if (!inputString.contains(data + ",")) {
                dataWithoutTimestamps.append(data).append(",");
            }
        }

        // Remove the trailing comma if any
        if (dataWithoutTimestamps.length() > 0) {
            dataWithoutTimestamps.setLength(dataWithoutTimestamps.length() - 1);
        }

        return dataWithoutTimestamps.toString();
    }
}
