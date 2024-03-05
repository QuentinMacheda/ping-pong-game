package src.view.components;

import javafx.scene.shape.Circle;
import src.controller.components.BallController;

public class BallView extends Circle {
    private BallController ballController;

    public BallView() {
        ballController = new BallController();

        this.setRadius(ballController.getRadius());
        this.getStyleClass().addAll("ball");
    }

    public void setPosY(double posY) {
        this.setTranslateY(posY);
    }

    public void setPosX(double posX) {
        this.setTranslateX(posX);
    }

    public void reset() {
        this.setPosX(ballController.getPosX());
        this.setPosY(ballController.getPosY());
    }
}