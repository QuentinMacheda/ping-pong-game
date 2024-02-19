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
        playerLeftController = new PlayerController();
        playerLeftController.initView();
        playerLeftController.updateName("Player 1");
        playerRightController = new PlayerController();
        playerRightController.initView();
        playerRightController.updateName("Player 2");

        racketLeftController = new RacketController();
        racketLeftController.initView();
        racketRightController = new RacketController();
        racketRightController.initView();

        ballController = new BallController();
        ballController.initView();
    }

    public GameView getView() {
        gameView = new GameView();
        return gameView;
    }

    public static GameController getInstance() {
        return selfInstance;
    }
}
