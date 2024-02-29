package src.controller.components;

import src.model.components.PlayerModel;
import src.view.components.PlayerView;

public class PlayerController {
    private PlayerModel playerModel;
    private PlayerView playerView;

    public PlayerController() {
        playerModel = new PlayerModel();
    }

    public void initView() {
        playerView = new PlayerView();
    }

    public PlayerView getView() {
        return playerView;
    }

    public String getName() {
        return playerModel.getName();
    }

    public void updateName(String name) {
        playerModel.setName(name);
        this.getView().updateName(this.getName());
    }

    public int getScore() {
        return playerModel.getScore();
    }

    public void incrementScore() {
        playerModel.setScore(getScore() + 1);
        this.getView().updateScore(this.getScore());
    }
}
