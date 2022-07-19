package controller;

import model.ShapeConfiguration;
import model.ShapeDrawer;
import model.Point;
import model.ShapeFactory;
import model.interfaces.IShape;
import model.persistence.ApplicationState;
import view.gui.PaintCanvas;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class MouseHandler extends MouseAdapter {
    // FIELDS

    // These points outline the coordinates of selected shape
    private Point firstPoint;
    private Point lastPoint;
    private PaintCanvas paintCanvas;
    private ApplicationState appState;


    // Constructor
    public MouseHandler(PaintCanvas paintCanvas, ApplicationState appState) {
        this.paintCanvas = paintCanvas;
        this.appState = appState;
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

        // Create the Shape and draw it
        ShapeConfiguration shapeConfiguration = new ShapeConfiguration(firstPoint, lastPoint, appState);
        ShapeFactory shapeFactory = new ShapeFactory();
        IShape shape = shapeFactory.getShape(shapeConfiguration);
        ShapeDrawer shapeDrawer = new ShapeDrawer(shape, paintCanvas);
        shapeDrawer.execute();
    }
}
