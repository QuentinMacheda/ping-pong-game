package src.view;

import javafx.scene.layout.BorderPane;
import src.controller.GameController;
import src.controller.layout.TopBarController;
import src.view.components.BallView;
import src.view.components.RacketView;

public class GameView extends BorderPane {
    public MainView mainView;
    public GameController gameController;
    public RacketView racketLeftView;
    public RacketView racketRightView;
    public BallView ballView;
    public TopBarController topBarController;

    // Constructor
    public GameView(MainView mainView) {
        // Set Top Bar
        topBarController = new TopBarController(mainView);
        this.setTop(topBarController.topBarView);

        // Set Game Components
        racketLeftView = new RacketView(20, 100, "Left", this);
        racketRightView = new RacketView(20, 100, "Right", this);
        ballView = new BallView(20, this);
    }
}
