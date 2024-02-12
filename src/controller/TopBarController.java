package src.controller;

import src.view.GameView;
import src.view.TopBarView;

public class TopBarController {
    public GameView gameView;
    public TopBarView topBarView;

    public TopBarController(GameView gameView) {
        this.gameView = gameView;

        topBarView = new TopBarView(this.gameView);

        // Handle onclick menu buttons
        topBarView.exit.setOnAction(e -> System.exit(0));
    }
}
