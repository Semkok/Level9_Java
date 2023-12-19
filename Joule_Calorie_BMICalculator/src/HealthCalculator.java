public class HealthCalculator {
	
	public double caloriesToJoules(double calories) {
		double joules = (calories * 4.184);
		return joules;
	}
	
	public double joulesToCalories(double joules) {
		double calories = (joules / 4.184);
		return calories;
	}
	
	public double calculateBMI(double bodyLength, double bodyWeightInKilos) {
		double BMI = bodyWeightInKilos /(bodyLength * bodyLength);
		return BMI;
	}
}
