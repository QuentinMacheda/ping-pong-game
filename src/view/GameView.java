package src.view;

import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import src.view.components.RacketView;
import src.view.components.BallView;
import src.view.components.PlayerView;
import src.controller.GameController;
import src.controller.layout.TopBarController;

public class GameView extends BorderPane {
    public BallView ballView;
    public RacketView racketLeftView;
    public RacketView racketRightView;
    public PlayerView playerLeftView;
    public PlayerView playerRightView;
    public Text startMessage;

    // Constructor
    public GameView() {
        setComponents(); // Set the view
        handleKeyboardEvents(); // Handle keyboard events
    }

    public void setComponents() {
        /*
         * Top Bar
         */
        TopBarController.getInstance().initView();
        this.setTop(TopBarController.getInstance().getView());

        /*
         * Rackets
         */
        racketLeftView = GameController.getInstance().racketLeftController.getView();
        racketRightView = GameController.getInstance().racketRightController.getView();
        this.setLeft(racketLeftView);
        this.setRight(racketRightView);

        /*
         * Ball & Start Message
         */
        ballView = GameController.getInstance().ballController.getView();
        startMessage = new Text("PRESS ENTER TO\nSTART THE GAME");
        startMessage.getStyleClass().add("start-message");

        /*
         * Players container
         */
        // Adding players names/scores
        playerLeftView = GameController.getInstance().playerLeftController.getView();
        playerRightView = GameController.getInstance().playerRightController.getView();

        BorderPane playersContainer = new BorderPane();
        playersContainer.getStyleClass().add("players-container");
        playersContainer.setLeft(playerLeftView);
        playersContainer.setRight(playerRightView);

        StackPane centerContainer = new StackPane(playersContainer, startMessage, ballView);
        this.setCenter(centerContainer);
    }

    public void handleKeyboardEvents() {
        this.setFocusTraversable(true);

        /*
         * Handle key press event for rackets and start game
         */
        this.setOnKeyPressed(event -> {
            // Check which key is pressed for which racket (Left or Right)
            if (event.getCode() == KeyCode.Q || event.getCode() == KeyCode.W) {
                GameController.getInstance().racketLeftController.setKeyPressed(true);
            } else if (event.getCode() == KeyCode.UP || event.getCode() == KeyCode.DOWN) {
                GameController.getInstance().racketRightController.setKeyPressed(true);
            }

            switch (event.getCode()) {
                case Q:
                    GameController.getInstance().racketLeftController.setRacketKeyCode(event.getCode());
                    break;
                case W:
                    GameController.getInstance().racketLeftController.setRacketKeyCode(event.getCode());
                    break;
                case UP:
                    GameController.getInstance().racketRightController.setRacketKeyCode(event.getCode());
                    break;
                case DOWN:
                    GameController.getInstance().racketRightController.setRacketKeyCode(event.getCode());
                    break;
                case ENTER:
                    if (!GameController.getInstance().ballController.getKeyPressed()) {
                        GameController.getInstance().ballController.startThread();
                        GameController.getInstance().ballController.setKeyPressed(true);

                        startMessage.setVisible(false);
                    }
                    break;
            }

        });

        /*
         * Handle key release event for rackets
         */
        this.setOnKeyReleased(event -> {
            // Check which key is pressed for which racket (Left or Right)
            if (event.getCode() == KeyCode.Q || event.getCode() == KeyCode.W) {
                GameController.getInstance().racketLeftController.setKeyPressed(false);
            } else if (event.getCode() == KeyCode.UP || event.getCode() == KeyCode.DOWN) {
                GameController.getInstance().racketRightController.setKeyPressed(false);
            }
        });
    }
}
