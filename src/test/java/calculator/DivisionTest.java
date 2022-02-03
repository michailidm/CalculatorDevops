package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DivisionTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void perform() {
        double a = 60.0;
        double b = 12.0;
        Division division = new Division(a, b);
        double expectedResult = 5.0;
        double result = division.perform();
        assertEquals(expectedResult, result, 0.0001);
    }

    @Test
    void showOperationExpression() {
        Division division = new Division(45, 75);
        String expectedResult = "45 / 75";
        String result = division.showExpression();
        assertEquals(expectedResult, result);

        division = new Division(45, -75.3);
        expectedResult = "45 / (-75.3)";
        result = division.showExpression();
        assertEquals(expectedResult, result);

        division = new Division(-45.5, 75);
        expectedResult = "-45.5 / 75";
        result = division.showExpression();
        assertEquals(expectedResult, result);

        division = new Division(0, 0.0);
        expectedResult = "0 / 0";
        result = division.showExpression();
        assertEquals(expectedResult, result);
    }
}