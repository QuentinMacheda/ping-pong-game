package src.controller;

import javafx.util.Duration;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.layout.AnchorPane;
import src.controller.MainController.MainState;
import src.controller.components.*;
import src.model.GameModel;
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

    public void initView() {
        gameView = new GameView();

        /*
         * Send game area height and width values to the ball controller
         */
        gameView.centerContainer.heightProperty().addListener((observable, oldValue, newValue) -> {
            GameModel.getInstance().setGameAreaHeight(newValue.doubleValue());
        });
        gameView.centerContainer.widthProperty().addListener((observable, oldValue, newValue) -> {
            GameModel.getInstance().setGameAreaWidth(newValue.doubleValue() + racketLeftController.getParentWidth()
                    + racketRightController.getParentWidth());
        });
    }

    public void score(String player) {
        MainController.getInstance().setMainState(MainState.PAUSED);

        // Increment the score of the player who scored
        // Print goal message
        if (player == "left") {
            playerLeftController.incrementScore();
            this.getView().setMessageToGoal(playerLeftController.getName());
        } else {
            playerRightController.incrementScore();
            this.getView().setMessageToGoal(playerRightController.getName());
        }

        // Pause the game for 2 seconds
        Timeline scorePause = new Timeline(new KeyFrame(Duration.millis(2000), event -> {
            ballController.reset();
            racketLeftController.reset();
            racketRightController.reset();
            this.getView().setMessageToStart();
        }));

        scorePause.play();
    }

    public GameView getView() {
        return gameView;
    }

    public static GameController getInstance() {
        return selfInstance;
    }
}
