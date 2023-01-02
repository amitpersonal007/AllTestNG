import org.testng.annotations.Test;

public class MathFunction {

	@Test
	public void add() {
		
		String a="230";
		double b=23;
		
		double c=Double.parseDouble(a);
		
		double sum=c/ b;
		
		
		//System.out.println(String.format("%.0f", sum));
		System.out.println(String.format("%.0f", sum));
		
		
	}
}
