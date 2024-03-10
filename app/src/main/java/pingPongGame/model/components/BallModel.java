package pingPongGame.model.components;

import javafx.geometry.BoundingBox;
import javafx.geometry.Bounds;
import pingPongGame.controller.GameController;
import pingPongGame.model.GameModel;

/**
 * Model representing the properties and behavior of the game ball.
 * 
 * @author Quentin Macheda
 * @version 1.4
 * @since 2024-03-09
 */
public class BallModel {
    /*
     * Position coordinates of the ball
     */
    private int x, y;

    /*
     * Radius of the ball
     */
    private int radius;

    /*
     * Bounding box representing the bounds of the ball
     */
    private Bounds bounds;

    /*
     * Speed in the X and Y directions & Speed increase rate
     */
    private int ballSpeedX, ballSpeedY, ballSpeedIR;

    /*
     * State of the ball collision
     */
    private boolean collisionState;

    /**
     * Constructor to initialize the ball model with default values.
     */
    public BallModel() {
        this.x = 0;
        this.y = 0;
        this.radius = 14;
        this.bounds = new BoundingBox(this.x - this.radius, this.y - this.radius, getBallSize(), getBallSize());

        setSpeed("normal");
        setSpeedIR("normal");

        this.collisionState = false;
    }

    /**
     * Gets the radius of the ball.
     *
     * @return The radius of the ball.
     */
    public int getRadius() {
        return this.radius;
    }

    /**
     * Gets the bounding box representing the bounds of the ball.
     *
     * @return The bounds of the ball.
     */
    public Bounds getBounds() {
        return this.bounds;
    }

    /**
     * Sets the bounds of the ball to a new bounding box.
     *
     * @param newBounds The new bounds of the ball.
     */
    public void setBounds(Bounds newBounds) {
        this.bounds = newBounds;
    }

    /**
     * Gets the size of the ball.
     *
     * @return The size of the ball.
     */
    public double getBallSize() {
        return getRadius() * 2;
    }

    /**
     * Gets the speed category of the ball (slow, normal, or fast).
     *
     * @return The speed category of the ball.
     */
    public String getSpeed() {
        // Determine the speed category based on ball speeds in X and Y directions
        if ((ballSpeedY == 2 || ballSpeedY == -2) && (ballSpeedX == 2 || ballSpeedX == -2)) {
            return "slow";
        } else if ((ballSpeedY == 4 || ballSpeedY == -4) && (ballSpeedX == 4 || ballSpeedX == -4)) {
            return "normal";
        } else if ((ballSpeedY == 6 || ballSpeedY == -6) && (ballSpeedX == 6 || ballSpeedX == -6)) {
            return "fast";
        } else {
            return "normal";
        }
    }

    /**
     * Sets the speed of the ball based on a speed category.
     *
     * @param newSpeed The new speed category of the ball.
     */
    public void setSpeed(String newSpeed) {
        // Set ball speeds based on the specified speed category
        switch (newSpeed) {
            case "slow":
                ballSpeedY = 2;
                ballSpeedX = 2;
                break;
            case "normal":
                ballSpeedY = 4;
                ballSpeedX = 4;
                break;
            case "fast":
                ballSpeedY = 6;
                ballSpeedX = 6;
                break;
            default:
                ballSpeedY = 2;
                ballSpeedX = 2;
                break;
        }
    }

    /**
     * Gets the speed increase rate category of the ball (slow, normal, or fast).
     *
     * @return The speed increase rate category of the ball.
     */
    public String getSpeedIR() {
        // Determine the speed increase rate category based on the ball speed increase
        // rate
        if (ballSpeedIR == 1) {
            return "slow";
        } else if (ballSpeedIR == 2) {
            return "normal";
        } else if (ballSpeedIR == 3) {
            return "fast";
        } else {
            return "normal";
        }
    }

    /**
     * Sets the speed increase rate of the ball based on a speed increase rate
     * category.
     *
     * @param newSpeedIR The new speed increase rate category of the ball.
     */
    public void setSpeedIR(String newSpeedIR) {
        // Set ball speed increase rate based on the specified speed increase rate
        // category
        switch (newSpeedIR) {
            case "slow":
                ballSpeedIR = 1;
                break;
            case "normal":
                ballSpeedIR = 2;
                break;
            case "fast":
                ballSpeedIR = 3;
                break;
            default:
                ballSpeedIR = 2;
                break;
        }
    }

    /**
     * Gets the X-coordinate of the ball's position.
     *
     * @return The X-coordinate of the ball's position.
     */
    public double getPosX() {
        return this.x;
    }

    /**
     * Gets the Y-coordinate of the ball's position.
     *
     * @return The Y-coordinate of the ball's position.
     */
    public double getPosY() {
        return this.y;
    }

    /**
     * Resets the ball to its default position and speed values.
     */
    public void reset() {
        this.x = 0;
        this.y = 0;
    }

    /**
     * Moves the ball, handling collisions and updating its position.
     */
    public void move() {
        handleWallCollisions();
        handleRacketCollisions();
        handleSideWallCollisions();
        moveBall();
    }

    /**
     * Handles collisions with the top and bottom walls of the game area.
     */
    public void handleWallCollisions() {
        double gameAreaHeight = GameModel.getInstance().getGameAreaHeight();

        // Check for collisions with the top and bottom walls
        if (this.y < -(gameAreaHeight / 2 - (getBallSize() / 2)) || this.y > gameAreaHeight / 2 - (getBallSize() / 2)) {
            ballSpeedY = -ballSpeedY;
            GameController.getInstance().playWallBounceSound();
        }
    }

    /**
     * Handles collisions with the rackets.
     */
    public void handleRacketCollisions() {
        // Check for collisions with the rackets
        if (!this.collisionState) {
            if (GameController.getInstance().ballController.getBounds()
                    .intersects(GameController.getInstance().racketRightController.getBounds())
                    || GameController.getInstance().ballController.getBounds()
                            .intersects(GameController.getInstance().racketLeftController.getBounds())) {
                ballSpeedX = -ballSpeedX;
                this.collisionState = true;
                GameController.getInstance().playRacketBounceSound();
            }
        } else {
            if (!GameController.getInstance().ballController.getBounds()
                    .intersects(GameController.getInstance().racketRightController.getBounds())
                    && !GameController.getInstance().ballController.getBounds()
                            .intersects(GameController.getInstance().racketLeftController.getBounds())) {
                this.collisionState = false;
            }
        }
    }

    /**
     * Handles collisions with the left and right walls of the game area.
     */
    public void handleSideWallCollisions() {
        double gameAreaWidth = GameModel.getInstance().getGameAreaWidth();

        // Check for collisions with the left and right walls
        if (this.x < -(gameAreaWidth / 2 - (getBallSize() / 2))) {
            GameController.getInstance().score(PlayerModel.PlayerSide.LEFT);
        } else if (this.x > gameAreaWidth / 2 - (getBallSize() / 2)) {
            GameController.getInstance().score(PlayerModel.PlayerSide.RIGHT);
        }
    }

    /**
     * Moves the ball to the next position while there are no collisions.
     */
    public void moveBall() {
        this.x += ballSpeedX;
        this.y += ballSpeedY;
        this.setBounds(new BoundingBox(this.x - this.radius, this.y - this.radius, getBallSize(), getBallSize()));
    }
}
