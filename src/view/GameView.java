package src.view;

import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import src.view.components.RacketView;
import src.view.components.BallView;
import src.controller.GameController;
import src.controller.layout.TopBarController;

public class GameView extends BorderPane {
    public BallView ballView;
    public RacketView racketLeftView;
    public RacketView racketRightView;

    // Constructor
    public GameView() {
        // Set Top Bar
        this.setTop(TopBarController.getInstance().getView());

        // Set Rackets
        racketLeftView = GameController.getInstance().racketLeftController.getView();
        racketRightView = GameController.getInstance().racketRightController.getView();
        this.setLeft(racketLeftView);
        this.setRight(racketRightView);

        // Set Ball
        ballView = GameController.getInstance().ballController.getView();
        this.setCenter(ballView);

        // Rackets Keyboard Control
        this.setFocusTraversable(true);
        this.setOnKeyPressed(event -> {
            // Check which key is pressed for which racket (Left or Right)
            if (event.getCode() == KeyCode.Q || event.getCode() == KeyCode.W) {
                GameController.getInstance().racketLeftController.setKeyPressed(true);
            } else if (event.getCode() == KeyCode.UP || event.getCode() == KeyCode.DOWN) {
                GameController.getInstance().racketRightController.setKeyPressed(true);
            }

            switch (event.getCode()) {
                case Q:
                    GameController.getInstance().racketLeftController.setRacketKeyCode(event.getCode());
                    break;
                case W:
                    GameController.getInstance().racketLeftController.setRacketKeyCode(event.getCode());
                    break;
                case UP:
                    GameController.getInstance().racketRightController.setRacketKeyCode(event.getCode());
                    break;
                case DOWN:
                    GameController.getInstance().racketRightController.setRacketKeyCode(event.getCode());
                    break;
            }

        });
        this.setOnKeyReleased(event -> {
            // Check which key is pressed for which racket (Left or Right)
            if (event.getCode() == KeyCode.Q || event.getCode() == KeyCode.W) {
                GameController.getInstance().racketLeftController.setKeyPressed(false);
            } else if (event.getCode() == KeyCode.UP || event.getCode() == KeyCode.DOWN) {
                GameController.getInstance().racketRightController.setKeyPressed(false);
            }
        });
    }
}
