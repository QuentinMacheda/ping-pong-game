package src.view.components;

import javafx.scene.text.Text;
import src.controller.components.PlayerController;

public class PlayerView extends Text {
    public PlayerController playerController;

    public PlayerView() {
        playerController = new PlayerController();

        this.setText(playerController.getName() + " | " + playerController.getScore());
        this.getStyleClass().addAll("player-info");
    }

    public void updateName(String newName) {
        this.setText(newName + " | " + playerController.getScore());
    }

    public void updateScore(int newScore) {
        this.setText(playerController.getName() + " | " + newScore);
    }
}
