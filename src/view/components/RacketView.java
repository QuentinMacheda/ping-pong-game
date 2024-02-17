package src.view.components;

import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;
import javafx.geometry.Pos;
import javafx.scene.layout.VBox;

public class RacketView extends VBox {
    public Rectangle racket;

    public RacketView(int width, int height) {
        this.racket = new Rectangle(width, height);
        this.racket.setFill(Color.web("#FF910A"));

        this.getChildren().add(racket); // Add racket to VBox
        this.setAlignment(Pos.CENTER); // Set Alignment to Center
    }
}
