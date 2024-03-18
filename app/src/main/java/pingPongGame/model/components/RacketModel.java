package pingPongGame.model.components;

import javafx.geometry.BoundingBox;
import javafx.geometry.Bounds;
import pingPongGame.model.GameModel;

/**
 * Model representing the properties and state of a racket in the game.
 * 
 * @author Quentin Macheda
 * @version 1.4
 * @since 2024-03-09
 */
public class RacketModel {
    /*
     * Variables representing the position, width, height, and height of the parent
     */
    private double x, y, width, height, parentHeight;

    /*
     * Bounding box representing the bounds of the racket
     */
    private Bounds bounds;

    /**
     * Default constructor to initialize the racket model with default dimensions
     * and position.
     */
    public RacketModel() {
        this.parentHeight = 0;
        this.setPosY(0);

        this.setWidth(Double.parseDouble(GameModel.getInstance().settingsProperties.getProperty("racketWidth")));
        this.setHeight(Double.parseDouble(GameModel.getInstance().settingsProperties.getProperty("racketHeight")));
    }

    /**
     * Resets the racket's position and updates the bounds.
     */
    public void reset() {
        this.setPosY(0);
        this.setBounds(
                new BoundingBox(getPosX() - (getWidth() / 2), getPosY() - (getHeight() / 2), getWidth(), getHeight()));
    }

    /**
     * Gets the height of the parent container.
     *
     * @return The height of the parent container.
     */
    public double getParentHeight() {
        return this.parentHeight;
    }

    /**
     * Sets the height of the parent container.
     *
     * @param newParentHeight The new height of the parent container.
     */
    public void setParentHeight(double newParentHeight) {
        this.parentHeight = newParentHeight;
    }

    /**
     * Gets the width of the racket.
     *
     * @return The width of the racket.
     */
    public double getWidth() {
        return this.width;
    }

    /**
     * Sets the width of the racket.
     *
     * @param newWidth The new width of the racket.
     * @return The updated width of the racket.
     */
    public void setWidth(double newWidth) {
        this.width = newWidth;

        // Save the new data into settings properties
        GameModel.getInstance().settingsProperties.setProperty("racketWidth", Double.toString(newWidth));
        GameModel.getInstance().saveSettings("Set racket width");
    }

    /**
     * Gets the height of the racket.
     *
     * @return The height of the racket.
     */
    public double getHeight() {
        return this.height;
    }

    /**
     * Sets the height of the racket.
     *
     * @param newHeight The new height of the racket.
     * @return The updated height of the racket.
     */
    public void setHeight(double newHeight) {
        this.height = newHeight;

        GameModel.getInstance().settingsProperties.setProperty("racketHeight", Double.toString(newHeight));
        GameModel.getInstance().saveSettings("Set racket height");
    }

    /**
     * Updates the size of the racket with new width and height.
     *
     * @param newWidth  The new width of the racket.
     * @param newHeight The new height of the racket.
     */
    public void updateSize(double newWidth, double newHeight) {
        setWidth(newWidth);
        setHeight(newHeight);
    }

    /**
     * Gets the bounds (bounding box) of the racket.
     *
     * @return The bounds of the racket.
     */
    public Bounds getBounds() {
        return this.bounds;
    }

    /**
     * Sets the bounds of the racket.
     *
     * @param newBounds The new bounds of the racket.
     */
    public void setBounds(Bounds newBounds) {
        this.bounds = newBounds;
    }

    /**
     * Gets the X-coordinate of the racket's position.
     *
     * @return The X-coordinate of the racket's position.
     */
    public double getPosX() {
        return this.x;
    }

    /**
     * Sets the X-coordinate of the racket's position and updates the bounds.
     *
     * @param newX The new X-coordinate of the racket's position.
     */
    public void setPosX(double newX) {
        this.x = newX;

        setBounds(
                new BoundingBox(getPosX() - (getWidth() / 2), getPosY() - (getHeight() / 2), getWidth(), getHeight()));
    }

    /**
     * Gets the Y-coordinate of the racket's position.
     *
     * @return The Y-coordinate of the racket's position.
     */
    public double getPosY() {
        return this.y;
    }

    /**
     * Sets the Y-coordinate of the racket's position.
     *
     * @param newY The new Y-coordinate of the racket's position.
     */
    public void setPosY(double newY) {
        this.y = newY;
    }

    /**
     * Moves the racket upwards while checking for upper boundary.
     */
    public void moveUp() {
        if (getPosY() > -(this.parentHeight / 2 - this.height / 2)) {
            setPosY(getPosY() - 5);
        }

        setBounds(
                new BoundingBox(getPosX() - (getWidth() / 2), getPosY() - (getHeight() / 2), getWidth(), getHeight()));
    }

    /**
     * Moves the racket downwards while checking for lower boundary.
     *
     * @param parentHeight The height of the parent container.
     */
    public void moveDown(double parentHeight) {
        if (getPosY() < (this.parentHeight / 2) - (this.height / 2)) {
            setPosY(getPosY() + 5);
        }

        setBounds(
                new BoundingBox(getPosX() - (getWidth() / 2), getPosY() - (getHeight() / 2), getWidth(), getHeight()));
    }
}
