package pingPongGame.controller;

import javafx.util.Duration;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import pingPongGame.controller.MainController.MainState;
import pingPongGame.controller.components.*;
import pingPongGame.controller.layout.TopBarController;
import pingPongGame.model.GameModel;
import pingPongGame.model.components.PlayerModel;
import pingPongGame.view.GameView;

public class GameController {
    public static GameController selfInstance = new GameController();
    public final MediaPlayer wallBounceSound = new MediaPlayer(
            new Media(GameController.class.getResource("/sound-design/wall-bounce.mp3").toString()));
    public final MediaPlayer racketBounceSound = new MediaPlayer(
            new Media(GameController.class.getResource("/sound-design/racket-bounce.mp3").toString()));
    public final MediaPlayer scoreSound = new MediaPlayer(
            new Media(GameController.class.getResource("/sound-design/score.mp3").toString()));

    public GameView gameView;
    public TopBarController topBarController;
    public PlayerController playerLeftController;
    public PlayerController playerRightController;
    public RacketController racketLeftController;
    public RacketController racketRightController;
    public BallController ballController;

    // Constructor
    private GameController() {
        this.fullReset();

        this.preloadSounds();
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

    public void score(PlayerModel.PlayerSide playerSide) {
        // Play the score sound
        this.playScoreSound();

        MainController.getInstance().setMainState(MainState.PAUSED);

        // Increment the score of the player who scored
        // Print goal message
        if (playerSide == PlayerModel.PlayerSide.LEFT) {
            playerRightController.incrementScore();

            // Check if score is less than the end game score
            if (playerRightController.getScore() < GameModel.getInstance().getEndGameScore()) {
                this.getView().setMessageToGoal(playerRightController.getName());
                this.resetAfterScore();
            } else {
                this.resetAfterGameOver();
                MainController.getInstance().gameOver(playerRightController.getName(), playerLeftController.getName());
            }
        } else if (playerSide == PlayerModel.PlayerSide.RIGHT) {
            playerLeftController.incrementScore();

            // Check if score is less than the end game score
            if (playerLeftController.getScore() < GameModel.getInstance().getEndGameScore()) {
                this.getView().setMessageToGoal(playerLeftController.getName());
                this.resetAfterScore();
            } else {
                this.resetAfterGameOver();
                MainController.getInstance().gameOver(playerLeftController.getName(), playerRightController.getName());
            }
        }
    }

    // Reset the game after a game over
    public void resetAfterGameOver() {
        ballController.reset();
        racketLeftController.reset();
        racketRightController.reset();
    }

    // Reset the game after a score (2 seconds pause)
    public void resetAfterScore() {
        Timeline scorePause = new Timeline(new KeyFrame(Duration.millis(2000), event -> {
            ballController.reset();
            racketLeftController.reset();
            racketRightController.reset();
            this.getView().setMessageToStart();
        }));

        scorePause.play();
    }

    public void fullReset() {
        GameModel.getInstance().fullReset();

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

    public void preloadSounds() {
        // Preload the sounds to avoid lag
        wallBounceSound.setVolume(0);
        racketBounceSound.setVolume(0);

        playWallBounceSound();
        playRacketBounceSound();

        Timeline delay = new Timeline(new KeyFrame(Duration.seconds(2), event -> {
            wallBounceSound.setVolume(0.1);
            racketBounceSound.setVolume(0.5);
        }));
        delay.play();
    }

    public void playWallBounceSound() {
        Platform.runLater(() -> {
            wallBounceSound.seek(Duration.ZERO);
            wallBounceSound.play();
        });
    }

    public void playRacketBounceSound() {
        Platform.runLater(() -> {
            racketBounceSound.seek(Duration.ZERO);
            racketBounceSound.play();
        });
    }

    public void playScoreSound() {
        Platform.runLater(() -> {
            scoreSound.seek(Duration.ZERO);
            scoreSound.play();
        });
    }

    public GameView getView() {
        return gameView;
    }

    public static GameController getInstance() {
        return selfInstance;
    }
}
