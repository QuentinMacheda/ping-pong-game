package src.view.components;

import javafx.scene.text.Text;
import src.controller.components.PlayerController;

public class PlayerView extends Text {
    public PlayerController playerController;

    public PlayerView(PlayerController playerController) {
        this.playerController = playerController;

        this.setText(playerController.getName() + " | " + playerController.getScore());
        this.getStyleClass().addAll("player-info");
    }

    public void update() {
        this.setText(playerController.getName() + " | " + this.playerController.getScore());
    }
}
