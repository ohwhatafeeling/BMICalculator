import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Calculator calculator = new Calculator();
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter your weight in KG: ");
		double weight = scanner.nextDouble();
		System.out.println("Enter your height in M: ");
		double height = scanner.nextDouble();
		double result = calculator.calculateBmi(weight, height);
		
		DecimalFormat numberFormat = new DecimalFormat("#.00");
		
		System.out.println("Your BMI is " + numberFormat.format(result));
	}

}
