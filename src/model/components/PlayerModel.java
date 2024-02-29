package src.model.components;

public class PlayerModel {
    private String name;
    private int score;

    public PlayerModel() {
        this.setName("Player");
        this.setScore(0);
    }

    public String getName() {
        return this.name;
    }

    public void setName(String newName) {
        this.name = newName;
    }

    public int getScore() {
        return this.score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
