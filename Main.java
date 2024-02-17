import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import src.view.MainView;
import src.controller.MainController;

public class Main extends Application {
    public MainView mainView;
    public MainController mainController;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage window) {
        mainController = MainController.getInstance();
        Scene mainScene = new Scene(MainView.getInstance(), 1000, 700);

        window.setTitle("Ping Pong Game");

        // Set the style of the stage
        window.getIcons().add(new Image("file:resources/icon.png"));
        window.setScene(mainScene);
        window.show();
    }
}
