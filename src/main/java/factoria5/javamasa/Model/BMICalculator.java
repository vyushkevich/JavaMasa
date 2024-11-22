package factoria5.javamasa.Model;

public class BMICalculator {

    public static double calculateBMI(double weight, double height) {
        if (height <= 0 || weight <= 0) {
            throw new IllegalArgumentException("Height and weight must be greater than zero");
        }
        return weight / (height * height); 
    }
    
    
    

    public static String classifyBMI(double bmi) {
        if (bmi < 16.0) {
            return "Delgadez severa";
        } else if (bmi >= 16.0 && bmi < 17.0) {
            return "Delgadez moderada";
        } else if (bmi >= 17.0 && bmi < 18.5) {
            return "Delgadez ligera";
        } else if (bmi >= 18.5 && bmi < 25.0) {
            return "Peso normal";
        } else if (bmi >= 25.0 && bmi < 30.0) {
            return "Sobrepeso";
        } else if (bmi >= 30.0 && bmi < 35.0) {
            return "Obesidad leve";
        } else if (bmi >= 35.0 && bmi < 40.0) {
            return "Obesidad severa";
        } else {
            return "Obesidad extrema";
        }
    }
    
}      

