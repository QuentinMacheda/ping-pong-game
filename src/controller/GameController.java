package src.controller;

import src.controller.components.PlayerController;
import src.controller.components.RacketController;
import src.view.GameView;

public class GameController {
    public static GameController selfInstance = new GameController();
    public GameView gameView;
    public PlayerController playerLeftController;
    public PlayerController playerRightController;
    public RacketController racketLeftController;
    public RacketController racketRightController;

    // Constructor
    private GameController() {
        playerLeftController = new PlayerController("Player1", 0);
        playerRightController = new PlayerController("Player2", 0);

        racketLeftController = new RacketController(20, 100);
        racketRightController = new RacketController(20, 100);
    }

    public GameView getView() {
        gameView = new GameView();
        return gameView;
    }

    public static GameController getInstance() {
        return selfInstance;
    }
}
