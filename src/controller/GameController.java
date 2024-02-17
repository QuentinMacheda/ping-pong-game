package src.controller;

import src.controller.components.PlayerController;
import src.view.GameView;

public class GameController {
    public static GameController selfInstance = new GameController();
    public GameView gameView;
    public PlayerController playerLeftController;
    public PlayerController playerRightController;

    // Constructor
    private GameController() {
        playerLeftController = new PlayerController("Player1", 0);
        playerRightController = new PlayerController("Player2", 0);
    }

    public GameView getView() {
        gameView = new GameView();
        return gameView;
    }

    public static GameController getInstance() {
        return selfInstance;
    }
}
