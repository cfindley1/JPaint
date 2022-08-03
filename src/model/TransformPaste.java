package model;

import model.interfaces.IShape;
import model.interfaces.ITransformStrategy;
import model.persistence.ApplicationState;

public class TransformPaste implements ITransformStrategy {

    @Override
    public IShape transform(ShapeConfiguration shape, Point p1, Point p2, int deltaX, int deltaY) {
        // Create offset points for new shape
        Point firstPoint = new Point (p1.getX() + deltaX, p1.getY() + deltaY);
        Point lastPoint = new Point (p2.getX() + deltaX, p2.getY() + deltaY);

        // Create copied Shape
        ShapeConfiguration s = new ShapeConfiguration(firstPoint, lastPoint, shape.appState);
        ShapeFactory shapeFactory = new ShapeFactory();
        IShape newShape = shapeFactory.getShape(s);
        ShapeList.add(newShape);
        return newShape;
    }
}
