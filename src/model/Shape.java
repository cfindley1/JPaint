package model;

public class Shape {
    // Fields
    public final Point firstPoint;
    private final Point lastPoint;
    public final int width;
    public final int height;

    // Constructor
    public Shape(Point firstPoint, Point lastPoint) {
        this.firstPoint = firstPoint;
        this.lastPoint = lastPoint;
        this.width = lastPoint.getX() - firstPoint.getX();
        this.height = lastPoint.getY() - firstPoint.getY();
    }
}
