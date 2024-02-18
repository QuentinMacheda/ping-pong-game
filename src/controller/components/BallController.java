package src.controller.components;

import src.model.components.BallModel;
import src.view.components.BallView;

public class BallController {
    public BallModel ballModel;
    public BallView ballView;

    public BallController(int radius) {
        ballModel = new BallModel(radius);
        ballView = new BallView(radius);
    }

    public String getSpeed() {
        return ballModel.getSpeed();
    }

    public void setSpeed(String newSpeed) {
        ballModel.setSpeed(newSpeed);
    }

    public String getSpeedIR() {
        return ballModel.getSpeedIR();
    }

    public void setSpeedIR(String newSpeedIR) {
        ballModel.setSpeedIR(newSpeedIR);
    }

    public BallView getView() {
        return ballView;
    }
}
