public class TimestampFinder {
    public static void main(String[] args) {
        String inputString = "User1,User3,User820210719153649";

        String appendedText = findAppendedTextWithTimestamp(inputString);
        System.out.println("Appended Text with Timestamp: " + appendedText);

        String dataWithoutTimestamps = findDataWithoutTimestamp(inputString);
        System.out.println("Data without Timestamp: " + dataWithoutTimestamps);

        String oldestAppendedText = findOldestAppendedText(inputString);
        System.out.println("Appended Text with Oldest Timestamp: " + oldestAppendedText);
    }

    public static String findAppendedTextWithTimestamp(String inputString) {
        StringBuilder appendedText = new StringBuilder();

        int startIndex = inputString.indexOf("User2");
        if (startIndex != -1) {
            int endIndex = startIndex + "User2".length() + 14;
            appendedText.append(inputString, startIndex, endIndex).append(",");
        } else {
            appendedText.append("Not Found");
        }

        // Remove the trailing comma if any
        if (appendedText.length() > 0) {
            appendedText.setLength(appendedText.length() - 1);
        }

        return appendedText.toString();
    }

    public static String findDataWithoutTimestamp(String inputString) {
        String[] users = inputString.split(",");
        StringBuilder dataWithoutTimestamps = new StringBuilder();

        for (String user : users) {
            if (!user.contains("User2")) {
                dataWithoutTimestamps.append(user).append(",");
            }
        }

        // Remove the trailing comma if any
        if (dataWithoutTimestamps.length() > 0) {
            dataWithoutTimestamps.setLength(dataWithoutTimestamps.length() - 1);
        }

        return dataWithoutTimestamps.toString();
    }

    public static String findOldestAppendedText(String inputString) {
        String[] users = inputString.split(",");
        String oldestTimestamp = null;
        String oldestAppendedText = null;

        for (String user : users) {
            if (user.startsWith("User2")) {
                String timestampStr = user.substring("User2".length());
                if (oldestTimestamp == null || timestampStr.compareTo(oldestTimestamp) < 0) {
                    oldestTimestamp = timestampStr;
                    oldestAppendedText = user.substring(0, "User2".length());
                }
            }
        }

        return oldestAppendedText;
    }
}
