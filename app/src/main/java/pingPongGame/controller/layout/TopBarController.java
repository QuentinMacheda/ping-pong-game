package pingPongGame.controller.layout;

import pingPongGame.view.layout.TopBarView;

/**
 * The TopBarController class manages the top bar layout in the game.
 * 
 * @author Quentin Macheda
 * @version 1.4
 * @since 2024-03-09
 */
public class TopBarController {
    /**
     * The TopBarView associated with the TopBarController.
     */
    public TopBarView topBarView;

    /**
     * Constructs a new TopBarController.
     */
    public TopBarController() {
    }

    /**
     * Initializes the TopBarView associated with the TopBarController.
     */
    public void initView() {
        topBarView = new TopBarView();
    }

    /**
     * Gets the TopBarView associated with the TopBarController.
     *
     * @return The TopBarView instance.
     */
    public TopBarView getView() {
        return topBarView;
    }
}
