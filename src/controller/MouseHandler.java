package controller;

import model.CreateShape;
import model.Point;
import view.gui.PaintCanvas;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class MouseHandler extends MouseAdapter {
    // FIELDS

    // These points outline the coordinates of selected shape
    public Point firstPoint;
    public Point lastPoint;
    private Graphics2D graphics2D;
    private PaintCanvas paintCanvas;


    // Constructor
    public MouseHandler(Graphics2D graphics2D, PaintCanvas paintCanvas) {
        this.graphics2D = graphics2D;
        this.paintCanvas = paintCanvas;
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

        // Create the Shape
        CreateShape shape = new CreateShape(firstPoint, lastPoint, paintCanvas);
        shape.execute();
    }
}
