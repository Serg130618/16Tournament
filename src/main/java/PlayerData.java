public class PlayerData {
    private int id;
    private String name;
    private int Strength;


    public String getName() {
        return name;
    }

    public int getStrength() {
        return Strength;
    }

    public PlayerData(int id, String name, int Strength) {
        this.id = id;
        this.name = name;
        this.Strength = Strength;
    }
}
