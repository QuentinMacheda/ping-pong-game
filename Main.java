import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

// Importing the controller, view, and model
import src.view.*;
import src.controller.*;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage window) {
        WelcomeView welcomeView = new WelcomeView();
        GameController gameController = new GameController();

        Scene mainScene = new Scene(welcomeView, 500, 500);

        window.setTitle("Ping Pong Game - v1.0");
        window.setScene(mainScene);
        window.show();
    }
}
