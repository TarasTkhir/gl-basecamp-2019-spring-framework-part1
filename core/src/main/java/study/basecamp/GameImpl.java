package study.basecamp;

import lombok.Getter;
import lombok.Setter;
import org.apache.logging.log4j.*;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

@Getter
@Setter
public class GameImpl implements Game {

    private static final Logger log = LogManager.getLogger(GameImpl.class);

    private NumberGenerator numberGenerator;


    private int guessCount;
    private int number;
    private int guess;
    private int smallest;
    private int biggest;
    private int remainingGuesses;


    @Autowired
    @Override
    public void setNumberGenerator(NumberGenerator numberGenerator) {

        this.numberGenerator = numberGenerator;
    }

    @Autowired
    public void setGuessCount(int guessCount) {

        this.guessCount = guessCount;
    }

    @PostConstruct
    @Override
    public void reset() {
        smallest = numberGenerator.getMinNumber();
        guess = 0;
        remainingGuesses = guessCount;
        biggest = numberGenerator.getMaxNumber();
        number = numberGenerator.next();
    }


    @Override
    public void check() {

        if (guess > number) {

            biggest = guess - 1;

        } else if (guess < number) {

            smallest = guess + 1;
        }
        remainingGuesses--;
    }


    @Override
    public boolean isGameWon() {
        return guess == number;
    }

    @Override
    public boolean checkNotValidNumberRange(int guess) {
        return (guess < smallest) || (guess > biggest);
    }


}
