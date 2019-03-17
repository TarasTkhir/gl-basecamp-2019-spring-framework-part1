package consoleInput;

import org.apache.logging.log4j.*;
import study.basecamp.Game;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleReader {

    private static final Logger log = LogManager.getLogger(ConsoleReader.class);

    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    private static int guess;

    private static int choice;

    public ConsoleReader(BufferedReader readerr) {

        reader = readerr;
    }

    public ConsoleReader() {

    }

    public static int readFromConsole(Game game) {

        log.info("Your number is between - {} , and - {}", game.getSmallest(), game.getBiggest());
        try {
            guess = Integer.parseInt(reader.readLine());
        } catch (IOException | NumberFormatException e) {

            log.info("Not a number or wrong number! Try Again!");
            readFromConsole(game);
        }
        if (game.checkNotValidNumberRange(guess)) {
            log.info("Too BIG or too SMAL NUMBER it must be between - {} , and - {}", game.getSmallest(), game.getBiggest());
            readFromConsole(game);
        }
        return guess;
    }


    public static boolean readChoice() {

        log.info("\n 1 - Start Game \n 0 - Quit");
        try {
            choice = Integer.parseInt(reader.readLine());
        } catch (IOException | NumberFormatException e) {

            log.info("Put 1 or 0 to make your choice");
            readChoice();
        }
        if (choice == 1) {
            return true;
        } else if (choice == 0) {

            try {
                reader.close();
            } catch (IOException e) {

                log.error("Cannot close reader in ConsoleReader.class");
            }

            return false;
        }
        return readChoice();
    }

}
