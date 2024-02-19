package src.controller.components;

import src.model.components.BallModel;
import src.view.components.BallView;

public class BallController {
    private BallModel ballModel;
    private BallView ballView;

    public BallController() {
        ballModel = new BallModel();
    }

    public void initView() {
        ballView = new BallView();
    }

    public BallView getView() {
        return ballView;
    }

    public int getRadius() {
        return ballModel.getRadius();
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
}
