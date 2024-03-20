package pingPongGame.view.components;

import javafx.scene.shape.Rectangle;
import pingPongGame.controller.components.RacketController;
import javafx.geometry.Pos;
import javafx.scene.layout.VBox;

/**
 * The visual representation of a racket in the game.
 * 
 * @author Quentin Macheda
 * @version 1.4
 * @since 2024-03-09
 */
public class RacketView extends VBox {
    /**
     * The RacketController associated with the RacketView.
     */
    private RacketController racketController;

    /**
     * The height of the parent container (used for positioning the racket).
     */
    private double parentRacketHeight;

    /**
     * Rectangle representing the racket
     */
    public Rectangle racket;

    /**
     * Constructs a new RacketView with the associated RacketController.
     */
    public RacketView() {
        // Set the racket controller
        racketController = new RacketController();

        // Create the rectangle representing the racket
        this.racket = new Rectangle(racketController.getWidth(), racketController.getHeight());
        this.racket.getStyleClass().addAll("racket");

        // Add the racket to the VBox
        this.getChildren().add(this.racket);

        // Set the alignment of the VBox
        this.setAlignment(Pos.CENTER);
    }

    /**
     * Gets the height of the parent container.
     *
     * @return The height of the parent container.
     */
    public double getParentHeight() {
        return this.parentRacketHeight;
    }

    /**
     * Updates the size of the racket.
     *
     * @param newWidth  The new width of the racket.
     * @param newHeight The new height of the racket.
     */
    public void updateSize(double newWidth, double newHeight) {
        // Update the size of the racket rectangle
        this.racket.setWidth(newWidth);
        this.racket.setHeight(newHeight);
    }

    /**
     * Sets the y-position of the racket.
     *
     * @param newPosition The new y-position of the racket.
     */
    public void setPosY(double newPosition) {
        // Set the y-position of the racket rectangle
        this.racket.setTranslateY(newPosition);
    }
}
