package src.view.components;

import javafx.scene.shape.Rectangle;
import javafx.geometry.Pos;
import javafx.scene.layout.VBox;

public class RacketView extends VBox {
    public Rectangle racket;

    public RacketView(double width, double height) {
        this.racket = new Rectangle(width, height);
        this.racket.getStyleClass().addAll("racket");

        this.getChildren().add(racket); // Add racket to VBox
        this.setAlignment(Pos.CENTER); // Set Alignment to Center
    }

    public void updateSize(double newWidth, double newHeight) {
        this.racket.setWidth(newWidth);
        this.racket.setHeight(newHeight);
    }
}
