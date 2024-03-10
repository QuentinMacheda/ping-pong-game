package pingPongGame.model;

public class GameModel {
    public static GameModel selfInstance = new GameModel();
    public int endGameScore;
    public double gameAreaHeight;
    public double gameAreaWidth;

    private GameModel() {
        this.fullReset();
    }

    public void fullReset() {
        this.endGameScore = 10;
        this.gameAreaHeight = 0;
        this.gameAreaWidth = 0;
    }

    public int getEndGameScore() {
        return this.endGameScore;
    }

    public void updateEndGameScore(int newScore) {
        this.endGameScore = newScore;
    }

    public double getGameAreaHeight() {
        return this.gameAreaHeight;
    }

    public void setGameAreaHeight(double newHeight) {
        this.gameAreaHeight = newHeight;
    }

    public double getGameAreaWidth() {
        return this.gameAreaWidth;
    }

    public void setGameAreaWidth(double newWidth) {
        this.gameAreaWidth = newWidth;
    }

    public static GameModel getInstance() {
        return selfInstance;
    }
}
