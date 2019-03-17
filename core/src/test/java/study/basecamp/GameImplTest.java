package study.basecamp;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameImplTest {

    private static Game testUnitGame;

    @BeforeEach
    void setUp() {

        testUnitGame = new GameImpl();
    }

    @AfterEach
    void tearDown() {

        testUnitGame = null;
    }

    @Test
    void whenResetCalledThenRemainingGuessesBecomeLikeGuessCount() {

        NumberGeneratorImpl numberGenerator = new NumberGeneratorImpl();
        numberGenerator.setMinNumber(10);
        numberGenerator.setMaxNumber(20);
        testUnitGame.setNumberGenerator(numberGenerator);
        testUnitGame.setGuessCount(5);
        testUnitGame.setRemainingGuesses(100);


        testUnitGame.reset();

        assertEquals(5, testUnitGame.getRemainingGuesses());

    }

    @Test
    void whenResetCalledThenSmallestBecomeLikeMinNumberFromNumberGenerator() {

        NumberGeneratorImpl numberGenerator = new NumberGeneratorImpl();
        numberGenerator.setMinNumber(10);
        numberGenerator.setMaxNumber(20);
        testUnitGame.setNumberGenerator(numberGenerator);
        testUnitGame.setSmallest(400);

        testUnitGame.reset();

        assertEquals(10, testUnitGame.getSmallest());

    }

    @Test
    void whenResetCalledThenGuessEqualZero() {

        NumberGeneratorImpl numberGenerator = new NumberGeneratorImpl();
        numberGenerator.setMinNumber(10);
        numberGenerator.setMaxNumber(20);
        testUnitGame.setNumberGenerator(numberGenerator);

        testUnitGame.setGuess(50);

        testUnitGame.reset();

        assertEquals(0, testUnitGame.getGuess());

    }

    @Test
    void whenResetCalledThenBiggestBecomeLikeMaxNumberFromNumberGenerator() {

        NumberGeneratorImpl numberGenerator = new NumberGeneratorImpl();
        numberGenerator.setMinNumber(10);
        numberGenerator.setMaxNumber(20);
        testUnitGame.setNumberGenerator(numberGenerator);

        testUnitGame.setBiggest(1000);

        testUnitGame.reset();

        assertEquals(20, testUnitGame.getBiggest());

    }

    @Test
    void whenResetCalledThenNumberBecomeIntegerBetweenMinNumberAndMaxNumber() {

        NumberGeneratorImpl numberGenerator = new NumberGeneratorImpl();
        numberGenerator.setMinNumber(20);
        numberGenerator.setMaxNumber(20);
        testUnitGame.setNumberGenerator(numberGenerator);

        testUnitGame.setNumber(500);

        testUnitGame.reset();

        assertEquals(20, testUnitGame.getNumber());

    }

    @Test
    void whenGuessNumberIsSmallerThanNumberThenAfterCheckMethodSmallerNumberMustBeLikeGuessNumberPlusOne_Positive() {

        testUnitGame.setBiggest(10);
        testUnitGame.setSmallest(0);
        testUnitGame.setGuess(5);
        testUnitGame.setNumber(8);
        testUnitGame.setRemainingGuesses(1);

        testUnitGame.check();

        assertEquals(6, testUnitGame.getSmallest());
    }

    @Test
    void whenGuessNumberIsBiggerThanNumberThenAfterCheckMethodBiggestNumberMustBeLikeGuessNumberMinusOne_Positive() {

        testUnitGame.setBiggest(10);
        testUnitGame.setSmallest(0);
        testUnitGame.setGuess(9);
        testUnitGame.setNumber(5);
        testUnitGame.setRemainingGuesses(1);

        testUnitGame.check();

        assertEquals(8, testUnitGame.getBiggest());
    }

    @Test
    void whenCheckMethodCalledThenRemainingGuessesValueMustBeDecremented_Positive() {

        testUnitGame.setBiggest(10);
        testUnitGame.setSmallest(0);
        testUnitGame.setGuess(5);
        testUnitGame.setNumber(8);
        testUnitGame.setRemainingGuesses(1);

        testUnitGame.check();

        assertEquals(0, testUnitGame.getRemainingGuesses());
    }


    @Test
    void whenGuessNumberAndActualNumberIsGivenThenReturnTrueIfTheyAreEquals_Positive() {

        testUnitGame.setNumber(10);
        testUnitGame.setGuess(10);

        assertEquals(true, testUnitGame.isGameWon());
    }

    @Test
    void whenGuessNumberAndActualNumberIsGivenThenReturnTrueIfTheyAreEquals_Negative() {

        testUnitGame.setNumber(10);
        testUnitGame.setGuess(10);

        assertNotEquals(false, testUnitGame.isGameWon());
    }

    @Test
    void whenBiggestAndSmallestAndGuessNumbersGivenThenCheckIfYourGessNumberIsNotInRangeBetweenBiggestAndSmallest_Positive() {

        int guess = 15;
        testUnitGame.setSmallest(10);
        testUnitGame.setBiggest(20);
        boolean result = testUnitGame.checkNotValidNumberRange(guess);

        assertEquals(false, result);
    }

    @Test
    void whenBiggestAndSmallestAndGuessNumbersGivenThenCheckIfYourGuessNumberIsNotInRangeBetweenBiggestAndSmallest_Negative() {

        int guess = 9;
        testUnitGame.setSmallest(10);
        testUnitGame.setBiggest(20);
        boolean result = testUnitGame.checkNotValidNumberRange(guess);

        assertNotEquals(false, result);
    }
}