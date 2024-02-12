package src.view;

import javafx.scene.layout.StackPane;
import src.controller.MainController;
import src.controller.SettingsController;
import src.controller.layout.TopBarController;

public class MainView extends StackPane {
    public MainController mainController;
    public TopBarController topBarController;
    public SettingsController settingsController;
    public WelcomeView welcomeView;
    public GameView gameView;

    // Constructor
    public MainView() {
        mainController = new MainController(this);

        // Set the background color
        this.setStyle("-fx-background-color: #1B1B1E");
    }

    public void welcome() {
        welcomeView = new WelcomeView(this);
        this.getChildren().add(welcomeView);
    }

    public void startGame() {
        gameView = new GameView(this);
        this.getChildren().add(gameView);
        mainController.setMainState("RUNNING");
    }

    public void settings() {
        // Remove the current view
        switch (mainController.getMainState()) {
            case WELCOME:
                this.getChildren().remove(welcomeView);
                break;
            case RUNNING:
                this.getChildren().remove(gameView);
                break;
            default:
                break;
        }

        // Display the settings view
        settingsController = new SettingsController(this);
        this.getChildren().add(settingsController.settingsView);
        mainController.setMainState("SETTINGS");
    }
}
