package src.controller;

import src.controller.components.*;
import src.view.GameView;

public class GameController {
    public static GameController selfInstance = new GameController();
    public GameView gameView;
    public PlayerController playerLeftController;
    public PlayerController playerRightController;
    public RacketController racketLeftController;
    public RacketController racketRightController;
    public BallController ballController;

    // Constructor
    private GameController() {
        playerLeftController = new PlayerController("Player1", 0);
        playerRightController = new PlayerController("Player2", 0);

        racketLeftController = new RacketController(20, 120);
        racketRightController = new RacketController(20, 120);

        ballController = new BallController(16);
    }

    public GameView getView() {
        gameView = new GameView();
        return gameView;
    }

    public static GameController getInstance() {
        return selfInstance;
    }
}
