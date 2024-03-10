package pingPongGame.model;

/**
 * The model representing the game state and settings.
 */
public class GameModel {
    /*
     * The singleton instance of the GameModel.
     */
    public static GameModel selfInstance = new GameModel();

    /*
     * The score required to end the game.
     */
    public int endGameScore;

    /*
     * The height and width of the game area.
     */
    public double gameAreaHeight, gameAreaWidth;

    /**
     * Private constructor to enforce singleton pattern and initialize default
     * values.
     */
    private GameModel() {
        this.fullReset();
    }

    /**
     * Resets the game model to its default values.
     */
    public void fullReset() {
        this.endGameScore = 10;
        this.gameAreaHeight = 0;
        this.gameAreaWidth = 0;
    }

    /**
     * Gets the end game score.
     *
     * @return The end game score.
     */
    public int getEndGameScore() {
        return this.endGameScore;
    }

    /**
     * Updates the end game score to a new value.
     *
     * @param newScore The new end game score.
     */
    public void updateEndGameScore(int newScore) {
        this.endGameScore = newScore;
    }

    /**
     * Gets the height of the game area.
     *
     * @return The height of the game area.
     */
    public double getGameAreaHeight() {
        return this.gameAreaHeight;
    }

    /**
     * Sets the height of the game area to a new value.
     *
     * @param newHeight The new height of the game area.
     */
    public void setGameAreaHeight(double newHeight) {
        this.gameAreaHeight = newHeight;
    }

    /**
     * Gets the width of the game area.
     *
     * @return The width of the game area.
     */
    public double getGameAreaWidth() {
        return this.gameAreaWidth;
    }

    /**
     * Sets the width of the game area to a new value.
     *
     * @param newWidth The new width of the game area.
     */
    public void setGameAreaWidth(double newWidth) {
        this.gameAreaWidth = newWidth;
    }

    /**
     * Gets the singleton instance of GameModel.
     *
     * @return The singleton instance of GameModel.
     */
    public static GameModel getInstance() {
        return selfInstance;
    }
}
