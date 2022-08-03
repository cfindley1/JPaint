package model;

public class Point {

    // Fields
    private int x;
    private int y;

    // Constructor
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // Getters
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void transformX(int deltaX) {
        this.x += deltaX;
    }

    public void transformY(int deltaY) {
        this.y += deltaY;
    }

    public void transformXAndY(int deltaX, int deltaY) {
        this.x += deltaX;
        this.y += deltaY;
    }

}
