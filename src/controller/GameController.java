package src.controller;

import javafx.util.Duration;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import src.controller.MainController.MainState;
import src.controller.components.*;
import src.controller.layout.TopBarController;
import src.model.GameModel;
import src.model.components.PlayerModel;
import src.view.GameView;

public class GameController {
    public static GameController selfInstance = new GameController();
    public GameView gameView;
    public TopBarController topBarController;
    public PlayerController playerLeftController;
    public PlayerController playerRightController;
    public RacketController racketLeftController;
    public RacketController racketRightController;
    public BallController ballController;

    // Constructor
    private GameController() {
        topBarController = new TopBarController();

        // Set the players name and score
        playerLeftController = new PlayerController();
        playerLeftController.initView();
        playerLeftController.setPlayerSide(PlayerModel.PlayerSide.LEFT);
        playerLeftController.updateName("Player 1");
        playerRightController = new PlayerController();
        playerRightController.initView();
        playerRightController.setPlayerSide(PlayerModel.PlayerSide.RIGHT);
        playerRightController.updateName("Player 2");

        // Set the rackets
        racketLeftController = new RacketController();
        racketLeftController.initView();

        racketRightController = new RacketController();
        racketRightController.initView();

        // Set the ball
        ballController = new BallController();
        ballController.initView();
    }

    public void initView() {
        gameView = new GameView();

        /*
         * Set game area height and width values
         * Set racket X position as it depends on game area width
         */
        gameView.centerContainer.heightProperty().addListener((observable, oldValue, newValue) -> {
            GameModel.getInstance().setGameAreaHeight(newValue.doubleValue());
        });
        gameView.centerContainer.widthProperty().addListener((observable, oldValue, newValue) -> {
            GameModel.getInstance().setGameAreaWidth(newValue.doubleValue() + racketLeftController.getParentWidth()
                    + racketRightController.getParentWidth());

            racketLeftController
                    .setPosX(-(GameModel.getInstance().getGameAreaWidth() / 2) + racketLeftController.getWidth());
            racketRightController
                    .setPosX((GameModel.getInstance().getGameAreaWidth() / 2) - racketLeftController.getWidth());
        });
    }

    public void score(String player) {
        MainController.getInstance().setMainState(MainState.PAUSED);

        // Increment the score of the player who scored
        // Print goal message
        if (player == "left") {
            playerRightController.incrementScore();
            this.getView().setMessageToGoal(playerRightController.getName());
        } else {
            playerLeftController.incrementScore();
            this.getView().setMessageToGoal(playerLeftController.getName());
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
