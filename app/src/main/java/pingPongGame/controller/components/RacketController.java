package pingPongGame.controller.components;

import javafx.application.Platform;
import javafx.geometry.Bounds;
import javafx.scene.input.KeyCode;
import pingPongGame.controller.MainController;
import pingPongGame.model.components.RacketModel;
import pingPongGame.view.components.RacketView;

/**
 * The RacketController class manages the behavior of the rackets in the game.
 * 
 * @author Quentin Macheda
 * @version 1.4
 * @since 2024-03-09
 */
public class RacketController implements Runnable {

    /**
     * The model of the racket.
     */
    private RacketModel racketModel;

    /**
     * The view of the racket.
     */
    private RacketView racketView;

    /**
     * The thread of the racket.
     */
    public Thread racketThread;

    /**
     * The key code of the racket.
     */
    public KeyCode racketKeyCode;

    /**
     * The status of the key pressed.
     */
    public boolean isKeyPressed;

    /**
     * Constructs a new RacketController with the associated RacketModel.
     */
    public RacketController() {
        racketModel = new RacketModel();

        racketThread = new Thread(this);
        racketThread.setName("Racket Thread");
        racketThread.setDaemon(true);
        racketThread.start();
    }

    /**
     * Initializes the racket view.
     */
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

    /**
     * Gets the view of the racket.
     *
     * @return The view of the racket.
     */
    public RacketView getView() {
        return racketView;
    }

    /**
     * Gets the height of the parent container.
     *
     * @return The height of the parent container.
     */
    public double getParentHeight() {
        return racketModel.getParentHeight();
    }

    /**
     * Sets the height of the parent container.
     *
     * @param newParentHeight The new height of the parent container.
     */
    public void setParentHeight(double newParentHeight) {
        racketModel.setParentHeight(newParentHeight);
    }

    /**
     * Gets the width of the parent container.
     *
     * @return The width of the parent container.
     */
    public double getParentWidth() {
        // Width of the racket is the same as the parent container
        return racketModel.getWidth();
    }

    /**
     * Sets the width of the parent container.
     *
     * @param newParentWidth The new width of the parent container.
     */
    public void setParentWidth(double newParentWidth) {
        // Width of the racket is the same as the parent container
        racketModel.setWidth(newParentWidth);
    }

    /**
     * Gets the width of the racket.
     *
     * @return The width of the racket.
     */
    public double getWidth() {
        return racketModel.getWidth();
    }

    /**
     * Gets the height of the racket.
     *
     * @return The height of the racket.
     */
    public double getHeight() {
        return racketModel.getHeight();
    }

    /**
     * Updates the size of the racket.
     *
     * @param newWidth  The new width of the racket.
     * @param newHeight The new height of the racket.
     */
    public void updateSize(double newWidth, double newHeight) {
        racketModel.updateSize(newWidth, newHeight);
        racketView.updateSize(this.getWidth(), this.getHeight());
    }

    /**
     * Gets the bounds of the racket.
     *
     * @return The bounds of the racket.
     */
    public Bounds getBounds() {
        return racketModel.getBounds();
    }

    /**
     * Gets the x-position of the racket.
     *
     * @return The x-position of the racket.
     */
    public double getPosX() {
        return racketModel.getPosX();
    }

    /**
     * Sets the x-position of the racket.
     *
     * @param newX The new x-position of the racket.
     */
    public void setPosX(double newX) {
        racketModel.setPosX(newX);
    }

    /**
     * Gets the y-position of the racket.
     *
     * @return The y-position of the racket.
     */
    public double getPosY() {
        return racketModel.getPosY();
    }

    /**
     * Gets the racket key code.
     *
     * @return The racket key code.
     */
    public KeyCode getRacketKeyCode() {
        return racketKeyCode;
    }

    /**
     * Sets the racket key code.
     *
     * @param newRacketKeyCode The new racket key code.
     */
    public void setRacketKeyCode(KeyCode newRacketKeyCode) {
        racketKeyCode = newRacketKeyCode;
    }

    /**
     * Set the key pressed status.
     * 
     * @param status The new key pressed status.
     */
    public void setKeyPressed(boolean status) {
        isKeyPressed = status;
    }

    /**
     * Resets the racket to its initial position.
     */
    public void reset() {
        racketModel.reset();
        racketView.setPosY(racketModel.getPosY());
    }

    /**
     * Moves the racket up.
     */
    public void moveUp() {
        racketModel.moveUp();
        racketView.setPosY(this.getPosY());
    }

    /**
     * Moves the racket down.
     */
    public void moveDown() {
        racketModel.moveDown(this.getParentHeight());
        racketView.setPosY(this.getPosY());
    }

    /**
     * The run method of the racket thread.
     */
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
