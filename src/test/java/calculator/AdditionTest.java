package calculator;

import static org.junit.jupiter.api.Assertions.*;

class AdditionTest {

    @org.junit.jupiter.api.Test
    void performTest1() {
        double a = 15.0;
        double b = 20.0;
        Addition addition = new Addition(a, b);
        double expectedResult = 35.0;
        double result = addition.perform();
        assertEquals(expectedResult, result, 0);
    }

    @org.junit.jupiter.api.Test
    void performTest2() {
        double a = 15.0;
        double b = -20.0;
        Addition addition = new Addition(a, b);
        double expectedResult = -5.0;
        double result = addition.perform();
        assertEquals(expectedResult, result, 0);
    }

    @org.junit.jupiter.api.Test
    void showOperationExpression() {
        Addition addition = new Addition(45, 75);
        String expectedResult = "45 + 75";
        String result = addition.showExpression();
        assertEquals(expectedResult, result);

        addition = new Addition(45, -75.3);
        expectedResult = "45 + (-75.3)";
        result = addition.showExpression();
        assertEquals(expectedResult, result);

        addition = new Addition(-45.5, 75);
        expectedResult = "-45.5 + 75";
        result = addition.showExpression();
        assertEquals(expectedResult, result);

        addition = new Addition(0, 0.0);
        expectedResult = "0 + 0";
        result = addition.showExpression();
        assertEquals(expectedResult, result);

    }
}