package pingPongGame;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import pingPongGame.view.MainView;
import pingPongGame.controller.MainController;

public class App extends Application {
    public MainView mainView;
    public MainController mainController;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage window) {
        mainController = MainController.getInstance();
        Scene mainScene = new Scene(MainView.getInstance(), 1024, 668);

        // Import CSS
        mainScene.getStylesheets().addAll(
                App.class.getResource("/style/main.css").toExternalForm(),
                App.class.getResource("/style/settings.css").toExternalForm(),
                App.class.getResource("/style/game.css").toExternalForm(),
                App.class.getResource("/style/end.css").toExternalForm(),
                App.class.getResource("/style/welcome.css").toExternalForm(),
                App.class.getResource("/style/button.css").toExternalForm(),
                App.class.getResource("/style/slider.css").toExternalForm(),
                App.class.getResource("/style/top-bar.css").toExternalForm());

        window.getIcons().add(new Image(App.class.getResource("/icon.png").toExternalForm()));
        window.setTitle("Ping Pong Game");
        window.setScene(mainScene);
        window.show();
    }
}
