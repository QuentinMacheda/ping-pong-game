package src.view.components;

import javafx.scene.shape.Circle;

public class BallView extends Circle {
    public BallView(int radius) {
        this.setRadius(radius);
        this.getStyleClass().addAll("ball");
    }
}