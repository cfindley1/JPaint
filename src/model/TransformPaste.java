package model;

import model.interfaces.IShape;
import model.interfaces.IShapeConfiguration;
import model.interfaces.ITransformStrategy;

public class TransformPaste implements ITransformStrategy {

    @Override
    public IShape transform(IShapeConfiguration shape, Point p1, Point p2, int deltaX, int deltaY) {
        // Create offset points for new shape
        Point firstPoint = new Point(p1.getX() + deltaX, p1.getY() + deltaY);
        Point lastPoint = new Point(p2.getX() + deltaX, p2.getY() + deltaY);

        // Create copied Shape
        ShapeConfiguration shape1 = (ShapeConfiguration) shape;
        IShape newShape = shape1.shapeCopy(firstPoint, lastPoint);
        ShapeList.add(newShape);
        return newShape;
    }
}
