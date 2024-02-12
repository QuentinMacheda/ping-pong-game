package src.view;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.geometry.Insets;

import src.controller.GameController;

public class WelcomeView {
    public GameController gameController;
    public GameView gameView;

    public Text welcomeText;
    public Image icon;
    public Button startButton;
    public VBox container;

    public WelcomeView(GameView gameView) {
        gameController = new GameController(gameView);

        // Text
        welcomeText = new Text();
        welcomeText.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.REGULAR, 25));
        welcomeText.setFill(Color.web("#F1E9DA"));
        welcomeText.setText("Welcome to my Ping Pong Game");

        // Image (Icon)
        icon = new Image("/resources/icon.png", 150, 150, false, false);

        // Start button
        startButton = new Button("Start the game");
        startButton.setPadding(new Insets(15));
        startButton.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.REGULAR, 15));
        startButton.setTextFill(Color.web("#1B1B1E"));
        startButton.setStyle("-fx-background-color: #FF910A");

        // Button action
        startButton.setOnAction(e -> {
            container.setVisible(false); // Hide the welcome view
            gameController.startGame(); // Start the game
        });

        // Container
        container = new VBox(40);
        container.getChildren().addAll(welcomeText, new ImageView(icon), startButton);
        container.setAlignment(Pos.CENTER);
        gameView.setCenter(container);
    }
}
