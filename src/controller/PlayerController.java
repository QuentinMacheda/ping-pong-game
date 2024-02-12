package src.controller;

import src.model.PlayerModel;
import src.view.components.PlayerView;

public class PlayerController {
    public PlayerModel playerModel;
    public PlayerView playerView;
    public String name;
    public int score;

    public PlayerController(String name, int score) {
        playerModel = new PlayerModel(name, score);
        playerView = new PlayerView(playerModel.getName(), playerModel.getScore());
    }

    public void getPlayerName() {
        playerModel.getName();
    }
}
