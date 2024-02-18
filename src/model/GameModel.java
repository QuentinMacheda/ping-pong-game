package src.model;

public class GameModel {
    public static GameModel selfInstance = new GameModel();
    public int endGameScore;

    private GameModel() {
        this.endGameScore = 10;
    }

    public int getEndGameScore() {
        return this.endGameScore;
    }

    public void updateEndGameScore(int newScore) {
        this.endGameScore = newScore;
    }

    public static GameModel getInstance() {
        return selfInstance;
    }
}
