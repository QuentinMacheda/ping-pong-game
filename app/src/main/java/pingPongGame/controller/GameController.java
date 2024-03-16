package pingPongGame.controller;

import javafx.util.Duration;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import pingPongGame.controller.MainController.MainState;
import pingPongGame.controller.components.*;
import pingPongGame.controller.layout.GameControlsController;
import pingPongGame.model.GameModel;
import pingPongGame.model.components.PlayerModel;
import pingPongGame.view.GameView;

/**
 * The GameController class manages the game logic, including players, rackets,
 * ball, and game state.
 * 
 * @author Quentin Macheda
 * @version 1.4
 * @since 2024-03-09
 */
public class GameController {

    /**
     * Singleton instance of GameController.
     */
    public static GameController selfInstance = new GameController();

    /**
     * Media player for the sound design.
     */
    public final MediaPlayer wallBounceSound = new MediaPlayer(
            new Media(GameController.class.getResource("/sound-design/wall-bounce.mp3").toString()));

    /**
     * Media player for the sound design.
     */
    public final MediaPlayer racketBounceSound = new MediaPlayer(
            new Media(GameController.class.getResource("/sound-design/racket-bounce.mp3").toString()));

    /**
     * Media player for the sound design.
     */
    public final MediaPlayer scoreSound = new MediaPlayer(
            new Media(GameController.class.getResource("/sound-design/score.mp3").toString()));

    /**
     * The GameView instance associated with the GameController.
     */
    public GameView gameView;

    /**
     * The GameControlsController instance for the controls of the game :
     * PLAY, PAUSE & RESTART.
     */
    public GameControlsController gameControlsController;

    /**
     * The PlayerController instance for the left and right player.
     */
    public PlayerController playerLeftController, playerRightController;

    /**
     * The RacketController instance for the left and right racket.
     */
    public RacketController racketLeftController, racketRightController;

    /**
     * The BallController instance for the ball.
     */
    public BallController ballController;

    /**
     * Private constructor to enforce Singleton pattern.
     */
    private GameController() {
        this.fullReset();
        this.preloadSounds();
    }

    /**
     * Initializes the GameView associated with the GameController.
     */
    public void initView() {
        gameView = new GameView();

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

    /**
     * Handles scoring based on the player who scored.
     *
     * @param playerSide The side of the player who scored.
     */
    public void score(PlayerModel.PlayerSide playerSide) {
        MainController.getInstance().setMainState(MainState.SCORED);
        this.playScoreSound();

        if (playerSide == PlayerModel.PlayerSide.LEFT) {
            playerRightController.incrementScore();
            if (playerRightController.getScore() < GameModel.getInstance().getEndGameScore()) {
                this.getView().setMessageToGoal(playerRightController.getName());
                this.resetAfterScore();
            } else {
                this.reset();
                MainController.getInstance().gameOver(playerRightController.getName(), playerLeftController.getName());
            }
        } else if (playerSide == PlayerModel.PlayerSide.RIGHT) {
            playerLeftController.incrementScore();
            if (playerLeftController.getScore() < GameModel.getInstance().getEndGameScore()) {
                this.getView().setMessageToGoal(playerLeftController.getName());
                this.resetAfterScore();
            } else {
                this.reset();
                MainController.getInstance().gameOver(playerLeftController.getName(), playerRightController.getName());
            }
        }
    }

    /**
     * Resets the game
     */
    public void reset() {
        ballController.reset();
        racketLeftController.reset();
        racketRightController.reset();
    }

    /**
     * Resets the game after a score with a 2-second pause.
     */
    public void resetAfterScore() {
        Timeline scorePause = new Timeline(new KeyFrame(Duration.millis(2000), event -> {
            this.reset();
            this.getView().setMessageToStart();
        }));
        scorePause.play();
    }

    /**
     * Fully resets the game, including players, rackets, and ball.
     */
    public void fullReset() {
        GameModel.getInstance().fullReset();
        gameControlsController = new GameControlsController();

        playerLeftController = new PlayerController();
        playerLeftController.initView();
        playerLeftController.setPlayerSide(PlayerModel.PlayerSide.LEFT);
        playerLeftController.updateName("Player 1");

        playerRightController = new PlayerController();
        playerRightController.initView();
        playerRightController.setPlayerSide(PlayerModel.PlayerSide.RIGHT);
        playerRightController.updateName("Player 2");

        racketLeftController = new RacketController();
        racketLeftController.initView();

        racketRightController = new RacketController();
        racketRightController.initView();

        ballController = new BallController();
        ballController.initView();
    }

    /**
     * Preloads game sounds to avoid lag during gameplay.
     */
    public void preloadSounds() {
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

    /**
     * Plays the wall bounce sound.
     */
    public void playWallBounceSound() {
        Platform.runLater(() -> {
            wallBounceSound.seek(Duration.ZERO);
            wallBounceSound.play();
        });
    }

    /**
     * Plays the racket bounce sound.
     */
    public void playRacketBounceSound() {
        Platform.runLater(() -> {
            racketBounceSound.seek(Duration.ZERO);
            racketBounceSound.play();
        });
    }

    /**
     * Plays the score sound.
     */
    public void playScoreSound() {
        Platform.runLater(() -> {
            scoreSound.seek(Duration.ZERO);
            scoreSound.play();
        });
    }

    /**
     * Gets the GameView associated with the GameController.
     *
     * @return The GameView instance.
     */
    public GameView getView() {
        return gameView;
    }

    /**
     * Gets the singleton instance of GameController.
     *
     * @return The GameController instance.
     */
    public static GameController getInstance() {
        return selfInstance;
    }
}
