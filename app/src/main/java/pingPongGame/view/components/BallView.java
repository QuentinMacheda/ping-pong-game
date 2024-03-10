package pingPongGame.view.components;

import javafx.scene.shape.Circle;
import pingPongGame.controller.components.BallController;

/**
 * The visual representation of the game ball.
 * 
 * @author Quentin Macheda
 * @version 1.4
 * @since 2024-03-09
 */
public class BallView extends Circle {
    /**
     * The controller responsible for controlling the behavior of the ball in the
     * game.
     */
    private BallController ballController;

    /**
     * Constructs a new BallView and initializes its controller.
     */
    public BallView() {
        // Initialize the ball controller
        ballController = new BallController();

        // Set the radius and style class for the ball
        this.setRadius(ballController.getRadius());
        this.getStyleClass().addAll("ball");
    }

    /**
     * Sets the Y-coordinate of the ball.
     *
     * @param posY The new Y-coordinate of the ball.
     */
    public void setPosY(double posY) {
        this.setTranslateY(posY);
    }

    /**
     * Sets the X-coordinate of the ball.
     *
     * @param posX The new X-coordinate of the ball.
     */
    public void setPosX(double posX) {
        this.setTranslateX(posX);
    }

    /**
     * Resets the position of the ball to its initial coordinates.
     */
    public void reset() {
        // Set the position of the ball to its initial coordinates
        this.setPosX(ballController.getPosX());
        this.setPosY(ballController.getPosY());
    }
}
