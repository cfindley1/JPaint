package model;

import java.awt.*;
import java.sql.SQLOutput;

import view.gui.PaintCanvas;

public class Rectangle {
    public Point firstPoint;
    public Point lastPoint;
    public int width;
    public int height;

    public Rectangle (Point firstPoint, Point lastPoint) {
        this.firstPoint = firstPoint;
        this.lastPoint = lastPoint;
        this.width = lastPoint.getX() - firstPoint.getX();
        this.height = lastPoint.getY() - firstPoint.getY();
    }
    // Draw Filled in Rectangle
    public static void drawShape(Graphics2D graphics2D, Point firstPoint, Point lastPoint) {
        Rectangle rectangle = new Rectangle(firstPoint, lastPoint);
        graphics2D.setColor(Color.pink);
        graphics2D.fillRect(firstPoint.getX(), firstPoint.getY(), rectangle.width, rectangle.height);
        System.out.println(rectangle.width);
        System.out.println(rectangle.height);
    }

}
