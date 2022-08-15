package model.commands;

import model.Point;
import model.SelectedShapeList;
import model.ShapeList;
import model.interfaces.ICommand;
import model.interfaces.IShape;
import model.shapes.Shape;
import view.gui.PaintCanvas;

public class SelectCommand implements ICommand {
    private Point firstPoint;
    private Point lastPoint;
    private PaintCanvas paintCanvas;

    public SelectCommand(Point firstPoint, Point lastPoint) {
        this.firstPoint = firstPoint;
        this.lastPoint = lastPoint;
        this.paintCanvas = PaintCanvas.getInstance();
    }

    @Override
    public void execute() {
        for (IShape shape : ShapeList.shapeList) {
            boolean collision = ShapeList.collides(firstPoint, lastPoint, shape);
            if (collision)
                SelectedShapeList.add(shape, paintCanvas);
            else SelectedShapeList.remove(shape, paintCanvas);
        }
    }
}
