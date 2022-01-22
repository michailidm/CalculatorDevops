package calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

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
    }
}