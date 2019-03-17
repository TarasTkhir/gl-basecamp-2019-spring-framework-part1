package configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import study.basecamp.GameImpl;
import study.basecamp.NumberGeneratorImpl;

@Configuration
@ComponentScan(basePackages = "study.basecamp")
public class SpringCofiguration {

    @Bean("numberGenerator")
    public NumberGeneratorImpl getNumberGenerator() {

        return new NumberGeneratorImpl();
    }

    @Bean("game")
    public GameImpl getGameImpl() {
        return new GameImpl();
    }
}
