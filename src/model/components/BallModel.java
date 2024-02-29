package src.model.components;

import src.controller.GameController;
import src.model.GameModel;

public class BallModel {
    private int x, y, radius;
    private int ballSpeedY, ballSpeedX;
    private int ballSpeedIR;

    public BallModel() {
        this.x = 0;
        this.y = 0;
        this.radius = 14;

        setSpeed("normal");
        setSpeedIR("normal");
    }

    public int getRadius() {
        return this.radius;
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
         * Handle collisions with the left and right walls
         */
        if (this.x < -(gameAreaWidth / 2 - (getBallSize() / 2))) {
            GameController.getInstance().score("left");
        } else if (this.x > gameAreaWidth / 2 - (getBallSize() / 2)) {
            GameController.getInstance().score("right");
        }

        this.x += ballSpeedX;
        this.y += ballSpeedY;
    }
}
