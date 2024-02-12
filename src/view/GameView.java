package src.view;

import javafx.scene.layout.BorderPane;
import src.controller.GameController;
import src.controller.TopBarController;
import src.view.gameComponents.BallView;
import src.view.gameComponents.RacketView;

public class GameView extends BorderPane {
    public GameController gameController;
    public WelcomeView welcomeView;
    public RacketView racketLeftView;
    public RacketView racketRightView;
    public BallView ballView;
    public TopBarController topBarController;

    // Constructor
    public GameView() {
        // Set the background color
        this.setStyle("-fx-background-color: #1B1B1E");

        // Create game controller and welcome view
        gameController = new GameController(this);
        welcomeView = new WelcomeView(this);
        topBarController = new TopBarController(this);
    }

    public void setGameComponents() {
        // Create game components
        racketLeftView = new RacketView(20, 100, "Left", this);
        racketRightView = new RacketView(20, 100, "Right", this);
        ballView = new BallView(20, this);
    }

    public void displayGameComponents(boolean state) {
        // Display game components
        racketLeftView.setVisible(state);
        racketRightView.setVisible(state);
        ballView.setVisible(state);
    }
}
