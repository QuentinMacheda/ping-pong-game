package src.model.components;

public class RacketModel {
    private double width;
    private double height;

    public RacketModel() {
        this.width = 20;
        this.height = 120;
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
}
