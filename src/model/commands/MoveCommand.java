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
            Point firstPoint = shapeConfig.getFirstPoint();
            Point lastPoint = shapeConfig.getLastPoint();
            move.execute(firstPoint, lastPoint, deltaX, deltaY);
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
