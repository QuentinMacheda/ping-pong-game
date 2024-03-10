package pingPongGame.view;

import javafx.scene.layout.StackPane;
import pingPongGame.controller.GameController;
import pingPongGame.controller.MainController;

public class MainView extends StackPane {
    public static MainView selfInstance = new MainView(); // Singleton
    public WelcomeView welcomeView;
    public EndView endView;
    public GameView gameView;

    // Constructor
    private MainView() {
        // Set the background color
        this.getStyleClass().add("main-container");
    }

    public void displayWelcome() {
        welcomeView = new WelcomeView();
        this.getChildren().add(welcomeView);
    }

    public void hideWelcome() {
        this.getChildren().remove(welcomeView);
    }

    public void displayGame() {
        GameController.getInstance().initView();
        this.getChildren().add(GameController.getInstance().getView());
    }

    public void hideGame() {
        this.getChildren().remove(GameController.getInstance().getView());
    }

    public void displayEnd(String winnerName, String looserName) {
        endView = new EndView(winnerName, looserName);
        this.getChildren().add(endView);
    }

    public void hideEnd() {
        this.getChildren().remove(endView);
    }

    public void displaySettings(String type) {
        MainController.getInstance().settingsController.initView(type);
        this.getChildren().add(MainController.getInstance().settingsController.settingsView);
    }

    public void hideSettings() {
        this.getChildren().remove(MainController.getInstance().settingsController.settingsView);
    }

    public static MainView getInstance() {
        return selfInstance; // Singleton
    }
}
