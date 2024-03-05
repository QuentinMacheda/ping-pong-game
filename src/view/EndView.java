package src.view;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import src.controller.MainController;

public class EndView extends BorderPane {
    private Text winnerText;
    private Text looserText;
    private Button playAgainButton;
    private VBox container;

    public EndView(String winnerName, String looserName) {
        // Text
        winnerText = new Text();
        winnerText.setText(winnerName.toUpperCase() + " WON !");
        winnerText.getStyleClass().add("winner-text");

        looserText = new Text();
        looserText.setText(looserName + ", wanna take your revenge ?");
        looserText.getStyleClass().add("looser-text");

        VBox textContainer = new VBox(15, winnerText, looserText);
        textContainer.setAlignment(Pos.CENTER);

        // Start button
        playAgainButton = new Button("Play again");
        playAgainButton.getStyleClass().addAll("btn", "orange-btn");

        // Container
        container = new VBox(60, textContainer, playAgainButton);
        container.setAlignment(Pos.CENTER);
        this.setCenter(container);

        // Controller Actions (do not need a controller as there is only one action)
        // On click
        playAgainButton.setOnAction(e -> {
            MainController.getInstance().fullReset();
            MainView.getInstance().hideEnd(); // Remove the end view
        });
        // On key pressed ENTER
        playAgainButton.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ENTER) {
                MainController.getInstance().fullReset();
                MainView.getInstance().hideEnd(); // Remove the end view
            }
        });
    }
}
