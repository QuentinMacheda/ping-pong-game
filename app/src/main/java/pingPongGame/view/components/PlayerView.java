package pingPongGame.view.components;

import javafx.scene.text.Text;
import pingPongGame.controller.components.PlayerController;

/**
 * The visual representation of a player's information, including name and
 * score.
 * 
 * @author Quentin Macheda
 * @version 1.4
 * @since 2024-03-09
 */
public class PlayerView extends Text {
    // Associated controller managing player logic
    public PlayerController playerController;

    /**
     * Constructs a new PlayerView with the associated PlayerController.
     *
     * @param playerController The PlayerController associated with this view.
     */
    public PlayerView(PlayerController playerController) {
        // Set the player controller
        this.playerController = playerController;

        // Set the initial text and style class for the player info
        this.setText(playerController.getName() + " | " + playerController.getScore());
        this.getStyleClass().addAll("player-info");
    }

    /**
     * Updates the displayed player information with the current name and score.
     */
    public void update() {
        // Update the text based on the current player information
        this.setText(playerController.getName() + " | " + this.playerController.getScore());
    }
}
