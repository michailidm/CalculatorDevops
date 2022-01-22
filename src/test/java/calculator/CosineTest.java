package calculator;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CosineTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void perform() {
        double a = 0.0;
        Cosine cosine = new Cosine(a);
        double expectedResult = 1.0;
        double result = cosine.perform();
        assertEquals(expectedResult, result, 0);

        a = 89.0;
        cosine = new Cosine(a);
        expectedResult = 0.51017704494;
        result = cosine.perform();
        assertEquals(expectedResult, result, 0.00000000001);
    }

    @Test
    void showOperationExpression() {
    }
}