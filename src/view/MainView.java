package src.view;

import javafx.scene.layout.StackPane;
import src.controller.GameController;
import src.controller.SettingsController;
import src.controller.layout.TopBarController;

public class MainView extends StackPane {
    public static MainView selfInstance = new MainView(); // Singleton
    public TopBarController topBarController;
    public SettingsController settingsController;
    public WelcomeView welcomeView;
    public GameView gameView;

    // Constructor
    private MainView() {
        // Set the background color
        this.setStyle("-fx-background-color: #1B1B1E");
    }

    public void displayWelcome() {
        welcomeView = new WelcomeView();
        this.getChildren().add(welcomeView);
    }

    public void hideWelcome() {
        this.getChildren().remove(welcomeView);
    }

    public void displayGame() {
        gameView = GameController.getInstance().getView();
        this.getChildren().add(gameView);
    }

    public void hideGame() {
        this.getChildren().remove(gameView);
    }

    public void displaySettings(String type) {
        // Display the settings view
        settingsController = new SettingsController(type);
        this.getChildren().add(settingsController.settingsView);
    }

    public void hideSettings() {
        this.getChildren().remove(settingsController.settingsView);
    }

    public static MainView getInstance() {
        return selfInstance; // Singleton
    }
}
