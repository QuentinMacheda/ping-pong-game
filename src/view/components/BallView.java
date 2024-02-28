package src.view.components;

import javafx.scene.shape.Circle;
import src.controller.components.BallController;

public class BallView extends Circle {
    private BallController ballController;

    public BallView() {
        ballController = new BallController();

        this.setRadius(ballController.getRadius());
        this.getStyleClass().addAll("ball");

        // Set translation
        this.setTranslateX(500);
        this.setTranslateY(0);
    }
}