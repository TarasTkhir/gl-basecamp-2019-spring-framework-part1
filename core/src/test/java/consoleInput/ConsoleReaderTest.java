package consoleInput;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import study.basecamp.Game;
import study.basecamp.GameImpl;

import java.io.BufferedReader;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ConsoleReaderTest {

    @InjectMocks
    ConsoleReader consoleReader;

    @Mock
    BufferedReader reader;

    @BeforeEach
    void setUp() {
        reader = Mockito.mock(BufferedReader.class);
        consoleReader = new ConsoleReader(reader);
    }

    @AfterEach
    void tearDown() {

        reader = null;
        consoleReader = null;

    }

    @Test
    void whenStringNumberInCorrectRangeGivenThenReturnThatNumberLikeInt() throws IOException {
        Game game = new GameImpl();
        game.setSmallest(0);
        game.setBiggest(10);

        when(reader.readLine()).thenReturn("3");
        assertEquals(3, ConsoleReader.readFromConsole(game));
    }

    @Test
    void whenZeroIsGivenThenReturnFalse() throws IOException {

        when(reader.readLine()).thenReturn("0");
        assertEquals(false, ConsoleReader.readChoice());

    }

    @Test
    void whenOneIsGivenThenReturnTrue() throws IOException {

        when(reader.readLine()).thenReturn("1");
        assertEquals(true, ConsoleReader.readChoice());

    }


}