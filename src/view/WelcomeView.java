package src.view;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
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
        TopBarController.getInstance().initView();
        this.setTop(TopBarController.getInstance().getView());

        // Set Welcome Content
        // Text
        welcomeText = new Text();
        welcomeText.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.REGULAR, 40));
        welcomeText.setFill(Color.web("#F1E9DA"));
        welcomeText.setText("Ping Pong Game");

        // Image (Icon)
        icon = new Image("/resources/icon.png", 150, 150, false, false);

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
            MainView.getInstance().getChildren().remove(this); // Remove the welcome view
            MainController.getInstance().startGame(); // Start the game
        });
        // On key pressed ENTER
        startButton.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ENTER) {
                MainView.getInstance().getChildren().remove(this); // Remove the welcome view
                MainController.getInstance().startGame(); // Start the game
            }
        });
    }
}
