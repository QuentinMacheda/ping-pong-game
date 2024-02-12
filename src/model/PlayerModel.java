package src.model;

public class PlayerModel {
    private String name;
    private int score;
    private String side;

    public PlayerModel(String name, int score, String side) {
        this.name = name;
        this.score = score;
        this.side = side;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return this.score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getSide() {
        return this.side;
    }
}
