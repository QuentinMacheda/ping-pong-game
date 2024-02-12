package src.view.gameComponents;

import javafx.scene.shape.Rectangle;
import src.view.GameView;
import javafx.scene.paint.Color;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.VBox;

public class RacketView extends VBox {
    public GameView gameView;
    private Rectangle racket;

    public RacketView(int width, int height, String side, GameView gameView) {
        racket = new Rectangle(width, height);
        racket.setFill(Color.web("#FF910A"));

        this.getChildren().add(racket); // Add racket to VBox
        this.setAlignment(Pos.CENTER); // Set Alignment to Center

        if (side == "Left") {
            VBox.setMargin(racket, new Insets(0, 0, 0, 50)); // Set Margin
            gameView.setLeft(this);
        } else if (side == "Right") {
            VBox.setMargin(racket, new Insets(0, 50, 0, 0)); // Set Margin
            gameView.setRight(this);
        }
    }
}
