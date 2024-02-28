package src.model.components;

public class BallModel {
    private int x, y, radius;
    private int ballSpeed;
    private int ballSpeedIR;

    public BallModel() {
        this.x = 0;
        this.y = 0;
        this.radius = 14;

        setSpeed("slow");
        setSpeedIR("slow");
    }

    public int getRadius() {
        return this.radius;
    }

    public String getSpeed() {
        if (ballSpeed == 1) {
            return "slow";
        } else if (ballSpeed == 2) {
            return "normal";
        } else if (ballSpeed == 3) {
            return "fast";
        } else {
            return "normal";
        }
    }

    public void setSpeed(String newSpeed) {
        switch (newSpeed) {
            case "slow":
                ballSpeed = 1;
                break;
            case "normal":
                ballSpeed = 2;
                break;
            case "fast":
                ballSpeed = 3;
                break;
            default:
                ballSpeed = 1;
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

    public void move() {
        this.x += ballSpeed;
        this.y += ballSpeed;
    }
}
