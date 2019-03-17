package study.basecamp;

import org.apache.logging.log4j.*;
import consoleInput.ConsoleReader;
import org.springframework.context.ConfigurableApplicationContext;


public class GameMenager {

    private static final Logger log = LogManager.getLogger(GameMenager.class);

    public static void startGame(ConfigurableApplicationContext context) {

        Game game = context.getBean("game", Game.class);

        do {

            int guess = ConsoleReader.readFromConsole(game);
            log.info("My guess = {}", guess);
            game.setGuess(guess);
            game.check();
            log.info("Remaining gesses = {}", game.getRemainingGuesses());

            log.info("Result = {}", game.isGameWon() ? "Win! C_O_N_G_R_A_T_U_L_A_T_I_O_N_S!!" : "Lose");


        } while ((game.getRemainingGuesses() > 0) && (!game.isGameWon()));

        log.warn("Number was: {}", game.getNumber());

        game.reset();
    }


    public static void executeMenu(ConfigurableApplicationContext context) {

        while (ConsoleReader.readChoice()) {

            startGame(context);
        }
    }
}
