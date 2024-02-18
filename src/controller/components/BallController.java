package src.controller.components;

import src.view.components.BallView;

public class BallController {
    public BallView ballView;
    public int ballSpeed;

    public BallController(int radius) {
        ballView = new BallView(16);
        setSpeed("normal");
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

    public BallView getView() {
        return ballView;
    }
}
