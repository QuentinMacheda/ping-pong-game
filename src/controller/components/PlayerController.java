package src.controller.components;

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

    public PlayerView getView() {
        return playerView;
    }

    public String getName() {
        return playerModel.getName();
    }

    public void updateName(String name) {
        playerModel.setName(name);
        this.getView().updateName(playerModel.getName());
    }

    public int getScore() {
        return playerModel.getScore();
    }
}
