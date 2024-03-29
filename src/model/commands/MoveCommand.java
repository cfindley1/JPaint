package model.commands;

import model.CommandHistory;
import model.SelectedShapeList;
import model.TransformContext;
import model.TransformMove;
import model.interfaces.ICommand;
import model.interfaces.IShape;
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

    public MoveCommand(int deltaX, int deltaY) {
        this.deltaX = deltaX;
        this.deltaY = deltaY;
        this.paintCanvas = PaintCanvas.getInstance();
    }

    @Override
    public void execute() {
        for (IShape shape : SelectedShapeList.getList()) {
            movedShapes.add(shape);
            move.execute(shape, deltaX, deltaY);
        }
        paintCanvas.repaint();
        CommandHistory.add(this);
    }

    @Override
    public void undo() {
        for (IShape shape : movedShapes)
            move.execute(shape, -deltaX, -deltaY);
        paintCanvas.repaint();
    }

    @Override
    public void redo() {
        for (IShape shape : movedShapes)
            move.execute(shape, deltaX, deltaY);
        paintCanvas.repaint();
    }
}
