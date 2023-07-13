import org.testng.annotations.Test;

public class GetCalculation {

    @Test
    public void test(){
        String input = "2,43,2.1,9.00";

        String[] numbers = input.split(",");
        double sum = 0.0;

        for (String number : numbers) {
            sum += Double.parseDouble(number);
        }

        System.out.print("Enter desired decimal places for output: ");
        int decimalPlaces = 1;

        String formatString = "%." + decimalPlaces + "f";
        String output = String.format(formatString, sum);

        System.out.println("Sum = " + output);
    }

}
