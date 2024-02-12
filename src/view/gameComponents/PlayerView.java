package src.view.gameComponents;

import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class PlayerView {
    public BorderPane playersContainer;
    public String name;
    public int score;
    public String side;
    public Text text;

    public PlayerView(String name, int score, String side, BorderPane playersContainer) {
        this.name = name;
        this.score = score;
        this.side = side;
        this.playersContainer = playersContainer;

        text = new Text();
        text.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.REGULAR, 25));
        text.setFill(Color.web("#F1E9DA"));
        text.setText(this.name + " : " + this.score);

        if (this.side == "Left") {
            playersContainer.setLeft(text);
        } else {
            playersContainer.setRight(text);
        }
    }
}
