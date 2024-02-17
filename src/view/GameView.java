package src.view;

import javafx.scene.layout.BorderPane;
import src.view.components.BallView;
import src.view.components.RacketView;
import src.controller.layout.TopBarController;

public class GameView extends BorderPane {
    public RacketView racketLeftView;
    public RacketView racketRightView;
    public BallView ballView;

    // Constructor
    public GameView() {
        // Set Top Bar
        this.setTop(TopBarController.getInstance().getView());

        // Set Game Components
        racketLeftView = new RacketView(20, 100, "Left", this);
        racketRightView = new RacketView(20, 100, "Right", this);
        ballView = new BallView(20, this);
    }
}
