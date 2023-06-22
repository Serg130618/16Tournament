import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class GameTest {
    Game game = new Game();
    @Test
    public void testWhenFirstWin() {
        PlayerData player1 = new PlayerData(1, "Ivan", 70);
        PlayerData player2 = new PlayerData(2, "Serg", 65);

        game.register(player1);
        game.register(player2);

        int actual = game.round("Ivan", "Serg");
        int expected = 1;

        Assertions.assertEquals(actual, expected);
    }

    @Test
    public void testWhenWin() {
        PlayerData player1 = new PlayerData(1, "Ivan", 70);
        PlayerData player2 = new PlayerData(2, "Serg", 75);

        game.register(player1);
        game.register(player2);

        int actual = game.round("Serg", "Ivan");
        int expected = 1;

        Assertions.assertEquals(actual, expected);
    }

    @Test
    public void testDidNotWin() {
        PlayerData player1 = new PlayerData(1, "Ivan", 70);
        PlayerData player2 = new PlayerData(2, "Serg", 70);

        game.register(player1);
        game.register(player2);

        int actual = game.round("Ivan", "Serg");
        int expected = 0;

        Assertions.assertEquals(actual, expected);
    }

    @Test
    public void testNotRegistered() {
        PlayerData player1 = new PlayerData(1, "Ivan", 70);
        PlayerData player2 = new PlayerData(2, "Serg", 70);

        game.register(player1);
        game.register(player2);
        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Maks", "Serg");
        });
    }

    @Test
    public void testWhenSecondWin() {
        PlayerData player1 = new PlayerData(1, "Ivan", 70);
        PlayerData player2 = new PlayerData(2, "Serg", 75);

        game.register(player1);
        game.register(player2);

        int actual = game.round("Ivan", "Serg");
        int expected = 2;

        Assertions.assertEquals(actual, expected);
    }

}