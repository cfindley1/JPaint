package model.commands;

import model.Point;
import model.SelectedShapeList;
import model.ShapeGroupConfiguration;
import model.ShapeList;
import model.interfaces.ICommand;
import model.interfaces.IShape;
import model.shapes.Shape;
import model.shapes.ShapeGroup;
import view.gui.PaintCanvas;

import java.util.List;

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
            if (collision) {
                // Check whether its group shape or not
                if (shape.getSize() > 1) {
                    ShapeGroup shapeGroup = (ShapeGroup) shape;
                    List<IShape> children = shapeGroup.getShapeConfig().getList();
                    for (IShape s : children) {
                        SelectedShapeList.add(s);
                    }
                }
                SelectedShapeList.add(shape);
            }
            else SelectedShapeList.remove(shape);
        }
        PaintCanvas.getInstance().repaint();
    }
}
