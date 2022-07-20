package controller;

import model.*;
import model.interfaces.IShape;
import model.persistence.ApplicationState;
import view.gui.PaintCanvas;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class MouseHandler extends MouseAdapter {
    // FIELDS

    // These points outline the coordinates of selected shape
    private Point firstPoint;
    private Point lastPoint;
    private PaintCanvas paintCanvas;
    private ApplicationState appState;
    private MouseMode mouseMode;


    // Constructor
    public MouseHandler(PaintCanvas paintCanvas, ApplicationState appState) {
        this.paintCanvas = paintCanvas;
        this.appState = appState;
        this.mouseMode = appState.getActiveMouseMode();
    }

    // Method Extensions
    @Override
    public void mousePressed(MouseEvent e) {
        // Calculate point on mouse press for start point of shape
        firstPoint = new Point(e.getX(), e.getY());
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        mouseMode = appState.getActiveMouseMode();
        // Calculate point on release for endpoint of shape after user drags mouse
        lastPoint = new Point(e.getX(), e.getY());

        // Create the Shape and draw it
        if (mouseMode == MouseMode.DRAW) {
            ShapeConfiguration shapeConfiguration = new ShapeConfiguration(firstPoint, lastPoint, appState);
            ShapeFactory shapeFactory = new ShapeFactory();
            IShape shape = shapeFactory.getShape(shapeConfiguration);
            ShapeDrawer shapeDrawer = new ShapeDrawer(shape, paintCanvas);
            shapeDrawer.execute();
        }

        if (mouseMode == MouseMode.SELECT) {
            SelectCommand selectCommand = new SelectCommand(firstPoint, lastPoint, paintCanvas);
            selectCommand.execute();
            
            // For Debugging
            for (IShape shape : SelectedShapeList.selectedShapeList) {
                System.out.println(shape);
            }
            System.out.println("Done");
        }

        if (mouseMode == MouseMode.MOVE) {
            int deltaX = lastPoint.getX() - firstPoint.getX();
            int deltaY = lastPoint.getY() - firstPoint.getY();
            MoveCommand moveCommand = new MoveCommand(deltaX, deltaY, paintCanvas);
            moveCommand.execute();
        }
    }
}
