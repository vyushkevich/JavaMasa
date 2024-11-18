package factoria5.javamasa;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

class AppTest {

    // Test for calculateBMI method
    @Test
    void testCalculateBMI() {
        double weight = 80;
        double height = 1.75;
        double expectedBMI = 80 / (1.75 * 1.75);
        assertEquals(expectedBMI, App.calculateBMI(weight, height), 0.01);
    }

    // Test for classifyBMI method
    @Test
    void testClassifyBMI() {
        assertEquals("Delgadez severa", App.classifyBMI(15));
        assertEquals("Delgadez moderada", App.classifyBMI(16.5));
        assertEquals("Delgadez leve", App.classifyBMI(17.5));
        assertEquals("Peso normal", App.classifyBMI(22));
        assertEquals("Sobrepeso", App.classifyBMI(27));
        assertEquals("Obesidad leve", App.classifyBMI(32));
        assertEquals("Obesidad moderada", App.classifyBMI(37));
        assertEquals("Obesidad mórbida", App.classifyBMI(41));
    }

    // Test for main method with simulated input
    @Test
    void testMainWithInput() {
        String simulatedInput = "80\n1.75\n";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setIn(inputStream);
        System.setOut(new PrintStream(outputStream));

        try {
            App.main(new String[]{});
        } finally {
            System.setIn(System.in);
            System.setOut(originalOut);
        }

        String output = outputStream.toString();
        assertTrue(output.contains("Your BMI is: 26.12"));
        assertTrue(output.contains("Classification: Sobrepeso"));
    }

    // Test for invalid inputs in calculateBMI
    @Test
    void testInvalidInputs() {
        assertThrows(IllegalArgumentException.class, () -> App.calculateBMI(-80, 1.75));
        assertThrows(IllegalArgumentException.class, () -> App.calculateBMI(80, -1.75));
        assertThrows(IllegalArgumentException.class, () -> App.calculateBMI(0, 1.75));
    }
}
