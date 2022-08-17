package model.commands;

import model.CommandHistory;
import model.SelectedShapeList;
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
    public DrawShapeCommand(IShape shape) {
        this.shape = shape;
        this.paintCanvas = PaintCanvas.getInstance();
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
        ShapeList.remove(shape);
        SelectedShapeList.remove(shape);
        paintCanvas.repaint();
    }

    @Override
    public void redo() {
        ShapeList.add(shape);
        paintCanvas.repaint();
    }
}
