package study.basecamp;

public interface NumberGenerator {

    int next();

    int getMaxNumber();

    int getMinNumber();

    void setMaxNumber(int maxNumber);

    void setMinNumber(int minNumber);

}
