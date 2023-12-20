public class HealthCalculator {
	
	public double caloriesToJoules(double calories) {
		
		return (calories * 4.184);
	}
	
	public double joulesToCalories(double joules) {
		return (joules / 4.184);
	}
	
	public double calculateBMI(double bodyLength, double bodyWeightInKilos) {
		
		return bodyWeightInKilos /(bodyLength * bodyLength);
	}
}
