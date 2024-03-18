package pingPongGame.model.components;

import pingPongGame.model.GameModel;

/**
 * Model representing the properties and state of a player in the game.
 * 
 * @author Quentin Macheda
 * @version 1.4
 * @since 2024-03-09
 */
public class PlayerModel {
    /**
     * Enumeration representing the player's side (LEFT or RIGHT).
     */
    public enum PlayerSide {
        LEFT,
        RIGHT
    }

    /*
     * The name of the player.
     */
    private String name;

    /*
     * The score of the player.
     */
    private int score;

    /*
     * The side of the player (LEFT or RIGHT).
     */
    private PlayerSide playerSide;

    /**
     * Constructor to initialize the player model with a default score of 0.
     */
    public PlayerModel() {
        this.resetScore();
    }

    /**
     * Gets the name of the player.
     *
     * @return The name of the player.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Sets the name of the player.
     *
     * @param newName The new name of the player.
     */
    public void setName(String newName) {
        this.name = newName;

        // Save the new data into settings properties
        if (this.playerSide == PlayerSide.LEFT) {
            GameModel.getInstance().settingsProperties.setProperty("player1", newName);
        } else {
            GameModel.getInstance().settingsProperties.setProperty("player2", newName);
        }
        GameModel.getInstance().saveSettings("Set players's name");
    }

    /**
     * Gets the score of the player.
     *
     * @return The score of the player.
     */
    public int getScore() {
        return this.score;
    }

    /**
     * Sets the score of the player.
     */
    public void resetScore() {
        this.score = 0;
    }

    /**
     * Increments the score of the player by 1.
     */
    public void incrementScore() {
        this.score++;
    }

    /**
     * Gets the side of the player (LEFT or RIGHT).
     *
     * @return The side of the player.
     */
    public PlayerSide getPlayerSide() {
        return playerSide;
    }

    /**
     * Sets the side of the player.
     *
     * @param playerSide The new side of the player (LEFT or RIGHT).
     */
    public void setPlayerSide(PlayerSide playerSide) {
        this.playerSide = playerSide;
    }
}
