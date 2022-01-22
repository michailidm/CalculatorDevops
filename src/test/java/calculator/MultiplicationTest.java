package calculator;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
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
    }
}