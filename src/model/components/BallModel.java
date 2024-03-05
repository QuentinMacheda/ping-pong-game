package src.model.components;

import javafx.geometry.BoundingBox;
import javafx.geometry.Bounds;
import src.controller.GameController;
import src.model.GameModel;

public class BallModel {
    private int x, y, radius;
    private Bounds bounds;
    private int ballSpeedY, ballSpeedX;
    private int ballSpeedIR;
    private boolean collisionState;

    public BallModel() {
        this.x = 0;
        this.y = 0;
        this.radius = 14;
        this.bounds = new BoundingBox(this.x - this.radius, this.y - this.radius, getBallSize(), getBallSize());

        setSpeed("normal");
        setSpeedIR("normal");

        this.collisionState = false;
    }

    public int getRadius() {
        return this.radius;
    }

    public Bounds getBounds() {
        return this.bounds;
    }

    public void setBounds(Bounds newBounds) {
        this.bounds = newBounds;
    }

    public double getBallSize() {
        return getRadius() * 2;
    }

    public String getSpeed() {
        if (ballSpeedY == 2 && ballSpeedX == 2) {
            return "slow";
        } else if (ballSpeedY == 4 && ballSpeedX == 4) {
            return "normal";
        } else if (ballSpeedY == 6 && ballSpeedX == 6) {
            return "fast";
        } else {
            return "normal";
        }
    }

    public void setSpeed(String newSpeed) {
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

    public String getSpeedIR() {
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

    public void setSpeedIR(String newSpeedIR) {
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

    public double getPosX() {
        return this.x;
    }

    public double getPosY() {
        return this.y;
    }

    public void reset() {
        this.x = 0;
        this.y = 0;
        setSpeed("normal");
        setSpeedIR("normal");
    }

    public void move() {
        double gameAreaHeight = GameModel.getInstance().getGameAreaHeight();
        double gameAreaWidth = GameModel.getInstance().getGameAreaWidth();

        /*
         * Handle collisions with the top and bottom walls
         */
        if (this.y < -(gameAreaHeight / 2 - (getBallSize() / 2)) || this.y > gameAreaHeight / 2 - (getBallSize() / 2)) {
            ballSpeedY = -ballSpeedY;
        }

        /*
         * Handle collisions with the rackets
         */
        if (!this.collisionState) {
            if (GameController.getInstance().ballController.getBounds()
                    .intersects(GameController.getInstance().racketRightController.getBounds())
                    || GameController.getInstance().ballController.getBounds()
                            .intersects(GameController.getInstance().racketLeftController.getBounds())) {
                ballSpeedX = -ballSpeedX;
                this.collisionState = true; // Set collision state to true
            }
        } else {
            // Add logic to wait until the ball is no longer in the collision state
            if (!GameController.getInstance().ballController.getBounds()
                    .intersects(GameController.getInstance().racketRightController.getBounds())
                    && !GameController.getInstance().ballController.getBounds()
                            .intersects(GameController.getInstance().racketLeftController.getBounds())) {
                this.collisionState = false; // Reset collision state
            }
        }

        /*
         * Handle collisions with the left and right walls
         */
        if (this.x < -(gameAreaWidth / 2 - (getBallSize() / 2))) {
            GameController.getInstance().score("left");
        } else if (this.x > gameAreaWidth / 2 - (getBallSize() / 2)) {
            GameController.getInstance().score("right");
        }

        /*
         * Move the ball while there are no collisions
         */
        this.x += ballSpeedX;
        this.y += ballSpeedY;
        this.setBounds(new BoundingBox(this.x - this.radius, this.y - this.radius, getBallSize(), getBallSize()));
    }
}
