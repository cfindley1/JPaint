package model.commands;

import model.*;
import model.interfaces.ICommand;
import model.interfaces.IShape;
import model.interfaces.ITransformStrategy;
import model.interfaces.IUndoable;
import view.gui.PaintCanvas;

import java.util.ArrayList;
import java.util.List;

public class MoveCommand implements IUndoable, ICommand {
    int deltaX;
    int deltaY;
    List<IShape> movedShapes = new ArrayList<>();
    PaintCanvas paintCanvas;
    TransformContext move = new TransformContext(new TransformMove());

    public MoveCommand(int deltaX, int deltaY, PaintCanvas paintCanvas) {
        this.deltaX = deltaX;
        this.deltaY = deltaY;
        this.paintCanvas = paintCanvas;
    }

    public void execute() {
        for (IShape shape : SelectedShapeList.selectedShapeList) {
            this.movedShapes.add(shape);
            ShapeConfiguration shapeConfig = shape.getShapeConfig();
            System.out.println(shapeConfig.shapeType); //Debug
            System.out.println("deltaX: " + deltaX + " deltaY: " + deltaY);
            Point firstPoint = shapeConfig.getFirstPoint();
            Point lastPoint = shapeConfig.getLastPoint();
            System.out.println("Before move: (" + firstPoint.getX() + ", " + firstPoint.getY() + ")" + "  ("
                    + lastPoint.getX() + ", " + lastPoint.getY() + ")"
            );
            move.execute(firstPoint, lastPoint, deltaX, deltaY);
            System.out.println("After move: (" + firstPoint.getX() + ", " + firstPoint.getY() + ")" + "  ("
                    + lastPoint.getX() + ", " + lastPoint.getY() + ")"
            );
        }
        paintCanvas.repaint();
        CommandHistory.add(this);
    }

    @Override
    public void undo() {
        for (IShape shape : movedShapes) {
            ShapeConfiguration shapeConfig = shape.getShapeConfig();
            Point firstPoint = shapeConfig.getFirstPoint();
            Point lastPoint = shapeConfig.getLastPoint();
            move.execute(firstPoint, lastPoint, -deltaX, -deltaY);
        }
        paintCanvas.repaint();
    }

    @Override
    public void redo() {
        for (IShape shape : movedShapes) {
            ShapeConfiguration shapeConfig = shape.getShapeConfig();
            Point firstPoint = shapeConfig.getFirstPoint();
            Point lastPoint = shapeConfig.getLastPoint();
            move.execute(firstPoint, lastPoint, deltaX, deltaY);
        }
        paintCanvas.repaint();
    }
}
