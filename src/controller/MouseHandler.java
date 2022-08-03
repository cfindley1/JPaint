package controller;

import model.*;
import model.commands.DrawShapeCommand;
import model.commands.MoveCommand;
import model.commands.SelectCommand;
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

    // Methods
    @Override
    public void mousePressed(MouseEvent e) {
        // Calculate point on mouse press for start point of shape
        firstPoint = new Point(e.getX(), e.getY());
        System.out.println(e.getX() + ", " + e.getY());
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        mouseMode = appState.getActiveMouseMode();
        // Calculate point on release for endpoint of shape after user drags mouse
        lastPoint = new Point(e.getX(), e.getY());
        
        if (mouseMode == MouseMode.DRAW) {
            ShapeConfiguration shapeConfiguration = new ShapeConfiguration(firstPoint, lastPoint, appState);
            ShapeFactory shapeFactory = new ShapeFactory();
            IShape shape = shapeFactory.getShape(shapeConfiguration);
            DrawShapeCommand drawShapeCommand = new DrawShapeCommand(shape, paintCanvas);
            drawShapeCommand.execute();
        }

        if (mouseMode == MouseMode.SELECT) {
            SelectCommand selectCommand = new SelectCommand(firstPoint, lastPoint, paintCanvas);
            selectCommand.execute();
        }

        if (mouseMode == MouseMode.MOVE) {
            int deltaX = lastPoint.getX() - firstPoint.getX();
            int deltaY = lastPoint.getY() - firstPoint.getY();
            MoveCommand moveCommand = new MoveCommand(deltaX, deltaY, paintCanvas);
            moveCommand.execute();
        }
    }
}
