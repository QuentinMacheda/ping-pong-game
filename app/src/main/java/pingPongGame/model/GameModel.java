package pingPongGame.model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

/**
 * The model representing the game state and settings.
 * 
 * @author Quentin Macheda
 * @version 1.4
 * @since 2024-03-09
 */
public class GameModel {
    /*
     * The singleton instance of the GameModel.
     */
    public static GameModel selfInstance = new GameModel();

    /*
     * The score required to end the game.
     */
    private int endGameScore;

    /*
     * The height and width of the game area.
     */
    private double gameAreaHeight, gameAreaWidth;

    /*
     * The settings properties file.
     */
    public Properties settingsProperties;

    /*
     * The path to the settings properties file.
     */
    private String settingsPropertiesPath = "src/main/resources/data/settings.properties";

    /**
     * Private constructor to enforce singleton pattern and initialize default
     * values.
     */
    private GameModel() {
        // Load settings properties
        settingsProperties = new Properties();

        // Create file if does not exists
        if (!Files.exists(Paths.get(settingsPropertiesPath))) {
            try {
                Files.createFile(Paths.get(settingsPropertiesPath));

                // Setting default values
                settingsProperties.setProperty("ballSpeed", "normal");
                settingsProperties.setProperty("ballSpeedIR", "normal");
                settingsProperties.setProperty("endGameScore", "10");
                settingsProperties.setProperty("player1", "Player 1");
                settingsProperties.setProperty("player2", "Player 2");
                settingsProperties.setProperty("racketHeight", "120.0");
                settingsProperties.setProperty("racketWidth", "20.0");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try (FileInputStream input = new FileInputStream(settingsPropertiesPath)) {
            settingsProperties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Initializes the data
        this.updateEndGameScore(Integer.parseInt(settingsProperties.getProperty("endGameScore")));
        this.setGameAreaHeight(0);
        this.setGameAreaWidth(0);
    }

    /**
     * Resets the game model to its default values.
     */

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

        // Save the new data into settings properties
        settingsProperties.setProperty("endGameScore", Integer.toString(endGameScore));
        saveSettings("Set end game score");
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
     * Saves the settings to the settings properties file.
     * 
     * @param comments The comments to add to the properties file.
     */
    public void saveSettings(String comments) {
        try (FileOutputStream output = new FileOutputStream(settingsPropertiesPath)) {
            settingsProperties.store(output, "Last save:" + comments);
        } catch (IOException e) {
            e.printStackTrace();
        }
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
