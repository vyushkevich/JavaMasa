package factoria5.javamasa;

import factoria5.javamasa.Model.BMICalculator;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AppTest {

    @Test
    public void testBMICalculator_calculation() {
        // Test BMI calculation
        double bmi1 = BMICalculator.calculateBMI(70, 1.75);  // 70 kg, 1.75 m
        double bmi2 = BMICalculator.calculateBMI(90, 1.80);  // 90 kg, 1.80 m

        assertEquals(22.86, bmi1, 0.01);  // Expected: 22.86
        assertEquals(27.78, bmi2, 0.01);  // Expected: 27.78
    }

    @Test
    public void testBMICalculator_classification() {
        // Test BMI classification
        assertEquals("Delgadez severa", BMICalculator.classifyBMI(15.0));
        assertEquals("Delgadez moderada", BMICalculator.classifyBMI(16.5));
        assertEquals("Delgadez ligera", BMICalculator.classifyBMI(17.5));
        assertEquals("Peso normal", BMICalculator.classifyBMI(22.5));
        assertEquals("Sobrepeso", BMICalculator.classifyBMI(27.5));
        assertEquals("Obesidad leve", BMICalculator.classifyBMI(32.5));
        assertEquals("Obesidad severa", BMICalculator.classifyBMI(37.5));
        assertEquals("Obesidad extrema", BMICalculator.classifyBMI(45.0));
    }

    @Test
public void testBMICalculator_classification_boundaries() {
    double bmi1 = 15.9; // "Delgadez severa" и "Delgadez moderada"
    double bmi2 = 16.1; // "Delgadez severa" и "Delgadez moderada"

    assertEquals("Delgadez severa", BMICalculator.classifyBMI(bmi1)); //  "Delgadez severa"
    assertEquals("Delgadez moderada", BMICalculator.classifyBMI(bmi2)); //  "Delgadez moderada"
}

    @Test
    public void testBMICalculator_invalidInput() {
        // Test invalid input
        assertThrows(IllegalArgumentException.class, () -> BMICalculator.calculateBMI(70, 0));
        assertThrows(IllegalArgumentException.class, () -> BMICalculator.calculateBMI(0, 1.75));
        assertThrows(IllegalArgumentException.class, () -> BMICalculator.calculateBMI(-70, 1.75));
    }

    @Test
    public void testBMICalculator_zeroInput() {
        // Test zero weight and height
        assertThrows(IllegalArgumentException.class, () -> BMICalculator.calculateBMI(0, 0));
    }

    @Test
    public void testBMICalculator_classifyExtremeValues() {
        // Test extreme BMI values
        assertEquals("Obesidad extrema", BMICalculator.classifyBMI(60.0));
        assertEquals("Delgadez severa", BMICalculator.classifyBMI(10.0));
    }

    @Test
    public void testBMICalculator_largeInput() {
        // Test with large values for weight and height
        double bmi1 = BMICalculator.calculateBMI(200, 2.0);
        double bmi2 = BMICalculator.calculateBMI(50, 2.5);

        assertTrue(bmi1 > 30); // Expected: BMI greater than 30 (Obesidad leve or higher)
        assertTrue(bmi2 < 20); // Expected: BMI less than 20 (Delgadez severa or higher)
    }

    @Test
    public void testBMICalculator_classification_roundingIssues() {
        
        double bmi1 = 24.99; 
        double bmi2 = 25.0;  
        
        assertEquals("Peso normal", BMICalculator.classifyBMI(bmi1));
        assertEquals("Sobrepeso", BMICalculator.classifyBMI(bmi2));  
    }

    @Test
public void testBMICalculator_classification_boundaries_expanded() {
    
    double bmi1 = 18.4; 
    double bmi2 = 24.9; 

    assertEquals("Delgadez ligera", BMICalculator.classifyBMI(bmi1));  
    assertEquals("Peso normal", BMICalculator.classifyBMI(bmi2));   
}


    @Test
public void testBMICalculator_extremeValues() {
    
    double bmi1 = BMICalculator.calculateBMI(200, 1.60);  
    double bmi2 = BMICalculator.calculateBMI(40, 2.0);  

    assertTrue(bmi1 > 40); 
    assertTrue(bmi2 < 20); 
}

@Test
public void testBMICalculator_bmiAtEdge() {
    
    double bmi = BMICalculator.calculateBMI(70, 1.75);
    assertTrue(bmi > 15.0 && bmi < 40.0, "Bmi should be within a reasonable range.");
}

}
