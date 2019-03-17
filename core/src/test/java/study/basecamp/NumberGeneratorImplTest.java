package study.basecamp;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumberGeneratorImplTest {

    private static NumberGenerator testUnitNumberGenerator;

    @BeforeEach
    void setUp() {
        testUnitNumberGenerator = new NumberGeneratorImpl();
    }

    @AfterEach
    void tearDown() {

        testUnitNumberGenerator = null;
    }

    @Test
    void whenTwoNumbersGiwenThenReturnRandomNumberBetweenRangeOfThisTwoNumbers_PositiveTest() {

        testUnitNumberGenerator.setMaxNumber(10);
        testUnitNumberGenerator.setMinNumber(0);
        int result = testUnitNumberGenerator.next();

        assertEquals(true, ((result >= 0) && (result <= 10)));
    }

    @Test
    void whenTwoNumbersGiwenThenReturnRandomNumberBetweenRangeOfThisTwoNumbers_NegativeTest() {

        testUnitNumberGenerator.setMaxNumber(20);
        testUnitNumberGenerator.setMinNumber(10);
        int result = testUnitNumberGenerator.next();

        assertNotEquals(true, ((result < 10) || (result > 20)));
    }
}