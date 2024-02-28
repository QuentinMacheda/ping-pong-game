package src.view.components;

import javafx.scene.text.Text;
import src.controller.components.PlayerController;

public class PlayerView extends Text {
    public PlayerController playerController;
    public String name;
    public int score;

    public PlayerView() {
        playerController = new PlayerController();

        this.name = playerController.getName();
        this.score = playerController.getScore();

        this.setText(this.name + " | " + this.score);
        this.getStyleClass().addAll("player-info");
    }

    public void updateName(String newName) {
        this.setText(newName + " | " + this.score);
    }

    public void updateScore(int score) {
        this.score = score;
        this.setText(this.name + " | " + this.score);
    }
}
