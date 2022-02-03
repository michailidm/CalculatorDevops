package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TangentTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void perform() {
        double a = 0.0;
        Tangent tangent = new Tangent(a);
        double expectedResult = 0.0;
        double result = tangent.perform();
        assertEquals(expectedResult, result, 0);

        a = 89.9;
        tangent = new Tangent(a);
        expectedResult = -2.62003383987;
        result = tangent.perform();
        assertEquals(expectedResult, result, 0.00000000001);
    }

    @Test
    void showOperationExpression() {
        Tangent tangent = new Tangent(75);
        String expectedResult = "tan(75)";
        String result = tangent.showExpression();
        assertEquals(expectedResult, result);

        tangent = new Tangent(-75.57);
        expectedResult = "tan(-75.57)";
        result = tangent.showExpression();
        assertEquals(expectedResult, result);

        tangent = new Tangent(-0.0);
        expectedResult = "tan(0)";
        result = tangent.showExpression();
        assertEquals(expectedResult, result);

        tangent = new Tangent(0);
        expectedResult = "tan(0)";
        result = tangent.showExpression();
        assertEquals(expectedResult, result);
    }
}