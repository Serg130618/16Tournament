public class NotRegisteredException extends RuntimeException {
    public NotRegisteredException(String playerName) {
        super("Игрок c именем" + playerName + "не найден");
    }
}
