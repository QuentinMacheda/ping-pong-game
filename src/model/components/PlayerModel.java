package src.model.components;

public class PlayerModel {
    private String name;
    private int score;

    public PlayerModel() {
        this.name = "Player";
        this.score = 0;
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
}
