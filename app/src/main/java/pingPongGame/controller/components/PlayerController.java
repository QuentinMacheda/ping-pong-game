package pingPongGame.controller.components;

import pingPongGame.model.components.PlayerModel;
import pingPongGame.view.components.PlayerView;

/**
 * The PlayerController class manages the player logic in the game.
 * 
 * @author Quentin Macheda
 * @version 1.4
 * @since 2024-03-09
 */
public class PlayerController {

    /**
     * The PlayerModel instance associated with the PlayerController.
     */
    private PlayerModel playerModel;

    /**
     * The PlayerView instance associated with the PlayerController.
     */
    private PlayerView playerView;

    /**
     * Constructs a new PlayerController with a new PlayerModel instance.
     */
    public PlayerController() {
        playerModel = new PlayerModel();
    }

    /**
     * Reset the player to its initial state.
     */
    public void reset() {
        playerModel.resetScore();
        this.getView().update();
    }

    /**
     * Initializes the PlayerView associated with the PlayerController.
     */
    public void initView() {
        playerView = new PlayerView(this);
    }

    /**
     * Gets the PlayerView associated with the PlayerController.
     *
     * @return The PlayerView instance.
     */
    public PlayerView getView() {
        return playerView;
    }

    /**
     * Gets the name of the player.
     *
     * @return The player's name.
     */
    public String getName() {
        return playerModel.getName();
    }

    /**
     * Updates the player's name and triggers a view update.
     *
     * @param newName The new name for the player.
     */
    public void updateName(String newName) {
        playerModel.setName(newName);
        this.getView().update();
    }

    /**
     * Gets the player's score.
     *
     * @return The player's score.
     */
    public int getScore() {
        return playerModel.getScore();
    }

    /**
     * Increments the player's score and triggers a view update.
     */
    public void incrementScore() {
        playerModel.incrementScore();
        this.getView().update();
    }

    /**
     * Sets the player's side (LEFT or RIGHT).
     *
     * @param playerSide The player's side.
     */
    public void setPlayerSide(PlayerModel.PlayerSide playerSide) {
        playerModel.setPlayerSide(playerSide);
    }
}
