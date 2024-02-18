package src.model.components;

public class RacketModel {
    public double width;
    public double height;

    public RacketModel(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double getWidth() {
        return this.width;
    }

    public double getHeight() {
        return this.height;
    }

    public void updateSize(double newWidth, double newHeight) {
        this.width = newWidth;
        this.height = newHeight;
    }
}
