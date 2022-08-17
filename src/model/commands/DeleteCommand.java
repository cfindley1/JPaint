package model.commands;

import model.CommandHistory;
import model.SelectedShapeList;
import model.ShapeList;
import model.interfaces.ICommand;
import model.interfaces.IShape;
import model.interfaces.IUndoable;
import view.gui.PaintCanvas;

import java.util.ArrayList;
import java.util.List;

public class DeleteCommand implements ICommand, IUndoable {

    List<IShape> deletedShapes = new ArrayList<>();
    PaintCanvas paintCanvas;

    public DeleteCommand() {
        this.paintCanvas = PaintCanvas.getInstance();
    }

    @Override
    public void execute() {
        for (IShape shape : SelectedShapeList.getList()) {
            deletedShapes.add(shape);
            ShapeList.remove(shape);
        }
        for (IShape shape : deletedShapes)
            SelectedShapeList.remove(shape);

        paintCanvas.repaint();
        CommandHistory.add(this);
    }

    @Override
    public void undo() {
        for (IShape shape : deletedShapes)
            ShapeList.shapeList.add(shape);

        paintCanvas.repaint();
    }

    @Override
    public void redo() {
        for (IShape shape : deletedShapes)
            ShapeList.shapeList.remove(shape);
        paintCanvas.repaint();
    }
}
