import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import src.view.MainView;

public class Main extends Application {
    public MainView mainView;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage window) {
        mainView = new MainView();

        Scene mainScene = new Scene(mainView, 1000, 700);

        window.setTitle("Ping Pong Game");

        // Set the style of the stage
        window.getIcons().add(new Image("file:resources/icon.png"));
        window.setScene(mainScene);
        window.show();
    }
}
