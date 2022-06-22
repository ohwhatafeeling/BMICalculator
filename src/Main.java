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
		
		System.out.println("Your BMI is " + result);
	}

}
