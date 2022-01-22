package calculator;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SineTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void perform() {
        double a = 0.0;
        Sine sine = new Sine(a);
        double expectedResult = 0.0;
        double result = sine.perform();
        assertEquals(expectedResult, result, 0);

        a = 52.0;
        sine = new Sine(a);
        expectedResult = 0.98662759204;
        result = sine.perform();
        assertEquals(expectedResult, result, 0.00000000001);
    }

    @Test
    void showOperationExpression() {
    }
}