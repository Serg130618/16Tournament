import org.junit.jupiter.api.Assertions;

import org.junit.jupiter.api.Test;

class GameTest {
    Game game = new Game();
    PlayerData player1 = new PlayerData(1, "Ivan", 70);
    PlayerData player2 = new PlayerData(2, "Serg", 65);

    @Test
    public void testWhenFirstWin() {

        game.register("Ivan", player1);
        game.register("Serg", player2);

        int actual = game.round("Ivan", "Serg");
        int expected = 1;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testWhenWin() {

        game.register("Ivan", player1);
        game.register("Serg", player2);

        int actual = game.round("Serg", "Ivan");
        int expected = 2;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testDidNotWin() {

        game.register("Ivan", player1);
        game.register("Serg", player2);

        int actual = game.round("Serg", "Serg");
        int expected = 0;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testNotRegistered() {

        game.register("Ivan", player1);
        game.register("Serg", player2);
        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Maks", "Serg");
        });
    }

    @Test
    public void testWhenSecondWin() {

        game.register("Ivan", player1);
        game.register("Serg", player2);

        int actual = game.round("Serg", "Ivan");
        int expected = 2;

        Assertions.assertEquals(expected, actual);
    }

}