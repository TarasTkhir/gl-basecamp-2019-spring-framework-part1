package study.basecamp;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Random;

@Setter
@Getter
public class NumberGeneratorImpl implements NumberGenerator {

    private final Random random = new Random();

    private int maxNumber;

    private int minNumber;

    @Override
    @Autowired
    public void setMaxNumber(int maxNumber) {
        this.maxNumber = maxNumber;
    }

    @Override
    @Autowired
    public void setMinNumber(int minNumber) {
        this.minNumber = minNumber;
    }

    @Override
    public int next() {

        return random.nextInt(maxNumber - minNumber + 1) + minNumber;
    }

}
