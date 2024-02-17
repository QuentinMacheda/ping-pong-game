package src.controller;

import src.controller.components.PlayerController;
import src.controller.components.RacketController;
import src.view.GameView;

public class GameController {
    public static GameController selfInstance = new GameController();
    public GameView gameView;
    public PlayerController playerLeftController;
    public PlayerController playerRightController;
    public RacketController racketLeftController;
    public RacketController racketRightController;
    public int endGameScore;

    // Constructor
    private GameController() {
        this.endGameScore = 10;

        playerLeftController = new PlayerController("Player1", 0);
        playerRightController = new PlayerController("Player2", 0);

        racketLeftController = new RacketController(20, 120);
        racketRightController = new RacketController(20, 120);
    }

    public int getEndGameScore() {
        return this.endGameScore;
    }

    public void updateEndGameScore(int newScore) {
        this.endGameScore = newScore;
    }

    public GameView getView() {
        gameView = new GameView();
        return gameView;
    }

    public static GameController getInstance() {
        return selfInstance;
    }
}
