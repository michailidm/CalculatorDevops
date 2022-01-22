package calculator;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.*;

class AdditionTest {

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        Addition addition = new Addition();
    }

    @org.junit.jupiter.api.Test
    void perform() {
        double a = 15.0;
        double b = 20.0;
        Addition addition = new Addition(a, b);
        double expectedResult = 35.0;
        double result = addition.perform();
        assertEquals(expectedResult, result, 0);
    }

    @org.junit.jupiter.api.Test
    void showOperationExpression() {
    }
}