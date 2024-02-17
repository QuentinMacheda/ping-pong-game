package src.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

import src.controller.MainController;
import src.controller.layout.TopBarController;

public class WelcomeView extends BorderPane {
    private Text welcomeText;
    private Image icon;
    private Button startButton;
    private VBox container;

    public WelcomeView() {
        // Set Top Bar
        this.setTop(TopBarController.getInstance().getView());

        // Set Welcome Content
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

        // Container
        container = new VBox(40);
        container.getChildren().addAll(welcomeText, new ImageView(icon), startButton);
        container.setAlignment(Pos.CENTER);
        this.setCenter(container);

        // Controller Actions (do not need a controller as there is only one action)
        startButton.setOnAction(e -> {
            MainView.getInstance().getChildren().remove(this); // Remove the welcome view
            MainController.getInstance().startGame(); // Start the game
        });
    }
}
