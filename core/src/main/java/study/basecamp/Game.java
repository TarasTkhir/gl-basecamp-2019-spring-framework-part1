package study.basecamp;

public interface Game {

    void setGuess(int guess);

    void setSmallest(int smallest);

    void setBiggest(int smallest);

    void setNumber(int number);

    void setNumberGenerator(NumberGenerator numberGenerator);

    void setRemainingGuesses(int remainingGuesses);

    void setGuessCount(int guessCount);

    int getGuessCount();

    NumberGenerator getNumberGenerator();

    int getSmallest();

    int getBiggest();

    int getRemainingGuesses();

    int getGuess();

    int getNumber();

    void reset();

    void check();

    boolean isGameWon();

    boolean checkNotValidNumberRange(int guess);

}
