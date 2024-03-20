package pingPongGame.view.layout;

import javafx.scene.layout.BorderPane;

import java.util.Optional;

import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import pingPongGame.controller.MainController;
import pingPongGame.controller.layout.GameControlsController;
import pingPongGame.view.MainView;

/**
 * The GameControlsView containing controls view for the game :
 * PLAY, PAUSE, RESTART.
 * 
 * @author Quentin Macheda
 * @version 1.4
 * @since 2024-03-09
 */
public class GameControlsView extends BorderPane {
    private GameControlsController gameControlsController;

    private Image playImage, pauseImage, restartImage;

    /**
     * The play/pause and restart images used in the game controls view.
     */
    private ImageView playPauseButton, restartButton;

    /**
     * The container for the play/pause and restart buttons.
     */
    private HBox controlsBox;

    /**
     * Constructs the GameControlsView, initializing the controls for the game.
     */
    public GameControlsView() {
        gameControlsController = new GameControlsController();
        initControls();
        handleControlsActions();
    }

    /**
     * Initializes the controls for the game.
     */
    private void initControls() {
        playImage = new Image(GameControlsView.class.getResource("/images/play.png").toExternalForm(), 25, 25, true,
                true);
        pauseImage = new Image(GameControlsView.class.getResource("/images/pause.png").toExternalForm(), 25, 25, true,
                true);
        restartImage = new Image(GameControlsView.class.getResource("/images/restart.png").toExternalForm(), 30, 30,
                true, true);

        playPauseButton = new ImageView(playImage);
        restartButton = new ImageView(restartImage);
        playPauseButton.getStyleClass().add("game-control-button");
        restartButton.getStyleClass().add("game-control-button");

        controlsBox = new HBox(20, playPauseButton, restartButton);
        controlsBox.setAlignment(Pos.CENTER);

        this.setCenter(controlsBox);
        controlsBox.getStyleClass().add("game-controls");
    }

    private void restartConfirm() {
        Alert alertRestart = new Alert(AlertType.CONFIRMATION);
        alertRestart.setTitle("Restart Confirmation");
        alertRestart.setHeaderText("Restart Confirmation");
        alertRestart.setContentText("Are you sure you want to restart the game ?");

        // Add buttons
        ButtonType buttonTypeYes = new ButtonType("Yes");
        ButtonType buttonTypeNo = new ButtonType("No");
        alertRestart.getButtonTypes().setAll(buttonTypeYes, buttonTypeNo);

        // Show the alert and wait for user input
        Optional<ButtonType> result = alertRestart.showAndWait();
        if (result.isPresent() && result.get() == buttonTypeYes) {
            MainController.getInstance().fullReset();
            MainView.getInstance().hideGame();
        } else {
            if (MainController.getInstance().getMainState() == MainController.MainState.PAUSED) {
                gameControlsController.play();
                playPauseButton.setImage(playImage);
            }
            alertRestart.close();
        }
    }

    /**
     * Handles the actions on the buttons.
     */
    private void handleControlsActions() {
        Platform.runLater(() -> {
            playPauseButton.setOnMouseClicked(e -> {
                switch (MainController.getInstance().getMainState()) {
                    case MainController.MainState.PAUSED:
                        gameControlsController.play();
                        playPauseButton.setImage(playImage);
                        break;
                    case MainController.MainState.RUNNING:
                        gameControlsController.pause();
                        playPauseButton.setImage(pauseImage);
                        break;
                    default:
                        break;
                }
            });
        });

        Platform.runLater(() -> {
            restartButton.setOnMouseClicked(e -> {
                if (MainController.getInstance().getMainState() != MainController.MainState.SCORED) {
                    if (MainController.getInstance().getMainState() == MainController.MainState.RUNNING) {
                        gameControlsController.pause();
                        playPauseButton.setImage(pauseImage);
                    }

                    this.restartConfirm();
                }
            });
        });
    }
}
