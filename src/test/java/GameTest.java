import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    @Test
    public void testWhenFirstWin() {
        Game game = new Game();
        Player player1 = new Player(1, "Ivan", 70);
        Player player2 = new Player(2, "Serg", 65);

        game.register(player1);
        game.register(player2);

        int actual = game.round("Ivan", "Serg");
        int expected = 1;

        Assertions.assertEquals(actual, expected);
    }

    @Test
    public void testWhenWin() {
        Game game = new Game();
        Player player1 = new Player(1, "Ivan", 70);
        Player player2 = new Player(2, "Serg", 75);

        game.register(player1);
        game.register(player2);

        int actual = game.round("Serg", "Ivan");
        int expected = 1;

        Assertions.assertEquals(actual, expected);
    }

    @Test
    public void testDidNotWin() {
        Game game = new Game();
        Player player1 = new Player(1, "Ivan", 65);
        Player player2 = new Player(2, "Serg", 65);

        game.register(player1);
        game.register(player2);

        int actual = game.round("Ivan", "Serg");
        int expected = 0;

        Assertions.assertEquals(actual, expected);
    }

    @Test
    public void testNotRegistered() {
        Game game = new Game();
        Player player1 = new Player(1, "Ivan", 65);
        Player player2 = new Player(2, "Serg", 65);

        game.register(player1);
        game.register(player2);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Maks", "Serg");
        });
    }

    @Test
    public void testWhenSecondWin() {
        Game game = new Game();
        Player player1 = new Player(1, "Ivan", 65);
        Player player2 = new Player(2, "Serg", 70);

        game.register(player1);
        game.register(player2);

        int actual = game.round("Ivan", "Serg");
        int expected = 2;

        Assertions.assertEquals(actual, expected);
    }

}