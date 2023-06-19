
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Game {
    HashMap<String, PlayerData> players = new HashMap<>();
    public void register(String name,PlayerData player) {
        players.put(name, player);    }

    public int round(String playerName1, String playerName2) {
//        PlayerData player1 = null;
//        PlayerData player2 = null;
        PlayerData player1 = players.get(playerName1);
        PlayerData player2 = players.get(playerName2);

            if (player1 == null) {
                throw new NotRegisteredException(playerName1);
            }
            if (player2 == null) {
                throw new NotRegisteredException(playerName2);
            }
            if (player1.getStrength() > player2.getStrength()) {
                return 1;
            }
            if (player1.getStrength() < player2.getStrength()) {
                return 2;
            }
            return 0;
        }


    }

