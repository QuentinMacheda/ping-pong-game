package pingPongGame.view;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import pingPongGame.controller.MainController;

/**
 * The view displayed at the end of the game, showing the winner, loser, and a
 * play again button.
 */
public class EndView extends BorderPane {
    /** The text messages displayed at the end of the game */
    private Text winnerText, looserText;

    /** The button to play the game again. */
    private Button playAgainButton;

    /** The container holding the winner text, loser text, and play again button. */
    private VBox container;

    /**
     * Constructs the EndView with the specified winner and loser names.
     *
     * @param winnerName The name of the winner.
     * @param looserName The name of the loser.
     */
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
