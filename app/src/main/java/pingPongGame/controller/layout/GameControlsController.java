package pingPongGame.controller.layout;

import pingPongGame.controller.MainController;
import pingPongGame.view.layout.GameControlsView;

/**
 * The GameControlsController class manages the game controls in the game.
 * 
 * @author Quentin Macheda
 * @version 1.4
 * @since 2024-03-09
 */
public class GameControlsController {
    /**
     * The GameControlsView associated with the GameControlsController.
     */
    public GameControlsView gameControlsView;

    /**
     * Constructs a new GameControlsController.
     */
    public GameControlsController() {
    }

    /**
     * Plays the game.
     */
    public void play() {
        MainController.getInstance().setMainState(MainController.MainState.RUNNING);
    }

    /**
     * Pauses the game.
     */
    public void pause() {
        MainController.getInstance().setMainState(MainController.MainState.PAUSED);
    }

    /**
     * Restarts the game.
     */
    public void restart() {

    }

    /**
     * Initializes the GameControlsView associated with the GameControlsController.
     */
    public void initView() {
        gameControlsView = new GameControlsView();
    }

    /**
     * Gets the GameControlsView associated with the GameControlsController.
     *
     * @return The GameControlsView instance.
     */
    public GameControlsView getView() {
        return gameControlsView;
    }
}
