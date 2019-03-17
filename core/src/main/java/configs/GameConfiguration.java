package configs;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = "study.basecamp")
@PropertySource("classpath:app.properties")
public class GameConfiguration {

    @Value("${game.guessCount}")
    private int guessCount;

    @Value("${numberGenerator.minNumber}")
    private int smallest;

    @Value("${numberGenerator.maxNumber}")
    private int maxNumber;

    @Bean("minNumber")
    public int smallestNumber() {
        System.out.println(smallest);
        return smallest;
    }

    @Bean("maxNumber")
    public int maxNumber() {
        System.out.println(maxNumber);
        return maxNumber;
    }

    @Bean("guessCount")
    public int guessCount() {

        System.out.println(guessCount);
        return guessCount;
    }

}
