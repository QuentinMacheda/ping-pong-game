package pingPongGame.view;

import javafx.scene.layout.StackPane;
import pingPongGame.controller.GameController;
import pingPongGame.controller.MainController;

/**
 * The main view of the Ping Pong Game application, managing the display of
 * different game views.
 */
public class MainView extends StackPane {
    /** The singleton instance of MainView. */
    public static MainView selfInstance = new MainView();

    /** The view for welcoming players. */
    public WelcomeView welcomeView;

    /** The view for displaying the end of the game. */
    public EndView endView;

    /** The view for playing the game. */
    public GameView gameView;

    /**
     * Private constructor to enforce the singleton pattern.
     */
    private MainView() {
        // Set the background color
        this.getStyleClass().add("main-container");
    }

    /**
     * Displays the welcome view.
     */
    public void displayWelcome() {
        welcomeView = new WelcomeView();
        this.getChildren().add(welcomeView);
    }

    /**
     * Hides the welcome view.
     */
    public void hideWelcome() {
        this.getChildren().remove(welcomeView);
    }

    /**
     * Displays the game view.
     */
    public void displayGame() {
        GameController.getInstance().initView();
        this.getChildren().add(GameController.getInstance().getView());
    }

    /**
     * Hides the game view.
     */
    public void hideGame() {
        this.getChildren().remove(GameController.getInstance().getView());
    }

    /**
     * Displays the end view with winner and loser names.
     *
     * @param winnerName The name of the winner.
     * @param looserName The name of the loser.
     */
    public void displayEnd(String winnerName, String looserName) {
        endView = new EndView(winnerName, looserName);
        this.getChildren().add(endView);
    }

    /**
     * Hides the end view.
     */
    public void hideEnd() {
        this.getChildren().remove(endView);
    }

    /**
     * Displays the settings view of a specific type.
     *
     * @param type The type of settings to display.
     */
    public void displaySettings(String type) {
        MainController.getInstance().settingsController.initView(type);
        this.getChildren().add(MainController.getInstance().settingsController.settingsView);
    }

    /**
     * Hides the settings view.
     */
    public void hideSettings() {
        this.getChildren().remove(MainController.getInstance().settingsController.settingsView);
    }

    /**
     * Gets the singleton instance of MainView.
     *
     * @return The MainView instance.
     */
    public static MainView getInstance() {
        return selfInstance;
    }
}
