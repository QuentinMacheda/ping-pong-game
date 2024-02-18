package src.model.components;

public class BallModel {
    private int radius;
    private int ballSpeed;
    private int ballSpeedIR;

    public BallModel(int radius) {
        this.radius = radius;
        setSpeed("normal");
        setSpeedIR("normal");
    }

    public String getSpeed() {
        if (ballSpeed == 10) {
            return "slow";
        } else if (ballSpeed == 15) {
            return "normal";
        } else if (ballSpeed == 20) {
            return "fast";
        } else {
            return "normal";
        }
    }

    public void setSpeed(String newSpeed) {
        switch (newSpeed) {
            case "slow":
                ballSpeed = 10;
                break;
            case "normal":
                ballSpeed = 15;
                break;
            case "fast":
                ballSpeed = 20;
                break;
            default:
                ballSpeed = 15;
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
}