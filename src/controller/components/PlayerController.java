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
        playerView = new PlayerView(this);
    }

    public PlayerView getView() {
        return playerView;
    }

    public String getName() {
        return playerModel.getName();
    }

    public void updateName(String newName) {
        playerModel.setName(newName);
        this.getView().update();
    }

    public int getScore() {
        return playerModel.getScore();
    }

    public void incrementScore() {
        playerModel.setScore(getScore() + 1);
        this.getView().update();
    }

    public void setPlayerSide(PlayerModel.PlayerSide playerSide) {
        playerModel.setPlayerSide(playerSide);
    }
}
