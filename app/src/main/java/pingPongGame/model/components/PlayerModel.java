package pingPongGame.model.components;

public class PlayerModel {
    public enum PlayerSide {
        LEFT,
        RIGHT
    }

    private String name;
    private int score;
    private PlayerSide playerSide;

    public PlayerModel() {
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

    public PlayerSide getPlayerSide() {
        return playerSide;
    }

    public void setPlayerSide(PlayerSide playerSide) {
        this.playerSide = playerSide;
    }
}
