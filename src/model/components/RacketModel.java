package src.model.components;

import javafx.geometry.BoundingBox;
import javafx.geometry.Bounds;

public class RacketModel {
    private double width;
    private double height;
    private double parentHeight;
    private double x, y;
    private Bounds bounds;

    public RacketModel() {
        this.width = 20;
        this.height = 120;
        this.parentHeight = 0;
        this.y = 0;
    }

    public double getParentHeight() {
        return this.parentHeight;
    }

    public void setParentHeight(double newParentHeight) {
        this.parentHeight = newParentHeight;
    }

    public double getParentWidth() {
        return this.width;
    }

    public void setParentWidth(double newParentWidth) {
        this.width = newParentWidth;
    }

    public double getWidth() {
        return this.width;
    }

    public double setWidth(double newWidth) {
        return this.width = newWidth;
    }

    public double getHeight() {
        return this.height;
    }

    public double setHeight(double newHeight) {
        return this.height = newHeight;
    }

    public void updateSize(double newWidth, double newHeight) {
        setWidth(newWidth);
        setHeight(newHeight);
    }

    public Bounds getBounds() {
        return this.bounds;
    }

    public void setBounds(Bounds newBounds) {
        this.bounds = newBounds;
    }

    public double getPosX() {
        return this.x;
    }

    public void setPosX(double newX) {
        this.x = newX;

        setBounds(
                new BoundingBox(getPosX() - (getWidth() / 2), getPosY() - (getHeight() / 2), getWidth(), getHeight()));
    }

    public double getPosY() {
        return this.y;
    }

    public void setPosY(double newY) {
        this.y = newY;
    }

    public void reset() {
        setPosY(0);
        setBounds(
                new BoundingBox(getPosX() - (getWidth() / 2), getPosY() - (getHeight() / 2), getWidth(), getHeight()));
    }

    public void moveUp() {
        if (getPosY() > -(this.parentHeight / 2 - this.height / 2)) {
            setPosY(getPosY() - 5);
        }

        setBounds(
                new BoundingBox(getPosX() - (getWidth() / 2), getPosY() - (getHeight() / 2), getWidth(), getHeight()));
    }

    public void moveDown(double parentHeight) {
        if (getPosY() < (this.parentHeight / 2) - (this.height / 2)) {
            setPosY(getPosY() + 5);
        }

        setBounds(
                new BoundingBox(getPosX() - (getWidth() / 2), getPosY() - (getHeight() / 2), getWidth(), getHeight()));
    }
}
