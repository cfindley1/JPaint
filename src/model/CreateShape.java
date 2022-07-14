package model;

import model.interfaces.ICommand;
import model.interfaces.IUndoable;
import view.gui.PaintCanvas;

// Fields
public class CreateShape implements IUndoable, ICommand {
    public Point firstPoint;
    public Point lastPoint;
    public int width;
    public int height;
    public Shape shape;
    private PaintCanvas paintCanvas;

    // Constructor
    public CreateShape(Point firstPoint, Point lastPoint, PaintCanvas paintCanvas) {
        this.firstPoint = firstPoint;
        this.lastPoint = lastPoint;
        this.width = lastPoint.getX() - firstPoint.getX();
        this.height = lastPoint.getY() - firstPoint.getY();
        this.shape = new Shape(firstPoint, lastPoint);
        this.paintCanvas = paintCanvas;
    }

    // Methods
    @Override
    public void execute() {
        ShapeList.add(shape, paintCanvas);
        paintCanvas.repaint();
        CommandHistory.add(this);
    }

    @Override
    public void undo() {
        ShapeList.remove(this.shape, paintCanvas);
        paintCanvas.repaint();
    }

    @Override
    public void redo() {
        ShapeList.add(this.shape, paintCanvas);
        paintCanvas.repaint();
    }
}
