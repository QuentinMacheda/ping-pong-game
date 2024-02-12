package src.view.components;

import javafx.scene.shape.Circle;
import src.view.GameView;
import javafx.scene.paint.Color;

public class BallView {
    public GameView gameView;
    private Circle ball;

    public BallView(int radius, GameView gameView) {
        ball = new Circle(radius);
        ball.setFill(Color.web("#B0413E"));

        gameView.setCenter(ball);
    }

    public void setVisible(boolean visible) {
        ball.setVisible(visible);
    }
}