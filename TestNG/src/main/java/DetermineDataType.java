import org.testng.annotations.Test;

import java.io.IOException;


public class DetermineDataType {

    String input="STISAS";

    @Test
    public void datatypecheck() throws IOException, ClassNotFoundException {
        switch (getDataType(input)) {
            case "boolean":
                System.out.println("The value is a boolean.");
                break;
            case "integer":
                System.out.println("The value is an integer.");
                break;
            case "double":
                System.out.println("The value is a double.");
                break;
            case "string":
                System.out.println("The value is a string.");
                break;
            default:
                System.out.println("Unknown data type.");
        }
    }


    public static String getDataType(String input) {
        if (input.equalsIgnoreCase("true") || input.equalsIgnoreCase("false")) {
            return "boolean";
        } else {
            try {
                Integer.parseInt(input);
                return "integer";
            } catch (NumberFormatException e1) {
                try {
                    Double.parseDouble(input);
                    return "double";
                } catch (NumberFormatException e2) {
                    return "string";
                }
            }
        }
    }



    }

