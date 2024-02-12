import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

// Importing the controller, view, and model
import src.view.*;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage window) {
        GameView gameView = new GameView();

        Scene mainScene = new Scene(gameView, 1000, 700);

        window.setTitle("Ping Pong Game");

        // Set the style of the stage
        window.getIcons().add(new Image("file:resources/icon.png"));
        window.setScene(mainScene);
        window.show();
    }
}
