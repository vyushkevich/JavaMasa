package factoria5.javamasa;

import java.util.Locale;
import java.util.Scanner;

public class App {

    // Method to calculate BMI
    public static double calculateBMI(double weight, double height) {
        if (weight <= 0 || height <= 0) {
            throw new IllegalArgumentException("Weight and height must be positive numbers.");
        }
        return weight / (height * height);
    }

    // Method to classify BMI
    public static String classifyBMI(double bmi) {
        if (bmi < 16) {
            return "Delgadez severa";
        } else if (bmi < 17) {
            return "Delgadez moderada";
        } else if (bmi < 18.5) {
            return "Delgadez leve";
        } else if (bmi < 25) {
            return "Peso normal";
        } else if (bmi < 30) {
            return "Sobrepeso";
        } else if (bmi < 35) {
            return "Obesidad leve";
        } else if (bmi < 40) {
            return "Obesidad moderada";
        } else {
            return "Obesidad mórbida";
        }
    }

    public static void main(String[] args) {
        Locale.setDefault(Locale.US); // Ensure dot as decimal separator
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Enter your weight in kilograms:");
            double weight = scanner.nextDouble();

            System.out.println("Enter your height in meters:");
            double height = scanner.nextDouble();

            double bmi = calculateBMI(weight, height);
            System.out.printf("Your BMI is: %.2f%n", bmi);
            System.out.println("Classification: " + classifyBMI(bmi));
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Invalid input. Please enter numbers only.");
        } finally {
            scanner.close();
        }
    }
}
