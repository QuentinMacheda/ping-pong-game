package src.model;

public class BallModel {
    private int x;
    private int y;
    private int speed;

    public BallModel(int x, int y, int speed) {
        this.x = x;
        this.y = y;
        this.speed = speed;
    }

    public int getX() {
        return this.x;
    }

    public void setX(int x) {
        if (x >= 0) {
            this.x = x;
        }
    }

    public int getY() {
        return this.y;
    }

    public void setY(int y) {
        if (y >= 0) {
            this.y = y;
        }
    }

    public int getSpeed() {
        return this.speed;
    }

    public void setSpeed(int speed) {
        if (speed >= 0) {
            this.speed = speed;
        }
    }
}
