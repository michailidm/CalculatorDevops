package calculator;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SquareRootTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void perform() {
        double a = 4.0;
        SquareRoot squareRoot = new SquareRoot(a);
        double expectedResult = 2.0;
        double result = squareRoot.perform();
        assertEquals(expectedResult, result, 0);

        a = 2.5;
        squareRoot = new SquareRoot(a);
        expectedResult = 1.58113883008;
        result = squareRoot.perform();
        assertEquals(expectedResult, result, 0.00000000001);
    }

    @Test
    void showOperationExpression() {
    }
}