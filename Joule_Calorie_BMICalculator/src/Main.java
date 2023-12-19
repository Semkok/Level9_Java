import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		HealthCalculator healthCalculate = new HealthCalculator();
		
		System.out.println("Welcome to the Joule / Calorie / BMI calculator");
		System.out.println("Choose from the folowing options below the number corresponding to the option:\nCalories To Joules [1].\nJoules to Calories [2].\nCalculate BMI [3].");;
		
		int option =  input.nextInt();
		if(option == 1) {
			System.out.println("Input the calories to convert:");
			double calories = input.nextDouble();
			System.out.printf("%.1f calories is: %.3f joules",calories,healthCalculate.caloriesToJoules(calories));
		}	
		else if(option == 2) {
			System.out.println("Input the joules to convert:");
			double joules = input.nextDouble();
			System.out.printf("%.3f joules is: %.1f calories",joules,healthCalculate.joulesToCalories(joules));
		}	
		else if(option == 3) {
			System.out.println("Type your body length:\n");
			double bodyLength = input.nextDouble();
			System.out.println("Type your body weigth in kilos:\n");
			double bodyWeight = input.nextDouble();
			System.out.printf("Your Body mass index is: %.1f",healthCalculate.calculateBMI(bodyLength, bodyWeight));
		}
		input.close();
	}

}
