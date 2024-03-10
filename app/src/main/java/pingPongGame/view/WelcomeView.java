package pingPongGame.view;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import pingPongGame.controller.GameController;
import pingPongGame.controller.MainController;

public class WelcomeView extends BorderPane {
    private Text welcomeText;
    private Image icon;
    private Button startButton;
    private VBox container;

    public WelcomeView() {
        /*
         * Top Bar
         */
        GameController.getInstance().topBarController.initView();
        this.setTop(GameController.getInstance().topBarController.getView());

        // Set Welcome Content
        // Text
        welcomeText = new Text();
        welcomeText.setText("PING PONG GAME");
        welcomeText.getStyleClass().add("welcome-text");

        // Image (Icon)
        icon = new Image(WelcomeView.class.getResource("/icon.png").toExternalForm(), 120, 120, false, false);

        // Start button
        startButton = new Button("Start the game");
        startButton.getStyleClass().addAll("btn", "orange-btn");

        // Container
        container = new VBox(40);
        container.getChildren().addAll(welcomeText, new ImageView(icon), startButton);
        container.setAlignment(Pos.CENTER);
        this.setCenter(container);

        // Controller Actions (do not need a controller as there is only one action)
        // On click
        startButton.setOnAction(e -> {
            MainView.getInstance().hideWelcome(); // Remove the welcome view
            MainController.getInstance().startGame(); // Start the game
        });
        // On key pressed ENTER
        startButton.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ENTER) {
                MainView.getInstance().hideWelcome(); // Remove the welcome view
                MainController.getInstance().startGame(); // Start the game
            }
        });
    }
}
