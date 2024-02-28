package src.model.components;

public class RacketModel {
    private double width;
    private double height;
    private double parentHeight;
    private double y;

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

    public double getPosY() {
        return this.y;
    }

    public void setPosY(double newY) {
        this.y = newY;
    }

    public void moveUp() {
        if (getPosY() > -(this.parentHeight / 2 - this.height / 2)) {
            setPosY(getPosY() - 5);
        }
    }

    public void moveDown(double parentHeight) {
        if (getPosY() < (this.parentHeight / 2) - (this.height / 2)) {
            setPosY(getPosY() + 5);
        }
    }
}
