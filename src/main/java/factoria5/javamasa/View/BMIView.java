package factoria5.javamasa.View;

import java.util.Locale;
import java.util.Scanner;

public class BMIView {

    private final Scanner scanner;

    public BMIView() {
        Locale.setDefault(Locale.US);
        this.scanner = new Scanner(System.in);
    }

    public double getInput(String prompt) {
        System.out.println(prompt);
        return scanner.nextDouble();
    }

    public void displayResult(double bmi, String classification) {
        System.out.printf("Your BMI is: %.2f%n", bmi);
        System.out.println("Classification: " + classification);
    }

    public void displayError(String message) {
        System.err.println(message);
    }

    public void close() {
        scanner.close();
    }
}
