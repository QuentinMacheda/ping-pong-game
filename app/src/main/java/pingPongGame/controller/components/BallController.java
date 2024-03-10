package pingPongGame.controller.components;

import javafx.application.Platform;
import javafx.geometry.Bounds;
import pingPongGame.controller.MainController;
import pingPongGame.model.components.BallModel;
import pingPongGame.view.components.BallView;

/**
 * The BallController class manages the ball logic in the game.
 * It implements the Runnable interface for multi-threading.
 */
public class BallController implements Runnable {

    /**
     * The BallModel instance associated with the BallController.
     */
    private BallModel ballModel;

    /**
     * The BallView instance associated with the BallController.
     */
    private BallView ballView;

    /**
     * The thread responsible for running the ball movement logic.
     */
    private Thread ballThread;

    /**
     * A flag indicating whether a key is pressed.
     */
    private boolean isKeyPressed;

    /**
     * Constructs a new BallController with a new BallModel instance.
     */
    public BallController() {
        ballModel = new BallModel();

        ballThread = new Thread(this);
        ballThread.setName("Ball Thread");
        ballThread.setDaemon(true);
    }

    /**
     * Initializes the BallView associated with the BallController.
     */
    public void initView() {
        ballView = new BallView();
    }

    /**
     * Gets the BallView associated with the BallController.
     *
     * @return The BallView instance.
     */
    public BallView getView() {
        return ballView;
    }

    /**
     * Gets the radius of the ball.
     *
     * @return The radius of the ball.
     */
    public int getRadius() {
        return ballModel.getRadius();
    }

    /**
     * Gets the current speed of the ball.
     *
     * @return The current speed of the ball.
     */
    public String getSpeed() {
        return ballModel.getSpeed();
    }

    /**
     * Sets the speed of the ball.
     *
     * @param newSpeed The new speed for the ball.
     */
    public void setSpeed(String newSpeed) {
        ballModel.setSpeed(newSpeed);
    }

    /**
     * Gets the current speed of the ball in the opposite direction.
     *
     * @return The current speed of the ball in the opposite direction.
     */
    public String getSpeedIR() {
        return ballModel.getSpeedIR();
    }

    /**
     * Sets the speed of the ball in the opposite direction.
     *
     * @param newSpeedIR The new speed for the ball in the opposite direction.
     */
    public void setSpeedIR(String newSpeedIR) {
        ballModel.setSpeedIR(newSpeedIR);
    }

    /**
     * Gets the bounds of the ball.
     *
     * @return The bounds of the ball.
     */
    public Bounds getBounds() {
        return ballModel.getBounds();
    }

    /**
     * Gets the X-coordinate of the ball.
     *
     * @return The X-coordinate of the ball.
     */
    public double getPosX() {
        return ballModel.getPosX();
    }

    /**
     * Gets the Y-coordinate of the ball.
     *
     * @return The Y-coordinate of the ball.
     */
    public double getPosY() {
        return ballModel.getPosY();
    }

    /**
     * Checks if a key is pressed.
     *
     * @return true if a key is pressed, false otherwise.
     */
    public boolean getKeyPressed() {
        return isKeyPressed;
    }

    /**
     * Sets the status of the key press.
     *
     * @param status The status of the key press.
     */
    public void setKeyPressed(boolean status) {
        isKeyPressed = status;
    }

    /**
     * Resets the ball position and key press status.
     */
    public void reset() {
        this.setKeyPressed(false);
        ballModel.reset();
        ballView.reset();
    }

    /**
     * Moves the ball and updates the BallView position.
     */
    public void move() {
        ballModel.move();
        ballView.setPosX(this.getPosX());
        ballView.setPosY(this.getPosY());
    }

    /**
     * Starts the ball movement thread if it is not already running.
     */
    public void startThread() {
        if (!ballThread.isAlive()) {
            ballThread.start();
        }
    }

    /**
     * The run method executed by the ball movement thread.
     */
    public void run() {
        while (true) {
            try {
                Thread.sleep(10);

                if (MainController.getInstance().getMainState() == MainController.MainState.RUNNING) {
                    if (isKeyPressed) {
                        Platform.runLater(this::move);
                    }
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
