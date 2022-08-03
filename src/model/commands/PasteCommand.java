package model.commands;

import model.*;
import model.interfaces.ICommand;
import model.interfaces.IShape;
import model.interfaces.IUndoable;
import view.gui.PaintCanvas;

import java.util.ArrayList;
import java.util.List;

public class PasteCommand implements ICommand, IUndoable {
    PaintCanvas paintCanvas;
    List<IShape> copiedShapes = new ArrayList<>();
    TransformContext paste = new TransformContext(new TransformPaste());
    public PasteCommand() {
        this.paintCanvas = PaintCanvas.getInstance();
    }

    public void execute() {
        for (IShape shape : CopyShapeList.copyShapeList) {
            IShape newShape = paste.execute(shape,-30, -30);
            copiedShapes.add(newShape);
        }
        paintCanvas.repaint();
        CommandHistory.add(this);
        CopyShapeList.print();
    }
    public void undo() {
        for (IShape shape : copiedShapes) {
            ShapeList.shapeList.remove(shape);
        }
        paintCanvas.repaint();
    }
    public void redo() {
        for (IShape shape : copiedShapes) {
            ShapeList.shapeList.add(shape);
        }
        paintCanvas.repaint();
    }
}
