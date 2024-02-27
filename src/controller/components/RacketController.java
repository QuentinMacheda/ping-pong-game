package src.controller.components;

import javafx.scene.input.KeyCode;
import src.model.components.RacketModel;
import src.view.components.RacketView;

public class RacketController implements Runnable {
    private RacketModel racketModel;
    private RacketView racketView;
    public Thread racketThread;
    public KeyCode racketKeyCode;
    public boolean isKeyPressed;

    public RacketController() {
        racketModel = new RacketModel();
        racketThread = new Thread(this);
        racketThread.setDaemon(true);
        racketThread.start();
    }

    public void initView() {
        racketView = new RacketView();

        // Set the racket position when height's ready
        racketView.heightProperty().addListener((observable, oldValue, newValue) -> {
            // Get the center position
            this.setParentHeight(newValue.doubleValue());
            Double racketCenterPos = this.getParentHeight() / 2 - this.getHeight() / 2;

            // Set racket position
            racketModel.setPosY(racketCenterPos);
            racketView.setPosY(racketCenterPos);
        });
    }

    public double getParentHeight() {
        return racketModel.getParentHeight();
    }

    public void setParentHeight(double newParentHeight) {
        racketModel.setParentHeight(newParentHeight);
    }

    public RacketView getView() {
        return racketView;
    }

    public double getWidth() {
        return racketModel.getWidth();
    }

    public double getHeight() {
        return racketModel.getHeight();
    }

    public void updateSize(double newWidth, double newHeight) {
        racketModel.updateSize(newWidth, newHeight);
        racketView.updateSize(this.getWidth(), this.getHeight());
    }

    public double getPosY() {
        return racketModel.getPosY();
    }

    public KeyCode getRacketKeyCode() {
        return racketKeyCode;
    }

    public void setRacketKeyCode(KeyCode newRacketKeyCode) {
        racketKeyCode = newRacketKeyCode;
    }

    public void setKeyPressed(boolean status) {
        isKeyPressed = status;
    }

    public void moveUp() {
        racketModel.moveUp();
        racketView.setPosY(this.getPosY());
    }

    public void moveDown() {
        racketModel.moveDown(this.getParentHeight());
        racketView.setPosY(this.getPosY());
    }

    // Thread
    public void run() {
        while (true) {
            try {
                Thread.sleep(8);

                if (isKeyPressed) {
                    if (getRacketKeyCode() == KeyCode.UP || getRacketKeyCode() == KeyCode.Q) {
                        moveUp();
                    } else if (getRacketKeyCode() == KeyCode.W || getRacketKeyCode() == KeyCode.DOWN) {
                        moveDown();
                    }
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
