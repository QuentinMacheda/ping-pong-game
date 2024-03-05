package src.controller.components;

import javafx.geometry.Bounds;
import src.controller.MainController;
import src.model.components.BallModel;
import src.view.components.BallView;

public class BallController implements Runnable {
    private BallModel ballModel;
    private BallView ballView;
    private Thread ballThread;
    private boolean isKeyPressed;

    public BallController() {
        ballModel = new BallModel();

        ballThread = new Thread(this);
        ballThread.setName("Ball Thread");
        ballThread.setDaemon(true);
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

    public Bounds getBounds() {
        return ballModel.getBounds();
    }

    public double getPosX() {
        return ballModel.getPosX();
    }

    public double getPosY() {
        return ballModel.getPosY();
    }

    public boolean getKeyPressed() {
        return isKeyPressed;
    }

    public void setKeyPressed(boolean status) {
        isKeyPressed = status;
    }

    public void reset() {
        this.setKeyPressed(false);
        ballModel.reset();
        ballView.reset();
    }

    public void move() {
        ballModel.move();
        ballView.setPosX(this.getPosX());
        ballView.setPosY(this.getPosY());
    }

    public void startThread() {
        if (!ballThread.isAlive()) {
            ballThread.start();
        }
    }

    // Thread
    public void run() {
        while (true) {
            try {
                Thread.sleep(10);

                if (MainController.getInstance().getMainState() == MainController.MainState.RUNNING) {
                    if (isKeyPressed) {
                        this.move();
                    }
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
