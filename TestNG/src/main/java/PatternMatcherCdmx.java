import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternMatcherCdmx {
    public static void main(String[] args) {
        String s = "Test$|aam| lowda ";
        Pattern pattern = Pattern.compile("\\$\\|(.*?)\\|");
        Matcher matcher = pattern.matcher(s);
        
        List<String> extractedStrings = new ArrayList<>();
        while (matcher.find()) {
            String extractedString = matcher.group(1);
            extractedStrings.add(extractedString);
        }
        
        System.out.println(extractedStrings);

        String replacedString = extractedStrings.get(0);

        String newString = "Testsigma is a testing platform";


       String e = newString.replace("testing", replacedString);

       System.out.println(e);
       
    }
}
