package model.commands;

import model.Point;
import model.SelectedShapeList;
import model.Shape;
import model.ShapeList;
import model.interfaces.ICommand;
import model.interfaces.IShape;
import view.gui.PaintCanvas;

public class SelectCommand implements ICommand {
    private Point firstPoint;
    private Point lastPoint;
    private PaintCanvas paintCanvas;

    public SelectCommand(Point firstPoint, Point lastPoint, PaintCanvas paintCanvas) {
        this.firstPoint = firstPoint;
        this.lastPoint = lastPoint;
        this.paintCanvas = paintCanvas;
    }

    @Override
    public void execute() {
        for (IShape shape : ShapeList.shapeList) {
            boolean collision = ShapeList.collides(firstPoint, lastPoint, (Shape) shape);
            if (collision)
                SelectedShapeList.add(shape, paintCanvas);
            else SelectedShapeList.remove(shape, paintCanvas);
        }
    }
}
