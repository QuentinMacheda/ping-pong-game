package pingPongGame.controller.components;

import javafx.application.Platform;
import javafx.geometry.Bounds;
import javafx.scene.input.KeyCode;
import pingPongGame.controller.MainController;
import pingPongGame.model.components.RacketModel;
import pingPongGame.view.components.RacketView;

public class RacketController implements Runnable {
    private RacketModel racketModel;
    private RacketView racketView;
    public Thread racketThread;
    public KeyCode racketKeyCode;
    public boolean isKeyPressed;

    public RacketController() {
        racketModel = new RacketModel();

        racketThread = new Thread(this);
        racketThread.setName("Racket Thread");
        racketThread.setDaemon(true);
        racketThread.start();
    }

    public void initView() {
        racketView = new RacketView();

        // Get the racket container height and width
        racketView.heightProperty().addListener((observable, oldValue, newValue) -> {
            this.setParentHeight(newValue.doubleValue());
        });
        racketView.widthProperty().addListener((observable, oldValue, newValue) -> {
            this.setParentWidth(newValue.doubleValue());
        });
    }

    public RacketView getView() {
        return racketView;
    }

    public double getParentHeight() {
        return racketModel.getParentHeight();
    }

    public void setParentHeight(double newParentHeight) {
        racketModel.setParentHeight(newParentHeight);
    }

    public double getParentWidth() {
        return racketModel.getParentWidth();
    }

    public void setParentWidth(double newParentWidth) {
        racketModel.setParentWidth(newParentWidth);
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

    public Bounds getBounds() {
        return racketModel.getBounds();
    }

    public double getPosX() {
        return racketModel.getPosX();
    }

    public void setPosX(double newX) {
        racketModel.setPosX(newX);
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

    public void reset() {
        racketModel.reset();
        racketView.setPosY(racketModel.getPosY());
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

                if (MainController.getInstance().getMainState() == MainController.MainState.RUNNING) {
                    if (isKeyPressed) {
                        Platform.runLater(() -> {
                            if (getRacketKeyCode() == KeyCode.UP || getRacketKeyCode() == KeyCode.Q) {
                                moveUp();
                            } else if (getRacketKeyCode() == KeyCode.W || getRacketKeyCode() == KeyCode.DOWN) {
                                moveDown();
                            }
                        });
                    }
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}