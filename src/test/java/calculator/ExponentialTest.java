package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExponentialTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void perform() {
        double a = 0;
        Exponential exponential = new Exponential(a);
        double expectedResult = 1.0;
        double result = exponential.perform();
        assertEquals(expectedResult, result, 0);

        a = 2.4;
        exponential = new Exponential(a);
        expectedResult = 11.0231763806;
        result = exponential.perform();
        assertEquals(expectedResult, result, 0.0000000001);
    }

    @Test
    void showOperationExpression() {
        Exponential exponential = new Exponential(75);
        String expectedResult = "exp(75)";
        String result = exponential.showExpression();
        assertEquals(expectedResult, result);

        exponential = new Exponential(-75.57);
        expectedResult = "exp(-75.57)";
        result = exponential.showExpression();
        assertEquals(expectedResult, result);

        exponential = new Exponential(-0.0);
        expectedResult = "exp(0)";
        result = exponential.showExpression();
        assertEquals(expectedResult, result);

        exponential = new Exponential(0);
        expectedResult = "exp(0)";
        result = exponential.showExpression();
        assertEquals(expectedResult, result);

    }
}