package src.controller;

import javafx.scene.layout.AnchorPane;
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
        // Set the players name and score
        playerLeftController = new PlayerController();
        playerLeftController.initView();
        playerLeftController.updateName("Player 1");
        playerRightController = new PlayerController();
        playerRightController.initView();
        playerRightController.updateName("Player 2");

        // Set the rackets
        racketLeftController = new RacketController();
        racketLeftController.initView();
        AnchorPane.setLeftAnchor(racketLeftController.getView().racket, 40.0);
        racketRightController = new RacketController();
        racketRightController.initView();
        AnchorPane.setRightAnchor(racketRightController.getView().racket, 40.0);

        // Set the ball
        ballController = new BallController();
        ballController.initView();
    }

    public GameView initView() {
        gameView = new GameView();

        return gameView;
    }

    public static GameController getInstance() {
        return selfInstance;
    }
}
