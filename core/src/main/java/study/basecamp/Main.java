package study.basecamp;

import org.apache.logging.log4j.*;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class Main {

    private static final Logger log = LogManager.getLogger(Main.class);

    public static void main(String[] args) {

        log.info("-----------GUESS NUMBER!----------------");

        ConfigurableApplicationContext context
                = new AnnotationConfigApplicationContext("configs");

        GameMenager.executeMenu(context);


        context.close();
    }

}

