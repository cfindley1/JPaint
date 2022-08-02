package model.commands;

import model.*;
import model.interfaces.ICommand;
import model.interfaces.IShape;
import model.interfaces.IUndoable;
import view.gui.PaintCanvas;

public class PasteCommand implements ICommand, IUndoable {
    PaintCanvas paintCanvas;
    public PasteCommand(PaintCanvas paintCanvas) {
        this.paintCanvas = paintCanvas;
    }

    public void execute() {
        // Strategy pattern for this and move?
        for (IShape shape : CopyShapeList.copyShapeList) {
            ShapeConfiguration shapeConfig = shape.getShapeConfig();
            Point firstPointOld = shapeConfig.getFirstPoint();
            Point lastPointOld = shapeConfig.getLastPoint();

            // Offset -- Need to optimize / edit down verbosity
            Point firstPointNew = new Point(firstPointOld.x -= 30, firstPointOld.y -= 30);
            Point lastPointNew = new Point(lastPointOld.x -= 30, lastPointOld.y -= 30);
            ShapeConfiguration s = new ShapeConfiguration(firstPointNew, lastPointNew, shapeConfig.appState);
            // Duplicate Shape
            ShapeFactory shapeFactory = new ShapeFactory();
            IShape newShape = shapeFactory.getShape(s);
            ShapeList.add(newShape);
        }
        for (IShape ishape : ShapeList.shapeList) {
            System.out.println("shape list shape " + ishape.getShapeConfig().x);
        }
        paintCanvas.repaint();
        CommandHistory.add(this);
    }
    public void undo() {

    }
    public void redo() {}
}
