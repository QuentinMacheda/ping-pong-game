package pingPongGame.view;

import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import pingPongGame.view.components.RacketView;
import pingPongGame.view.components.BallView;
import pingPongGame.view.components.PlayerView;
import pingPongGame.controller.GameController;
import pingPongGame.controller.MainController;
import pingPongGame.controller.MainController.MainState;

/**
 * The view for playing the Ping Pong Game, including rackets, ball, and player
 * information.
 */
public class GameView extends BorderPane {
    /** The view for the ball in the game. */
    public BallView ballView;

    /** The view for the left and right racket in the game. */
    public RacketView racketLeftView, racketRightView;

    /** The view for the players on the left and right side. */
    public PlayerView playerLeftView, playerRightView;

    /** The text displaying start or goal messages. */
    public Text startMessage;

    /** The container for players and the start/goal message. */
    public StackPane centerContainer;

    /**
     * Constructs the GameView, setting up the game components and handling keyboard
     * events.
     */
    public GameView() {
        setComponents(); // Set the view
        handleKeyboardEvents(); // Handle keyboard events
    }

    /**
     * Sets up the components of the game view, including rackets, ball, and player
     * information.
     */
    public void setComponents() {
        /*
         * Top Bar
         */
        GameController.getInstance().topBarController.initView();
        this.setTop(GameController.getInstance().topBarController.getView());

        /*
         * Rackets
         */
        racketLeftView = GameController.getInstance().racketLeftController.getView();
        racketRightView = GameController.getInstance().racketRightController.getView();
        this.setLeft(racketLeftView);
        this.setRight(racketRightView);

        /*
         * Ball & Start/Goal Message
         */
        ballView = GameController.getInstance().ballController.getView();
        startMessage = new Text();
        this.setMessageToStart();

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

        centerContainer = new StackPane(playersContainer, startMessage, ballView);
        this.setCenter(centerContainer);
    }

    /**
     * Sets the message to start the game.
     */
    public void setMessageToStart() {
        if (!startMessage.isVisible())
            startMessage.setVisible(true);
        startMessage.setText("PRESS ENTER TO\nSTART THE GAME");
        startMessage.getStyleClass().remove("goal-message");
        startMessage.getStyleClass().add("start-message");
    }

    /**
     * Sets the message to a goal scored by a player.
     *
     * @param playerName The name of the player who scored.
     */
    public void setMessageToGoal(String playerName) {
        if (!startMessage.isVisible())
            startMessage.setVisible(true);
        startMessage.setText(playerName.toUpperCase() + " SCORES");
        startMessage.getStyleClass().remove("start-message");
        startMessage.getStyleClass().add("goal-message");
    }

    /**
     * Handles keyboard events for controlling the game, including racket movements
     * and starting the game.
     */
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
                        MainController.getInstance().setMainState(MainState.RUNNING);
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
