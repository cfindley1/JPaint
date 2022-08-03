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

    public DeleteCommand(PaintCanvas paintCanvas) {
        this.paintCanvas = paintCanvas;
    }

    @Override
    public void execute() {
        for (int i = 0; i < SelectedShapeList.selectedShapeList.size(); i++) {
            IShape shape = SelectedShapeList.selectedShapeList.get(i);
            deletedShapes.add(shape);
            ShapeList.shapeList.remove(shape);
            SelectedShapeList.selectedShapeList.remove(shape);
        }
        paintCanvas.repaint();
        CommandHistory.add(this);
    }

    @Override
    public void undo() {
        for (int i = 0; i < deletedShapes.size(); i++) {
            IShape shape = deletedShapes.get(i);
            ShapeList.shapeList.add(shape);
        }
        paintCanvas.repaint();
    }

    @Override
    public void redo() {
        for (int i = 0; i < deletedShapes.size(); i++) {
            IShape shape = deletedShapes.get(i);
            ShapeList.shapeList.remove(shape);
        }
        paintCanvas.repaint();
    }
}
