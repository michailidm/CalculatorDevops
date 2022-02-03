package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MultiplicationTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void perform() {
        double a = 18.5;
        double b = 12.6;
        Multiplication multiplication = new Multiplication(a, b);
        double expectedResult = 233.1;
        double result = multiplication.perform();
        assertEquals(expectedResult, result, 0);
    }

    @Test
    void showOperationExpression() {
        Multiplication multiplication = new Multiplication(45, 75);
        String expectedResult = "45 * 75";
        String result = multiplication.showExpression();
        assertEquals(expectedResult, result);

        multiplication = new Multiplication(45, -75.3);
        expectedResult = "45 * (-75.3)";
        result = multiplication.showExpression();
        assertEquals(expectedResult, result);

        multiplication = new Multiplication(-45.5, 75);
        expectedResult = "-45.5 * 75";
        result = multiplication.showExpression();
        assertEquals(expectedResult, result);

        multiplication = new Multiplication(0, 0.0);
        expectedResult = "0 * 0";
        result = multiplication.showExpression();
        assertEquals(expectedResult, result);
    }
}