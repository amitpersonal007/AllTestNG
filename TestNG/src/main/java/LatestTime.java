import okhttp3.*;

import java.io.IOException;
import java.time.Instant;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LatestTime {
    public static void main(String[] args) {

        try {
           String data = "abc@gmail.com2023-07-19T13:16:03.644753Z,test@cpd.com2023-07-19T13:16:03.64479 a3Z,stella@gmail.com2023-07-26T02:15:52.324661Z,mic@gmail.com";
//            Map.Entry<Instant, String> oldestDateInfo = findOldestDate(data);
//           System.out.println("Oldest Date: " + oldestDateInfo.getKey());
//           System.out.println("User with oldest Data: " + oldestDateInfo.getValue());
            String result1 = pickStringsWithoutTimestamp(data);
           // String result = removeSpecialCharacters(result1);
            System.out.println("Email without time stamp " + result1);

           // System.out.println("Strings without Timestamp: " + result1);
            if(result1.isEmpty()){
                Map.Entry<Instant, String> oldestDateInfo = findOldestDate(data);
                System.out.println("Oldest Date: " + oldestDateInfo.getKey());
                System.out.println("User with oldest Data: " + oldestDateInfo.getValue());
                System.out.println("Without time stamp is empty. Picking up the Oldest time User"+oldestDateInfo.getValue());
            }else{
                String randomEmail = pickRandomEmail(result1);
                System.out.println("Random User details without any time stamp--- " + randomEmail);
                Instant timestamp = Instant.now();
                String timestampString = formatTimestamp(timestamp);
               String new1 = randomEmail+timestampString;
                String outputString = data.replaceAll(randomEmail, new1);
               System.out.println("Replaced value  "+outputString);
                updateenv(outputString);

            }

        }
        catch(Exception e) {

            e.printStackTrace();
        }

    }

    public static Map.Entry<Instant, String> findOldestDate(String data) {
        Pattern pattern = Pattern.compile("([a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[A-Z|a-z]{2,})(\\d{4}-\\d{2}-\\d{2}T\\d{2}:\\d{2}:\\d{2}\\.\\d{6}Z)");
        Matcher matcher = pattern.matcher(data);
        Instant oldestDate = null;
        String oldestUserData = null;

        while (matcher.find()) {
            String userData = matcher.group(1);
            String timestampString = matcher.group(2);
            Instant currentTimestamp = Instant.parse(timestampString);

            if (oldestDate == null || currentTimestamp.isBefore(oldestDate)) {
                oldestDate = currentTimestamp;
                oldestUserData = userData;
            }
        }

        return new HashMap.SimpleEntry<>(oldestDate, oldestUserData);
    }
    public static String pickStringsWithoutTimestamp(String inputString) {

        Pattern pattern = Pattern.compile("\\b[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Z|a-z]{2,}\\b");
        Matcher matcher = pattern.matcher(inputString);
        StringBuilder resultBuilder = new StringBuilder();
        while (matcher.find()) {
            String value = matcher.group();
            resultBuilder.append(value).append(",");
        }

        // Remove the trailing comma if any
        if (resultBuilder.length() > 0) {
            resultBuilder.setLength(resultBuilder.length() - 1);
        }

        return resultBuilder.toString();
    }


    public static String pickRandomEmail(String emailsString) {
        if (emailsString == null || emailsString.isEmpty()) {
            throw new IllegalArgumentException("Email string cannot be empty or null.");
        }

        String[] emails = emailsString.split(",");
        Random random = new Random();
        int randomIndex = random.nextInt(emails.length);

        return emails[randomIndex].trim();
    }

    public static String formatTimestamp(Instant timestamp) {
        DateTimeFormatter formatter = DateTimeFormatter.ISO_INSTANT;
        return formatter.format(timestamp);
    }

    public static void updateenv(String payload) throws IOException {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, "{\n" +
                "     \"projectId\":\"567\",\n" +
                "    \"parameters\": {\n" +
                "         \"email\": \""+payload+"\"\n" +
                "}\n" +
                "}");
        Request request = new Request.Builder()
                .url("https://app.testsigma.com/api/v1/environments/274")
                .method("PUT", body)
                .addHeader("Authorization", "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJlOWVhYmQzYi05YjdhLTQ3NWYtOTI4MS1jYjUyODc5ZDU2NGUiLCJkb21haW4iOiJ0ZXN0c2lnbWF0ZWNoLmNvbSIsInRlbmFudElkIjoyODE3fQ.XBr9AhnM_kL4UPyv-yWxRc24yV4KhYJ41g0QlUVzClFi2Xo34Nsm2cFMwKY_4Md25f9OraapUPBGJ23KYnonVA")
                .addHeader("Content-Type", "application/json")
                .build();
        Response response = client.newCall(request).execute();

    }
}


