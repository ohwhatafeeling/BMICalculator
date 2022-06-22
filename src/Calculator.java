
public class Calculator {
	private double weight;
	private double height;
	private double bmi;
	
	Calculator() {
		
	}
	
	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	public void setHeight(double height) {
		this.height = height;
	}
	
	public double getWeight() {
		return this.weight;
	}
	
	public double getHeight() {
		return this.height;
	}
	
	public double getBmi() {
		return this.bmi;
	}
	
	public double calculateBmi(double weight, double height) {
		return weight / (height * height);
	}
}
