package pingPongGame;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import pingPongGame.view.MainView;
import pingPongGame.controller.MainController;

/**
 * The main class responsible for launching the Ping Pong Game application.
 */
public class App extends Application {
    private MainView mainView;
    private MainController mainController;

    /**
     * The main entry point for the JavaFX application.
     *
     * @param args The command-line arguments.
     */
    public static void main(String[] args) {
        launch(args);
    }

    /**
     * Initializes and starts the Ping Pong Game application.
     *
     * @param primaryStage The primary stage for the JavaFX application.
     */
    @Override
    public void start(Stage primaryStage) {
        // Initialize main controller and view
        mainController = MainController.getInstance();
        mainView = MainView.getInstance();

        // Create the main scene
        Scene mainScene = new Scene(mainView, 1024, 668);

        // Import CSS styles
        mainScene.getStylesheets().addAll(
                App.class.getResource("/style/main.css").toExternalForm(),
                App.class.getResource("/style/settings.css").toExternalForm(),
                App.class.getResource("/style/game.css").toExternalForm(),
                App.class.getResource("/style/end.css").toExternalForm(),
                App.class.getResource("/style/welcome.css").toExternalForm(),
                App.class.getResource("/style/button.css").toExternalForm(),
                App.class.getResource("/style/slider.css").toExternalForm(),
                App.class.getResource("/style/top-bar.css").toExternalForm());

        // Set window properties
        primaryStage.getIcons().add(new Image(App.class.getResource("/icon.png").toExternalForm()));
        primaryStage.setTitle("Ping Pong Game");
        primaryStage.setScene(mainScene);
        primaryStage.show();
    }
}
