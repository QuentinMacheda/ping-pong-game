package src.controller;

import javafx.scene.layout.BorderPane;
import src.model.PlayerModel;
import src.view.gameComponents.PlayerView;

public class PlayerController {
    public BorderPane playersContainer;
    public PlayerModel playerModel;
    public PlayerView playerView;
    public String name;
    public int score;
    public String side;

    public PlayerController(String name, int score, String side, BorderPane playersContainer) {
        playerModel = new PlayerModel(name, score, side);
        playerView = new PlayerView(playerModel.getName(), playerModel.getScore(), playerModel.getSide(),
                playersContainer);
    }

    public void getPlayerName() {
        playerModel.getName();
    }
}
