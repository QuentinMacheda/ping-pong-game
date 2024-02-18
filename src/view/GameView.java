package src.view;

import javafx.geometry.Insets;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
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
        VBox.setMargin(racketLeftView.racket, new Insets(0, 0, 0, 50));
        VBox.setMargin(racketRightView.racket, new Insets(0, 50, 0, 0));
        this.setLeft(racketLeftView);
        this.setRight(racketRightView);

        // Set Ball
        ballView = new BallView(20, this);

        // Bottom Balance
        VBox bottom = new VBox();
        bottom.setMinHeight(80);
        this.setBottom(bottom);
    }
}
