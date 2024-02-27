package src.view.components;

import javafx.scene.shape.Rectangle;
import src.controller.components.RacketController;
import javafx.scene.layout.AnchorPane;

public class RacketView extends AnchorPane {
    private RacketController racketController;
    private double parentRacketHeight;
    public Rectangle racket;

    public RacketView() {
        racketController = new RacketController();

        this.racket = new Rectangle(racketController.getWidth(), racketController.getHeight());
        this.racket.getStyleClass().addAll("racket");

        this.getChildren().add(this.racket); // Add racket to AnchorPane
    }

    public double getParentHeight() {
        return this.parentRacketHeight;
    }

    public void updateSize(double newWidth, double newHeight) {
        this.racket.setWidth(newWidth);
        this.racket.setHeight(newHeight);
    }

    public void setPosY(double newPosition) {
        AnchorPane.setTopAnchor(this.racket, newPosition);
    }
}
