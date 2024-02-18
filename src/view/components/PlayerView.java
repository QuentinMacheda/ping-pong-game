package src.view.components;

import javafx.scene.text.Text;

public class PlayerView extends Text {
    public String name;
    public int score;

    public PlayerView(String name, int score) {
        this.name = name;
        this.score = score;

        this.setText(this.name + " : " + this.score);
        this.getStyleClass().addAll("player-info");
    }

    public void updateName(String newName) {
        this.setText(newName + " : " + this.score);
    }

    public void updateScore(int score) {
        this.score = score;
        this.setText(this.name + " : " + this.score);
    }
}
