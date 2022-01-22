package calculator;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
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
    }
}