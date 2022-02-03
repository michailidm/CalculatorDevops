package calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

class SubtractionTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void perform() {
        double a = 34;
        double b = 12;
        Subtraction subtraction = new Subtraction(a, b);
        double expectedResult = 22;
        double result = subtraction.perform();
        Assertions.assertEquals(expectedResult, result, 0);
    }

    @Test
    void showOperationExpression() {
        Subtraction subtraction = new Subtraction(45, 75);
        String expectedResult = "45 - 75";
        String result = subtraction.showExpression();
        Assertions.assertEquals(expectedResult, result);

        subtraction = new Subtraction(45, -75.3);
        expectedResult = "45 - (-75.3)";
        result = subtraction.showExpression();
        Assertions.assertEquals(expectedResult, result);

        subtraction = new Subtraction(-45.5, 75);
        expectedResult = "-45.5 - 75";
        result = subtraction.showExpression();
        Assertions.assertEquals(expectedResult, result);

        subtraction = new Subtraction(0, 0.0);
        expectedResult = "0 - 0";
        result = subtraction.showExpression();
        Assertions.assertEquals(expectedResult, result);
    }
}