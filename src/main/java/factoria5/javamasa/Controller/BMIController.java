package factoria5.javamasa.Controller;

import factoria5.javamasa.Model.BMICalculator;
import factoria5.javamasa.View.BMIView;

public class BMIController {

    private final BMIView view;

    public BMIController(BMIView view) {
        this.view = view;
    }

    public void start() {
        try {
            double weight = view.getInput("Enter your weight in kilograms:");
            double height = view.getInput("Enter your height in meters:");

            double bmi = BMICalculator.calculateBMI(weight, height);
            String classification = BMICalculator.classifyBMI(bmi);

            view.displayResult(bmi, classification);
        } catch (IllegalArgumentException e) {
            view.displayError("Error: " + e.getMessage());
        } catch (Exception e) {
            view.displayError("Invalid input. Please enter numbers only.");
        }
    }

    public void calculateBMI(double testWeight, double testHeight) {
        throw new UnsupportedOperationException("Unimplemented method 'calculateBMI'");
    }
}
