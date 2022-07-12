package controller;

import model.Point;
import model.Rectangle;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;



public class MouseHandler extends MouseAdapter {
    // FIELDS

    // These points outline the coordinates of selected shape
    public Point firstPoint;
    public Point lastPoint;
    private Graphics2D graphics2D;

    // Constructor
    public MouseHandler(Graphics2D graphics2D) {
        this.graphics2D = graphics2D;
    }

    // Method Extensions
    @Override
    public void mousePressed(MouseEvent e) {
        // Calculate point on mouse press for start point of shape
        firstPoint = new Point(e.getX(), e.getY());
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // Calculate point on release for endpoint of shape after user drags mouse
        lastPoint = new Point(e.getX(), e.getY());

        // Draw the shape
        Rectangle.drawShape(graphics2D, firstPoint, lastPoint);
    }
}
