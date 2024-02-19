package src.view.components;

import javafx.scene.shape.Rectangle;
import src.controller.components.RacketController;
import javafx.geometry.Pos;
import javafx.scene.layout.VBox;

public class RacketView extends VBox {
    private RacketController racketController;
    public Rectangle racket;

    public RacketView() {
        racketController = new RacketController();

        this.racket = new Rectangle(racketController.getWidth(), racketController.getHeight());
        this.racket.getStyleClass().addAll("racket");

        this.getChildren().add(racket); // Add racket to VBox
        this.setAlignment(Pos.CENTER); // Set Alignment to Center
    }

    public void updateSize(double newWidth, double newHeight) {
        this.racket.setWidth(newWidth);
        this.racket.setHeight(newHeight);
    }
}
