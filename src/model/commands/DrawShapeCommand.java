package model.commands;

import model.CommandHistory;
import model.ShapeList;
import model.interfaces.ICommand;
import model.interfaces.IShape;
import model.interfaces.IUndoable;
import view.gui.PaintCanvas;

public class DrawShapeCommand implements IUndoable, ICommand {

    private PaintCanvas paintCanvas;
    // Fields
    public IShape shape; // Reference to created shape

    // Constructor
    public DrawShapeCommand(IShape shape, PaintCanvas paintCanvas) {
        this.shape = shape;
        this.paintCanvas = paintCanvas;
    }

    // Methods
    @Override
    public void execute() {
        ShapeList.add(shape);
        paintCanvas.repaint();
        CommandHistory.add(this);
    }

    @Override
    public void undo() {
        ShapeList.remove();
        paintCanvas.repaint();
    }

    @Override
    public void redo() {
        ShapeList.add(this.shape);
        paintCanvas.repaint();
    }
}