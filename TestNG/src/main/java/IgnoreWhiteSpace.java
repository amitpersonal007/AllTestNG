import org.testng.annotations.Test;

public class IgnoreWhiteSpace {

    @Test
    public void statrt(){

String input = "2,4,5,11.92";
        String[] numbers = input.split(",");
        double sum = 0;
        for (String number : numbers) {
            sum += Double.parseDouble(number);

        }


System.out.println(sum);


    }
}
