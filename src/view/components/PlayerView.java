package src.view.components;

import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class PlayerView extends Text {
    public String name;
    public int score;

    public PlayerView(String name, int score) {
        this.name = name;
        this.score = score;

        this.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.REGULAR, 25));
        this.setFill(Color.web("#F1E9DA"));
        this.setText(this.name + " : " + this.score);
    }

    public void updateName(String newName) {
        this.setText(newName + " : " + this.score);
    }

    public void updateScore(int score) {
        this.score = score;
        this.setText(this.name + " : " + this.score);
    }
}
